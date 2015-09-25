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
package org.xbup.lib.parser_command;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.xbup.lib.core.block.XBBlock;
import org.xbup.lib.core.block.XBBlockDataMode;
import org.xbup.lib.core.block.XBBlockTerminationMode;
import org.xbup.lib.core.parser.XBParseException;
import org.xbup.lib.core.parser.XBParserMode;
import org.xbup.lib.core.parser.XBParserState;
import org.xbup.lib.core.parser.XBProcessingException;
import org.xbup.lib.core.parser.XBProcessingExceptionType;
import org.xbup.lib.core.parser.basic.XBHead;
import org.xbup.lib.core.parser.basic.wrapper.ExtendedAreaInputStreamWrapper;
import org.xbup.lib.core.parser.basic.wrapper.FixedDataInputStreamWrapper;
import org.xbup.lib.core.parser.basic.wrapper.TerminatedDataInputStreamWrapper;
import org.xbup.lib.core.parser.token.XBAttribute;
import org.xbup.lib.core.parser.token.XBAttributeToken;
import org.xbup.lib.core.parser.token.XBBeginToken;
import org.xbup.lib.core.parser.token.XBDataToken;
import org.xbup.lib.core.parser.token.XBEndToken;
import org.xbup.lib.core.parser.token.XBToken;
import org.xbup.lib.core.parser.token.pull.XBPullProvider;
import org.xbup.lib.core.stream.FinishableStream;
import org.xbup.lib.core.stream.SeekableStream;
import org.xbup.lib.core.ubnumber.type.UBENat32;
import org.xbup.lib.core.ubnumber.type.UBNat32;

/**
 * XBUP level 0 command reader using pull reader.
 *
 * This reader expects data not to be changed, so exclusive lock on source data
 * is recommended.
 *
 * @version 0.2.0 2015/09/25
 * @author XBUP Project (http://xbup.org)
 */
public class XBReader implements XBCommandReader, XBPullProvider, Closeable {

    private XBParserState parserState;
    private XBParserMode parserMode = XBParserMode.FULL;
    private FinishableStream dataWrapper;
    private final List<XBReader.BlockPosition> pathPositions = new ArrayList<>();

    private InputStream source;
    private long currentSourcePosition;
    private long processedBlockSize;

    private XBBlockDataMode currentBlockDataMode;
    private XBBlockTerminationMode currentBlockTerminationMode;
    private int attributePartSizeValue;
    private Integer dataPartSizeValue;
    private int attributeIndex;
    // Cached last block accesing this reader for faster position matching
    private XBReaderBlock activeBlock = null;

    public XBReader() throws IOException {
        resetParser();
    }

    public XBReader(InputStream stream) throws IOException {
        openStream(stream);
    }

    public XBReader(InputStream stream, XBParserMode parserMode) throws IOException {
        this.parserMode = parserMode;
        openStream(stream);
    }

    @Override
    public void open(InputStream stream) throws IOException {
        openStream(stream);
    }

    private void openStream(InputStream stream) throws IOException {
        source = stream;

        if (!(source instanceof SeekableStream)) {
            throw new IOException("XBReader only supports seekable streams");
        }

        resetParser();
    }

    @Override
    public void close() throws IOException {
        if (source != null) {
            source.close();
        }
    }

    private void resetParser() throws IOException {
        pathPositions.clear();
        dataWrapper = null;
        currentSourcePosition = 0;
        processedBlockSize = 0;
        attributePartSizeValue = 0;
        dataPartSizeValue = null;
        parserState = XBParserState.START;

        resetBlock();
    }

    @Override
    public void resetXB() throws IOException {
        resetParser();
    }

    private void resetBlock() {
        currentBlockDataMode = null;
        currentBlockTerminationMode = null;
        attributeIndex = 0;
        currentSourcePosition = currentSourcePosition - processedBlockSize;
        processedBlockSize = 0;
    }

    private void restartBlock() throws IOException {
        if (pathPositions.isEmpty()) {
            currentSourcePosition = 0;
            parserState = XBParserState.START;
        } else {
            BlockPosition currentPosition = pathPositions.get(pathPositions.size() - 1);
            currentSourcePosition = currentPosition.streamPosition;

            // Revert already decreased size limits
            for (BlockPosition blockPosition : pathPositions) {
                if (blockPosition.sizeLimit != null) {
                    blockPosition.sizeLimit -= (int) processedBlockSize;
                }
            }

            processedBlockSize = 0;
        }

        ((SeekableStream) source).seek(currentSourcePosition);
        resetBlock();
    }

    @Override
    public XBBlock getRootBlock() {
        return getBlock(new long[0]);
    }

    @Override
    public XBBlock getBlock(long[] blockPath) {
        return new XBReaderBlock(this, blockPath);
    }

    public XBReaderBlock getActiveBlock() {
        return activeBlock;
    }

    public void setActiveBlock(XBReaderBlock activeBlock) {
        this.activeBlock = activeBlock;
    }

    @Override
    public InputStream getExtendedArea() {
        // TODO: Stupid algorithmus for initial testing
        try {
            if (parserState == XBParserState.EOF) {
                resetParser();
            }

            while (!isFinishedXB()) {
                XBToken token = pullXBToken();
                if (parserState == XBParserState.EXTENDED_AREA) {
                    return ((XBDataToken) token).getData();
                }
            }
        } catch (IOException ex) {
        }

        return null;
    }

    @Override
    public long getExtendedAreaSize() {
        try {
            // TODO
            ExtendedAreaInputStreamWrapper extendedArea = (ExtendedAreaInputStreamWrapper) getExtendedArea();
            return extendedArea == null ? 0 : extendedArea.available();
        } catch (IOException ex) {
        }

        return 0;
    }

    /**
     * Returns currently selected block.
     *
     * @return block handler
     */
    public XBBlock getBlock() {
        return getBlock(getCurrentPath());
    }

    public XBBlockDataMode getBlockDataMode() throws XBProcessingException, IOException {
        if (parserState != XBParserState.BLOCK_BEGIN) {
            restartBlock();
            pullXBToken();
        }

        return currentBlockDataMode;
    }

    public XBBlockTerminationMode getBlockTerminationMode() throws XBProcessingException, IOException {
        if (parserState != XBParserState.BLOCK_BEGIN) {
            restartBlock();
            pullXBToken();
        }

        return currentBlockTerminationMode;
    }

    public XBAttribute getBlockAttribute(int attributeIndex) throws XBProcessingException, IOException {
        //if (parserState != XBParserState.BLOCK_BEGIN) {
        restartBlock();
        pullXBToken();
        //}

        int attributesCount = 0;
        while (attributesCount < attributeIndex && parserState == XBParserState.ATTRIBUTE_PART) {
            attributesCount++;
            pullXBToken();
        }

        if (attributesCount == attributeIndex && parserState == XBParserState.ATTRIBUTE_PART) {
            return ((XBAttributeToken) pullXBToken()).getAttribute();
        }

        return null;
    }

    public int getBlockAttributesCount() throws XBProcessingException, IOException {
        if (parserState != XBParserState.BLOCK_BEGIN) {
            restartBlock();
            pullXBToken();
        }

        int attributesCount = 0;
        while (parserState == XBParserState.ATTRIBUTE_PART) {
            attributesCount++;
            pullXBToken();
        }

        return attributesCount;
    }

    public InputStream getBlockData() throws XBProcessingException, IOException {
        if (parserState != XBParserState.BLOCK_BEGIN) {
            restartBlock();
            pullXBToken();
        }

        if (parserState == XBParserState.DATA_PART) {
            return ((XBDataToken) pullXBToken()).getData();
        } else {
            return null;
        }
    }

    public int getBlockChildrenCount() {
        return 0;
    }

    private long[] getCurrentPath() {
        long[] currentPath = new long[pathPositions.size()];
        for (int i = 0; i < currentPath.length; i++) {
            currentPath[i] = pathPositions.get(i).blockIndex;
        }
        return currentPath;
    }

    public int getCurrentLevel() {
        return pathPositions.size() - 1;
    }

    public long getCurrentBlockStreamPosition() {
        return pathPositions.isEmpty() ? 0 : pathPositions.get(pathPositions.size() - 1).streamPosition;
    }

    /**
     * Returns current level of how deep in tree we are.
     *
     * @return tree level, 0 means root
     */
    protected int getLevel() {
        return pathPositions.size();
    }

    public void skipXB(long tokenCount) throws XBProcessingException, IOException {
        for (long i = 0; i < tokenCount; i++) {
            pullXBToken();
        }
    }

    public void skipChildXB(long childBlocksCount) throws XBProcessingException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void skipAttributesXB(long attributesCount) throws XBProcessingException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Pulls next token from the reader.
     *
     * @return next recognized event item in stream
     * @throws IOException
     */
    @Override
    public XBToken pullXBToken() throws XBProcessingException, IOException {
        if (dataWrapper != null) {
            dataWrapper.finish();
            shrinkStatus(pathPositions, (int) dataWrapper.getLength());
            dataWrapper = null;
        }

        if (parserState == XBParserState.START) {
            if (parserMode != XBParserMode.SINGLE_BLOCK && parserMode != XBParserMode.SKIP_HEAD) {
                XBHead.checkXBUPHead(source);
            }

            parserState = XBParserState.BLOCK_BEGIN;
        }

        switch (parserState) {
            case BLOCK_BEGIN: {
                UBNat32 attrPartSize = new UBNat32();
                int headSize = attrPartSize.fromStreamUB(source);
                shrinkStatus(pathPositions, headSize);
                if (attrPartSize.getLong() == 0) {
                    // Process terminator
                    if (pathPositions.isEmpty() || pathPositions.get(pathPositions.size() - 1).sizeLimit != null) {
                        throw new XBParseException("Unexpected terminator", XBProcessingExceptionType.UNEXPECTED_TERMINATOR);
                    }

                    pathPositions.remove(pathPositions.size() - 1);
                    parserState = XBParserState.BLOCK_END;
                    // no break - Continue to process BLOCK_END
                } else {
                    attributePartSizeValue = attrPartSize.getInt();
                    shrinkStatus(pathPositions, attributePartSizeValue);

                    UBENat32 dataPartSize = new UBENat32();
                    int dataPartSizeLength = dataPartSize.fromStreamUB(source);
                    dataPartSizeValue = dataPartSize.isInfinity() ? null : dataPartSize.getInt();
                    currentBlockTerminationMode = dataPartSize.isInfinity() ? XBBlockTerminationMode.TERMINATED_BY_ZERO : XBBlockTerminationMode.SIZE_SPECIFIED;

                    if (attributePartSizeValue == dataPartSizeLength) {
                        currentBlockDataMode = XBBlockDataMode.DATA_BLOCK;
                        parserState = XBParserState.DATA_PART;
                    } else {
                        currentBlockDataMode = XBBlockDataMode.NODE_BLOCK;
                        attributePartSizeValue -= dataPartSizeLength;
                        if (attributePartSizeValue > 0) {
                            parserState = XBParserState.ATTRIBUTE_PART;
                        } else {
                            if (dataPartSizeValue == null || dataPartSizeValue > 0) {
                                pathPositions.add(new BlockPosition(0, 0, dataPartSizeValue));
                                parserState = XBParserState.BLOCK_BEGIN;
                            } else {
                                parserState = XBParserState.BLOCK_END;
                            }
                        }
                    }

                    return new XBBeginToken(dataPartSizeValue == null ? XBBlockTerminationMode.TERMINATED_BY_ZERO : XBBlockTerminationMode.SIZE_SPECIFIED);
                }
            }

            case EXTENDED_AREA:
            case BLOCK_END: {
                // must be after begin
                if (pathPositions.isEmpty()) {
                    if (parserState == XBParserState.BLOCK_END) {
                        if (parserMode != XBParserMode.SINGLE_BLOCK && parserMode != XBParserMode.SKIP_EXTENDED) {
                            parserState = XBParserState.EXTENDED_AREA;
                            ExtendedAreaInputStreamWrapper wrapper = new ExtendedAreaInputStreamWrapper(source);
                            if (wrapper.available() > 0) {
                                return new XBDataToken(wrapper);
                            }
                        }
                    }

                    parserState = XBParserState.EOF;
                } else {
                    if (pathPositions.get(pathPositions.size() - 1).sizeLimit == null || pathPositions.get(pathPositions.size() - 1).sizeLimit > 0) {
                        parserState = XBParserState.BLOCK_BEGIN;
                    } else {
                        pathPositions.remove(pathPositions.size() - 1);
                    }
                }

                return new XBEndToken();
            }

            case ATTRIBUTE_PART: {
                UBNat32 attribute = new UBNat32();
                int attributeLength = attribute.fromStreamUB(source);
                if (attributeLength > attributePartSizeValue) {
                    throw new XBParseException("Attribute overflow", XBProcessingExceptionType.ATTRIBUTE_OVERFLOW);
                }

                attributePartSizeValue -= attributeLength;
                if (attributePartSizeValue == 0) {
                    if (dataPartSizeValue == null || dataPartSizeValue > 0) {
                        pathPositions.add(new BlockPosition(0, 0, dataPartSizeValue));
                        parserState = XBParserState.BLOCK_BEGIN;
                    } else {
                        parserState = XBParserState.BLOCK_END;
                    }
                }

                attributeIndex++;
                return new XBAttributeToken(attribute);
            }

            case DATA_PART: {
                dataWrapper = (dataPartSizeValue == null)
                        ? new TerminatedDataInputStreamWrapper(source)
                        : new FixedDataInputStreamWrapper(source, dataPartSizeValue);

                parserState = XBParserState.BLOCK_END;
                return new XBDataToken((InputStream) dataWrapper);
            }

            case EOF:
                throw new XBParseException("Reading After End", XBProcessingExceptionType.READING_AFTER_END);

            default:
                throw new XBParseException("Unexpected pull item type", XBProcessingExceptionType.UNKNOWN);
        }
    }

    public boolean isFinishedXB() {
        return parserState == XBParserState.EOF;
    }

    /**
     * Returns actual parsing mode.
     *
     * @return parse mode
     */
    public XBParserState getParseMode() {
        return parserState;
    }

    @Override
    public long getDocumentSize() {
        return ((SeekableStream) source).getStreamSize();
    }

    /**
     * Seeks given reader block.
     *
     * @param targetBlock target reader block
     * @throws IOException
     */
    public void seekBlock(XBReaderBlock targetBlock) throws XBProcessingException, IOException {
        if (activeBlock != targetBlock) {
            seekBlockPath(targetBlock.getBlockPath());
            activeBlock = targetBlock;
        }
    }

    /**
     * Seeks given block path in stream.
     *
     * @param blockPath target block path
     * @throws IOException
     */
    public void seekBlockPath(long[] blockPath) throws XBProcessingException, IOException {
        // Find maximum match in current block path
        int depthMatch = 0;
        if (blockPath != null) {
            while (blockPath.length > depthMatch && pathPositions.size() > depthMatch) {
                if (blockPath[depthMatch] == pathPositions.get(depthMatch).blockIndex) {
                    depthMatch++;
                } else {
                    break;
                }
            }
        }

        // Seek to the most further block position
        if (depthMatch == 0) {
            pathPositions.clear();
            ((SeekableStream) source).seek(0);
        } else {
            // Remove block positions after matched depth, but compute processed size
            for (int i = pathPositions.size() - 1; i >= depthMatch; i--) {
                pathPositions.remove(i);
            }

            BlockPosition targetPosition = pathPositions.get(depthMatch - 1);
            long processedSize = currentSourcePosition - targetPosition.streamPosition;
            // Revert already decreased size limits
            for (BlockPosition blockPosition : pathPositions) {
                if (blockPosition.sizeLimit != null) {
                    blockPosition.sizeLimit -= (int) processedSize;
                }
            }

            ((SeekableStream) source).seek(targetPosition.streamPosition);
        }

        // Traverse tree to the target position
        resetBlock();
    }

    /**
     * Shrinks limits accross all depths.
     *
     * @param length Value to shrink all limits off
     * @throws XBParseException If limits are breached
     */
    private void shrinkStatus(List<XBReader.BlockPosition> pathPositions, int value) throws XBParseException {
        for (BlockPosition blockPosition : pathPositions) {
            Integer limit = blockPosition.sizeLimit;
            if (limit != null) {
                if (limit < value) {
                    throw new XBParseException("Block overflow", XBProcessingExceptionType.BLOCK_OVERFLOW);
                }

                blockPosition.sizeLimit = limit - value;
            }
        }
        processedBlockSize += value;
        currentSourcePosition += value;
    }

    public void seekBlockStart(long currentBlockStreamPosition, int preserveLevels) throws IOException {
        dataWrapper = null;
        parserState = XBParserState.START;
        pathPositions.clear();
        attributePartSizeValue = 0;

        if (source instanceof SeekableStream) {
            ((SeekableStream) source).seek(currentBlockStreamPosition);
        }
    }

    /**
     * Record for block position.
     */
    private class BlockPosition {

        long streamPosition;
        int blockIndex;
        Integer sizeLimit;

        public BlockPosition(long streamPosition, int blockIndex, Integer sizeLimit) {
            this.streamPosition = streamPosition;
            this.blockIndex = blockIndex;
            this.sizeLimit = sizeLimit;
        }
    }
}
