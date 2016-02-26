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
package org.xbup.lib.framework.gui.file.api;

import org.xbup.lib.framework.api.XBApplicationModulePlugin;
import org.xbup.lib.framework.api.XBModuleRepositoryUtils;

/**
 * Interface for XBUP framework file module.
 *
 * @version 0.2.0 2016/02/03
 * @author XBUP Project (http://xbup.org)
 */
public interface GuiFileModuleApi extends XBApplicationModulePlugin {

    public static String MODULE_ID = XBModuleRepositoryUtils.getModuleIdByApi(GuiFileModuleApi.class);

    FileHandlingActionsApi getFileHandlingActions();

    void addFileType(FileType fileType);

    /**
     * Registers file handling operations to main frame menu.
     */
    void registerMenuFileHandlingActions();

    /**
     * Registers file handling operations to main frame tool bar.
     */
    void registerToolBarFileHandlingActions();

    /**
     * Register close listener.
     */
    void registerCloseListener();

    /**
     * Attempts to load given filename to active panel.
     *
     * @param filename
     */
    void loadFromFile(String filename);
    
    /**
     * Registers list of last opened files into file menu.
     */
    void registerLastOpenedMenuActions();
}
