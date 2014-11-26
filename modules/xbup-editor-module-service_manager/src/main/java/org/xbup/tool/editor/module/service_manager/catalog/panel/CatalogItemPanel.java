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
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.xbup.lib.core.catalog.XBACatalog;
import org.xbup.lib.core.catalog.base.XBCBlockSpec;
import org.xbup.lib.core.catalog.base.XBCFormatSpec;
import org.xbup.lib.core.catalog.base.XBCGroupSpec;
import org.xbup.lib.core.catalog.base.XBCItem;
import org.xbup.lib.core.catalog.base.XBCRev;
import org.xbup.lib.core.catalog.base.XBCSpec;
import org.xbup.lib.core.catalog.base.XBCXDesc;
import org.xbup.lib.core.catalog.base.XBCXFile;
import org.xbup.lib.core.catalog.base.XBCXHDoc;
import org.xbup.lib.core.catalog.base.XBCXIcon;
import org.xbup.lib.core.catalog.base.XBCXName;
import org.xbup.lib.core.catalog.base.XBCXStri;
import org.xbup.lib.core.catalog.base.service.XBCXDescService;
import org.xbup.lib.core.catalog.base.service.XBCXFileService;
import org.xbup.lib.core.catalog.base.service.XBCXHDocService;
import org.xbup.lib.core.catalog.base.service.XBCXIconService;
import org.xbup.lib.core.catalog.base.service.XBCXNameService;
import org.xbup.lib.core.catalog.base.service.XBCXStriService;
import org.xbup.tool.editor.base.api.MainFrameManagement;

/**
 * Panel for basic XBItem viewing/editation.
 *
 * @version 0.1.24 2014/11/26
 * @author XBUP Project (http://xbup.org)
 */
public class CatalogItemPanel extends javax.swing.JPanel {

    private XBCItem item;

    private CatalogDefsTableModel defsModel;
    private CatalogRevsTableModel revsModel;
    private XBCXNameService nameService;
    private XBCXDescService descService;
    private XBCXStriService striService;
    private XBCXHDocService hDocService;
    private XBCXFileService fileService;
    private XBCXIconService iconService;
    private XBCXName itemName;
    private XBCXDesc itemDesc;
    private XBCXHDoc itemHDoc;
    private XBCXIcon itemIcon;
    private JumpActionListener jumpActionListener = null;

    public CatalogItemPanel(XBACatalog catalog, MainFrameManagement mainFrameManagement) {
        nameService = null;
        descService = null;
        if (catalog != null) {
            striService = (XBCXStriService) catalog.getCatalogService(XBCXStriService.class);
            nameService = (XBCXNameService) catalog.getCatalogService(XBCXNameService.class);
            descService = (XBCXDescService) catalog.getCatalogService(XBCXDescService.class);
            hDocService = (XBCXHDocService) catalog.getCatalogService(XBCXHDocService.class);
            fileService = (XBCXFileService) catalog.getCatalogService(XBCXFileService.class);
            iconService = (XBCXIconService) catalog.getCatalogService(XBCXIconService.class);
            // TODO: OnAddExtension
        }

        defsModel = new CatalogDefsTableModel(catalog);
        revsModel = new CatalogRevsTableModel(catalog);
        initComponents();

        JPopupMenu defaultTextPopupMenu = mainFrameManagement.getDefaultTextPopupMenu();
        for (Component menuComponent : defaultTextPopupMenu.getComponents()) {
            definitionPopupMenu.add(mainFrameManagement.duplicateMenuComponent(menuComponent));
        }

        mainFrameManagement.initPopupMenu(definitionPopupMenu);
        itemDefinitionTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int rowIndex = itemDefinitionTable.getSelectedRow();
                if (rowIndex >= 0) {
                    if (defsModel.getRowItem(rowIndex).getTarget() != null) {
                        jumpToMenuItem.setEnabled(true);
                        return;
                    }
                }

                jumpToMenuItem.setEnabled(false);
            }
        });
    }

    public CatalogItemPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        definitionPopupMenu = new javax.swing.JPopupMenu();
        jumpToMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mainTabbedPane = new javax.swing.JTabbedPane();
        generalPanel = new javax.swing.JPanel();
        basicItemScrollPane = new javax.swing.JScrollPane();
        basicItemDataPanel = new javax.swing.JPanel();
        itemTitleLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        itemNameLabel = new javax.swing.JLabel();
        itemNameTextField = new javax.swing.JTextField();
        itemPathLabel = new javax.swing.JLabel();
        itemPathTextField = new javax.swing.JTextField();
        itemTypeLabel = new javax.swing.JLabel();
        itemTypeTextField = new javax.swing.JTextField();
        itemDescriptionLabel = new javax.swing.JLabel();
        itemDescriptionTextField = new javax.swing.JTextField();
        itemCreatedLabel = new javax.swing.JLabel();
        itemCreatedTextField = new javax.swing.JTextField();
        iconPanel = new javax.swing.JPanel();
        itemIconLabel = new javax.swing.JLabel();
        documentationPanel = new javax.swing.JPanel();
        itemHDocScrollPane = new javax.swing.JScrollPane();
        itemHDocEditorPane = new javax.swing.JEditorPane();
        revisionsPanel = new javax.swing.JPanel();
        itemRevisionsScrollPane = new javax.swing.JScrollPane();
        itemRevisionsTable = new javax.swing.JTable();
        definitionPanel = new javax.swing.JPanel();
        itemDefinitionScrollPane = new javax.swing.JScrollPane();
        itemDefinitionTable = new javax.swing.JTable();

        definitionPopupMenu.setName("definitionPopupMenu"); // NOI18N

        jumpToMenuItem.setText("Jump To Type");
        jumpToMenuItem.setToolTipText("Navigate to type of selected definition row");
        jumpToMenuItem.setName("jumpToMenuItem"); // NOI18N
        jumpToMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumpToMenuItemActionPerformed(evt);
            }
        });
        definitionPopupMenu.add(jumpToMenuItem);

        jSeparator2.setName("jSeparator2"); // NOI18N
        definitionPopupMenu.add(jSeparator2);

        setLayout(new java.awt.BorderLayout());

        mainTabbedPane.setName("mainTabbedPane"); // NOI18N

        generalPanel.setName("generalPanel"); // NOI18N
        generalPanel.setLayout(new java.awt.CardLayout());

        basicItemScrollPane.setName("basicItemScrollPane"); // NOI18N

        basicItemDataPanel.setName("basicItemDataPanel"); // NOI18N

        itemTitleLabel.setText("Unknown item");
        itemTitleLabel.setName("itemTitleLabel"); // NOI18N

        jSeparator1.setName("jSeparator1"); // NOI18N

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/xbup/tool/editor/module/service_manager/catalog/panel/resources/CatalogItemPanel"); // NOI18N
        itemNameLabel.setText(bundle.getString("itemNameLabel.text")); // NOI18N
        itemNameLabel.setName("itemNameLabel"); // NOI18N

        itemNameTextField.setEditable(false);
        itemNameTextField.setName("itemNameTextField"); // NOI18N

        itemPathLabel.setText("StringId");
        itemPathLabel.setName("itemPathLabel"); // NOI18N

        itemPathTextField.setEditable(false);
        itemPathTextField.setName("itemPathTextField"); // NOI18N

        itemTypeLabel.setText("Type");
        itemTypeLabel.setName("itemTypeLabel"); // NOI18N

        itemTypeTextField.setEditable(false);
        itemTypeTextField.setName("itemTypeTextField"); // NOI18N

        itemDescriptionLabel.setText(bundle.getString("itemDescriptionLabel.text")); // NOI18N
        itemDescriptionLabel.setName("itemDescriptionLabel"); // NOI18N

        itemDescriptionTextField.setEditable(false);
        itemDescriptionTextField.setName("itemDescriptionTextField"); // NOI18N

        itemCreatedLabel.setText(bundle.getString("itemCreatedLabel.text")); // NOI18N
        itemCreatedLabel.setName("itemCreatedLabel"); // NOI18N

        itemCreatedTextField.setEditable(false);
        itemCreatedTextField.setName("itemCreatedTextField"); // NOI18N

        iconPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        iconPanel.setName("iconPanel"); // NOI18N
        iconPanel.setLayout(new java.awt.BorderLayout());

        itemIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/xbup/tool/editor/module/service_manager/resources/images/empty.png"))); // NOI18N
        itemIconLabel.setName("itemIconLabel"); // NOI18N
        iconPanel.add(itemIconLabel, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout basicItemDataPanelLayout = new javax.swing.GroupLayout(basicItemDataPanel);
        basicItemDataPanel.setLayout(basicItemDataPanelLayout);
        basicItemDataPanelLayout.setHorizontalGroup(
            basicItemDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basicItemDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(basicItemDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(basicItemDataPanelLayout.createSequentialGroup()
                        .addComponent(iconPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(itemTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSeparator1)
                    .addGroup(basicItemDataPanelLayout.createSequentialGroup()
                        .addGroup(basicItemDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(itemPathLabel)
                            .addComponent(itemNameLabel)
                            .addComponent(itemCreatedLabel)
                            .addComponent(itemDescriptionLabel)
                            .addComponent(itemTypeLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(basicItemDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(itemCreatedTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                            .addComponent(itemPathTextField)
                            .addComponent(itemTypeTextField)
                            .addComponent(itemDescriptionTextField)
                            .addComponent(itemNameTextField))))
                .addContainerGap())
        );
        basicItemDataPanelLayout.setVerticalGroup(
            basicItemDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basicItemDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(basicItemDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(itemTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(iconPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(basicItemDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(basicItemDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(itemPathLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemPathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(basicItemDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(itemTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(basicItemDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemDescriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemDescriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(basicItemDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(itemCreatedTextField)
                    .addComponent(itemCreatedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        basicItemScrollPane.setViewportView(basicItemDataPanel);

        generalPanel.add(basicItemScrollPane, "card2");

        mainTabbedPane.addTab("Basic", generalPanel);

        documentationPanel.setName("documentationPanel"); // NOI18N

        itemHDocScrollPane.setName("itemHDocScrollPane"); // NOI18N

        itemHDocEditorPane.setEditable(false);
        itemHDocEditorPane.setContentType("text/html"); // NOI18N
        itemHDocEditorPane.setName("itemHDocEditorPane"); // NOI18N
        itemHDocScrollPane.setViewportView(itemHDocEditorPane);

        javax.swing.GroupLayout documentationPanelLayout = new javax.swing.GroupLayout(documentationPanel);
        documentationPanel.setLayout(documentationPanelLayout);
        documentationPanelLayout.setHorizontalGroup(
            documentationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(itemHDocScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
        );
        documentationPanelLayout.setVerticalGroup(
            documentationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(itemHDocScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
        );

        mainTabbedPane.addTab("Documentation", documentationPanel);

        revisionsPanel.setName("revisionsPanel"); // NOI18N
        revisionsPanel.setLayout(new java.awt.BorderLayout());

        itemRevisionsScrollPane.setName("itemRevisionsScrollPane"); // NOI18N

        itemRevisionsTable.setModel(revsModel);
        itemRevisionsTable.setName("itemRevisionsTable"); // NOI18N
        itemRevisionsScrollPane.setViewportView(itemRevisionsTable);

        revisionsPanel.add(itemRevisionsScrollPane, java.awt.BorderLayout.CENTER);

        mainTabbedPane.addTab("Revisions", revisionsPanel);

        definitionPanel.setName("definitionPanel"); // NOI18N
        definitionPanel.setLayout(new java.awt.BorderLayout());

        itemDefinitionScrollPane.setName("itemDefinitionScrollPane"); // NOI18N

        itemDefinitionTable.setModel(defsModel);
        itemDefinitionTable.setComponentPopupMenu(definitionPopupMenu);
        itemDefinitionTable.setName("itemDefinitionTable"); // NOI18N
        itemDefinitionTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        itemDefinitionScrollPane.setViewportView(itemDefinitionTable);

        definitionPanel.add(itemDefinitionScrollPane, java.awt.BorderLayout.CENTER);

        mainTabbedPane.addTab("Definition", definitionPanel);

        add(mainTabbedPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jumpToMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumpToMenuItemActionPerformed
        CatalogDefsTableModel model = (CatalogDefsTableModel) itemDefinitionTable.getModel();
        CatalogDefsTableItem rowItem = model.getRowItem(itemDefinitionTable.getSelectedRow());
        XBCRev target = rowItem.getTarget();
        if (jumpActionListener != null) {
            jumpActionListener.jumpToRev(target);
        }
    }//GEN-LAST:event_jumpToMenuItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel basicItemDataPanel;
    private javax.swing.JScrollPane basicItemScrollPane;
    private javax.swing.JPanel definitionPanel;
    private javax.swing.JPopupMenu definitionPopupMenu;
    private javax.swing.JPanel documentationPanel;
    private javax.swing.JPanel generalPanel;
    private javax.swing.JPanel iconPanel;
    private javax.swing.JLabel itemCreatedLabel;
    private javax.swing.JTextField itemCreatedTextField;
    private javax.swing.JScrollPane itemDefinitionScrollPane;
    private javax.swing.JTable itemDefinitionTable;
    private javax.swing.JLabel itemDescriptionLabel;
    private javax.swing.JTextField itemDescriptionTextField;
    private javax.swing.JEditorPane itemHDocEditorPane;
    private javax.swing.JScrollPane itemHDocScrollPane;
    private javax.swing.JLabel itemIconLabel;
    private javax.swing.JLabel itemNameLabel;
    private javax.swing.JTextField itemNameTextField;
    private javax.swing.JLabel itemPathLabel;
    private javax.swing.JTextField itemPathTextField;
    private javax.swing.JScrollPane itemRevisionsScrollPane;
    private javax.swing.JTable itemRevisionsTable;
    private javax.swing.JLabel itemTitleLabel;
    private javax.swing.JLabel itemTypeLabel;
    private javax.swing.JTextField itemTypeTextField;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuItem jumpToMenuItem;
    private javax.swing.JTabbedPane mainTabbedPane;
    private javax.swing.JPanel revisionsPanel;
    // End of variables declaration//GEN-END:variables

    public XBCItem getItem() {
        return item;
    }

    public void setItem(XBCItem item) {
        this.item = item;
        reloadItem();
    }

    private CatalogSpecItemType getItemType() {
        CatalogSpecItemType itemType = CatalogSpecItemType.NODE;
        if (item instanceof XBCBlockSpec) {
            itemType = CatalogSpecItemType.BLOCK;
        } else if (item instanceof XBCGroupSpec) {
            itemType = CatalogSpecItemType.GROUP;
        } else if (item instanceof XBCFormatSpec) {
            itemType = CatalogSpecItemType.FORMAT;
        }

        return itemType;
    }

    private void reloadItem() {
        if (item != null) {
            boolean isSpec = item instanceof XBCSpec;
            if (isSpec) {
                if (item instanceof XBCFormatSpec) {
                    itemTypeTextField.setText("Format Specification");
                } else if (item instanceof XBCGroupSpec) {
                    itemTypeTextField.setText("Group Specification");
                } else if (item instanceof XBCBlockSpec) {
                    itemTypeTextField.setText("Block Specification");
                } else {
                    itemTypeTextField.setText("Failed to recognize");
                }
                // TODO: Fix button "Jump" enablement
            } else {
                itemTypeTextField.setText("Node");
                // jumpToDefButton.setEnabled(itemDefinitionTable.getSelectedRow()>=0);
            }
            Long xbIndex = item.getXBIndex();
//            jLabel6.setText((xbIndex==null)?"":xbIndex.toString());
            Long itemId = ((XBCItem) item).getId();
//            jLabel7.setText((itemId==null)?"":itemId.toString());
            itemName = nameService.getItemName(item);
            itemNameTextField.setText((itemName == null) ? "" : itemName.getText());
            itemDesc = descService.getItemDesc(item);
            itemDescriptionTextField.setText((itemDesc == null) ? "" : itemDesc.getText());
            itemTitleLabel.setText(((itemName == null) ? "-" : itemName.getText()) + " (" + ((xbIndex == null) ? "" : xbIndex.toString()) + ")");

            XBCXStri stringId = striService.getItemStringId(item);
            itemPathTextField.setText(stringId == null ? "" : stringId.getText());

            itemHDocEditorPane.setText(null);
            itemHDoc = hDocService.getDocumentation(item);
            if (itemHDoc != null) {
                XBCXFile itemHDocFile = itemHDoc.getDocFile();
                InputStream fileStream = fileService.getFile(itemHDocFile);
                try {
                    itemHDocEditorPane.getEditorKit().createDefaultDocument();
                    itemHDocEditorPane.read(fileStream, itemHDocEditorPane.getDocument());

                } catch (RuntimeException | IOException ex) {
                    Logger.getLogger(CatalogItemPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            itemIcon = iconService.getDefaultIcon(item);
            if (itemIcon != null) {
                ImageIcon icon = iconService.getDefaultImageIcon(item);
                itemIconLabel.setIcon(icon);
            } else {
                itemIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/xbup/tool/editor/module/service_manager/resources/images/empty.png")));
            }
//            itemHD
        } else {
            itemTitleLabel.setText("unknown");
            itemTypeTextField.setText("unknown");
            itemNameTextField.setText("");
            itemDescriptionTextField.setText("");
            itemHDocEditorPane.setText("");
        }

        revsModel.setSpec(item instanceof XBCSpec ? (XBCSpec) item : null);

        defsModel.setCatalogItem(item);
        defsModel.setRevsModel(revsModel);
    }

    public JumpActionListener getJumpActionListener() {
        return jumpActionListener;
    }

    public void setJumpActionListener(JumpActionListener jumpActionListener) {
        this.jumpActionListener = jumpActionListener;
    }

    public interface JumpActionListener {

        void jumpToRev(XBCRev rev);
    }
}
