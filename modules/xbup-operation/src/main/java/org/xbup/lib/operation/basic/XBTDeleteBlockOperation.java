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
package org.xbup.lib.operation.basic;

import java.util.List;
import org.xbup.lib.core.block.XBTBlock;
import org.xbup.lib.core.block.XBTEditableBlock;
import org.xbup.lib.operation.Operation;
import org.xbup.lib.operation.XBTDocOperation;

/**
 * Command for deleting child block.
 *
 * @version 0.1.25 2015/04/27
 * @author XBUP Project (http://xbup.org)
 */
public class XBTDeleteBlockOperation extends XBTDocOperation {

    private final long position;

    public XBTDeleteBlockOperation(long position) {
        this.position = position;
    }

    @Override
    public XBBasicOperationType getBasicType() {
        return XBBasicOperationType.ADD_NODE;
    }

    @Override
    public void execute() throws Exception {
        if (position == -1) {
            document.clear();
        } else {
            XBTEditableBlock node = (XBTEditableBlock) document.findBlockByIndex(position);
            List<XBTBlock> children = node.getChildren();
            children.remove(children.size() - 1);
        }
    }

    @Override
    public Operation executeWithUndo() throws Exception {
        XBTEditableBlock deletedNode;
        if (position == -1) {
            deletedNode = (XBTEditableBlock) document.getRootBlock();
        } else {
            XBTEditableBlock node = (XBTEditableBlock) document.findBlockByIndex(position);
            List<XBTBlock> children = node.getChildren();
            deletedNode = (XBTEditableBlock) children.get(children.size() - 1);
        }
        XBTAddBlockOperation undoOperation = new XBTAddBlockOperation(position, deletedNode);
        undoOperation.setDocument(document);

        execute();

        return undoOperation;
    }
}
