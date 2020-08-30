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
package org.exbin.xbup.core.serial.param;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.exbin.xbup.core.block.XBBlockTerminationMode;
import org.exbin.xbup.core.block.XBBlockType;
import org.exbin.xbup.core.parser.XBProcessingException;
import org.exbin.xbup.core.parser.XBProcessingExceptionType;
import org.exbin.xbup.core.parser.token.XBAttribute;
import org.exbin.xbup.core.parser.token.XBTAttributeToken;
import org.exbin.xbup.core.parser.token.XBTBeginToken;
import org.exbin.xbup.core.parser.token.XBTDataToken;
import org.exbin.xbup.core.parser.token.XBTEndToken;
import org.exbin.xbup.core.parser.token.XBTToken;
import org.exbin.xbup.core.parser.token.XBTTypeToken;
import org.exbin.xbup.core.serial.XBSerializable;
import org.exbin.xbup.core.serial.sequence.XBSerialSequenceItem;
import org.exbin.xbup.core.serial.sequence.XBSerialSequenceOp;
import org.exbin.xbup.core.ubnumber.type.UBNat32;

/**
 * Level 2 event listener for performing block building using sequence
 * operations.
 *
 * @version 0.2.1 2020/08/30
 * @author ExBin Project (http://exbin.org)
 */
@ParametersAreNonnullByDefault
public class XBPSerialSequence implements XBPListener {

    private final List<XBSerialSequenceItem> items = new ArrayList<>();
    private int depth = 0;

    public XBPSerialSequence() {
    }

    private void checkStarted() {
        if (depth == 0) {
            throw new XBProcessingException("Unexpected serialization event when sequencing", XBProcessingExceptionType.WRITING_AFTER_END);
        }
    }

    @Override
    public void putBegin(XBBlockTerminationMode terminationMode) throws XBProcessingException, IOException {
        depth++;
        items.add(new XBSerialSequenceItem(XBSerialSequenceOp.TOKEN, new XBPTokenWrapper(XBTBeginToken.create(terminationMode))));
    }

    @Override
    public void putType(XBBlockType type) throws XBProcessingException, IOException {
        checkStarted();
        items.add(new XBSerialSequenceItem(XBSerialSequenceOp.TOKEN, new XBPTokenWrapper(XBTTypeToken.create(type))));
    }

    @Override
    public void putAttribute(XBAttribute attribute) throws XBProcessingException, IOException {
        checkStarted();
        items.add(new XBSerialSequenceItem(XBSerialSequenceOp.TOKEN, new XBPTokenWrapper(XBTAttributeToken.create(attribute))));
    }

    @Override
    public void putAttribute(byte attributeValue) throws XBProcessingException, IOException {
        checkStarted();
        putAttribute(new UBNat32(attributeValue));
    }

    @Override
    public void putAttribute(short attributeValue) throws XBProcessingException, IOException {
        checkStarted();
        putAttribute(new UBNat32(attributeValue));
    }

    @Override
    public void putAttribute(int attributeValue) throws XBProcessingException, IOException {
        checkStarted();
        putAttribute(new UBNat32(attributeValue));
    }

    @Override
    public void putAttribute(long attributeValue) throws XBProcessingException, IOException {
        checkStarted();
        putAttribute(new UBNat32(attributeValue));
    }

    @Override
    public void putData(InputStream data) throws XBProcessingException, IOException {
        checkStarted();
        items.add(new XBSerialSequenceItem(XBSerialSequenceOp.TOKEN, new XBPTokenWrapper(XBTDataToken.create(data))));
    }

    @Override
    public void putEnd() throws XBProcessingException, IOException {
        checkStarted();
        items.add(new XBSerialSequenceItem(XBSerialSequenceOp.TOKEN, new XBPTokenWrapper(XBTEndToken.create())));
        depth--;
    }

    @Override
    public void putToken(XBTToken token) throws XBProcessingException, IOException {
        putItem(new XBSerialSequenceItem(XBSerialSequenceOp.TOKEN, new XBPTokenWrapper(token)));
    }

    @Override
    public void putConsist(XBSerializable serial) throws XBProcessingException, IOException {
        checkStarted();
        items.add(new XBSerialSequenceItem(XBSerialSequenceOp.CONSIST, serial));
    }

    @Override
    public void putJoin(XBSerializable serial) throws XBProcessingException, IOException {
        checkStarted();
        items.add(new XBSerialSequenceItem(XBSerialSequenceOp.JOIN, serial));
    }

    @Override
    public void putListConsist(XBSerializable serial) throws XBProcessingException, IOException {
        checkStarted();
        items.add(new XBSerialSequenceItem(XBSerialSequenceOp.LIST_CONSIST, serial));
    }

    @Override
    public void putListJoin(XBSerializable serial) throws XBProcessingException, IOException {
        checkStarted();
        items.add(new XBSerialSequenceItem(XBSerialSequenceOp.LIST_JOIN, serial));
    }

    @Override
    public void putItem(XBSerialSequenceItem item) throws XBProcessingException, IOException {
        if (item.getSequenceOp() == XBSerialSequenceOp.TOKEN) {
            switch (((XBPTokenWrapper) item.getItem()).getToken().getTokenType()) {
                case BEGIN: {
                    depth++;
                    break;
                }
                case END: {
                    checkStarted();
                    depth--;
                    break;
                }
                default: {
                    checkStarted();
                }
            }

            items.add(item);
        } else {
            checkStarted();
            items.add(item);
        }
    }

    @Override
    public void putAppend(XBSerializable serial) throws XBProcessingException, IOException {
        throw new IllegalStateException("Append is not allowed on sequencing");
    }

    public void passSequence(XBPOutputSerialHandler serializationHandler) throws XBProcessingException, IOException {
        for (XBSerialSequenceItem serialItem : items) {
            serializationHandler.putItem(serialItem);
        }
    }

    public int getDepth() {
        return depth;
    }

    public boolean isClosed() {
        return depth == 0;
    }
}
