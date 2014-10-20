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
package org.xbup.lib.core.catalog.base.manager;

import org.xbup.lib.core.catalog.base.XBCTran;

/**
 * Interface for XBCTran catalog manager.
 *
 * @version 0.1.21 2011/12/29
 * @author XBUP Project (http://xbup.org)
 * @param <T> transformation entity
 */
public interface XBCTranManager<T extends XBCTran> extends XBCCatalogManager<T> {

    /**
     * Gets count of all transformations.
     *
     * @return count of transformations
     */
    public Long getAllItemsCount();
}
