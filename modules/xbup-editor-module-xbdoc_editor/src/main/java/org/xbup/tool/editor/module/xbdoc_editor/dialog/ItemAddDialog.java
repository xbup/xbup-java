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

import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.xbup.lib.core.block.XBBlockDataMode;
import org.xbup.lib.core.block.declaration.XBBlockDecl;
import org.xbup.lib.core.block.declaration.XBContext;
import org.xbup.lib.core.catalog.XBACatalog;
import org.xbup.lib.core.catalog.base.XBCBlockSpec;
import org.xbup.lib.core.catalog.base.XBCGroupSpec;
import org.xbup.lib.core.catalog.base.service.XBCXNameService;
import org.xbup.lib.parser_tree.XBTTreeNode;
import org.xbup.lib.core.ubnumber.type.UBNat32;
import org.xbup.tool.editor.module.service_manager.catalog.dialog.CatalogSelectSpecDialog;
import org.xbup.tool.editor.module.service_manager.catalog.panel.CatalogSpecItemType;
import org.xbup.tool.editor.base.api.XBEditorFrame;

/**
 * Dialog for adding new item into given document.
 *
 * @version 0.1.23 2013/09/23
 * @author XBUP Project (http://xbup.org)
 */
public class ItemAddDialog extends javax.swing.JDialog {

    private XBTTreeNode parentNode;
    private XBTTreeNode workNode;
    private XBACatalog catalog;
    private XBCBlockSpec blockSpec;

    /** Creates new form NewItem */
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
            Long[] basicGroupPath = { new Long(0), new Long(0) };
            List<XBBlockDecl> list = catalog.getBlocks((XBCGroupSpec) catalog.findGroupTypeByPath(basicGroupPath, 0));

            XBCXNameService nameExtension = (XBCXNameService) catalog.getCatalogService(XBCXNameService.class);
            for (int i = 1; i < list.size(); i++) {
                XBBlockDecl decl = list.get(i);
                if (decl instanceof XBCBlockSpec) {
                    basicTypeComboBox.addItem(nameExtension.getDefaultCaption((XBCBlockSpec) decl));
                }
            }
        }

        assignGlobalKeyListener(this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        okButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        emptyNodeRadioButton = new javax.swing.JRadioButton();
        emptyDataRadioButton = new javax.swing.JRadioButton();
        basicTypeRadioButton = new javax.swing.JRadioButton();
        basicTypeComboBox = new javax.swing.JComboBox();
        basicTypeAdvancedButton = new javax.swing.JButton();
        localTypeRadioButton = new javax.swing.JRadioButton();
        localTypeComboBox = new javax.swing.JComboBox();
        localTypeAdvancedButton = new javax.swing.JButton();
        catalogTypeRadioButton = new javax.swing.JRadioButton();
        catalogTypeSelectButton = new javax.swing.JButton();
        catalogTypeTextField = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/xbup/tool/xbeditor/module/xbdoceditor/dialog/resources/ItemAddDialog"); // NOI18N
        setTitle(bundle.getString("title")); // NOI18N
        setLocationByPlatform(true);
        setModal(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        okButton.setText(bundle.getString("okButton.text")); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("jPanel1.border.title"))); // NOI18N

        buttonGroup1.add(emptyNodeRadioButton);
        emptyNodeRadioButton.setSelected(true);
        emptyNodeRadioButton.setText(bundle.getString("jRadioButton1.text")); // NOI18N
        emptyNodeRadioButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        buttonGroup1.add(emptyDataRadioButton);
        emptyDataRadioButton.setText(bundle.getString("jRadioButton2.text")); // NOI18N
        emptyDataRadioButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        buttonGroup1.add(basicTypeRadioButton);
        basicTypeRadioButton.setText(bundle.getString("jRadioButton3.text")); // NOI18N
        basicTypeRadioButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        basicTypeRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                basicTypeRadioButtonStateChanged(evt);
            }
        });

        basicTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Unknown" }));
        basicTypeComboBox.setEnabled(false);

        basicTypeAdvancedButton.setText(bundle.getString("jButton1.text")); // NOI18N
        basicTypeAdvancedButton.setEnabled(false);
        basicTypeAdvancedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                basicTypeAdvancedButtonActionPerformed(evt);
            }
        });

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

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(catalogTypeRadioButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                            .add(localTypeRadioButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, emptyDataRadioButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                            .add(basicTypeRadioButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                            .add(emptyNodeRadioButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                                .add(12, 12, 12)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .add(localTypeComboBox, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(localTypeAdvancedButton))
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .add(basicTypeComboBox, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(basicTypeAdvancedButton))))))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(23, 23, 23)
                        .add(catalogTypeTextField)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(catalogTypeSelectButton)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(emptyNodeRadioButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(emptyDataRadioButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(basicTypeRadioButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(basicTypeAdvancedButton)
                    .add(basicTypeComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(localTypeRadioButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(localTypeAdvancedButton)
                    .add(localTypeComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(catalogTypeRadioButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
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
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 16, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cancelButton)
                    .add(okButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        workNode = new XBTTreeNode();
        
        // TODO
        /*
        if (basicTypeRadioButton.isSelected()) {
            workNode.clearAttributes();
            workNode.setBlockType(new XBContextBlockType(0, basicTypeComboBox.getSelectedIndex()));
            if (parentNode != null && parentNode.getBlockType() instanceof XBContextBlockType) {
                XBContext context = ((XBContextBlockType) parentNode.getBlockType()).getContext();
                ((XBContextBlockType) workNode.getBlockType()).setContext(context);
            }
        } else if (emptyNodeRadioButton.isSelected()) {
            workNode.clearAttributes();
            workNode.setBlockType(new XBContextBlockType(0, 0));
            workNode.addAttribute(new UBNat32());
            if (parentNode != null && parentNode.getBlockType() instanceof XBContextBlockType) {
                XBContext context = ((XBContextBlockType) parentNode.getBlockType()).getContext();
                ((XBContextBlockType) workNode.getBlockType()).setContext(context);
            }
        } else if (emptyDataRadioButton.isSelected()) {
            workNode.setDataMode(XBBlockDataMode.DATA_BLOCK);
        } else {
            workNode.setDataMode(XBBlockDataMode.NODE_BLOCK);
        } */

        setVisible(false);
        dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void basicTypeAdvancedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_basicTypeAdvancedButtonActionPerformed
        // Add your handling code here:
    }//GEN-LAST:event_basicTypeAdvancedButtonActionPerformed

    /** Closes the dialog */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void localTypeAdvancedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_localTypeAdvancedButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_localTypeAdvancedButtonActionPerformed

    private void catalogTypeSelectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catalogTypeSelectButtonActionPerformed
        if (catalog != null) {
            CatalogSelectSpecDialog selectSpecDialog = new CatalogSelectSpecDialog((Frame) SwingUtilities.getWindowAncestor(this), true, catalog, CatalogSpecItemType.BLOCK);
            selectSpecDialog.setVisible(true);
            if (selectSpecDialog.getOption() == JOptionPane.OK_OPTION) {
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton basicTypeAdvancedButton;
    private javax.swing.JComboBox basicTypeComboBox;
    private javax.swing.JRadioButton basicTypeRadioButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelButton;
    private javax.swing.JRadioButton catalogTypeRadioButton;
    private javax.swing.JButton catalogTypeSelectButton;
    private javax.swing.JTextField catalogTypeTextField;
    private javax.swing.JRadioButton emptyDataRadioButton;
    private javax.swing.JRadioButton emptyNodeRadioButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton localTypeAdvancedButton;
    private javax.swing.JComboBox localTypeComboBox;
    private javax.swing.JRadioButton localTypeRadioButton;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables

    /** Assign ESCAPE/ENTER key for all focusable components recursively */
    private void assignGlobalKeyListener(Container comp) {
        Component[] comps = comp.getComponents();
        for (int i = 0; i < comps.length; i++) {
            Component item = comps[i];
            if (item.isFocusable()) {
                item.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                    }

                    @Override
                    public void keyPressed(KeyEvent evt) {
                        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
                            cancelButton.doClick();
                        }
                        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                            if (evt.getSource() instanceof JButton) {
                                ((JButton) evt.getSource()).doClick();
                            } else {
                                okButton.doClick();
                            }
                        }
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });
            }
            if (item instanceof Container) {
                assignGlobalKeyListener((Container) item);
            }
        }
    }

    public void setParentNode(XBTTreeNode parentNode) {
        this.parentNode = parentNode;
    }
}
