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

import javax.swing.JOptionPane;
import org.xbup.tool.editor.base.api.utils.WindowUtils;

/**
 * Find text dialog.
 *
 * @version 0.1.22 2013/03/14
 * @author XBUP Project (http://xbup.org)
 */
public class FindDialog extends javax.swing.JDialog {

    private int dialogOption = JOptionPane.CLOSED_OPTION;

    public FindDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        init();
    }

    private void init() {
        WindowUtils.assignGlobalKeyListener(this, findButton, cancelButton);
    }

    public boolean getSearchFromStart() {
        return !searchFromCursorCheckBox.isSelected();
    }

    public void setSelected() {
        textToFindjTextField.requestFocusInWindow();
        textToFindjTextField.selectAll();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        findButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        findPanel = new javax.swing.JPanel();
        textToFindLabel = new javax.swing.JLabel();
        textToFindjTextField = new javax.swing.JTextField();
        searchFromCursorCheckBox = new javax.swing.JCheckBox();
        matchCaseCheckBox = new javax.swing.JCheckBox();
        replacePanel = new javax.swing.JPanel();
        performReplaceCheckBox = new javax.swing.JCheckBox();
        textToReplaceLabel = new javax.swing.JLabel();
        textToReplaceTextField = new javax.swing.JTextField();
        replaceAllMatchesCheckBox = new javax.swing.JCheckBox();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/xbup/tool/editor/module/text_editor/dialog/resources/FindDialog"); // NOI18N
        setTitle(bundle.getString("Form.title")); // NOI18N
        setLocationByPlatform(true);
        setModal(true);
        setName("Form"); // NOI18N

        findButton.setText(bundle.getString("findButton.text")); // NOI18N
        findButton.setName("findButton"); // NOI18N
        findButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findButtonActionPerformed(evt);
            }
        });

        cancelButton.setText(bundle.getString("cancelButton.text")); // NOI18N
        cancelButton.setName("cancelButton"); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        findPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("findPanel.border.title"))); // NOI18N
        findPanel.setName("findPanel"); // NOI18N

        textToFindLabel.setText(bundle.getString("textToFindLabel.text")); // NOI18N
        textToFindLabel.setName("textToFindLabel"); // NOI18N

        textToFindjTextField.setName("textToFindjTextField"); // NOI18N

        searchFromCursorCheckBox.setSelected(true);
        searchFromCursorCheckBox.setText(bundle.getString("jCheckBox1.text")); // NOI18N
        searchFromCursorCheckBox.setName("searchFromCursorCheckBox"); // NOI18N

        matchCaseCheckBox.setText(bundle.getString("jCheckBox2.text")); // NOI18N
        matchCaseCheckBox.setEnabled(false);
        matchCaseCheckBox.setName("matchCaseCheckBox"); // NOI18N

        javax.swing.GroupLayout findPanelLayout = new javax.swing.GroupLayout(findPanel);
        findPanel.setLayout(findPanelLayout);
        findPanelLayout.setHorizontalGroup(
            findPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(findPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(findPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(matchCaseCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                    .addComponent(searchFromCursorCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                    .addComponent(textToFindLabel)
                    .addComponent(textToFindjTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE))
                .addContainerGap())
        );
        findPanelLayout.setVerticalGroup(
            findPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(findPanelLayout.createSequentialGroup()
                .addComponent(textToFindLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textToFindjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchFromCursorCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(matchCaseCheckBox)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        replacePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("replacePanel.border.title"))); // NOI18N
        replacePanel.setName("replacePanel"); // NOI18N

        performReplaceCheckBox.setText(bundle.getString("jCheckBox3.text")); // NOI18N
        performReplaceCheckBox.setName("performReplaceCheckBox"); // NOI18N
        performReplaceCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                performReplaceCheckBoxActionPerformed(evt);
            }
        });

        textToReplaceLabel.setText(bundle.getString("textToReplaceLabel.text")); // NOI18N
        textToReplaceLabel.setName("textToReplaceLabel"); // NOI18N

        textToReplaceTextField.setEnabled(false);
        textToReplaceTextField.setName("textToReplaceTextField"); // NOI18N

        replaceAllMatchesCheckBox.setText(bundle.getString("jCheckBox4.text")); // NOI18N
        replaceAllMatchesCheckBox.setEnabled(false);
        replaceAllMatchesCheckBox.setName("replaceAllMatchesCheckBox"); // NOI18N

        javax.swing.GroupLayout replacePanelLayout = new javax.swing.GroupLayout(replacePanel);
        replacePanel.setLayout(replacePanelLayout);
        replacePanelLayout.setHorizontalGroup(
            replacePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(replacePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(replacePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(performReplaceCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                    .addComponent(textToReplaceLabel)
                    .addComponent(textToReplaceTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                    .addComponent(replaceAllMatchesCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE))
                .addContainerGap())
        );
        replacePanelLayout.setVerticalGroup(
            replacePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(replacePanelLayout.createSequentialGroup()
                .addComponent(performReplaceCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textToReplaceLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textToReplaceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(replaceAllMatchesCheckBox)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(findButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelButton))
                    .addComponent(findPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(replacePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(findPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(replacePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(findButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dialogOption = JOptionPane.CANCEL_OPTION;
        WindowUtils.closeWindow(this);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void findButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findButtonActionPerformed
        dialogOption = JOptionPane.OK_OPTION;
        WindowUtils.closeWindow(this);
    }//GEN-LAST:event_findButtonActionPerformed

    private void performReplaceCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_performReplaceCheckBoxActionPerformed
        textToReplaceTextField.setEnabled(performReplaceCheckBox.isSelected());
        textToReplaceLabel.setEnabled(performReplaceCheckBox.isSelected());
    }//GEN-LAST:event_performReplaceCheckBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        WindowUtils.invokeWindow(new FindDialog(new javax.swing.JFrame(), true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton findButton;
    private javax.swing.JPanel findPanel;
    private javax.swing.JCheckBox matchCaseCheckBox;
    private javax.swing.JCheckBox performReplaceCheckBox;
    private javax.swing.JCheckBox replaceAllMatchesCheckBox;
    private javax.swing.JPanel replacePanel;
    private javax.swing.JCheckBox searchFromCursorCheckBox;
    private javax.swing.JLabel textToFindLabel;
    private javax.swing.JTextField textToFindjTextField;
    private javax.swing.JLabel textToReplaceLabel;
    private javax.swing.JTextField textToReplaceTextField;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the dialogOption
     */
    public int getOption() {
        return dialogOption;
    }

    public String getFindText() {
        return textToFindjTextField.getText();
    }

    public boolean getShallReplace() {
        return performReplaceCheckBox.isSelected();
    }

    public void setShallReplace(boolean shallReplace) {
        performReplaceCheckBox.setSelected(shallReplace);
        performReplaceCheckBoxActionPerformed(null);
    }

    public String getReplaceText() {
        return textToReplaceTextField.getText();
    }
}
