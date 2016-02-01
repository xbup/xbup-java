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
package org.xbup.lib.framework.editor.xbup.panel.cell;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 * Empty property column panel with operation button.
 *
 * @version 0.1.24 2014/12/13
 * @author XBUP Project (http://xbup.org)
 */
public class PropertyTableCellPanel extends javax.swing.JPanel {

    private int paramIndex;
    private JComponent cellComponent;

    public PropertyTableCellPanel() {
        this(new JLabel());
    }

    public PropertyTableCellPanel(JComponent cellComponent) {
        this.cellComponent = cellComponent;
        initComponents();
        add(cellComponent, BorderLayout.CENTER);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editorButton = new javax.swing.JButton();

        setName("Form"); // NOI18N
        setLayout(new java.awt.BorderLayout());

        editorButton.setText("..."); // NOI18N
        editorButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        editorButton.setName("editorButton"); // NOI18N
        add(editorButton, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editorButton;
    // End of variables declaration//GEN-END:variables

    public void setEditorAction(ActionListener actionListener) {
        editorButton.addActionListener(actionListener);
    }

    public int getParamIndex() {
        return paramIndex;
    }

    public void setParamIndex(int paramIndex) {
        this.paramIndex = paramIndex;
    }

    public JComponent getCellComponent() {
        return cellComponent;
    }
}
