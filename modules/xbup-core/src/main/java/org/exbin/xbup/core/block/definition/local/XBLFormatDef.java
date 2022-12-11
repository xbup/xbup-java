/*
 * Copyright (C) ExBin Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.exbin.xbup.core.block.definition.local;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.exbin.xbup.core.block.XBBasicBlockType;
import org.exbin.xbup.core.block.XBBlockTerminationMode;
import org.exbin.xbup.core.block.XBBlockType;
import org.exbin.xbup.core.block.XBFixedBlockType;
import org.exbin.xbup.core.block.declaration.XBGroupDecl;
import org.exbin.xbup.core.block.definition.XBFormatDef;
import org.exbin.xbup.core.block.definition.XBFormatParam;
import org.exbin.xbup.core.block.definition.XBFormatParamConsist;
import org.exbin.xbup.core.block.definition.XBFormatParamJoin;
import org.exbin.xbup.core.block.definition.XBRevisionDef;
import org.exbin.xbup.core.block.definition.XBRevisionParam;
import org.exbin.xbup.core.parser.XBProcessingException;
import org.exbin.xbup.core.parser.XBProcessingExceptionType;
import org.exbin.xbup.core.parser.basic.XBTListener;
import org.exbin.xbup.core.parser.token.XBAttribute;
import org.exbin.xbup.core.serial.XBSerializable;
import org.exbin.xbup.core.serial.basic.XBReceivingFinished;
import org.exbin.xbup.core.serial.basic.XBTBasicInputReceivingSerialHandler;
import org.exbin.xbup.core.serial.basic.XBTBasicOutputReceivingSerialHandler;
import org.exbin.xbup.core.serial.basic.XBTBasicReceivingSerializable;
import org.exbin.xbup.core.serial.param.XBPInputSerialHandler;
import org.exbin.xbup.core.serial.param.XBPOutputSerialHandler;
import org.exbin.xbup.core.serial.param.XBPSequenceSerialHandler;
import org.exbin.xbup.core.serial.param.XBPSequenceSerializable;
import org.exbin.xbup.core.serial.param.XBPSerializable;
import org.exbin.xbup.core.serial.param.XBSerializationMode;
import org.exbin.xbup.core.serial.sequence.XBListConsistSerializable;
import org.exbin.xbup.core.ubnumber.UBENatural;
import org.exbin.xbup.core.ubnumber.type.UBENat32;

/**
 * XBUP level 1 local format definition.
 *
 * @author ExBin Project (https://exbin.org)
 */
public class XBLFormatDef implements XBFormatDef, XBPSequenceSerializable, XBTBasicReceivingSerializable {

    private List<XBFormatParam> formatParams = new ArrayList<>();
    private XBLRevisionDef revisionDef = null;

    public XBLFormatDef() {
    }

    public XBLFormatDef(XBGroupDecl groupDecl) {
        formatParams.add(new XBFormatParamConsist(groupDecl));
        revisionDef = new XBLRevisionDef();
        revisionDef.getRevParams().add(new XBRevisionParam(1));
    }

    public XBLFormatDef(XBLRevisionDef revisionDef) {
        this.revisionDef = revisionDef;
    }

    @Override
    public List<XBFormatParam> getFormatParams() {
        return formatParams;
    }

    public void setFormatParams(List<XBFormatParam> formats) {
        this.formatParams = formats;
    }

    @Override
    public XBRevisionDef getRevisionDef() {
        return revisionDef;
    }

    public void setRevisionDef(XBLRevisionDef revisionDef) {
        this.revisionDef = revisionDef;
    }

    @Override
    public long getParamsCount() {
        return formatParams.size();
    }

    @Override
    public XBFormatParam getFormatParam(int paramIndex) {
        return paramIndex < formatParams.size() ? formatParams.get(paramIndex) : null;
    }

    public void realignRevision() {
        revisionDef = new XBLRevisionDef();
        XBRevisionParam revisionParam = new XBRevisionParam();
        revisionParam.setParamCount(formatParams.size());
        revisionDef.getRevParams().add(revisionParam);
    }

    public void clear() {
        formatParams.clear();
        revisionDef = null;
    }

    @Override
    public void serializeXB(XBPSequenceSerialHandler serial) throws XBProcessingException, IOException {
        serial.begin();
        serial.matchType(new XBFixedBlockType(XBBasicBlockType.FORMAT_DEFINITION));
        if (serial.getSerializationMode() == XBSerializationMode.PULL) {
            revisionDef = new XBLRevisionDef();
            serial.join(revisionDef);
        } else {
            serial.join(revisionDef);
        }

        serial.listConsist(new XBListConsistSerializable() {

            private int position = 0;
            private boolean infinityMode = false;

            @Override
            public UBENatural getSize() {
                return new UBENat32(formatParams.size());
            }

            @Override
            public void setSize(UBENatural count) {
                if (count.isInfinity()) {
                    infinityMode = true;
                }

                formatParams.clear();
                if (!infinityMode) {
                    int size = count.getInt();
                    for (int i = 0; i < size; i++) {
                        formatParams.add(null);
                    }
                }
            }

            @Override
            public void reset() {
                position = 0;
            }

            @Override
            public XBSerializable next() {
                return new ParamSerializator(position++);
            }

            class ParamSerializator implements XBPSerializable {

                private int position = 0;

                public ParamSerializator(int position) {
                    this.position = position;
                }

                @Override
                public void serializeFromXB(XBPInputSerialHandler serializationHandler) throws XBProcessingException, IOException {
                    serializationHandler.begin();
                    XBBlockType type = serializationHandler.pullType();
                    XBFormatParam param = type.getAsBasicType() == XBBasicBlockType.FORMAT_CONSIST_PARAMETER ? new XBFormatParamConsist()
                            : type.getAsBasicType() == XBBasicBlockType.FORMAT_CONSIST_PARAMETER ? new XBFormatParamJoin() : null;
                    if (param == null) {
                        throw new IllegalStateException("Illegal format parameter " + position);
                    }
                    if (infinityMode) {
                        formatParams.add(null);
                    }
                    formatParams.set(position, param);
                    serializationHandler.join(param);
                    serializationHandler.end();
                }

                @Override
                public void serializeToXB(XBPOutputSerialHandler serializationHandler) throws XBProcessingException, IOException {
                    serializationHandler.append(formatParams.get(position));
                }
            }
        });
        serial.end();
    }

    private enum RecvProcessingState {

        START, BEGIN, TYPE, REVISION_DEF_SIZE, REVISION_DEF, FORMAT_PARAM_SIZE, FORMAT_PARAM_BEGIN, FORMAT_PARAM, END
    }

    @Override
    public void serializeRecvFromXB(XBTBasicInputReceivingSerialHandler serializationHandler) throws XBProcessingException, IOException {
        clear();
        serializationHandler.process(new RecvSerialization());
    }

    private class RecvSerialization implements XBTListener, XBReceivingFinished {

        private RecvProcessingState processingState = RecvProcessingState.START;
        private XBTListener activeListener = null;
        private XBTListener revisionDefListener = null;
        private int formatParamsPos = 0;
        private XBBlockTerminationMode formatParamTerminationMode;
        private int revisionDefPos = 0;
        private int revisionDefSize = 0;

        @Override
        public void beginXBT(XBBlockTerminationMode terminationMode) throws XBProcessingException, IOException {
            if (processingState == RecvProcessingState.FORMAT_PARAM_SIZE) {
                formatParamTerminationMode = terminationMode;
                formatParamsPos++;
                processingState = RecvProcessingState.FORMAT_PARAM_BEGIN;
            }

            if (activeListener != null) {
                activeListener.beginXBT(terminationMode);
                return;
            }

            if (processingState != RecvProcessingState.START) {
                throw new XBProcessingException("Unexpected token: begin", XBProcessingExceptionType.UNEXPECTED_ORDER);
            }

            processingState = RecvProcessingState.BEGIN;
        }

        @Override
        public void typeXBT(XBBlockType type) throws XBProcessingException, IOException {
            if (processingState == RecvProcessingState.FORMAT_PARAM_BEGIN) {
                XBTBasicReceivingSerializable param = type.getAsBasicType() == XBBasicBlockType.FORMAT_CONSIST_PARAMETER ? new XBFormatParamConsist()
                        : type.getAsBasicType() == XBBasicBlockType.FORMAT_CONSIST_PARAMETER ? new XBFormatParamJoin() : null;
                if (param == null) {
                    throw new IllegalStateException("Illegal format parameter " + formatParamsPos);
                }
                param.serializeRecvFromXB(new XBTBasicInputReceivingSerialHandler() {

                    @Override
                    public void process(XBTListener listener) {
                        activeListener = listener;
                    }
                });
                activeListener.beginXBT(formatParamTerminationMode);
                processingState = RecvProcessingState.FORMAT_PARAM;
            }

            if (activeListener != null) {
                activeListener.typeXBT(type);
                return;
            }

            if (processingState != RecvProcessingState.BEGIN) {
                throw new XBProcessingException("Unexpected token: type", XBProcessingExceptionType.UNEXPECTED_ORDER);
            }

            processingState = RecvProcessingState.TYPE;
        }

        @Override
        public void attribXBT(XBAttribute value) throws XBProcessingException, IOException {
            if (activeListener != null) {
                activeListener.attribXBT(value);
                return;
            }

            if (processingState == RecvProcessingState.TYPE) {
                revisionDefSize = value.getNaturalInt();
                revisionDefPos = 0;
                revisionDef = new XBLRevisionDef();
                revisionDef.serializeRecvFromXB(new XBTBasicInputReceivingSerialHandler() {

                    @Override
                    public void process(XBTListener listener) {
                        revisionDefListener = listener;
                    }
                });
                revisionDefListener.beginXBT(XBBlockTerminationMode.SIZE_SPECIFIED);
                revisionDefListener.typeXBT(new XBFixedBlockType(XBBasicBlockType.REVISION_DEFINITION));
                revisionDefListener.attribXBT(value);
                if (revisionDefSize == 0) {
                    revisionDefListener.endXBT();
                    processingState = RecvProcessingState.REVISION_DEF;
                } else {
                    processingState = RecvProcessingState.REVISION_DEF_SIZE;
                }
            } else if (processingState == RecvProcessingState.REVISION_DEF_SIZE) {
                revisionDefListener.attribXBT(value);
                revisionDefPos++;
                if (revisionDefPos == revisionDefSize) {
                    revisionDefListener.endXBT();
                    processingState = RecvProcessingState.REVISION_DEF;
                }
            } else if (processingState == RecvProcessingState.REVISION_DEF) {
                int size = value.getNaturalInt();
                for (int i = 0; i < size; i++) {
                    formatParams.add(null);
                }
                formatParamsPos = 0;
                processingState = size == 0 ? RecvProcessingState.FORMAT_PARAM : RecvProcessingState.FORMAT_PARAM_SIZE;
            } else {
                throw new XBProcessingException("Unexpected token: attribute", XBProcessingExceptionType.UNEXPECTED_ORDER);
            }
        }

        @Override
        public void dataXBT(InputStream data) throws XBProcessingException, IOException {
            if (activeListener != null) {
                activeListener.dataXBT(data);
                return;
            }

            throw new XBProcessingException("Unexpected token: data", XBProcessingExceptionType.UNEXPECTED_ORDER);
        }

        @Override
        public void endXBT() throws XBProcessingException, IOException {
            if (activeListener != null) {
                activeListener.endXBT();
                if (((XBReceivingFinished) activeListener).isFinished()) {
                    if (formatParamsPos == formatParams.size()) {
                        processingState = RecvProcessingState.FORMAT_PARAM;
                    } else {
                        activeListener = null;
                    }
                }

                return;
            }

            if (processingState == RecvProcessingState.START || processingState == RecvProcessingState.BEGIN || processingState == RecvProcessingState.END) {
                throw new XBProcessingException("Unexpected token: end", XBProcessingExceptionType.UNEXPECTED_ORDER);
            }

            processingState = RecvProcessingState.END;
        }

        @Override
        public boolean isFinished() {
            return processingState == RecvProcessingState.END;
        }
    }

    @Override
    public void serializeRecvToXB(XBTBasicOutputReceivingSerialHandler serializationHandler) throws XBProcessingException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
