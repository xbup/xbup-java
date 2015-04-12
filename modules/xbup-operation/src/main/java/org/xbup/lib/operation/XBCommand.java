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
package org.xbup.lib.operation;

import org.xbup.lib.core.block.XBEditableDocument;
import org.xbup.lib.operation.basic.XBBasicCommandType;

/**
 * Interface for XBUP editor command.
 *
 * @version 0.1.25 2015/04/12
 * @author XBUP Project (http://xbup.org)
 */
public interface XBCommand {

    /**
     * Returns operation type.
     *
     * @return command type
     */
    public XBBasicCommandType getOpType();

    /**
     * Returns caption as text.
     *
     * @return text caption
     */
    public String getCaption();

    /**
     * Performs operation on given document.
     *
     * @param document a document to execute operation on
     * @throws java.lang.Exception
     */
    public void execute(XBEditableDocument document) throws Exception;

    /**
     * Performs redo on given document.
     *
     * @param document a document to execute operation on
     * @throws java.lang.Exception
     */
    public void redo(XBEditableDocument document) throws Exception;

    /**
     * Performs undo operation on given document.
     *
     * @param document a document to execute operation on
     * @throws java.lang.Exception
     */
    public void undo(XBEditableDocument document) throws Exception;

    /**
     * Returns true if command support undo operation.
     *
     * @return true if undo supported
     */
    public boolean canUndo();
}
