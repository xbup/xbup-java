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

import javax.annotation.ParametersAreNonnullByDefault;
import org.exbin.xbup.core.catalog.base.XBCBlockRev;
import org.exbin.xbup.core.catalog.base.XBCGroupCons;
import org.exbin.xbup.core.catalog.base.XBCSpec;

/**
 * Interface for group consist entity.
 *
 * @version 0.2.1 2020/08/13
 * @author ExBin Project (http://exbin.org)
 */
@ParametersAreNonnullByDefault
public interface XBMGroupCons extends XBCGroupCons, XBMConsDef {

    /**
     * Sets owner which is also specification.
     *
     * @param spec XBCGroupSpec group specification
     */
    @Override
    void setSpec(XBCSpec spec);

    /**
     * Sets target specification.
     *
     * @param targetRev block revision, never empty
     */
    void setTarget(XBCBlockRev targetRev);
}
