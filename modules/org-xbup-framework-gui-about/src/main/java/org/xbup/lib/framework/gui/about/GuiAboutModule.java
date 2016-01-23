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
package org.xbup.lib.framework.gui.about;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import net.xeoh.plugins.base.annotations.PluginImplementation;
import org.xbup.lib.framework.gui.api.XBApplication;
import org.xbup.lib.framework.gui.about.api.GuiAboutModuleApi;
import org.xbup.lib.framework.gui.frame.api.GuiFrameModuleApi;
import org.xbup.lib.framework.gui.menu.api.GuiMenuModuleApi;
import org.xbup.lib.framework.gui.menu.api.MenuPosition;
import org.xbup.lib.framework.gui.menu.api.PositionMode;
import org.xbup.lib.framework.gui.utils.ActionUtils;

/**
 * Implementation of XBUP framework about module.
 *
 * @version 0.2.0 2016/01/23
 * @author XBUP Project (http://xbup.org)
 */
@PluginImplementation
public class GuiAboutModule implements GuiAboutModuleApi {

    private XBApplication application;
    private Action aboutAction;

    public GuiAboutModule() {
    }

    @Override
    public void init(XBApplication application) {
        this.application = application;
    }

    @Override
    public void unregisterPlugin(String pluginId) {
    }

    @Override
    public Action getAboutAction() {
        if (aboutAction == null) {
            aboutAction = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    GuiFrameModuleApi frameModule = application.getModuleRepository().getModuleByInterface(GuiFrameModuleApi.class);
                    AboutDialog aboutDialog = new AboutDialog(frameModule.getFrame(), true, application);
                    aboutDialog.setProjectResourceBundle(application.getAppBundle());
                    aboutDialog.setVisible(true);
                }
            };
            aboutAction.putValue("Name", "About");
            aboutAction.putValue(ActionUtils.ACTION_DIALOG_MODE, true);
        }
        
        return aboutAction;
    }

    @Override
    public void registerDefaultMenuItem() {
        GuiMenuModuleApi menuModule = application.getModuleRepository().getModuleByInterface(GuiMenuModuleApi.class);
        menuModule.registerMenuItem(GuiFrameModuleApi.HELP_MENU_ID, GuiAboutModuleApi.MODULE_ID, getAboutAction(), new MenuPosition(PositionMode.BOTTOM_LAST));
    }
}
