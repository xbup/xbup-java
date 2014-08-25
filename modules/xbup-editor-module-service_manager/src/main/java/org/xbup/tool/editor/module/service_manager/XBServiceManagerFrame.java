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
package org.xbup.tool.editor.module.service_manager;

import java.awt.Color;
import java.util.Arrays;
import java.util.prefs.Preferences;
import javax.swing.JMenuItem;
import org.xbup.tool.editor.module.service_manager.dialog.ConnectionDialog;
import org.xbup.tool.editor.module.service_manager.panel.ServiceManagerPanel;
import org.xbup.tool.editor.base.api.MainFrameManagement;
import org.xbup.tool.editor.base.api.XBEditorFrame;

/**
 * Manager Main Window.
 *
 * @version 0.1.23 2013/09/14
 * @author XBUP Project (http://xbup.org)
 */
public class XBServiceManagerFrame extends javax.swing.JFrame implements XBEditorFrame {

    private final String DIALOG_MENU_SUFIX = "...";
    private ServiceManagerPanel activePanel = null;
    private static Preferences preferences = Preferences.userNodeForPackage(XBServiceManagerFrame.class);
    private MainFrameManagement mainFrameManagement;

    /** Creates new form XBServiceManagerFrame */
    public XBServiceManagerFrame() {
        initComponents();
        activePanel = new ServiceManagerPanel();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        statusPanel = new javax.swing.JPanel();
        textStatusPanel = new javax.swing.JPanel();
        textStatusLabel = new javax.swing.JLabel();
        textStatusStateLabel = new javax.swing.JLabel();
        emptyStatusPanel = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        serviceMenu = new javax.swing.JMenu();
        connectMenuItem = new javax.swing.JMenuItem();
        disconnectMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setName("mainPanel"); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 574, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 441, Short.MAX_VALUE)
        );

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        statusPanel.setName("statusPanel"); // NOI18N
        statusPanel.setLayout(new java.awt.CardLayout());

        textStatusPanel.setName("textStatusPanel"); // NOI18N

        textStatusLabel.setName("textStatusLabel"); // NOI18N

        textStatusStateLabel.setBackground(new java.awt.Color(255, 0, 0));
        textStatusStateLabel.setFont(new java.awt.Font("Tahoma 11", 1, 12)); // NOI18N
        textStatusStateLabel.setForeground(new java.awt.Color(0, 0, 0));
        textStatusStateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textStatusStateLabel.setText("Disconnected");
        textStatusStateLabel.setName("textStatusStateLabel"); // NOI18N
        textStatusStateLabel.setOpaque(true);

        javax.swing.GroupLayout textStatusPanelLayout = new javax.swing.GroupLayout(textStatusPanel);
        textStatusPanel.setLayout(textStatusPanelLayout);
        textStatusPanelLayout.setHorizontalGroup(
            textStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, textStatusPanelLayout.createSequentialGroup()
                .addComponent(textStatusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(textStatusStateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        textStatusPanelLayout.setVerticalGroup(
            textStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textStatusStateLabel)
            .addComponent(textStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        statusPanel.add(textStatusPanel, "card3");

        emptyStatusPanel.setName("emptyStatusPanel"); // NOI18N

        javax.swing.GroupLayout emptyStatusPanelLayout = new javax.swing.GroupLayout(emptyStatusPanel);
        emptyStatusPanel.setLayout(emptyStatusPanelLayout);
        emptyStatusPanelLayout.setHorizontalGroup(
            emptyStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 574, Short.MAX_VALUE)
        );
        emptyStatusPanelLayout.setVerticalGroup(
            emptyStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        statusPanel.add(emptyStatusPanel, "card2");

        getContentPane().add(statusPanel, java.awt.BorderLayout.SOUTH);

        menuBar.setName("menuBar"); // NOI18N

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/xbup/tool/xbeditor/module/xbservicemanager/resources/XBServiceManagerFrame"); // NOI18N
        serviceMenu.setText(bundle.getString("serviceMenu.text")); // NOI18N
        serviceMenu.setName("serviceMenu"); // NOI18N

        connectMenuItem.setText(bundle.getString("actionConnect.Action.text")); // NOI18N
        connectMenuItem.setToolTipText(bundle.getString("actionConnect.Action.shortDescription")); // NOI18N
        connectMenuItem.setName("connectMenuItem"); // NOI18N
        connectMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectMenuItemActionPerformed(evt);
            }
        });
        serviceMenu.add(connectMenuItem);

        disconnectMenuItem.setText(bundle.getString("actionDisconnect.Action.text")); // NOI18N
        disconnectMenuItem.setToolTipText(bundle.getString("actionDisconnect.Action.shortDescription")); // NOI18N
        disconnectMenuItem.setName("disconnectMenuItem"); // NOI18N
        disconnectMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectMenuItemActionPerformed(evt);
            }
        });
        serviceMenu.add(disconnectMenuItem);

        jSeparator1.setName("jSeparator1"); // NOI18N
        serviceMenu.add(jSeparator1);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        exitMenuItem.setText(bundle.getString("actionExit.Action.text")); // NOI18N
        exitMenuItem.setToolTipText(bundle.getString("actionToolsOptions.Action.shortDescription")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        serviceMenu.add(exitMenuItem);

        menuBar.add(serviceMenu);

        for (JMenuItem item : Arrays.asList(connectMenuItem, disconnectMenuItem)) {
            item.setText(item.getText()+DIALOG_MENU_SUFIX);
        }

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void connectMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectMenuItemActionPerformed
        actionConnect();
    }//GEN-LAST:event_connectMenuItemActionPerformed

    private void disconnectMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectMenuItemActionPerformed
        actionDisconnect();
    }//GEN-LAST:event_disconnectMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(XBServiceManagerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(XBServiceManagerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(XBServiceManagerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(XBServiceManagerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new XBServiceManagerFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem connectMenuItem;
    private javax.swing.JMenuItem disconnectMenuItem;
    private javax.swing.JPanel emptyStatusPanel;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    public javax.swing.JMenu serviceMenu;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JLabel textStatusLabel;
    private javax.swing.JPanel textStatusPanel;
    private javax.swing.JLabel textStatusStateLabel;
    // End of variables declaration//GEN-END:variables

    public void setStatus(Color color, String status) {
        textStatusStateLabel.setBackground(color);
        textStatusStateLabel.setText(status);
    }

    /**
     * @return the statusPanel
     */
    public javax.swing.JPanel getStatusPanel() {
        return statusPanel;
    }

    /**
     * @return the activePanel
     */
    public ServiceManagerPanel getActivePanel() {
        return activePanel;
    }

    public void actionExit() {
        // TODO
        dispose();
    }

    public void actionConnect() {
        ConnectionDialog loginDialog = new ConnectionDialog(this, true);
        loginDialog.setLocationRelativeTo(loginDialog.getParent());
        loginDialog.loadConnectionList(preferences);
        loginDialog.setVisible(true);
        loginDialog.saveConnectionList(preferences);
        activePanel.setService(loginDialog.getService());
    }

    public void actionDisconnect() {
        activePanel.setService(null);
    }

    public boolean isConnected() {
        return false;
    }

    @Override
    public MainFrameManagement getMainFrameManagement() {
        return mainFrameManagement;
    }

    void setMainFrameManagement(MainFrameManagement mainFrameManagement) {
        this.mainFrameManagement = mainFrameManagement;
    }
}
