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
package org.xbup.lib.framework.service_manager.catalog.panel;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.DefaultEditorKit;
import org.xbup.lib.core.catalog.XBACatalog;
import org.xbup.lib.core.catalog.base.XBCItem;
import org.xbup.lib.core.catalog.base.XBCNode;
import org.xbup.lib.core.catalog.base.XBCXStri;
import org.xbup.lib.core.catalog.base.service.XBCNodeService;
import org.xbup.lib.core.catalog.base.service.XBCSpecService;
import org.xbup.lib.core.catalog.base.service.XBCXDescService;
import org.xbup.lib.core.catalog.base.service.XBCXNameService;
import org.xbup.lib.core.catalog.base.service.XBCXStriService;
import org.xbup.lib.catalog.XBECatalog;
import org.xbup.lib.catalog.entity.XBEXDesc;
import org.xbup.lib.catalog.entity.XBEXName;
import org.xbup.lib.framework.gui.editor.api.XBEditorProvider;
import org.xbup.lib.framework.gui.file.api.FileType;
import org.xbup.lib.framework.gui.menu.api.MenuManagement;
import org.xbup.lib.framework.gui.utils.WindowUtils;
import org.xbup.lib.framework.service_manager.ServiceManagerHandler;
import org.xbup.lib.framework.service_manager.catalog.dialog.CatalogEditItemDialog;

/**
 * Catalog Specification Panel.
 *
 * @version 0.2.0 2016/02/01
 * @author XBUP Project (http://xbup.org)
 */
public class CatalogBrowserPanel extends javax.swing.JPanel implements XBEditorProvider {

    private XBCItem currentItem;

    private XBACatalog catalog;
    private ServiceManagerHandler serviceManagerHandler;

    // Cached values
    private XBCNodeService nodeService;
    private XBCSpecService specService;
    private XBCXNameService nameService;
    private XBCXDescService descService;
    private XBCXStriService striService;

    private final Map<String, ActionListener> actionListenerMap = new HashMap<>();
    private MenuManagement menuManagement;

    public CatalogBrowserPanel() {
        initComponents();

        updateItem();

        actionListenerMap.put(DefaultEditorKit.cutAction, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performCut();
            }
        });
        actionListenerMap.put(DefaultEditorKit.copyAction, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performCopy();
            }
        });
        actionListenerMap.put(DefaultEditorKit.pasteAction, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performPaste();
            }
        });
        actionListenerMap.put(DefaultEditorKit.deleteNextCharAction, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performDelete();
            }
        });
        actionListenerMap.put("delete", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performDelete();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        catalogTreePopupMenu = new javax.swing.JPopupMenu();
        popupEditMenuItem = new javax.swing.JMenuItem();
        popupRefreshMenuItem = new javax.swing.JMenuItem();
        panelSplitPane = new javax.swing.JSplitPane();
        catalogItemSplitPane = new javax.swing.JSplitPane();
        temporaryPanel = new javax.swing.JPanel();
        temporaryLabel = new javax.swing.JLabel();

        catalogTreePopupMenu.setName("catalogTreePopupMenu"); // NOI18N

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/xbup/lib/framework/service_manager/catalog/panel/resources/CatalogItemsTreePanel"); // NOI18N
        popupEditMenuItem.setText(bundle.getString("editMenuItem.text")); // NOI18N
        popupEditMenuItem.setToolTipText(bundle.getString("editMenuItem,toolTipText")); // NOI18N
        popupEditMenuItem.setName("popupEditMenuItem"); // NOI18N
        popupEditMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popupEditMenuItemActionPerformed(evt);
            }
        });
        catalogTreePopupMenu.add(popupEditMenuItem);

        popupRefreshMenuItem.setText(bundle.getString("refreshMenuItem,text")); // NOI18N
        popupRefreshMenuItem.setToolTipText(bundle.getString("refreshMenuItem,toolTipText")); // NOI18N
        popupRefreshMenuItem.setName("popupRefreshMenuItem"); // NOI18N
        popupRefreshMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popupRefreshMenuItemActionPerformed(evt);
            }
        });
        catalogTreePopupMenu.add(popupRefreshMenuItem);

        setName("Form"); // NOI18N
        setLayout(new java.awt.BorderLayout());

        panelSplitPane.setDividerLocation(100);
        panelSplitPane.setName("panelSplitPane"); // NOI18N

        catalogItemSplitPane.setDividerLocation(180);
        catalogItemSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        catalogItemSplitPane.setName("catalogItemSplitPane"); // NOI18N
        panelSplitPane.setLeftComponent(catalogItemSplitPane);

        temporaryPanel.setName("temporaryPanel"); // NOI18N
        temporaryPanel.setLayout(new java.awt.BorderLayout());

        temporaryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        temporaryLabel.setText("TBD");
        temporaryLabel.setName("temporaryLabel"); // NOI18N
        temporaryPanel.add(temporaryLabel, java.awt.BorderLayout.CENTER);

        panelSplitPane.setRightComponent(temporaryPanel);

        add(panelSplitPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void popupEditMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popupEditMenuItemActionPerformed
        if (currentItem != null) {
            CatalogEditItemDialog editDialog = new CatalogEditItemDialog(WindowUtils.getFrame(this), true);
            editDialog.setMenuManagement(menuManagement);
            editDialog.setCatalog(catalog);
            editDialog.setCatalogItem(currentItem);
            editDialog.setVisible(true);

            if (editDialog.getDialogOption() == JOptionPane.OK_OPTION) {
                EntityManager em = ((XBECatalog) catalog).getEntityManager();
                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                editDialog.persist();
                setItem(currentItem);
                em.flush();
                transaction.commit();
            }
        }
    }//GEN-LAST:event_popupEditMenuItemActionPerformed

    private void popupRefreshMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popupRefreshMenuItemActionPerformed
        Component invoker = catalogTreePopupMenu.getInvoker();
        reloadNodesTree();
    }//GEN-LAST:event_popupRefreshMenuItemActionPerformed

    public void setNode(XBCNode node) {
        setItem(node);
    }

    public void setItem(XBCItem item) {
        currentItem = item;

        if (serviceManagerHandler != null) {
//            updateActionStatus(serviceManagerHandler.getLastFocusOwner());
        }

        updateItem();
    }

//    @Override
//    public boolean updateActionStatus(Component component) {
//        // clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//
//        if (serviceManagerHandler != null) {
//            serviceManagerHandler.getCutAction().setEnabled(currentItem != null);
//            serviceManagerHandler.getCopyAction().setEnabled(currentItem != null);
//            serviceManagerHandler.getPasteAction().setEnabled(false); // TODO clipboard.isDataFlavorAvailable(xbFlavor));
//            serviceManagerHandler.getDeleteAction().setEnabled(currentItem != null);
//            serviceManagerHandler.getSelectAllAction().setEnabled(false);
//        }
//
//        // frameManagement.getUndoAction().setEnabled(treeUndo.canUndo());
//        // frameManagement.getRedoAction().setEnabled(treeUndo.canRedo());
//        return true;
//    }
    public void setServiceManagerHandler(ServiceManagerHandler serviceManagerHandler) {
        this.serviceManagerHandler = serviceManagerHandler;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSplitPane catalogItemSplitPane;
    private javax.swing.JPopupMenu catalogTreePopupMenu;
    private javax.swing.JSplitPane panelSplitPane;
    private javax.swing.JMenuItem popupEditMenuItem;
    private javax.swing.JMenuItem popupRefreshMenuItem;
    private javax.swing.JLabel temporaryLabel;
    private javax.swing.JPanel temporaryPanel;
    // End of variables declaration//GEN-END:variables

    public void setCatalog(XBACatalog catalog) {
        this.catalog = catalog;

        nodeService = catalog == null ? null : (XBCNodeService) catalog.getCatalogService(XBCNodeService.class);
        specService = catalog == null ? null : (XBCSpecService) catalog.getCatalogService(XBCSpecService.class);
        nameService = catalog == null ? null : (XBCXNameService) catalog.getCatalogService(XBCXNameService.class);
        descService = catalog == null ? null : (XBCXDescService) catalog.getCatalogService(XBCXDescService.class);
        striService = catalog == null ? null : (XBCXStriService) catalog.getCatalogService(XBCXStriService.class);

        reloadNodesTree();
    }

    public void performCut() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void performCopy() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void performPaste() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void performDelete() {
        Object[] options = {
            "Delete",
            "Cancel"
        };

        int result = JOptionPane.showOptionDialog(this,
                "Are you sure you want to delete this item?",
                "Delete Item",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);

        if (result == JOptionPane.OK_OPTION) {
            // TODO: Use different transaction management later
            EntityManager em = ((XBECatalog) catalog).getEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            List<XBEXName> names = nameService.getItemNames(currentItem);
            for (XBEXName name : names) {
                nameService.removeItem(name);
            }

            List<XBEXDesc> descs = descService.getItemDescs(currentItem);
            for (XBEXDesc desc : descs) {
                descService.removeItem(desc);
            }

            XBCXStri stri = striService.getItemStringId(currentItem);
            if (stri != null) {
                striService.removeItem(stri);
            }

            if (currentItem instanceof XBCNode) {
                nodeService.removeItem(currentItem);
            } else {
                specService.removeItem(currentItem);
            }
            em.flush();
            transaction.commit();

            repaint();
        }
    }

//    public boolean performAction(String eventName, ActionEvent event) {
//        if (serviceManagerHandler != null && serviceManagerHandler.getLastFocusOwner() != null) {
//            ActionListener actionListener = actionListenerMap.get(eventName);
//            if (actionListener != null) {
//                actionListener.actionPerformed(event);
//                return true;
//            }
//        }
//
//        return false;
//    }
    /**
     * Gets the extension part of file name.
     *
     * @param file Source file
     * @return extension part of file name
     */
    public static String getExtension(File file) {
        String ext = null;
        String str = file.getName();
        int i = str.lastIndexOf('.');

        if (i > 0 && i < str.length() - 1) {
            ext = str.substring(i + 1).toLowerCase();
        }
        return ext;
    }

    public void setMenuManagement(MenuManagement menuManagement) {
        this.menuManagement = menuManagement;
        menuManagement.insertMainPopupMenu(catalogTreePopupMenu, 4);
    }

    private void reloadNodesTree() {
        XBCNode rootNode = nodeService.getRootNode();
    }

    private void updateItem() {
        popupEditMenuItem.setEnabled(currentItem != null);
    }

    @Override
    public JPanel getPanel() {
        return this;
    }

    @Override
    public void setPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getWindowTitle(String frameTitle) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void loadFromFile() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void saveToFile() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getFileName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setFileName(String string) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setFileType(FileType ft) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void newFile() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isModified() {
        return false;
    }
}
