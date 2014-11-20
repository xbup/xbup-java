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
package org.xbup.tool.editor.module.service_manager.catalog.dialog;

import java.awt.Frame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.xbup.lib.core.catalog.XBACatalog;
import org.xbup.lib.core.catalog.base.XBCBlockSpec;
import org.xbup.lib.core.catalog.base.XBCFormatSpec;
import org.xbup.lib.core.catalog.base.XBCGroupSpec;
import org.xbup.lib.core.catalog.base.XBCRev;
import org.xbup.lib.core.catalog.base.XBCSpec;
import org.xbup.lib.core.catalog.base.XBCSpecDefType;
import org.xbup.lib.core.catalog.base.service.XBCXNameService;
import org.xbup.tool.editor.module.service_manager.catalog.panel.CatalogSpecItemType;
import org.xbup.tool.editor.base.api.XBEditorFrame;
import org.xbup.tool.editor.base.api.utils.WindowUtils;
import org.xbup.tool.editor.module.service_manager.catalog.panel.CatalogDefsTableItem;

/**
 * XBManager Catalog Specification Definition Editor Dialog.
 *
 * @version 0.1.24 2014/11/17
 * @author XBUP Project (http://xbup.org)
 */
public class CatalogSpecDefEditorDialog extends javax.swing.JDialog {

    private int dialogOption = JOptionPane.CLOSED_OPTION;

    private final XBACatalog catalog;

    private XBCSpec spec;
    private CatalogDefsTableItem defItem;
    private CatalogSpecItemType targetType;
    private XBCRev targetRev;

    public CatalogSpecDefEditorDialog(java.awt.Frame parent, boolean modal, XBACatalog catalog) {
        super(parent, modal);
        targetType = CatalogSpecItemType.BLOCK;
        initComponents();
        if (parent instanceof XBEditorFrame) {
            setIconImage(((XBEditorFrame) parent).getMainFrameManagement().getFrameIcon());
        }

        // TODO change listener for definitionTypeComboBox.
        this.catalog = catalog;
        targetRev = null;

        init();
    }

    private void init() {
        WindowUtils.assignGlobalKeyListener(this, okButton, cancelButton);
    }

    public int getDialogOption() {
        return dialogOption;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        controlPanel = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        definitionTypePanel = new javax.swing.JPanel();
        operationLabel = new javax.swing.JLabel();
        operationComboBox = new javax.swing.JComboBox();
        definitionTargetLabel = new javax.swing.JLabel();
        definitionTargetTextField = new javax.swing.JTextField();
        selectTargetButton = new javax.swing.JButton();
        stringIdLabel = new javax.swing.JLabel();
        stringIdTextField = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        descriptionLabel = new javax.swing.JLabel();
        descriptionTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Definition Editor");

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        okButton.setText("Set");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlPanelLayout.createSequentialGroup()
                .addContainerGap(283, Short.MAX_VALUE)
                .addComponent(okButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelButton)
                .addContainerGap())
        );
        controlPanelLayout.setVerticalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton))
                .addContainerGap())
        );

        getContentPane().add(controlPanel, java.awt.BorderLayout.PAGE_END);

        operationLabel.setText("Operation");

        operationComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Consist", "Join" }));
        operationComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                operationComboBoxItemStateChanged(evt);
            }
        });

        definitionTargetLabel.setText("Target Type");

        definitionTargetTextField.setEditable(false);

        selectTargetButton.setText("Select...");
        selectTargetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectTargetButtonActionPerformed(evt);
            }
        });

        stringIdLabel.setText("String Id");

        nameLabel.setText("Name");

        descriptionLabel.setText("Description");

        javax.swing.GroupLayout definitionTypePanelLayout = new javax.swing.GroupLayout(definitionTypePanel);
        definitionTypePanel.setLayout(definitionTypePanelLayout);
        definitionTypePanelLayout.setHorizontalGroup(
            definitionTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(definitionTypePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(definitionTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(operationComboBox, 0, 422, Short.MAX_VALUE)
                    .addGroup(definitionTypePanelLayout.createSequentialGroup()
                        .addComponent(definitionTargetTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(selectTargetButton))
                    .addComponent(stringIdTextField)
                    .addComponent(nameTextField)
                    .addComponent(descriptionTextField)
                    .addGroup(definitionTypePanelLayout.createSequentialGroup()
                        .addGroup(definitionTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(operationLabel)
                            .addComponent(definitionTargetLabel)
                            .addComponent(stringIdLabel)
                            .addComponent(nameLabel)
                            .addComponent(descriptionLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        definitionTypePanelLayout.setVerticalGroup(
            definitionTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(definitionTypePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(operationLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(operationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(definitionTargetLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(definitionTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(definitionTargetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectTargetButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stringIdLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stringIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descriptionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(definitionTypePanel, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(456, 341));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dialogOption = JOptionPane.CANCEL_OPTION;
        WindowUtils.closeWindow(this);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        String operation = (String) operationComboBox.getModel().getSelectedItem();
        XBCRev target = targetRev;

        if (target == null && ("Consist".equals(operation) || "Join".equals(operation))) {
            JOptionPane.showMessageDialog(this, "Target Type is required", "Set is not allowed", JOptionPane.ERROR_MESSAGE);
            return;
        }

        defItem.setName(nameTextField.getText());
        defItem.setDescription(descriptionTextField.getText());
        defItem.setStringId(stringIdTextField.getText());
        defItem.setDefType(getSpecDefType());
        defItem.setOperation(operation);
        defItem.setTarget(target);

        XBCXNameService nameService = (XBCXNameService) catalog.getCatalogService(XBCXNameService.class);
        defItem.setType(target != null ? nameService.getDefaultText(target.getParent()) : null);
        defItem.setTargetRevision(target != null ? target.getXBIndex() : null);

        dialogOption = JOptionPane.OK_OPTION;
        WindowUtils.closeWindow(this);
    }//GEN-LAST:event_okButtonActionPerformed

    private void selectTargetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectTargetButtonActionPerformed
        CatalogSelectSpecDialog specSelectDialog = new CatalogSelectSpecDialog((Frame) SwingUtilities.getWindowAncestor(this), true, catalog, targetType);
        specSelectDialog.setVisible(true);
        if (specSelectDialog.getDialogOption() == JOptionPane.OK_OPTION) {
            setTargetRev(specSelectDialog.getTarget());
        }
    }//GEN-LAST:event_selectTargetButtonActionPerformed

    private void operationComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_operationComboBoxItemStateChanged
        updateSpecDefType();
    }//GEN-LAST:event_operationComboBoxItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        WindowUtils.invokeWindow(new CatalogSpecDefEditorDialog(new javax.swing.JFrame(), true, null));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JLabel definitionTargetLabel;
    private javax.swing.JTextField definitionTargetTextField;
    private javax.swing.JPanel definitionTypePanel;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JTextField descriptionTextField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JButton okButton;
    private javax.swing.JComboBox operationComboBox;
    private javax.swing.JLabel operationLabel;
    private javax.swing.JButton selectTargetButton;
    private javax.swing.JLabel stringIdLabel;
    private javax.swing.JTextField stringIdTextField;
    // End of variables declaration//GEN-END:variables

    public void setSpec(XBCSpec spec) {
        this.spec = spec;
        if (spec instanceof XBCBlockSpec) {
            operationComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Consist", "Join", "Attribute", "Blob", "List Consist", "List Join"}));
            switchSpecDefType(CatalogSpecItemType.BLOCK);
        } else {
            operationComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Consist", "Join"}));
            if (spec instanceof XBCGroupSpec) {
                switchSpecDefType(CatalogSpecItemType.BLOCK);
            } else {
                switchSpecDefType(CatalogSpecItemType.GROUP);
            }
        }
    }

    public CatalogDefsTableItem getDefItem() {
        return defItem;
    }

    public void setDefItem(CatalogDefsTableItem defItem) {
        this.defItem = defItem;

        nameTextField.setText(defItem.getName());
        descriptionTextField.setText(defItem.getDescription());
        stringIdTextField.setText(defItem.getStringId());

        setTargetRev(defItem.getTarget());

        if (defItem.getDefType() == null) {
            defItem.setDefType(getSpecDefType());
        }

        switch (defItem.getDefType()) {
            case CONS: {
                operationComboBox.setSelectedIndex((defItem.getTarget() == null) && (operationComboBox.getItemCount() > 3) ? 3 : 0);
                break;
            }
            case JOIN: {
                operationComboBox.setSelectedIndex((defItem.getTarget() == null) && (operationComboBox.getItemCount() > 2) ? 2 : 1);
                break;
            }
            case LIST_CONS: {
                operationComboBox.setSelectedIndex(4);
                break;
            }
            case LIST_JOIN: {
                operationComboBox.setSelectedIndex(5);
                break;
            }
        }

        updateSpecDefType();
    }

    public XBCSpecDefType getSpecDefType() {
        if (spec instanceof XBCBlockSpec) {
            switch (operationComboBox.getSelectedIndex()) {
                case 0:
                    return XBCSpecDefType.CONS;
                case 1:
                    return XBCSpecDefType.JOIN;
                case 2:
                    return XBCSpecDefType.JOIN; // Attribute
                case 3:
                    return XBCSpecDefType.CONS; // Blob
                case 4:
                    return XBCSpecDefType.LIST_CONS;
                case 5:
                    return XBCSpecDefType.LIST_JOIN;
                default:
                    return XBCSpecDefType.CONS;
            }
        } else {
            if (operationComboBox.getSelectedIndex() == 0) {
                return XBCSpecDefType.CONS;
            } else {
                return XBCSpecDefType.JOIN;
            }
        }
    }

    private void switchSpecDefType(CatalogSpecItemType newType) {
        definitionTargetTextField.setText("");
        targetType = newType;
        targetRev = null;
    }

    private void updateSpecDefType() {
        if (spec instanceof XBCBlockSpec) {
            if (operationComboBox.getSelectedIndex() == 2 || operationComboBox.getSelectedIndex() == 3) {
                switchSpecDefType(CatalogSpecItemType.BLOCK);
            }
        } else if (spec instanceof XBCGroupSpec) {
            if (operationComboBox.getSelectedIndex() == 0) {
                switchSpecDefType(CatalogSpecItemType.BLOCK);
            } else {
                switchSpecDefType(CatalogSpecItemType.GROUP);
            }
        } else if (spec instanceof XBCFormatSpec) {
            if (operationComboBox.getSelectedIndex() == 0) {
                switchSpecDefType(CatalogSpecItemType.GROUP);
            } else {
                switchSpecDefType(CatalogSpecItemType.FORMAT);
            }
        }

        if (spec instanceof XBCBlockSpec) {
            boolean enabled = !((operationComboBox.getSelectedIndex() == 2) || (operationComboBox.getSelectedIndex() == 3));
            selectTargetButton.setEnabled(enabled);
        } else {
            selectTargetButton.setEnabled(true);
        }
    }

    private void setTargetRev(XBCRev targetRev) {
        this.targetRev = targetRev;
        if (targetRev != null) {
            XBCXNameService nameService = (XBCXNameService) catalog.getCatalogService(XBCXNameService.class);
            String targetCaption = nameService.getItemNamePath(targetRev.getParent());
            if (targetCaption == null) {
                targetCaption = "";
            } else {
                targetCaption += " ";
            }
            targetCaption += "(" + Long.toString(targetRev.getParent().getId()) + ")";
            definitionTargetTextField.setText(targetCaption);

        } else {
            definitionTargetTextField.setText("");
        }
    }
}
