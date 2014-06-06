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
package org.xbup.lib.xb.serial.token;

import java.io.IOException;
import org.xbup.lib.xb.parser.XBProcessingException;
import org.xbup.lib.xb.parser.token.XBToken;
import org.xbup.lib.xb.parser.token.event.XBEventListener;
import org.xbup.lib.xb.serial.XBOutputTokenSerialHandler;

/**
 * XBUP level 0 XBEventListener handler.
 *
 * @version 0.1 wr23.0 2014/03/08
 * @author XBUP Project (http://xbup.org)
 */
public class XBEventListenerSerialHandler implements XBEventListener, XBOutputTokenSerialHandler {

    private XBEventListener listener;

    public XBEventListenerSerialHandler() {
    }

    @Override
    public void attachXBEventListener(XBEventListener listener) {
        this.listener = listener;
    }

    @Override
    public void putXBToken(XBToken token) throws XBProcessingException, IOException {
        listener.putXBToken(token);
    }
}
