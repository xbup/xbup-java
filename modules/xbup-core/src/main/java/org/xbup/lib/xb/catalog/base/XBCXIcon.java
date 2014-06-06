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
 * Interface for catalog item icon entity.
 *
 * @version 0.1 wr21.0 2011/12/29
 * @author XBUP Project (http://xbup.org)
 */
public interface XBCXIcon extends XBCBase {

    /**
     * Get XB Index.
     *
     * @return the XB Index
     */
    public Long getXBIndex();

    /**
     * Get parent.
     *
     * @return the parent item.
     */
    public XBCItem getParent();

    /**
     * Get icon mode.
     *
     * @return icon mode
     */
    public XBCXIconMode getMode();

    /**
     * Get icon file.
     *
     * @return icon file
     */
    public XBCXFile getIconFile();
}
