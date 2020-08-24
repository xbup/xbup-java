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
package org.exbin.xbup.catalog.entity;

import java.io.Serializable;
import javax.annotation.Nonnull;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import org.exbin.xbup.catalog.modifiable.XBMJoinDef;
import org.exbin.xbup.core.block.definition.XBParamType;
import org.exbin.xbup.core.catalog.base.XBCSpec;

/**
 * Join database database entity.
 *
 * @version 0.1.22 2013/01/11
 * @author ExBin Project (http://exbin.org)
 */
@Entity(name = "XBJoinDef")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class XBEJoinDef extends XBESpecDef implements Serializable, XBMJoinDef {

    public XBEJoinDef() {
    }

    @Nonnull
    @Override
    public XBCSpec getSpec() {
        return (XBCSpec) super.getSpec();
    }

    @Nonnull
    @Override
    public XBParamType getType() {
        return XBParamType.JOIN;
    }
}
