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
import org.xbup.lib.catalog.entity.XBEItem;
import org.xbup.lib.catalog.entity.XBERev;
import org.xbup.lib.core.catalog.XBACatalog;
import org.xbup.lib.core.catalog.base.XBCItem;
import org.xbup.lib.core.catalog.base.XBCNode;
import org.xbup.lib.core.catalog.base.XBCSpec;
import org.xbup.lib.core.catalog.base.service.XBCRevService;
import org.xbup.lib.core.catalog.base.service.XBCXDescService;
import org.xbup.lib.core.catalog.base.service.XBCXNameService;
import org.xbup.tool.editor.module.service_manager.catalog.dialog.CatalogSpecRevEditorDialog;

/**
 * XBManager Catalog Item Edit Revisions Panel.
 *
 * @version 0.1.24 2014/11/17
 * @author XBUP Project (http://xbup.org)
 */
public class CatalogItemEditRevsPanel extends javax.swing.JPanel {

    private XBACatalog catalog;
    private XBCItem catalogItem;
    private XBCRevService revService;
    private final CatalogRevsTableModel revsModel;
    private CatalogDefsTableModel defsModel;
    private List<CatalogRevsTableItem> removeList;
    private List<CatalogRevsTableItem> updateList;

    public CatalogItemEditRevsPanel() {
        revsModel = new CatalogRevsTableModel(null);
        initComponents();

        itemRevisionsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
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

        itemRevisionsScrollPane = new javax.swing.JScrollPane();
        itemRevisionsTable = new javax.swing.JTable();
        revisionsControlPanel = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        revisionsControlSidePanel = new javax.swing.JPanel();
        modifyButton = new javax.swing.JButton();
        removeDefButton = new javax.swing.JButton();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/xbup/tool/editor/module/service_manager/catalog/panel/resources/CatalogItemEditDefinitionPanel"); // NOI18N
        setToolTipText(bundle.getString("toolTipText")); // NOI18N
        setLayout(new java.awt.BorderLayout());

        itemRevisionsTable.setModel(revsModel);
        itemRevisionsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        itemRevisionsScrollPane.setViewportView(itemRevisionsTable);

        add(itemRevisionsScrollPane, java.awt.BorderLayout.CENTER);

        addButton.setText("Add...");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout revisionsControlPanelLayout = new javax.swing.GroupLayout(revisionsControlPanel);
        revisionsControlPanel.setLayout(revisionsControlPanelLayout);
        revisionsControlPanelLayout.setHorizontalGroup(
            revisionsControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(revisionsControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addButton)
                .addContainerGap(312, Short.MAX_VALUE))
        );
        revisionsControlPanelLayout.setVerticalGroup(
            revisionsControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, revisionsControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(revisionsControlPanel, java.awt.BorderLayout.SOUTH);

        modifyButton.setText("Modify...");
        modifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyButtonActionPerformed(evt);
            }
        });

        removeDefButton.setText("Remove");
        removeDefButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeDefButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout revisionsControlSidePanelLayout = new javax.swing.GroupLayout(revisionsControlSidePanel);
        revisionsControlSidePanel.setLayout(revisionsControlSidePanelLayout);
        revisionsControlSidePanelLayout.setHorizontalGroup(
            revisionsControlSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(revisionsControlSidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(revisionsControlSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modifyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(removeDefButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        revisionsControlSidePanelLayout.setVerticalGroup(
            revisionsControlSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(revisionsControlSidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(modifyButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeDefButton)
                .addContainerGap(183, Short.MAX_VALUE))
        );

        add(revisionsControlSidePanel, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        CatalogSpecRevEditorDialog editorDialog = new CatalogSpecRevEditorDialog(getFrame(), true);
        editorDialog.setRevItem(new CatalogRevsTableItem());
        editorDialog.setVisible(true);

        if (editorDialog.getDialogOption() == JOptionPane.OK_OPTION) {
            long maxXbIndex = 0;
            if (revsModel.getRowCount() > 0) {
                CatalogRevsTableItem rewItem = revsModel.getRowItem(revsModel.getRowCount() - 1);
                if (rewItem.getXbIndex() >= maxXbIndex) {
                    maxXbIndex = rewItem.getXbIndex() + 1;
                }
            }

            CatalogRevsTableItem revItem = editorDialog.getRevItem();
            revItem.setXbIndex(maxXbIndex);
            if (!updateList.contains(revItem)) {
                updateList.add(revItem);
            }

            revsModel.getRevs().add(revItem);
            revsModel.fireTableDataChanged();
            updateItemStatus();
            defsModel.setRevsModel(revsModel);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void modifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyButtonActionPerformed
        int selectedRow = itemRevisionsTable.getSelectedRow();
        CatalogRevsTableItem row = revsModel.getRowItem(selectedRow);

        CatalogSpecRevEditorDialog editorDialog = new CatalogSpecRevEditorDialog(getFrame(), true);
        editorDialog.setRevItem(row);
        editorDialog.setVisible(true);

        if (editorDialog.getDialogOption() == JOptionPane.OK_OPTION) {
            CatalogRevsTableItem revItem = editorDialog.getRevItem();
            if (!updateList.contains(revItem)) {
                updateList.add(revItem);
            }

            updateItemStatus();
            defsModel.setRevsModel(revsModel);
        }
    }//GEN-LAST:event_modifyButtonActionPerformed

    private void removeDefButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeDefButtonActionPerformed
        int selectedRow = itemRevisionsTable.getSelectedRow();
        CatalogRevsTableItem revItem = revsModel.getRowItem(selectedRow);

        if (updateList.contains(revItem)) {
            updateList.remove(revItem);
        }

        removeList.add(revItem);
        revsModel.getRevs().remove(revItem);
        revsModel.fireTableDataChanged();
        updateItemStatus();
        defsModel.setRevsModel(revsModel);
    }//GEN-LAST:event_removeDefButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JScrollPane itemRevisionsScrollPane;
    private javax.swing.JTable itemRevisionsTable;
    private javax.swing.JButton modifyButton;
    private javax.swing.JButton removeDefButton;
    private javax.swing.JPanel revisionsControlPanel;
    private javax.swing.JPanel revisionsControlSidePanel;
    // End of variables declaration//GEN-END:variables

    public void persist() {
        for (CatalogRevsTableItem revItem : updateList) {
            XBCXNameService nameService = (XBCXNameService) catalog.getCatalogService(XBCXNameService.class);
            XBCXDescService descService = (XBCXDescService) catalog.getCatalogService(XBCXDescService.class);

            XBERev rev = (XBERev) revItem.getRev();
            if (rev == null) {
                rev = (XBERev) revService.createItem();
                rev.setParent((XBEItem) catalogItem);
                rev.setXBIndex(revItem.getXbIndex());
                rev.setXBLimit(revItem.getLimit());
            }

            revService.persistItem(rev);

            nameService.setDefaultText(rev, revItem.getName());
            descService.setDefaultText(rev, revItem.getDescription());
        }

        for (CatalogRevsTableItem revItem : removeList) {
            if (revItem.getRev() != null) {
                revService.removeItem(revItem.getRev());
            }
        }
    }

    private void updateItemStatus() {
        int selectedRow = itemRevisionsTable.getSelectedRow();
        int rowsCount = revsModel.getRowCount();
        if ((selectedRow >= 0) && (selectedRow < rowsCount)) {
            modifyButton.setEnabled(true);
            removeDefButton.setEnabled(true);
        } else {
            modifyButton.setEnabled(false);
            removeDefButton.setEnabled(false);
        }

        itemRevisionsTable.repaint();
    }

    public void setCatalogItem(XBCItem catalogItem) {
        this.catalogItem = catalogItem;
        addButton.setEnabled(!(catalogItem instanceof XBCNode));
        revsModel.setSpec((XBCSpec) catalogItem);
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
        revService = (XBCRevService) catalog.getCatalogService(XBCRevService.class);
        revsModel.setCatalog(catalog);
    }

    public void setDefsModel(CatalogDefsTableModel defsModel) {
        this.defsModel = defsModel;
        defsModel.setRevsModel(revsModel);
    }

    private Frame getFrame() {
        Component component = SwingUtilities.getWindowAncestor(this);
        while (!(component == null || component instanceof Frame)) {
            component = component.getParent();
        }
        return (Frame) component;
    }
}
