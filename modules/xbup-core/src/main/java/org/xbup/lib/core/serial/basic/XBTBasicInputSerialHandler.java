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
package org.xbup.lib.core.serial.basic;

import org.xbup.lib.core.parser.basic.XBTConsumer;
import org.xbup.lib.core.serial.XBInputSerialHandler;

/**
 * Interface for XBUP level 1 serialization input handler using basic parser.
 *
 * @version 0.1.24 2014/09/05
 * @author XBUP Project (http://xbup.org)
 */
public interface XBTBasicInputSerialHandler extends XBInputSerialHandler {

    /**
     * Attach listener to be used as target for serialization.
     *
     * @param consumer
     */
    public void attachXBTConsumer(XBTConsumer consumer);
}
