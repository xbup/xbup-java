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
package org.xbup.lib.framework.editor.picture.panel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JColorChooser;
import javax.swing.JDialog;

/**
 * XBPEditor Color Selection panel.
 *
 * @version 0.2.0 2016/02/06
 * @author ExBin Project (http://exbin.org)
 */
public class ToolColorPanel extends javax.swing.JPanel {

    public ToolColorPanel() {
        initComponents();
    }

    public Color getToolColor() {
        return toolColorPanel.getBackground();
    }

    public Color getSelectionColor() {
        return selectionColorPanel.getBackground();
    }

    public void setToolColor(Color color) {
        toolColorPanel.setBackground(color);
    }

    public void setSelectionColor(Color color) {
        selectionColorPanel.setBackground(color);
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
        toolColorPanel = new javax.swing.JPanel();
        penColorSelectButton = new javax.swing.JButton();
        fillcolorLabel = new javax.swing.JLabel();
        selectionColorPanel = new javax.swing.JPanel();
        fillColorSelectButton = new javax.swing.JButton();

        jColorChooser1.setName("jColorChooser1"); // NOI18N

        setName("Form"); // NOI18N

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/xbup/lib/framework/editor/picture/panel/resources/ToolColorPanel"); // NOI18N
        penColorLabel.setText(bundle.getString("ToolColorPanel.penColorLabel.text")); // NOI18N
        penColorLabel.setName("penColorLabel"); // NOI18N

        toolColorPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        toolColorPanel.setName("toolColorPanel"); // NOI18N

        javax.swing.GroupLayout toolColorPanelLayout = new javax.swing.GroupLayout(toolColorPanel);
        toolColorPanel.setLayout(toolColorPanelLayout);
        toolColorPanelLayout.setHorizontalGroup(
            toolColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        toolColorPanelLayout.setVerticalGroup(
            toolColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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

        selectionColorPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        selectionColorPanel.setName("selectionColorPanel"); // NOI18N

        javax.swing.GroupLayout selectionColorPanelLayout = new javax.swing.GroupLayout(selectionColorPanel);
        selectionColorPanel.setLayout(selectionColorPanelLayout);
        selectionColorPanelLayout.setHorizontalGroup(
            selectionColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        selectionColorPanelLayout.setVerticalGroup(
            selectionColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addComponent(toolColorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectionColorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(penColorSelectButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fillColorSelectButton, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
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
                        .addComponent(toolColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(penColorSelectButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fillcolorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectionColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fillColorSelectButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void penColorSelectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_penColorSelectButtonActionPerformed
        jColorChooser1.setColor(toolColorPanel.getBackground());
        JDialog dialog = JColorChooser.createDialog(this, "Select color", true, jColorChooser1, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setToolColor(jColorChooser1.getColor());
            }
        }, null);
        dialog.setVisible(true);
    }//GEN-LAST:event_penColorSelectButtonActionPerformed

    private void fillColorSelectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillColorSelectButtonActionPerformed
        jColorChooser1.setColor(selectionColorPanel.getBackground());
        JDialog dialog = JColorChooser.createDialog(this, "Select color", true, jColorChooser1, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setSelectionColor(jColorChooser1.getColor());
            }
        }, null);
        dialog.setVisible(true);
    }//GEN-LAST:event_fillColorSelectButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton fillColorSelectButton;
    private javax.swing.JLabel fillcolorLabel;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel penColorLabel;
    private javax.swing.JButton penColorSelectButton;
    private javax.swing.JPanel selectionColorPanel;
    private javax.swing.JPanel toolColorPanel;
    // End of variables declaration//GEN-END:variables

}
