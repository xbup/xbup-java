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
package org.xbup.lib.core.parser.token.param;

import org.xbup.lib.core.block.definition.XBBlockParam;

/**
 * XBUP protocol level 1 parameter begin token.
 *
 * @version 0.1.23 2013/11/29
 * @author XBUP Project (http://xbup.org)
 */
public class XBBeginParamToken extends XBParamToken {

    private final XBBlockParam paramType;

    public XBBeginParamToken(XBBlockParam paramType) {
        this.paramType = paramType;
    }

    public XBBlockParam getParamType() {
        return paramType;
    }

    @Override
    public XBParamTokenType getTokenType() {
        return XBParamTokenType.BEGIN;
    }
}
