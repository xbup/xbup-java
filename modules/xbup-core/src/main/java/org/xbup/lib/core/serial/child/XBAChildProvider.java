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
package org.xbup.lib.core.serial.child;

import java.io.IOException;
import java.util.List;
import org.xbup.lib.core.block.XBBlockType;
import org.xbup.lib.core.parser.XBProcessingException;
import org.xbup.lib.core.serial.XBSerializable;

/**
 * XBUP level 2 child serialization provider interface.
 *
 * @version 0.1.24 2015/01/19
 * @author XBUP Project (http://xbup.org)
 */
public interface XBAChildProvider extends XBTChildProvider {

    /**
     * Pulls and matches block type.
     *
     * @param blockTypes list of block types to match to
     * @return block type
     * @throws XBProcessingException if not matching
     * @throws IOException if input/output exception occurs
     */
    public XBBlockType pullMatchingType(XBBlockType blockTypes) throws XBProcessingException, IOException;

    /**
     * Pulls and matches one of block types.
     *
     * @param blockTypes list of block types to match to
     * @return block type
     * @throws XBProcessingException if not matching
     * @throws IOException if input/output exception occurs
     */
    public XBBlockType pullMatchingType(List<XBBlockType> blockTypes) throws XBProcessingException, IOException;


    /**
     * Pulls serializable object using join method.
     *
     * @param serial serializable block
     * @throws XBProcessingException if not matching
     * @throws IOException if input/output exception occurs
     */
    public void pullJoin(XBSerializable serial) throws XBProcessingException, IOException;

    /**
     * Pulls serializable object using join operation.
     *
     * @param serial serializable object
     * @return null if all pulled items are zero or empty blocks, serial
     * othervise
     */
    public XBSerializable pullNullJoin(XBSerializable serial);
}
