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
package org.xbup.lib.framework.gui.service.catalog.panel;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.JList;
import org.xbup.lib.catalog.XBECatalog;
import org.xbup.lib.catalog.entity.service.XBENodeService;
import org.xbup.lib.core.catalog.XBACatalog;
import org.xbup.lib.core.catalog.base.service.XBCItemService;
import org.xbup.lib.core.catalog.base.service.XBCNodeService;
import org.xbup.lib.core.catalog.base.service.XBCRevService;
import org.xbup.lib.core.catalog.base.service.XBCSpecService;

/**
 * Panel for catalog status.
 *
 * @version 0.1.24 2015/01/09
 * @author ExBin Project (http://exbin.org)
 */
public class CatalogStatusPanel extends javax.swing.JPanel {

    private XBACatalog catalog;
    private final CatalogExtensionsListModel extModel;

    public CatalogStatusPanel() {
        extModel = new CatalogExtensionsListModel();
        initComponents();

        updateCatalog();
        // Patch for unchecked call to setModel(ListModel<E>) as a member of the raw type JList
        JList newList = new JList();
        newList.setModel(extModel);
        extensionsList = newList;
        extensionsScrollPane.setViewportView(extensionsList);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        catalogStatusBorderPanel = new javax.swing.JPanel();
        catalogStatusPanel = new javax.swing.JPanel();
        itemsCountLabel = new javax.swing.JLabel();
        itemsCountTextField = new javax.swing.JTextField();
        nodesCountLabel = new javax.swing.JLabel();
        nodesCountTextField = new javax.swing.JTextField();
        specsCountLabel = new javax.swing.JLabel();
        specsCountTextField = new javax.swing.JTextField();
        formatsCountLabel = new javax.swing.JLabel();
        formatsCountTextField = new javax.swing.JTextField();
        groupsCountLabel = new javax.swing.JLabel();
        groupsCountTextField = new javax.swing.JTextField();
        blocksCountLabel = new javax.swing.JLabel();
        blocksCountTextField = new javax.swing.JTextField();
        defsCountLabel = new javax.swing.JLabel();
        defsCountTextField = new javax.swing.JTextField();
        revsCountLabel = new javax.swing.JLabel();
        revsCountTextField = new javax.swing.JTextField();
        lastUpdateLabel = new javax.swing.JLabel();
        lastUpdatePanel = new javax.swing.JPanel();
        lastUpdateTextField = new javax.swing.JTextField();
        lastUpdateNowButton = new javax.swing.JButton();
        extensionsBorderPanel = new javax.swing.JPanel();
        extensionsScrollPane = new javax.swing.JScrollPane();
        extensionsList = new JList<>();

        catalogStatusBorderPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Catalog Status"));

        catalogStatusPanel.setLayout(new java.awt.GridLayout(9, 2));

        itemsCountLabel.setText("Count of Items");
        catalogStatusPanel.add(itemsCountLabel);

        itemsCountTextField.setEditable(false);
        itemsCountTextField.setText("unknown");
        itemsCountTextField.setBorder(null);
        catalogStatusPanel.add(itemsCountTextField);

        nodesCountLabel.setText("Nodes");
        catalogStatusPanel.add(nodesCountLabel);

        nodesCountTextField.setEditable(false);
        nodesCountTextField.setText("unknown");
        nodesCountTextField.setBorder(null);
        catalogStatusPanel.add(nodesCountTextField);

        specsCountLabel.setText("Specifications");
        catalogStatusPanel.add(specsCountLabel);

        specsCountTextField.setEditable(false);
        specsCountTextField.setText("unknown");
        specsCountTextField.setBorder(null);
        catalogStatusPanel.add(specsCountTextField);

        formatsCountLabel.setText("Formats");
        catalogStatusPanel.add(formatsCountLabel);

        formatsCountTextField.setEditable(false);
        formatsCountTextField.setText("unknown");
        formatsCountTextField.setBorder(null);
        catalogStatusPanel.add(formatsCountTextField);

        groupsCountLabel.setText("Groups");
        catalogStatusPanel.add(groupsCountLabel);

        groupsCountTextField.setEditable(false);
        groupsCountTextField.setText("unknown");
        groupsCountTextField.setBorder(null);
        catalogStatusPanel.add(groupsCountTextField);

        blocksCountLabel.setText("Blocks");
        catalogStatusPanel.add(blocksCountLabel);

        blocksCountTextField.setEditable(false);
        blocksCountTextField.setText("unknown");
        blocksCountTextField.setBorder(null);
        catalogStatusPanel.add(blocksCountTextField);

        defsCountLabel.setText("Defs");
        catalogStatusPanel.add(defsCountLabel);

        defsCountTextField.setEditable(false);
        defsCountTextField.setText("unknown");
        defsCountTextField.setBorder(null);
        catalogStatusPanel.add(defsCountTextField);

        revsCountLabel.setText("Revisions");
        catalogStatusPanel.add(revsCountLabel);

        revsCountTextField.setEditable(false);
        revsCountTextField.setText("unknown");
        revsCountTextField.setBorder(null);
        catalogStatusPanel.add(revsCountTextField);

        lastUpdateLabel.setText("Last Update");
        catalogStatusPanel.add(lastUpdateLabel);

        lastUpdateTextField.setEditable(false);
        lastUpdateTextField.setText("unknown");
        lastUpdateTextField.setBorder(null);

        lastUpdateNowButton.setText("Set Now");
        lastUpdateNowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastUpdateNowButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lastUpdatePanelLayout = new javax.swing.GroupLayout(lastUpdatePanel);
        lastUpdatePanel.setLayout(lastUpdatePanelLayout);
        lastUpdatePanelLayout.setHorizontalGroup(
            lastUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lastUpdatePanelLayout.createSequentialGroup()
                .addComponent(lastUpdateTextField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lastUpdateNowButton))
        );
        lastUpdatePanelLayout.setVerticalGroup(
            lastUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lastUpdateNowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(lastUpdateTextField)
        );

        catalogStatusPanel.add(lastUpdatePanel);

        javax.swing.GroupLayout catalogStatusBorderPanelLayout = new javax.swing.GroupLayout(catalogStatusBorderPanel);
        catalogStatusBorderPanel.setLayout(catalogStatusBorderPanelLayout);
        catalogStatusBorderPanelLayout.setHorizontalGroup(
            catalogStatusBorderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(catalogStatusBorderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(catalogStatusPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addContainerGap())
        );
        catalogStatusBorderPanelLayout.setVerticalGroup(
            catalogStatusBorderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(catalogStatusPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
        );

        extensionsBorderPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Extensions"));

        extensionsScrollPane.setViewportView(extensionsList);

        javax.swing.GroupLayout extensionsBorderPanelLayout = new javax.swing.GroupLayout(extensionsBorderPanel);
        extensionsBorderPanel.setLayout(extensionsBorderPanelLayout);
        extensionsBorderPanelLayout.setHorizontalGroup(
            extensionsBorderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, extensionsBorderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(extensionsScrollPane)
                .addContainerGap())
        );
        extensionsBorderPanelLayout.setVerticalGroup(
            extensionsBorderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(extensionsBorderPanelLayout.createSequentialGroup()
                .addComponent(extensionsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(extensionsBorderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(catalogStatusBorderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(catalogStatusBorderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(extensionsBorderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lastUpdateNowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastUpdateNowButtonActionPerformed
        XBCNodeService nodeService = catalog == null ? null : ((XBCNodeService) catalog.getCatalogService(XBCNodeService.class));
        if (nodeService instanceof XBENodeService) {
            EntityManager em = ((XBECatalog) catalog).getEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            ((XBENodeService) nodeService).setLastUpdateToNow();
            transaction.commit();
            em.refresh(nodeService.getRoot());
            lastUpdateTextField.setText(nodeService.getLastUpdate().toString());
        }
    }//GEN-LAST:event_lastUpdateNowButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel blocksCountLabel;
    private javax.swing.JTextField blocksCountTextField;
    private javax.swing.JPanel catalogStatusBorderPanel;
    private javax.swing.JPanel catalogStatusPanel;
    private javax.swing.JLabel defsCountLabel;
    private javax.swing.JTextField defsCountTextField;
    private javax.swing.JPanel extensionsBorderPanel;
    private javax.swing.JList<String> extensionsList;
    private javax.swing.JScrollPane extensionsScrollPane;
    private javax.swing.JLabel formatsCountLabel;
    private javax.swing.JTextField formatsCountTextField;
    private javax.swing.JLabel groupsCountLabel;
    private javax.swing.JTextField groupsCountTextField;
    private javax.swing.JLabel itemsCountLabel;
    private javax.swing.JTextField itemsCountTextField;
    private javax.swing.JLabel lastUpdateLabel;
    private javax.swing.JButton lastUpdateNowButton;
    private javax.swing.JPanel lastUpdatePanel;
    private javax.swing.JTextField lastUpdateTextField;
    private javax.swing.JLabel nodesCountLabel;
    private javax.swing.JTextField nodesCountTextField;
    private javax.swing.JLabel revsCountLabel;
    private javax.swing.JTextField revsCountTextField;
    private javax.swing.JLabel specsCountLabel;
    private javax.swing.JTextField specsCountTextField;
    // End of variables declaration//GEN-END:variables

    public void setCatalog(XBACatalog catalog) {
        this.catalog = catalog;
        updateCatalog();
    }

    private void updateCatalog() {
        extModel.setCatalog(catalog);
        XBCNodeService nodeService = null;
        XBCSpecService specService = null;
        XBCRevService revService = null;
        if (catalog != null) {
            nodeService = ((XBCNodeService) catalog.getCatalogService(XBCNodeService.class));
            specService = ((XBCSpecService) catalog.getCatalogService(XBCSpecService.class));
            revService = ((XBCRevService) catalog.getCatalogService(XBCRevService.class));
        }
        
        lastUpdateNowButton.setEnabled(catalog instanceof XBECatalog);

        Long count = catalog == null ? null : ((XBCItemService) catalog.getCatalogService(XBCItemService.class)).getItemsCount();
        itemsCountTextField.setText(count == null ? "unknown" : count.toString());
        count = nodeService == null ? null : nodeService.getItemsCount();
        nodesCountTextField.setText(count == null ? "unknown" : count.toString());
        count = specService == null ? null : specService.getItemsCount();
        specsCountTextField.setText(count == null ? "unknown" : count.toString());
        count = specService == null ? null : specService.getDefsCount();
        defsCountTextField.setText(count == null ? "unknown" : count.toString());
        count = specService == null ? null : specService.getAllFormatSpecsCount();
        formatsCountTextField.setText(count == null ? "unknown" : count.toString());
        count = specService == null ? null : specService.getAllGroupSpecsCount();
        groupsCountTextField.setText(count == null ? "unknown" : count.toString());
        count = specService == null ? null : specService.getAllBlockSpecsCount();
        blocksCountTextField.setText(count == null ? "unknown" : count.toString());
        count = revService == null ? null : revService.getItemsCount();
        revsCountTextField.setText(count == null ? "unknown" : count.toString());
        count = revService == null ? null : revService.getItemsCount();
        revsCountTextField.setText(count == null ? "unknown" : count.toString());
        Date date = nodeService == null ? null : nodeService.getLastUpdate();
        lastUpdateTextField.setText(date == null ? "unknown" : date.toString());
    }
}
