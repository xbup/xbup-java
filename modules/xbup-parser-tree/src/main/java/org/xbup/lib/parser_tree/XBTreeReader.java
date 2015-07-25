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
package org.xbup.lib.parser_tree;

import java.io.IOException;
import java.io.InputStream;
import org.xbup.lib.core.block.XBBlockDataMode;
import org.xbup.lib.core.parser.XBParseException;
import org.xbup.lib.core.parser.XBParserState;
import org.xbup.lib.core.parser.XBProcessingException;
import org.xbup.lib.core.parser.XBProcessingExceptionType;
import org.xbup.lib.core.parser.basic.XBListener;
import org.xbup.lib.core.parser.basic.convert.XBSkipBlockListener;
import org.xbup.lib.core.block.XBBlockTerminationMode;
import org.xbup.lib.core.block.XBDefaultDocument;
import org.xbup.lib.core.block.XBDocument;
import org.xbup.lib.core.block.XBEditableBlock;
import org.xbup.lib.core.block.XBEditableDocument;
import org.xbup.lib.core.parser.token.XBAttribute;
import org.xbup.lib.core.ubnumber.UBNatural;

/**
 * XBUP level 0 convertor from tokens to tree node.
 *
 * @version 0.1.25 2015/07/25
 * @author XBUP Project (http://xbup.org)
 */
public class XBTreeReader implements XBListener {

    private XBDocument target;
    private XBEditableBlock block;
    private final boolean recursive;
    private final boolean allowExtendedArea;
    private boolean finished;
    private XBParserState parserState;
    private XBSkipBlockListener skipNode;
    private long level;

    public XBTreeReader(XBDocument target) {
        this(target, true, true);
    }

    public XBTreeReader(XBDocument target, boolean recursive, boolean allowExtendedArea) {
        this.target = target;
        block = (XBEditableBlock) target.getRootBlock();
        this.recursive = recursive;
        this.allowExtendedArea = allowExtendedArea;
        finished = false;
        if (!recursive) {
            skipNode = new XBSkipBlockListener();
        }

        parserState = XBParserState.START;
        level = 0;
    }

    public XBTreeReader(XBEditableBlock target) {
        this(new XBDefaultDocument(target), true, false);
    }

    @Override
    public void beginXB(XBBlockTerminationMode terminationMode) throws XBProcessingException, IOException {
        if (finished) {
            throw new XBParseException("Block already parsed", XBProcessingExceptionType.UNEXPECTED_ORDER);
        }

        if ((!recursive) && (!skipNode.isSkipped())) {
            skipNode.beginXB(terminationMode);
            return;
        }

        if (parserState == XBParserState.START) {
            if (!recursive) {
                if (block.getDataMode() == XBBlockDataMode.NODE_BLOCK) {
                    block.setAttributesCount(0);
                } else {
                    block.clearData();
                }
            } else {
                block.clear();
            }

            block.setTerminationMode(terminationMode);
            parserState = XBParserState.BLOCK_BEGIN;
        } else if (parserState == XBParserState.ATTRIBUTE_PART || parserState == XBParserState.BLOCK_END) {
            if (!recursive) {
                throw new XBParseException("Parser invalid state", XBProcessingExceptionType.UNKNOWN);
            }

            XBEditableBlock node = (XBEditableBlock) block.createNewChild(block.getChildrenCount());
            node.setParent(block);
            node.setTerminationMode(terminationMode);
            level++;
            block = node;
            parserState = XBParserState.BLOCK_BEGIN;
        } else {
            throw new XBParseException("Unexpected block begin event", XBProcessingExceptionType.UNEXPECTED_ORDER);
        }
    }

    @Override
    public void attribXB(XBAttribute value) throws XBProcessingException, IOException {
        if (finished) {
            throw new XBParseException("Block already parsed", XBProcessingExceptionType.UNEXPECTED_ORDER);
        }

        if ((!recursive) && (!skipNode.isSkipped())) {
            skipNode.attribXB((UBNatural) value);
            return;
        }

        if (parserState == XBParserState.BLOCK_BEGIN) {
            block.setAttributesCount(0);
            parserState = XBParserState.ATTRIBUTE_PART;
        }

        if (parserState == XBParserState.ATTRIBUTE_PART) {
            block.setAttributeAt(value, block.getAttributesCount());
        } else {
            throw new XBParseException("Unexpected attribute event", XBProcessingExceptionType.UNEXPECTED_ORDER);
        }
    }

    @Override
    public void dataXB(InputStream data) throws XBProcessingException, IOException {
        if (finished) {
            throw new XBParseException("Block already parsed", XBProcessingExceptionType.UNEXPECTED_ORDER);
        }

        if ((!recursive) && (!skipNode.isSkipped())) {
            skipNode.dataXB(data);
            return;
        }

        if (level == 0 && (parserState == XBParserState.ATTRIBUTE_PART || parserState == XBParserState.DATA_PART || parserState == XBParserState.BLOCK_END)) {
            if (allowExtendedArea) {
                ((XBEditableDocument) target).setExtendedArea(data);
                parserState = XBParserState.EXTENDED_AREA;
            } else {
                throw new XBParseException("Unexpected data event for extended area", XBProcessingExceptionType.UNEXPECTED_ORDER);
            }
        } else {
            if (parserState == XBParserState.BLOCK_BEGIN) {
                parserState = XBParserState.DATA_PART;
                block.setDataMode(XBBlockDataMode.DATA_BLOCK);
                block.setData(data);
            } else {
                throw new XBParseException("Unexpected data event", XBProcessingExceptionType.UNEXPECTED_ORDER);
            }
        }
    }

    @Override
    public void endXB() throws XBProcessingException, IOException {
        if (finished) {
            throw new XBParseException("Block already parsed", XBProcessingExceptionType.UNEXPECTED_ORDER);
        }

        if ((!recursive) && (!skipNode.isSkipped())) {
            skipNode.endXB();
            return;
        }

        if (parserState == XBParserState.DATA_PART || parserState == XBParserState.ATTRIBUTE_PART || parserState == XBParserState.BLOCK_END || parserState == XBParserState.EXTENDED_AREA) {
            parserState = XBParserState.BLOCK_END;
            if (level > 0) {
                level--;
                block = (XBEditableBlock) block.getParent();
                return;
            } else {
                finished = true;
                parserState = XBParserState.EOF;
                return;
            }
        }

        throw new XBParseException("Unexpected block end event", XBProcessingExceptionType.UNEXPECTED_ORDER);
    }

    public boolean isClosed() {
        return finished;
    }
}
