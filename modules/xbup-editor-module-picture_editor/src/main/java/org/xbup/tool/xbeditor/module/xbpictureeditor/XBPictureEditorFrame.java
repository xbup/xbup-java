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
package org.xbup.tool.xbeditor.module.xbpictureeditor;

import java.awt.CardLayout;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.util.Arrays;
import java.util.ResourceBundle;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.filechooser.FileFilter;
import org.xbup.tool.xbeditor.module.xbpictureeditor.dialog.ImageResizeDialog;
import org.xbup.tool.xbeditor.module.xbpictureeditor.dialog.PropertiesDialog;
import org.xbup.tool.xbeditor.module.xbpictureeditor.dialog.ToolColorDialog;
import org.xbup.tool.xbeditor.module.xbpictureeditor.panel.ImagePanel;
import org.xbup.tool.xbeditorbase.base.api.FileType;

/**
 * XBPictureEditor Main Frame.
 *
 * @version 0.1 wr22.0 2013/03/24
 * @author XBUP Project (http://xbup.org)
 */
public class XBPictureEditorFrame extends javax.swing.JFrame {

    public ImagePanel activePanel;
    private MouseMotionListener mouseMotionListener;
    private final String DIALOG_MENU_SUFIX = "...";
    private ResourceBundle resourceBundle;

    public static final String XBPFILETYPE = "XBPictureEditor.XBPFileType";

    /**
     * Creates new form XBPictureEditorFrame
     */
    public XBPictureEditorFrame() {
        resourceBundle = ResourceBundle.getBundle("org/xbup/tool/xbeditor/module/xbpictureeditor/resources/XBPictureEditorFrame");

        activePanel = new ImagePanel();

        initComponents();

        ((CardLayout) statusPanel.getLayout()).show(statusPanel,"default");

        mainPanel.add(activePanel, java.awt.BorderLayout.CENTER);

        // Open file from command line
/*        String fileName = ((XBPEditor) app).getFileName();
        if (!"".equals(fileName)) {
            setFileName(fileName);
            activePanel.loadFromFile();
        } */

        // Caret position listener
        mouseMotionListener = new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                if (activePanel == null) {
                    return;
                }
                Point pos = activePanel.getMousePosition();
                if (pos == null) {
                    return;
                }
                cursorPositionTextField.setText(Long.toString((long) pos.getX()) +":"+ Long.toString((long) pos.getY()));
            }
        };

        activePanel.attachCaretListener(mouseMotionListener);
        activePanel.setPopupMenu(mainPopupMenu);
     }

    public JPopupMenu getPopupMenu() {
        return mainPopupMenu;
    }

    public boolean isEditEnabled() {
        if (activePanel == null) {
            return false;
        }
        return activePanel.isEditEnabled();
    }

    public boolean isPasteEnabled() {
        if (activePanel == null) {
            return false;
        }
        return activePanel.isPasteEnabled();
    }

    public boolean isUndoAvailable() {
        return activePanel.getUndo().canUndo();
    }

    public boolean isRedoAvailable() {
        return activePanel.getUndo().canRedo();
    }

    public boolean isFalse() {
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        zoombuttonGroup = new javax.swing.ButtonGroup();
        mainPopupMenu = new javax.swing.JPopupMenu();
        statusBar = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusPanel = new javax.swing.JPanel();
        cursorPositionPanel = new javax.swing.JPanel();
        cursorPositionTextField = new javax.swing.JTextField();
        mainPanel = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        filePropertiesMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        filePrintMenuItem = new javax.swing.JMenuItem();
        viewMenu = new javax.swing.JMenu();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        viewZoom = new javax.swing.JMenu();
        viewZoom25MenuItem = new javax.swing.JRadioButtonMenuItem();
        viewZoom50MenuItem = new javax.swing.JRadioButtonMenuItem();
        viewZoom100MenuItem = new javax.swing.JRadioButtonMenuItem();
        viewZoom200MenuItem = new javax.swing.JRadioButtonMenuItem();
        viewZoom400MenuItem = new javax.swing.JRadioButtonMenuItem();
        toolsMenu = new javax.swing.JMenu();
        toolPencilMenuItem = new javax.swing.JRadioButtonMenuItem();
        pictMenu = new javax.swing.JMenu();
        pictResizeMenuItem = new javax.swing.JMenuItem();
        pictRotateMenu = new javax.swing.JMenu();
        pictRotateMirrorMenuItem = new javax.swing.JMenuItem();
        optionsMenu = new javax.swing.JMenu();
        optionsColorsMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        statusBar.setLayout(new java.awt.BorderLayout());
        statusBar.add(statusPanelSeparator, java.awt.BorderLayout.NORTH);

        statusPanel.setPreferredSize(new java.awt.Dimension(649, 26));
        statusPanel.setRequestFocusEnabled(false);
        statusPanel.setLayout(new java.awt.CardLayout());

        cursorPositionTextField.setEditable(false);
        cursorPositionTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cursorPositionTextField.setText("1:1"); // NOI18N

        javax.swing.GroupLayout cursorPositionPanelLayout = new javax.swing.GroupLayout(cursorPositionPanel);
        cursorPositionPanel.setLayout(cursorPositionPanelLayout);
        cursorPositionPanelLayout.setHorizontalGroup(
            cursorPositionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cursorPositionPanelLayout.createSequentialGroup()
                .addComponent(cursorPositionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(304, Short.MAX_VALUE))
        );
        cursorPositionPanelLayout.setVerticalGroup(
            cursorPositionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cursorPositionTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        statusPanel.add(cursorPositionPanel, "default");

        statusBar.add(statusPanel, java.awt.BorderLayout.SOUTH);

        getContentPane().add(statusBar, java.awt.BorderLayout.SOUTH);

        mainPanel.setLayout(new java.awt.BorderLayout());
        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/xbup/tool/xbeditor/module/xbpictureeditor/resources/XBPictureEditorFrame"); // NOI18N
        fileMenu.setText(bundle.getString("fileMenu.text")); // NOI18N

        filePropertiesMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, java.awt.event.InputEvent.ALT_MASK));
        filePropertiesMenuItem.setText("Properties");
        filePropertiesMenuItem.setToolTipText("");
        filePropertiesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filePropertiesMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(filePropertiesMenuItem);
        fileMenu.add(jSeparator1);

        filePrintMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        filePrintMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/xbup/tool/xbeditor/module/xbpictureeditor/resources/images/actions/Print16.gif"))); // NOI18N
        filePrintMenuItem.setText(bundle.getString("actionFilePrint.Action.text")); // NOI18N
        filePrintMenuItem.setToolTipText(bundle.getString("actionFilePrint.Action.shortDescription")); // NOI18N
        filePrintMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filePrintMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(filePrintMenuItem);

        menuBar.add(fileMenu);

        viewMenu.setText(bundle.getString("viewMenu.text")); // NOI18N
        viewMenu.add(jSeparator3);

        viewZoom.setText(bundle.getString("viewZoomMenuItem.text")); // NOI18N
        viewZoom.setToolTipText("");

        viewZoom25MenuItem.setText(bundle.getString("viewZoom25.Action.text")); // NOI18N
        viewZoom25MenuItem.setToolTipText(bundle.getString("viewZoom25.Action.shortDescription")); // NOI18N
        viewZoom25MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewZoom25MenuItemActionPerformed(evt);
            }
        });
        viewZoom.add(viewZoom25MenuItem);

        viewZoom50MenuItem.setText(bundle.getString("viewZoom50.Action.text")); // NOI18N
        viewZoom50MenuItem.setToolTipText(bundle.getString("viewZoom50.Action.shortDescription")); // NOI18N
        viewZoom50MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewZoom50MenuItemActionPerformed(evt);
            }
        });
        viewZoom.add(viewZoom50MenuItem);

        viewZoom100MenuItem.setSelected(true);
        viewZoom100MenuItem.setText(bundle.getString("viewZoom100.Action.text")); // NOI18N
        viewZoom100MenuItem.setToolTipText(bundle.getString("viewZoom100.Action.shortDescription")); // NOI18N
        viewZoom100MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewZoom100MenuItemActionPerformed(evt);
            }
        });
        viewZoom.add(viewZoom100MenuItem);

        viewZoom200MenuItem.setText(bundle.getString("viewZoom200.Action.text")); // NOI18N
        viewZoom200MenuItem.setToolTipText(bundle.getString("viewZoom200.Action.shortDescription")); // NOI18N
        viewZoom200MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewZoom200MenuItemActionPerformed(evt);
            }
        });
        viewZoom.add(viewZoom200MenuItem);

        viewZoom400MenuItem.setText(bundle.getString("viewZoom400.Action.text")); // NOI18N
        viewZoom400MenuItem.setToolTipText(bundle.getString("viewZoom400.Action.shortDescription")); // NOI18N
        viewZoom400MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewZoom400MenuItemActionPerformed(evt);
            }
        });
        viewZoom.add(viewZoom400MenuItem);

        viewMenu.add(viewZoom);

        menuBar.add(viewMenu);

        toolsMenu.setText(bundle.getString("toolsMenu.text")); // NOI18N

        toolPencilMenuItem.setSelected(true);
        toolPencilMenuItem.setText(bundle.getString("toolPencil.Action.text")); // NOI18N
        toolPencilMenuItem.setToolTipText(bundle.getString("toolPencil.Action.shortDescription")); // NOI18N
        toolsMenu.add(toolPencilMenuItem);

        menuBar.add(toolsMenu);

        pictMenu.setText(bundle.getString("pictMenu.text")); // NOI18N

        pictResizeMenuItem.setText(bundle.getString("pictResizeAction.Action.text")); // NOI18N
        pictResizeMenuItem.setToolTipText(bundle.getString("pictResizeAction.Action.shortDescription")); // NOI18N
        pictResizeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pictResizeMenuItemActionPerformed(evt);
            }
        });
        pictMenu.add(pictResizeMenuItem);

        pictRotateMenu.setText(bundle.getString("pictRotateMenu.text")); // NOI18N
        pictRotateMenu.setEnabled(false);

        pictRotateMirrorMenuItem.setText(bundle.getString("pictRotateMirror.Action.text")); // NOI18N
        pictRotateMirrorMenuItem.setToolTipText(bundle.getString("pictRotateMirror.Action.shortDescription")); // NOI18N
        pictRotateMenu.add(pictRotateMirrorMenuItem);

        pictMenu.add(pictRotateMenu);

        menuBar.add(pictMenu);

        optionsMenu.setText(bundle.getString("optionsMenu.text")); // NOI18N

        optionsColorsMenuItem.setText(bundle.getString("toolColorMenuItem.text")); // NOI18N
        optionsColorsMenuItem.setToolTipText(bundle.getString("XBPictureEditorFrame.optionsColorsMenuItem.toolTipText")); // NOI18N
        optionsColorsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionsColorsMenuItemActionPerformed(evt);
            }
        });
        optionsMenu.add(optionsColorsMenuItem);

        menuBar.add(optionsMenu);

        for (JMenuItem item : Arrays.asList(filePropertiesMenuItem, filePrintMenuItem, pictResizeMenuItem, optionsColorsMenuItem)) {
            item.setText(item.getText()+DIALOG_MENU_SUFIX);
        }

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filePrintMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filePrintMenuItemActionPerformed
        activePanel.printFile();
    }//GEN-LAST:event_filePrintMenuItemActionPerformed

    private void filePropertiesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filePropertiesMenuItemActionPerformed
        PropertiesDialog dialog = new PropertiesDialog(this, true);
        dialog.setDocument(activePanel);
        dialog.setLocationRelativeTo(dialog.getParent());
        dialog.setVisible(true);
    }//GEN-LAST:event_filePropertiesMenuItemActionPerformed

    private void viewZoom25MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewZoom25MenuItemActionPerformed
        activePanel.scale(0.25);
    }//GEN-LAST:event_viewZoom25MenuItemActionPerformed

    private void viewZoom50MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewZoom50MenuItemActionPerformed
        activePanel.scale(0.5);
    }//GEN-LAST:event_viewZoom50MenuItemActionPerformed

    private void viewZoom100MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewZoom100MenuItemActionPerformed
        activePanel.scale(1);
    }//GEN-LAST:event_viewZoom100MenuItemActionPerformed

    private void viewZoom200MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewZoom200MenuItemActionPerformed
        activePanel.scale(2);
    }//GEN-LAST:event_viewZoom200MenuItemActionPerformed

    private void viewZoom400MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewZoom400MenuItemActionPerformed
        activePanel.scale(4);
    }//GEN-LAST:event_viewZoom400MenuItemActionPerformed

    private void pictResizeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pictResizeMenuItemActionPerformed
        ImageResizeDialog dlg = new ImageResizeDialog(this, true);
        dlg.setLocationRelativeTo(dlg.getParent());
        activePanel.showResizeDialog(dlg);
    }//GEN-LAST:event_pictResizeMenuItemActionPerformed

    private void optionsColorsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionsColorsMenuItemActionPerformed
        ToolColorDialog dlg = new ToolColorDialog(this, true);
        dlg.setLocationRelativeTo(dlg.getParent());
        dlg.setVisible(true);
        // activePanel.setToolColorDialog(dlg.get);
    }//GEN-LAST:event_optionsColorsMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new XBPictureEditorFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cursorPositionPanel;
    private javax.swing.JTextField cursorPositionTextField;
    public javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem filePrintMenuItem;
    private javax.swing.JMenuItem filePropertiesMenuItem;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPopupMenu mainPopupMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem optionsColorsMenuItem;
    public javax.swing.JMenu optionsMenu;
    public javax.swing.JMenu pictMenu;
    private javax.swing.JMenuItem pictResizeMenuItem;
    private javax.swing.JMenu pictRotateMenu;
    private javax.swing.JMenuItem pictRotateMirrorMenuItem;
    private javax.swing.JPanel statusBar;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JRadioButtonMenuItem toolPencilMenuItem;
    public javax.swing.JMenu toolsMenu;
    public javax.swing.JMenu viewMenu;
    private javax.swing.JMenu viewZoom;
    private javax.swing.JRadioButtonMenuItem viewZoom100MenuItem;
    private javax.swing.JRadioButtonMenuItem viewZoom200MenuItem;
    private javax.swing.JRadioButtonMenuItem viewZoom25MenuItem;
    private javax.swing.JRadioButtonMenuItem viewZoom400MenuItem;
    private javax.swing.JRadioButtonMenuItem viewZoom50MenuItem;
    private javax.swing.ButtonGroup zoombuttonGroup;
    // End of variables declaration//GEN-END:variables

    /**
     * Get the extension part of file name.
     *
     * @param file Source file
     * @return extension part of file name
     */
    public static String getExtension(File file) {
        String ext = null;
        String str = file.getName();
        int i = str.lastIndexOf('.');

        if (i > 0 &&  i < str.length() - 1) {
            ext = str.substring(i+1).toLowerCase();
        }
        return ext;
    }

    public class XBPFileType extends FileFilter implements FileType {

        @Override
        public boolean accept(File f) {
            if (f.isDirectory()) {
                return true;
            }
            String extension = getExtension(f);
            if (extension != null) {
                if (extension.length()<3) {
                    return false;
                }
                return "xbp".contains(extension.substring(0,3));
            }
            return false;
        }

        @Override
        public String getDescription() {
            return resourceBundle.getString("filter_file_xbp");
        }

        @Override
        public String getFileTypeId() {
            return XBPFILETYPE;
        }
    }

    public FileType newXBPFilesFilter() {
        return new XBPictureEditorFrame.XBPFileType();
    }

    public JPanel getStatusPanel() {
        return statusPanel;
    }
}
