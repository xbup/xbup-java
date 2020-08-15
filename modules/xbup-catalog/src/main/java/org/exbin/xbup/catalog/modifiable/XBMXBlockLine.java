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
package org.exbin.xbup.catalog.modifiable;

import org.exbin.xbup.core.catalog.base.XBCBlockRev;
import org.exbin.xbup.core.catalog.base.XBCXBlockLine;
import org.exbin.xbup.core.catalog.base.XBCXPlugLine;

/**
 * Interface for block line editor catalog entity.
 *
 * @version 0.2.1 2020/08/14
 * @author ExBin Project (http://exbin.org)
 */
public interface XBMXBlockLine extends XBCXBlockLine, XBMBase {

    /**
     * Sets relevant specification.
     *
     * @param revision block revision
     */
    void setBlockRev(XBCBlockRev revision);

    /**
     * Sets line editor.
     *
     * @param line line editor
     */
    void setLine(XBCXPlugLine line);

    /**
     * Sets priority.
     *
     * @param priority priority
     */
    void setPriority(long priority);
}
