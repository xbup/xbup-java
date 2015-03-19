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
package org.xbup.lib.client.catalog.remote.service;

import org.xbup.lib.client.XBCatalogServiceClient;
import org.xbup.lib.client.catalog.XBRCatalog;
import org.xbup.lib.core.catalog.base.manager.XBCLimiManager;
import org.xbup.lib.core.catalog.base.service.XBCLimiService;
import org.xbup.lib.client.catalog.remote.XBRItemLimi;
import org.xbup.lib.client.catalog.remote.manager.XBRLimiManager;

/**
 * Remote service for XBRItemLimi items.
 *
 * @version 0.1.25 2015/03/19
 * @author XBUP Project (http://xbup.org)
 */
public class XBRLimiService extends XBRDefaultService<XBRItemLimi> implements XBCLimiService<XBRItemLimi> {

    public XBRLimiService(XBRCatalog catalog) {
        super(catalog);
        itemManager = new XBRLimiManager(catalog);
        catalog.addCatalogManager(XBCLimiManager.class, itemManager);
    }

    @Override
    public XBRItemLimi itemConstructor(XBCatalogServiceClient client, long itemId) {
        return new XBRItemLimi(client, itemId);
    }
}
