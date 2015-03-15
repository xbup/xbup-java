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
package org.xbup.lib.client.stub;

import java.util.List;
import org.xbup.lib.client.XBCatalogServiceClient;
import org.xbup.lib.client.catalog.remote.XBRItem;
import org.xbup.lib.client.catalog.remote.XBRXFile;
import org.xbup.lib.client.catalog.remote.XBRXIcon;
import org.xbup.lib.client.catalog.remote.XBRXIconMode;
import org.xbup.lib.core.block.declaration.XBDeclBlockType;
import org.xbup.lib.core.catalog.base.XBCItem;
import org.xbup.lib.core.catalog.base.XBCXFile;
import org.xbup.lib.core.catalog.base.XBCXIconMode;

/**
 * RPC stub class for XBRXIcon catalog items.
 *
 * @version 0.1.25 2015/03/15
 * @author XBUP Project (http://xbup.org)
 */
public class XBPXIconStub implements XBPManagerStub<XBRXIcon> {

    public static long[] OWNER_ICON_PROCEDURE = {0, 2, 13, 0, 0};
    public static long[] MODE_ICON_PROCEDURE = {0, 2, 13, 1, 0};
    public static long[] XBINDEX_ICON_PROCEDURE = {0, 2, 13, 2, 0};
    public static long[] DEFAULTITEM_ICON_PROCEDURE = {0, 2, 13, 3, 0};
    public static long[] FILE_ICON_PROCEDURE = {0, 2, 13, 4, 0};

    private final XBCatalogServiceClient client;

    public XBPXIconStub(XBCatalogServiceClient client) {
        this.client = client;
    }

    public XBRItem getParent(long iconId) {
        Long index = XBPStubUtils.longToLongMethod(client.procedureCall(), new XBDeclBlockType(OWNER_ICON_PROCEDURE), iconId);
        return index == null ? null : new XBRItem(client, index);
    }

    public XBCXIconMode getMode(long iconId) {
        Long index = XBPStubUtils.longToLongMethod(client.procedureCall(), new XBDeclBlockType(MODE_ICON_PROCEDURE), iconId);
        return index == null ? null : new XBRXIconMode(client, index);
    }

    public XBCXFile getIconFile(long iconId) {
        Long index = XBPStubUtils.longToLongMethod(client.procedureCall(), new XBDeclBlockType(FILE_ICON_PROCEDURE), iconId);
        return index == null ? null : new XBRXFile(client, index);
    }

    public XBRXIcon getDefaultIcon(XBCItem item) {
        Long index = XBPStubUtils.longToLongMethod(client.procedureCall(), new XBDeclBlockType(DEFAULTITEM_ICON_PROCEDURE), item.getId());
        return index == null ? null : new XBRXIcon(client, index);
    }

    @Override
    public XBRXIcon createItem() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void persistItem(XBRXIcon item) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removeItem(XBRXIcon item) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public XBRXIcon getItem(long itemId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<XBRXIcon> getAllItems() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public long getItemsCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
