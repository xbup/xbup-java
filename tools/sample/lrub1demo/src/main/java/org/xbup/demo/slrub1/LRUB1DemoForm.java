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
package org.xbup.demo.slrub1;

import javax.swing.JOptionPane;

/**
 * Demonstration Application Frame From LRUB1 Encoding.
 *
 * @version 0.1.24 2014/11/08
 * @author XBUP Project (http://xbup.org)
 */
public class LRUB1DemoForm extends javax.swing.JFrame {

    private final LRUB1 handler;

    public LRUB1DemoForm() {
        handler = new LRUB1();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        convertToLabel = new javax.swing.JLabel();
        sourceNumberTextField = new javax.swing.JTextField();
        convertToButton = new javax.swing.JButton();
        targetCodeTextField = new javax.swing.JTextField();
        convertFromLabel = new javax.swing.JLabel();
        sourceCodeTextField = new javax.swing.JTextField();
        convertFromButton = new javax.swing.JButton();
        targetNumberTextField = new javax.swing.JTextField();
        codesScrollPane = new javax.swing.JScrollPane();
        codesTextArea = new javax.swing.JTextArea();
        codesLabel = new javax.swing.JLabel();
        listButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UBNumberDemo");

        convertToLabel.setText("Convert number to LRUB(1)");

        convertToButton.setText("Convert >>");
        convertToButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convertToButtonActionPerformed(evt);
            }
        });

        convertFromLabel.setText("Convert LRUB(1) code to number");

        sourceCodeTextField.setToolTipText("");

        convertFromButton.setText("Convert >>");
        convertFromButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convertFromButtonActionPerformed(evt);
            }
        });

        codesTextArea.setColumns(20);
        codesTextArea.setRows(5);
        codesScrollPane.setViewportView(codesTextArea);

        codesLabel.setText("List Codes");

        listButton.setText("List");
        listButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listButtonActionPerformed(evt);
            }
        });

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(codesScrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                    .addComponent(convertToLabel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sourceNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(convertToButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(sourceCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(convertFromButton))
                            .addComponent(convertFromLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(targetNumberTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                            .addComponent(targetCodeTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)))
                    .addComponent(codesLabel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 309, Short.MAX_VALUE)
                        .addComponent(closeButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(convertToLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sourceNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(targetCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(convertToButton))
                .addGap(18, 18, 18)
                .addComponent(convertFromLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(targetNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sourceCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(convertFromButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(codesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(codesScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closeButton)
                    .addComponent(listButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    private void convertToButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convertToButtonActionPerformed
        targetCodeTextField.setText("");
        try {
            long value = Long.valueOf(sourceNumberTextField.getText());
            targetCodeTextField.setText(handler.codeFromNumber(value));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Input String is not valid " + ex.getMessage(), "Input String is not valid", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_convertToButtonActionPerformed

    private void listButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listButtonActionPerformed
        StringBuilder builder = new StringBuilder();
        long value = 0;
        while (value < 50000) {
            builder.append(handler.codeFromNumber(value));
            builder.append("        = ");
            builder.append(String.valueOf(value));
            builder.append(System.getProperty("line.separator"));
            value++;
        }
        codesTextArea.setText(builder.toString());
    }//GEN-LAST:event_listButtonActionPerformed

    private void convertFromButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convertFromButtonActionPerformed
        targetNumberTextField.setText("");
        try {
            long value = handler.numberFromCode(sourceCodeTextField.getText());
            targetNumberTextField.setText(String.valueOf(value));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Input String is not valid " + ex.getMessage(), "Input String is not valid", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_convertFromButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LRUB1DemoForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel codesLabel;
    private javax.swing.JScrollPane codesScrollPane;
    private javax.swing.JTextArea codesTextArea;
    private javax.swing.JButton convertFromButton;
    private javax.swing.JLabel convertFromLabel;
    private javax.swing.JButton convertToButton;
    private javax.swing.JLabel convertToLabel;
    private javax.swing.JButton listButton;
    private javax.swing.JTextField sourceCodeTextField;
    private javax.swing.JTextField sourceNumberTextField;
    private javax.swing.JTextField targetCodeTextField;
    private javax.swing.JTextField targetNumberTextField;
    // End of variables declaration//GEN-END:variables

}
