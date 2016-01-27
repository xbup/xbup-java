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
package org.xbup.lib.framework.editor.picture.panel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JColorChooser;
import javax.swing.JDialog;

/**
 * XBPEditor Color Selection panel.
 *
 * @version 0.2.0 2016/01/27
 * @author XBUP Project (http://xbup.org)
 */
public class ToolColorPanel extends javax.swing.JPanel {

    public ToolColorPanel() {
        initComponents();
    }

    public Color getTextColor() {
        return penColorPanel.getBackground();
    }

    public Color getTextBackgroundColor() {
        return fillColorPanel.getBackground();
    }

    public void setTextColor(Color color) {
        penColorPanel.setBackground(color);
    }

    public void setTextBackgroundColor(Color color) {
        fillColorPanel.setBackground(color);
    }

    @Override
    public void setEnabled(boolean b) {
        super.setEnabled(b);
        fillColorSelectButton.setEnabled(b);
        penColorSelectButton.setEnabled(b);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        penColorLabel = new javax.swing.JLabel();
        penColorPanel = new javax.swing.JPanel();
        penColorSelectButton = new javax.swing.JButton();
        fillcolorLabel = new javax.swing.JLabel();
        fillColorPanel = new javax.swing.JPanel();
        fillColorSelectButton = new javax.swing.JButton();

        jColorChooser1.setName("jColorChooser1"); // NOI18N

        setName("Form"); // NOI18N

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/xbup/lib/framework/editor/picture/panel/resources/ToolColorPanel"); // NOI18N
        penColorLabel.setText(bundle.getString("ToolColorPanel.penColorLabel.text")); // NOI18N
        penColorLabel.setName("penColorLabel"); // NOI18N

        penColorPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        penColorPanel.setName("penColorPanel"); // NOI18N

        javax.swing.GroupLayout penColorPanelLayout = new javax.swing.GroupLayout(penColorPanel);
        penColorPanel.setLayout(penColorPanelLayout);
        penColorPanelLayout.setHorizontalGroup(
            penColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        penColorPanelLayout.setVerticalGroup(
            penColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

        penColorSelectButton.setText(bundle.getString("ToolColorPanel.penColorSelectButton")); // NOI18N
        penColorSelectButton.setName("penColorSelectButton"); // NOI18N
        penColorSelectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                penColorSelectButtonActionPerformed(evt);
            }
        });

        fillcolorLabel.setText(bundle.getString("ToolColorPanel.fillColorLabel")); // NOI18N
        fillcolorLabel.setName("fillcolorLabel"); // NOI18N

        fillColorPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        fillColorPanel.setName("fillColorPanel"); // NOI18N

        javax.swing.GroupLayout fillColorPanelLayout = new javax.swing.GroupLayout(fillColorPanel);
        fillColorPanel.setLayout(fillColorPanelLayout);
        fillColorPanelLayout.setHorizontalGroup(
            fillColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        fillColorPanelLayout.setVerticalGroup(
            fillColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

        fillColorSelectButton.setText(bundle.getString("ToolColorPanel.fillColorSelectButton")); // NOI18N
        fillColorSelectButton.setName("fillColorSelectButton"); // NOI18N
        fillColorSelectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillColorSelectButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(penColorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fillColorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(penColorSelectButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fillColorSelectButton, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(penColorLabel)
                            .addComponent(fillcolorLabel))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(penColorLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(penColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(penColorSelectButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fillcolorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fillColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fillColorSelectButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void penColorSelectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_penColorSelectButtonActionPerformed
        jColorChooser1.setColor(penColorPanel.getBackground());
        JDialog dialog = JColorChooser.createDialog(this, "Select color", true, jColorChooser1, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setTextColor(jColorChooser1.getColor());
            }
        }, null);
        dialog.setVisible(true);
    }//GEN-LAST:event_penColorSelectButtonActionPerformed

    private void fillColorSelectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillColorSelectButtonActionPerformed
        jColorChooser1.setColor(fillColorPanel.getBackground());
        JDialog dialog = JColorChooser.createDialog(this, "Select color", true, jColorChooser1, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setTextBackgroundColor(jColorChooser1.getColor());
            }
        }, null);
        dialog.setVisible(true);
    }//GEN-LAST:event_fillColorSelectButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel fillColorPanel;
    private javax.swing.JButton fillColorSelectButton;
    private javax.swing.JLabel fillcolorLabel;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel penColorLabel;
    private javax.swing.JPanel penColorPanel;
    private javax.swing.JButton penColorSelectButton;
    // End of variables declaration//GEN-END:variables

}
