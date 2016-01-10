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

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import javax.swing.AbstractListModel;
import javax.swing.JOptionPane;
import org.xbup.lib.framework.gui.utils.WindowUtils;

/**
 * Encoding Selection Panel.
 *
 * @version 0.1.25 2015/04/11
 * @author XBUP Project (http://xbup.org)
 */
public class AddEncodingDialog extends javax.swing.JDialog {

    protected int dialogOption = JOptionPane.CLOSED_OPTION;

    public AddEncodingDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    private void init() {
        WindowUtils.initWindow(this);
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

        supportedEncodingsLabel = new javax.swing.JLabel();
        encodingsScrollPane = new javax.swing.JScrollPane();
        encodingsList = new javax.swing.JList();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Supported Encoding"); // NOI18N
        setName("Form"); // NOI18N

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/xbup/tool/editor/module/text_editor/dialog/resources/AddEncodingDialog"); // NOI18N
        supportedEncodingsLabel.setText(bundle.getString("supportedEncodingsLabel.text")); // NOI18N
        supportedEncodingsLabel.setName("supportedEncodingsLabel"); // NOI18N

        encodingsScrollPane.setName("encodingsScrollPane"); // NOI18N

        encodingsList.setModel(new AvailableEncodingsListModel());
        encodingsList.setName("encodingsList"); // NOI18N
        encodingsScrollPane.setViewportView(encodingsList);

        cancelButton.setText(bundle.getString("cancelButton.text")); // NOI18N
        cancelButton.setName("cancelButton"); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        okButton.setText(bundle.getString("okButton.text")); // NOI18N
        okButton.setName("okButton"); // NOI18N
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
                    .addComponent(encodingsScrollPane)
                    .addComponent(supportedEncodingsLabel)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(okButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(supportedEncodingsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(encodingsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
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
        WindowUtils.invokeWindow(new AddEncodingDialog(new javax.swing.JFrame(), true));
    }

    public void setEncodings(List<String> encodings) {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (Entry<String, Charset> entry : Charset.availableCharsets().entrySet()) {
            if (!"UTF-8".equals(entry.getKey())) {
                set.add(entry.getValue().name()); //displayName(Locale.getDefault()));
            }
        }
        set.remove("UTF-8");
        for (Iterator<String> it = encodings.iterator(); it.hasNext();) {
            set.remove(it.next());
        }
        ArrayList<String> list = new ArrayList<>(set);
        ((AvailableEncodingsListModel) encodingsList.getModel()).setCharsets(list);
    }

    public List<String> getEncodings() {
        ArrayList<String> result = new ArrayList<>();
        List selectedValues = encodingsList.getSelectedValuesList();
        for (Object value : selectedValues) {
            if (value instanceof String) {
                result.add((String) value);
            }
        }
        return result;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JList encodingsList;
    private javax.swing.JScrollPane encodingsScrollPane;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel supportedEncodingsLabel;
    // End of variables declaration//GEN-END:variables

    private class AvailableEncodingsListModel extends AbstractListModel {

        private List<String> charsets = null;

        @Override
        public int getSize() {
            if (charsets == null) {
                return 0;
            }
            return charsets.size();
        }

        @Override
        public Object getElementAt(int index) {
            return charsets.get(index);
        }

        public List<String> getCharsets() {
            return charsets;
        }

        public void setCharsets(List<String> charsets) {
            this.charsets = charsets;
            fireContentsChanged(this, 0, charsets.size());
        }
    }
}
