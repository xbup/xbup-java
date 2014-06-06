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
package org.xbup.tool.xbeditor.module.xbdoceditor.panel;

import java.awt.Color;
import java.awt.Component;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import org.xbup.lib.xb.block.XBBlockDataMode;
import org.xbup.lib.xb.block.XBBlockType;
import org.xbup.lib.xb.block.declaration.XBContextBlockType;
import org.xbup.lib.xb.block.declaration.XBDBlockType;
import org.xbup.lib.xb.catalog.XBACatalog;
import org.xbup.lib.xb.catalog.base.XBCBlockSpec;
import org.xbup.lib.xb.catalog.base.service.XBCXIconService;
import org.xbup.lib.xb.catalog.base.service.XBCXNameService;
import org.xbup.lib.xb.catalog.declaration.XBCBlockDecl;
import org.xbup.lib.xb.parser.tree.XBTTreeNode;

/**
 * Tree Cell Renderer for XBUP Document Tree.
 *
 * @version 0.1 wr22.0 2013/08/31
 * @author XBUP Project (http://xbup.org)
 */
public class XBDocTreeCellRenderer extends DefaultTreeCellRenderer {

    private XBACatalog catalog;
    private Map<Long,String> captionCache;
    private Map<Long,ImageIcon> iconCache;

    /** Creates a new instance of XBDocTreeCellRenderer */
    public XBDocTreeCellRenderer(XBACatalog catalog) {
        super();
        this.catalog = catalog;
        captionCache = new HashMap<Long,String>();
        iconCache = new HashMap<Long,ImageIcon>();
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel,
            boolean expanded, boolean leaf, int row, boolean hasFocus) {
//        setLeafIcon(leafIcon);
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        if (value instanceof XBTTreeNode) {
            XBTTreeNode node = ((XBTTreeNode) value);
            String caption = null;
            if (node.getDataMode() == XBBlockDataMode.DATA_BLOCK) {
                caption = "Data Block";
            } else if (catalog != null) {
                caption = getCaption(node.getBlockType());
            }
            if (caption != null) {
              setText(caption);
            } else {
              setText("Undefined");
              setForeground(Color.RED);
            }

            if (node.getDataMode() == XBBlockDataMode.NODE_BLOCK) {
                //new ("/home/hajdam/Projekty/XBUP/imgs/xbup_logo2.png").getImage();
                ImageIcon icon = null;
                if (catalog != null) {
                    icon = getIcon(node.getBlockType());
                }
                if (icon != null) {
                    setIcon(icon);
                }
            }
        }
        return this;
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
    }

    /**
     * Get caption for given block type. Use cache if available.
     *
     * @param blockType
     * @return caption
     */
    public String getCaption(XBBlockType blockType) {
        if (blockType instanceof XBContextBlockType) {
            XBCBlockDecl blockDecl = (XBCBlockDecl) ((XBContextBlockType) blockType).getBlockDecl();
            if (blockDecl != null) {
                XBCBlockSpec blockSpec = blockDecl.getBlockSpec(catalog);
                if (captionCache.containsKey(blockSpec.getId())) {
                    return captionCache.get(blockSpec.getId());
                }
                XBCXNameService nameService = (XBCXNameService) catalog.getCatalogService(XBCXNameService.class);
                String caption = nameService.getDefaultCaption(blockSpec);
                captionCache.put(blockSpec.getId(), caption);
                return caption;
            }
        } else if (blockType instanceof XBDBlockType) {
            XBCBlockDecl blockDecl = (XBCBlockDecl) ((XBDBlockType) blockType).getBlockDecl();
            if (blockDecl != null) {
                XBCBlockSpec blockSpec = blockDecl.getBlockSpec(catalog);
                if (captionCache.containsKey(blockSpec.getId())) {
                    return captionCache.get(blockSpec.getId());
                }
                XBCXNameService nameService = (XBCXNameService) catalog.getCatalogService(XBCXNameService.class);
                String caption = nameService.getDefaultCaption(blockSpec);
                captionCache.put(blockSpec.getId(), caption);
                return caption;
            }
        }
        return null;
    }

    /**
     * Get icon for given block type. Use cache if available.
     *
     * @param blockType
     * @return icon
     */
    public ImageIcon getIcon(XBBlockType blockType) {
        if (blockType instanceof XBContextBlockType) {
            XBCBlockDecl blockDecl = (XBCBlockDecl) ((XBContextBlockType) blockType).getBlockDecl();
            if (blockDecl != null) {
                XBCBlockSpec blockSpec = blockDecl.getBlockSpec(catalog);
                if (iconCache.containsKey(blockSpec.getId())) {
                    return iconCache.get(blockSpec.getId());
                }
                XBCXIconService iconService = (XBCXIconService) catalog.getCatalogService(XBCXIconService.class);
                ImageIcon icon = iconService.getDefaultImageIcon(blockSpec);
                if (icon == null) {
                    iconCache.put(blockSpec.getId(), icon);
                    return null;
                }
                if (icon.getImage() == null) {
                    return null;
                }
                icon = new ImageIcon(icon.getImage().getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH));
                iconCache.put(blockSpec.getId(), icon);
                return icon;
            }
        } else if (blockType instanceof XBDBlockType) {
            XBCBlockDecl blockDecl = (XBCBlockDecl) ((XBDBlockType) blockType).getBlockDecl();
            if (blockDecl != null) {
                XBCBlockSpec blockSpec = blockDecl.getBlockSpec(catalog);
                if (iconCache.containsKey(blockSpec.getId())) {
                    return iconCache.get(blockSpec.getId());
                }
                XBCXIconService iconService = (XBCXIconService) catalog.getCatalogService(XBCXIconService.class);
                ImageIcon icon = iconService.getDefaultImageIcon(blockSpec);
                if (icon == null) {
                    iconCache.put(blockSpec.getId(), icon);
                    return null;
                }
                icon = new ImageIcon(icon.getImage().getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH));
                iconCache.put(blockSpec.getId(), icon);
                return icon;
            }
        }
        return null;
    }
}
