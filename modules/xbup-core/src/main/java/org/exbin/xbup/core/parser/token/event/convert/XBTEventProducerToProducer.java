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
package org.exbin.xbup.core.parser.token.event.convert;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import org.exbin.xbup.core.parser.basic.XBTListener;
import org.exbin.xbup.core.parser.basic.XBTProducer;
import org.exbin.xbup.core.parser.token.event.XBTEventProducer;

/**
 * Event producer To producer convertor for XBUP protocol level 1.
 *
 * @version 0.2.1 2017/06/05
 * @author ExBin Project (http://exbin.org)
 */
@ParametersAreNonnullByDefault
public class XBTEventProducerToProducer implements XBTProducer {

    @Nonnull
    private final XBTEventProducer eventProducer;

    public XBTEventProducerToProducer(XBTEventProducer eventProducer) {
        this.eventProducer = eventProducer;
    }

    @Override
    public void attachXBTListener(XBTListener eventListener) {
        eventProducer.attachXBTEventListener(new XBTListenerToEventListener(eventListener));
    }
}
