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
package org.xbup.lib.framework.editor.xbup.dialog;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import org.xbup.lib.core.block.XBBlockType;
import org.xbup.lib.core.block.declaration.XBBlockDecl;
import org.xbup.lib.core.block.declaration.XBContext;
import org.xbup.lib.core.block.declaration.XBDeclBlockType;
import org.xbup.lib.core.block.declaration.XBGroup;
import org.xbup.lib.core.block.declaration.catalog.XBCBlockDecl;
import org.xbup.lib.core.catalog.XBACatalog;
import org.xbup.lib.core.catalog.base.service.XBCXNameService;
import org.xbup.lib.framework.gui.utils.WindowUtils;
import org.xbup.lib.parser_tree.XBTTreeNode;

/**
 * Dialog for adding new item into given document.
 *
 * @version 0.1.24 2014/11/21
 * @author XBUP Project (http://xbup.org)
 */
public class ContextTypeChoiceDialog extends javax.swing.JDialog {

    private XBTTreeNode parentNode;
    private final XBACatalog catalog;
    private int dialogOption = JOptionPane.CLOSED_OPTION;
    private int selectedGroup;
    private final XBCXNameService nameService;

    public ContextTypeChoiceDialog(java.awt.Frame parent, boolean modal, XBACatalog catalog, XBTTreeNode parentNode) {
        super(parent, modal);
        this.catalog = catalog;
        this.parentNode = parentNode;

        nameService = (XBCXNameService) catalog.getCatalogService(XBCXNameService.class);

        initComponents();
        init();
    }

    private void init() {
        if (catalog != null && parentNode != null) {
            XBContext context = parentNode.getContext();
            int groupId = 1;
            for (XBGroup typeGroup : context.getGroups()) {
                groupComboBox.addItem(Integer.toString(groupId)); // TODO group description if available
                groupId++;
            }
        }

        WindowUtils.initWindow(this);
        WindowUtils.assignGlobalKeyListener(this, okButton, cancelButton);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        groupLabel = new javax.swing.JLabel();
        groupComboBox = new javax.swing.JComboBox<>();
        blockLabel = new javax.swing.JLabel();
        blockTypeScrollPane = new javax.swing.JScrollPane();
        blockTypeList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/xbup/lib/framework/editor/xbup/dialog/resources/ContextTypeChoiceDialog"); // NOI18N
        setTitle(bundle.getString("title")); // NOI18N
        setModal(true);

        okButton.setText(bundle.getString("okButton.text")); // NOI18N
        okButton.setEnabled(false);
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText(bundle.getString("cancelButton.text")); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        groupLabel.setText("Type Group");

        groupComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupComboBoxActionPerformed(evt);
            }
        });

        blockLabel.setText("Block Type");

        blockTypeList.setModel(new DefaultListModel<String>());
        blockTypeList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        blockTypeList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                blockTypeListValueChanged(evt);
            }
        });
        blockTypeScrollPane.setViewportView(blockTypeList);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(blockTypeScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(okButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(cancelButton))
                    .add(groupComboBox, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(groupLabel)
                            .add(blockLabel))
                        .add(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(groupLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(groupComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(blockLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(blockTypeScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cancelButton)
                    .add(okButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dialogOption = JOptionPane.CANCEL_OPTION;
        WindowUtils.closeWindow(this);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        dialogOption = JOptionPane.OK_OPTION;

        WindowUtils.closeWindow(this);
    }//GEN-LAST:event_okButtonActionPerformed

    private void groupComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupComboBoxActionPerformed
        ((DefaultListModel<String>) blockTypeList.getModel()).removeAllElements();
        if (parentNode != null) {
            XBContext context = parentNode.getContext();
            selectedGroup = groupComboBox.getSelectedIndex() + 1;
            if (selectedGroup >= 0) {
                XBGroup groupForId = context.getGroupForId(selectedGroup);
                if (groupForId != null) {
                    int blockId = 0;
                    for (XBBlockDecl blockDecl : groupForId.getBlocks()) {
                        String blockCaption = Integer.toString(blockId);
                        if (blockDecl != null) {
                            if (blockDecl instanceof XBCBlockDecl) {
                                blockCaption += ": " + nameService.getDefaultText(((XBCBlockDecl) blockDecl).getBlockSpecRev().getParent());
                            }
                        }

                        ((DefaultListModel<String>) blockTypeList.getModel()).addElement(blockCaption);
                        blockId++;
                    }
                }
            }
        }
    }//GEN-LAST:event_groupComboBoxActionPerformed

    private void blockTypeListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_blockTypeListValueChanged
        if (!evt.getValueIsAdjusting()) {
            okButton.setEnabled(blockTypeList.getSelectedIndex() >= 0);
        }
    }//GEN-LAST:event_blockTypeListValueChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        BlockPropertiesDialog propertiesDialog = new BlockPropertiesDialog(new javax.swing.JFrame(), true);
        // TODO propertiesDialog.setDevMode(true);
        WindowUtils.invokeWindow(propertiesDialog);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel blockLabel;
    private javax.swing.JList<String> blockTypeList;
    private javax.swing.JScrollPane blockTypeScrollPane;
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox<String> groupComboBox;
    private javax.swing.JLabel groupLabel;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables

    public void setParentNode(XBTTreeNode parentNode) {
        this.parentNode = parentNode;
    }

    public int getDialogOption() {
        return dialogOption;
    }

    public XBBlockType getBlockType() {
        if (selectedGroup >= 0) {
            XBContext context = parentNode.getContext();
            XBGroup groupForId = context.getGroupForId(selectedGroup);
            XBBlockDecl blockDecl = groupForId.getBlockForId(blockTypeList.getSelectedIndex());
            return blockDecl != null ? new XBDeclBlockType(blockDecl) : null;
        }

        return null;
    }
}
