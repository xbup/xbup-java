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
package org.xbup.lib.xb.catalog.base;

/**
 * Interface for catalog user entity.
 *
 * @version 0.1 wr22.0 2012/09/09
 * @author XBUP Project (http://xbup.org)
 */
public interface XBCXUser extends XBCBase {

    /**
     * Get login string.
     *
     * @return the login
     */
    public String getLogin();

    /**
     * Get password string.
     *
     * TODO: Use hash instead
     *
     * @return the passwd
     */
    public String getPasswd();
}
