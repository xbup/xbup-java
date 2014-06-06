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
package org.xbup.lib.xbplugin;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.xeoh.plugins.base.PluginManager;
import net.xeoh.plugins.base.impl.PluginManagerFactory;
import net.xeoh.plugins.base.options.GetPluginOption;
import net.xeoh.plugins.base.options.getplugin.OptionPluginSelector;
import net.xeoh.plugins.base.options.getplugin.PluginSelector;
import net.xeoh.plugins.base.util.PluginManagerUtil;
import org.xbup.lib.xb.catalog.XBACatalog;
import org.xbup.lib.xb.catalog.base.XBCXFile;
import org.xbup.lib.xb.catalog.base.XBCXPlugin;
import org.xbup.lib.xb.catalog.base.XBCXStri;
import org.xbup.lib.xb.catalog.base.service.XBCXFileService;
import org.xbup.lib.xb.catalog.base.service.XBCXStriService;
import org.xbup.lib.xb.util.CopyStreamUtils;

/**
 * XBUP Transformation Plugin Base Class.
 *
 * @version 0.1 wr21.0 2011/12/31
 * @author XBUP Project (http://xbup.org)
 */
public class XBPluginRepository {

    private PluginManager pluginManager;
    private Map<Long, XBPlugin> plugins;
    private XBACatalog catalog;

    public XBPluginRepository() {
        plugins = new HashMap<Long, XBPlugin>();
        pluginManager = PluginManagerFactory.createPluginManager();
    }

    public void addPluginsFrom(URI uri) {
        pluginManager.addPluginsFrom(uri);

    }

    public void processPlugins() {
        PluginManagerUtil pmu = new PluginManagerUtil(pluginManager);
        final Collection<XBPlugin> pluginCol = pmu.getPlugins(XBPlugin.class);

        if (catalog != null) {
//            for (final XBPlugin plugin : pluginCol) {
//                catalog.ge
//                plugins.put(new Long(0), plugin);
//            }
        }
    }

    /**
     * @return the catalog
     */
    public XBACatalog getCatalog() {
        return catalog;
    }

    /**
     * @param catalog the catalog to set
     */
    public void setCatalog(XBACatalog catalog) {
        this.catalog = catalog;
    }

    public XBPlugin getPluginHandler(XBCXPlugin plugin) {
        // TODO: Use local files if available
        // TODO: Use repository cache if available
        XBCXFile plugFile = plugin.getPluginFile();
        if (plugFile == null) {
            return null;
        }
        XBCXStriService striService = (XBCXStriService) catalog.getCatalogService(XBCXStriService.class);
        if (plugins.containsKey(plugFile.getId())) {
            return (XBPlugin) plugins.get(plugFile.getId());
        }
        XBCXFileService fileService = (XBCXFileService) catalog.getCatalogService(XBCXFileService.class);
        XBCXStri stri = striService.getItemStringId(plugFile.getNode());
        String filePath = striService.getFullPath(stri);
        filePath += "/" + plugFile.getFilename();
        InputStream iStream = fileService.getFile(plugFile);
        // TODO: Download file and load plugin
        java.io.File tmpFile = null;
        try {
            tmpFile = java.io.File.createTempFile("jspfplugindownload", ".jar");
            FileOutputStream oStream = new FileOutputStream(tmpFile);
            CopyStreamUtils.copyInputStreamToOutputStream(iStream, oStream);
            iStream.close();
            oStream.close();
        } catch (IOException ex) {
            Logger.getLogger(XBPluginRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (tmpFile == null) {
            return null;
        }
        pluginManager.addPluginsFrom(tmpFile.getAbsoluteFile().toURI());
        GetPluginOption plugOpt = new OptionPluginSelector<XBPlugin>(new XBPluginSelector(filePath));
        return (XBPlugin) pluginManager.getPlugin(XBPlugin.class, plugOpt);
    }

    public class XBPluginSelector implements PluginSelector<XBPlugin> {

        private String filePath;

        public XBPluginSelector(String filePath) {
            this.filePath = filePath;
        }

        @Override
        public boolean selectPlugin(XBPlugin plugin) {
            System.out.println("Plugin filename:" + filePath);
            String plugPath = "/" + plugin.getPluginPath();
            if (plugPath == null) {
                return false;
            }
            return plugPath.equals(filePath);
        }
    }
}
