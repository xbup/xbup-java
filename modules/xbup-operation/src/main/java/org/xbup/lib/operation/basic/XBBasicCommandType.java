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
package org.xbup.lib.operation.basic;

/**
 * Document command type enumeration.
 *
 * @version 0.1.25 2015/04/25
 * @author XBUP Project (http://xbup.org)
 */
public enum XBBasicCommandType {

    /**
     * Node added.
     */
    NODE_ADDED("Node addded"),
    /**
     * Node deleted.
     */
    NODE_DELETED("Node deleted"),
    /**
     * Node modified.
     */
    NODE_MODIFIED("Node modified"),
    /**
     * Count of attribute changed.
     */
    @Deprecated
    NODE_RSZ_ATTR("Count of attributes changed"),
    /**
     * Attribute modified.
     */
    ATTRIBUTE_MODIFIED("Attribute modified"),
    /**
     * Data modified.
     */
    DATA_MODIFIED("Data modified"),
    /**
     * Data size changed.
     */
    @Deprecated
    NODE_RSZ_DATA("Size of data changed"),
    /**
     * Node swaped.
     */
    NODE_SWAPED("Node swapped");

    private final String caption;

    private XBBasicCommandType(String caption) {
        this.caption = caption;
    }

    public String getCaption() {
        return caption;
    }
}
