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
package org.xbup.tool.xbeditor.module.xbdoceditor.dialog;

import hexedit.HexEditPanel;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.xbup.lib.xb.block.XBBlockDataMode;
import org.xbup.lib.xb.block.declaration.XBContextBlockType;
import org.xbup.lib.xb.catalog.XBACatalog;
import org.xbup.lib.xb.catalog.base.XBCBlockRev;
import org.xbup.lib.xb.catalog.base.XBCBlockSpec;
import org.xbup.lib.xb.catalog.base.XBCXBlockPane;
import org.xbup.lib.xb.catalog.base.XBCXPlugPane;
import org.xbup.lib.xb.catalog.base.XBCXPlugin;
import org.xbup.lib.xb.catalog.base.service.XBCRevService;
import org.xbup.lib.xb.catalog.base.service.XBCXPaneService;
import org.xbup.lib.xb.catalog.declaration.XBCBlockDecl;
import org.xbup.lib.xb.parser.XBParserMode;
import org.xbup.lib.xb.parser.XBProcessingException;
import org.xbup.lib.xb.parser.token.event.XBEventWriter;
import org.xbup.lib.xb.parser.token.event.convert.XBTToXBEventConvertor;
import org.xbup.lib.xb.parser.token.pull.XBPullReader;
import org.xbup.lib.xb.parser.token.pull.convert.XBToXBTPullConvertor;
import org.xbup.lib.xb.parser.tree.XBTTreeDocument;
import org.xbup.lib.xb.parser.tree.XBTTreeNode;
import org.xbup.lib.xb.serial.XBSerializable;
import org.xbup.lib.xb.serial.XBSerializationType;
import org.xbup.lib.xb.serial.child.XBTChildListenerSerialHandler;
import org.xbup.lib.xb.serial.child.XBTChildProviderSerialHandler;
import org.xbup.lib.xb.ubnumber.UBNatural;
import org.xbup.lib.xb.ubnumber.type.UBNat32;
import org.xbup.lib.xbplugin.XBPanelEditor;
import org.xbup.lib.xbplugin.XBPlugin;
import org.xbup.lib.xbplugin.XBPluginRepository;
import org.xbup.tool.xbeditorbase.base.api.XBEditorFrame;

/**
 * Dialog for modifying item attributes or data.
 *
 * @version 0.1 wr23.0 2013/09/23
 * @author XBUP Project (http://xbup.org)
 */
public class ItemModifyDialog extends javax.swing.JDialog {

    private ItemAttribsTableModel tableModel = new ItemAttribsTableModel();
    private XBTTreeNode node;
    private XBTTreeNode srcNode;
    private HexEditPanel hexPanel;
    private JPanel customPanel;
    private XBACatalog catalog;
    private XBPluginRepository pluginRepository;

    /**
     * Creates new form ItemModifyDialog
     */
    public ItemModifyDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        if (parent instanceof XBEditorFrame) {
            setIconImage(((XBEditorFrame) parent).getMainFrameManagement().getFrameIcon());
        }

        hexPanel = new HexEditPanel((JFrame) parent);
        customPanel = null;
        hexEditPanel.add(hexPanel);
        assignGlobalKeyListener();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        defaultEditorPanel = new javax.swing.JPanel();
        attributesScrollPane = new javax.swing.JScrollPane();
        attributesTable = new javax.swing.JTable();
        modifyButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        dataEditorPanel = new javax.swing.JPanel();
        dataLabel = new javax.swing.JLabel();
        saveAsButton = new javax.swing.JButton();
        loadFromButton = new javax.swing.JButton();
        hexEditPanel = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/xbup/tool/xbeditor/module/xbdoceditor/dialog/resources/ItemModifyDialog"); // NOI18N
        setTitle(bundle.getString("title")); // NOI18N
        setLocationByPlatform(true);
        setModal(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        mainPanel.setLayout(new java.awt.CardLayout());

        defaultEditorPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("jPanel1.border.title"))); // NOI18N

        attributesTable.setModel(tableModel);
        attributesTable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                attributesTablePropertyChange(evt);
            }
        });
        attributesScrollPane.setViewportView(attributesTable);
        attributesTable.getAccessibleContext().setAccessibleName("AttributeTable");

        modifyButton.setText(bundle.getString("modifyButton.text")); // NOI18N
        modifyButton.setEnabled(false);

        removeButton.setText(bundle.getString("removeButton.text")); // NOI18N
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        addButton.setText(bundle.getString("addButton.text")); // NOI18N
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout defaultEditorPanelLayout = new org.jdesktop.layout.GroupLayout(defaultEditorPanel);
        defaultEditorPanel.setLayout(defaultEditorPanelLayout);
        defaultEditorPanelLayout.setHorizontalGroup(
            defaultEditorPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, defaultEditorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(attributesScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(defaultEditorPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(removeButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(addButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(modifyButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        defaultEditorPanelLayout.setVerticalGroup(
            defaultEditorPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(defaultEditorPanelLayout.createSequentialGroup()
                .add(defaultEditorPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(defaultEditorPanelLayout.createSequentialGroup()
                        .add(addButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(removeButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(modifyButton))
                    .add(attributesScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
                .addContainerGap())
        );

        mainPanel.add(defaultEditorPanel, "card0");

        dataLabel.setText(bundle.getString("dataLabel.text")); // NOI18N

        saveAsButton.setText(bundle.getString("saveAsButton.text")); // NOI18N
        saveAsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsButtonActionPerformed(evt);
            }
        });

        loadFromButton.setText(bundle.getString("loadFromButton.text")); // NOI18N
        loadFromButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadFromButtonActionPerformed(evt);
            }
        });

        hexEditPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        hexEditPanel.setLayout(new java.awt.BorderLayout());

        org.jdesktop.layout.GroupLayout dataEditorPanelLayout = new org.jdesktop.layout.GroupLayout(dataEditorPanel);
        dataEditorPanel.setLayout(dataEditorPanelLayout);
        dataEditorPanelLayout.setHorizontalGroup(
            dataEditorPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(dataEditorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(dataEditorPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(hexEditPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, dataEditorPanelLayout.createSequentialGroup()
                        .add(dataEditorPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(dataEditorPanelLayout.createSequentialGroup()
                                .add(dataLabel)
                                .add(351, 351, 351))
                            .add(dataEditorPanelLayout.createSequentialGroup()
                                .add(loadFromButton)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)))
                        .add(saveAsButton)))
                .addContainerGap())
        );
        dataEditorPanelLayout.setVerticalGroup(
            dataEditorPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(dataEditorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(dataLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(hexEditPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(dataEditorPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(saveAsButton)
                    .add(loadFromButton))
                .addContainerGap())
        );

        mainPanel.add(dataEditorPanel, "card2");

        cancelButton.setText(bundle.getString("cancelButton.text")); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        okButton.setText(bundle.getString("okButton.text")); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(335, Short.MAX_VALUE)
                .add(okButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(cancelButton)
                .addContainerGap())
            .add(mainPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 493, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(mainPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cancelButton)
                    .add(okButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        node.addAttribute(new UBNat32());
        tableModel.fireTableDataChanged();
//        tableModel.fireTableRowsInserted(tableModel.getAttribs().size()-1,tableModel.getAttribs().size());
        attributesTable.revalidate();
        removeButton.setEnabled(true);
    }//GEN-LAST:event_addButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        int index = node.getAttributesCount();
        if (index>1) {
            node.removeAttribute((int) (index-1));
            if (index==2) {
                removeButton.setEnabled(false);
            }
        }
        attributesTable.revalidate();
    }//GEN-LAST:event_removeButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        setVisible(false);
        if (node != null) {
            if (node.getDataMode() == XBBlockDataMode.DATA_BLOCK) {
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                try {
                    HexEditPanel.saveToStream(stream);
                } catch (IOException ex) {
                    Logger.getLogger(ItemModifyDialog.class.getName()).log(Level.SEVERE, null, ex);
                }
                node.setData(new ByteArrayInputStream(stream.toByteArray()));
            }
        } else if (customPanel instanceof XBSerializable) {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            XBTTreeDocument doc = new XBTTreeDocument(catalog);
            try {
                // TODO: Do proper loading later
                XBTChildListenerSerialHandler handler = new XBTChildListenerSerialHandler();
                handler.attachXBTEventListener(new XBTToXBEventConvertor(new XBEventWriter(stream)));
                ((XBSerializable) customPanel).serializeXB(XBSerializationType.TO_XB, 0, handler);
                doc.fromStreamUB(new ByteArrayInputStream(stream.toByteArray()));
                node = (XBTTreeNode) doc.getRootBlock();
                // TODO: Patching node type, should be handled by context later
                node.setAttribute(srcNode.getAttribute(0), 0);
                node.setAttribute(srcNode.getAttribute(1), 1);
            } catch (IOException ex) {
                Logger.getLogger(ItemModifyDialog.class.getName()).log(Level.SEVERE, null, ex);
            } catch (XBProcessingException ex) {
                Logger.getLogger(ItemModifyDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setVisible(false);
        node = null;
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void attributesTablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_attributesTablePropertyChange
        attributesTable.repaint();
    }//GEN-LAST:event_attributesTablePropertyChange

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        node = null;
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void loadFromButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadFromButtonActionPerformed
        HexEditPanel.openFile(null);
        hexPanel.repaint();
}//GEN-LAST:event_loadFromButtonActionPerformed

    private void saveAsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsButtonActionPerformed
        HexEditPanel.saveFile();
}//GEN-LAST:event_saveAsButtonActionPerformed

    public XBTTreeNode runDialog(XBTTreeNode srcNode) {
        this.srcNode = srcNode;
        if (srcNode.getDataMode() == XBBlockDataMode.DATA_BLOCK) {
            ((CardLayout) mainPanel.getLayout()).last(mainPanel);
            node = new XBTTreeNode();
            node.setDataMode(XBBlockDataMode.DATA_BLOCK);
            HexEditPanel.loadFromStream(srcNode.getData(), srcNode.getDataSize());
//            jTextArea1.setText(new String(extended));
        } else {
            customPanel = getCustomPanel(srcNode);
            if (customPanel instanceof XBSerializable) {
                try {
                    ByteArrayOutputStream ostream = new ByteArrayOutputStream();
                    srcNode.toStreamUB(ostream);
                    ByteArrayInputStream stream = new ByteArrayInputStream(ostream.toByteArray());
                    XBTChildProviderSerialHandler handler = new XBTChildProviderSerialHandler();
                    handler.attachXBTPullProvider(new XBToXBTPullConvertor(new XBPullReader(stream, XBParserMode.SINGLE_BLOCK)));
                    ((XBSerializable) customPanel).serializeXB(XBSerializationType.FROM_XB, 0, handler);
                    node = null;
                    mainPanel.add(customPanel,"custom");
                    ((CardLayout) mainPanel.getLayout()).show(mainPanel, "custom");
                } catch (XBProcessingException ex) {
                    Logger.getLogger(ItemModifyDialog.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ItemModifyDialog.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                ((CardLayout) mainPanel.getLayout()).first(mainPanel);
                node = new XBTTreeNode();
                node.clearAttributes();
                node.setBlockType(new XBContextBlockType(0, 0));
                if (srcNode.getBlockType() != null) {
                    node.addAttribute(srcNode.getBlockType().getGroupID()); // TODO: This is ugly code, should be fixed later
                    node.addAttribute(srcNode.getBlockType().getBlockID()); // TODO: This is ugly code, should be fixed later
                }
                for (Iterator it = srcNode.getAttributes().iterator(); it.hasNext();) {
                    node.addAttribute(new UBNat32((UBNat32) it.next()));
                }
                tableModel.setAttribs(node.getAttributes());
//                if (srcNode.getTypeSpec() instanceof XBCPContextSpec) tableModel.setTypeSpec((XBCPContextSpec) srcNode.getTypeSpec());
                tableModel.updateBlockAttribs();
                removeButton.setEnabled(node.getAttributes().size() > 1);
            }
        }
        setVisible(true);
        return node;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JScrollPane attributesScrollPane;
    private javax.swing.JTable attributesTable;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel dataEditorPanel;
    private javax.swing.JLabel dataLabel;
    private javax.swing.JPanel defaultEditorPanel;
    private javax.swing.JPanel hexEditPanel;
    private javax.swing.JButton loadFromButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton modifyButton;
    private javax.swing.JButton okButton;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton saveAsButton;
    // End of variables declaration//GEN-END:variables

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
                            cancelButton.doClick();
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

    /**
     * @return the pluginRepository
     */
    public XBPluginRepository getPluginRepository() {
        return pluginRepository;
    }

    /**
     * @param pluginRepository the pluginRepository to set
     */
    public void setPluginRepository(XBPluginRepository pluginRepository) {
        this.pluginRepository = pluginRepository;
    }

    private JPanel getCustomPanel(XBTTreeNode srcNode) {
        if (catalog == null) {
            return null;
        }
        if (srcNode.getBlockType() == null) {
            return null;
        }
        if (((XBContextBlockType) srcNode.getBlockType()).getBlockDecl() == null) {
            return null;
        }
        XBCRevService revService = (XBCRevService) catalog.getCatalogService(XBCRevService.class);
        XBCXPaneService paneService = (XBCXPaneService) catalog.getCatalogService(XBCXPaneService.class);
        XBCBlockDecl decl = ((XBCBlockDecl) ((XBContextBlockType) srcNode.getBlockType()).getBlockDecl());
        if (decl == null) {
            return null;
        }
        XBCBlockSpec spec = decl.getBlockSpec(catalog);
        if (spec == null) {
            return null;
        }
        int revision = decl.getRevision();
        XBCBlockRev rev = (XBCBlockRev) revService.getRev(spec, revision);
        if (rev == null) {
            return null;
        }
        XBCXBlockPane pane = paneService.findPaneByPR(rev, 0);
        if (pane == null) {
            return null;
        }
        XBCXPlugPane plugPane = pane.getPane();
        if (plugPane == null) {
            return null;
        }
        XBCXPlugin plugin = plugPane.getPlugin();
        XBPlugin pluginHandler = null;
        // This part is stub for Java Webstart, uncomment it if needed
        /*if ("XBPicturePlugin.jar".equals(plugin.getPluginFile().getFilename())) {
            pluginHandler = new XBPicturePlugin();
        } else */ pluginHandler = pluginRepository.getPluginHandler(plugin);
        if (pluginHandler == null) {
            return null;
        }
        XBPanelEditor panelEditor = pluginHandler.getPanelEditor(plugPane.getPaneIndex());
        if (panelEditor == null) {
            return null;
        }
        return panelEditor.getPanel();
    }

    private void assignGlobalKeyListener() {
        assignGlobalKeyListener(this);
    }
}
