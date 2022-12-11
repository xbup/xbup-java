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
package org.exbin.xbup.core.serial.token;

import javax.annotation.ParametersAreNonnullByDefault;
import org.exbin.xbup.core.parser.token.event.XBTEventListener;
import org.exbin.xbup.core.serial.XBOutputSerialHandler;

/**
 * Interface for XBUP level 1 serialization output handler using token parser.
 *
 * @author ExBin Project (https://exbin.org)
 */
@ParametersAreNonnullByDefault
public interface XBTTokenOutputSerialHandler extends XBOutputSerialHandler {

    /**
     * Attaches event listener to be used as target for serialization.
     *
     * @param listener listener
     */
    void attachXBTEventListener(XBTEventListener listener);
}
