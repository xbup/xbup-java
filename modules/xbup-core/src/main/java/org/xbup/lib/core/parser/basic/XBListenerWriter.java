/*
 * Copyright (C) XBUP Project
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
package org.xbup.lib.core.parser.basic;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.xbup.lib.core.block.XBBlockDataMode;
import org.xbup.lib.core.parser.XBParseException;
import org.xbup.lib.core.parser.XBParserMode;
import org.xbup.lib.core.parser.XBParserState;
import org.xbup.lib.core.parser.XBProcessingException;
import org.xbup.lib.core.parser.XBProcessingExceptionType;
import org.xbup.lib.core.parser.basic.wrapper.FixedDataOutputStreamWrapper;
import org.xbup.lib.core.parser.basic.wrapper.TerminatedDataOutputStreamWrapper;
import org.xbup.lib.core.parser.token.convert.XBTokenBuffer;
import org.xbup.lib.core.parser.token.XBAttributeToken;
import org.xbup.lib.core.parser.token.XBBeginToken;
import org.xbup.lib.core.block.XBBlockTerminationMode;
import org.xbup.lib.core.parser.basic.wrapper.FinishableStream;
import org.xbup.lib.core.parser.token.XBAttribute;
import org.xbup.lib.core.parser.token.XBDataToken;
import org.xbup.lib.core.parser.token.XBEndToken;
import org.xbup.lib.core.ubnumber.type.UBENat32;
import org.xbup.lib.core.ubnumber.type.UBNat32;
import org.xbup.lib.core.util.CopyStreamUtils;

/**
 * XBUP level 0 listener writer.
 *
 * @version 0.1.24 2014/10/04
 * @author XBUP Project (http://xbup.org)
 */
public class XBListenerWriter implements Closeable, XBListener {

    private XBParserMode parserMode = XBParserMode.FULL;
    private OutputStream stream;

    private XBParserState parserState = XBParserState.START;
    private final XBTokenBuffer tokenWriter = new XBTokenBuffer();
    private final List<Integer> sizeLimits = new ArrayList<>();
    private XBDataToken extendedArea = null;
    private int bufferedFromLevel = -1;
    private int depthLevel = 0;

    private XBBlockTerminationMode terminationMode;
    private XBBlockDataMode dataMode;
    private final List<XBAttribute> attributeList = new ArrayList<>();
    private int attributePartSizeValue = 0;

    public XBListenerWriter() {
    }

    public XBListenerWriter(OutputStream outputStream) throws IOException {
        this();
        openStream(outputStream);
    }

    public XBListenerWriter(OutputStream outputStream, XBParserMode parserMode) throws IOException {
        this();
        this.parserMode = parserMode;
        openStream(outputStream);
    }

    private void openStream(OutputStream outputStream) throws IOException {
        stream = outputStream;
    }

    /**
     * Opens output byte-stream.
     *
     * @param outputStream output stream
     * @throws IOException if input/output error
     */
    public void open(OutputStream outputStream) throws IOException {
        openStream(outputStream);
    }

    @Override
    public void close() throws IOException {
        stream.close();
    }

    public void closeXB() throws XBProcessingException, IOException {
        if (parserState != XBParserState.EOF && parserState != XBParserState.EXTENDED_AREA) {
            throw new XBParseException("Unexpected end of stream", XBProcessingExceptionType.UNEXPECTED_END_OF_STREAM);
        }

        close();
    }

    @Override
    public void beginXB(XBBlockTerminationMode terminationMode) throws XBProcessingException, IOException {
        if (parserState == XBParserState.START) {
            // Write file head
            if (parserMode != XBParserMode.SINGLE_BLOCK && parserMode != XBParserMode.SKIP_HEAD) {
                XBHead.writeXBUPHead(stream);
            }

            parserState = XBParserState.BLOCK_BEGIN;
        }

        if (parserState == XBParserState.ATTRIBUTE_PART) {
            flushAttributes();
            parserState = XBParserState.BLOCK_BEGIN;
        }

        if (parserState == XBParserState.BLOCK_BEGIN) {
            depthLevel++;
            this.terminationMode = terminationMode;
            dataMode = null;
            if (bufferedFromLevel >= 0) {
                tokenWriter.putXBToken(new XBBeginToken(terminationMode));
                sizeLimits.add(null);
            } else {
                if (terminationMode == XBBlockTerminationMode.SIZE_SPECIFIED) {
                    bufferedFromLevel = depthLevel;
                    tokenWriter.putXBToken(new XBBeginToken(terminationMode));
                    sizeLimits.add(null);
                } else {
                    sizeLimits.add(null);
                }
            }

            attributeList.clear();
            parserState = XBParserState.ATTRIBUTE_PART;
        } else {
            throw new XBParseException("Unexpected begin of block", XBProcessingExceptionType.UNEXPECTED_ORDER);
        }
    }

    @Override
    public void attribXB(XBAttribute attribute) throws XBProcessingException, IOException {
        if (parserState == XBParserState.ATTRIBUTE_PART) {
            dataMode = XBBlockDataMode.NODE_BLOCK;
            if (bufferedFromLevel >= 0) {
                tokenWriter.putXBToken(new XBAttributeToken(attribute));
            } else {
                int attributeSize = attribute.getSizeUB();
                shrinkStatus(sizeLimits, attributeSize);
                attributePartSizeValue += attributeSize;
                attributeList.add(attribute);
            }
        } else {
            throw new XBParseException("Unexpected attribute", XBProcessingExceptionType.UNEXPECTED_ORDER);
        }
    }

    @Override
    public void dataXB(InputStream data) throws XBProcessingException, IOException {
        if (parserState == XBParserState.ATTRIBUTE_PART) {
            if (depthLevel == 1 && dataMode == XBBlockDataMode.NODE_BLOCK) {
                extendedArea = new XBDataToken(data);
                parserState = XBParserState.EXTENDED_AREA;
            } else {
                dataMode = XBBlockDataMode.DATA_BLOCK;

                if (dataMode == XBBlockDataMode.NODE_BLOCK) {
                    throw new XBParseException("Unexpected data token after attribute", XBProcessingExceptionType.UNEXPECTED_ORDER);
                }

                if (bufferedFromLevel >= 0) {
                    tokenWriter.putXBToken(new XBDataToken(data));
                } else {
                    OutputStream streamWrapper;
                    if (terminationMode == XBBlockTerminationMode.SIZE_SPECIFIED) {
                        // TODO determine size
                        streamWrapper = new FixedDataOutputStreamWrapper(stream, 0);
                    } else {
                        UBNat32 attributePartSize = new UBNat32(UBENat32.INFINITY_SIZE_UB);
                        attributePartSize.toStreamUB(stream);
                        UBENat32 dataPartSize = new UBENat32();
                        dataPartSize.setInfinity();
                        dataPartSize.toStreamUB(stream);
                        shrinkStatus(sizeLimits, UBENat32.INFINITY_SIZE_UB + 1);
                        streamWrapper = new TerminatedDataOutputStreamWrapper(stream);
                    }

                    CopyStreamUtils.copyInputStreamToOutputStream(data, streamWrapper);

                    int dataPartSize = (int) ((FinishableStream) streamWrapper).finish();
                    shrinkStatus(sizeLimits, dataPartSize);
                }

                parserState = XBParserState.BLOCK_END;
            }
        } else if (parserState == XBParserState.BLOCK_BEGIN) {
            if (depthLevel == 1) {
                extendedArea = new XBDataToken(data);
                parserState = XBParserState.EXTENDED_AREA;
            } else {
                throw new XBParseException("Unexpected data token", XBProcessingExceptionType.UNEXPECTED_ORDER);
            }

            parserState = XBParserState.EOF;
        } else if (parserState == XBParserState.BLOCK_END) {
            if (depthLevel == 1 && dataMode == XBBlockDataMode.DATA_BLOCK) {
                extendedArea = new XBDataToken(data);
                parserState = XBParserState.EXTENDED_AREA;
            } else {
                throw new XBParseException("Unexpected data token", XBProcessingExceptionType.UNEXPECTED_ORDER);
            }
        } else {
            throw new XBParseException("Unexpected data token", XBProcessingExceptionType.UNEXPECTED_ORDER);
        }
    }

    @Override
    public void endXB() throws XBProcessingException, IOException {
        switch (parserState) {
            case ATTRIBUTE_PART: {
                flushAttributes();
            }

            case EXTENDED_AREA:
            case BLOCK_BEGIN:
            case BLOCK_END: {
                if (bufferedFromLevel >= 0) {
                    tokenWriter.putXBToken(new XBEndToken());
                    if (bufferedFromLevel == depthLevel) {
                        tokenWriter.write(stream);
                        bufferedFromLevel = -1;
                    }
                }

                // Write extended block if present
                if (parserState == XBParserState.EXTENDED_AREA) {
                    if (parserMode != XBParserMode.SINGLE_BLOCK && parserMode != XBParserMode.SKIP_EXTENDED) {
                        CopyStreamUtils.copyInputStreamToOutputStream(extendedArea.getData(), stream);
                    } else {
                        throw new XBParseException("Extended data block present when not expected", XBProcessingExceptionType.UNEXPECTED_ORDER);
                    }
                }

                depthLevel--;
                parserState = (depthLevel == 0) ? XBParserState.EOF : XBParserState.BLOCK_BEGIN;
                break;
            }

            default:
                throw new XBParseException("Unexpected end token", XBProcessingExceptionType.UNEXPECTED_ORDER);
        }
    }

    private void flushAttributes() throws IOException {
        if (bufferedFromLevel == -1) {
            attributePartSizeValue += UBENat32.INFINITY_SIZE_UB;
            UBNat32 attributePartSize = new UBNat32(attributePartSizeValue);
            shrinkStatus(sizeLimits, attributePartSize.getSizeUB() + UBENat32.INFINITY_SIZE_UB + 1);
            attributePartSize.toStreamUB(stream);
            UBENat32 dataPartSize = new UBENat32();
            dataPartSize.setInfinity();
            dataPartSize.toStreamUB(stream);

            for (XBAttribute attribute : attributeList) {
                attribute.toStreamUB(stream);
            }

            stream.write(0);
            attributeList.clear();
        }
    }

    /**
     * Shrinks limits accross all depths.
     *
     * @param value value to shrink all limits off
     * @throws XBParseException if limits are breached
     */
    private void shrinkStatus(List<Integer> sizeLimits, int value) throws XBParseException {
        for (int depth = 0; depth < sizeLimits.size(); depth++) {
            Integer limit = sizeLimits.get(depth);
            if (limit != null) {
                if (limit < value) {
                    throw new XBParseException("Block Overflow", XBProcessingExceptionType.BLOCK_OVERFLOW);
                }

                sizeLimits.set(depth, limit - value);
            }
        }
    }
}
