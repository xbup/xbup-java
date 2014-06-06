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
package org.xbup.lib.xb.serial;

/**
 * Enumeration of possible serial parsing states.
 *
 * @version 0.1 wr23.0 2014/02/25
 * @author XBUP Project (http://xbup.org)
 */
public enum XBSerialState {

    /**
     * Start of the block.
     */
    BLOCK_BEGIN,
    /**
     * Inside or at the end of atribute part.
     */
    ATTRIBUTE_PART,
    /**
     * Type processing.
     */
    TYPE,
    /**
     * After first and before last attribute.
     */
    ATTRIBUTES,
    /**
     * Inside or at the end of data part.
     */
    DATA,
    /**
     * Children data processed.
     */
    CHILDREN,
    /**
     * End of block.
     */
    BLOCK_END,
    /**
     * End of parsing.
     */
    EOF,
}
