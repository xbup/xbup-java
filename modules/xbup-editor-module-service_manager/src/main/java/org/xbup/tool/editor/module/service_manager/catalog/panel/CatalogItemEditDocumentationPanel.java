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
package org.xbup.tool.editor.module.service_manager.catalog.panel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLEditorKit;
import org.xbup.lib.core.catalog.XBACatalog;
import org.xbup.lib.core.catalog.base.XBCItem;
import org.xbup.lib.core.catalog.base.XBCXFile;
import org.xbup.lib.core.catalog.base.XBCXHDoc;
import org.xbup.lib.core.catalog.base.XBCXLanguage;
import org.xbup.lib.core.catalog.base.XBCXStri;
import org.xbup.lib.core.catalog.base.service.XBCXFileService;
import org.xbup.lib.core.catalog.base.service.XBCXHDocService;
import org.xbup.lib.core.catalog.base.service.XBCXLangService;
import org.xbup.lib.core.catalog.base.service.XBCXStriService;
import org.xbup.lib.catalog.entity.XBEItem;
import org.xbup.lib.catalog.entity.XBENode;
import org.xbup.lib.catalog.entity.XBEXFile;
import org.xbup.lib.catalog.entity.XBEXHDoc;
import org.xbup.lib.catalog.entity.XBEXLanguage;
import org.xbup.lib.catalog.entity.service.XBEXFileService;
import org.xbup.lib.catalog.entity.service.XBEXHDocService;

/**
 * XBManager Catalog Item Edit Documentation Panel.
 *
 * @version 0.1.23 2013/09/22
 * @author XBUP Project (http://xbup.org)
 */
public class CatalogItemEditDocumentationPanel extends javax.swing.JPanel {

    private XBACatalog catalog;
    private XBCItem catalogItem;
    private XBCXHDocService hDocService;
    private XBCXHDoc itemHDoc;
    private long hdocPreviousState = 0;

    /**
     * Creates new form CatalogItemEditDocumentationPanel
     */
    public CatalogItemEditDocumentationPanel() {
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

        includeDocumentationCheckBox = new javax.swing.JCheckBox();
        hdocTabbedPane = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemHDocEditorPane = new javax.swing.JEditorPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        itemHDocSourceTextPane = new javax.swing.JTextPane();

        includeDocumentationCheckBox.setSelected(true);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/xbup/tool/xbeditor/module/xbservicemanager/catalog/panel/resources/CatalogItemEditDocumentationPanel"); // NOI18N
        includeDocumentationCheckBox.setText(bundle.getString("CatalogItemEditDocumentationDialog.includeDocumentationCheckBox.text")); // NOI18N
        includeDocumentationCheckBox.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                includeDocumentationCheckBoxStateChanged(evt);
            }
        });

        hdocTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                hdocTabbedPaneStateChanged(evt);
            }
        });

        itemHDocEditorPane.setContentType("text/html"); // NOI18N
        jScrollPane1.setViewportView(itemHDocEditorPane);

        hdocTabbedPane.addTab("HTML", jScrollPane1);

        jScrollPane3.setViewportView(itemHDocSourceTextPane);

        hdocTabbedPane.addTab("Source", jScrollPane3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hdocTabbedPane)
            .addComponent(includeDocumentationCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(includeDocumentationCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hdocTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void includeDocumentationCheckBoxStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_includeDocumentationCheckBoxStateChanged
        itemHDocEditorPane.setEnabled(includeDocumentationCheckBox.isSelected());
        itemHDocSourceTextPane.setEnabled(includeDocumentationCheckBox.isSelected());
    }//GEN-LAST:event_includeDocumentationCheckBoxStateChanged

    private void hdocTabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_hdocTabbedPaneStateChanged
        if (hdocTabbedPane.getSelectedIndex() != hdocPreviousState) {
            hdocPreviousState = hdocTabbedPane.getSelectedIndex();
            if (hdocPreviousState == 0) {
                try {
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    itemHDocSourceTextPane.write(new OutputStreamWriter(outputStream));
                    itemHDocEditorPane.read(new ByteArrayInputStream(outputStream.toByteArray()), null);
                } catch (IOException ex) {
                    Logger.getLogger(CatalogItemPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

                    HTMLEditorKit kit = new HTMLEditorKit();
                    kit.write(outputStream, itemHDocEditorPane.getDocument(), 0, itemHDocEditorPane.getDocument().getLength());
                    byte[] data = outputStream.toByteArray();
                    itemHDocSourceTextPane.read(new ByteArrayInputStream(data), null);
                } catch (IOException ex) {
                    Logger.getLogger(CatalogItemPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (BadLocationException ex) {
                    Logger.getLogger(CatalogItemPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_hdocTabbedPaneStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane hdocTabbedPane;
    private javax.swing.JCheckBox includeDocumentationCheckBox;
    private javax.swing.JEditorPane itemHDocEditorPane;
    private javax.swing.JTextPane itemHDocSourceTextPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables

    public void persist() {
        XBCXLangService langService = (XBCXLangService) catalog.getCatalogService(XBCXLangService.class);
        XBCXStriService striService = (XBCXStriService) catalog.getCatalogService(XBCXStriService.class);
        XBCXLanguage defaultLanguage = langService.getDefaultLang();
        XBCXStri stringId = striService.getItemStringId(catalogItem);
        String itemPath = stringId == null ? "" : stringId.getText();

        XBCXFileService fileService = (XBCXFileService)catalog.getCatalogService(XBCXFileService.class);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            if (hdocPreviousState == 0) {
                itemHDocEditorPane.write(new OutputStreamWriter(outputStream));
            } else {
                itemHDocSourceTextPane.write(new OutputStreamWriter(outputStream));
            }
        } catch (IOException ex) {
            Logger.getLogger(CatalogItemPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (includeDocumentationCheckBox.isSelected()) {
            itemHDoc = hDocService.getDocumentation(catalogItem);
            XBCXFile itemHDocFile = null;
            if (itemHDoc != null) {
                itemHDocFile = itemHDoc.getDocFile();
            }

            if (outputStream.size() > 0) {
                if (itemHDoc == null) {
                    itemHDoc = (XBCXHDoc) hDocService.createItem();
                    if (itemHDoc instanceof XBEXHDoc) {
                        ((XBEXHDoc) itemHDoc).setLang((XBEXLanguage) defaultLanguage);
                        ((XBEXHDoc) itemHDoc).setItem((XBEItem) catalogItem);
                        itemHDocFile = (XBCXFile) fileService.createItem();
                        ((XBEXFile) itemHDocFile).setFilename("hdoc-" + itemPath);
                        ((XBEXFile) itemHDocFile).setNode((XBENode) catalogItem.getParent());
                        ((XBEXHDoc) itemHDoc).setDocFile((XBEXFile) itemHDocFile);

                        ((XBEXFileService) fileService).persistItem((XBEXFile) itemHDocFile);
                        ((XBEXHDocService) hDocService).persistItem((XBEXHDoc) itemHDoc);
                    }
                }

                if ((itemHDocFile != null)&&(itemHDocFile instanceof XBEXFile)) {
                    ByteArrayOutputStream contentOutputStream = new ByteArrayOutputStream();
                    OutputStream fileOutputStream = ((XBEXFileService) fileService).setFile(itemHDocFile);
                    try {
                        itemHDocSourceTextPane.write(new OutputStreamWriter(fileOutputStream));
                        itemHDocSourceTextPane.write(new OutputStreamWriter(contentOutputStream));
                        fileOutputStream.close();
                        fileOutputStream.flush();
                        contentOutputStream.close();
                        contentOutputStream.flush();
                        ((XBEXFile) itemHDocFile).setContent(contentOutputStream.toByteArray());
                        ((XBEXFileService) fileService).persistItem((XBEXFile) itemHDocFile);
                    } catch (IOException ex) {
                        Logger.getLogger(CatalogItemPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else {
            // TODO Remove hdoc
        }
    }

    public void setCatalogItem(XBCItem catalogItem) {
        this.catalogItem = catalogItem;

        XBCXFileService fileService = (XBCXFileService) catalog.getCatalogService(XBCXFileService.class);
        itemHDoc = hDocService.getDocumentation(catalogItem);
        includeDocumentationCheckBox.setSelected(itemHDoc != null);
        if (itemHDoc != null) {
            XBCXFile itemHDocFile = itemHDoc.getDocFile();
            InputStream fileStream = fileService.getFile(itemHDocFile);
            try {
                itemHDocEditorPane.getEditorKit().createDefaultDocument();
                itemHDocEditorPane.read(fileStream, itemHDocEditorPane.getDocument());
            } catch (RuntimeException ex) {
                // TODO: Properly handle loading exceptions
            } catch (IOException ex) {
                Logger.getLogger(CatalogItemPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            fileStream = fileService.getFile(itemHDocFile);
            try {
                itemHDocSourceTextPane.read(fileStream, null);
            } catch (IOException ex) {
                Logger.getLogger(CatalogItemPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            itemHDocEditorPane.setText("");
            itemHDocSourceTextPane.setText("");
        }
    }

    public XBCItem getCatalogItem() {
        return catalogItem;
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
        hDocService = (XBCXHDocService) catalog.getCatalogService(XBCXHDocService.class);
    }
}

