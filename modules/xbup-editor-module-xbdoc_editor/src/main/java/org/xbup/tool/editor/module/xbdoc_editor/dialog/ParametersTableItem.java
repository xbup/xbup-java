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
package org.xbup.tool.editor.module.xbdoc_editor.dialog;

import org.xbup.lib.core.catalog.base.XBCSpecDef;
import org.xbup.lib.core.catalog.base.XBCSpecDefType;
import static org.xbup.lib.core.catalog.base.XBCSpecDefType.CONS;
import static org.xbup.lib.core.catalog.base.XBCSpecDefType.JOIN;
import static org.xbup.lib.core.catalog.base.XBCSpecDefType.LIST_CONS;
import static org.xbup.lib.core.catalog.base.XBCSpecDefType.LIST_JOIN;
import org.xbup.lib.plugin.XBLineEditor;

/**
 * Parameters list table item record.
 *
 * @version 0.1.24 2015/01/10
 * @author XBUP Project (http://xbup.org)
 */
public class ParametersTableItem {

    private XBCSpecDef specDef;
    private String valueName;
    private String typeName;
    private XBLineEditor lineEditor;

    public ParametersTableItem(XBCSpecDef specDef, String valueName, String typeName, XBLineEditor lineEditor) {
        this.specDef = specDef;
        this.valueName = valueName;
        this.typeName = typeName;
        this.lineEditor = lineEditor;
    }

    public ParametersTableItem(XBCSpecDef specDef, String name, String type) {
        this(specDef, name, type, null);
    }

    public XBCSpecDef getSpecDef() {
        return specDef;
    }

    public void setSpecDef(XBCSpecDef spec) {
        this.specDef = spec;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public XBLineEditor getLineEditor() {
        return lineEditor;
    }

    public void setLineEditor(XBLineEditor lineEditor) {
        this.lineEditor = lineEditor;
    }

    public String getDefTypeName() {
        String defTypeName = "";
        if (specDef.getTarget() == null) {
            switch (specDef.getType()) {
                case CONS:
                case LIST_CONS: {
                    defTypeName = "Any";
                    break;
                }
                case JOIN:
                case LIST_JOIN: {
                    defTypeName = "Attribute";
                    break;
                }
            }
        } else {
            defTypeName = typeName;
        }
        if (specDef.getType() == XBCSpecDefType.LIST_CONS || specDef.getType() == XBCSpecDefType.LIST_JOIN) {
            defTypeName += "[]";
        }
        
        return defTypeName;
    }
}
