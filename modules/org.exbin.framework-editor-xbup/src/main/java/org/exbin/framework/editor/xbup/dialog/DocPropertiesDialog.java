/*
 * Copyright (C) ExBin Project
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
package org.exbin.framework.editor.xbup.dialog;

import org.xbup.lib.core.block.XBTEditableDocument;
import org.exbin.framework.gui.utils.ActionUtils;
import org.exbin.framework.gui.utils.WindowUtils;
import org.xbup.lib.parser_tree.XBTTreeDocument;

/**
 * Dialog for document properties showing various information about file.
 *
 * @version 0.2.0 2016/03/09
 * @author ExBin Project (http://exbin.org)
 */
public class DocPropertiesDialog extends javax.swing.JDialog {

    private XBTEditableDocument doc;
    private final java.util.ResourceBundle bundle = ActionUtils.getResourceBundleByClass(DocPropertiesDialog.class);

    public DocPropertiesDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        init();
    }

    private void init() {
        WindowUtils.initWindow(this);
        propertiesTabbedPane.setEnabledAt(1, false);
        WindowUtils.addHeaderPanel(this, bundle.getString("header.title"), bundle.getString("header.description"), bundle.getString("header.icon"));
        WindowUtils.assignGlobalKeyListener(this, closeButton);
        pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        propertiesTabbedPane = new javax.swing.JTabbedPane();
        generalPanel = new javax.swing.JPanel();
        fileNameLabel = new javax.swing.JLabel();
        fileNameTextField = new javax.swing.JTextField();
        fileSizeTextField = new javax.swing.JTextField();
        fileTypeLabel = new javax.swing.JLabel();
        fileTypeTextField = new javax.swing.JTextField();
        fileSizeLabel = new javax.swing.JLabel();
        documentTypePanel = new javax.swing.JPanel();
        controlPanel = new javax.swing.JPanel();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/exbin/framework/editor/xbup/dialog/resources/DocPropertiesDialog"); // NOI18N
        setTitle(bundle.getString("title")); // NOI18N
        setLocationByPlatform(true);

        fileNameLabel.setText(bundle.getString("fileNameLabel.text")); // NOI18N

        fileNameTextField.setEditable(false);

        fileSizeTextField.setEditable(false);

        fileTypeLabel.setText(bundle.getString("fileTypeLabel.text")); // NOI18N

        fileTypeTextField.setEditable(false);

        fileSizeLabel.setText(bundle.getString("fileSizeLabel.text")); // NOI18N

        javax.swing.GroupLayout generalPanelLayout = new javax.swing.GroupLayout(generalPanel);
        generalPanel.setLayout(generalPanelLayout);
        generalPanelLayout.setHorizontalGroup(
            generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fileNameLabel)
                    .addComponent(fileTypeLabel)
                    .addComponent(fileSizeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fileNameTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(fileTypeTextField)
                    .addComponent(fileSizeTextField, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        generalPanelLayout.setVerticalGroup(
            generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileNameLabel)
                    .addComponent(fileNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fileSizeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileTypeLabel)
                    .addComponent(fileTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        propertiesTabbedPane.addTab(bundle.getString("generalPanel.tabTitle"), generalPanel); // NOI18N

        javax.swing.GroupLayout documentTypePanelLayout = new javax.swing.GroupLayout(documentTypePanel);
        documentTypePanel.setLayout(documentTypePanelLayout);
        documentTypePanelLayout.setHorizontalGroup(
            documentTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 292, Short.MAX_VALUE)
        );
        documentTypePanelLayout.setVerticalGroup(
            documentTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        propertiesTabbedPane.addTab(bundle.getString("documentTypePanel.tabTitle"), documentTypePanel); // NOI18N

        getContentPane().add(propertiesTabbedPane, java.awt.BorderLayout.CENTER);

        closeButton.setText(bundle.getString("okButton.text")); // NOI18N
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlPanelLayout.createSequentialGroup()
                .addContainerGap(220, Short.MAX_VALUE)
                .addComponent(closeButton)
                .addContainerGap())
        );
        controlPanelLayout.setVerticalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(closeButton)
                .addContainerGap())
        );

        getContentPane().add(controlPanel, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        WindowUtils.closeWindow(this);
    }//GEN-LAST:event_closeButtonActionPerformed

    public void runDialog(XBTEditableDocument doc, String fileName) {
        this.doc = doc;
        fileNameTextField.setText(fileName);
        if (doc instanceof XBTTreeDocument) {
            fileSizeTextField.setText(Long.toString(((XBTTreeDocument) doc).getDocumentSize()));
        } else {
            fileSizeTextField.setText("Unknown");
        }

        setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        WindowUtils.invokeWindow(new BlockPropertiesDialog(new javax.swing.JFrame(), true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JPanel documentTypePanel;
    private javax.swing.JLabel fileNameLabel;
    private javax.swing.JTextField fileNameTextField;
    private javax.swing.JLabel fileSizeLabel;
    private javax.swing.JTextField fileSizeTextField;
    private javax.swing.JLabel fileTypeLabel;
    private javax.swing.JTextField fileTypeTextField;
    private javax.swing.JPanel generalPanel;
    private javax.swing.JTabbedPane propertiesTabbedPane;
    // End of variables declaration//GEN-END:variables

}
