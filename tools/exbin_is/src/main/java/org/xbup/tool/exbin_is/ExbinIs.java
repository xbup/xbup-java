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
package org.xbup.tool.exbin_is;

import java.awt.Dimension;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.xbup.lib.core.parser.basic.XBHead;
import org.xbup.lib.framework.editor.text.EditorTextModule;
import org.xbup.lib.framework.editor.xbup.EditorXbupModule;
import org.xbup.lib.framework.XBBaseApplication;
import org.xbup.lib.framework.gui.about.api.GuiAboutModuleApi;
import org.xbup.lib.framework.api.XBModuleRepository;
import org.xbup.lib.framework.gui.editor.api.GuiEditorModuleApi;
import org.xbup.lib.framework.gui.frame.api.GuiFrameModuleApi;
import org.xbup.lib.framework.gui.menu.api.GuiMenuModuleApi;
import org.xbup.lib.framework.gui.undo.api.GuiUndoModuleApi;
import org.xbup.lib.framework.gui.options.api.GuiOptionsModuleApi;
import org.xbup.lib.framework.gui.frame.api.ApplicationFrameHandler;
import org.xbup.lib.framework.gui.help.api.GuiHelpModuleApi;
import org.xbup.lib.framework.gui.utils.ActionUtils;
import org.xbup.lib.framework.exbin.ExbinModule;
import org.xbup.lib.framework.exbin.panel.ExbinMainPanel;
import org.xbup.lib.framework.gui.data.api.GuiDataModuleApi;

/**
 * The main class of the ExbinIs application.
 *
 * @version 0.2.0 2016/02/23
 * @author ExBin Project (http://exbin.org)
 */
public class ExbinIs {

    /**
     * Main method launching the application.
     *
     * @param args arguments
     */
    public static void main(String[] args) {
        Preferences preferences;
        boolean verboseMode = false;
        boolean devMode = false;
        final ResourceBundle bundle = ActionUtils.getResourceBundleByClass(ExbinIs.class);

        try {
            preferences = Preferences.userNodeForPackage(ExbinIs.class);
        } catch (SecurityException ex) {
            preferences = null;
        }
        try {
            // Parameters processing
            Options opt = new Options();
            opt.addOption("h", "help", false, bundle.getString("cl_option_help"));
            opt.addOption("v", false, bundle.getString("cl_option_verbose"));
            opt.addOption("dev", false, bundle.getString("cl_option_dev"));
            BasicParser parser = new BasicParser();
            CommandLine cl = parser.parse(opt, args);
            if (cl.hasOption('h')) {
                HelpFormatter f = new HelpFormatter();
                f.printHelp(bundle.getString("cl_syntax"), opt);
            } else {
                verboseMode = cl.hasOption("v");
                devMode = cl.hasOption("dev");
                Logger logger = Logger.getLogger("");
                try {
                    logger.setLevel(Level.ALL);
                    logger.addHandler(new XBHead.XBLogHandler(verboseMode));
                } catch (java.security.AccessControlException ex) {
                    // Ignore it in java webstart
                }

                XBBaseApplication app = new XBBaseApplication();
                app.setAppPreferences(preferences);
                app.setAppBundle(bundle, ActionUtils.getResourceBaseNameBundleByClass(ExbinIs.class));
                app.init();

                XBModuleRepository moduleRepository = app.getModuleRepository();
                moduleRepository.addClassPathPlugins();
                moduleRepository.addPluginsFromManifest(ExbinIs.class);
                moduleRepository.initModules();

                GuiFrameModuleApi frameModule = moduleRepository.getModuleByInterface(GuiFrameModuleApi.class);
                GuiEditorModuleApi editorModule = moduleRepository.getModuleByInterface(GuiEditorModuleApi.class);
                GuiMenuModuleApi menuModule = moduleRepository.getModuleByInterface(GuiMenuModuleApi.class);
                GuiAboutModuleApi aboutModule = moduleRepository.getModuleByInterface(GuiAboutModuleApi.class);
                GuiHelpModuleApi helpModule = moduleRepository.getModuleByInterface(GuiHelpModuleApi.class);
                GuiUndoModuleApi undoModule = moduleRepository.getModuleByInterface(GuiUndoModuleApi.class);
                GuiDataModuleApi dataModule = moduleRepository.getModuleByInterface(GuiDataModuleApi.class);
                GuiOptionsModuleApi optionsModule = moduleRepository.getModuleByInterface(GuiOptionsModuleApi.class);
                ExbinModule exbinModule = moduleRepository.getModuleByInterface(ExbinModule.class);
                EditorXbupModule xbupEditorModule = moduleRepository.getModuleByInterface(EditorXbupModule.class);
                final EditorTextModule textEditorModule = moduleRepository.getModuleByInterface(EditorTextModule.class);

                aboutModule.registerDefaultMenuItem();
//                try {
//                    helpModule.setHelpUrl(new URL(bundle.getString("online_help_url")));
//                } catch (MalformedURLException ex) {
//                    Logger.getLogger(ExbinIs.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                helpModule.registerOnlineHelpMenu();

                frameModule.registerExitAction();
                frameModule.registerBarsVisibilityActions();

//                undoModule.registerMainMenu();
//                undoModule.registerMainToolBar();
//                undoModule.registerUndoManagerInMainMenu();
//                XBTLinearUndo linearUndo = new XBTLinearUndo(null);
////                linearUndo.addUndoUpdateListener(new UndoUpdateListener() {
////                    @Override
////                    public void undoChanged() {
////                        ((AudioPanel) waveEditorModule.getEditorProvider()).repaint();
////                    }
////                });
//                undoModule.setUndoHandler(linearUndo);
                // Register clipboard editing actions
                menuModule.registerMenuClipboardActions();

                optionsModule.registerMenuAction();

                ApplicationFrameHandler frameHandler = frameModule.getFrameHandler();
                // xbupEditorModule.registerStatusBar();
                // xbupEditorModule.registerOptionsPanels();

                exbinModule.setPreferences(preferences);
                ExbinMainPanel mainPanel = exbinModule.getExbinMainPanel();
                mainPanel.setPanel(dataModule.getTableEditPanel());
                frameHandler.setMainPanel(mainPanel);
                frameHandler.setDefaultSize(new Dimension(600, 400));
                frameHandler.show();

                exbinModule.openConnectionDialog();

                List fileArgs = cl.getArgList();
                if (fileArgs.size() > 0) {
                    // TODO app.loadFromFile((String) fileArgs.get(0));
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(ExbinIs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
