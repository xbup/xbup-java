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
package org.xbup.tool.xbpeditor;

import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import net.xeoh.plugins.base.util.uri.ClassURI;
import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.xbup.lib.xb.parser.basic.XBHead;
import org.xbup.tool.xbeditor.module.xbpictureeditor.XBPictureEditorModule;
import org.xbup.tool.xbeditorbase.base.XBEditorApplication;
import org.xbup.tool.xbeditorbase.base.XBEditorBase;

/**
 * The main class of the XBPEditor application.
 *
 * @version 0.1 wr22.0 2013/03/10
 * @author XBUP Project (http://xbup.org)
 */
public class XBPEditor extends XBEditorBase {

    private static Preferences preferences;
    private static boolean verboseMode = false;

    public XBPEditor() {
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("org/xbup/tool/xbpeditor/resources/XBPEditor");
        try {
            preferences = Preferences.userNodeForPackage(XBPEditor.class);
        } catch (SecurityException ex) {
            preferences = null;
        }
        try {
            // Parameters processing
            Options opt = new Options();
            opt.addOption("h", "help", false, bundle.getString("cl_option_help"));
            opt.addOption("port", true, bundle.getString("cl_option_port"));
            opt.addOption("ip", true, bundle.getString("cl_option_ip"));
            opt.addOption("v", false, bundle.getString("cl_option_verbose"));
            BasicParser parser = new BasicParser();
            CommandLine cl = parser.parse(opt, args);
            if (cl.hasOption('h')) {
                HelpFormatter f = new HelpFormatter();
                f.printHelp(bundle.getString("cl_syntax"), opt);
            } else {
                verboseMode = cl.hasOption("v");
                Logger logger = Logger.getLogger("");
                try {
                    logger.setLevel(Level.ALL);
                    logger.addHandler(new XBHead.XBLogHandler(verboseMode));
                } catch (java.security.AccessControlException ex) {
                    // Ignore it in java webstart
                }

                XBEditorApplication app = new XBEditorApplication();
                app.setAppMode(true);
                app.setAppPreferences(preferences);
                app.setAppBundle(bundle);

                app.addPlugin(new ClassURI(XBPictureEditorModule.class).toURI());

                String catalogConnection = cl.getOptionValue("ip");
                String port = cl.getOptionValue("port");
                if ((!"".equals(port))&&(port != null)) {
                    catalogConnection += ":" + port;
                }

                List fileArgs = cl.getArgList();
                if (fileArgs.size()>0) {
                    app.loadFromFile((String) fileArgs.get(0));
                }

                app.startup();
            }
        } catch (ParseException ex) {
            Logger.getLogger(XBPEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
