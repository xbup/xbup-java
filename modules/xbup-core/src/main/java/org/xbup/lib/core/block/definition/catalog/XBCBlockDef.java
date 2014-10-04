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
package org.xbup.lib.core.block.definition.catalog;

import java.util.List;
import org.xbup.lib.core.block.XBTBlock;
import org.xbup.lib.core.block.declaration.catalog.XBCBlockDecl;
import org.xbup.lib.core.block.definition.XBBlockDef;
import org.xbup.lib.core.block.definition.local.XBDRevisionDef;
import org.xbup.lib.core.block.param.XBDParamDecl;
import org.xbup.lib.core.block.param.XBParamDecl;
import org.xbup.lib.core.catalog.XBCatalog;
import org.xbup.lib.core.catalog.base.XBCBlockRev;
import org.xbup.lib.core.catalog.base.XBCSpecDef;
import org.xbup.lib.core.catalog.base.service.XBCSpecService;
import org.xbup.lib.core.parser.param.XBParamPosition;
import org.xbup.lib.core.serial.XBSerializable;

/**
 * XBUP level 1 block definition.
 *
 * @version 0.1.24 2014/10/02
 * @author XBUP Project (http://xbup.org)
 */
public class XBCBlockDef implements XBBlockDef, XBSerializable {

    private final XBCatalog catalog;
    private final XBCBlockRev blockSpecRev;

    public XBCBlockDef(XBCatalog catalog, XBCBlockRev blockSpecRev) {
        this.catalog = catalog;
        this.blockSpecRev = blockSpecRev;
    }

    @Override
    public List<XBDRevisionDef> getRevisionDefs() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public XBTBlock getParameter(XBTBlock block, int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getParametersCount(XBTBlock block) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public XBParamPosition getParamPosition(XBSerializable source, int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public XBParamDecl getParamDecl(int index) {
        XBCSpecService specService = (XBCSpecService) catalog.getCatalogService(XBCSpecService.class);
        XBCSpecDef specDef = specService.getSpecDefByOrder(blockSpecRev.getParent(), index);
        return new XBDParamDecl(new XBCBlockDecl((XBCBlockRev) specDef.getTarget(), catalog));
    }

    @Override
    public List<XBParamDecl> getParamDecls() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public long getParamCount() {
        return blockSpecRev.getXBLimit();
    }
}
