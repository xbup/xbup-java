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

import hexedit.HexEditPanel;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xbup.lib.parser_tree.XBTTreeDocument;
import org.xbup.lib.parser_tree.XBTTreeNode;

/**
 * Panel with document tree visualization.
 *
 * @version 0.1.21 2011/07/28
 * @author XBUP Project (http://xbup.org)
 */
public class XBDocHexPanel extends javax.swing.JPanel {

    private final XBTTreeDocument mainDoc;
    private final List<ActionListener> updateEventList;
    private boolean editEnabled;
    private boolean addEnabled;

    private final HexEditPanel hexPanel;

    public XBDocHexPanel(XBTTreeDocument doc) {
        mainDoc = doc;
        updateEventList = new ArrayList<>();

        initComponents();

//        updateItem();

        hexPanel = new HexEditPanel(null);
        add(hexPanel);
    }

    /** Updating selected item available operations status, like add, edit, delete */
    public void updateItem() {
        // TODO
/*        setEditEnabled(!mainTree.isSelectionEmpty());
        updateUndoAvailable();
        if (!editEnabled) {
            setAddEnabled(mainDoc.getTree().getRootNode() == null);
        } else setAddEnabled(!((XBEditTreeNode) mainTree.getLastSelectedPathComponent()).isDataNode());
        for (Iterator it = updateEventList.iterator(); it.hasNext();) {
            ((ActionListener) it.next()).actionPerformed(null);
        } */
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents

    public XBTTreeNode getSelectedItem() {
        return null; // TODO (XBEditTreeNode) mainTree.getLastSelectedPathComponent();
    }

    public XBTTreeDocument getDoc() {
        return mainDoc;
    }

    public boolean isEditEnabled() {
        return editEnabled;
    }

    public boolean isAddEnabled() {
        return addEnabled;
    }

    public boolean isPasteEnabled() {
        return addEnabled; // && clipboard.isDataFlavorAvailable(xbFlavor);
    }

    public void addUpdateListener(ActionListener tml) {
        updateEventList.add(tml);
    }

    public void removeUpdateListener(ActionListener tml) {
        updateEventList.remove(tml);
    }

    public void performCut() {
        performCopy();
        performDelete();
    }

    public void performCopy() {
        // TODO
    }

    public void performPaste() {
        // TODO
    }

    public void performSelectAll() {
        // TODO: This is not working
        KeyboardFocusManager focusManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        focusManager.processKeyEvent(hexPanel, new KeyEvent(hexPanel, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), KeyEvent.CTRL_DOWN_MASK, KeyEvent.VK_A, KeyEvent.CHAR_UNDEFINED));
        focusManager.processKeyEvent(hexPanel, new KeyEvent(hexPanel, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), KeyEvent.CTRL_DOWN_MASK, KeyEvent.VK_A, KeyEvent.CHAR_UNDEFINED));
    }

    public void performUndo() {
        // TODO
    }

    public void performRedo() {
        // TODO
    }

    public void performAdd() {
        // TODO
    }

    public void performDelete() {
        // TODO
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public void setEditEnabled(boolean editEnabled) {
        if (editEnabled != this.editEnabled) {
            this.editEnabled = editEnabled;
            firePropertyChange("editEnabled", !editEnabled, editEnabled);
        }
    }

    public void setAddEnabled(boolean addEnabled) {
        if (addEnabled != this.addEnabled) {
            this.addEnabled = addEnabled;
            firePropertyChange("addEnabled", !addEnabled, addEnabled);
            firePropertyChange("pasteEnabled", !editEnabled, editEnabled);
        }
    }

    public void updateUndoAvailable() {
        firePropertyChange("undoAvailable", false, true);
        firePropertyChange("redoAvailable", false, true);
    }

    void loadFromStream(InputStream buf, long size) {
        hexPanel.loadFromStream(buf, size);
        hexPanel.repaint();
    }

    void saveToStream(OutputStream buf) {
        try {
            hexPanel.saveToStream(buf);
        } catch (IOException ex) {
            Logger.getLogger(XBDocHexPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
