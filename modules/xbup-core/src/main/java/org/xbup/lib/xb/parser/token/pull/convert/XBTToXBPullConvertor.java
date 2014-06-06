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
package org.xbup.lib.xb.parser.token.pull.convert;

import java.io.IOException;
import org.xbup.lib.xb.parser.XBProcessingException;
import org.xbup.lib.xb.parser.XBProcessingExceptionType;
import org.xbup.lib.xb.parser.token.XBAttributeToken;
import org.xbup.lib.xb.parser.token.XBBeginToken;
import org.xbup.lib.xb.parser.token.XBDataToken;
import org.xbup.lib.xb.parser.token.XBEndToken;
import org.xbup.lib.xb.parser.token.XBTAttributeToken;
import org.xbup.lib.xb.parser.token.XBTBeginToken;
import org.xbup.lib.xb.parser.token.XBTDataToken;
import org.xbup.lib.xb.parser.token.XBTToken;
import org.xbup.lib.xb.parser.token.XBTTypeToken;
import org.xbup.lib.xb.parser.token.XBToken;
import org.xbup.lib.xb.parser.token.pull.XBPullProvider;
import org.xbup.lib.xb.parser.token.pull.XBTPullConsumer;
import org.xbup.lib.xb.parser.token.pull.XBTPullProvider;

/**
 * XBUP level 1 to level 0 pull convertor.
 *
 * @version 0.1 wr23.0 2014/02/06
 * @author XBUP Project (http://xbup.org)
 */
public class XBTToXBPullConvertor implements XBTPullConsumer, XBPullProvider {

    private XBTPullProvider pullProvider;
    private XBToken buffer;

    @Override
    public void attachXBTPullProvider(XBTPullProvider pullProvider) {
        this.pullProvider = pullProvider;
        buffer = null;
    }

    @Override
    public XBToken pullXBToken() throws XBProcessingException, IOException {
        if (buffer != null) {
            XBToken token = buffer;
            buffer = null;
            return token;
        }

        XBTToken token = pullProvider.pullXBTToken();
        switch (token.getTokenType()) {
            case BEGIN:
                return new XBBeginToken(((XBTBeginToken) token).getTerminationMode());

            case TYPE: {
                buffer = new XBAttributeToken(((XBTTypeToken) token).getBlockType().getBlockID());
                return new XBAttributeToken(((XBTTypeToken) token).getBlockType().getGroupID());
            }

            case ATTRIBUTE:
                return new XBAttributeToken(((XBTAttributeToken) token).getAttribute());

            case DATA:
                return new XBDataToken(((XBTDataToken) token).getData());

            case END:
                return new XBEndToken();

            default:
                throw new XBProcessingException("Unexpected token type", XBProcessingExceptionType.UNKNOWN);
        }
    }
}
