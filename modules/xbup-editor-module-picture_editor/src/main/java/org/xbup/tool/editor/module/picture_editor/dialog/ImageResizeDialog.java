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
package org.xbup.tool.editor.module.picture_editor.dialog;

import java.awt.Point;
import javax.swing.JOptionPane;
import org.xbup.tool.editor.base.api.utils.WindowUtils;

/**
 * XBPEditor Color Selection Dialog.
 *
 * @version 0.1.24 2014/11/08
 * @author XBUP Project (http://xbup.org)
 */
public class ImageResizeDialog extends javax.swing.JDialog {

    protected int dialogOption = JOptionPane.CLOSED_OPTION;

    public ImageResizeDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
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

        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        resizeImagePanel = new javax.swing.JPanel();
        imageSizePanel = new javax.swing.JPanel();
        widthLabel = new javax.swing.JLabel();
        widthTextField = new javax.swing.JTextField();
        heightLabel = new javax.swing.JLabel();
        heightTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setModal(true);
        setName("Form"); // NOI18N

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/xbup/tool/editor/module/picture_editor/dialog/resources/ImageResizeDialog"); // NOI18N
        cancelButton.setText(bundle.getString("jButton1.text")); // NOI18N
        cancelButton.setName("cancelButton"); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        okButton.setText(bundle.getString("jButton2.text")); // NOI18N
        okButton.setName("okButton"); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        resizeImagePanel.setName("resizeImagePanel"); // NOI18N
        resizeImagePanel.setLayout(new java.awt.GridLayout(1, 0));

        imageSizePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("jPanel2.border.title"))); // NOI18N
        imageSizePanel.setName("imageSizePanel"); // NOI18N

        widthLabel.setText(bundle.getString("jLabel1.text")); // NOI18N
        widthLabel.setName("widthLabel"); // NOI18N

        widthTextField.setName("widthTextField"); // NOI18N

        heightLabel.setText(bundle.getString("jLabel2.text")); // NOI18N
        heightLabel.setName("heightLabel"); // NOI18N

        heightTextField.setName("heightTextField"); // NOI18N

        javax.swing.GroupLayout imageSizePanelLayout = new javax.swing.GroupLayout(imageSizePanel);
        imageSizePanel.setLayout(imageSizePanelLayout);
        imageSizePanelLayout.setHorizontalGroup(
            imageSizePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imageSizePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(imageSizePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(heightTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                    .addComponent(widthTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                    .addComponent(widthLabel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(heightLabel, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        imageSizePanelLayout.setVerticalGroup(
            imageSizePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imageSizePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(widthLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(widthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(heightLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(heightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        resizeImagePanel.add(imageSizePanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(okButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelButton)
                .addContainerGap())
            .addComponent(resizeImagePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(resizeImagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
        WindowUtils.invokeWindow(new ImageResizeDialog(new javax.swing.JFrame(), true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel heightLabel;
    private javax.swing.JTextField heightTextField;
    private javax.swing.JPanel imageSizePanel;
    private javax.swing.JButton okButton;
    private javax.swing.JPanel resizeImagePanel;
    private javax.swing.JLabel widthLabel;
    private javax.swing.JTextField widthTextField;
    // End of variables declaration//GEN-END:variables

    public void setResolution(Point point) {
        widthTextField.setText(Integer.toString((int) point.getX()));
        heightTextField.setText(Integer.toString((int) point.getY()));
    }

    public Point getResolution() {
        return new Point(new Integer(widthTextField.getText()), new Integer(heightTextField.getText()));
    }
}
