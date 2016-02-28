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
package org.xbup.lib.framework.gui.service.catalog.panel;

import org.xbup.lib.core.catalog.XBACatalog;
import org.xbup.lib.core.catalog.base.XBCItem;
import org.xbup.lib.core.catalog.base.service.XBCXDescService;
import org.xbup.lib.core.catalog.base.service.XBCXHDocService;
import org.xbup.lib.core.catalog.base.service.XBCXNameService;
import org.xbup.lib.core.catalog.base.service.XBCXStriService;

/**
 * Compact information about catalog item Panel.
 *
 * @version 0.1.24 2015/01/31
 * @author ExBin Project (http://exbin.org)
 */
public class CatalogItemInfoPanel extends javax.swing.JPanel {

    private XBACatalog catalog;

    public CatalogItemInfoPanel() {
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

        mainScrollPane = new javax.swing.JScrollPane();
        mainEditorPane = new javax.swing.JEditorPane();

        setLayout(new java.awt.BorderLayout());

        mainEditorPane.setEditable(false);
        mainEditorPane.setContentType("text/html"); // NOI18N
        mainEditorPane.setText("<html>\n  <head>\n\n  </head>\n  <body>\n    <p style=\"margin-top: 0\">\n      No catalog item was selected.\n    </p>\n  </body>\n</html>\n");
        mainScrollPane.setViewportView(mainEditorPane);

        add(mainScrollPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane mainEditorPane;
    private javax.swing.JScrollPane mainScrollPane;
    // End of variables declaration//GEN-END:variables

    public void setItem(XBCItem item) {
        XBCXNameService nameService = (XBCXNameService) catalog.getCatalogService(XBCXNameService.class);
        XBCXDescService descService = (XBCXDescService) catalog.getCatalogService(XBCXDescService.class);
        XBCXStriService striService = (XBCXStriService) catalog.getCatalogService(XBCXStriService.class);
        XBCXHDocService hdocService = (XBCXHDocService) catalog.getCatalogService(XBCXHDocService.class);

        String nameOrId = nameService.getDefaultText(item);
        if (nameOrId == null || nameOrId.isEmpty()) {
            nameOrId = String.valueOf(item.getId());
        }

        String stringId = striService.getItemStringIdText(item);
        String name = nameService.getDefaultText(item);
        String desc = descService.getDefaultText(item);
        String hdoc = hdocService.getDocumentationBodyText(item);

        StringBuilder builder = new StringBuilder();
        builder.append("<html><head></head><body>");
        builder.append("\n");
        builder.append("<h1>Block: ").append(nameOrId).append("</h1>");
        builder.append("\n");
        builder.append("Id : ").append(String.valueOf(item.getId())).append("<br/>");
        builder.append("\n");
        builder.append("String Id : ").append(stringId).append("<br/>");
        builder.append("\n");
        builder.append("Name : ").append(name).append("<br/>");
        builder.append("\n");
        builder.append("Description : ").append(desc).append("<br/>");
        builder.append("\n");
        builder.append("TBD<br/>");
        builder.append("\n");
        if (hdoc != null && !hdoc.isEmpty()) {
            builder.append("<h2>Documentation</h2>");
            builder.append("\n");
            builder.append(hdoc);
            builder.append("\n");
        }
        builder.append("</body></html>");
        builder.append("\n");
        mainEditorPane.setText(builder.toString());
    }

    public XBACatalog getCatalog() {
        return catalog;
    }

    public void setCatalog(XBACatalog catalog) {
        this.catalog = catalog;
    }
}
