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
package org.xbup.lib.framework.gui.options.panel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;
import org.xbup.lib.framework.gui.options.panel.OptionsPanel.ModifiedOptionListener;
import org.xbup.lib.framework.gui.options.panel.OptionsPanel.PathItem;
import org.xbup.lib.framework.gui.frame.api.XBApplicationFrameHandler;

/**
 * Tool Bar Apperance Options panel.
 *
 * @version 0.2.0 2015/11/05
 * @author XBUP Project (http://xbup.org)
 */
public class AppearanceOptionsPanel extends javax.swing.JPanel implements OptionsPanel {

    public static final String PREFERENCES_TOOLBAR_VISIBLE = "toolBar.visible";
    public static final String PREFERENCES_TOOLBAR_CAPTIONS = "toolBar.captions";
    public static final String PREFERENCES_STATUSBAR_VISIBLE = "statusBar.visible";

    private ModifiedOptionListener modifiedOptionListener;
    private final XBApplicationFrameHandler frame;
    private OptionsPanel extendedPanel = null;

    public AppearanceOptionsPanel(XBApplicationFrameHandler frame) {
        this.frame = frame;
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

        toolBarsOptionsPanel = new javax.swing.JPanel();
        showToolbarCheckBox = new javax.swing.JCheckBox();
        showCaptionsCheckBox = new javax.swing.JCheckBox();
        showStatusbarCheckBox = new javax.swing.JCheckBox();

        setLayout(new java.awt.BorderLayout());

        showToolbarCheckBox.setSelected(true);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/xbup/lib/framework/gui/options/panel/resources/AppearanceOptionsPanel"); // NOI18N
        showToolbarCheckBox.setText(bundle.getString("AppearanceOptionsPanel.showToolbarCheckBox.text")); // NOI18N
        showToolbarCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                showToolbarCheckBoxjCheckBoxItemStateChanged(evt);
            }
        });

        showCaptionsCheckBox.setSelected(true);
        showCaptionsCheckBox.setText(bundle.getString("AppearanceOptionsPanel.showCaptionsCheckBox.text")); // NOI18N
        showCaptionsCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                showCaptionsCheckBoxjCheckBoxItemStateChanged(evt);
            }
        });

        showStatusbarCheckBox.setSelected(true);
        showStatusbarCheckBox.setText(bundle.getString("AppearanceOptionsPanel.showStatusbarCheckBox.text")); // NOI18N
        showStatusbarCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                showStatusbarCheckBoxjCheckBoxItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout toolBarsOptionsPanelLayout = new javax.swing.GroupLayout(toolBarsOptionsPanel);
        toolBarsOptionsPanel.setLayout(toolBarsOptionsPanelLayout);
        toolBarsOptionsPanelLayout.setHorizontalGroup(
            toolBarsOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, toolBarsOptionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(toolBarsOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(showCaptionsCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(showStatusbarCheckBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(showToolbarCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        toolBarsOptionsPanelLayout.setVerticalGroup(
            toolBarsOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toolBarsOptionsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(showToolbarCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showCaptionsCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showStatusbarCheckBox))
        );

        add(toolBarsOptionsPanel, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents

    private void showToolbarCheckBoxjCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_showToolbarCheckBoxjCheckBoxItemStateChanged
        setModified(true);
    }//GEN-LAST:event_showToolbarCheckBoxjCheckBoxItemStateChanged

    private void showCaptionsCheckBoxjCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_showCaptionsCheckBoxjCheckBoxItemStateChanged
        setModified(true);
    }//GEN-LAST:event_showCaptionsCheckBoxjCheckBoxItemStateChanged

    private void showStatusbarCheckBoxjCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_showStatusbarCheckBoxjCheckBoxItemStateChanged
        setModified(true);
    }//GEN-LAST:event_showStatusbarCheckBoxjCheckBoxItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox showCaptionsCheckBox;
    private javax.swing.JCheckBox showStatusbarCheckBox;
    private javax.swing.JCheckBox showToolbarCheckBox;
    private javax.swing.JPanel toolBarsOptionsPanel;
    // End of variables declaration//GEN-END:variables

    private void setModified(boolean b) {
        if (modifiedOptionListener != null) {
            modifiedOptionListener.wasModified();
        }
    }

    @Override
    public List<PathItem> getPath() {
        ArrayList<OptionsPanel.PathItem> path = new ArrayList<>();
        path.add(new PathItem("apperance", ""));
        return path;
    }

    @Override
    public void applyPreferencesChanges() {
        if (extendedPanel != null) {
            extendedPanel.applyPreferencesChanges();
        }

        frame.setToolBarsVisibility(showToolbarCheckBox.isSelected(), showCaptionsCheckBox.isSelected(), showStatusbarCheckBox.isSelected());
    }

    @Override
    public void loadFromPreferences(Preferences preferences) {
        if (extendedPanel != null) {
            extendedPanel.loadFromPreferences(preferences);
        }

        showToolbarCheckBox.setSelected(Boolean.valueOf(preferences.get(PREFERENCES_TOOLBAR_VISIBLE, Boolean.toString(true))));
        showCaptionsCheckBox.setSelected(Boolean.valueOf(preferences.get(PREFERENCES_TOOLBAR_CAPTIONS, Boolean.toString(true))));
        showStatusbarCheckBox.setSelected(Boolean.valueOf(preferences.get(PREFERENCES_STATUSBAR_VISIBLE, Boolean.toString(true))));
    }

    @Override
    public void saveToPreferences(Preferences preferences) {
        if (extendedPanel != null) {
            extendedPanel.saveToPreferences(preferences);
        }

        preferences.put(PREFERENCES_TOOLBAR_VISIBLE, Boolean.toString(showToolbarCheckBox.isSelected()));
        preferences.put(PREFERENCES_TOOLBAR_CAPTIONS, Boolean.toString(showCaptionsCheckBox.isSelected()));
        preferences.put(PREFERENCES_STATUSBAR_VISIBLE, Boolean.toString(showStatusbarCheckBox.isSelected()));
    }

    @Override
    public void setModifiedOptionListener(ModifiedOptionListener listener) {
        modifiedOptionListener = listener;
    }

    public void addExtendedPanel(OptionsPanel panel) {
        if (extendedPanel != null) {
            remove((Component) extendedPanel);
        }
        extendedPanel = panel;
        add((Component) panel, BorderLayout.CENTER);
        extendedPanel.setModifiedOptionListener(modifiedOptionListener);
    }
}
