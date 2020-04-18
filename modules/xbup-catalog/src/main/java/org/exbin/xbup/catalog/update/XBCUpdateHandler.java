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
package org.exbin.xbup.catalog.update;

import org.exbin.xbup.core.block.declaration.XBContext;
import org.exbin.xbup.core.catalog.base.XBCBlockSpec;
import org.exbin.xbup.core.catalog.base.XBCFormatSpec;
import org.exbin.xbup.core.catalog.base.XBCGroupSpec;
import org.exbin.xbup.core.catalog.base.XBCNode;

/**
 * Interface for XB catalog update handler.
 *
 * Provides methods for updating catalog database.
 *
 * @version 0.2.0 2017/01/07
 * @author ExBin Project (http://exbin.org)
 */
public interface XBCUpdateHandler {

    /**
     * Initialize Updater.
     */
    void init();

    XBContext updateTypeSpecFromWS(Long[] path, long specId);

    XBCFormatSpec updateFormatSpec(Long[] path, Long specId);

    XBCGroupSpec updateGroupSpec(Long[] path, Long specId);

    XBCBlockSpec updateBlockSpec(Long[] path, Long specId);

    XBCFormatSpec addFormatSpecFromWS(XBCNode node, Long specId);

    XBCGroupSpec addGroupSpecFromWS(XBCNode node, Long specId);

    XBCBlockSpec addBlockSpecFromWS(XBCNode node, Long specId);

    XBCNode addNodeFromWS(XBCNode node, Long nodeId);

    /**
     * Process all catalog data in given path and subnodes.
     *
     * @param path path
     */
    void processAllData(Long[] path);

    boolean processNodePath(Long[] path);

    void addWSListener(XBCUpdateListener wsl);

    void removeWSListener(XBCUpdateListener wsl);

    void fireUsageEvent(boolean usage);
}
