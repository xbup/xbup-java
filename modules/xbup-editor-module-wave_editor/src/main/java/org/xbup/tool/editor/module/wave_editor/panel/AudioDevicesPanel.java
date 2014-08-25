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
package org.xbup.tool.editor.module.wave_editor.panel;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Control;
import javax.sound.sampled.Line;
import javax.sound.sampled.Mixer;
import org.xbup.tool.editor.base.api.OptionsPanel;

/**
 * Panel for choosing input and output audio devices.
 *
 * @version 0.1.22 2013/09/01
 * @author XBUP Project (http://xbup.org)
 */
public class AudioDevicesPanel extends javax.swing.JPanel implements OptionsPanel {

    private ResourceBundle resourceBundle;

    /** Creates new form AudioDevicesPanel */
    @SuppressWarnings("unchecked")
    public AudioDevicesPanel() {
        resourceBundle = java.util.ResourceBundle.getBundle("org/xbup/tool/xbeditor/module/xbwaveeditor/panel/resources/AudioDevicesPanel");
        initComponents();

        // loop through all mixers, and all source and target lines within each mixer.
        Mixer.Info[] mis = AudioSystem.getMixerInfo();
        for (Mixer.Info mi : mis) {
            Mixer mixer = AudioSystem.getMixer(mi);
            // e.g. com.sun.media.sound.DirectAudioDevice
//            System.out.println("mixer: " + mixer.getClass().getName());
            Line.Info[] lis = mixer.getSourceLineInfo();
            for (Line.Info li : lis) {
//                System.out.println("    source line: " + li.toString());
//                showFormats(li);
            }
            lis = mixer.getTargetLineInfo();
            outputSoundDeviceComboBox.addItem(mixer.getMixerInfo().getName());
            for (Line.Info li : lis) {
                Mixer.Info mixerInfo = mixer.getMixerInfo();
//                System.out.println("    target line: " + li.toString());
/*                if (mixer instanceof DirectAudioDevice) {
                    jComboBox4.addItem(mixer.getMixerInfo().getName());
                } else { */
//                    jComboBox4.addItem(mixer.getMixerInfo().getName() + " (" + li.toString() + ")");
//                }
//                showFormats(li);
            }
            Control[] cs = mixer.getControls();
            for (Control c : cs) {
                System.out.println("    control: " + c.toString());
            }
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        audioOutputPanel = new javax.swing.JPanel();
        outputSoundDeviceLabel = new javax.swing.JLabel();
        outputSampleRateLabel = new javax.swing.JLabel();
        outputBufferSizejLabel = new javax.swing.JLabel();
        outputSoundDeviceComboBox = new javax.swing.JComboBox();
        outputSampleRateComboBox = new javax.swing.JComboBox();
        outputBufferSizeComboBox = new javax.swing.JComboBox();
        testAudioButton = new javax.swing.JButton();

        setAutoscrolls(true);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/xbup/tool/xbeditor/module/xbwaveeditor/panel/resources/AudioDevicesPanel"); // NOI18N
        audioOutputPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("audioOutputPanel.border.title"))); // NOI18N
        audioOutputPanel.setName("audioOutputPanel"); // NOI18N

        outputSoundDeviceLabel.setText(bundle.getString("outputSoundDeviceLabel.text")); // NOI18N
        outputSoundDeviceLabel.setName("outputSoundDeviceLabel"); // NOI18N

        outputSampleRateLabel.setText(bundle.getString("outputSampleRateLabel.text")); // NOI18N
        outputSampleRateLabel.setName("outputSampleRateLabel"); // NOI18N

        outputBufferSizejLabel.setText(bundle.getString("outputBufferSizejLabel.text")); // NOI18N
        outputBufferSizejLabel.setName("outputBufferSizejLabel"); // NOI18N

        outputSoundDeviceComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<default>" }));
        outputSoundDeviceComboBox.setName("outputSoundDeviceComboBox"); // NOI18N

        outputSampleRateComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<default>" }));
        outputSampleRateComboBox.setName("outputSampleRateComboBox"); // NOI18N

        outputBufferSizeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<default>" }));
        outputBufferSizeComboBox.setName("outputBufferSizeComboBox"); // NOI18N

        testAudioButton.setText(bundle.getString("testAudioButton.text")); // NOI18N
        testAudioButton.setName("testAudioButton"); // NOI18N

        javax.swing.GroupLayout audioOutputPanelLayout = new javax.swing.GroupLayout(audioOutputPanel);
        audioOutputPanel.setLayout(audioOutputPanelLayout);
        audioOutputPanelLayout.setHorizontalGroup(
            audioOutputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(audioOutputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(audioOutputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(audioOutputPanelLayout.createSequentialGroup()
                        .addGroup(audioOutputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(outputSoundDeviceLabel)
                            .addComponent(outputSampleRateLabel)
                            .addComponent(outputBufferSizejLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(audioOutputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(outputSampleRateComboBox, 0, 347, Short.MAX_VALUE)
                            .addComponent(outputSoundDeviceComboBox, 0, 347, Short.MAX_VALUE)
                            .addComponent(outputBufferSizeComboBox, 0, 347, Short.MAX_VALUE)))
                    .addComponent(testAudioButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        audioOutputPanelLayout.setVerticalGroup(
            audioOutputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(audioOutputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(audioOutputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(outputSoundDeviceLabel)
                    .addComponent(outputSoundDeviceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(audioOutputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(outputSampleRateLabel)
                    .addComponent(outputSampleRateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(audioOutputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(outputBufferSizejLabel)
                    .addComponent(outputBufferSizeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(testAudioButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(audioOutputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(audioOutputPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel audioOutputPanel;
    public javax.swing.JComboBox outputBufferSizeComboBox;
    public javax.swing.JLabel outputBufferSizejLabel;
    public javax.swing.JComboBox outputSampleRateComboBox;
    public javax.swing.JLabel outputSampleRateLabel;
    public javax.swing.JComboBox outputSoundDeviceComboBox;
    public javax.swing.JLabel outputSoundDeviceLabel;
    public javax.swing.JButton testAudioButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public List<OptionsPanel.PathItem> getPath() {
        ArrayList<OptionsPanel.PathItem> path = new ArrayList<OptionsPanel.PathItem>();
        path.add(new PathItem("audio", resourceBundle.getString("options.Path.0")));
        return path;
    }

    @Override
    public void loadFromPreferences(Preferences preferences) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void saveToPreferences(Preferences preferences) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void applyPreferencesChanges() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setModifiedOptionListener(ModifiedOptionListener listener) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
