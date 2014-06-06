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
package org.xbup.lib.xb.catalog;

import java.util.List;
import org.xbup.lib.xb.block.declaration.XBBlockDecl;
import org.xbup.lib.xb.block.declaration.XBContext;
import org.xbup.lib.xb.block.declaration.XBFormatDecl;
import org.xbup.lib.xb.block.declaration.XBGroupDecl;
import org.xbup.lib.xb.catalog.base.XBCBase;
import org.xbup.lib.xb.catalog.base.XBCFormatSpec;
import org.xbup.lib.xb.catalog.base.XBCGroupSpec;
import org.xbup.lib.xb.catalog.base.manager.XBCManager;
import org.xbup.lib.xb.catalog.base.service.XBCService;

/**
 * Interface for XBUP level 1 catalog.
 *
 * @version 0.1 wr23.0 2014/03/17
 * @author XBUP Project (http://xbup.org)
 */
public interface XBCatalog {

    /**
     * Returns a processing context for empty document.
     *
     * @return block types processing context
     */
    public XBContext getRootContext();

    /**
     * Returns a type of block for given XB Path.
     *
     * @param xbCatalogPath a path in catalog using xbIndexes
     * @return block type declaration for given catalog or null if traversal
     * fails
     */
    public XBBlockDecl findBlockTypeByPath(Long[] xbCatalogPath);

    /**
     * Returns a group type for given XB Path.
     *
     * @param xbCatalogPath a path in catalog using xbIndexes
     * @return group Type for given catalog or null if fails
     */
    public XBGroupDecl findGroupTypeByPath(Long[] xbCatalogPath);

    /**
     * Returns a format type for given XB Path.
     *
     * @param xbCatalogPath a path in catalog using xbIndexes
     * @return format Type for given catalog or null if fails
     */
    public XBFormatDecl findFormatTypeByPath(Long[] xbCatalogPath);

    /**
     * Returns list of binded specifications for given format specification for
     * processing context.
     *
     * @param spec a format specification
     * @return list of group specifications
     */
    List<XBGroupDecl> getGroups(XBCFormatSpec spec);

    /**
     * Returns list of binded specifications for given group specification for
     * processing context.
     *
     * @param spec a group specification
     * @return list of block specifications
     */
    List<XBBlockDecl> getBlocks(XBCGroupSpec spec);

    /**
     * Returns catalog service of given type.
     *
     * @param type a class for desired instance of catalog service
     * @return service
     */
    public XBCService<? extends XBCBase> getCatalogService(Class type);

    /**
     * Returns catalog manager of given type.
     *
     * @param type a class for desired instance of catalog manager
     * @return manager
     */
    public XBCManager<? extends XBCBase> getCatalogManager(Class type);

    /**
     * Returns list of catalog services.
     *
     * @return list of all catalog extensions
     */
    public List<XBCService<? extends XBCBase>> getCatalogServices();

    /**
     * Returns list of catalog managers.
     *
     * @return list of all catalog extensions
     */
    public List<XBCManager<? extends XBCBase>> getCatalogManagers();

    /**
     * Add catalog manager to catalog repository.
     *
     * Should be used only for internal purposes.
     *
     * @param type type of extension
     * @param ext instance of extension, must implement XBCExtension
     */
    public void addCatalogManager(Class type, XBCManager<? extends XBCBase> ext);

    /**
     * Add catalog service to catalog repository.
     *
     * @param type type of extension
     * @param ext instance of extension, must implement XBCExtension
     */
    public void addCatalogService(Class type, XBCService<? extends XBCBase> ext);
}
