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
package org.exbin.framework.gui.service.catalog.dialog;

import com.lightdev.app.shtm.DefaultTextResources;
import com.lightdev.app.shtm.SHTMLPanel;
import com.lightdev.app.shtm.SHTMLPanelImpl;
import com.lightdev.app.shtm.TextResources;
import com.lightdev.app.shtm.Util;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import org.exbin.xbup.core.catalog.XBACatalog;
import org.exbin.framework.gui.utils.WindowUtils;

/**
 * XBManager catalog specification selection dialog.
 *
 * @version 0.2.0 2016/01/02
 * @author ExBin Project (http://exbin.org)
 */
public class CatalogEditDocumentationDialog extends javax.swing.JDialog {

    private int dialogOption = JOptionPane.CLOSED_OPTION;
    private String documentation;
    private final SHTMLPanel mainPanel;

    public CatalogEditDocumentationDialog(java.awt.Frame parent, boolean modal, XBACatalog catalog, String documentation) {
        super(parent, modal);
        this.documentation = documentation;
        initComponents();

        SHTMLPanelImpl.setTextResources(createResources());
        SHTMLPanel.getResources();
        mainPanel = SHTMLPanel.createSHTMLPanel();
        mainPanel.setOpenHyperlinkHandler(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
                if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                    try {
                        java.net.URI uri = new java.net.URI(e.getActionCommand());
                        desktop.browse(uri);
                    } catch (IOException | URISyntaxException ex) {
                        Util.errMsg((Component) e.getSource(), ex.getMessage(), ex);
                    }
                }
            }
        });

        mainPanel.setCurrentDocumentContent(documentation);
        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        init();
    }

    private void init() {
        WindowUtils.initWindow(this);
        WindowUtils.assignGlobalKeyListener(this, okButton, cancelButton);
    }

    private static TextResources createResources() {
        try {
            final String propsLoc = "org/exbin/framework/gui/service/catalog/dialog/resources/SimplyHTML.properties";
            final URL defaultPropsURL = ClassLoader.getSystemResource(propsLoc);
            final Properties props = new Properties();
            try (InputStream in = defaultPropsURL.openStream()) {
                props.load(in);
            }
            final ResourceBundle resourceBundle = ResourceBundle.getBundle(
                    "com.lightdev.app.shtm.resources.SimplyHTML", Locale.getDefault());
            return new DefaultTextResources(resourceBundle, props);
        } catch (final Exception ex) {
            Util.errMsg(null, "resources not found", ex);
            return null;
        }
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

        controlPanel = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Documentation Editor");

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        okButton.setText("Set");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Remove Documentation");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(removeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
                .addComponent(okButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelButton)
                .addContainerGap())
        );
        controlPanelLayout.setVerticalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton)
                    .addComponent(removeButton))
                .addContainerGap())
        );

        getContentPane().add(controlPanel, java.awt.BorderLayout.PAGE_END);

        setSize(new java.awt.Dimension(646, 462));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dialogOption = JOptionPane.CANCEL_OPTION;
        WindowUtils.closeWindow(this);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        dialogOption = JOptionPane.OK_OPTION;
        WindowUtils.closeWindow(this);
        documentation = mainPanel.getDocumentText();
    }//GEN-LAST:event_okButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        documentation = "";
        dialogOption = JOptionPane.OK_OPTION;
        WindowUtils.closeWindow(this);
    }//GEN-LAST:event_removeButtonActionPerformed

    public String getDocumentation() {
        return documentation;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        WindowUtils.invokeWindow(new CatalogEditDocumentationDialog(new javax.swing.JFrame(), true, null, null));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JButton okButton;
    private javax.swing.JButton removeButton;
    // End of variables declaration//GEN-END:variables
}
