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
package org.xbup.lib.xbcommand.basic;

import java.util.List;
import org.xbup.lib.xb.block.XBBlockDataMode;
import org.xbup.lib.xb.block.XBBlockType;
import org.xbup.lib.xb.block.XBTEditableDocument;
import org.xbup.lib.xb.parser.tree.XBTTreeNode;
import org.xbup.lib.xb.ubnumber.UBNatural;
import org.xbup.lib.xbcommand.XBTCommand;

/**
 * Command for modifying block attributes.
 *
 * @version 0.1 wr20.0 2010/09/15
 * @author XBUP Project (http://xbup.org)
 */
public class XBTModAttrBlockCommand implements XBTCommand {

    private String caption;
    private List<UBNatural> attrList;
    private XBBlockType blockType;
    private int position;

    public XBTModAttrBlockCommand(XBTTreeNode node, XBTTreeNode newNode) throws Exception {
        caption = "Modified attribute value";
        if (newNode.getDataMode() == XBBlockDataMode.DATA_BLOCK) {
            throw new Exception("Unable to process data node");
        }
        if (node.getDataMode() == XBBlockDataMode.DATA_BLOCK) {
            throw new Exception("Unable to process data node");
        }
        attrList = newNode.getAttributes();
        blockType = newNode.getBlockType();
        position = node.getBlockIndex();
    }

    @Override
    public XBBasicCommandType getOpType() {
        return XBBasicCommandType.NODE_MOD_ATTR;
    }

    @Override
    public String getCaption() {
        return caption;
    }

    @Override
    public void perform(XBTEditableDocument document) {
        XBTTreeNode node = (XBTTreeNode) document.findNodeByIndex(position);
        List<UBNatural> newList = node.getAttributes();
        node.setAttributes(attrList);
        node.setBlockType(blockType);
        attrList = newList;
    }

    @Override
    public void revert(XBTEditableDocument document) throws Exception {
        XBTTreeNode node = (XBTTreeNode) document.findNodeByIndex(position);
        List<UBNatural> newList = node.getAttributes();
        node.setAttributes(attrList);
        node.setBlockType(blockType);
        attrList = newList;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    @Override
    public boolean supportRevert() {
        return true;
    }
}
