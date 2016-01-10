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
package org.xbup.tool.editor.module.text_editor.panel;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import org.xbup.lib.framework.gui.options.api.OptionsPanel;
import org.xbup.lib.framework.gui.options.api.OptionsPanel.ModifiedOptionListener;
import org.xbup.lib.framework.gui.options.api.OptionsPanel.PathItem;

/**
 * XBTEditor Color Selection panel.
 *
 * @version 0.1.22 2013/03/15
 * @author XBUP Project (http://xbup.org)
 */
public class TextColorOptionsPanel extends javax.swing.JPanel implements OptionsPanel {

    public static final String PREFERENCES_TEXT_COLOR_DEFAULT = "textColor.default";

    private ModifiedOptionListener modifiedOptionListener;
    private ResourceBundle resourceBundle;
    private TextColorPanelFrame frame;
    private TextColorPanel colorPanel;

    /** Creates new form TextColorPanel */
    public TextColorOptionsPanel(TextColorPanelFrame frame) {
        this.frame = frame;
        initComponents();
        resourceBundle = java.util.ResourceBundle.getBundle("org/xbup/tool/editor/module/text_editor/panel/resources/TextColorOptionsPanel");

        colorPanel = new TextColorPanel(frame);
        colorPanel.setEnabled(false);
        add(colorPanel, BorderLayout.CENTER);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        defaultColorPanel = new javax.swing.JPanel();
        defaultColorCheckBox = new javax.swing.JCheckBox();

        jColorChooser1.setName("jColorChooser1"); // NOI18N

        setName("Form"); // NOI18N
        setLayout(new java.awt.BorderLayout());

        defaultColorPanel.setName("defaultColorPanel"); // NOI18N

        defaultColorCheckBox.setSelected(true);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/xbup/tool/editor/module/text_editor/panel/resources/TextColorOptionsPanel"); // NOI18N
        defaultColorCheckBox.setText(bundle.getString("TextColorOptionsPanel.defaultColorCheckBox.text")); // NOI18N
        defaultColorCheckBox.setName("defaultColorCheckBox"); // NOI18N
        defaultColorCheckBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                defaultColorCheckBoxItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout defaultColorPanelLayout = new javax.swing.GroupLayout(defaultColorPanel);
        defaultColorPanel.setLayout(defaultColorPanelLayout);
        defaultColorPanelLayout.setHorizontalGroup(
            defaultColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(defaultColorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(defaultColorCheckBox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        defaultColorPanelLayout.setVerticalGroup(
            defaultColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(defaultColorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(defaultColorCheckBox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(defaultColorPanel, java.awt.BorderLayout.NORTH);
    }// </editor-fold>//GEN-END:initComponents

    private void defaultColorCheckBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_defaultColorCheckBoxItemStateChanged
        boolean checked = evt.getStateChange() != ItemEvent.SELECTED;
        colorPanel.setEnabled(checked);
        setModified(true);
    }//GEN-LAST:event_defaultColorCheckBoxItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox defaultColorCheckBox;
    private javax.swing.JPanel defaultColorPanel;
    private javax.swing.JColorChooser jColorChooser1;
    // End of variables declaration//GEN-END:variables

    @Override
    public List<OptionsPanel.PathItem> getPath() {
        ArrayList<OptionsPanel.PathItem> path = new ArrayList<OptionsPanel.PathItem>();
        path.add(new PathItem("apperance", ""));
        path.add(new PathItem("colors", resourceBundle.getString("options.Path.0")));
        return path;
    }

    @Override
    public void loadFromPreferences(Preferences preferences) {
        Boolean defaultColor = Boolean.valueOf(preferences.get(PREFERENCES_TEXT_COLOR_DEFAULT, Boolean.toString(true)));
        defaultColorCheckBox.setSelected(defaultColor);
        colorPanel.setEnabled(!defaultColor);
        colorPanel.loadFromPreferences(preferences);
    }

    @Override
    public void saveToPreferences(Preferences preferences) {
        preferences.put(PREFERENCES_TEXT_COLOR_DEFAULT, Boolean.toString(defaultColorCheckBox.isSelected()));
        colorPanel.saveToPreferences(preferences);
    }

    @Override
    public void applyPreferencesChanges() {
        if (defaultColorCheckBox.isSelected()) {
            frame.setCurrentTextColors(frame.getDefaultTextColors());
        } else {
            colorPanel.applyPreferencesChanges();
        }
    }

    private void setModified(boolean b) {
        if (modifiedOptionListener != null) {
            modifiedOptionListener.wasModified();
        }
    }

    @Override
    public void setModifiedOptionListener(ModifiedOptionListener listener) {
        modifiedOptionListener = listener;
        colorPanel.setModifiedOptionListener(listener);
    }
}
