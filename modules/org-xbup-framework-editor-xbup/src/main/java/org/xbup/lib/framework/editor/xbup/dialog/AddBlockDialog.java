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

import java.awt.CardLayout;
import java.awt.Frame;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.xbup.lib.core.block.XBBasicBlockType;
import org.xbup.lib.core.block.XBBlockDataMode;
import org.xbup.lib.core.block.XBBlockType;
import org.xbup.lib.core.block.XBDBlockType;
import org.xbup.lib.core.block.XBFixedBlockType;
import org.xbup.lib.core.block.declaration.XBBlockDecl;
import org.xbup.lib.core.block.declaration.XBDeclBlockType;
import org.xbup.lib.core.block.declaration.XBDeclaration;
import org.xbup.lib.core.block.declaration.catalog.XBCBlockDecl;
import org.xbup.lib.core.block.declaration.catalog.XBCGroupDecl;
import org.xbup.lib.core.catalog.XBACatalog;
import org.xbup.lib.core.catalog.base.XBCBlockRev;
import org.xbup.lib.core.catalog.base.XBCBlockSpec;
import org.xbup.lib.core.catalog.base.XBCRev;
import org.xbup.lib.core.catalog.base.service.XBCXNameService;
import org.xbup.lib.core.parser.token.event.convert.XBTListenerToEventListener;
import org.xbup.lib.core.serial.XBPSerialWriter;
import org.xbup.lib.framework.gui.utils.ActionUtils;
import org.xbup.lib.framework.gui.utils.WindowUtils;
import org.xbup.lib.framework.service_manager.catalog.dialog.CatalogSelectSpecDialog;
import org.xbup.lib.framework.service_manager.catalog.panel.CatalogSpecItemType;
import org.xbup.lib.parser_tree.XBTTreeNode;
import org.xbup.lib.parser_tree.XBTTreeReader;

/**
 * Dialog for adding new item into given document.
 *
 * @version 0.2.0 2016/02/01
 * @author XBUP Project (http://xbup.org)
 */
public class AddBlockDialog extends javax.swing.JDialog {

    private XBTTreeNode parentNode;
    private XBTTreeNode workNode;
    private XBACatalog catalog;
    private XBBlockType contextBlockType = null;
    private XBBlockType catalogBlockType = null;
    private int dialogOption = JOptionPane.CLOSED_OPTION;
    private final java.util.ResourceBundle bundle = ActionUtils.getResourceBundleByClass(AddBlockDialog.class);

    public AddBlockDialog(java.awt.Frame parent, boolean modal, XBACatalog catalog) {
        super(parent, modal);
        this.catalog = catalog;
        workNode = null;
        initComponents();
        fireCatalogUpdate();
        init();
    }

    private void init() {
        reloadBasicTypes();
        ((CardLayout) mainPanel.getLayout()).show(mainPanel, "type");

        WindowUtils.initWindow(this);
        WindowUtils.addHeaderPanel(this, bundle.getString("header.title"), bundle.getString("header.description"), bundle.getString("header.icon"));
        WindowUtils.assignGlobalKeyListener(this, okButton, cancelButton);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        blockTypeButtonGroup = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        typePanel = new javax.swing.JPanel();
        dataRadioButton = new javax.swing.JRadioButton();
        basicTypeRadioButton = new javax.swing.JRadioButton();
        basicTypeComboBox = new javax.swing.JComboBox<>();
        contextTypeRadioButton = new javax.swing.JRadioButton();
        contextTypeSelectButton = new javax.swing.JButton();
        contextTypeTextField = new javax.swing.JTextField();
        catalogTypeRadioButton = new javax.swing.JRadioButton();
        catalogTypeSelectButton = new javax.swing.JButton();
        catalogTypeTextField = new javax.swing.JTextField();
        conditionsPanel = new javax.swing.JPanel();
        generateDeclarationCheckBox = new javax.swing.JCheckBox();
        prefillCheckBox = new javax.swing.JCheckBox();
        controlPanel = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        prevButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/xbup/lib/framework/editor/xbup/dialog/resources/AddBlockDialog"); // NOI18N
        setTitle(bundle.getString("title")); // NOI18N
        setModal(true);

        mainPanel.setLayout(new java.awt.CardLayout());

        typePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("typePanel.border.title"))); // NOI18N

        blockTypeButtonGroup.add(dataRadioButton);
        dataRadioButton.setText(bundle.getString("dataRadioButton.text")); // NOI18N
        dataRadioButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        blockTypeButtonGroup.add(basicTypeRadioButton);
        basicTypeRadioButton.setSelected(true);
        basicTypeRadioButton.setText(bundle.getString("basicTypeRadioButton.text")); // NOI18N
        basicTypeRadioButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        basicTypeRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                basicTypeRadioButtonStateChanged(evt);
            }
        });

        blockTypeButtonGroup.add(contextTypeRadioButton);
        contextTypeRadioButton.setText(bundle.getString("contextTypeRadioButton.text")); // NOI18N
        contextTypeRadioButton.setEnabled(false);
        contextTypeRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                contextTypeRadioButtonStateChanged(evt);
            }
        });

        contextTypeSelectButton.setText(bundle.getString("contextTypeSelectButton.text")); // NOI18N
        contextTypeSelectButton.setEnabled(false);
        contextTypeSelectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contextTypeSelectButtonActionPerformed(evt);
            }
        });

        contextTypeTextField.setEditable(false);

        blockTypeButtonGroup.add(catalogTypeRadioButton);
        catalogTypeRadioButton.setText(bundle.getString("catalogTypeRadioButton.text")); // NOI18N
        catalogTypeRadioButton.setEnabled(false);
        catalogTypeRadioButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                catalogTypeRadioButtonStateChanged(evt);
            }
        });

        catalogTypeSelectButton.setText(bundle.getString("catalogTypeSelectButton.text")); // NOI18N
        catalogTypeSelectButton.setEnabled(false);
        catalogTypeSelectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catalogTypeSelectButtonActionPerformed(evt);
            }
        });

        catalogTypeTextField.setEditable(false);
        catalogTypeTextField.setEnabled(false);

        org.jdesktop.layout.GroupLayout typePanelLayout = new org.jdesktop.layout.GroupLayout(typePanel);
        typePanel.setLayout(typePanelLayout);
        typePanelLayout.setHorizontalGroup(
            typePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, typePanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(typePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(contextTypeRadioButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, catalogTypeRadioButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                    .add(dataRadioButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, basicTypeRadioButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(typePanelLayout.createSequentialGroup()
                        .add(11, 11, 11)
                        .add(catalogTypeTextField)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(catalogTypeSelectButton))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, typePanelLayout.createSequentialGroup()
                        .add(12, 12, 12)
                        .add(basicTypeComboBox, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, typePanelLayout.createSequentialGroup()
                        .add(11, 11, 11)
                        .add(contextTypeTextField)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(contextTypeSelectButton)))
                .addContainerGap())
        );
        typePanelLayout.setVerticalGroup(
            typePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(typePanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(dataRadioButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(basicTypeRadioButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(basicTypeComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(contextTypeRadioButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(typePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(contextTypeSelectButton)
                    .add(contextTypeTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(catalogTypeRadioButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(typePanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(catalogTypeSelectButton)
                    .add(catalogTypeTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        mainPanel.add(typePanel, "type");

        generateDeclarationCheckBox.setSelected(true);
        generateDeclarationCheckBox.setText(bundle.getString("generateDeclarationCheckBox.text")); // NOI18N

        prefillCheckBox.setText(bundle.getString("prefillCheckBox.text")); // NOI18N
        prefillCheckBox.setEnabled(false);

        org.jdesktop.layout.GroupLayout conditionsPanelLayout = new org.jdesktop.layout.GroupLayout(conditionsPanel);
        conditionsPanel.setLayout(conditionsPanelLayout);
        conditionsPanelLayout.setHorizontalGroup(
            conditionsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(conditionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(conditionsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(generateDeclarationCheckBox, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                    .add(conditionsPanelLayout.createSequentialGroup()
                        .add(prefillCheckBox)
                        .add(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        conditionsPanelLayout.setVerticalGroup(
            conditionsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(conditionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(generateDeclarationCheckBox)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(prefillCheckBox)
                .addContainerGap(235, Short.MAX_VALUE))
        );

        mainPanel.add(conditionsPanel, "cond");

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        cancelButton.setText(bundle.getString("cancelButton.text")); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        okButton.setText(bundle.getString("okButton.text")); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        nextButton.setText(bundle.getString("nextButton.text")); // NOI18N
        nextButton.setEnabled(false);
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        prevButton.setText(bundle.getString("prevButton.text")); // NOI18N
        prevButton.setEnabled(false);
        prevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout controlPanelLayout = new org.jdesktop.layout.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
            controlPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, controlPanelLayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .add(prevButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(nextButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(okButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(cancelButton)
                .addContainerGap())
        );
        controlPanelLayout.setVerticalGroup(
            controlPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, controlPanelLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(controlPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cancelButton)
                    .add(okButton)
                    .add(nextButton)
                    .add(prevButton))
                .addContainerGap())
        );

        getContentPane().add(controlPanel, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dialogOption = JOptionPane.CANCEL_OPTION;
        WindowUtils.closeWindow(this);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        dialogOption = JOptionPane.OK_OPTION;
        workNode = new XBTTreeNode();
        if (parentNode != null) {
            workNode.setContext(parentNode.getContext());
        }

        if (dataRadioButton.isSelected()) {
            workNode.setDataMode(XBBlockDataMode.DATA_BLOCK);
        } else if (basicTypeRadioButton.isSelected()) {
            workNode.setBlockType(new XBFixedBlockType(XBBasicBlockType.valueOf(basicTypeComboBox.getSelectedIndex())));
        } else if (contextTypeRadioButton.isSelected()) {
            workNode.setBlockType(contextBlockType);
        } else if (catalogTypeRadioButton.isSelected()) {
            if (generateDeclarationCheckBox.isSelected()) {
                XBPSerialWriter writer = new XBPSerialWriter(new XBTListenerToEventListener(new XBTTreeReader(workNode)));
                XBDeclaration newDeclaration = new XBDeclaration(((XBDBlockType) catalogBlockType).getBlockDecl());
                writer.write(newDeclaration);
                XBTTreeNode newNode = new XBTTreeNode();
                newNode.setBlockType(catalogBlockType);
                workNode.setChildAt(newNode, workNode.getChildrenCount());
            } else {
                workNode.setBlockType(catalogBlockType);
            }
        }

        WindowUtils.closeWindow(this);
    }//GEN-LAST:event_okButtonActionPerformed

    private void contextTypeSelectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contextTypeSelectButtonActionPerformed
        if (catalog != null) {
            ContextTypeChoiceDialog contextTypeDialog = new ContextTypeChoiceDialog((Frame) SwingUtilities.getWindowAncestor(this), true, catalog, parentNode);
            contextTypeDialog.setLocationRelativeTo(this);
            contextTypeDialog.setVisible(true);
            if (contextTypeDialog.getDialogOption() == JOptionPane.OK_OPTION) {
                contextBlockType = contextTypeDialog.getBlockType();
                XBCBlockDecl blockDecl = (XBCBlockDecl) ((XBDeclBlockType) contextBlockType).getBlockDecl();
                XBCBlockSpec blockSpec = blockDecl.getBlockSpecRev().getParent();
                //new XBDeclBlockType(new XBCBlockDecl();
                XBCXNameService nameService = (XBCXNameService) catalog.getCatalogService(XBCXNameService.class);
                String targetCaption = nameService.getItemNamePath(blockSpec);
                if (targetCaption == null) {
                    targetCaption = "";
                } else {
                    targetCaption += " ";
                }
                targetCaption += "(" + Long.toString(blockSpec.getId()) + ")";
                contextTypeTextField.setText(targetCaption);
            }
        }

        updateOkButton();
    }//GEN-LAST:event_contextTypeSelectButtonActionPerformed

    private void catalogTypeSelectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catalogTypeSelectButtonActionPerformed
        if (catalog != null) {
            CatalogSelectSpecDialog selectSpecDialog = new CatalogSelectSpecDialog((Frame) SwingUtilities.getWindowAncestor(this), true, catalog, CatalogSpecItemType.BLOCK);
            selectSpecDialog.setLocationRelativeTo(this);
            selectSpecDialog.setVisible(true);
            if (selectSpecDialog.getDialogOption() == JOptionPane.OK_OPTION) {
                XBCRev blockRev = selectSpecDialog.getTarget();
                catalogBlockType = new XBDeclBlockType(new XBCBlockDecl((XBCBlockRev) blockRev, catalog));
                XBCXNameService nameService = (XBCXNameService) catalog.getCatalogService(XBCXNameService.class);
                String targetCaption = nameService.getItemNamePath(blockRev.getParent());
                if (targetCaption == null) {
                    targetCaption = "";
                } else {
                    targetCaption += " ";
                }
                targetCaption += "(" + Long.toString(blockRev.getId()) + ")";
                catalogTypeTextField.setText(targetCaption);
            }
        }

        updateOkButton();
    }//GEN-LAST:event_catalogTypeSelectButtonActionPerformed

    private void basicTypeRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_basicTypeRadioButtonStateChanged
        basicTypeComboBox.setEnabled(basicTypeRadioButton.isSelected());
    }//GEN-LAST:event_basicTypeRadioButtonStateChanged

    private void contextTypeRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_contextTypeRadioButtonStateChanged
        contextTypeSelectButton.setEnabled(contextTypeRadioButton.isSelected());
        updateOkButton();
    }//GEN-LAST:event_contextTypeRadioButtonStateChanged

    private void catalogTypeRadioButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_catalogTypeRadioButtonStateChanged
        catalogTypeTextField.setEnabled(catalogTypeRadioButton.isSelected());
        catalogTypeSelectButton.setEnabled(catalogTypeRadioButton.isSelected());
        nextButton.setEnabled(catalogTypeRadioButton.isSelected());
        updateOkButton();
    }//GEN-LAST:event_catalogTypeRadioButtonStateChanged

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        ((CardLayout) mainPanel.getLayout()).show(mainPanel, "cond");
        nextButton.setEnabled(false);
        prevButton.setEnabled(true);
    }//GEN-LAST:event_nextButtonActionPerformed

    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevButtonActionPerformed
        ((CardLayout) mainPanel.getLayout()).show(mainPanel, "type");
        nextButton.setEnabled(true);
        prevButton.setEnabled(false);
    }//GEN-LAST:event_prevButtonActionPerformed

    private void updateOkButton() {
        okButton.setEnabled(!(contextTypeRadioButton.isSelected() || catalogTypeRadioButton.isSelected())
                || (contextBlockType != null && contextTypeRadioButton.isSelected())
                || (catalogBlockType != null && catalogTypeRadioButton.isSelected()));
    }

    public XBTTreeNode showDialog() {
        workNode = null;
        setVisible(true);
        return workNode;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        BlockPropertiesDialog propertiesDialog = new BlockPropertiesDialog(new javax.swing.JFrame(), true);
        // TODO propertiesDialog.setDevMode(true);
        WindowUtils.invokeWindow(propertiesDialog);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> basicTypeComboBox;
    private javax.swing.JRadioButton basicTypeRadioButton;
    private javax.swing.ButtonGroup blockTypeButtonGroup;
    private javax.swing.JButton cancelButton;
    private javax.swing.JRadioButton catalogTypeRadioButton;
    private javax.swing.JButton catalogTypeSelectButton;
    private javax.swing.JTextField catalogTypeTextField;
    private javax.swing.JPanel conditionsPanel;
    private javax.swing.JRadioButton contextTypeRadioButton;
    private javax.swing.JButton contextTypeSelectButton;
    private javax.swing.JTextField contextTypeTextField;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JRadioButton dataRadioButton;
    private javax.swing.JCheckBox generateDeclarationCheckBox;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton okButton;
    private javax.swing.JCheckBox prefillCheckBox;
    private javax.swing.JButton prevButton;
    private javax.swing.JPanel typePanel;
    // End of variables declaration//GEN-END:variables

    public void setParentNode(XBTTreeNode parentNode) {
        this.parentNode = parentNode;
        contextTypeRadioButton.setEnabled(parentNode != null && parentNode.getContext().getGroupsCount() > 1);
    }

    public int getDialogOption() {
        return dialogOption;
    }

    public void setCatalog(XBACatalog catalog) {
        this.catalog = catalog;
        reloadBasicTypes();
        fireCatalogUpdate();
    }

    private void fireCatalogUpdate() {
        catalogTypeRadioButton.setEnabled(catalog != null);
    }

    private void reloadBasicTypes() {
        DefaultComboBoxModel<String> model = (DefaultComboBoxModel) basicTypeComboBox.getModel();
        model.removeAllElements();
        if (catalog != null) {
            Long[] basicGroupPath = {0l, 0l};
            List<XBBlockDecl> list = catalog.getBlocks(((XBCGroupDecl) catalog.findGroupTypeByPath(basicGroupPath, 0)).getGroupSpecRev().getParent());

            XBCXNameService nameService = (XBCXNameService) catalog.getCatalogService(XBCXNameService.class);
            for (XBBlockDecl decl : list) {
                model.addElement(nameService.getDefaultText(((XBCBlockDecl) decl).getBlockSpecRev().getParent()));
            }
        }
    }
}
