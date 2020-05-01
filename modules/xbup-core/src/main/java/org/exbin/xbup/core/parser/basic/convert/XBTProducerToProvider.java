/*
 * Copyright (C) ExBin Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.exbin.xbup.core.parser.basic.convert;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.exbin.xbup.core.block.XBBlockTerminationMode;
import org.exbin.xbup.core.block.XBBlockType;
import org.exbin.xbup.core.parser.XBProcessingException;
import org.exbin.xbup.core.parser.XBProcessingExceptionType;
import org.exbin.xbup.core.parser.basic.XBTListener;
import org.exbin.xbup.core.parser.basic.XBTProducer;
import org.exbin.xbup.core.parser.basic.XBTProvider;
import org.exbin.xbup.core.parser.basic.XBTSListener;
import org.exbin.xbup.core.parser.token.XBAttribute;
import org.exbin.xbup.core.parser.token.XBTAttributeToken;
import org.exbin.xbup.core.parser.token.XBTBeginToken;
import org.exbin.xbup.core.parser.token.XBTDataToken;
import org.exbin.xbup.core.parser.token.XBTEndToken;
import org.exbin.xbup.core.parser.token.XBTSBeginToken;
import org.exbin.xbup.core.parser.token.XBTToken;
import org.exbin.xbup.core.parser.token.XBTTypeToken;
import org.exbin.xbup.core.parser.token.convert.XBTListenerToToken;
import org.exbin.xbup.core.ubnumber.UBNatural;

/**
 * XBUP level 1 producer to provider convertor.
 *
 * Uses token buffer stored in memory.
 *
 * @version 0.1.25 2015/02/06
 * @author ExBin Project (http://exbin.org)
 */
public class XBTProducerToProvider implements XBTProvider {

    private List<XBTToken> tokens;

    public XBTProducerToProvider(XBTProducer producer) {
        tokens = new ArrayList<>();
        producer.attachXBTListener(new XBTSListener() {

            @Override
            public void beginXBT(XBBlockTerminationMode terminationMode) throws XBProcessingException, IOException {
                tokens.add(XBTBeginToken.create(terminationMode));
            }

            @Override
            public void beginXBT(XBBlockTerminationMode terminationMode, UBNatural blockSize) throws XBProcessingException, IOException {
                tokens.add(XBTSBeginToken.create(terminationMode, blockSize));
            }

            @Override
            public void typeXBT(XBBlockType type) throws XBProcessingException, IOException {
                tokens.add(XBTTypeToken.create(type));
            }

            @Override
            public void attribXBT(XBAttribute value) throws XBProcessingException, IOException {
                tokens.add(XBTAttributeToken.create(value));
            }

            @Override
            public void dataXBT(InputStream data) throws XBProcessingException, IOException {
                tokens.add(XBTDataToken.create(data));
            }

            @Override
            public void endXBT() throws XBProcessingException, IOException {
                tokens.add(XBTEndToken.create());
            }
        });
    }

    @Override
    public void produceXBT(XBTListener listener) throws XBProcessingException, IOException {
        if (tokens.isEmpty()) {
            XBTToken token = tokens.get(0);
            XBTListenerToToken.tokenToListener(token, listener);
        } else {
            throw new XBProcessingException("End of data reached", XBProcessingExceptionType.UNEXPECTED_END_OF_STREAM);
        }
    }
}
