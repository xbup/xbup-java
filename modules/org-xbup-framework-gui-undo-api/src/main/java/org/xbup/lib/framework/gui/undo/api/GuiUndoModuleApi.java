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
package org.xbup.lib.framework.gui.undo.api;

import org.xbup.lib.framework.gui.api.XBApplicationModulePlugin;
import org.xbup.lib.framework.gui.api.XBModuleRepositoryUtils;
import org.xbup.lib.operation.undo.XBUndoHandler;

/**
 * Interface for XBUP framework undo/redo module.
 *
 * @version 0.2.0 2015/11/09
 * @author XBUP Project (http://xbup.org)
 */
public interface GuiUndoModuleApi extends XBApplicationModulePlugin {

    public static String MODULE_ID = XBModuleRepositoryUtils.getModuleIdByApi(GuiUndoModuleApi.class);

    /**
     * Returns undo handler.
     *
     * @return undo handler
     */
    XBUndoHandler getUndoHandler();

    /**
     * Registers undo/redo operations to main frame menu.
     */
    void registerMainMenu();

    /**
     * Registers undo/redo operations to main frame tool bar.
     */
    void registerMainToolBar();
}
