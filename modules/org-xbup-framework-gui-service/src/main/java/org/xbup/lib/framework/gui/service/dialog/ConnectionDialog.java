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
package org.xbup.lib.framework.gui.service.dialog;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.io.IOException;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javax.persistence.Persistence;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.xbup.lib.framework.gui.service.XBDbServiceClient;
import org.xbup.lib.client.XBCatalogNetServiceClient;
import org.xbup.lib.client.XBCatalogServiceClient;
import org.xbup.lib.framework.gui.utils.WindowUtils;

/**
 * XBManager connection / login dialog.
 *
 * @version 0.2.0 2016/02/19
 * @author ExBin Project (http://exbin.org)
 */
public class ConnectionDialog extends javax.swing.JDialog {

    private XBCatalogServiceClient service;

    private static final String PREFERENCES_PREFIX = "catalogConnection";

    public ConnectionDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        service = null;
        init();
    }

    private void init() {
        WindowUtils.initWindow(this);
        WindowUtils.assignGlobalKeyListener(this, okButton, cancelButton);
    }

    public void setConnectionStatus(Color color, String status, String statusLabel) {
        statusTextLabel.setText(status);
        statusIndicatorPanel.setBackground(color);
        if (statusLabel == null) {
            ((CardLayout) connectionStatusPanel.getLayout()).show(connectionStatusPanel, "default");
        } else {
            busyProgressBar.setString(statusLabel);
            ((CardLayout) connectionStatusPanel.getLayout()).show(connectionStatusPanel, "busy");
        }
    }

    public XBCatalogServiceClient getService() {
        return service;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        accessTypeButtonGroup = new javax.swing.ButtonGroup();
        connectionHeaderPanel = new javax.swing.JPanel();
        prereleaseWarningLabel = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        serviceLabel = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        logoImageLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        connectionLoginPanel = new javax.swing.JPanel();
        loginPanel = new javax.swing.JPanel();
        usernameLabel = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        connectionPointLabel = new javax.swing.JLabel();
        connectionComboBox = new javax.swing.JComboBox();
        connectionManageButton = new javax.swing.JButton();
        anonymousRadioButton = new javax.swing.JRadioButton();
        loginRadioButton = new javax.swing.JRadioButton();
        devDbLocalButton = new javax.swing.JButton();
        devDbCatalogButton = new javax.swing.JButton();
        devDbCatalogDevButton = new javax.swing.JButton();
        statusPanel = new javax.swing.JPanel();
        connectionStatusPanel = new javax.swing.JPanel();
        defaultPanel = new javax.swing.JPanel();
        statusModeLabel = new javax.swing.JLabel();
        busyStatusPanel = new javax.swing.JPanel();
        busyProgressBar = new javax.swing.JProgressBar();
        statusIndicatorPanel = new javax.swing.JPanel();
        statusTextLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/xbup/lib/framework/gui/service/dialog/resources/ConnectionDialog"); // NOI18N
        setTitle(bundle.getString("title")); // NOI18N

        connectionHeaderPanel.setBackground(new java.awt.Color(255, 255, 255));

        prereleaseWarningLabel.setText(bundle.getString("prereleaseWarningLabel.text")); // NOI18N

        jLayeredPane1.setBackground(new java.awt.Color(204, 255, 204));
        jLayeredPane1.setOpaque(true);

        serviceLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        serviceLabel.setText(bundle.getString("serviceLabel.text")); // NOI18N
        jLayeredPane1.add(serviceLabel);
        serviceLabel.setBounds(100, 0, 480, 43);

        logoImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/xbup/lib/framework/gui/service/resources/images/xbup_maskot4_small.png"))); // NOI18N
        jLayeredPane2.add(logoImageLabel);
        logoImageLabel.setBounds(20, 0, 50, 80);

        org.jdesktop.layout.GroupLayout connectionHeaderPanelLayout = new org.jdesktop.layout.GroupLayout(connectionHeaderPanel);
        connectionHeaderPanel.setLayout(connectionHeaderPanelLayout);
        connectionHeaderPanelLayout.setHorizontalGroup(
            connectionHeaderPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, connectionHeaderPanelLayout.createSequentialGroup()
                .add(333, 333, 333)
                .add(prereleaseWarningLabel)
                .addContainerGap(142, Short.MAX_VALUE))
            .add(connectionHeaderPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jLayeredPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE))
            .add(connectionHeaderPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jLayeredPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE))
            .add(connectionHeaderPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE))
        );
        connectionHeaderPanelLayout.setVerticalGroup(
            connectionHeaderPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(connectionHeaderPanelLayout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .add(prereleaseWarningLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(connectionHeaderPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jLayeredPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
            .add(connectionHeaderPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(connectionHeaderPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(jLayeredPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(22, Short.MAX_VALUE)))
            .add(connectionHeaderPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(org.jdesktop.layout.GroupLayout.TRAILING, connectionHeaderPanelLayout.createSequentialGroup()
                    .add(0, 82, Short.MAX_VALUE)
                    .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(connectionHeaderPanel, java.awt.BorderLayout.NORTH);

        loginPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("loginPanel.border.title"))); // NOI18N
        loginPanel.setEnabled(false);

        usernameLabel.setText(bundle.getString("usernameLabel.text")); // NOI18N
        usernameLabel.setEnabled(false);

        usernameTextField.setText("admin");
        usernameTextField.setEnabled(false);

        passwordLabel.setText(bundle.getString("passwordLabel.text")); // NOI18N
        passwordLabel.setEnabled(false);

        passwordField.setEnabled(false);

        org.jdesktop.layout.GroupLayout loginPanelLayout = new org.jdesktop.layout.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(loginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(loginPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(usernameLabel)
                    .add(usernameTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
                    .add(passwordLabel)
                    .add(passwordField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE))
                .addContainerGap())
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, loginPanelLayout.createSequentialGroup()
                .add(usernameLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(usernameTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(passwordLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(passwordField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        okButton.setText(bundle.getString("okButton.text")); // NOI18N
        okButton.setToolTipText("");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText(bundle.getString("cancelButton.text")); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        connectionPointLabel.setText(bundle.getString("connectionPointLabel.text")); // NOI18N

        connectionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "localhost:22594" }));

        connectionManageButton.setText(bundle.getString("connectionManageButton.text")); // NOI18N
        connectionManageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectionManageButtonActionPerformed(evt);
            }
        });

        accessTypeButtonGroup.add(anonymousRadioButton);
        anonymousRadioButton.setSelected(true);
        anonymousRadioButton.setText(bundle.getString("anonymousRadioButton.text")); // NOI18N
        anonymousRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anonymousRadioButtonActionPerformed(evt);
            }
        });

        accessTypeButtonGroup.add(loginRadioButton);
        loginRadioButton.setText(bundle.getString("loginRadioButton.text")); // NOI18N
        loginRadioButton.setToolTipText("");
        loginRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginRadioButtonActionPerformed(evt);
            }
        });

        devDbLocalButton.setText("DB: Local");
        devDbLocalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devDbLocalButtonActionPerformed(evt);
            }
        });

        devDbCatalogButton.setText("DB: xbcatalog");
        devDbCatalogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devDbCatalogButtonActionPerformed(evt);
            }
        });

        devDbCatalogDevButton.setText("DB: xbcatalog-dev");
        devDbCatalogDevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devDbCatalogDevButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout connectionLoginPanelLayout = new org.jdesktop.layout.GroupLayout(connectionLoginPanel);
        connectionLoginPanel.setLayout(connectionLoginPanelLayout);
        connectionLoginPanelLayout.setHorizontalGroup(
            connectionLoginPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(connectionLoginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(connectionLoginPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(anonymousRadioButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(connectionPointLabel)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, connectionLoginPanelLayout.createSequentialGroup()
                        .add(connectionComboBox, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(connectionManageButton))
                    .add(loginRadioButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, connectionLoginPanelLayout.createSequentialGroup()
                        .add(devDbLocalButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(devDbCatalogButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(devDbCatalogDevButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(cancelButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(okButton)))
                .addContainerGap())
            .add(connectionLoginPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(connectionLoginPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(loginPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        connectionLoginPanelLayout.setVerticalGroup(
            connectionLoginPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(connectionLoginPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(connectionPointLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(connectionLoginPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(connectionComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(connectionManageButton))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(anonymousRadioButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(loginRadioButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 166, Short.MAX_VALUE)
                .add(connectionLoginPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cancelButton)
                    .add(okButton)
                    .add(devDbLocalButton)
                    .add(devDbCatalogButton)
                    .add(devDbCatalogDevButton))
                .addContainerGap())
            .add(connectionLoginPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(connectionLoginPanelLayout.createSequentialGroup()
                    .add(119, 119, 119)
                    .add(loginPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        getContentPane().add(connectionLoginPanel, java.awt.BorderLayout.CENTER);

        statusPanel.setBackground(javax.swing.UIManager.getDefaults().getColor("PropSheet.setBackground"));
        statusPanel.setLayout(new java.awt.BorderLayout());

        connectionStatusPanel.setLayout(new java.awt.CardLayout());

        defaultPanel.setLayout(new java.awt.BorderLayout());
        defaultPanel.add(statusModeLabel, java.awt.BorderLayout.CENTER);

        connectionStatusPanel.add(defaultPanel, "default");

        busyProgressBar.setIndeterminate(true);
        busyProgressBar.setString("");
        busyProgressBar.setStringPainted(true);

        org.jdesktop.layout.GroupLayout busyStatusPanelLayout = new org.jdesktop.layout.GroupLayout(busyStatusPanel);
        busyStatusPanel.setLayout(busyStatusPanelLayout);
        busyStatusPanelLayout.setHorizontalGroup(
            busyStatusPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(busyProgressBar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
        );
        busyStatusPanelLayout.setVerticalGroup(
            busyStatusPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(busyProgressBar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        connectionStatusPanel.add(busyStatusPanel, "busy");

        statusPanel.add(connectionStatusPanel, java.awt.BorderLayout.CENTER);

        statusIndicatorPanel.setBackground(new java.awt.Color(153, 153, 153));

        statusTextLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        statusTextLabel.setForeground(javax.swing.UIManager.getDefaults().getColor("TabRenderer.selectedActivatedForeground"));
        statusTextLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusTextLabel.setText("Disconnected");

        org.jdesktop.layout.GroupLayout statusIndicatorPanelLayout = new org.jdesktop.layout.GroupLayout(statusIndicatorPanel);
        statusIndicatorPanel.setLayout(statusIndicatorPanelLayout);
        statusIndicatorPanelLayout.setHorizontalGroup(
            statusIndicatorPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, statusTextLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
        );
        statusIndicatorPanelLayout.setVerticalGroup(
            statusIndicatorPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(statusTextLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        statusPanel.add(statusIndicatorPanel, java.awt.BorderLayout.EAST);

        getContentPane().add(statusPanel, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        String connectionString = (String) connectionComboBox.getSelectedItem();
        String connectionHost;
        int connectionPort = 22594; // is 0x5842 (XB)
        int pos = connectionString.indexOf(":");
        if (pos >= 0) {
            connectionHost = connectionString.substring(0, pos);
            connectionPort = Integer.valueOf(connectionString.substring(pos + 1));
        } else {
            connectionHost = connectionString;
        }

        okButton.setEnabled(false);
        service = new XBCatalogNetServiceClient(connectionHost, connectionPort); // 22594 is 0x5842 (XB)
        final String connectionLabel = "Connecting to server " + connectionHost + ":" + connectionPort;
        new Thread(new Runnable() {
            @Override
            public void run() {
                setConnectionStatus(Color.ORANGE, "Connecting", connectionLabel);
                if (service != null) {
                    setConnectionStatus(Color.ORANGE, "Logging in", "Logging in...");
                    try {
                        int loginResult = service.login(usernameTextField.getText(), passwordField.getPassword());
                        if (loginResult == 0) {
                            setConnectionStatus(Color.GREEN, "Connected", null);
                            dispose();
                        } else {
                            statusModeLabel.setText("Unable to login: error " + loginResult);
                            setConnectionStatus(Color.RED, "Failed", null);
                        }
                    } catch (ConnectException ex) {
                        statusModeLabel.setText("Unable to connect: " + ex.getMessage());
                        setConnectionStatus(Color.RED, "Failed", null);
                    } catch (UnsupportedOperationException ex) {
                        Logger.getLogger(ConnectionDialog.class.getName()).log(Level.SEVERE, null, ex);
                        setConnectionStatus(Color.RED, "Failed", null);
                    } catch (Exception ex) {
                        Logger.getLogger(ConnectionDialog.class.getName()).log(Level.SEVERE, null, ex);
                        setConnectionStatus(Color.RED, "Failed", null);
                    }
                } else {
                    setConnectionStatus(Color.RED, "Disconnected", null);
                }

                okButton.setEnabled(true);
            }
        }).start();
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        WindowUtils.closeWindow(this);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void connectionManageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectionManageButtonActionPerformed
        ConnectionListDialog connectionDialog = new ConnectionListDialog((Frame) this.getParent(), true);
        List<String> connectionList = new ArrayList<>();
        int itemsCount = connectionComboBox.getItemCount();
        for (int i = 0; i < itemsCount; i++) {
            connectionList.add((String) connectionComboBox.getItemAt(i));
        }
        connectionDialog.setConnectionList(connectionList);
        connectionDialog.setLocationRelativeTo(connectionDialog.getParent());
        connectionDialog.setVisible(true);
        if (connectionDialog.getDialogOption() == JOptionPane.OK_OPTION) {
            connectionList = connectionDialog.getConnectionList();
            DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) connectionComboBox.getModel();
            comboBoxModel.removeAllElements();
            for (String connection : connectionList) {
                comboBoxModel.addElement(connection);
            }
        }
    }//GEN-LAST:event_connectionManageButtonActionPerformed

    private void anonymousRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anonymousRadioButtonActionPerformed
        setLoginAccountEnabled(false);
    }//GEN-LAST:event_anonymousRadioButtonActionPerformed

    private void loginRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginRadioButtonActionPerformed
        setLoginAccountEnabled(true);
    }//GEN-LAST:event_loginRadioButtonActionPerformed

    private void devDbLocalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devDbLocalButtonActionPerformed
        service = new XBDbServiceClient(Persistence.createEntityManagerFactory("XBManagerLocalPU"));
        try {
            service.login(usernameTextField.getText(), passwordField.getPassword());
        } catch (IOException ex) {
            Logger.getLogger(ConnectionDialog.class.getName()).log(Level.SEVERE, null, ex);
        }

        setConnectionStatus(Color.GREEN, "Connected", null);
        WindowUtils.closeWindow(this);
    }//GEN-LAST:event_devDbLocalButtonActionPerformed

    private void devDbCatalogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devDbCatalogButtonActionPerformed
        service = new XBDbServiceClient(Persistence.createEntityManagerFactory("XBManagerMySQLPU"));
        try {
            service.login(usernameTextField.getText(), passwordField.getPassword());
        } catch (IOException ex) {
            Logger.getLogger(ConnectionDialog.class.getName()).log(Level.SEVERE, null, ex);
        }

        setConnectionStatus(Color.GREEN, "Connected", null);
        WindowUtils.closeWindow(this);
    }//GEN-LAST:event_devDbCatalogButtonActionPerformed

    private void devDbCatalogDevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devDbCatalogDevButtonActionPerformed
        service = new XBDbServiceClient(Persistence.createEntityManagerFactory("XBManagerMySQLDevPU"));
        try {
            service.login(usernameTextField.getText(), passwordField.getPassword());
        } catch (IOException ex) {
            Logger.getLogger(ConnectionDialog.class.getName()).log(Level.SEVERE, null, ex);
        }

        setConnectionStatus(Color.GREEN, "Connected", null);
        WindowUtils.closeWindow(this);
    }//GEN-LAST:event_devDbCatalogDevButtonActionPerformed

    private void setLoginAccountEnabled(boolean enabled) {
        loginPanel.setEnabled(enabled);
        usernameLabel.setEnabled(enabled);
        usernameTextField.setEnabled(enabled);
        passwordLabel.setEnabled(enabled);
        passwordField.setEnabled(enabled);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        WindowUtils.invokeWindow(new ConnectionDialog(new javax.swing.JFrame(), true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup accessTypeButtonGroup;
    private javax.swing.JRadioButton anonymousRadioButton;
    private javax.swing.JProgressBar busyProgressBar;
    private javax.swing.JPanel busyStatusPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox connectionComboBox;
    private javax.swing.JPanel connectionHeaderPanel;
    private javax.swing.JPanel connectionLoginPanel;
    private javax.swing.JButton connectionManageButton;
    private javax.swing.JLabel connectionPointLabel;
    private javax.swing.JPanel connectionStatusPanel;
    private javax.swing.JPanel defaultPanel;
    private javax.swing.JButton devDbCatalogButton;
    private javax.swing.JButton devDbCatalogDevButton;
    private javax.swing.JButton devDbLocalButton;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JRadioButton loginRadioButton;
    private javax.swing.JLabel logoImageLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel prereleaseWarningLabel;
    private javax.swing.JLabel serviceLabel;
    private javax.swing.JPanel statusIndicatorPanel;
    private javax.swing.JLabel statusModeLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JLabel statusTextLabel;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables

    public List<String> getConnectionList() {
        ArrayList<String> connectionList = new ArrayList<>();
        int pos = 0;
        while (pos < connectionComboBox.getItemCount()) {
            connectionList.add((String) connectionComboBox.getItemAt(pos));
            pos++;
        }
        return connectionList;
    }

    public void setConnectionList(List<String> connectionList) {
        connectionComboBox.removeAllItems();
        for (String connection : connectionList) {
            connectionComboBox.addItem(connection);
        }
    }

    public void loadConnectionList(Preferences preferences) {
        ArrayList<String> connectionList = new ArrayList<>();
        long pos = 1;
        while (preferences.get(PREFERENCES_PREFIX + String.valueOf(pos), null) != null) {
            connectionList.add(preferences.get(PREFERENCES_PREFIX + String.valueOf(pos), ""));
            pos++;
        }

        if (connectionList.size() > 0) {
            setConnectionList(connectionList);
        }
    }

    public void saveConnectionList(Preferences preferences) {
        List<String> connectionList = getConnectionList();
        int pos = 0;
        while (pos < connectionList.size()) {
            preferences.put(PREFERENCES_PREFIX + String.valueOf(pos + 1), connectionList.get(pos));
            pos++;
        }
    }
}
