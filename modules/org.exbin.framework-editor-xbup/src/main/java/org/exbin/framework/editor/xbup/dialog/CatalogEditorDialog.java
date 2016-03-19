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
package org.exbin.framework.editor.xbup.dialog;

import java.awt.BorderLayout;
import java.util.ResourceBundle;
import org.exbin.xbup.core.catalog.XBACatalog;
import org.exbin.framework.gui.menu.api.MenuManagement;
import org.exbin.framework.gui.service.catalog.panel.CatalogEditorPanel;
import org.exbin.framework.gui.service.panel.CatalogAvailabilityPanel;
import org.exbin.framework.gui.service.panel.CatalogManagerPanelable;
import org.exbin.framework.gui.utils.ActionUtils;
import org.exbin.framework.gui.utils.WindowUtils;

/**
 * Dialog for showing information about document block.
 *
 * @version 0.2.0 2016/02/10
 * @author ExBin Project (http://exbin.org)
 */
public class CatalogEditorDialog extends javax.swing.JDialog implements CatalogManagerPanelable {

    private final CatalogEditorPanel catalogEditorPanel;
    private final CatalogAvailabilityPanel catalogAvailabilityPanel;
    private XBACatalog catalog = null;
    private final ResourceBundle bundle = ActionUtils.getResourceBundleByClass(CatalogEditorDialog.class);

    public CatalogEditorDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        catalogEditorPanel = new CatalogEditorPanel();
        catalogAvailabilityPanel = new CatalogAvailabilityPanel();

        initComponents();

        init();
    }

    private void init() {
        getContentPane().add(catalogAvailabilityPanel, BorderLayout.CENTER);
        setSize(900, 600);
        WindowUtils.initWindow(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/exbin/framework/editor/xbup/dialog/resources/CatalogEditorDialog"); // NOI18N
        setTitle(bundle.getString("title")); // NOI18N
        setLocationByPlatform(true);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        WindowUtils.invokeWindow(new CatalogEditorDialog(new javax.swing.JFrame(), true));
    }

    @Override
    public void setMenuManagement(MenuManagement menuManagement) {
        catalogEditorPanel.setMenuManagement(menuManagement);
    }

    @Override
    public void setCatalog(XBACatalog catalog) {
        if (this.catalog == null && catalog != null) {
            catalogAvailabilityPanel.setCatalog(catalog);
            catalogEditorPanel.setCatalog(catalog);
            getContentPane().removeAll();
            getContentPane().add(catalogEditorPanel, BorderLayout.CENTER);
            revalidate();
            repaint();
        } else if (this.catalog != null && catalog == null) {
            catalogAvailabilityPanel.setCatalog(catalog);
            getContentPane().removeAll();
            getContentPane().add(catalogAvailabilityPanel, BorderLayout.CENTER);
            revalidate();
            repaint();
            catalogEditorPanel.setCatalog(catalog);
        } else {
            catalogEditorPanel.setCatalog(catalog);
        }

        this.catalog = catalog;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
