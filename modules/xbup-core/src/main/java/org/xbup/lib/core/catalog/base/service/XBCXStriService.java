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
package org.xbup.lib.core.catalog.base.service;

import java.util.List;
import org.xbup.lib.core.catalog.base.XBCItem;
import org.xbup.lib.core.catalog.base.XBCSpec;
import org.xbup.lib.core.catalog.base.XBCXStri;
import org.xbup.lib.core.catalog.base.XBCExtension;

/**
 * Interface for XBCXStri items service.
 *
 * @version 0.1.24 2014/11/17
 * @author XBUP Project (http://xbup.org)
 * @param <T> stringId entity
 */
public interface XBCXStriService<T extends XBCXStri> extends XBCService<T>, XBCExtension {

    /**
     * Returns StringId for given item.
     *
     * @param item item
     * @return stringId
     */
    public XBCXStri getItemStringId(XBCItem item);

    /**
     * Returns list of StringIds for given item.
     *
     * @param item item
     * @return list of stringIds
     */
    public List<XBCXStri> getItemStringIds(XBCItem item);

    /**
     * Gets string id text for given item.
     *
     * @param item item to get Stri of
     * @return text or null if Stri is not set
     */
    public String getItemStringIdText(XBCItem item);

    /**
     * Sets string id text for given item.
     *
     * @param item item to set stri for
     * @param text text to set
     */
    public void setItemStringIdText(XBCItem item, String text);

    /**
     * Returns full stringId path including leading slash symbol.
     *
     * @param itemString stringId item
     * @return String representation of the path
     */
    public String getFullPath(XBCXStri itemString);

    /**
     * Returns full stringId path including leading slash symbol.
     *
     * @param item item to get stri of
     * @return string representation of the path
     */
    public String getItemFullPath(XBCItem item);

    /**
     * Gets specification for give full path.
     *
     * @param fullPath fullPath to specification
     * @return specification
     */
    public XBCSpec getSpecByFullPath(String fullPath);
}
