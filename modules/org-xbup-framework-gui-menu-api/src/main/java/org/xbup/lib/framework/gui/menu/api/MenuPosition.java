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
package org.xbup.lib.framework.gui.menu.api;

/**
 * Menu position.
 *
 * @version 0.2.0 2016/01/09
 * @author XBUP Project (http://xbup.org)
 */
public class MenuPosition {

    private final MenuPositionMode basicMode;
    private final String groupId;

    public MenuPosition(MenuPositionMode basicMode) {
        this.basicMode = basicMode;
        groupId = null;
    }

    public MenuPosition(String groupId) {
        basicMode = null;
        this.groupId = groupId;
    }

    public MenuPositionMode getBasicMode() {
        return basicMode;
    }

    public String getGroupId() {
        return groupId;
    }
}
