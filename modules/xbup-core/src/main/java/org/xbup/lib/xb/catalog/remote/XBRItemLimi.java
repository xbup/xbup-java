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

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xbup.lib.xb.catalog.base.XBCItemLimi;
import org.xbup.lib.xb.catalog.base.XBCLimitSpec;
import org.xbup.lib.xb.catalog.client.XBCatalogServiceClient;
import org.xbup.lib.xb.catalog.client.XBCatalogServiceMessage;
import org.xbup.lib.xb.parser.XBProcessingException;
import org.xbup.lib.xb.parser.basic.XBListener;
import org.xbup.lib.xb.remote.XBServiceClient;
import org.xbup.lib.xb.stream.XBStreamChecker;
import org.xbup.lib.xb.ubnumber.type.UBNat32;

/**
 *
 * @version 0.1 wr18.0 2009/12/23
 * @author XBUP Project (http://xbup.org)
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
        try {
            XBCatalogServiceMessage message = client.executeProcedure(XBServiceClient.OWNER_ITEM_PROCEDURE);
            XBListener listener = message.getXBOutput();
            listener.attribXB(new UBNat32(getId()));
            listener.endXB();
            XBStreamChecker checker = message.getXBInput();
            long ownerId = checker.attribXB().getLong();
            checker.endXB();
            message.close();
            if (ownerId == 0) {
                return null;
            }
            return new XBRBlockSpec(client, ownerId);
        } catch (XBProcessingException ex) {
            Logger.getLogger(XBRItem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XBRItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public XBCLimitSpec getTarget() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Long getXBIndex() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
