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
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import org.exbin.xbup.core.block.XBBlockDataMode;
import org.exbin.xbup.core.block.XBBlockTerminationMode;
import org.exbin.xbup.core.block.XBBlockType;
import org.exbin.xbup.core.block.XBFBlockType;
import org.exbin.xbup.core.block.XBTBlock;
import org.exbin.xbup.core.block.declaration.XBBlockDecl;
import org.exbin.xbup.core.block.declaration.catalog.XBCBlockDecl;
import org.exbin.xbup.core.catalog.XBACatalog;
import org.exbin.xbup.core.catalog.base.XBCBlockSpec;
import org.exbin.xbup.core.catalog.base.service.XBCSpecService;
import org.exbin.xbup.core.catalog.base.service.XBCXNameService;
import org.exbin.framework.gui.service.catalog.panel.CatalogItemInfoPanel;
import org.exbin.framework.gui.utils.ActionUtils;
import org.exbin.framework.gui.utils.BareBonesBrowserLaunch;
import org.exbin.framework.gui.utils.WindowUtils;
import org.exbin.xbup.parser_tree.XBTTreeNode;

/**
 * Dialog for showing information about document block.
 *
 * @version 0.2.0 2016/02/08
 * @author ExBin Project (http://exbin.org)
 */
public class BlockPropertiesDialog extends javax.swing.JDialog {

    private XBTBlock block;
    private XBACatalog catalog;
    private final CatalogItemInfoPanel catalogItemPanel;
    private boolean devMode = false;
    private final ResourceBundle bundle = ActionUtils.getResourceBundleByClass(BlockPropertiesDialog.class);

    public BlockPropertiesDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        catalogItemPanel = new CatalogItemInfoPanel();
        typePanel.add(catalogItemPanel, BorderLayout.CENTER);
        init();
    }

    private void init() {
        WindowUtils.initWindow(this);
        WindowUtils.addHeaderPanel(this, bundle.getString("header.title"), bundle.getString("header.description"), bundle.getString("header.icon"));
        WindowUtils.assignGlobalKeyListener(this, closeButton);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        linkPopupMenu = new javax.swing.JPopupMenu();
        copyLinkMenuItem = new javax.swing.JMenuItem();
        tabbedPane = new javax.swing.JTabbedPane();
        generalPanel = new javax.swing.JPanel();
        nodeTypeLabel = new javax.swing.JLabel();
        nodeTypeTextField = new javax.swing.JTextField();
        dataModeLabel = new javax.swing.JLabel();
        dataModeTextField = new javax.swing.JTextField();
        terminationModeLabel = new javax.swing.JLabel();
        terminationModeTextField = new javax.swing.JTextField();
        nodeSizeLabel = new javax.swing.JLabel();
        nodeSizeTextField = new javax.swing.JTextField();
        attributesCountLabel = new javax.swing.JLabel();
        attributesCountTextField = new javax.swing.JTextField();
        childrenCountLabel = new javax.swing.JLabel();
        childrenCountTextField = new javax.swing.JTextField();
        webCatalogLabel = new javax.swing.JLabel();
        webCatalogLinkScrollPane = new javax.swing.JScrollPane();
        webCatalogLinkLabel = new javax.swing.JLabel();
        webCatalogLinkLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        typePanel = new javax.swing.JPanel();
        controlPanel = new javax.swing.JPanel();
        closeButton = new javax.swing.JButton();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/exbin/framework/editor/xbup/dialog/resources/BlockPropertiesDialog"); // NOI18N
        copyLinkMenuItem.setText(bundle.getString("copyLinkMenuItem.text")); // NOI18N
        copyLinkMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyLinkMenuItemActionPerformed(evt);
            }
        });
        linkPopupMenu.add(copyLinkMenuItem);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(bundle.getString("title")); // NOI18N
        setLocationByPlatform(true);

        nodeTypeLabel.setText(bundle.getString("nodeTypeLabel.text")); // NOI18N

        nodeTypeTextField.setEditable(false);

        dataModeLabel.setText(bundle.getString("dataModeLabel.text")); // NOI18N

        dataModeTextField.setEditable(false);

        terminationModeLabel.setText(bundle.getString("terminationModeLabel.text")); // NOI18N

        terminationModeTextField.setEditable(false);

        nodeSizeLabel.setText(bundle.getString("nodeSizeLabel.text")); // NOI18N

        nodeSizeTextField.setEditable(false);

        attributesCountLabel.setText(bundle.getString("attributesCountLabel.text")); // NOI18N

        attributesCountTextField.setEditable(false);

        childrenCountLabel.setText(bundle.getString("childrenCountLabel.text")); // NOI18N

        childrenCountTextField.setEditable(false);

        webCatalogLabel.setText(bundle.getString("webCatalogLabell.text")); // NOI18N

        webCatalogLinkScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        webCatalogLinkScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        webCatalogLinkLabel.setForeground(java.awt.Color.blue);
        webCatalogLinkLabel.setText(bundle.getString("webCatalogLabel.text")); // NOI18N
        webCatalogLinkLabel.setComponentPopupMenu(linkPopupMenu);
        HashMap<TextAttribute, Object> attribs = new HashMap<TextAttribute, Object>();
        attribs.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_ONE_PIXEL);
        webCatalogLinkLabel.setFont(webCatalogLinkLabel.getFont().deriveFont(attribs));
        webCatalogLinkLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                webCatalogLinkLabelMouseClicked(evt);
            }
        });
        webCatalogLinkScrollPane.setViewportView(webCatalogLinkLabel);

        javax.swing.GroupLayout generalPanelLayout = new javax.swing.GroupLayout(generalPanel);
        generalPanel.setLayout(generalPanelLayout);
        generalPanelLayout.setHorizontalGroup(
            generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(terminationModeLabel)
                    .addComponent(nodeSizeLabel)
                    .addComponent(attributesCountLabel)
                    .addComponent(childrenCountLabel)
                    .addComponent(webCatalogLabel)
                    .addComponent(dataModeLabel)
                    .addComponent(nodeTypeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nodeTypeTextField)
                    .addComponent(dataModeTextField)
                    .addComponent(childrenCountTextField)
                    .addComponent(attributesCountTextField)
                    .addComponent(nodeSizeTextField)
                    .addComponent(terminationModeTextField)
                    .addComponent(webCatalogLinkScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
                .addContainerGap())
        );
        generalPanelLayout.setVerticalGroup(
            generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nodeTypeLabel)
                    .addComponent(nodeTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataModeLabel)
                    .addComponent(dataModeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(terminationModeLabel)
                    .addComponent(terminationModeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nodeSizeLabel)
                    .addComponent(nodeSizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(attributesCountLabel)
                    .addComponent(attributesCountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(childrenCountLabel)
                    .addComponent(childrenCountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(generalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(webCatalogLabel)
                    .addComponent(webCatalogLinkScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        tabbedPane.addTab(bundle.getString("generalPanel.tabTitle"), generalPanel); // NOI18N

        typePanel.setLayout(new java.awt.BorderLayout());
        tabbedPane.addTab(bundle.getString("typePanel.tabTitle"), typePanel); // NOI18N

        getContentPane().add(tabbedPane, java.awt.BorderLayout.CENTER);

        closeButton.setText(bundle.getString("okButton.text")); // NOI18N
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlPanelLayout.createSequentialGroup()
                .addContainerGap(302, Short.MAX_VALUE)
                .addComponent(closeButton)
                .addContainerGap())
        );
        controlPanelLayout.setVerticalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(closeButton)
                .addContainerGap())
        );

        getContentPane().add(controlPanel, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        WindowUtils.closeWindow(this);
    }//GEN-LAST:event_closeButtonActionPerformed

    private void webCatalogLinkLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_webCatalogLinkLabelMouseClicked
        if (!evt.isPopupTrigger()) {
            String targetURL = ((JLabel) evt.getSource()).getText();
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

            if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                try {
                    java.net.URI uri = new java.net.URI(targetURL);
                    desktop.browse(uri);
                } catch (IOException | URISyntaxException ex) {
                    Logger.getLogger(BlockPropertiesDialog.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                BareBonesBrowserLaunch.openURL(targetURL);
            }
        }
    }//GEN-LAST:event_webCatalogLinkLabelMouseClicked

    private void copyLinkMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyLinkMenuItemActionPerformed
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(new StringSelection(webCatalogLinkLabel.getText()), null);
    }//GEN-LAST:event_copyLinkMenuItemActionPerformed

    public void runDialog(XBTTreeNode srcNode) {
        XBCSpecService specService = (XBCSpecService) catalog.getCatalogService(XBCSpecService.class);
        block = srcNode;
        nodeTypeTextField.setText(getCaption(block));
        dataModeTextField.setText(block.getDataMode() == XBBlockDataMode.DATA_BLOCK ? "DATA_BLOCK" : "NODE_BLOCK");
        terminationModeTextField.setText(block.getTerminationMode() == XBBlockTerminationMode.TERMINATED_BY_ZERO ? "TERMINATED_BY_ZERO" : "SIZE_SPECIFIED");
        nodeSizeTextField.setText(block instanceof XBTTreeNode ? Integer.toString(((XBTTreeNode) block).getSizeUB()) : "Unknown");
        attributesCountTextField.setText(String.valueOf(block.getAttributesCount()));
        childrenCountTextField.setText(String.valueOf(block.getChildrenCount()));

        String catalogLink = devMode ? "http://catalog-dev.exbin.org/" : "http://catalog.exbin.org/";
        XBBlockDecl decl = block instanceof XBTTreeNode ? ((XBTTreeNode) block).getBlockDecl() : null;
        if (decl instanceof XBCBlockDecl) {
            XBCBlockSpec spec = ((XBCBlockDecl) decl).getBlockSpecRev().getParent();
            catalogItemPanel.setCatalog(catalog);
            catalogItemPanel.setItem(spec);
            if (spec != null) {
                Long[] path = specService.getSpecXBPath(spec);
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < path.length; i++) {
                    if (i > 0) {
                        builder.append("/");
                    }
                    builder.append(path[i]);
                }
                catalogLink += "?block=" + builder.toString();
            }
        }

        webCatalogLinkLabel.setText(catalogLink);
        webCatalogLinkLabel.setToolTipText("Link to: " + catalogLink);
        setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        WindowUtils.invokeWindow(new BlockPropertiesDialog(new javax.swing.JFrame(), true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel attributesCountLabel;
    private javax.swing.JTextField attributesCountTextField;
    private javax.swing.JLabel childrenCountLabel;
    private javax.swing.JTextField childrenCountTextField;
    private javax.swing.JButton closeButton;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JMenuItem copyLinkMenuItem;
    private javax.swing.JLabel dataModeLabel;
    private javax.swing.JTextField dataModeTextField;
    private javax.swing.JPanel generalPanel;
    private javax.swing.JPopupMenu linkPopupMenu;
    private javax.swing.JLabel nodeSizeLabel;
    private javax.swing.JTextField nodeSizeTextField;
    private javax.swing.JLabel nodeTypeLabel;
    private javax.swing.JTextField nodeTypeTextField;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JLabel terminationModeLabel;
    private javax.swing.JTextField terminationModeTextField;
    private javax.swing.JPanel typePanel;
    private javax.swing.JLabel webCatalogLabel;
    private javax.swing.JLabel webCatalogLinkLabel;
    private javax.swing.JScrollPane webCatalogLinkScrollPane;
    // End of variables declaration//GEN-END:variables

    public XBACatalog getCatalog() {
        return catalog;
    }

    public void setCatalog(XBACatalog catalog) {
        this.catalog = catalog;
    }

    public void setDevMode(boolean devMode) {
        this.devMode = devMode;
    }

    private String getCaption(XBTBlock node) {
        if (node.getDataMode() == XBBlockDataMode.DATA_BLOCK) {
            return bundle.getString("node_caption_data");
        }

        XBBlockType blockType = node.getBlockType();
        if (catalog != null) {
            XBCXNameService nameService = (XBCXNameService) catalog.getCatalogService(XBCXNameService.class);

            XBCBlockDecl blockDecl = node instanceof XBTTreeNode ? (XBCBlockDecl) ((XBTTreeNode) node).getBlockDecl() : null;
            if (blockDecl == null) {
                return bundle.getString("node_caption_undefined");
            }
            XBCBlockSpec blockSpec = blockDecl.getBlockSpecRev().getParent();
            return nameService.getDefaultText(blockSpec);
        }
        if (blockType == null) {
            return bundle.getString("node_caption_unknown");
        }

        return bundle.getString("node_caption_unknown") + " (" + Integer.toString(((XBFBlockType) blockType).getGroupID().getInt()) + ", " + Integer.toString(((XBFBlockType) blockType).getBlockID().getInt()) + ")";
    }
}
