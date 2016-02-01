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
package org.xbup.lib.framework.service_manager.catalog.dialog;

import java.awt.Container;
import javax.swing.JOptionPane;
import org.xbup.lib.core.catalog.XBACatalog;
import org.xbup.lib.core.catalog.base.XBCItem;
import org.xbup.lib.core.catalog.base.XBCNode;
import org.xbup.lib.core.catalog.base.XBCSpec;
import org.xbup.lib.framework.gui.menu.api.MenuManagement;
import org.xbup.lib.framework.gui.utils.WindowUtils;
import org.xbup.lib.framework.service_manager.catalog.panel.CatalogItemEditDefinitionPanel;
import org.xbup.lib.framework.service_manager.catalog.panel.CatalogItemEditPanel;
import org.xbup.lib.framework.service_manager.catalog.panel.CatalogItemEditFilesPanel;
import org.xbup.lib.framework.service_manager.catalog.panel.CatalogItemEditRevsPanel;

/**
 * XBManager catalog item editation dialog.
 *
 * @version 0.2.0 2016/02/01
 * @author XBUP Project (http://xbup.org)
 */
public class CatalogEditItemDialog extends javax.swing.JDialog {

    private int dialogOption = JOptionPane.CLOSED_OPTION;

    private XBACatalog catalog;

    private CatalogItemEditPanel propertiesPanel;
    private CatalogItemEditRevsPanel revisionsPanel;
    private CatalogItemEditDefinitionPanel definitionPanel;
    private CatalogItemEditFilesPanel filesPanel;
    private MenuManagement menuManagement;
    private final java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/xbup/tool/editor/module/service_manager/catalog/dialog/resources/CatalogEditItemDialog");

    public CatalogEditItemDialog(java.awt.Frame frame, boolean modal) {
        super(frame, modal);
        initComponents();

        init();
    }

    private void init() {
        WindowUtils.initWindow(this);
        WindowUtils.addHeaderPanel(this, bundle.getString("header.title"), bundle.getString("header.description"), bundle.getString("header.icon"));
        initComponent(this);
    }

    private void initComponent(Container container) {
        WindowUtils.assignGlobalKeyListener(container, setButton, cancelButton);
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

        mainTabbedPane = new javax.swing.JTabbedPane();
        controlPanel = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        setButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/xbup/lib/framework/service_manager/catalog/dialog/resources/CatalogEditItemDialog"); // NOI18N
        setTitle(bundle.getString("title")); // NOI18N
        setModal(true);
        setName("Form"); // NOI18N

        mainTabbedPane.setName("mainTabbedPane"); // NOI18N
        getContentPane().add(mainTabbedPane, java.awt.BorderLayout.CENTER);

        controlPanel.setName("controlPanel"); // NOI18N

        cancelButton.setText(bundle.getString("cancelButton.text")); // NOI18N
        cancelButton.setName("cancelButton"); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        setButton.setText(bundle.getString("setButton.text")); // NOI18N
        setButton.setName("setButton"); // NOI18N
        setButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlPanelLayout.createSequentialGroup()
                .addContainerGap(484, Short.MAX_VALUE)
                .addComponent(setButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelButton)
                .addContainerGap())
        );
        controlPanelLayout.setVerticalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(setButton))
                .addContainerGap())
        );

        getContentPane().add(controlPanel, java.awt.BorderLayout.PAGE_END);

        setSize(new java.awt.Dimension(657, 511));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void setButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setButtonActionPerformed
        dialogOption = JOptionPane.OK_OPTION;
        WindowUtils.closeWindow(this);
}//GEN-LAST:event_setButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dialogOption = JOptionPane.CANCEL_OPTION;
        WindowUtils.closeWindow(this);
}//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        WindowUtils.invokeWindow(new CatalogEditItemDialog(new javax.swing.JFrame(), true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JTabbedPane mainTabbedPane;
    private javax.swing.JButton setButton;
    // End of variables declaration//GEN-END:variables

    public void setCatalogItem(XBCItem item) {
        mainTabbedPane.removeAll();

        propertiesPanel = new CatalogItemEditPanel();
        propertiesPanel.setCatalog(catalog);
        propertiesPanel.setCatalogItem(item);
        initComponent(propertiesPanel);
        mainTabbedPane.add(propertiesPanel, "Basic");

        if (item instanceof XBCSpec) {
            revisionsPanel = new CatalogItemEditRevsPanel();
            revisionsPanel.setCatalog(catalog);
            revisionsPanel.setCatalogItem(item);
            initComponent(revisionsPanel);
            mainTabbedPane.add(revisionsPanel, "Revisions");

            definitionPanel = new CatalogItemEditDefinitionPanel();
            definitionPanel.setCatalog(catalog);
            definitionPanel.setCatalogItem(item);
            revisionsPanel.setDefsModel(definitionPanel.getDefsModel());
            initComponent(definitionPanel);
            mainTabbedPane.add(definitionPanel, "Definition");
        } else if (item instanceof XBCNode) {
            filesPanel = new CatalogItemEditFilesPanel();
            filesPanel.setCatalog(catalog);
            filesPanel.setNode((XBCNode) item);
            if (menuManagement != null) {
                filesPanel.setMenuManagement(menuManagement);
            }

            initComponent(filesPanel);
            mainTabbedPane.add(filesPanel, "Files");
        }
    }

    public void persist() {
        propertiesPanel.persist();
        if (definitionPanel != null) {
            definitionPanel.persist();
        }
        if (revisionsPanel != null) {
            revisionsPanel.persist();
        }
        if (filesPanel != null) {
            filesPanel.persist();
        }
    }

    public void setMenuManagement(MenuManagement menuManagement) {
        this.menuManagement = menuManagement;

        if (filesPanel != null) {
            filesPanel.setMenuManagement(menuManagement);
        }
    }

    public XBCItem getCatalogItem() {
        return propertiesPanel.getCatalogItem();
    }

    public void setCatalog(XBACatalog catalog) {
        this.catalog = catalog;
        if (propertiesPanel != null) {
            propertiesPanel.setCatalog(catalog);
        }
        if (revisionsPanel != null) {
            revisionsPanel.setCatalog(catalog);
        }
        if (definitionPanel != null) {
            definitionPanel.setCatalog(catalog);
        }
        if (filesPanel != null) {
            filesPanel.setCatalog(catalog);
        }
    }
}
