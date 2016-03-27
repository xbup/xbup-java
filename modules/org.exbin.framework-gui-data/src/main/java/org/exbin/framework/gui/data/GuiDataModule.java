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
package org.exbin.framework.gui.data;

import javax.swing.JPanel;
import org.exbin.framework.api.XBApplication;
import org.exbin.framework.gui.data.api.GuiDataModuleApi;
import org.exbin.framework.gui.data.panel.TableEditPanel;
import org.exbin.xbup.plugin.XBModuleHandler;

/**
 * Implementation of XBUP framework data module.
 *
 * @version 0.2.0 2016/02/27
 * @author ExBin Project (http://exbin.org)
 */
public class GuiDataModule implements GuiDataModuleApi {

    private XBApplication application;

    public GuiDataModule() {
    }

    @Override
    public void init(XBModuleHandler application) {
        this.application = (XBApplication) application;
    }

    @Override
    public void unregisterModule(String moduleId) {
    }
    
    @Override
    public JPanel getTableEditPanel() {
        return new TableEditPanel();
    }
}
