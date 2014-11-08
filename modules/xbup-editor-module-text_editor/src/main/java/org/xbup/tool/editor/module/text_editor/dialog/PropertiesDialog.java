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
package org.xbup.tool.editor.module.text_editor.dialog;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.Document;
import org.xbup.tool.editor.base.api.utils.WindowUtils;
import org.xbup.tool.editor.module.text_editor.panel.TextPanel;

/**
 * File Properties Dialog.
 *
 * @version 0.1.24 2014/11/08
 * @author XBUP Project (http://xbup.org)
 */
public class PropertiesDialog extends javax.swing.JDialog {

    public PropertiesDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    private void init() {
        WindowUtils.assignGlobalKeyListener(this, closeButton);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        closeButton = new javax.swing.JButton();
        fileNameLabel = new javax.swing.JLabel();
        fileNameTextField = new javax.swing.JTextField();
        documentSizePanel = new javax.swing.JPanel();
        linesCountLabel = new javax.swing.JLabel();
        linesCountTextField = new javax.swing.JTextField();
        charCountLabel = new javax.swing.JLabel();
        charCountTextField = new javax.swing.JTextField();
        fileSizeLabel = new javax.swing.JLabel();
        fileSizeTextField = new javax.swing.JTextField();
        wordsCountLabel = new javax.swing.JLabel();
        wordsCountTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/xbup/tool/editor/module/text_editor/dialog/resources/PropertiesDialog"); // NOI18N
        setTitle(bundle.getString("PropertiesDialog.title")); // NOI18N
        setLocationByPlatform(true);
        setModal(true);
        setName("Form"); // NOI18N

        closeButton.setText(bundle.getString("closeButton.text")); // NOI18N
        closeButton.setName("closeButton"); // NOI18N
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        fileNameLabel.setText(bundle.getString("jLabel1.text")); // NOI18N
        fileNameLabel.setName("fileNameLabel"); // NOI18N

        fileNameTextField.setEditable(false);
        fileNameTextField.setName("fileNameTextField"); // NOI18N

        documentSizePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("jPanel1.border.title"))); // NOI18N
        documentSizePanel.setName("documentSizePanel"); // NOI18N

        linesCountLabel.setText(bundle.getString("jLabel4.text")); // NOI18N
        linesCountLabel.setName("linesCountLabel"); // NOI18N

        linesCountTextField.setEditable(false);
        linesCountTextField.setName("linesCountTextField"); // NOI18N

        charCountLabel.setText(bundle.getString("jLabel5.text")); // NOI18N
        charCountLabel.setName("charCountLabel"); // NOI18N

        charCountTextField.setEditable(false);
        charCountTextField.setName("charCountTextField"); // NOI18N

        fileSizeLabel.setText(bundle.getString("jLabel2.text")); // NOI18N
        fileSizeLabel.setName("fileSizeLabel"); // NOI18N

        fileSizeTextField.setEditable(false);
        fileSizeTextField.setName("fileSizeTextField"); // NOI18N

        wordsCountLabel.setText(bundle.getString("jLabel3.text")); // NOI18N
        wordsCountLabel.setName("wordsCountLabel"); // NOI18N

        wordsCountTextField.setEditable(false);
        wordsCountTextField.setName("wordsCountTextField"); // NOI18N

        javax.swing.GroupLayout documentSizePanelLayout = new javax.swing.GroupLayout(documentSizePanel);
        documentSizePanel.setLayout(documentSizePanelLayout);
        documentSizePanelLayout.setHorizontalGroup(
            documentSizePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(documentSizePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(documentSizePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(linesCountLabel)
                    .addComponent(charCountLabel)
                    .addComponent(fileSizeLabel)
                    .addComponent(wordsCountLabel)
                    .addComponent(charCountTextField)
                    .addComponent(fileSizeTextField)
                    .addComponent(wordsCountTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(linesCountTextField))
                .addContainerGap())
        );
        documentSizePanelLayout.setVerticalGroup(
            documentSizePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(documentSizePanelLayout.createSequentialGroup()
                .addComponent(linesCountLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(linesCountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(charCountLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(charCountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fileSizeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fileSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wordsCountLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wordsCountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(documentSizePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(closeButton)
                    .addComponent(fileNameLabel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fileNameTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fileNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fileNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(documentSizePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(closeButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        WindowUtils.closeWindow(this);
    }//GEN-LAST:event_closeButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        WindowUtils.invokeWindow(new PropertiesDialog(new javax.swing.JFrame(), true));
    }

    public void setDocument(TextPanel panel) {
        fileNameTextField.setText(panel.getFileName());
        Document document = panel.getDocument();
        linesCountTextField.setText(Integer.toString(panel.getLineCount()));
        charCountTextField.setText(Integer.toString(document.getLength()));
        CharBuffer buffer = CharBuffer.wrap(new StringBuffer(panel.getText()));

        CharsetEncoder encoder = Charset.defaultCharset().newEncoder();
        try {
            ByteBuffer result = encoder.encode(buffer);
            int length = 0;
            while (result.hasRemaining()) {
                result.get();
                length++;
            }
            fileSizeTextField.setText(Integer.toString(length));
        } catch (CharacterCodingException ex) {
            Logger.getLogger(PropertiesDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel charCountLabel;
    private javax.swing.JTextField charCountTextField;
    private javax.swing.JButton closeButton;
    private javax.swing.JPanel documentSizePanel;
    private javax.swing.JLabel fileNameLabel;
    private javax.swing.JTextField fileNameTextField;
    private javax.swing.JLabel fileSizeLabel;
    private javax.swing.JTextField fileSizeTextField;
    private javax.swing.JLabel linesCountLabel;
    private javax.swing.JTextField linesCountTextField;
    private javax.swing.JLabel wordsCountLabel;
    private javax.swing.JTextField wordsCountTextField;
    // End of variables declaration//GEN-END:variables

}
