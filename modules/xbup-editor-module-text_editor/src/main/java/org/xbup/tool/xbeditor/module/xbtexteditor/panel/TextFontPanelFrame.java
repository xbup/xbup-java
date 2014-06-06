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
package org.xbup.tool.xbeditor.module.xbtexteditor.panel;

import java.awt.Font;

/**
 * XB Text Editor Module.
 *
 * @version 0.1 wr22.0 2013/03/10
 * @author XBUP Project (http://xbup.org)
 */
public interface TextFontPanelFrame {

    /**
     * Returns current font used in application frame.
     * @return font
     */
    public Font getCurrentFont();

    /**
     * Returns default colors used in application frame.
     * @return font
     */
    public Font getDefaultFont();

    /**
     * Sets current colors used in application frame.
     */
    public void setCurrentFont(Font font);
}
