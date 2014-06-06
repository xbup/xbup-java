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
package org.xbup.lib.xb.catalog.remote.manager;

import java.io.InputStream;
import java.util.ArrayList;
import org.xbup.lib.xb.catalog.XBRCatalog;
import org.xbup.lib.xb.catalog.base.XBCNode;
import org.xbup.lib.xb.catalog.base.XBCXPlugin;
import org.xbup.lib.xb.catalog.base.manager.XBCXPlugManager;
import org.xbup.lib.xb.catalog.remote.XBRXPlugin;

/**
 * Manager class for XBRXPlugin catalog items.
 *
 * @version 0.1 wr21.0 2011/12/31
 * @author XBUP Project (http://xbup.org)
 */
public class XBRXPlugManager extends XBRDefaultManager<XBRXPlugin> implements XBCXPlugManager<XBRXPlugin> {

    public XBRXPlugManager(XBRCatalog catalog) {
        super(catalog);
    }

    @Override
    public Long getAllPluginCount() {
        throw new UnsupportedOperationException("Not supported yet.");
/*        try {
            XBCatalogServiceMessage message = client.executeProcedure(XBServiceClient.SPECSCOUNT_SPEC_PROCEDURE);
            XBListener listener = message.getXBOutput();
            listener.endXB();
            XBStreamChecker checker = message.getXBInput();
            Long index = checker.attribXB().getLong();
            checker.endXB();
            message.close();
            return index;
        } catch (XBProcessingException ex) {
            Logger.getLogger(XBRItem.class.getExtensionName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XBRItem.class.getExtensionName()).log(Level.SEVERE, null, ex);
        }
        return null; */
    }

    @Override
    public Long[] getPluginXBPath(XBCXPlugin plugin) {
        ArrayList<Long> list = new ArrayList<Long>();
        XBCNode parent = plugin.getOwner();
        while (parent != null) {
            if (parent.getParent() != null) {
                if (parent.getXBIndex() == null) {
                    return null;
                }
                list.add(0, parent.getXBIndex());
            }
            parent = (XBCNode) parent.getParent();
        }
        list.add(plugin.getId());
        return (Long[]) list.toArray(new Long[list.size()]);
    }

    @Override
    public XBRXPlugin findById(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public InputStream getPlugin(XBCXPlugin plugin) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public XBRXPlugin findPlugin(XBCNode node, Long index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void initializeExtension() {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getExtensionName() {
        return "Plugin Extension";
    }
}
