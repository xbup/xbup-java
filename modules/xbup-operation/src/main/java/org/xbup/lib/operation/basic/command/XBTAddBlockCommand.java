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
package org.xbup.lib.operation.basic.command;

import org.xbup.lib.core.block.XBTEditableBlock;
import org.xbup.lib.operation.XBTOpDocCommand;
import org.xbup.lib.operation.basic.XBBasicCommandType;
import org.xbup.lib.operation.basic.XBTAddBlockOperation;

/**
 * Command for adding child block.
 *
 * @version 0.2.0 2015/09/19
 * @author XBUP Project (http://xbup.org)
 */
public class XBTAddBlockCommand extends XBTOpDocCommand {

    public XBTAddBlockCommand(long parentPosition, int childIndex, XBTEditableBlock newNode) {
//        long position;
//        int childIndex = 0;
//        if ( == null) {
//            position = -1;
//        } else {
//            position = parentNode.getBlockIndex();
//            childIndex = parentNode.getChildrenCount();
//        }
        setOperation(new XBTAddBlockOperation(parentPosition, childIndex, newNode));
    }

    @Override
    public XBBasicCommandType getBasicType() {
        return XBBasicCommandType.NODE_ADDED;
    }
}
