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
package org.xbup.lib.catalog.entity.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.xbup.lib.catalog.XBECatalog;
import org.xbup.lib.core.catalog.base.XBCBase;

/**
 * Default manager for catalog items.
 *
 * @version 0.2.0 2016/02/20
 * @author ExBin Project (http://exbin.org)
 * @param <T> entity class
 */
public class XBEDefaultCatalogManager<T extends XBCBase> extends XBEDefaultManager<T> {

    @Autowired
    protected XBECatalog catalog;

    public XBEDefaultCatalogManager() {
    }

    public XBEDefaultCatalogManager(XBECatalog catalog) {
        super(catalog.getEntityManager());
        this.catalog = catalog;
    }
}
