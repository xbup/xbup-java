package org.xbup.plugin.picture;

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
import javax.swing.JPanel;
import net.xeoh.plugins.base.annotations.PluginImplementation;
import org.xbup.lib.plugin.XBLineEditor;
import org.xbup.lib.plugin.XBPanelEditor;
import org.xbup.lib.plugin.XBPlugin;
import org.xbup.lib.plugin.XBTransformation;
import org.xbup.lib.visual.xbplugins.XBPicturePanel;

/**
 * XBUP Editor plugin - provides editing panel for XBUP data.
 *
 * @version 0.1.24 2014/11/27
 * @author XBUP Project (http://xbup.org)
 */
@PluginImplementation
public class XBPicturePlugin implements XBPlugin {

    @Override
    public String getPluginPath() {
        return "xbup/visual/picture/XBPicturePlugin.jar";
    }

    @Override
    public long getLineEditorsCount() {
        return 0;
    }

    @Override
    public XBLineEditor getLineEditor(long index) {
        return null;
    }

    @Override
    public long getPanelEditorsCount() {
        return 1;
    }

    @Override
    public XBPanelEditor getPanelEditor(long index) {
        if (index == 0) {
            return new XBPanelEditor() {

                @Override
                public JPanel getPanel() {
                    return new XBPicturePanel();
                }
            };
        }
        return null;
    }

    @Override
    public long getTransformationCount() {
        return 0;
    }

    @Override
    public XBTransformation getTransformation(long index) {
        return null;
    }

}
