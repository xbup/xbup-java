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

import java.awt.Component;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.xbup.lib.core.catalog.XBACatalog;
import org.xbup.lib.core.catalog.base.XBCItem;
import org.xbup.lib.core.catalog.base.XBCNode;
import org.xbup.lib.core.catalog.base.XBCSpec;
import org.xbup.lib.core.catalog.base.XBCSpecDef;
import org.xbup.lib.core.catalog.base.service.XBCSpecService;
import org.xbup.lib.catalog.entity.XBERev;
import org.xbup.lib.catalog.entity.XBESpec;
import org.xbup.lib.catalog.entity.XBESpecDef;
import org.xbup.lib.core.catalog.base.service.XBCXDescService;
import org.xbup.lib.core.catalog.base.service.XBCXNameService;
import org.xbup.lib.core.catalog.base.service.XBCXStriService;
import org.xbup.tool.editor.module.service_manager.catalog.dialog.CatalogSpecDefEditorDialog;

/**
 * XBManager Catalog Item Edit Documentation Panel.
 *
 * @version 0.1.24 2014/11/14
 * @author XBUP Project (http://xbup.org)
 */
public class CatalogItemEditDefinitionPanel extends javax.swing.JPanel {

    private XBACatalog catalog;
    private XBCItem catalogItem;
    private XBCSpecService specService;
    private final CatalogDefsTableModel defsModel;
    private List<XBCSpecDef> removeList;
    private List<XBCSpecDef> updateList;

    public CatalogItemEditDefinitionPanel() {
        defsModel = new CatalogDefsTableModel(null);
        initComponents();

        itemDefinitionsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                updateItemStatus();
            }
        });
        updateItemStatus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        itemDefinitionsScrollPane = new javax.swing.JScrollPane();
        itemDefinitionsTable = new javax.swing.JTable();
        definitionControlPanel = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        definitionControlSidePanel = new javax.swing.JPanel();
        modifyButton = new javax.swing.JButton();
        jumpToDefButton = new javax.swing.JButton();
        removeDefButton = new javax.swing.JButton();
        moveUpDefButton = new javax.swing.JButton();
        moveDownDefButton = new javax.swing.JButton();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/xbup/tool/editor/module/service_manager/catalog/panel/resources/CatalogItemEditDefinitionPanel"); // NOI18N
        setToolTipText(bundle.getString("toolTipText")); // NOI18N
        setLayout(new java.awt.BorderLayout());

        itemDefinitionsTable.setModel(defsModel);
        itemDefinitionsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        itemDefinitionsScrollPane.setViewportView(itemDefinitionsTable);

        add(itemDefinitionsScrollPane, java.awt.BorderLayout.CENTER);

        addButton.setText("Add...");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout definitionControlPanelLayout = new javax.swing.GroupLayout(definitionControlPanel);
        definitionControlPanel.setLayout(definitionControlPanelLayout);
        definitionControlPanelLayout.setHorizontalGroup(
            definitionControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(definitionControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addButton)
                .addContainerGap(312, Short.MAX_VALUE))
        );
        definitionControlPanelLayout.setVerticalGroup(
            definitionControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, definitionControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(definitionControlPanel, java.awt.BorderLayout.SOUTH);

        modifyButton.setText("Modify...");
        modifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyButtonActionPerformed(evt);
            }
        });

        jumpToDefButton.setText("Jump to");

        removeDefButton.setText("Remove");
        removeDefButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeDefButtonActionPerformed(evt);
            }
        });

        moveUpDefButton.setText("Up");
        moveUpDefButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveUpDefButtonActionPerformed(evt);
            }
        });

        moveDownDefButton.setText("Down");
        moveDownDefButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveDownDefButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout definitionControlSidePanelLayout = new javax.swing.GroupLayout(definitionControlSidePanel);
        definitionControlSidePanel.setLayout(definitionControlSidePanelLayout);
        definitionControlSidePanelLayout.setHorizontalGroup(
            definitionControlSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(definitionControlSidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(definitionControlSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(moveUpDefButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(moveDownDefButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(modifyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(removeDefButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jumpToDefButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        definitionControlSidePanelLayout.setVerticalGroup(
            definitionControlSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(definitionControlSidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(moveUpDefButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(moveDownDefButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modifyButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeDefButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jumpToDefButton)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        add(definitionControlSidePanel, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        CatalogSpecDefEditorDialog editorDialog = new CatalogSpecDefEditorDialog(getFrame(), true, catalog);
        editorDialog.setSpec((XBCSpec) catalogItem);
        editorDialog.setVisible(true);

        if (editorDialog.getDialogOption() == JOptionPane.OK_OPTION) {
            long maxXbIndex = 0;
            if (defsModel.getRowCount() > 0) {
                CatalogDefsTableItem rowItem = defsModel.getRowItem(defsModel.getRowCount() - 1);
                maxXbIndex = rowItem.getSpecDef().getXBIndex() + 1;
            }

            XBCSpecDef specDef;
            specDef = specService.createSpecDef((XBCSpec) catalogItem, editorDialog.getSpecDefType());
            // TODO: Refit for general usage (including XBRSpecDef and so on...)
            ((XBESpecDef) specDef).setCatalogItem((XBESpec) catalogItem);
            ((XBESpecDef) specDef).setTarget((XBERev) editorDialog.getTarget());
            ((XBESpecDef) specDef).setXBIndex(maxXbIndex);
            if (!updateList.contains(specDef)) {
                updateList.add(specDef);
            }

            XBCXNameService nameService = (XBCXNameService) catalog.getCatalogService(XBCXNameService.class);
            nameService.setItemNameText(specDef, editorDialog.getItemName());
            XBCXDescService descService = (XBCXDescService) catalog.getCatalogService(XBCXDescService.class);
            descService.setItemDescText(specDef, editorDialog.getItemDescription());
            XBCXStriService striService = (XBCXStriService) catalog.getCatalogService(XBCXStriService.class);
            striService.setItemStringIdText(specDef, editorDialog.getItemStringId());

            updateItemStatus();
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void modifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyButtonActionPerformed
        int selectedRow = itemDefinitionsTable.getSelectedRow();
        CatalogDefsTableItem row = defsModel.getRowItem(selectedRow);

        CatalogSpecDefEditorDialog editorDialog = new CatalogSpecDefEditorDialog(getFrame(), true, catalog);
        editorDialog.setSpecDef(row.getSpecDef());
        editorDialog.setVisible(true);

        if (editorDialog.getDialogOption() == JOptionPane.OK_OPTION) {
            XBCSpecDef specDef = row.getSpecDef();
            ((XBESpecDef) specDef).setTarget((XBERev) editorDialog.getTarget());

            if (updateList.contains(specDef)) {
                updateList.remove(specDef);
            }

            XBCXNameService nameService = (XBCXNameService) catalog.getCatalogService(XBCXNameService.class);
            nameService.setItemNameText(specDef, editorDialog.getItemName());
            XBCXDescService descService = (XBCXDescService) catalog.getCatalogService(XBCXDescService.class);
            descService.setItemDescText(specDef, editorDialog.getItemDescription());
            XBCXStriService striService = (XBCXStriService) catalog.getCatalogService(XBCXStriService.class);
            striService.setItemStringIdText(specDef, editorDialog.getItemStringId());
        }
    }//GEN-LAST:event_modifyButtonActionPerformed

    private void removeDefButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeDefButtonActionPerformed
        int selectedRow = itemDefinitionsTable.getSelectedRow();
        XBCSpecDef specDef = defsModel.getRowItem(selectedRow).getSpecDef();

        if (updateList.contains(specDef)) {
            updateList.remove(specDef);
        }

        removeList.add(specDef);
        defsModel.removeItem(specDef);
        updateItemStatus();
    }//GEN-LAST:event_removeDefButtonActionPerformed

    private void moveUpDefButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveUpDefButtonActionPerformed
        int selectedRow = itemDefinitionsTable.getSelectedRow();
        XBCSpecDef specDef = defsModel.getRowItem(selectedRow).getSpecDef();
        XBCSpecDef targetSpecDef = defsModel.getRowItem(selectedRow - 1).getSpecDef();
        Long prevIndex = specDef.getXBIndex();
        ((XBESpecDef) specDef).setXBIndex(targetSpecDef.getXBIndex());
        ((XBESpecDef) targetSpecDef).setXBIndex(prevIndex);

        if (!updateList.contains(specDef)) {
            updateList.add(specDef);
        }
        if (!updateList.contains(targetSpecDef)) {
            updateList.add(targetSpecDef);
        }

        defsModel.moveItemDown(selectedRow - 1);
        updateItemStatus();

        itemDefinitionsTable.setRowSelectionInterval(selectedRow - 1, selectedRow - 1);
    }//GEN-LAST:event_moveUpDefButtonActionPerformed

    private void moveDownDefButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveDownDefButtonActionPerformed
        int selectedRow = itemDefinitionsTable.getSelectedRow();
        XBCSpecDef specDef = defsModel.getRowItem(selectedRow).getSpecDef();
        XBCSpecDef targetSpecDef = defsModel.getRowItem(selectedRow + 1).getSpecDef();

        Long prevIndex = specDef.getXBIndex();
        ((XBESpecDef) specDef).setXBIndex(targetSpecDef.getXBIndex());
        ((XBESpecDef) targetSpecDef).setXBIndex(prevIndex);

        if (!updateList.contains(specDef)) {
            updateList.add(specDef);
        }
        if (!updateList.contains(targetSpecDef)) {
            updateList.add(targetSpecDef);
        }

        defsModel.moveItemDown(selectedRow);
        updateItemStatus();
        itemDefinitionsTable.setRowSelectionInterval(selectedRow + 1, selectedRow + 1);
    }//GEN-LAST:event_moveDownDefButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JPanel definitionControlPanel;
    private javax.swing.JPanel definitionControlSidePanel;
    private javax.swing.JScrollPane itemDefinitionsScrollPane;
    private javax.swing.JTable itemDefinitionsTable;
    private javax.swing.JButton jumpToDefButton;
    private javax.swing.JButton modifyButton;
    private javax.swing.JButton moveDownDefButton;
    private javax.swing.JButton moveUpDefButton;
    private javax.swing.JButton removeDefButton;
    // End of variables declaration//GEN-END:variables

    public void persist() {
        for (XBCSpecDef specDef : removeList) {
            specService.removeItem(specDef);
        }

        for (int i = 0; i < updateList.size(); i++) {
            specService.persistItem(removeList.get(i));
        }
    }

    private void updateItemStatus() {
        int selectedRow = itemDefinitionsTable.getSelectedRow();
        int rowsCount = defsModel.getRowCount();
        if ((selectedRow >= 0) && (selectedRow < rowsCount)) {
            moveUpDefButton.setEnabled(selectedRow > 0);
            moveDownDefButton.setEnabled(selectedRow < rowsCount - 1);
            modifyButton.setEnabled(true);
            removeDefButton.setEnabled(true);
            jumpToDefButton.setEnabled(true);
        } else {
            moveUpDefButton.setEnabled(false);
            moveDownDefButton.setEnabled(false);
            modifyButton.setEnabled(false);
            removeDefButton.setEnabled(false);
            jumpToDefButton.setEnabled(false);
        }
        itemDefinitionsTable.repaint();
    }

    public void setCatalogItem(XBCItem catalogItem) {
        this.catalogItem = catalogItem;
        addButton.setEnabled(!(catalogItem instanceof XBCNode));
        defsModel.setItem(catalogItem);
        updateList = new ArrayList<>();
        removeList = new ArrayList<>();
        updateItemStatus();
    }

    public XBCItem getCatalogItem() {
        return catalogItem;
    }

    public XBACatalog getCatalog() {
        return catalog;
    }

    public void setCatalog(XBACatalog catalog) {
        this.catalog = catalog;
        specService = (XBCSpecService) catalog.getCatalogService(XBCSpecService.class);
        defsModel.setCatalog(catalog);
    }

    private Frame getFrame() {
        Component component = SwingUtilities.getWindowAncestor(this);
        while (!(component == null || component instanceof Frame)) {
            component = component.getParent();
        }
        return (Frame) component;
    }
}
