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
package org.xbup.lib.core.serial.param;

import org.xbup.lib.core.serial.sequence.XBTSequenceListSerializable;
import org.xbup.lib.core.serial.sequence.XBTSequenceIListSerializable;
import org.xbup.lib.core.serial.sequence.XBSerialSequence;
import org.xbup.lib.core.serial.sequence.XBListConsistSerializable;
import org.xbup.lib.core.serial.sequence.XBListJoinSerializable;
import org.xbup.lib.core.serial.sequence.XBSerialSequenceItem;
import org.xbup.lib.core.serial.child.XBTChildListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xbup.lib.core.block.XBBlockType;
import org.xbup.lib.core.parser.XBProcessingException;
import org.xbup.lib.core.block.XBBlockTerminationMode;
import org.xbup.lib.core.parser.XBProcessingExceptionType;
import org.xbup.lib.core.parser.token.XBTToken;
import org.xbup.lib.core.parser.token.XBTTokenType;
import org.xbup.lib.core.parser.token.event.XBTEventListener;
import org.xbup.lib.core.serial.XBSerializable;
import org.xbup.lib.core.serial.XBTWriteSerialHandler;
import org.xbup.lib.core.serial.token.XBTTokenOutputSerialHandler;
import org.xbup.lib.core.serial.child.XBTChildListenerSerialHandler;
import org.xbup.lib.core.serial.child.XBTChildSerializable;
import org.xbup.lib.core.ubnumber.UBENatural;
import org.xbup.lib.core.ubnumber.UBNatural;
import org.xbup.lib.core.ubnumber.type.UBNat32;

/**
 * XBUP level 1 serialization handler using serialization sequence parser
 * mapping to token listener.
 *
 * @version 0.1.24 2014/12/16
 * @author XBUP Project (http://xbup.org)
 */
public class XBTSequenceListenerSerialHandler implements XBTSequenceSerialHandler, XBTSequenceOutputSerialHandler, XBTTokenOutputSerialHandler {

    private final XBTChildListenerSerialHandler listener;
    private XBTWriteSerialHandler childHandler = null;
    private XBTEventListener eventListener;

    public XBTSequenceListenerSerialHandler() {
        listener = new XBTChildListenerSerialHandler();
    }

    public XBTSequenceListenerSerialHandler(XBTWriteSerialHandler childHandler) {
        listener = new XBTChildListenerSerialHandler(childHandler);
        this.childHandler = childHandler;
    }

    @Override
    public void attachXBTEventListener(XBTEventListener eventListener) {
        this.eventListener = eventListener;
        listener.attachXBTEventListener(eventListener);
    }

    public XBSerializationMode getSerializationMode() {
        return XBSerializationMode.PUSH;
    }

    public void begin() throws XBProcessingException, IOException {
        putBegin(XBBlockTerminationMode.SIZE_SPECIFIED);
    }

    public void end() throws XBProcessingException, IOException {
        putEnd();
    }

    public void matchType(XBBlockType blockType) throws XBProcessingException, IOException {
        putType(blockType);
    }

    public void attribute(UBNatural attributeValue) throws XBProcessingException, IOException {
        putAttribute(attributeValue);
    }

    public void child(XBSerializable child) throws XBProcessingException, IOException {
        putChild(child);
    }

    public void append(XBSerializable child) throws XBProcessingException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void matchChild(XBSerializable child) throws XBProcessingException, IOException {
        putChild(child);
    }

    @Override
    public void putBegin(XBBlockTerminationMode terminationMode) throws XBProcessingException, IOException {
        listener.putBegin(terminationMode);
    }

    @Override
    public void putType(XBBlockType type) throws XBProcessingException, IOException {
        listener.putType(type);
    }

    @Override
    public void putAttribute(UBNatural attribute) throws XBProcessingException, IOException {
        listener.putAttribute(attribute);
    }

    @Override
    public void putAttribute(byte attributeValue) throws XBProcessingException, IOException {
        listener.putAttribute(attributeValue);
    }

    @Override
    public void putAttribute(short attributeValue) throws XBProcessingException, IOException {
        listener.putAttribute(attributeValue);
    }

    @Override
    public void putAttribute(int attributeValue) throws XBProcessingException, IOException {
        listener.putAttribute(attributeValue);
    }

    @Override
    public void putAttribute(long attributeValue) throws XBProcessingException, IOException {
        listener.putAttribute(attributeValue);
    }

    public void putChild(XBSerializable child) throws XBProcessingException, IOException {
        listener.putChild(child);
    }

    public void putAppend(XBSerializable serial) throws XBProcessingException, IOException {
        listener.putAppend(serial);
    }

    @Override
    public void putData(InputStream data) throws XBProcessingException, IOException {
        listener.putData(data);
    }

    @Override
    public void putEnd() throws XBProcessingException, IOException {
        listener.putEnd();
    }

    @Override
    public XBBlockTerminationMode pullBegin() throws XBProcessingException, IOException {
        throw new XBProcessingException("Pulling data not allowed in pushing mode", XBProcessingExceptionType.ILLEGAL_OPERATION);
    }

    @Override
    public XBBlockType pullType() throws XBProcessingException, IOException {
        throw new XBProcessingException("Pulling data not allowed in pushing mode", XBProcessingExceptionType.ILLEGAL_OPERATION);
    }

    @Override
    public UBNatural pullAttribute() throws XBProcessingException, IOException {
        throw new XBProcessingException("Pulling data not allowed in pushing mode", XBProcessingExceptionType.ILLEGAL_OPERATION);
    }

    @Override
    public byte pullByteAttribute() throws XBProcessingException, IOException {
        throw new XBProcessingException("Pulling data not allowed in pushing mode", XBProcessingExceptionType.ILLEGAL_OPERATION);
    }

    @Override
    public short pullShortAttribute() throws XBProcessingException, IOException {
        throw new XBProcessingException("Pulling data not allowed in pushing mode", XBProcessingExceptionType.ILLEGAL_OPERATION);
    }

    @Override
    public int pullIntAttribute() throws XBProcessingException, IOException {
        throw new XBProcessingException("Pulling data not allowed in pushing mode", XBProcessingExceptionType.ILLEGAL_OPERATION);
    }

    @Override
    public long pullLongAttribute() throws XBProcessingException, IOException {
        throw new XBProcessingException("Pulling data not allowed in pushing mode", XBProcessingExceptionType.ILLEGAL_OPERATION);
    }

    public void pullChild(XBSerializable child) throws XBProcessingException, IOException {
        throw new XBProcessingException("Pulling data not allowed in pushing mode", XBProcessingExceptionType.ILLEGAL_OPERATION);
    }

    public void pullAppend(XBSerializable serial) throws XBProcessingException, IOException {
        throw new XBProcessingException("Pulling data not allowed in pushing mode", XBProcessingExceptionType.ILLEGAL_OPERATION);
    }

    @Override
    public InputStream pullData() throws XBProcessingException, IOException {
        throw new XBProcessingException("Pulling data not allowed in pushing mode", XBProcessingExceptionType.ILLEGAL_OPERATION);
    }

    @Override
    public void pullEnd() throws XBProcessingException, IOException {
        throw new XBProcessingException("Pulling data not allowed in pushing mode", XBProcessingExceptionType.ILLEGAL_OPERATION);
    }

    public void appendSequence(XBSerialSequence sequence) throws XBProcessingException, IOException {
        listener.putBegin(sequence.getTerminationMode());
        listener.putType(sequence.getBlockType());

        List<XBSerializable> params = new ArrayList<>();
        serializeToXBSequence(sequence, listener, params);
        for (Iterator<XBSerializable> it = params.iterator(); it.hasNext();) {
            listener.putChild(it.next());
        }
        listener.putEnd();
    }

    public void serializeToXBSequence(XBSerialSequence sequence, XBTChildListener serial, List<XBSerializable> params) throws XBProcessingException, IOException {
        for (XBSerialSequenceItem item : sequence.getItems()) {
            switch (item.getSequenceOp()) {
                case JOIN: {
                    if (item.getItem() instanceof XBSerialSequence) {
                        serializeToXBSequence((XBSerialSequence) item.getItem(), serial, params);
                    } else {
                        // TODO process serial methods
                        // XBSerialMethod serialMethod = item.getItem().getSerializationMethods(XBSerializationType.TO_XB);
                        //if (serialMethod instanceof XBTSerialMethodStream) {
                        if (item.getItem() instanceof XBTChildSerializable) {
                            // TODO
                            /* XBJoinOutputSerial joinSerial = new XBJoinOutputSerial(serial, params);
                             joinSerial.attachXBTEventListener(eventListener);
                             ((XBTChildSerializable) item.getItem()).serializeToXB(joinSerial); */
                        } else if (item.getItem() instanceof XBTSequenceSerializable) {
                            XBTSequenceListenerSerialHandler serialHandler = new XBTSequenceListenerSerialHandler();
                            serialHandler.attachXBTEventListener(eventListener);
                            ((XBTSequenceSerializable) item.getItem()).serializeXB(serialHandler);
                        } else {
                            throw new UnsupportedOperationException("Not supported yet.");
                        }

                        //} else if (serialMethod instanceof XBTSerialSequenceListenerMethod) {
                        //    throw new UnsupportedOperationException("Not supported yet.");
                        //} else {
                        //    throw new XBProcessingException("Unknown serialization object");
                        //}
                    }
                    break;
                }
                case CONSIST: {
                    params.add(item.getItem());
                    break;
                }
                case LIST_JOIN: {
                    XBListJoinSerializable list = (XBListJoinSerializable) item.getItem();
                    UBNatural count = list.getSize();
                    serial.putAttribute(count);
                    params.add(new XBTSequenceListSerializable(list));
                    break;
                }
                case LIST_CONSIST: {
                    XBListConsistSerializable list = (XBListConsistSerializable) item.getItem();
                    UBENatural count = list.getSize();
                    serial.putAttribute(new UBNat32(count.getLong()));
                    params.add(new XBTSequenceIListSerializable(list));
                    break;
                }
            }
        }
    }

    @Override
    public void join(XBSerializable child) throws XBProcessingException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void putToken(XBTToken token) throws XBProcessingException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void putConsist(XBSerializable serial) throws XBProcessingException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void putJoin(XBSerializable serial) throws XBProcessingException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void putListConsist(XBSerializable serial) throws XBProcessingException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void putListJoin(XBSerializable serial) throws XBProcessingException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void putItem(XBSerialSequenceItem item) throws XBProcessingException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public XBTToken pullToken(XBTTokenType tokenType) throws XBProcessingException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void pullConsist(XBSerializable child) throws XBProcessingException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void pullJoin(XBSerializable serial) throws XBProcessingException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void pullListConsist(XBSerializable child) throws XBProcessingException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void pullListJoin(XBSerializable serial) throws XBProcessingException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void pullItem(XBSerialSequenceItem item) throws XBProcessingException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
