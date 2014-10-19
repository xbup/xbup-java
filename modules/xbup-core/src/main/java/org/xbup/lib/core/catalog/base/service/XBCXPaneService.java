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
import org.xbup.lib.core.catalog.base.XBCBlockRev;
import org.xbup.lib.core.catalog.base.XBCXBlockPane;
import org.xbup.lib.core.catalog.base.XBCXPlugPane;
import org.xbup.lib.core.catalog.base.XBCXPlugin;
import org.xbup.lib.core.catalog.base.XBCExtension;

/**
 * Interface for XBCXBlockPane items service.
 *
 * @version 0.1.24 2014/10/19
 * @author XBUP Project (http://xbup.org)
 * @param <T> block panel editor entity
 */
public interface XBCXPaneService<T extends XBCXBlockPane> extends XBCService<T>, XBCExtension {

    /**
     * Get list of all binds for given revision.
     *
     * @param revision revision
     * @return list of block panel editors
     */
    public List<XBCXBlockPane> getPanes(XBCBlockRev revision);

    /**
     * Get count of panel editors for given revision.
     *
     * @param revision
     * @return count of panel editors
     */
    public long getPanesCount(XBCBlockRev revision);

    /**
     * Get panel editor for given revision and priority.
     *
     * @param revision revision
     * @param priority priority
     * @return block panel editor
     */
    public XBCXBlockPane findPaneByPR(XBCBlockRev revision, long priority);

    /**
     * Find block panel editor by ID.
     *
     * @param id id
     * @return block panel editor
     */
    public XBCXBlockPane findById(long id);

    /**
     * Find panel editor plugin by ID.
     *
     * @param id id
     * @return panel editor plugin
     */
    public XBCXPlugPane findPlugPaneById(long id);

    /**
     * Get count of all block panel editors.
     *
     * @return count of block panel editors
     */
    public Long getAllPanesCount();

    /**
     * Get list of all plugin editor panels for given plugin.
     *
     * @param plugin plugin
     * @return list of plugin editor panels
     */
    public List<XBCXPlugPane> getPlugPanes(XBCXPlugin plugin);

    /**
     * Get count of panel editors for given plugin.
     *
     * @param plugin plugin
     * @return count of plugin editor panels
     */
    public long getPlugPanesCount(XBCXPlugin plugin);

    /**
     * Get editor panel plugin for given plugin and order index.
     *
     * @param plugin
     * @param pane editor panel order index
     * @return editor panel plugin
     */
    public XBCXPlugPane getPlugPane(XBCXPlugin plugin, long pane);

    /**
     * Get count of editor panel plugins.
     *
     * @return count of editor panel plugins
     */
    public Long getAllPlugPanesCount();
}
