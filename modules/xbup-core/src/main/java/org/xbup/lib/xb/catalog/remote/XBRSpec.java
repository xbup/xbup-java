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
package org.xbup.lib.xb.catalog.remote;

import org.xbup.lib.xb.catalog.base.XBCSpec;
import org.xbup.lib.xb.catalog.client.XBCatalogServiceClient;

/**
 *
 * @version 0.1 wr22.0 2012/12/12
 * @author XBUP Project (http://xbup.org)
 */
public class XBRSpec extends XBRItem implements XBCSpec {

    public XBRSpec(XBCatalogServiceClient client, long id) {
        super(client,id);
    }

    @Override
    public XBRNode getParent() {
        XBRItem item = super.getParent();
        if (item == null) {
            return null;
        }
        return new XBRNode(item.client,item.getId());
    }
}
