/*
 * Copyright (C) ExBin Project
 *
 * This application or library is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * This application or library is distributed in the hope that it will be
 * useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along this application.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.xbup.lib.core.parser.token.event;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.xbup.lib.core.parser.XBParseException;
import org.xbup.lib.core.parser.XBParserMode;
import org.xbup.lib.core.parser.XBProcessingException;
import org.xbup.lib.core.parser.XBProcessingExceptionType;
import org.xbup.lib.core.parser.basic.wrapper.ExtendedAreaInputStreamWrapper;
import org.xbup.lib.core.parser.basic.wrapper.FixedDataInputStreamWrapper;
import org.xbup.lib.core.stream.FinishableStream;
import org.xbup.lib.core.parser.basic.wrapper.TerminatedDataInputStreamWrapper;
import org.xbup.lib.core.parser.token.XBAttributeToken;
import org.xbup.lib.core.parser.token.XBBeginToken;
import org.xbup.lib.core.block.XBBlockTerminationMode;
import org.xbup.lib.core.parser.basic.XBHead;
import org.xbup.lib.core.parser.token.XBDataToken;
import org.xbup.lib.core.parser.token.XBEndToken;
import org.xbup.lib.core.ubnumber.type.UBENat32;
import org.xbup.lib.core.ubnumber.type.UBNat32;

/**
 * Basic XBUP level 0 event reader - producer.
 *
 * @version 0.1.25 2015/07/23
 * @author ExBin Project (http://exbin.org)
 */
public class XBEventReader implements XBEventProducer {

    private XBParserMode parserMode = XBParserMode.FULL;
    private InputStream source;
    private XBEventListener listener;

    public XBEventReader() {
    }

    public XBEventReader(InputStream inputStream) throws IOException {
        this();
        openStream(inputStream);
    }

    public XBEventReader(InputStream inputStream, XBParserMode parserMode) throws IOException {
        this();
        this.parserMode = parserMode;
        openStream(inputStream);
    }

    private void openStream(InputStream stream) throws IOException {
        source = stream;
    }

    /**
     * Opens input byte-stream.
     *
     * @param stream input stream
     * @throws IOException
     */
    public void open(InputStream stream) throws IOException {
        openStream(stream);
    }

    /**
     * Processes all events and send them to target.
     *
     * @throws XBProcessingException
     * @throws IOException
     */
    public void read() throws XBProcessingException, IOException {
        // Process header
        if (parserMode != XBParserMode.SINGLE_BLOCK && parserMode != XBParserMode.SKIP_HEAD) {
            XBHead.checkXBUPHead(source);
        }

        // Process single node
        readNode();
    }

    /**
     * Reads single node and all its child nodes.
     *
     * If parent node is in terminated mode, this might just close parent node.
     */
    private void readNode() throws XBProcessingException, IOException {
        // Size limits provides list of limits in tree structure
        // with null value for terminated data parts
        List<Integer> sizeLimits = new ArrayList<>();

        // Process blocks until whole tree is processed
        do {
            UBNat32 attributePartSize = new UBNat32();
            int attributePartSizeLength = attributePartSize.fromStreamUB(source);
            shrinkStatus(sizeLimits, attributePartSizeLength);
            if (attributePartSize.getLong() == 0) {
                // Process terminator
                if (sizeLimits.isEmpty() || sizeLimits.get(sizeLimits.size() - 1) != null) {
                    throw new XBParseException("Unexpected terminator", XBProcessingExceptionType.UNEXPECTED_TERMINATOR);
                }

                sizeLimits.remove(sizeLimits.size() - 1);

                if (sizeLimits.isEmpty()) {
                    // Process extended area
                    if (parserMode != XBParserMode.SINGLE_BLOCK && parserMode != XBParserMode.SKIP_EXTENDED && source.available() > 0) {
                        listener.putXBToken(new XBDataToken(new ExtendedAreaInputStreamWrapper(source)));
                    }
                }

                listener.putXBToken(new XBEndToken());
            } else {
                // Process regular block
                int attributePartSizeValue = attributePartSize.getInt();
                shrinkStatus(sizeLimits, attributePartSizeValue);

                UBENat32 dataPartSize = new UBENat32();
                int dataPartSizeLength = dataPartSize.fromStreamUB(source);
                Integer dataPartSizeValue = dataPartSize.isInfinity() ? null : dataPartSize.getInt();

                listener.putXBToken(new XBBeginToken(dataPartSizeValue == null ? XBBlockTerminationMode.TERMINATED_BY_ZERO : XBBlockTerminationMode.SIZE_SPECIFIED));

                if (attributePartSizeValue == dataPartSizeLength) {
                    // Process data block
                    FinishableStream dataWrapper = (dataPartSizeValue == null)
                            ? new TerminatedDataInputStreamWrapper(source)
                            : new FixedDataInputStreamWrapper(source, dataPartSizeValue);
                    listener.putXBToken(new XBDataToken((InputStream) dataWrapper));
                    dataWrapper.finish();
                    shrinkStatus(sizeLimits, (int) dataWrapper.getLength());

                    if (sizeLimits.isEmpty()) {
                        // Process extended area
                        if (parserMode != XBParserMode.SINGLE_BLOCK && parserMode != XBParserMode.SKIP_EXTENDED && source.available() > 0) {
                            listener.putXBToken(new XBDataToken(new ExtendedAreaInputStreamWrapper(source)));
                        }
                    }

                    listener.putXBToken(new XBEndToken());
                } else {
                    // Process standard block
                    sizeLimits.add(dataPartSizeValue);

                    // Process attributes
                    attributePartSizeValue -= dataPartSizeLength;
                    while (attributePartSizeValue > 0) {
                        UBNat32 attribute = new UBNat32();
                        int attributeLength = attribute.fromStreamUB(source);
                        if (attributeLength > attributePartSizeValue) {
                            throw new XBParseException("Attribute overflow", XBProcessingExceptionType.ATTRIBUTE_OVERFLOW);
                        }

                        attributePartSizeValue -= attributeLength;
                        listener.putXBToken(new XBAttributeToken(attribute));
                    }
                }
            }

            // Enclose all completed blocks
            while (sizeLimits.size() > 0 && sizeLimits.get(sizeLimits.size() - 1) != null && sizeLimits.get(sizeLimits.size() - 1) == 0) {
                sizeLimits.remove(sizeLimits.size() - 1);

                if (sizeLimits.isEmpty()) {
                    // Process extended area
                    if (parserMode != XBParserMode.SINGLE_BLOCK && parserMode != XBParserMode.SKIP_EXTENDED && source.available() > 0) {
                        ExtendedAreaInputStreamWrapper dataWrapper = new ExtendedAreaInputStreamWrapper(source);
                        listener.putXBToken(new XBDataToken(dataWrapper));
                    }
                }

                listener.putXBToken(new XBEndToken());
            }
        } while (!sizeLimits.isEmpty());
    }

    /**
     * Closes input stream.
     *
     * @throws IOException
     */
    public void close() throws IOException {
        source.close();
    }

    /**
     * Shrinks limits accross all depths.
     *
     * @param length Value to shrink all limits off
     * @throws XBParseException If limits are breached
     */
    private static void shrinkStatus(List<Integer> sizeLimits, int length) throws XBParseException {
        for (int depthLevel = 0; depthLevel < sizeLimits.size(); depthLevel++) {
            Integer limit = sizeLimits.get(depthLevel);
            if (limit != null) {
                if (limit < length) {
                    throw new XBParseException("Block overflow", XBProcessingExceptionType.BLOCK_OVERFLOW);
                }

                sizeLimits.set(depthLevel, limit - length);
            }
        }
    }

    @Override
    public void attachXBEventListener(XBEventListener eventListener) {
        this.listener = eventListener;
    }

    @Override
    public String toString() {
        String retValue;
        retValue = super.toString();
        return retValue;
    }
}
