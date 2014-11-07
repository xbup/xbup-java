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
import org.xbup.tool.editor.module.service_manager.catalog.dialog.CatalogSpecDefEditorDialog;

/**
 * XBManager Catalog Item Edit Documentation Panel.
 *
 * @version 0.1.23 2013/09/23
 * @author XBUP Project (http://xbup.org)
 */
public class CatalogItemEditDefinitionPanel extends javax.swing.JPanel {

    private XBACatalog catalog;
    private XBCItem catalogItem;
    private XBCSpecService specService;
    private CatalogBindsTableModel bindsModel;
    private List<XBCSpecDef> removeList;
    private List<XBCSpecDef> updateList;

    /**
     * Creates new form CatalogItemEditDocumentationPanel
     */
    public CatalogItemEditDefinitionPanel() {
        bindsModel = new CatalogBindsTableModel(null);
        initComponents();

        itemDefinitionTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
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

        jScrollPane5 = new javax.swing.JScrollPane();
        itemDefinitionTable = new javax.swing.JTable();
        definitionControlPanel = new javax.swing.JPanel();
        addDefButton = new javax.swing.JButton();
        definitionControlSidePanel = new javax.swing.JPanel();
        modifyButton = new javax.swing.JButton();
        jumpToDefButton = new javax.swing.JButton();
        removeDefButton = new javax.swing.JButton();
        moveUpDefButton = new javax.swing.JButton();
        moveDownDefButton = new javax.swing.JButton();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/xbup/tool/editor/module/service_manager/catalog/panel/resources/CatalogItemEditDefinitionPanel"); // NOI18N
        setToolTipText(bundle.getString("toolTipText")); // NOI18N
        setLayout(new java.awt.BorderLayout());

        itemDefinitionTable.setModel(bindsModel);
        itemDefinitionTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane5.setViewportView(itemDefinitionTable);

        add(jScrollPane5, java.awt.BorderLayout.CENTER);

        addDefButton.setText("Add...");
        addDefButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDefButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout definitionControlPanelLayout = new javax.swing.GroupLayout(definitionControlPanel);
        definitionControlPanel.setLayout(definitionControlPanelLayout);
        definitionControlPanelLayout.setHorizontalGroup(
            definitionControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(definitionControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addDefButton)
                .addContainerGap(487, Short.MAX_VALUE))
        );
        definitionControlPanelLayout.setVerticalGroup(
            definitionControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, definitionControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addDefButton)
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

    private void addDefButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDefButtonActionPerformed
        CatalogSpecDefEditorDialog editorDialog = new CatalogSpecDefEditorDialog(getFrame(), true, catalog);
        editorDialog.setSpec((XBCSpec) catalogItem);
        editorDialog.setVisible(true);

        if (editorDialog.getOption() == JOptionPane.OK_OPTION) {
            long maxXbIndex = 0;
            if (bindsModel.getRowCount() > 0) {
                CatalogBindsTableItem rowItem = bindsModel.getRowItem(bindsModel.getRowCount() - 1);
                maxXbIndex = rowItem.getSpecDef().getXBIndex() + 1;
            }

            XBCSpecDef specDef;
            specDef = specService.createSpecDef((XBCSpec) catalogItem, editorDialog.getSpecDefType());
            // TODO: Refit for general usage (including XBRSpecDef and so on...)
            ((XBESpecDef) specDef).setSpec((XBESpec) catalogItem);
            ((XBESpecDef) specDef).setTarget((XBERev) editorDialog.getTarget());
            ((XBESpecDef) specDef).setXBIndex(maxXbIndex);
            if (!updateList.contains(specDef)) {
                updateList.add(specDef);
            }

            updateItemStatus();
        }
    }//GEN-LAST:event_addDefButtonActionPerformed

    private void modifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyButtonActionPerformed
        int selectedRow = itemDefinitionTable.getSelectedRow();
        CatalogBindsTableItem row = bindsModel.getRowItem(selectedRow);

        CatalogSpecDefEditorDialog editorDialog = new CatalogSpecDefEditorDialog(getFrame(), true, catalog);
        editorDialog.setSpecDef(row.getSpecDef());
        editorDialog.setVisible(true);

        if (editorDialog.getOption() == JOptionPane.OK_OPTION) {
            XBCSpecDef specDef = row.getSpecDef();
            ((XBESpecDef) specDef).setTarget((XBERev) editorDialog.getTarget());

            if (updateList.contains(specDef)) {
                updateList.remove(specDef);
            }
        }
    }//GEN-LAST:event_modifyButtonActionPerformed

    private void removeDefButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeDefButtonActionPerformed
        int selectedRow = itemDefinitionTable.getSelectedRow();
        XBCSpecDef specDef = bindsModel.getRowItem(selectedRow).getSpecDef();

        if (updateList.contains(specDef)) {
            updateList.remove(specDef);
        }

        removeList.add(specDef);
        bindsModel.removeItem(specDef);
        updateItemStatus();
    }//GEN-LAST:event_removeDefButtonActionPerformed

    private void moveUpDefButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveUpDefButtonActionPerformed
        int selectedRow = itemDefinitionTable.getSelectedRow();
        XBCSpecDef specDef = bindsModel.getRowItem(selectedRow).getSpecDef();
        XBCSpecDef targetSpecDef = bindsModel.getRowItem(selectedRow - 1).getSpecDef();
        Long prevIndex = specDef.getXBIndex();
        ((XBESpecDef) specDef).setXBIndex(targetSpecDef.getXBIndex());
        ((XBESpecDef) targetSpecDef).setXBIndex(prevIndex);

        if (!updateList.contains(specDef)) {
            updateList.add(specDef);
        }
        if (!updateList.contains(targetSpecDef)) {
            updateList.add(targetSpecDef);
        }

        bindsModel.moveItemDown(selectedRow - 1);
        updateItemStatus();

        itemDefinitionTable.setRowSelectionInterval(selectedRow - 1, selectedRow - 1);
    }//GEN-LAST:event_moveUpDefButtonActionPerformed

    private void moveDownDefButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveDownDefButtonActionPerformed
        int selectedRow = itemDefinitionTable.getSelectedRow();
        XBCSpecDef specDef = bindsModel.getRowItem(selectedRow).getSpecDef();
        XBCSpecDef targetSpecDef = bindsModel.getRowItem(selectedRow + 1).getSpecDef();
        Long prevIndex = specDef.getXBIndex();
        ((XBESpecDef) specDef).setXBIndex(targetSpecDef.getXBIndex());
        ((XBESpecDef) targetSpecDef).setXBIndex(prevIndex);

        if (!updateList.contains(specDef)) {
            updateList.add(specDef);
        }
        if (!updateList.contains(targetSpecDef)) {
            updateList.add(targetSpecDef);
        }

        bindsModel.moveItemDown(selectedRow);
        updateItemStatus();
        itemDefinitionTable.setRowSelectionInterval(selectedRow + 1, selectedRow + 1);
    }//GEN-LAST:event_moveDownDefButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDefButton;
    private javax.swing.JPanel definitionControlPanel;
    private javax.swing.JPanel definitionControlSidePanel;
    private javax.swing.JTable itemDefinitionTable;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton jumpToDefButton;
    private javax.swing.JButton modifyButton;
    private javax.swing.JButton moveDownDefButton;
    private javax.swing.JButton moveUpDefButton;
    private javax.swing.JButton removeDefButton;
    // End of variables declaration//GEN-END:variables

    public void persist() {
        for (int i = 0; i < removeList.size(); i++) {
            specService.removeItem(removeList.get(i));
        }

        for (int i = 0; i < updateList.size(); i++) {
            specService.persistItem(removeList.get(i));
        }
    }

    private void updateItemStatus() {
        int selectedRow = itemDefinitionTable.getSelectedRow();
        int rowsCount = bindsModel.getRowCount();
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
        itemDefinitionTable.repaint();
    }

    public void setCatalogItem(XBCItem catalogItem) {
        this.catalogItem = catalogItem;
        addDefButton.setEnabled(!(catalogItem instanceof XBCNode));
        bindsModel.setItem(catalogItem);
        updateList = new ArrayList<XBCSpecDef>();
        removeList = new ArrayList<XBCSpecDef>();
        updateItemStatus();
    }

    public XBCItem getCatalogItem() {
        return catalogItem;
    }

    /**
     * @return the catalog
     */
    public XBACatalog getCatalog() {
        return catalog;
    }

    /**
     * @param catalog the catalog to set
     */
    public void setCatalog(XBACatalog catalog) {
        this.catalog = catalog;
        specService = (XBCSpecService) catalog.getCatalogService(XBCSpecService.class);
        bindsModel.setCatalog(catalog);
    }

    private Frame getFrame() {
        Component component = SwingUtilities.getWindowAncestor(this);
        while (!(component == null || component instanceof Frame)) {
            component = component.getParent();
        }
        return (Frame) component;
    }
}

