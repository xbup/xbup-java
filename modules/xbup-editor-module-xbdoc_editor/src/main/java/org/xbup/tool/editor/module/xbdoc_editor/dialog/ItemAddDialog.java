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

import java.awt.Frame;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.xbup.lib.core.block.XBBasicBlockType;
import org.xbup.lib.core.block.XBBlockDataMode;
import org.xbup.lib.core.block.XBFixedBlockType;
import org.xbup.lib.core.block.declaration.XBBlockDecl;
import org.xbup.lib.core.block.declaration.XBContext;
import org.xbup.lib.core.block.declaration.XBDeclBlockType;
import org.xbup.lib.core.block.declaration.catalog.XBCGroupDecl;
import org.xbup.lib.core.catalog.XBACatalog;
import org.xbup.lib.core.catalog.base.XBCBlockSpec;
import org.xbup.lib.core.catalog.base.service.XBCXNameService;
import org.xbup.lib.core.ubnumber.type.UBNat32;
import org.xbup.lib.parser_tree.XBTTreeNode;
import org.xbup.tool.editor.module.service_manager.catalog.dialog.CatalogSelectSpecDialog;
import org.xbup.tool.editor.module.service_manager.catalog.panel.CatalogSpecItemType;
import org.xbup.tool.editor.base.api.XBEditorFrame;
import org.xbup.tool.editor.base.api.utils.WindowUtils;

/**
 * Dialog for adding new item into given document.
 *
 * @version 0.1.24 2014/11/11
 * @author XBUP Project (http://xbup.org)
 */
public class ItemAddDialog extends javax.swing.JDialog {

    private XBTTreeNode parentNode;
    private XBTTreeNode workNode;
    private final XBACatalog catalog;
    private XBCBlockSpec blockSpec;
    private int dialogOption = JOptionPane.CANCEL_OPTION;

    public ItemAddDialog(java.awt.Frame parent, boolean modal, XBACatalog catalog) {
        super(parent, modal);
        this.catalog = catalog;
        if (parent instanceof XBEditorFrame) {
            setIconImage(((XBEditorFrame) parent).getMainFrameManagement().getFrameIcon());
        }

        init();
    }

    private void init() {
        workNode = null;
        initComponents();

        if (catalog != null) {
            Long[] basicGroupPath = {0l, 0l};
            List<XBBlockDecl> list = catalog.getBlocks(((XBCGroupDecl) catalog.findGroupTypeByPath(basicGroupPath, 0)).getGroupSpec().getParent());

            XBCXNameService nameExtension = (XBCXNameService) catalog.getCatalogService(XBCXNameService.class);
            for (int i = 1; i < list.size(); i++) {
                XBBlockDecl decl = list.get(i);
                if (decl instanceof XBCBlockSpec) {
                    basicTypeComboBox.addItem(nameExtension.getDefaultCaption((XBCBlockSpec) decl));
                }
            }
        }

        WindowUtils.assignGlobalKeyListener(this, okButton, cancelButton);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        okButton = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        dataRadioButton = new javax.swing.JRadioButton();
        basicTypeRadioButton = new javax.swing.JRadioButton();
        basicTypeComboBox = new javax.swing.JComboBox();
        localTypeRadioButton = new javax.swing.JRadioButton();
        localTypeComboBox = new javax.swing.JComboBox();
        localTypeAdvancedButton = new javax.swing.JButton();
        catalogTypeRadioButton = new javax.swing.JRadioButton();
        catalogTypeSelectButton = new javax.swing.JButton();
        catalogTypeTextField = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/xbup/tool/editor/module/xbdoc_editor/dialog/resources/ItemAddDialog"); // NOI18N
        setTitle(bundle.getString("title")); // NOI18N
        setLocationByPlatform(true);
        setModal(true);

        okButton.setText(bundle.getString("okButton.text")); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        mainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("jPanel1.border.title"))); // NOI18N

        buttonGroup1.add(dataRadioButton);
        dataRadioButton.setText(bundle.getString("jRadioButton2.text")); // NOI18N
        dataRadioButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        buttonGroup1.add(basicTypeRadioButton);
        basicTypeRadioButton.setSelected(true);
        basicTypeRadioButton.setText(bundle.getString("jRadioButton3.text")); // NOI18N
        basicTypeRadioButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        basicTypeRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                basicTypeRadioButtonStateChanged(evt);
            }
        });

        basicTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Unknown", "Declaration", "Format Declaration", "Group Declaration", "Block Declaration", "Format Definition", "Group Definition", "Block Definition", "List Definition", "Revision Definition" }));

        buttonGroup1.add(localTypeRadioButton);
        localTypeRadioButton.setText(bundle.getString("jRadioButton4.text")); // NOI18N
        localTypeRadioButton.setEnabled(false);
        localTypeRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                localTypeRadioButtonStateChanged(evt);
            }
        });

        localTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "data block" }));
        localTypeComboBox.setEnabled(false);

        localTypeAdvancedButton.setText(bundle.getString("jButton4.text")); // NOI18N
        localTypeAdvancedButton.setEnabled(false);
        localTypeAdvancedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                localTypeAdvancedButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(catalogTypeRadioButton);
        catalogTypeRadioButton.setText(bundle.getString("jRadioButton5.text")); // NOI18N
        catalogTypeRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                catalogTypeRadioButtonStateChanged(evt);
            }
        });

        catalogTypeSelectButton.setText(bundle.getString("jButton5.text")); // NOI18N
        catalogTypeSelectButton.setEnabled(false);
        catalogTypeSelectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catalogTypeSelectButtonActionPerformed(evt);
            }
        });

        catalogTypeTextField.setEditable(false);
        catalogTypeTextField.setToolTipText("");
        catalogTypeTextField.setEnabled(false);

        org.jdesktop.layout.GroupLayout mainPanelLayout = new org.jdesktop.layout.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, catalogTypeRadioButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, localTypeRadioButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .add(dataRadioButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, basicTypeRadioButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .add(mainPanelLayout.createSequentialGroup()
                        .add(11, 11, 11)
                        .add(catalogTypeTextField)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(catalogTypeSelectButton))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, mainPanelLayout.createSequentialGroup()
                        .add(12, 12, 12)
                        .add(mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(basicTypeComboBox, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(mainPanelLayout.createSequentialGroup()
                                .add(localTypeComboBox, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(localTypeAdvancedButton)))))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(dataRadioButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(basicTypeRadioButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(basicTypeComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(localTypeRadioButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(localTypeAdvancedButton)
                    .add(localTypeComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(catalogTypeRadioButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(mainPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(catalogTypeSelectButton)
                    .add(catalogTypeTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cancelButton.setText(bundle.getString("cancelButton.text")); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, mainPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(okButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(cancelButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(mainPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 16, Short.MAX_VALUE)
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
        workNode = new XBTTreeNode();

        if (dataRadioButton.isSelected()) {
            workNode.setDataMode(XBBlockDataMode.DATA_BLOCK);
        } else if (basicTypeRadioButton.isSelected()) {
            workNode.setBlockType(new XBFixedBlockType(XBBasicBlockType.valueOf(basicTypeComboBox.getSelectedIndex())));
        } else if (localTypeRadioButton.isSelected()) {
            throw new UnsupportedOperationException("Not supported yet.");
        } else {
            workNode.setDataMode(XBBlockDataMode.NODE_BLOCK);
        }
        WindowUtils.closeWindow(this);
    }//GEN-LAST:event_okButtonActionPerformed

    private void localTypeAdvancedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_localTypeAdvancedButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_localTypeAdvancedButtonActionPerformed

    private void catalogTypeSelectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catalogTypeSelectButtonActionPerformed
        if (catalog != null) {
            CatalogSelectSpecDialog selectSpecDialog = new CatalogSelectSpecDialog((Frame) SwingUtilities.getWindowAncestor(this), true, catalog, CatalogSpecItemType.BLOCK);
            selectSpecDialog.setVisible(true);
            if (selectSpecDialog.getDialogOption() == JOptionPane.OK_OPTION) {
                blockSpec = (XBCBlockSpec) selectSpecDialog.getSpec();
                catalogTypeTextField.setText(blockSpec.getId().toString());
            }
        }
    }//GEN-LAST:event_catalogTypeSelectButtonActionPerformed

    private void basicTypeRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_basicTypeRadioButtonStateChanged
        basicTypeComboBox.setEnabled(basicTypeRadioButton.isSelected());
    }//GEN-LAST:event_basicTypeRadioButtonStateChanged

    private void localTypeRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_localTypeRadioButtonStateChanged
        localTypeComboBox.setEnabled(localTypeRadioButton.isSelected());
    }//GEN-LAST:event_localTypeRadioButtonStateChanged

    private void catalogTypeRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_catalogTypeRadioButtonStateChanged
        catalogTypeTextField.setEnabled(catalogTypeRadioButton.isSelected());
        catalogTypeSelectButton.setEnabled(catalogTypeRadioButton.isSelected());
    }//GEN-LAST:event_catalogTypeRadioButtonStateChanged

    public XBTTreeNode showDialog() {
        workNode = null;
        setVisible(true);
        return workNode;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        WindowUtils.invokeWindow(new ItemPropertiesDialog(new javax.swing.JFrame(), true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox basicTypeComboBox;
    private javax.swing.JRadioButton basicTypeRadioButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelButton;
    private javax.swing.JRadioButton catalogTypeRadioButton;
    private javax.swing.JButton catalogTypeSelectButton;
    private javax.swing.JTextField catalogTypeTextField;
    private javax.swing.JRadioButton dataRadioButton;
    private javax.swing.JButton localTypeAdvancedButton;
    private javax.swing.JComboBox localTypeComboBox;
    private javax.swing.JRadioButton localTypeRadioButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables

    public void setParentNode(XBTTreeNode parentNode) {
        this.parentNode = parentNode;
    }

    public int getDialogOption() {
        return dialogOption;
    }
}
