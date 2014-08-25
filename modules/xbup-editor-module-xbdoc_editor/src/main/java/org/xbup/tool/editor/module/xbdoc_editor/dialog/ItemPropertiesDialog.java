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
package org.xbup.tool.editor.module.xbdoc_editor.dialog;

import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JLabel;
import org.xbup.lib.core.block.XBBlockDataMode;
import org.xbup.lib.core.block.XBBlockType;
import org.xbup.lib.core.block.declaration.XBBlockDecl;
import org.xbup.lib.core.block.declaration.XBContextBlockType;
import org.xbup.lib.core.catalog.XBACatalog;
import org.xbup.lib.core.catalog.base.XBCBlockSpec;
import org.xbup.lib.core.catalog.base.service.XBCSpecService;
import org.xbup.lib.core.catalog.base.service.XBCXNameService;
import org.xbup.lib.core.catalog.declaration.XBCBlockDecl;
import org.xbup.lib.core.block.XBBlockTerminationMode;
import org.xbup.lib.parser_tree.XBTTreeNode;
import org.xbup.tool.editor.module.xbdoc_editor.util.BareBonesBrowserLaunch;
import org.xbup.tool.editor.base.api.XBEditorFrame;

/**
 * Dialog for showing information about items.
 *
 * @version 0.1.23 2013/09/23
 * @author XBUP Project (http://xbup.org)
 */
public class ItemPropertiesDialog extends javax.swing.JDialog {

    private XBTTreeNode node;
    private XBACatalog catalog;
    private ResourceBundle resourceBundle = java.util.ResourceBundle.getBundle("org/xbup/tool/xbeditor/module/xbdoceditor/dialog/resources/ItemPropertiesDialog");

    /**
     * Creates new form ItemPropertiesDialog
     */
    public ItemPropertiesDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        if (parent instanceof XBEditorFrame) {
            setIconImage(((XBEditorFrame) parent).getMainFrameManagement().getFrameIcon());
        }
        assignGlobalKeyListener();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButton = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        onlineSpecLinkLabel = new javax.swing.JLabel();
        onlineSpecLinkLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        onlineSpecLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/xbup/tool/xbeditor/module/xbdoceditor/dialog/resources/ItemPropertiesDialog"); // NOI18N
        setTitle(bundle.getString("title")); // NOI18N
        setLocationByPlatform(true);

        okButton.setText(bundle.getString("okButton.text")); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        jLabel1.setText(bundle.getString("jLabel1.text")); // NOI18N

        jTextField1.setEditable(false);

        jLabel2.setText(bundle.getString("jLabel2.text")); // NOI18N

        jTextField2.setEditable(false);

        jLabel3.setText(bundle.getString("jLabel3.text")); // NOI18N

        jLabel4.setText(bundle.getString("jLabel4.text")); // NOI18N

        jCheckBox1.setText(bundle.getString("jCheckBox1.text")); // NOI18N
        jCheckBox1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jCheckBox1.setEnabled(false);
        jCheckBox1.setMargin(new java.awt.Insets(0, 0, 0, 0));

        onlineSpecLinkLabel.setForeground(java.awt.Color.blue);
        onlineSpecLinkLabel.setText(bundle.getString("onlineSpecLinkLabel.text")); // NOI18N
        HashMap<TextAttribute, Object> attribs = new HashMap<TextAttribute, Object>();
        attribs.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_ONE_PIXEL);
        onlineSpecLinkLabel.setFont(onlineSpecLinkLabel.getFont().deriveFont(attribs));
        onlineSpecLinkLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onlineSpecLinkLabelMouseClicked(evt);
            }
        });

        onlineSpecLabel.setText(bundle.getString("onlineSpecLabel.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(onlineSpecLabel)
                    .addComponent(onlineSpecLinkLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(onlineSpecLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(onlineSpecLinkLabel)
                .addContainerGap())
        );

        jTabbedPane1.addTab(bundle.getString("jPanel1.TabConstraints.tabTitle"), jPanel1); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 518, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 225, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab(bundle.getString("jPanel2.TabConstraints.tabTitle"), jPanel2); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(okButton)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(okButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void onlineSpecLinkLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onlineSpecLinkLabelMouseClicked
        BareBonesBrowserLaunch.openURL(((JLabel) evt.getSource()).getText());
}//GEN-LAST:event_onlineSpecLinkLabelMouseClicked

    /** Assign ESCAPE/ENTER key for all focusable components recursively */
    private void assignGlobalKeyListener(Container comp) {
        Component[] comps = comp.getComponents();
        for (int i = 0; i < comps.length; i++) {
            Component item = comps[i];
            if (item.isFocusable()) {
                item.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                    }

                    @Override
                    public void keyPressed(KeyEvent evt) {
                        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
                            okButton.doClick();
                        }
                        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                            if (evt.getSource() instanceof JButton) {
                                ((JButton) evt.getSource()).doClick();
                            } else {
                                okButton.doClick();
                            }
                        }
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });
            }
            if (item instanceof Container) {
                assignGlobalKeyListener((Container) item);
            }
        }
    }

    public void runDialog(XBTTreeNode srcNode) {
        XBCSpecService specService = (XBCSpecService) catalog.getCatalogService(XBCSpecService.class);
        node = srcNode;
        jTextField1.setText(getCaption(node));
        jTextField2.setText(Integer.toString(node.getSizeUB()));
        jCheckBox1.setSelected(node.getTerminationMode() == XBBlockTerminationMode.ZERO_TERMINATED);
        // TODO: Different link for dev mode
        String catalogLink = "http://catalog.xbup.org/";
        XBBlockType type = node.getBlockType();
        if (type instanceof XBContextBlockType) {
            XBBlockDecl decl = ((XBContextBlockType) type).getBlockDecl();
            if (decl instanceof XBCBlockDecl) {
                XBCBlockSpec spec = ((XBCBlockDecl) decl).getBlockSpec(catalog);
                if (spec != null) {
                    Long[] path = specService.getSpecXBPath(spec);
                    StringBuilder builder = new StringBuilder();
                    for (int i = 0; i < path.length; i++) {
                        if (i>0) {
                            builder.append("/");
                        }
                        builder.append(path[i]);
                    }
                    catalogLink += "?spec=" + builder.toString();
                }
            }
        }
        onlineSpecLinkLabel.setText(catalogLink);
        setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ItemPropertiesDialog(new javax.swing.JFrame(), true).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel onlineSpecLabel;
    private javax.swing.JLabel onlineSpecLinkLabel;
    // End of variables declaration//GEN-END:variables

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

    private String getCaption(XBTTreeNode node) {
        if (node.getDataMode() == XBBlockDataMode.DATA_BLOCK) {
            String blockCaption = resourceBundle.getString("block_caption_data");
            if (blockCaption == null) {
                return "Data Block";
            }

            return blockCaption;
        }

        XBBlockType blockType = node.getBlockType();
        if (catalog != null) {
            XBCXNameService nameService = (XBCXNameService) catalog.getCatalogService(XBCXNameService.class);
            if (blockType instanceof XBContextBlockType) {
                XBCBlockDecl blockDecl = (XBCBlockDecl) ((XBContextBlockType) blockType).getBlockDecl();
                if (blockDecl == null) {
                    return "Undefined";
                }
                XBCBlockSpec blockSpec = blockDecl.getBlockSpec(catalog);
                return nameService.getDefaultCaption(blockSpec);
            }
        }
        if (blockType == null) {
            return "Unknown";
        }
        return "Unknown" + " (" + Integer.toString(blockType.getGroupID().getInt()) + ", "+ Integer.toString(blockType.getBlockID().getInt())+")";
    }

    private void assignGlobalKeyListener() {
        assignGlobalKeyListener(this);
    }
}
