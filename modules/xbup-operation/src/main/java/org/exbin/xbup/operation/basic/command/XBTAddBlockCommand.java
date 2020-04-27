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
package org.exbin.xbup.operation.basic.command;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import org.exbin.xbup.core.block.XBTEditableBlock;
import org.exbin.xbup.core.block.XBTEditableDocument;
import org.exbin.xbup.operation.XBTOpDocCommand;
import org.exbin.xbup.operation.basic.XBBasicCommandType;
import org.exbin.xbup.operation.basic.XBTAddBlockOperation;

/**
 * Command for adding child block.
 *
 * @version 0.2.0 2015/09/19
 * @author ExBin Project (http://exbin.org)
 */
@ParametersAreNonnullByDefault
public class XBTAddBlockCommand extends XBTOpDocCommand {

    public XBTAddBlockCommand(XBTEditableDocument document, long parentPosition, int childIndex, XBTEditableBlock newNode) {
        super(document);
//        long position;
//        int childIndex = 0;
//        if ( == null) {
//            position = -1;
//        } else {
//            position = parentNode.getBlockIndex();
//            childIndex = parentNode.getChildrenCount();
//        }
        super.setOperation(new XBTAddBlockOperation(document, parentPosition, childIndex, newNode));
    }

    @Nonnull
    @Override
    public XBBasicCommandType getBasicType() {
        return XBBasicCommandType.BLOCK_ADDED;
    }
}
