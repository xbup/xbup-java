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
package org.exbin.xbup.core.catalog.base.service;

import java.util.List;
import org.exbin.xbup.core.block.declaration.catalog.XBCBlockDecl;
import org.exbin.xbup.core.block.declaration.catalog.XBCFormatDecl;
import org.exbin.xbup.core.block.declaration.catalog.XBCGroupDecl;
import org.exbin.xbup.core.block.declaration.local.XBLBlockDecl;
import org.exbin.xbup.core.block.declaration.local.XBLFormatDecl;
import org.exbin.xbup.core.block.declaration.local.XBLGroupDecl;
import org.exbin.xbup.core.block.definition.XBParamType;
import org.exbin.xbup.core.catalog.base.XBCBlockSpec;
import org.exbin.xbup.core.catalog.base.XBCFormatSpec;
import org.exbin.xbup.core.catalog.base.XBCGroupSpec;
import org.exbin.xbup.core.catalog.base.XBCNode;
import org.exbin.xbup.core.catalog.base.XBCSpec;
import org.exbin.xbup.core.catalog.base.XBCSpecDef;

/**
 * Interface for XBCSpec items service.
 *
 * @version 0.1.25 2015/02/20
 * @author ExBin Project (http://exbin.org)
 * @param <T> specification entity
 */
public interface XBCSpecService<T extends XBCSpec> extends XBCService<T> {

    /**
     * Returns path of XBIndexes for given node.
     *
     * @param spec specifications
     * @return catalog path
     */
    Long[] getSpecXBPath(XBCSpec spec);

    /**
     * Gets list of specifications.
     *
     * @param node parent node
     * @return list of specifications
     */
    List<XBCSpec> getSpecs(XBCNode node);

    /**
     * Gets list of specifications.
     *
     * @param node parent node
     * @param index order index
     * @return specification
     */
    XBCSpec getSpecByOrder(XBCNode node, long index);

    /**
     * Returns format specification of given order index.
     *
     * @param node parent node
     * @param index order index
     * @return specification
     */
    XBCFormatSpec getFormatSpec(XBCNode node, long index);

    /**
     * Gets list of format specifications.
     *
     * @param node parent node
     * @return list of specifications
     */
    List<XBCFormatSpec> getFormatSpecs(XBCNode node);

    /**
     * Returns block specification of given order index.
     *
     * @param node parent node
     * @param index order index
     * @return specification
     */
    XBCBlockSpec getBlockSpec(XBCNode node, long index);

    /**
     * Gets list of block specifications.
     *
     * @param node parent node
     * @return list of specifications
     */
    List<XBCBlockSpec> getBlockSpecs(XBCNode node);

    /**
     * Returns group specification of given order index.
     *
     * @param node parent node
     * @param index order index
     * @return specification
     */
    XBCGroupSpec getGroupSpec(XBCNode node, long index);

    /**
     * Gets list of group specifications.
     *
     * @param node parent node
     * @return list of specifications
     */
    List<XBCGroupSpec> getGroupSpecs(XBCNode node);

    /**
     * Finds block specification by XB index.
     *
     * @param node parent node
     * @param xbIndex XB index
     * @return specification
     */
    XBCBlockSpec findBlockSpecByXB(XBCNode node, long xbIndex);

    /**
     * Finds maximum XB index of block specifications for given node.
     *
     * @param node parent node
     * @return maximum XB index
     */
    Long findMaxBlockSpecXB(XBCNode node);

    /**
     * Finds group specification by XB index.
     *
     * @param node parent node
     * @param xbIndex XB index
     * @return specification
     */
    XBCGroupSpec findGroupSpecByXB(XBCNode node, long xbIndex);

    /**
     * Finds maximum XB index of group specifications for given node.
     *
     * @param node parent node
     * @return maximum XB index
     */
    Long findMaxGroupSpecXB(XBCNode node);

    /**
     * Finds format specification by XB index.
     *
     * @param node parent node
     * @param xbIndex XB index
     * @return specification
     */
    XBCFormatSpec findFormatSpecByXB(XBCNode node, long xbIndex);

    /**
     * Finds maximum XB index of format specifications for given node.
     *
     * @param node parent node
     * @return maximum XB index
     */
    Long findMaxFormatSpecXB(XBCNode node);

    /**
     * Gets count of specification definitions.
     *
     * @return count of definition rows.
     */
    long getDefsCount();

    /**
     * Gets specification's definition of given order index.
     *
     * @param spec specification
     * @param index order index
     * @return specification's definition
     */
    XBCSpecDef getSpecDefByOrder(XBCSpec spec, long index);

    /**
     * Gets specification's definition of given XB index.
     *
     * @param spec specification
     * @param xbIndex XBIndex of given bind
     * @return specification's definition
     */
    XBCSpecDef findSpecDefByXB(XBCSpec spec, long xbIndex);

    /**
     * Gets maximum XB index of specification's definitions.
     *
     * @param spec specification
     * @return maximum XB index
     */
    Long findMaxSpecDefXB(XBCSpec spec);

    /**
     * Gets list of all specification's definitions.
     *
     * @param spec specification
     * @return list of specification's definitions
     */
    List<XBCSpecDef> getSpecDefs(XBCSpec spec);

    /**
     * Returns count of specification's definitions.
     *
     * @param spec specification
     * @return count of specification's definitions
     */
    long getSpecDefsCount(XBCSpec spec);

    /**
     * Gets specification's definition.
     *
     * @param itemId item id
     * @return specification's definition
     */
    XBCSpecDef getSpecDef(long itemId);

    /**
     * Creates new instance of block specification definition.
     *
     * @param spec specification
     * @param type specification definition's type
     * @return specification definition
     */
    XBCSpecDef createSpecDef(XBCSpec spec, XBParamType type);

    /**
     * Creates new instance of block specification.
     *
     * @return specification
     */
    XBCBlockSpec createBlockSpec();

    /**
     * Creates new instance of group specification.
     *
     * @return specification
     */
    XBCGroupSpec createGroupSpec();

    /**
     * Creates new instance of format specification.
     *
     * @return specification
     */
    XBCFormatSpec createFormatSpec();

    /**
     * Gets count of format specifications for given node.
     *
     * @param node parent node
     * @return count of specifications
     */
    long getFormatSpecsCount(XBCNode node);

    /**
     * Gets count of group specifications for given node.
     *
     * @param node parent node
     * @return count of specifications
     */
    long getGroupSpecsCount(XBCNode node);

    /**
     * Gets count of block specifications for given node.
     *
     * @param node parent node
     * @return count of specifications
     */
    long getBlockSpecsCount(XBCNode node);

    /**
     * Gets count of specifications for given node.
     *
     * @param node parent node
     * @return count of specifications
     */
    long getSpecsCount(XBCNode node);

    /**
     * Gets count of all specifications in catalog.
     *
     * @return count of specifications
     */
    Long getAllSpecsCount();

    /**
     * Gets count of all format specifications in catalog.
     *
     * @return count of specifications
     */
    Long getAllFormatSpecsCount();

    /**
     * Gets count of all group specifications in catalog.
     *
     * @return count of specifications
     */
    Long getAllGroupSpecsCount();

    /**
     * Gets count of all block specifications in catalog.
     *
     * @return count of specifications
     */
    Long getAllBlockSpecsCount();

    /**
     * Removes specification definition with all dependencies.
     *
     * @param specDef definition to remove
     */
    void removeItemDepth(XBCSpecDef specDef);

    /**
     * Converts catalog format declaration to local declaration with definition.
     *
     * @param formatDecl format specification
     * @return local format declaration
     */
    XBLFormatDecl getFormatDeclAsLocal(XBCFormatDecl formatDecl);

    /**
     * Converts catalog group declaration to local declaration with definition.
     *
     * @param groupDecl group specification
     * @return local group declaration
     */
    XBLGroupDecl getGroupDeclAsLocal(XBCGroupDecl groupDecl);

    /**
     * Converts catalog block declaration to local declaration with definition.
     *
     * @param blockDecl block specification
     * @return local block declaration
     */
    XBLBlockDecl getBlockDeclAsLocal(XBCBlockDecl blockDecl);
}
