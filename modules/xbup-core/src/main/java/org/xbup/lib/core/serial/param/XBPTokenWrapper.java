/*
 * Copyright (C) ExBin Project
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
package org.xbup.lib.core.serial.param;

import java.io.IOException;
import org.xbup.lib.core.parser.XBProcessingException;
import org.xbup.lib.core.parser.token.XBTToken;

/**
 * Token wrapper for level 2 serialization event.
 *
 * @version 0.1.24 2015/01/22
 * @author ExBin Project (http://exbin.org)
 */
public class XBPTokenWrapper implements XBPSerializable {

    private XBTToken token;

    public XBPTokenWrapper(XBTToken token) {
        this.token = token;
    }

    public XBTToken getToken() {
        return token;
    }

    public void setToken(XBTToken token) {
        this.token = token;
    }

    @Override
    public void serializeFromXB(XBPInputSerialHandler serializationHandler) throws XBProcessingException, IOException {
        token = serializationHandler.pullToken(token.getTokenType());
    }

    @Override
    public void serializeToXB(XBPOutputSerialHandler serializationHandler) throws XBProcessingException, IOException {
        serializationHandler.putToken(token);
    }
}
