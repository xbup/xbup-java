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
package org.xbup.lib.xb.parser.token.event.convert;

import java.io.IOException;
import org.xbup.lib.xb.parser.XBProcessingException;
import org.xbup.lib.xb.parser.token.XBAttributeToken;
import org.xbup.lib.xb.parser.token.XBBeginToken;
import org.xbup.lib.xb.parser.token.XBDataToken;
import org.xbup.lib.xb.parser.token.XBEndToken;
import org.xbup.lib.xb.parser.token.XBTAttributeToken;
import org.xbup.lib.xb.parser.token.XBTBeginToken;
import org.xbup.lib.xb.parser.token.XBTDataToken;
import org.xbup.lib.xb.parser.token.XBTToken;
import org.xbup.lib.xb.parser.token.XBTTokenType;
import org.xbup.lib.xb.parser.token.XBTTypeToken;
import org.xbup.lib.xb.parser.token.event.XBEventListener;
import org.xbup.lib.xb.parser.token.event.XBEventProducer;
import org.xbup.lib.xb.parser.token.event.XBTEventListener;

/**
 * XBUP level 1 to level 0 event convertor.
 *
 * @version 0.1 wr23.0 2013/11/22
 * @author XBUP Project (http://xbup.org)
 */
public class XBTToXBEventConvertor implements XBTEventListener, XBEventProducer {

    private XBEventListener target;

    public XBTToXBEventConvertor(XBEventListener target) {
        this.target = target;
    }

    @Override
    public void attachXBEventListener(XBEventListener eventListener) {
        target = eventListener;
    }

    @Override
    public void putXBTToken(XBTToken token) throws XBProcessingException, IOException {
        if (token.getTokenType() == XBTTokenType.TYPE) {
            target.putXBToken(new XBAttributeToken(((XBTTypeToken) token).getBlockType().getGroupID()));
            target.putXBToken(new XBAttributeToken(((XBTTypeToken) token).getBlockType().getBlockID()));
        } else {
            switch (token.getTokenType()) {
                case BEGIN: {
                    target.putXBToken(new XBBeginToken(((XBTBeginToken) token).getTerminationMode()));
                    break;
                }

                case ATTRIBUTE: {
                    target.putXBToken(new XBAttributeToken(((XBTAttributeToken) token).getAttribute()));
                    break;
                }

                case DATA: {
                    target.putXBToken(new XBDataToken(((XBTDataToken) token).getData()));
                    break;
                }

                case END: {
                    target.putXBToken(new XBEndToken());
                    break;
                }
            }
        }
    }
}
