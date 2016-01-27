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
package org.xbup.lib.framework.editor.picture.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.PixelGrabber;
import java.awt.image.RenderedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import org.xbup.lib.core.block.declaration.XBDeclaration;
import org.xbup.lib.core.block.declaration.local.XBLFormatDecl;
import org.xbup.lib.core.catalog.XBPCatalog;
import org.xbup.lib.core.parser.XBProcessingException;
import org.xbup.lib.core.parser.basic.convert.XBTTypeUndeclaringFilter;
import org.xbup.lib.core.parser.token.event.XBEventWriter;
import org.xbup.lib.core.parser.token.event.convert.XBTEventListenerToListener;
import org.xbup.lib.core.parser.token.event.convert.XBTListenerToEventListener;
import org.xbup.lib.core.parser.token.event.convert.XBTToXBEventConvertor;
import org.xbup.lib.core.parser.token.pull.XBPullReader;
import org.xbup.lib.core.parser.token.pull.convert.XBTPullTypeDeclaringFilter;
import org.xbup.lib.core.parser.token.pull.convert.XBToXBTPullConvertor;
import org.xbup.lib.core.serial.XBPSerialReader;
import org.xbup.lib.core.serial.XBPSerialWriter;
import org.xbup.lib.framework.editor.picture.EditorPictureModule;
import org.xbup.lib.framework.editor.picture.PictureFileType;
import org.xbup.lib.framework.gui.file.api.FileType;
import org.xbup.lib.visual.picture.XBBufferedImage;
import org.xbup.lib.framework.editor.picture.dialog.FontDialog;
import org.xbup.lib.framework.editor.picture.dialog.ImageResizeDialog;
import org.xbup.lib.framework.editor.picture.dialog.ToolColorDialog;
import org.xbup.lib.framework.gui.editor.api.XBEditorProvider;
import org.xbup.lib.framework.gui.menu.api.ClipboardActionsUpdateListener;
import org.xbup.lib.framework.gui.menu.api.ComponentClipboardHandler;

/**
 * Image panel for XBPEditor.
 *
 * @version 0.2.0 2016/01/27
 * @author XBUP Project (http://xbup.org)
 */
public class ImagePanel extends javax.swing.JPanel implements XBEditorProvider, ComponentClipboardHandler {

    private static final String DEFAULT_PICTURE_FILE_EXT = "PNG";

    private final UndoManager undo;
    private String fileName;
    private String ext;
    private FileType fileType;
    private final boolean modified = false;
    private Image image;
    private Image scaledImage;
    private Graphics grph;
    private double scaleRatio;
    private final Object highlight;
    private Color selectionColor;
    private Color toolColor;
    private Font defaultFont;
    private Color[] defaultColors;
    private InputMethodListener caretListener;
    private final ToolMode toolMode;
    private PropertyChangeListener propertyChangeListener;

    public ImagePanel() {
        initComponents();
        scaleRatio = 1;
        toolMode = ToolMode.DOTTER;
        undo = new UndoManager();
        fileName = "";
        highlight = null;
        toolColor = Color.BLACK;
        selectionColor = Color.YELLOW;

        // if the document is ever edited, assume that it needs to be saved
/*        imageArea.getDocument().addDocumentListener(new DocumentListener() {
         public void changedUpdate(DocumentEvent e) { setModified(true); }
         public void insertUpdate(DocumentEvent e) { setModified(true); }
         public void removeUpdate(DocumentEvent e) { setModified(true); }
         }); */
        // Listener for undo and redo events
/*        imageArea.getDocument().addUndoableEditListener(new UndoableEditListener() {

         public void undoableEditHappened(UndoableEditEvent evt) {
         undo.addEdit(evt.getEdit());
         firePropertyChange("undoAvailable", false, true);
         firePropertyChange("redoAvailable", false, true);
         }
         }); */
        // Create an undo action and add it to the text component
        imageArea.getActionMap().put("Undo", new AbstractAction("Undo") {

            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    if (undo.canUndo()) {
                        undo.undo();
                    }
                } catch (CannotUndoException ex) {
                    Logger.getLogger(ImagePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        // Bind the undo action to ctl-Z
        imageArea.getInputMap().put(KeyStroke.getKeyStroke("control Z"), "Undo");

        // Create a redo action and add it to the text component
        imageArea.getActionMap().put("Redo", new AbstractAction("Redo") {

            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    if (undo.canRedo()) {
                        undo.redo();
                    }
                } catch (CannotRedoException ex) {
                    Logger.getLogger(ImagePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        // Bind the redo action to ctl-Y
        imageArea.getInputMap().put(KeyStroke.getKeyStroke("control Y"), "Redo");
    }

    public Icon getIcon() {
        return imageArea.getIcon();
    }

    @Override
    public void performCopy() {
        throw new UnsupportedOperationException("Not supported yet.");
//        imageArea.copy();
    }

    @Override
    public void performCut() {
        throw new UnsupportedOperationException("Not supported yet.");
//        imageArea.cut();
    }

    @Override
    public void performDelete() {
        throw new UnsupportedOperationException("Not supported yet.");
//        imageArea.getInputContext().dispatchEvent(new KeyEvent(this, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_DELETE, KeyEvent.CHAR_UNDEFINED));
    }

    @Override
    public void performPaste() {
        throw new UnsupportedOperationException("Not supported yet.");
//        imageArea.paste();
    }

    @Override
    public void performSelectAll() {
        throw new UnsupportedOperationException("Not supported yet.");
//        imageArea.selectAll();
    }

    public void printFile() {
        PrinterJob job = PrinterJob.getPrinterJob();
        if (job.printDialog()) {
            try {
//                PrintJob myJob = imageArea.getToolkit().getPrintJob(null, fileName, null);
//                if (myJob != null) {
                job.setPrintable(new Printable() {

                    @Override
                    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                        imageArea.print(graphics); // TODO: Rescale on page
                        if (pageIndex == 0) {
                            return Printable.PAGE_EXISTS;
                        }
                        return Printable.NO_SUCH_PAGE;
                    }
                });
                job.print();
//                }
            } catch (PrinterException ex) {
                Logger.getLogger(ImagePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void setCurrentFont(Font font) {
        imageArea.setFont(font);
    }

    public void showColorDialog(ToolColorDialog dlg) {
        ToolColorPanel colorPanel = dlg.getColorPanel();
        // colorPanel.setTextFindColor(getSelectionColor());
        dlg.setVisible(true);
        if (dlg.getDialogOption() == JOptionPane.OK_OPTION) {
            // setSelectionColor(colorPanel.getTextFindColor());
        }
    }

    public void showFontDialog(FontDialog dlg) {
//        SimpleAttributeSet a = new SimpleAttributeSet();
//        StyleConstants.setFontFamily(a, "Monospaced");
//        StyleConstants.setFontSize(a, 12);
//        dlg.setAttributes(a);
        dlg.setStoredFont(imageArea.getFont());
        dlg.setVisible(true);
        if (dlg.getDialogOption() == JOptionPane.OK_OPTION) {
            imageArea.setFont(dlg.getStoredFont());
//            textArea.setForeground(dlg.getMyColor());
        }
    }

    public Color getSelectionColor() {
        return selectionColor;
    }

    public void setSelectionColor(Color color) {
        selectionColor = color;
        if (highlight != null) {
            // TODO: Replace higlighter with the same with new color
//            ((DefaultHighlighter) highlight).getHighlights()[0].
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        imageArea = new javax.swing.JLabel();

        setAutoscrolls(true);
        setInheritsPopupMenu(true);
        setName("Form"); // NOI18N
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        imageArea.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        imageArea.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        imageArea.setAlignmentY(0.0F);
        imageArea.setAutoscrolls(true);
        imageArea.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        imageArea.setIconTextGap(0);
        imageArea.setName("imageArea"); // NOI18N
        imageArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageAreaMouseClicked(evt);
            }
        });
        imageArea.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                imageAreaMouseDragged(evt);
            }
        });
        jScrollPane1.setViewportView(imageArea);

        add(jScrollPane1);
    }// </editor-fold>//GEN-END:initComponents

    private void imageAreaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageAreaMouseDragged
        if (null != toolMode) {
            switch (toolMode) {
                case DOTTER:
                    int x = (int) (evt.getX() / scaleRatio);
                    int y = (int) (evt.getY() / scaleRatio);
                    if (grph != null) {
                        grph.fillOval(x - 5, y - 5, 10, 10);
//                image.flush();
                        scaledImage.flush();
                        imageArea.repaint();
                    } else {
                        System.out.println("Graphics is null!");
                    }   //            evt.getComponent().repaint();
                    evt.consume();
                    break;
                case PENCIL:
                    break;
                case LINE:
                    break;
                default:
                    break;
            }
        }
    }//GEN-LAST:event_imageAreaMouseDragged

    private void imageAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageAreaMouseClicked
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON1) {
            if (null != toolMode) {
                switch (toolMode) {
                    case DOTTER:
                        int x = (int) (evt.getX() / scaleRatio);
                        int y = (int) (evt.getY() / scaleRatio);
                        if (grph != null) {
                            grph.fillOval(x - 5, y - 5, 10, 10);
//                    image.flush();
                            scaledImage.flush();
                            repaint();
                        } else {
                            System.out.println("Graphics is null!");
                        }   //                evt.getComponent().repaint();
                        evt.consume();
                        break;
                    case PENCIL:
                        break;
                    case LINE:
                        break;
                    default:
                        break;
                }
            }
        }
    }//GEN-LAST:event_imageAreaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imageArea;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public boolean isModified() {
        return modified;
    }

    public void setModified(boolean modified) {
        /*        if (highlight != null) {
         imageArea.getHighlighter().removeHighlight(highlight);
         highlight = null;
         }
         boolean oldValue = this.modified;
         this.modified = modified;
         firePropertyChange("modified", oldValue, this.modified); */
    }

    public boolean isEditEnabled() {
        return false;
//        return imageArea.isEditable();
    }

    public boolean isPasteEnabled() {
        return false;
//        return imageArea.isEditable();
    }

    @Override
    public void loadFromFile() {
        if (EditorPictureModule.XBPFILETYPE.equals(fileType.getFileTypeId())) {
            try {
                if (image == null) {
                    image = createImage(1, 1);
                }

                XBPCatalog catalog = new XBPCatalog();
                catalog.addFormatDecl(getContextFormatDecl());
                XBLFormatDecl formatDecl = new XBLFormatDecl(XBBufferedImage.XBUP_FORMATREV_CATALOGPATH);
                XBBufferedImage bufferedImage = new XBBufferedImage(toBufferedImage(image));
                XBDeclaration declaration = new XBDeclaration(formatDecl, bufferedImage);
                XBTPullTypeDeclaringFilter typeProcessing = new XBTPullTypeDeclaringFilter(catalog);
                typeProcessing.attachXBTPullProvider(new XBToXBTPullConvertor(new XBPullReader(new FileInputStream(getFileName()))));
                XBPSerialReader reader = new XBPSerialReader(typeProcessing);
                reader.read(declaration);
                image = bufferedImage.getImage();
            } catch (XBProcessingException | IOException ex) {
                Logger.getLogger(ImagePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            image = toBufferedImage(Toolkit.getDefaultToolkit().getImage(getFileName()));
        }
        scaledImage = image;
        grph = image.getGraphics();
        grph.setColor(toolColor);
        imageArea.setIcon(new ImageIcon(image));
        scale(scaleRatio);
    }

    @Override
    public void saveToFile() {
        File file = new File(getFileName());
        if (EditorPictureModule.XBPFILETYPE.equals(fileType.getFileTypeId())) {
            try {
                FileOutputStream output = new FileOutputStream(file);

                XBPCatalog catalog = new XBPCatalog();
                catalog.addFormatDecl(getContextFormatDecl());
                XBLFormatDecl formatDecl = new XBLFormatDecl(XBBufferedImage.XBUP_FORMATREV_CATALOGPATH);
                XBDeclaration declaration = new XBDeclaration(formatDecl, new XBBufferedImage(toBufferedImage(image)));
                declaration.realignReservation(catalog);
                XBTTypeUndeclaringFilter typeProcessing = new XBTTypeUndeclaringFilter(catalog);
                typeProcessing.attachXBTListener(new XBTEventListenerToListener(new XBTToXBEventConvertor(new XBEventWriter(output))));
                XBPSerialWriter writer = new XBPSerialWriter(new XBTListenerToEventListener(typeProcessing));
                writer.write(declaration);
            } catch (XBProcessingException | IOException ex) {
                Logger.getLogger(ImagePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                if (fileType instanceof PictureFileType) {
                    ext = ((PictureFileType) fileType).getExt();
                }

                ImageIO.write((RenderedImage) image, ext == null ? DEFAULT_PICTURE_FILE_EXT : ext, file);
            } catch (IOException ex) {
                Logger.getLogger(ImagePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Returns local format declaration when catalog or service is not
     * available.
     *
     * @return local format declaration
     */
    public XBLFormatDecl getContextFormatDecl() {
        /*XBLFormatDef formatDef = new XBLFormatDef();
         List<XBFormatParam> groups = formatDef.getFormatParams();
         XBLGroupDecl bitmapGroup = new XBLGroupDecl(new XBLGroupDef());
         List<XBGroupParam> bitmapBlocks = bitmapGroup.getGroupDef().getGroupParams();
         bitmapBlocks.add(new XBGroupParamConsist(new XBLBlockDecl(new long[]{1, 4, 0, 0, 1, 0})));
         bitmapBlocks.add(new XBGroupParamConsist(new XBLBlockDecl(new long[]{1, 4, 0, 0, 2, 0})));
         ((XBLGroupDef) bitmapGroup.getGroupDef()).provideRevision();
         XBLGroupDecl paletteGroup = new XBLGroupDecl(new XBLGroupDef());
         List<XBGroupParam> paletteBlocks = paletteGroup.getGroupDef().getGroupParams();
         paletteBlocks.add(new XBGroupParamConsist(new XBLBlockDecl(new long[]{1, 4, 0, 1, 1, 0})));
         paletteBlocks.add(new XBGroupParamConsist(new XBLBlockDecl(new long[]{1, 4, 0, 1, 1, 0})));
         paletteBlocks.add(new XBGroupParamConsist(new XBLBlockDecl(new long[]{1, 4, 0, 1, 2, 0})));
         paletteBlocks.add(new XBGroupParamConsist(new XBLBlockDecl(new long[]{1, 4, 0, 1, 3, 0})));
         paletteBlocks.add(new XBGroupParamConsist(new XBLBlockDecl(new long[]{1, 4, 0, 1, 4, 0})));
         paletteBlocks.add(new XBGroupParamConsist(new XBLBlockDecl(new long[]{1, 4, 0, 1, 5, 0})));
         paletteBlocks.add(new XBGroupParamConsist(new XBLBlockDecl(new long[]{1, 4, 0, 1, 6, 0})));
         paletteBlocks.add(new XBGroupParamConsist(new XBLBlockDecl(new long[]{1, 4, 0, 1, 7, 0})));
         ((XBLGroupDef) paletteGroup.getGroupDef()).provideRevision();
         groups.add(new XBFormatParamConsist(bitmapGroup));
         groups.add(new XBFormatParamConsist(paletteGroup));
         formatDef.realignRevision();
            
         XBLFormatDecl formatDecl = new XBLFormatDecl(formatDef);
         formatDecl.setCatalogPath(XBBufferedImage.XBUP_FORMATREV_CATALOGPATH);*/

        XBPSerialReader reader = new XBPSerialReader(ClassLoader.class.getResourceAsStream("/org/xbup/tool/editor/module/picture_editor/resources/xbp_format_decl.xb"));
        XBLFormatDecl formatDecl = new XBLFormatDecl();
        try {
            reader.read(formatDecl);
        } catch (XBProcessingException | IOException ex) {
            Logger.getLogger(ImagePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return formatDecl;
    }

    @Override
    public void newFile() {
        image = toBufferedImage(createImage(100, 100));
        scaledImage = image;
        imageArea.setIcon(new ImageIcon(image));
        grph = image.getGraphics();
        grph.setColor(Color.WHITE);
        grph.fillRect(0, 0, imageArea.getIcon().getIconWidth(), imageArea.getIcon().getIconHeight());
        grph.setColor(toolColor);
        setModified(false);
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    @Override
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public UndoManager getUndo() {
        return undo;
    }

    public void setPopupMenu(JPopupMenu menu) {
        imageArea.setComponentPopupMenu(menu);
    }

    public Font getDefaultFont() {
        return defaultFont;
    }

    public void scale(double ratio) {
        scaleRatio = ratio;
        int width = (int) (image.getWidth(null) * ratio);
        int height = (int) (image.getHeight(null) * ratio);
        scaledImage = image.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        ((ImageIcon) imageArea.getIcon()).setImage(scaledImage);
        imageArea.setSize(width, height);
        imageArea.repaint();
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    // This method returns a buffered image with the contents of an image
    // From: http://www.exampledepot.com/egs/java.awt.image/Image2Buf.html
    public static BufferedImage toBufferedImage(Image image) {
        if (image == null) {
            return null;
        }

        if (image instanceof BufferedImage) {
            return (BufferedImage) image;
        }

        // This code ensures that all the pixels in the image are loaded
        image = new ImageIcon(image).getImage();

        // Determine if the image has transparent pixels; for this method's
        // implementation, see e661 Determining If an Image Has Transparent Pixels
        boolean hasAlpha = hasAlpha(image);

        // Create a buffered image with a format that's compatible with the screen
        BufferedImage bimage = null;
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            // Determine the type of transparency of the new buffered image
            int transparency = Transparency.OPAQUE;
            if (hasAlpha) {
                transparency = Transparency.BITMASK;
            }

            // Create the buffered image
            GraphicsDevice gs = ge.getDefaultScreenDevice();
            GraphicsConfiguration gc = gs.getDefaultConfiguration();
            int width = image.getWidth(null);
            int height = image.getHeight(null);
            if ((width == -1) || (height == -1)) {
                // Something gone wrong

            }
            bimage = gc.createCompatibleImage(width, height, transparency);
        } catch (HeadlessException e) {
            // The system does not have a screen
        }

        if (bimage == null) {
            // Create a buffered image using the default color model
            int type = BufferedImage.TYPE_INT_RGB;
            if (hasAlpha) {
                type = BufferedImage.TYPE_INT_ARGB;
            }
            bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
        }

        // Copy image to buffered image
        Graphics g = bimage.createGraphics();

        // Paint the image onto the buffered image
        g.drawImage(image, 0, 0, null);
        g.dispose();

        return bimage;
    }

    public static boolean hasAlpha(Image image) {
        // If buffered image, the color model is readily available
        if (image instanceof BufferedImage) {
            BufferedImage bimage = (BufferedImage) image;
            return bimage.getColorModel().hasAlpha();
        }

        // Use a pixel grabber to retrieve the image's color model;
        // grabbing a single pixel is usually sufficient
        PixelGrabber pg = new PixelGrabber(image, 0, 0, 1, 1, false);
        try {
            pg.grabPixels();
        } catch (InterruptedException e) {
        }

        // Get the image's color model
        ColorModel cm = pg.getColorModel();
        if (cm == null) {
            return false;
        }
        return cm.hasAlpha();
    }

    @Override
    public Point getMousePosition() {
        return imageArea.getMousePosition();
    }

    public void attachCaretListener(MouseMotionListener listener) {
        imageArea.addMouseMotionListener(listener);
    }

    public void setToolColor(Color toolColor) {
        this.toolColor = toolColor;
        if (grph != null) {
            grph.setColor(toolColor);
        }
    }

    public void showResizeDialog(ImageResizeDialog dlg) {
        dlg.setResolution(new Point(image.getWidth(null), image.getHeight(null)));
        dlg.setVisible(true);
        if (dlg.getDialogOption() == JOptionPane.OK_OPTION) {
            Point point = dlg.getResolution();
            int width = (int) (point.getX());
            int height = (int) (point.getY());
            image = toBufferedImage(image.getScaledInstance(width, height, Image.SCALE_DEFAULT));
            grph = image.getGraphics();
            grph.setColor(toolColor);
            scale(scaleRatio);
        }
    }

    @Override
    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    @Override
    public void setPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        this.propertyChangeListener = propertyChangeListener;
    }

    @Override
    public String getWindowTitle(String frameTitle) {
        if (!"".equals(fileName)) {
            int pos;
            int newpos = 0;
            do {
                pos = newpos;
                newpos = fileName.indexOf(File.separatorChar, pos) + 1;
            } while (newpos > 0);
            return fileName.substring(pos) + " - " + frameTitle;
        }

        return frameTitle;
    }

    @Override
    public JPanel getPanel() {
        return this;
    }

    @Override
    public boolean isSelection() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isEditable() {
        return false;
    }

    @Override
    public boolean canSelectAll() {
        return false;
    }

    @Override
    public boolean canPaste() {
        return false;
    }

    @Override
    public void setUpdateListener(ClipboardActionsUpdateListener updateListener) {
    }

    public enum ToolMode {

        DOTTER,
        PENCIL,
        LINE
    }
}
