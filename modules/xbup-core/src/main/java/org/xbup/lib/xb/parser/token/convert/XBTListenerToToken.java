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
package org.xbup.lib.xb.parser.token.convert;

import java.io.IOException;
import java.io.InputStream;
import org.xbup.lib.xb.block.XBBlockType;
import org.xbup.lib.xb.parser.XBProcessingException;
import org.xbup.lib.xb.parser.basic.XBTListener;
import org.xbup.lib.xb.block.XBBlockTerminationMode;
import org.xbup.lib.xb.parser.token.XBTAttributeToken;
import org.xbup.lib.xb.parser.token.XBTBeginToken;
import org.xbup.lib.xb.parser.token.XBTDataToken;
import org.xbup.lib.xb.parser.token.XBTEndToken;
import org.xbup.lib.xb.parser.token.XBTToken;
import org.xbup.lib.xb.parser.token.XBTTypeToken;
import org.xbup.lib.xb.ubnumber.UBNatural;

/**
 * XBUP level 1 listener to token convertor.
 *
 * @version 0.1 wr23.0 2014/02/07
 * @author XBUP Project (http://xbup.org)
 */
public class XBTListenerToToken implements XBTListener {

    private XBTToken token;

    public XBTListenerToToken() {
        token = null;
    }

    public XBTToken getToken() {
        return token;
    }

    @Override
    public void beginXBT(XBBlockTerminationMode terminationMode) throws XBProcessingException, IOException {
        token = new XBTBeginToken(terminationMode);
    }

    @Override
    public void typeXBT(XBBlockType blockType) throws XBProcessingException, IOException {
        token = new XBTTypeToken(blockType);
    }

    @Override
    public void attribXBT(UBNatural value) throws XBProcessingException, IOException {
        token = new XBTAttributeToken(value);
    }

    @Override
    public void dataXBT(InputStream data) throws XBProcessingException, IOException {
        token = new XBTDataToken(data);
    }

    @Override
    public void endXBT() throws XBProcessingException, IOException {
        token = new XBTEndToken();
    }

    public static void tokenToListener(XBTToken token, XBTListener listener) throws XBProcessingException, IOException {
        switch (token.getTokenType()) {
            case BEGIN: {
                listener.beginXBT(((XBTBeginToken) token).getTerminationMode());
                break;
            }

            case TYPE: {
                listener.typeXBT(((XBTTypeToken) token).getBlockType());
                break;
            }

            case ATTRIBUTE: {
                listener.attribXBT(((XBTAttributeToken) token).getAttribute());
                break;
            }

            case DATA: {
                listener.dataXBT(((XBTDataToken) token).getData());
                break;
            }

            case END: {
                listener.endXBT();
                break;
            }
        }
    }
}
