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
package org.exbin.framework.editor.text.panel;

import org.exbin.framework.editor.text.TextStatusApi;

/**
 * Text editor status panel.
 *
 * @version 0.2.0 2016/01/12
 * @author ExBin Project (http://exbin.org)
 */
public class TextStatusPanel extends javax.swing.JPanel implements TextStatusApi {

    public TextStatusPanel() {
        initComponents();
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        documentCursorPositionTextField = new javax.swing.JTextField();
        encodingLabel = new javax.swing.JLabel();
        documentEncodingTextField = new javax.swing.JTextField();

        setName("Form"); // NOI18N

        documentCursorPositionTextField.setEditable(false);
        documentCursorPositionTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        documentCursorPositionTextField.setText("1:1"); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/exbin/framework/editor/text/panel/resources/TextStatusPanel"); // NOI18N
        documentCursorPositionTextField.setToolTipText(bundle.getString("TextStatusPanel.documentCursorPositionTextField.toolTipText")); // NOI18N
        documentCursorPositionTextField.setName("documentCursorPositionTextField"); // NOI18N

        encodingLabel.setText(bundle.getString("TextStatusPanel.encodingLabel.text")); // NOI18N
        encodingLabel.setName("encodingLabel"); // NOI18N

        documentEncodingTextField.setEditable(false);
        documentEncodingTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        documentEncodingTextField.setText("UTF-8"); // NOI18N
        documentEncodingTextField.setToolTipText(bundle.getString("TextStatusPanel.documentEncodingTextField.toolTipText")); // NOI18N
        documentEncodingTextField.setName("documentEncodingTextField"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(documentCursorPositionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 397, Short.MAX_VALUE)
                .addComponent(encodingLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(documentEncodingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(documentCursorPositionTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addComponent(documentEncodingTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(encodingLabel))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField documentCursorPositionTextField;
    private javax.swing.JTextField documentEncodingTextField;
    private javax.swing.JLabel encodingLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setTextPosition(String textPosition) {
         documentCursorPositionTextField.setText(textPosition);
    }

    @Override
    public void setEncoding(String encodingName) {
        documentEncodingTextField.setText(encodingName);
    }
}
