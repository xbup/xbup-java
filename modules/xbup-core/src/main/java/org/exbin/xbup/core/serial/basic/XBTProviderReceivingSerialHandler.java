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
package org.exbin.xbup.core.serial.basic;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import org.exbin.xbup.core.parser.basic.XBTListener;
import org.exbin.xbup.core.parser.basic.XBTProvider;
import org.exbin.xbup.core.parser.basic.convert.XBTListenerToConsumer;

/**
 * XBUP level 1 serialization handler using basic parser mapping to provider.
 *
 * @version 0.2.1 2017/05/16
 * @author ExBin Project (http://exbin.org)
 */
@ParametersAreNonnullByDefault
public class XBTProviderReceivingSerialHandler implements XBTBasicInputReceivingSerialHandler {

    @Nullable
    private XBTProvider provider = null;

    public XBTProviderReceivingSerialHandler() {
    }

    public void attachXBTProvider(XBTProvider provider) {
        this.provider = provider;
    }

    @Override
    public void process(XBTListener listener) {
        if (provider == null) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        new XBTListenerToConsumer(listener).attachXBTProvider(provider);
    }
}
