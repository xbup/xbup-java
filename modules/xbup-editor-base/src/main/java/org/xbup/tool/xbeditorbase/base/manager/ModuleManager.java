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
package org.xbup.tool.xbeditorbase.base.manager;

import org.xbup.tool.xbeditorbase.base.api.ApplicationFilePanel;
import org.xbup.tool.xbeditorbase.base.api.ApplicationPanel;
import org.xbup.tool.xbeditorbase.base.api.FileTypeManagement;
import org.xbup.tool.xbeditorbase.base.api.MainFrameManagement;
import org.xbup.tool.xbeditorbase.base.api.MenuManagement;
import org.xbup.tool.xbeditorbase.base.api.ModuleManagement;
import org.xbup.tool.xbeditorbase.base.api.OptionsManagement;
import org.xbup.tool.xbeditorbase.base.api.StatusManagement;

/**
 * Manager for modules.
 *
 * @version 0.1 wr22.0 2013/03/01
 * @author XBUP Project (http://xbup.org)
 */
public class ModuleManager implements ModuleManagement {

    private BaseModuleRepository moduleRepository;
    private MenuManager menuManager;
    private PanelManager panelManager;
    private FileTypeManager fileTypeManager;
    private StatusManager statusManager;
    private OptionsManager optionsManager;
    private MainFrameManagement mainFrame;

    public ModuleManager(BaseModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
        menuManager = new MenuManager(moduleRepository);
        panelManager = new PanelManager(moduleRepository);
        fileTypeManager = new FileTypeManager(moduleRepository);
        statusManager = new StatusManager(moduleRepository);
        optionsManager = new OptionsManager(moduleRepository);
        mainFrame = moduleRepository.getMainFrame();
    }

    @Override
    public void registerPanel(ApplicationPanel panel) {
        panelManager.registerPanel(panel);
        if (panel instanceof ApplicationFilePanel) {
            menuManager.setMode(MenuManager.MenuManagerMode.FILE);
        }
    }

    @Override
    public MenuManagement getMenuManagement() {
        return menuManager;
    }

    @Override
    public FileTypeManagement getFileTypeManagement() {
        return fileTypeManager;
    }

    /**
     * @return the statusManager
     */
    @Override
    public StatusManagement getStatusManagement() {
        return statusManager;
    }

    @Override
    public OptionsManagement getOptionsManagement() {
        return optionsManager;
    }

    @Override
    public MainFrameManagement getMainFrameManagement() {
        return mainFrame;
    }
}
