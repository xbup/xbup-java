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

import org.exbin.xbup.core.serial.XBSerialHandler;

/**
 * Interface for XBUP level 2 serialization handler using serialization
 * sequence.
 *
 * @version 0.1.24 2014/12/06
 * @author ExBin Project (http://exbin.org)
 */
public interface XBPSequenceSerialHandler extends XBSerialHandler, XBPSequencer {
}
