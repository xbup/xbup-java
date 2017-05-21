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
package org.exbin.xbup.core.parser.token.event.convert;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.exbin.xbup.core.block.XBBasicBlockType;
import org.exbin.xbup.core.block.XBBlockTerminationMode;
import org.exbin.xbup.core.block.XBBlockType;
import org.exbin.xbup.core.block.XBDBlockType;
import org.exbin.xbup.core.block.XBFixedBlockType;
import org.exbin.xbup.core.block.declaration.XBContext;
import org.exbin.xbup.core.block.declaration.XBLevelContext;
import org.exbin.xbup.core.catalog.XBCatalog;
import org.exbin.xbup.core.parser.XBProcessingException;
import org.exbin.xbup.core.parser.XBProcessingExceptionType;
import org.exbin.xbup.core.parser.token.XBTBeginToken;
import org.exbin.xbup.core.parser.token.XBTDataToken;
import org.exbin.xbup.core.parser.token.XBTToken;
import org.exbin.xbup.core.parser.token.XBTTokenType;
import org.exbin.xbup.core.parser.token.XBTTypeToken;
import org.exbin.xbup.core.parser.token.convert.XBTListenerToToken;
import org.exbin.xbup.core.parser.token.event.XBTEventFilter;
import org.exbin.xbup.core.parser.token.event.XBTEventListener;
import org.exbin.xbup.core.util.StreamUtils;

/**
 * Filter to convert declared stand-alone block types to fixed types.
 *
 * @version 0.1.25 2015/02/25
 * @author ExBin Project (http://exbin.org)
 */
public class XBTEventTypeUndeclaringFilter implements XBTEventFilter {

    private XBTEventListener eventListener;
    private XBCatalog catalog;
    private final List<XBLevelContext> contexts = new ArrayList<>();
    private XBLevelContext currentContext = null;

    private int documentDepth = 0;
    private XBBlockTerminationMode beginTerminationMode;

    public XBTEventTypeUndeclaringFilter(XBCatalog catalog) {
        this(catalog, null);
    }

    public XBTEventTypeUndeclaringFilter(XBCatalog catalog, XBTEventListener eventListener) {
        this.catalog = catalog;
        currentContext = new XBLevelContext(catalog, catalog.getRootContext(), 0);
        this.eventListener = eventListener;
    }

    public XBTEventTypeUndeclaringFilter(XBContext initialContext) {
        currentContext = new XBLevelContext(catalog, initialContext, 0);
    }

    public XBTEventTypeUndeclaringFilter(XBContext initialContext, XBTEventListener eventListener) {
        this(initialContext);
        this.eventListener = eventListener;
    }

    @Override
    public void putXBTToken(XBTToken token) throws XBProcessingException, IOException {
        if (currentContext != null && !currentContext.isDeclarationFinished()) {
            if (token.getTokenType() == XBTTokenType.DATA) {
                InputStream inputStream = ((XBTDataToken) token).getData();
                ByteArrayOutputStream dataStream = new ByteArrayOutputStream();
                StreamUtils.copyInputStreamToOutputStream(inputStream, dataStream);
                currentContext.dataXBT(new ByteArrayInputStream(dataStream.toByteArray()));
                token = XBTDataToken.create(new ByteArrayInputStream(dataStream.toByteArray()));
            } else {
                XBTListenerToToken.tokenToListener(token, currentContext);
            }
        }

        switch (token.getTokenType()) {
            case BEGIN: {
                documentDepth++;
                beginTerminationMode = ((XBTBeginToken) token).getTerminationMode();

                eventListener.putXBTToken(token);
                break;
            }
            case TYPE: {
                XBBlockType blockType = ((XBTTypeToken) token).getBlockType();
                if (blockType.getAsBasicType() == XBBasicBlockType.DECLARATION) {
                    documentDepth++;
                    contexts.add(currentContext);
                    currentContext = new XBLevelContext(catalog, currentContext == null ? null : currentContext.getContext(), documentDepth);
                    currentContext.beginXBT(beginTerminationMode);
                    currentContext.typeXBT(blockType);
                } else {
                    if (blockType instanceof XBDBlockType) {
                        XBFixedBlockType fixedType = currentContext.getContext().getFixedBlockType((XBDBlockType) blockType);
                        if (fixedType == null) {
                            throw new XBProcessingException("Unable to match block type", XBProcessingExceptionType.BLOCK_TYPE_MISMATCH);
                        }
                        eventListener.putXBTToken(XBTTypeToken.create(fixedType));
                        return;
                    }
                }

                eventListener.putXBTToken(token);
                break;
            }
            case ATTRIBUTE: {
                eventListener.putXBTToken(token);
                break;
            }
            case DATA: {
                eventListener.putXBTToken(token);
                break;
            }
            case END: {
                documentDepth--;
                if (currentContext != null && currentContext.getDepthLevel() > documentDepth) {
                    currentContext = contexts.size() > 0 ? contexts.remove(contexts.size() - 1) : null;
                }

                eventListener.putXBTToken(token);
                break;
            }
            default: {
                throw new IllegalStateException("Unexpected token type " + token.getTokenType().toString());
            }
        }
    }

    @Override
    public void attachXBTEventListener(XBTEventListener eventListener) {
        this.eventListener = eventListener;
    }
}
