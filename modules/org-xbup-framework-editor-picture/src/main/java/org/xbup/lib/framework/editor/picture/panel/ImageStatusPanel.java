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

import java.awt.Point;
import org.xbup.lib.framework.editor.picture.ImageControlApi;

/**
 * Image editor status panel.
 *
 * @version 0.2.0 2016/01/31
 * @author XBUP Project (http://xbup.org)
 */
public class ImageStatusPanel extends javax.swing.JPanel {

    private final ImageControlApi imageControl;

    public ImageStatusPanel(ImageControlApi imageControl) {
        this.imageControl = imageControl;
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

        cursorPositionTextField = new javax.swing.JTextField();

        setName("Form"); // NOI18N

        cursorPositionTextField.setEditable(false);
        cursorPositionTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cursorPositionTextField.setText("1:1"); // NOI18N
        cursorPositionTextField.setName("cursorPositionTextField"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cursorPositionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(731, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cursorPositionTextField)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cursorPositionTextField;
    // End of variables declaration//GEN-END:variables

    public void setCurrentPosition(Point position) {
        if (position != null) {
            String positionText = position.x + " : " + position.y;
            cursorPositionTextField.setText(positionText);
        }
    }
}
