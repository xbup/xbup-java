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
package org.xbup.lib.client.catalog.remote;

import org.xbup.lib.core.catalog.base.XBCItemLimi;
import org.xbup.lib.core.catalog.base.XBCLimitSpec;
import org.xbup.lib.client.XBCatalogServiceClient;

/**
 *
 * @version 0.1.18 2009/12/23
 * @author ExBin Project (http://exbin.org)
 */
public class XBRItemLimi implements XBCItemLimi {

    private long id;
    protected XBCatalogServiceClient client;

    public XBRItemLimi(XBCatalogServiceClient client, long id) {
        this.id = id;
        this.client = client;
    }

    @Override
    public XBRBlockSpec getOwner() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public XBCLimitSpec getTarget() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Long getXBIndex() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Long getId() {
        return id;
    }
}
