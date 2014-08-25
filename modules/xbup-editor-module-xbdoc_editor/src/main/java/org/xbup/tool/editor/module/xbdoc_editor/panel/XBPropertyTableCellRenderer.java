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
package org.xbup.tool.editor.module.xbdoc_editor.panel;

import java.awt.Component;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import org.xbup.lib.core.catalog.XBACatalog;
import org.xbup.lib.parser_tree.XBTTreeDocument;
import org.xbup.lib.parser_tree.XBTTreeNode;
import org.xbup.tool.editor.module.xbdoc_editor.dialog.XBPropertyDialog;

/**
 * Properties panel custom renderer.
 *
 * @version 0.1.23 2013/09/23
 * @author XBUP Project (http://xbup.org)
 */
public class XBPropertyTableCellRenderer extends javax.swing.JPanel implements TableCellRenderer, TableCellEditor {

    private List<CellEditorListener> cellEditorListeners;
    private int paramIndex;
    private XBACatalog catalog;
    private XBTTreeNode node;

    /** Creates new form XBPropertyTableCellRenderer */
    public XBPropertyTableCellRenderer(XBACatalog catalog) {
        this.catalog = catalog;
        initComponents();
        cellEditorListeners = new ArrayList<CellEditorListener>();
        node = null;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setName("Form"); // NOI18N
        setLayout(new java.awt.BorderLayout());

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/xbup/tool/xbeditor/module/xbdoceditor/panel/resources/XBPropertyTableCellRenderer"); // NOI18N
        jButton1.setText(bundle.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, java.awt.BorderLayout.EAST);

        jTextField1.setEditable(false);
        jTextField1.setText(bundle.getString("jTextField1.text")); // NOI18N
        jTextField1.setName("jTextField1"); // NOI18N
        add(jTextField1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        XBPropertyDialog propertyDialog = new XBPropertyDialog(getFrame(), true);
        propertyDialog.setCatalog(catalog);
        propertyDialog.setLocationRelativeTo(propertyDialog.getParent());
        XBTTreeDocument document = propertyDialog.getDocumentPanel().getDoc();

        XBTTreeNode newNode = (XBTTreeNode) node.getParam(catalog, getParamIndex());
        document.setRootBlock(newNode);
        propertyDialog.getDocumentPanel().reportStructureChange(newNode);
        propertyDialog.getDocumentPanel().updateItem();
        propertyDialog.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return this;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return this;
    }

    @Override
    public Object getCellEditorValue() {
        return "";
    }

    @Override
    public boolean isCellEditable(EventObject anEvent) {
        return true;
    }

    @Override
    public boolean shouldSelectCell(EventObject anEvent) {
        return true;
    }

    @Override
    public boolean stopCellEditing() {
        return true;
    }

    @Override
    public void cancelCellEditing() {
    }


    @Override
    public void addCellEditorListener(CellEditorListener l) {
        cellEditorListeners.add(l);
    }

    @Override
    public void removeCellEditorListener(CellEditorListener l) {
        cellEditorListeners.remove(l);
    }

    /**
     * @return the catalog
     */
    public XBACatalog getCatalog() {
        return catalog;
    }

    /**
     * @param catalog the catalog to set
     */
    public void setCatalog(XBACatalog catalog) {
        this.catalog = catalog;
    }

    void setNode(XBTTreeNode node) {
        this.node = node;
    }

    /**
     * @return the paramIndex
     */
    public int getParamIndex() {
        return paramIndex;
    }

    /**
     * @param paramIndex the paramIndex to set
     */
    public void setParamIndex(int paramIndex) {
        this.paramIndex = paramIndex;
    }

    private Frame getFrame() {
        Component component = SwingUtilities.getWindowAncestor(this);
        while (!(component == null || component instanceof Frame)) {
            component = component.getParent();
        }
        return (Frame) component;
    }
}
