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
package org.xbup.lib.client;

import java.io.IOException;
import java.net.Socket;
import org.xbup.lib.core.remote.XBServiceClient;

/**
 * Connection client handler for remote catalogs.
 *
 * @version 0.1.25 2015/02/22
 * @author XBUP Project (http://xbup.org)
 */
public interface XBCatalogServiceClient extends XBServiceClient {

    /**
     * Executes remote procedure of XBUP Service
     *
     * @param procedureId procedure identification array
     * @return message handler
     */
    @Deprecated
    public XBCatalogServiceMessage executeProcedure(long[] procedureId);

    public int login(String user, char[] password) throws IOException;

    public String getVersion();

    public void close();

    public void ping();

    public String getHost();

    public int getPort();

    public String getLocalAddress();

    public String getHostAddress();

    public boolean validate();

    public Socket getSocket();
}
