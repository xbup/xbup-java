/*
 * Copyright (C) ExBin Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.exbin.xbup.client.catalog.remote.service;

import java.io.InputStream;
import org.exbin.xbup.client.catalog.XBRCatalog;
import org.exbin.xbup.client.catalog.remote.XBRXPlugin;
import org.exbin.xbup.client.catalog.remote.manager.XBRXPlugManager;
import org.exbin.xbup.core.catalog.base.XBCExtension;
import org.exbin.xbup.core.catalog.base.XBCNode;
import org.exbin.xbup.core.catalog.base.XBCXPlugin;
import org.exbin.xbup.core.catalog.base.manager.XBCXPlugManager;
import org.exbin.xbup.core.catalog.base.service.XBCXPlugService;

/**
 * Remote service for XBRXPlugin items.
 *
 * @version 0.1.25 2015/03/19
 * @author ExBin Project (http://exbin.org)
 */
public class XBRXPlugService extends XBRDefaultService<XBRXPlugin> implements XBCXPlugService<XBRXPlugin> {

    public XBRXPlugService(XBRCatalog catalog) {
        super(catalog);
        itemManager = new XBRXPlugManager(catalog);
        catalog.addCatalogManager(XBCXPlugManager.class, (XBCXPlugManager) itemManager);
    }

    @Override
    public XBRXPlugin findById(long id) {
        return ((XBRXPlugManager) itemManager).findById(id);
    }

    @Override
    public XBRXPlugin findPlugin(XBCNode node, Long index) {
        return ((XBRXPlugManager) itemManager).findPlugin(node, index);
    }

    @Override
    public Long getAllPluginCount() {
        return ((XBRXPlugManager) itemManager).getAllPluginCount();
    }

    @Override
    public InputStream getPlugin(XBCXPlugin plugin) {
        return ((XBRXPlugManager) itemManager).getPlugin(plugin);
    }

    @Override
    public Long[] getPluginXBPath(XBCXPlugin plugin) {
        return ((XBRXPlugManager) itemManager).getPluginXBPath(plugin);
    }

    @Override
    public String getExtensionName() {
        return ((XBCExtension) itemManager).getExtensionName();
    }

    @Override
    public void initializeExtension() {
        ((XBCExtension) itemManager).initializeExtension();
    }

}
