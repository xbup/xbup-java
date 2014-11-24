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
package org.xbup.tool.editor.module.service_manager.catalog.panel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.xbup.lib.core.catalog.XBACatalog;
import org.xbup.lib.core.catalog.base.XBCBlockCons;
import org.xbup.lib.core.catalog.base.XBCBlockJoin;
import org.xbup.lib.core.catalog.base.XBCBlockListCons;
import org.xbup.lib.core.catalog.base.XBCBlockListJoin;
import org.xbup.lib.core.catalog.base.XBCConsDef;
import org.xbup.lib.core.catalog.base.XBCItem;
import org.xbup.lib.core.catalog.base.XBCJoinDef;
import org.xbup.lib.core.catalog.base.XBCSpec;
import org.xbup.lib.core.catalog.base.XBCSpecDef;
import org.xbup.lib.core.catalog.base.XBCXName;
import org.xbup.lib.core.catalog.base.service.XBCSpecService;
import org.xbup.lib.core.catalog.base.service.XBCXDescService;
import org.xbup.lib.core.catalog.base.service.XBCXNameService;
import org.xbup.lib.core.catalog.base.service.XBCXStriService;

/**
 * Table model for catalog bindings.
 *
 * @version 0.1.24 2014/11/17
 * @author XBUP Project (http://xbup.org)
 */
public class CatalogDefsTableModel extends AbstractTableModel {

    private XBACatalog catalog;
    private XBCSpec spec = null;
    private XBCItem catalogItem = null;
    private CatalogRevsTableModel revsModel = null;

    private final List<CatalogDefsTableItem> items = new ArrayList<>();

    private final String[] columnNames = new String[]{"XBIndex", "Revision", "StringId", "Operation", "Type", "Type Revision", "Name", "Description"};
    private final Class[] columnClasses = new Class[]{
        java.lang.Long.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class
    };

    public CatalogDefsTableModel(XBACatalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public int getRowCount() {
        if (spec == null) {
            return 0;
        }
        return items.size();
    }

    @Override
    public int getColumnCount() {
        return columnClasses.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (spec == null) {
            return null;
        }
        CatalogDefsTableItem item = items.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return item.getXbIndex();
            case 1:
                return item.getRevision();
            case 2:
                return item.getStringId();
            case 3:
                return item.getOperation();
            case 4:
                return item.getType();
            case 5:
                return item.getTargetRevision();
            case 6:
                return item.getName();
            case 7:
                return item.getDescription();

            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClasses[columnIndex];
    }

    public List<CatalogDefsTableItem> getDefs() {
        return items;
    }

    public void setCatalogItem(XBCItem item) {
        this.catalogItem = item;
        items.clear();
        if (item instanceof XBCSpec) {
            XBCXNameService nameService = (XBCXNameService) catalog.getCatalogService(XBCXNameService.class);
            XBCXDescService descService = (XBCXDescService) catalog.getCatalogService(XBCXDescService.class);
            XBCXStriService striService = (XBCXStriService) catalog.getCatalogService(XBCXStriService.class);
            XBCSpecService specService = (XBCSpecService) catalog.getCatalogService(XBCSpecService.class);

            spec = (XBCSpec) item;
            List<XBCSpecDef> specDefs = specService.getSpecDefs(spec);
            for (XBCSpecDef specDef : specDefs) {
                CatalogDefsTableItem tableItem = new CatalogDefsTableItem();
                tableItem.setSpecDef(specDef);
                tableItem.setXbIndex(specDef.getXBIndex());
                tableItem.setOperation(getOperation(specDef));
                tableItem.setDefType(specDef.getType());

                tableItem.setType("");
                tableItem.setTargetRevision(0L);
                tableItem.setTarget(specDef.getTarget());
                if (specDef.getTarget() != null) {
                    XBCSpec targetSpec = (XBCSpec) specDef.getTarget().getParent();
                    if (targetSpec != null) {
                        XBCXName name = nameService.getItemName(targetSpec);
                        if (name != null) {
                            tableItem.setType(name.getText());
                        }
                    }

                    tableItem.setTargetRevision(specDef.getTarget().getXBIndex());
                }

                tableItem.setName(nameService.getDefaultText(specDef));
                tableItem.setDescription(descService.getDefaultText(specDef));
                tableItem.setStringId(striService.getItemStringIdText(specDef));

                if (revsModel != null) {
                    tableItem.setRevision(revsModel.getRevisionForIndex(specDef.getXBIndex()));
                }

                items.add(tableItem);
            }
        }

        fireTableDataChanged();
    }

    public String getOperation(XBCSpecDef specDef) {
        String operation;
        if (specDef instanceof XBCBlockJoin) {
            if (specDef.getTarget() == null) {
                operation = "Attribute";
            } else {
                operation = "Join";
            }
        } else if (specDef instanceof XBCBlockCons) {
            if (specDef.getTarget() == null) {
                operation = "Data Block";
            } else {
                operation = "Consist";
            }
        } else if (specDef instanceof XBCBlockListJoin) {
            operation = "Join List";
        } else if (specDef instanceof XBCBlockListCons) {
            operation = "Consist List";
        } else if (specDef instanceof XBCJoinDef) {
            operation = "Join";
        } else if (specDef instanceof XBCConsDef) {
            operation = "Consist";
        } else {
            operation = "Unknown";
        }

        return operation;
    }

    public CatalogDefsTableItem getRowItem(int rowIndex) {
        return items.get(rowIndex);
    }

    public void setCatalog(XBACatalog catalog) {
        this.catalog = catalog;

        if (catalogItem != null) {
            setCatalogItem(catalogItem);
        }
    }

    public void removeItem(XBCSpecDef specDef) {
        for (int i = 0; i < items.size(); i++) {
            CatalogDefsTableItem item = items.get(i);
            if (item.getSpecDef() == specDef) {
                items.remove(item);
                break;
            }
        }
    }

    public void moveItemDown(int itemPos) {
        CatalogDefsTableItem item = items.get(itemPos);
        CatalogDefsTableItem nextItem = items.get(itemPos + 1);
        Long prevIndex = item.getXbIndex();
        item.setXbIndex(nextItem.getXbIndex());
        nextItem.setXbIndex(prevIndex);

        if (revsModel != null) {
            item.setRevision(revsModel.getRevisionForIndex(item.getXbIndex()));
            nextItem.setRevision(revsModel.getRevisionForIndex(nextItem.getXbIndex()));
        }

        items.remove(item);
        items.add(itemPos + 1, item);
    }

    public void setRevsModel(CatalogRevsTableModel revsModel) {
        this.revsModel = revsModel;

        if (catalogItem != null) {
            setCatalogItem(catalogItem);
        }
    }
}
