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
package org.exbin.xbup.core.parser.token;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import org.exbin.xbup.core.ubnumber.type.UBNat32;

/**
 * XBUP protocol level 1 attribute token.
 *
 * This class carry single UBNatural value.
 *
 * @version 0.2.1 2017/05/22
 * @author ExBin Project (http://exbin.org)
 */
@ParametersAreNonnullByDefault
public abstract class XBTAttributeToken implements XBTToken {

    @Nonnull
    public abstract XBAttribute getAttribute();

    /**
     * Returns true if this is attribute is zero.
     *
     * @return true if attribute is zero
     */
    public abstract boolean isZero();

    @Nonnull
    @Override
    public XBTTokenType getTokenType() {
        return XBTTokenType.ATTRIBUTE;
    }

    @Nonnull
    public static XBTAttributeToken create(XBAttribute attribute) {
        return new XBTAttributeTokenImpl(attribute);
    }

    @ParametersAreNonnullByDefault
    private static class XBTAttributeTokenImpl extends XBTAttributeToken {

        @Nonnull
        private final XBAttribute attribute;

        private XBTAttributeTokenImpl(XBAttribute attribute) {
            this.attribute = attribute;
        }

        @Nonnull
        @Override
        public XBAttribute getAttribute() {
            return attribute;
        }

        @Override
        public boolean isZero() {
            return attribute.isNaturalZero();
        }

        @Nonnull
        @Override
        public XBTTokenType getTokenType() {
            return XBTTokenType.ATTRIBUTE;
        }
    }

    @Nullable
    private static XBTZeroAttributeToken instance = null;

    @Nonnull
    public static XBTAttributeToken createZeroToken() {
        if (instance == null) {
            instance = new XBTZeroAttributeToken();
        }

        return instance;
    }

    @ParametersAreNonnullByDefault
    private static class XBTZeroAttributeToken extends XBTAttributeToken {

        private XBTZeroAttributeToken() {
        }

        @Nonnull
        @Override
        public XBAttribute getAttribute() {
            return new UBNat32();
        }

        @Override
        public boolean isZero() {
            return true;
        }
    }
}
