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
package org.xbup.tool.editor.module.xbdoc_editor.panel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import org.xbup.lib.core.block.XBBlockDataMode;
import org.xbup.lib.core.block.XBBlockType;
import org.xbup.lib.core.block.XBFBlockType;
import org.xbup.lib.core.block.declaration.XBBlockDecl;
import org.xbup.lib.core.block.declaration.catalog.XBCBlockDecl;
import org.xbup.lib.core.catalog.XBACatalog;
import org.xbup.lib.core.catalog.base.XBCBlockSpec;
import org.xbup.lib.core.catalog.base.XBCXDesc;
import org.xbup.lib.core.catalog.base.service.XBCXDescService;
import org.xbup.lib.core.catalog.base.service.XBCXNameService;
import org.xbup.lib.parser_tree.XBTTreeNode;
import org.xbup.tool.editor.base.api.utils.WindowUtils;
import org.xbup.tool.editor.module.xbdoc_editor.dialog.ItemPropertiesDialog;

/**
 * Panel for properties of the actual panel.
 *
 * @version 0.1.22 2013/02/27
 * @author XBUP Project (http://xbup.org)
 */
public class XBPropertyPanel extends javax.swing.JPanel {

    private XBACatalog catalog;
    private Thread propertyThread;
    private final Semaphore valueFillingSemaphore;
    private final List<XBCBlockSpec> specList;
    private XBDocumentPanel activePanel;
    // private final XBPropertyTableCellRenderer cellRenderer;
    private final XBPropertyTablePanel propertiesPanel;

    public XBPropertyPanel(XBACatalog catalog) {
        this.catalog = catalog;

        initComponents();

        propertiesPanel = new XBPropertyTablePanel(catalog);
        add(propertiesPanel, java.awt.BorderLayout.CENTER);

//        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        /*TableColumnModel columns = propertiesTable.getColumnModel();
         columns.getColumn(0).setPreferredWidth(190);
         columns.getColumn(1).setPreferredWidth(190);
         columns.getColumn(0).setWidth(190);
         columns.getColumn(1).setWidth(190);
         cellRenderer = new XBPropertyTableCellRenderer(catalog);
         columns.getColumn(1).setCellRenderer(cellRenderer);
         columns.getColumn(1).setCellEditor(cellRenderer); */
//        columns.getColumn(1).setModelIndex();
        propertyThread = null;
        valueFillingSemaphore = new Semaphore(1);
        specList = new ArrayList<>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        propertyPopupMenu = new javax.swing.JPopupMenu();
        popupItemOpenMenuItem = new javax.swing.JMenuItem();
        popupItemAddMenuItem = new javax.swing.JMenuItem();
        popupItemModifyMenuItem = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        popupUndoMenuItem = new javax.swing.JMenuItem();
        popupRedoMenuItem = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        popupCutMenuItem = new javax.swing.JMenuItem();
        popupCopyMenuItem = new javax.swing.JMenuItem();
        popupPasteMenuItem = new javax.swing.JMenuItem();
        popupDeleteMenuItem = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        popupSelectAllMenuItem = new javax.swing.JMenuItem();
        jSeparator16 = new javax.swing.JPopupMenu.Separator();
        popupItemPropertiesMenuItem = new javax.swing.JMenuItem();
        itemInfoHeaderPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        descLabel = new javax.swing.JLabel();
        descTextField = new javax.swing.JTextField();
        nameTextField = new javax.swing.JTextField();

        propertyPopupMenu.setName("propertyPopupMenu"); // NOI18N

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/xbup/tool/editor/module/xbdoc_editor/panel/resources/XBPropertyPanel"); // NOI18N
        popupItemOpenMenuItem.setText(bundle.getString("actionItemOpen.text")); // NOI18N
        popupItemOpenMenuItem.setName("popupItemOpenMenuItem"); // NOI18N
        propertyPopupMenu.add(popupItemOpenMenuItem);

        popupItemAddMenuItem.setText(bundle.getString("popupItemAddMenuItem.text")); // NOI18N
        popupItemAddMenuItem.setToolTipText(bundle.getString("popupItemAddMenuItem.toolTipText")); // NOI18N
        popupItemAddMenuItem.setName("popupItemAddMenuItem"); // NOI18N
        propertyPopupMenu.add(popupItemAddMenuItem);

        popupItemModifyMenuItem.setText(bundle.getString("popupItemModifyMenuItem.text")); // NOI18N
        popupItemModifyMenuItem.setToolTipText(bundle.getString("popupItemModifyMenuItem.toolTipText")); // NOI18N
        popupItemModifyMenuItem.setName("popupItemModifyMenuItem"); // NOI18N
        propertyPopupMenu.add(popupItemModifyMenuItem);

        jSeparator14.setName("jSeparator14"); // NOI18N
        propertyPopupMenu.add(jSeparator14);

        popupUndoMenuItem.setText(bundle.getString("popupUndoMenuItem.text")); // NOI18N
        popupUndoMenuItem.setToolTipText(bundle.getString("popupUndoMenuItem.toolTipText")); // NOI18N
        popupUndoMenuItem.setName("popupUndoMenuItem"); // NOI18N
        propertyPopupMenu.add(popupUndoMenuItem);

        popupRedoMenuItem.setText(bundle.getString("popupRedoMenuItem.text")); // NOI18N
        popupRedoMenuItem.setToolTipText(bundle.getString("popupRedoMenuItem.toolTipText")); // NOI18N
        popupRedoMenuItem.setName("popupRedoMenuItem"); // NOI18N
        propertyPopupMenu.add(popupRedoMenuItem);

        jSeparator10.setName("jSeparator10"); // NOI18N
        propertyPopupMenu.add(jSeparator10);

        popupCutMenuItem.setText("Cut"); // NOI18N
        popupCutMenuItem.setName("popupCutMenuItem"); // NOI18N
        propertyPopupMenu.add(popupCutMenuItem);

        popupCopyMenuItem.setText("Copy"); // NOI18N
        popupCopyMenuItem.setName("popupCopyMenuItem"); // NOI18N
        propertyPopupMenu.add(popupCopyMenuItem);

        popupPasteMenuItem.setText("Paste"); // NOI18N
        popupPasteMenuItem.setName("popupPasteMenuItem"); // NOI18N
        propertyPopupMenu.add(popupPasteMenuItem);

        popupDeleteMenuItem.setText("Delete"); // NOI18N
        popupDeleteMenuItem.setName("popupDeleteMenuItem"); // NOI18N
        propertyPopupMenu.add(popupDeleteMenuItem);

        jSeparator7.setName("jSeparator7"); // NOI18N
        propertyPopupMenu.add(jSeparator7);

        popupSelectAllMenuItem.setText("Select All"); // NOI18N
        popupSelectAllMenuItem.setName("popupSelectAllMenuItem"); // NOI18N
        propertyPopupMenu.add(popupSelectAllMenuItem);

        jSeparator16.setName("jSeparator16"); // NOI18N
        propertyPopupMenu.add(jSeparator16);

        popupItemPropertiesMenuItem.setText(bundle.getString("popupItemPropertiesMenuItem.text")); // NOI18N
        popupItemPropertiesMenuItem.setName("popupItemPropertiesMenuItem"); // NOI18N
        propertyPopupMenu.add(popupItemPropertiesMenuItem);

        setName("Form"); // NOI18N
        setLayout(new java.awt.BorderLayout());

        itemInfoHeaderPanel.setName("itemInfoHeaderPanel"); // NOI18N

        nameLabel.setText(bundle.getString("nameLabel.text")); // NOI18N

        descLabel.setText(bundle.getString("descLabel.text")); // NOI18N
        descLabel.setName("descLabel"); // NOI18N

        descTextField.setEditable(false);
        descTextField.setName("descTextField"); // NOI18N

        nameTextField.setEditable(false);
        nameTextField.setName("nameTextField"); // NOI18N

        javax.swing.GroupLayout itemInfoHeaderPanelLayout = new javax.swing.GroupLayout(itemInfoHeaderPanel);
        itemInfoHeaderPanel.setLayout(itemInfoHeaderPanelLayout);
        itemInfoHeaderPanelLayout.setHorizontalGroup(
            itemInfoHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemInfoHeaderPanelLayout.createSequentialGroup()
                .addGroup(itemInfoHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descLabel)
                    .addComponent(nameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(itemInfoHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)))
        );
        itemInfoHeaderPanelLayout.setVerticalGroup(
            itemInfoHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(itemInfoHeaderPanelLayout.createSequentialGroup()
                .addGroup(itemInfoHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(itemInfoHeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descLabel)
                    .addComponent(descTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(itemInfoHeaderPanel, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel descLabel;
    private javax.swing.JTextField descTextField;
    private javax.swing.JPanel itemInfoHeaderPanel;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator14;
    private javax.swing.JPopupMenu.Separator jSeparator16;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JMenuItem popupCopyMenuItem;
    private javax.swing.JMenuItem popupCutMenuItem;
    private javax.swing.JMenuItem popupDeleteMenuItem;
    private javax.swing.JMenuItem popupItemAddMenuItem;
    private javax.swing.JMenuItem popupItemModifyMenuItem;
    private javax.swing.JMenuItem popupItemOpenMenuItem;
    private javax.swing.JMenuItem popupItemPropertiesMenuItem;
    private javax.swing.JMenuItem popupPasteMenuItem;
    private javax.swing.JMenuItem popupRedoMenuItem;
    private javax.swing.JMenuItem popupSelectAllMenuItem;
    private javax.swing.JMenuItem popupUndoMenuItem;
    private javax.swing.JPopupMenu propertyPopupMenu;
    // End of variables declaration//GEN-END:variables

    public void setActiveNode(XBTTreeNode node) {
        propertiesPanel.setActiveNode(node);
        nameTextField.setText(getCaption(node));

        descTextField.setText(getDescription(node));
    }

    public XBACatalog getCatalog() {
        return catalog;
    }

    public void setCatalog(XBACatalog catalog) {
        this.catalog = catalog;
        propertiesPanel.setCatalog(catalog);
    }

    private Thread getPropertyThread() {
        return propertyThread;
    }

    private void setPropertyThread(Thread propertyThread) {
        this.propertyThread = propertyThread;
    }

    private Semaphore getValueFillingSemaphore() {
        return valueFillingSemaphore;
    }

//    // TODO: Prepare values and then fill it property panel
//    private class PropertyThread extends Thread {
//
//        private XBPropertyPanel propertyPanel;
//        private XBTTreeNode node;
//        private DefaultTableModel tableModel;
//
//        public PropertyThread(XBPropertyPanel propertyPanel, XBTTreeNode node) {
//            super();
//            this.propertyPanel = propertyPanel;
//            this.node = node;
//        }
//
//        @Override
//        public void start() {
//            super.start();
//            try {
//                getValueFillingSemaphore().acquire();
//                tableModel = ((DefaultTableModel) propertiesTable.getModel());
//                for (int i = tableModel.getRowCount()-1; i >= 0; i--) {
//                    tableModel.removeRow(i);
//                }
//                specList.clear();
//                propertyPanel.setPropertyThread(this);
//                getValueFillingSemaphore().release();
//                fillPanel();
//            } catch (InterruptedException ex) {
//                Logger.getLogger(XBPropertyPanel.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            if (node != null) {
//                nameTextField.setText(getCaption(node));
//            }
//        }
//
//        public void fillPanel() {
//            if ((catalog == null) || (node == null)) {
//                return;
//            }
//            XBBlockType type = node.getBlockType();
//            if (propertyThread != this) {
//                return;
//            }
//            XBCSpecService specService = (XBCSpecService) catalog.getCatalogService(XBCSpecService.class);
//            XBBlockDecl decl = node.getBlockDecl();
//            if (decl instanceof XBCBlockDecl) {
//                XBCXNameService nameService = (XBCXNameService) catalog.getCatalogService(XBCXNameService.class);
//                XBCXDescService descService = (XBCXDescService) catalog.getCatalogService(XBCXDescService.class);
//                XBCBlockSpec spec = ((XBCBlockDecl) decl).getBlockSpec().getParent();
//                if (propertyThread != this) {
//                    return;
//                }
//                if (spec != null) {
//                    XBCXDesc desc = descService.getDefaultItemDesc(spec);
//                    if (propertyThread != this) {
//                        return;
//                    }
//                    long bindCount = specService.getSpecDefsCount(spec);
//                    try {
//                        getValueFillingSemaphore().acquire();
//                        if (propertyPanel.getPropertyThread() == this) {
//                            if (desc != null) {
//                                descTextField.setText(desc.getText());
//                            }
//                            for (int i = 0; i < bindCount; i++) {
//                                // TODO: Exclusive lock
//                                XBCSpecDef bind = specService.getSpecDefByOrder(spec, i);
//                                Object[] row = new Object[2];
//                                if (bind != null) {
//                                    XBCRev rowRev = bind.getTarget();
//                                    XBCSpec rowSpec = rowRev.getParent();
//                                    XBCXName rowName = nameService.getDefaultItemName(rowSpec);
//                                    if (rowName != null) {
//                                        row[0] = rowName.getText();
//                                    }
//                                }
//                                row[1] = "";
//                                tableModel.addRow(row);
//                                specList.add(spec);
//                            }
//                        }
//                        getValueFillingSemaphore().release();
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(XBPropertyPanel.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//            }
//        }
//    }
    private String getCaption(XBTTreeNode node) {
        if (node != null) {
            if (node.getDataMode() == XBBlockDataMode.DATA_BLOCK) {
                return "Data Block";
            }
            XBBlockType blockType = node.getBlockType();
            XBCBlockDecl blockDecl = (XBCBlockDecl) node.getBlockDecl();
            if (blockDecl instanceof XBCBlockDecl) {
                XBCBlockSpec blockSpec = ((XBCBlockDecl) blockDecl).getBlockSpec().getParent();
                if (catalog != null) {
                    XBCXNameService nameService = (XBCXNameService) catalog.getCatalogService(XBCXNameService.class);
                    return nameService.getDefaultText(blockSpec);
                }
            }

            if (blockType == null) {
                return "Unknown";
            }
            return "Unknown" + " (" + Integer.toString(((XBFBlockType) blockType).getGroupID().getInt()) + ", " + Integer.toString(((XBFBlockType) blockType).getBlockID().getInt()) + ")";
        }

        return "";
    }

    public void actionItemProperties() {
        ItemPropertiesDialog dialog = new ItemPropertiesDialog(WindowUtils.getFrame(this), true);
        dialog.setCatalog(catalog);
        dialog.runDialog(activePanel.getSelectedItem());
    }

    public void actionItemOpen() {
    }

    public boolean isStub1Enabled() {
        return activePanel.getMode() == XBDocumentPanel.PanelMode.TEXT;
    }

    private boolean addEnabled = false;

    public boolean isAddEnabled() {
        return addEnabled;
    }

    public void setAddEnabled(boolean b) {
        boolean old = isAddEnabled();
        this.addEnabled = b;
        firePropertyChange("addEnabled", old, isAddEnabled());
    }

    private boolean undoAvailable = false;

    public boolean isUndoAvailable() {
        return undoAvailable;
    }

    public void setUndoAvailable(boolean b) {
        boolean old = isUndoAvailable();
        this.undoAvailable = b;
        firePropertyChange("undoAvailable", old, isUndoAvailable());
    }

    public boolean isRedoAvailable() {
        return false; //activePanel.canRedo();
    }

    public boolean isEditEnabled() {
        if (activePanel == null) {
            return false;
        }
        return activePanel.isEditEnabled() && (activePanel.getMode() == XBDocumentPanel.PanelMode.TREE);
    }

    public boolean isPasteEnabled() {
        if (activePanel == null) {
            return false;
        }
        return activePanel.isPasteEnabled();
    }

    public boolean isFalse() {
        return false;
    }

    private String getDescription(XBTTreeNode node) {
        if (node != null) {
            XBBlockDecl decl = node.getBlockDecl();
            if (decl instanceof XBCBlockDecl) {
                XBCBlockSpec spec = ((XBCBlockDecl) decl).getBlockSpec().getParent();
                XBCXDescService descService = (XBCXDescService) catalog.getCatalogService(XBCXDescService.class);
                XBCXDesc desc = descService.getDefaultItemDesc(spec);
                return desc == null ? "" : desc.getText();
            }
        }

        return "";
    }
}
