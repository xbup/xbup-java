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
package org.xbup.lib.core.parser.token;

import java.io.InputStream;

/**
 * XBUP protocol level 0 data token.
 *
 * Class carry data represented as byte stream available via InputStream class.
 * You have to process data before processing next event.
 *
 * @version 0.1.22 2013/11/01
 * @author XBUP Project (http://xbup.org)
 */
public class XBDataToken extends XBToken {

    private final InputStream data;

    public XBDataToken(InputStream data) {
        this.data = data;
    }

    public InputStream getData() {
        return data;
    }

    @Override
    public XBTokenType getTokenType() {
        return XBTokenType.DATA;
    }
}
