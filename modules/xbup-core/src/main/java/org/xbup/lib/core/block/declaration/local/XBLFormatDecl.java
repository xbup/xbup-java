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
package org.xbup.lib.core.block.declaration.local;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.xbup.lib.core.block.XBBasicBlockType;
import org.xbup.lib.core.block.XBFixedBlockType;
import org.xbup.lib.core.block.declaration.XBFormatDecl;
import org.xbup.lib.core.block.declaration.XBGroupDecl;
import org.xbup.lib.core.block.definition.XBFormatDef;
import org.xbup.lib.core.block.definition.XBFormatParam;
import org.xbup.lib.core.block.definition.XBFormatParamConsist;
import org.xbup.lib.core.block.definition.XBFormatParamJoin;
import org.xbup.lib.core.block.definition.local.XBLFormatDef;
import org.xbup.lib.core.parser.XBProcessingException;
import org.xbup.lib.core.serial.param.XBPSequenceSerialHandler;
import org.xbup.lib.core.serial.param.XBPSequenceSerializable;
import org.xbup.lib.core.serial.param.XBSerializationMode;

/**
 * XBUP level 1 local format declaration.
 *
 * @version 0.1.24 2015/01/27
 * @author XBUP Project (http://xbup.org)
 */
public class XBLFormatDecl implements XBFormatDecl, XBPSequenceSerializable {

    private long[] catalogPath = null;
    private int revision;
    private XBFormatDef formatDef = null;

    public XBLFormatDecl() {
        catalogPath = null;
        revision = 0;
    }

    public XBLFormatDecl(long[] revisionPath) {
        revision = (int) revisionPath[revisionPath.length - 1];
        catalogPath = Arrays.copyOf(revisionPath, revisionPath.length - 1);
    }

    public XBLFormatDecl(Long[] revisionPath) {
        setCatalogObjectPath(Arrays.copyOf(revisionPath, revisionPath.length - 1));
        revision = revisionPath[revisionPath.length - 1].intValue();
    }

    public XBLFormatDecl(long[] specPath, int revision) {
        this.catalogPath = specPath;
        this.revision = revision;
    }

    public XBLFormatDecl(Long[] specPath, int revision) {
        setCatalogObjectPath(specPath);
        this.revision = revision;
    }

    public XBLFormatDecl(XBFormatDef formatDef) {
        this.formatDef = formatDef;
    }

    public XBLFormatDecl(XBGroupDecl groupDecl) {
        formatDef = new XBLFormatDef(groupDecl);
    }

    public XBLFormatDecl(long[] revisionPath, XBFormatDef formatDef) {
        this(revisionPath);
        this.formatDef = formatDef;
    }

    @Override
    public List<XBGroupDecl> getGroupDecls() {
        List<XBGroupDecl> groups = new ArrayList<>();
        int blocksLimit = getGroupsLimit();
        for (int paramIndex = 0; paramIndex < blocksLimit; paramIndex++) {
            XBFormatParam formatParam = formatDef.getFormatParam(paramIndex);
            if (formatParam instanceof XBFormatParamJoin) {
                XBFormatDecl groupDecl = ((XBFormatParamJoin) formatParam).getFormatDecl();
                groups.addAll(groupDecl.getGroupDecls());
            } else {
                groups.add(((XBFormatParamConsist) formatParam).getGroupDecl());
            }
        }

        return groups;
    }

    public int getGroupsLimit() {
        return formatDef.getRevisionDef().getRevisionLimit(revision);
    }

    private void setCatalogObjectPath(Long[] path) {
        catalogPath = new long[path.length];
        for (int i = 0; i < path.length; i++) {
            catalogPath[i] = path[i];
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Arrays.hashCode(this.catalogPath);
        hash = 47 * hash + this.revision;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof XBLFormatDecl) {
            return Arrays.equals(((XBLFormatDecl) obj).catalogPath, catalogPath) && (((XBLFormatDecl) obj).revision == revision);
        }

        return super.equals(obj);
    }

    @Override
    public void serializeXB(XBPSequenceSerialHandler serializationHandler) throws XBProcessingException, IOException {
        serializationHandler.begin();
        serializationHandler.matchType(new XBFixedBlockType(XBBasicBlockType.FORMAT_DECLARATION));
        if (serializationHandler.getSerializationMode() == XBSerializationMode.PULL) {
            catalogPath = new long[serializationHandler.pullAttribute().getInt()];
            for (int pathPosition = 0; pathPosition < catalogPath.length; pathPosition++) {
                catalogPath[pathPosition] = serializationHandler.pullLongAttribute();
            }
            revision = serializationHandler.pullAttribute().getInt();

            // TODO
            if (formatDef == null) {
                formatDef = new XBLFormatDef();
            }
            // serializationHandler.pullConsist(formatDef);
        } else {
            serializationHandler.putAttribute(catalogPath.length);
            for (long pathIndex : catalogPath) {
                serializationHandler.putAttribute(pathIndex);
            }

            serializationHandler.putAttribute(revision);
            if (formatDef != null) {
                serializationHandler.putConsist(formatDef);
            }
        }
        serializationHandler.end();
    }

    public long[] getCatalogPath() {
        return catalogPath;
    }

    public void setCatalogPath(long[] catalogPath) {
        this.catalogPath = catalogPath;
    }

    public void setCatalogPath(Long[] path) {
        setCatalogObjectPath(path);
    }

    @Override
    public XBFormatDef getFormatDef() {
        return formatDef;
    }

    public void setFormatDef(XBFormatDef formatDef) {
        this.formatDef = formatDef;
    }

    @Override
    public long getRevision() {
        return revision;
    }
}
