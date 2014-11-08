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
package org.xbup.tool.editor.module.service_manager.dialog;

import javax.swing.JOptionPane;
import org.xbup.tool.editor.base.api.XBEditorFrame;
import org.xbup.tool.editor.base.api.utils.WindowUtils;

/**
 * Add Connection Dialog
 *
 * @version 0.1.24 2014/11/08
 * @author XBUP Project (http://xbup.org)
 */
public class AddConnectionDialog extends javax.swing.JDialog {

    protected int dialogOption = JOptionPane.CLOSED_OPTION;

    public AddConnectionDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        if (parent instanceof XBEditorFrame) {
            setIconImage(((XBEditorFrame) parent).getMainFrameManagement().getFrameIcon());
        }
    }

    public int getOption() {
        return dialogOption;
    }

    public String getConnection() {
        return connectionHostTextField.getText() + ":" + String.valueOf((Integer) connectionPortSpinner.getValue());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cancelButton = new javax.swing.JButton();
        connectionHostLabel = new javax.swing.JLabel();
        connectionPortSpinner = new javax.swing.JSpinner();
        connectionPortLabel = new javax.swing.JLabel();
        connectionHostTextField = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/xbup/tool/editor/module/service_manager/dialog/resources/AddConnectionDialog"); // NOI18N
        setTitle(bundle.getString("Form.title")); // NOI18N

        cancelButton.setText(bundle.getString("cancelButton.text")); // NOI18N
        cancelButton.setToolTipText(bundle.getString("cancelButton.toolTipText")); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        connectionHostLabel.setText(bundle.getString("connectionHostLabel.text")); // NOI18N

        connectionPortLabel.setText(bundle.getString("connectionPortLabel.text")); // NOI18N

        okButton.setText(bundle.getString("okButton.text")); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(okButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelButton))
                    .addComponent(connectionHostLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                    .addComponent(connectionHostTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                    .addComponent(connectionPortLabel)
                    .addComponent(connectionPortSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(connectionHostLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(connectionHostTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(connectionPortLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(connectionPortSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton))
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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        WindowUtils.invokeWindow(new AddConnectionDialog(new javax.swing.JFrame(), true));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel connectionHostLabel;
    private javax.swing.JTextField connectionHostTextField;
    private javax.swing.JLabel connectionPortLabel;
    private javax.swing.JSpinner connectionPortSpinner;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
}
