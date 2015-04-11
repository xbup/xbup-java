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

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JOptionPane;
import org.xbup.lib.core.catalog.XBACatalog;
import org.xbup.lib.core.catalog.base.XBCItem;
import org.xbup.lib.core.catalog.base.XBCRev;
import org.xbup.lib.core.catalog.base.XBCSpec;
import org.xbup.lib.core.catalog.base.service.XBCRevService;
import org.xbup.tool.editor.module.service_manager.catalog.panel.CatalogSpecItemType;
import org.xbup.tool.editor.utils.WindowUtils;
import org.xbup.tool.editor.module.service_manager.catalog.panel.CatalogItemsSearchPanel;
import org.xbup.tool.editor.module.service_manager.catalog.panel.CatalogRevsComboBoxModel;

/**
 * XBManager Catalog Specification Selection Dialog.
 *
 * @version 0.1.24 2014/12/12
 * @author XBUP Project (http://xbup.org)
 */
public class CatalogSelectSpecDialog extends javax.swing.JDialog {

    private XBCRevService revService;
    private final CatalogItemsSearchPanel selectSpecPanel;
    private int dialogOption = JOptionPane.CLOSED_OPTION;
    private XBCItem specification;
    private CatalogRevsComboBoxModel revsModel;

    public CatalogSelectSpecDialog(java.awt.Frame parent, boolean modal, XBACatalog catalog, CatalogSpecItemType specType) {
        super(parent, modal);
        revsModel = new CatalogRevsComboBoxModel();
        initComponents();

        if (catalog != null) {
            revService = (XBCRevService) catalog.getCatalogService(XBCRevService.class);
        }

        selectSpecPanel = new CatalogItemsSearchPanel();
        selectSpecPanel.setCatalog(catalog);
        mainPanel.add(selectSpecPanel);
        selectSpecPanel.setSelectionListener(new CatalogItemsSearchPanel.SelectionListener() {

            @Override
            public void selectedItem(XBCItem spec) {
                if (spec != null) {
                    if (spec instanceof XBCSpec) {
                        revsModel.setRevs(revService.getRevs((XBCSpec) spec));
                        targetRevisionComboBox.setSelectedIndex(revsModel.getSize() - 1);
                        selectButton.setEnabled(true);
                    } else {
                        revsModel.getRevs().clear();
                    }
                } else {
                    selectButton.setEnabled(false);
                    targetRevisionComboBox.setSelectedIndex(-1);
                    revsModel.getRevs().clear();
                }

                revsModel.fireDataChanged();
            }
        });

        targetRevisionComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                DefaultListCellRenderer retValue = (DefaultListCellRenderer) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof XBCRev) {
                    retValue.setText("Revision " + ((XBCRev) value).getXBIndex());
                }

                return retValue;
            }
        });

        init();
        
        selectSpecPanel.switchToSpecTypeMode(specType);
    }

    private void init() {
        WindowUtils.initWindow(this);
        WindowUtils.assignGlobalKeyListener(this, selectButton, cancelButton);
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

        mainPanel = new javax.swing.JPanel();
        revisionSelectionPanel = new javax.swing.JPanel();
        targetRevisionComboBox = new javax.swing.JComboBox();
        controlPanel = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        selectButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Select Specification");

        mainPanel.setLayout(new java.awt.BorderLayout());

        targetRevisionComboBox.setModel(revsModel);

        javax.swing.GroupLayout revisionSelectionPanelLayout = new javax.swing.GroupLayout(revisionSelectionPanel);
        revisionSelectionPanel.setLayout(revisionSelectionPanelLayout);
        revisionSelectionPanelLayout.setHorizontalGroup(
            revisionSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(revisionSelectionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(targetRevisionComboBox, 0, 484, Short.MAX_VALUE)
                .addContainerGap())
        );
        revisionSelectionPanelLayout.setVerticalGroup(
            revisionSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, revisionSelectionPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(targetRevisionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        mainPanel.add(revisionSelectionPanel, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        selectButton.setText("Select");
        selectButton.setEnabled(false);
        selectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlPanelLayout.createSequentialGroup()
                .addContainerGap(325, Short.MAX_VALUE)
                .addComponent(selectButton)
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
                    .addComponent(selectButton))
                .addContainerGap())
        );

        getContentPane().add(controlPanel, java.awt.BorderLayout.PAGE_END);

        setSize(new java.awt.Dimension(518, 431));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dialogOption = JOptionPane.CANCEL_OPTION;
        WindowUtils.closeWindow(this);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void selectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectButtonActionPerformed
        specification = selectSpecPanel.getItem();
        if (specification != null) {
            dialogOption = JOptionPane.OK_OPTION;
            WindowUtils.closeWindow(this);
        }
    }//GEN-LAST:event_selectButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        WindowUtils.invokeWindow(new CatalogSelectSpecDialog(new javax.swing.JFrame(), true, null, CatalogSpecItemType.NODE));
    }

    public XBCItem getSpec() {
        return specification;
    }

    public void setSpec(XBCItem spec) {
        this.specification = spec;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel revisionSelectionPanel;
    private javax.swing.JButton selectButton;
    private javax.swing.JComboBox targetRevisionComboBox;
    // End of variables declaration//GEN-END:variables

    public XBCRev getTarget() {
        return (XBCRev) targetRevisionComboBox.getSelectedItem();
    }

    public void setTarget(XBCRev rev) {
        if (rev != null) {
            specification = rev.getParent();
            revsModel.setRevs(revService.getRevs((XBCSpec) specification));
            targetRevisionComboBox.setSelectedIndex(rev.getXBIndex().intValue());
        } else {
            specification = null;
        }
    }
}
