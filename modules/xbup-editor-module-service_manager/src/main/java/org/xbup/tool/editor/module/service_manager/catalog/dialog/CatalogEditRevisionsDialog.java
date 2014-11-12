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

import javax.swing.JOptionPane;
import org.xbup.lib.core.catalog.XBACatalog;
import org.xbup.lib.core.catalog.base.XBCItem;
import org.xbup.tool.editor.base.api.XBEditorFrame;
import org.xbup.tool.editor.base.api.utils.WindowUtils;
import org.xbup.tool.editor.module.service_manager.catalog.panel.CatalogRevsTableModel;

/**
 * XBManager Catalog Revisions Editor Dialog.
 *
 * @version 0.1.24 2014/11/12
 * @author XBUP Project (http://xbup.org)
 */
public class CatalogEditRevisionsDialog extends javax.swing.JDialog {

    private int dialogOption = JOptionPane.CLOSED_OPTION;

    private XBACatalog catalog;
    private final CatalogRevsTableModel revsTableModel;

    public CatalogEditRevisionsDialog(java.awt.Frame frame, boolean modal, XBACatalog catalog) {
        super(frame, modal);
        this.catalog = catalog;
        revsTableModel = new CatalogRevsTableModel(catalog);
        initComponents();
        if (frame instanceof XBEditorFrame) {
            setIconImage(((XBEditorFrame) frame).getMainFrameManagement().getFrameIcon());
        }

        init();
    }

    private void init() {
        WindowUtils.assignGlobalKeyListener(this, setButton, cancelButton);
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
        setButton = new javax.swing.JButton();
        revisionsScrollPane = new javax.swing.JScrollPane();
        revisionsTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/xbup/tool/editor/module/service_manager/catalog/dialog/resources/CatalogItemEditDialog"); // NOI18N
        setTitle(bundle.getString("Form.title")); // NOI18N
        setLocationByPlatform(true);
        setModal(true);
        setName("Form"); // NOI18N

        controlPanel.setName("controlPanel"); // NOI18N

        cancelButton.setText(bundle.getString("cancelButton.text")); // NOI18N
        cancelButton.setName("cancelButton"); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        setButton.setText(bundle.getString("setButton.text")); // NOI18N
        setButton.setName("setButton"); // NOI18N
        setButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlPanelLayout.createSequentialGroup()
                .addContainerGap(133, Short.MAX_VALUE)
                .addComponent(setButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelButton)
                .addContainerGap())
        );
        controlPanelLayout.setVerticalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(setButton))
                .addContainerGap())
        );

        getContentPane().add(controlPanel, java.awt.BorderLayout.PAGE_END);

        revisionsScrollPane.setName("revisionsScrollPane"); // NOI18N

        revisionsTable.setModel(revsTableModel);
        revisionsTable.setName("revisionsTable"); // NOI18N
        revisionsScrollPane.setViewportView(revisionsTable);

        getContentPane().add(revisionsScrollPane, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(306, 219));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void setButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setButtonActionPerformed
        dialogOption = JOptionPane.OK_OPTION;
        WindowUtils.closeWindow(this);
}//GEN-LAST:event_setButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dialogOption = JOptionPane.CANCEL_OPTION;
        WindowUtils.closeWindow(this);
}//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        WindowUtils.invokeWindow(new CatalogEditRevisionsDialog(new javax.swing.JFrame(), true, null));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JScrollPane revisionsScrollPane;
    private javax.swing.JTable revisionsTable;
    private javax.swing.JButton setButton;
    // End of variables declaration//GEN-END:variables

    public void setCatalogItem(XBCItem item) {
    }

    public XBCItem getCatalogItem() {
        return null;
    }

    public void setCatalog(XBACatalog catalog) {
        this.catalog = catalog;
        revsTableModel.setCatalog(catalog);
    }
}
