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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xbup.lib.xb.block.XBTBlock;
import org.xbup.lib.xb.block.XBTEditableDocument;
import org.xbup.lib.xb.parser.tree.XBTTreeNode;
import org.xbup.lib.xbcommand.XBTCommand;
import org.xbup.lib.xbcommand.undo.XBTLinearUndo;

/**
 * Command for deleting block.
 *
 * @version 0.1 wr20.0 2010/09/15
 * @author XBUP Project (http://xbup.org)
 */
public class XBTDeleteBlockCommand implements XBTCommand {

    private String caption;
    private long position;
    private long index;
    private InputStream data;

    public XBTDeleteBlockCommand(XBTTreeNode node) {
        caption = "Deleted item";
        if (node.getParent() != null) {
            position = node.getParent().getBlockIndex();
            index = node.getParent().getIndex(node);
        } else {
            position = 0;
            index = -1;
        }
    }

    @Override
    public XBBasicCommandType getOpType() {
        return XBBasicCommandType.NODE_DEL;
    }

    @Override
    public String getCaption() {
        return caption;
    }

    @Override
    public void perform(XBTEditableDocument document) {
        XBTTreeNode node;
        XBTTreeNode parent;
        if ((position == 0) && (index == -1)) {
            node = (XBTTreeNode) document.getRootBlock();
            parent = null;
        } else {
            parent = (XBTTreeNode) document.findNodeByIndex(position);
            node = (XBTTreeNode) parent.getChildAt((int) index);
        }

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try {
            node.toStreamUB(stream);
        } catch (IOException ex) {
            Logger.getLogger(XBTLinearUndo.class.getName()).log(Level.SEVERE, null, ex);
        }
        data = new ByteArrayInputStream(stream.toByteArray());
        if ((position == 0) && (index == -1)) {
            document.clear();
        } else {
            parent.getChildren().remove(node);
        }
    }

    @Override
    public void revert(XBTEditableDocument document) throws Exception {
        data.reset();
        if ((position == 0) && (index == -1)) {
            XBTTreeNode newNode = (XBTTreeNode) document.createNewBlock(null);
            newNode.fromStreamUB(data);
            document.setRootBlock(newNode);
// TODO                newNode.setContext(document.getRootContext());
// TODO                document.processSpec();
        } else {
            XBTTreeNode node = (XBTTreeNode) document.findNodeByIndex(position);
            if (node == null) {
                throw new Exception("Unable to find node referenced in undo");
            }
            List<XBTBlock> children = node.getChildren();
            XBTTreeNode newNode = (XBTTreeNode) node.newNodeInstance(node);
            newNode.fromStreamUB(data);
            children.add((int) index, newNode);
            // TODO: Update context newNode.setContext(node.getContext());
        }
        data = null;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    @Override
    public boolean supportRevert() {
        return true;
    }
}
