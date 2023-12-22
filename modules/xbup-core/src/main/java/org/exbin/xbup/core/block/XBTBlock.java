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
package org.exbin.xbup.core.block;

import java.io.InputStream;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.exbin.auxiliary.binary_data.BinaryData;
import org.exbin.xbup.core.parser.token.XBAttribute;

/**
 * Interface for read access to XBUP level 1 block.
 *
 * @author ExBin Project (https://exbin.org)
 */
public interface XBTBlock {

    /**
     * Gets parent block or null if block has no parent.
     *
     * @return parent block
     */
    @Nonnull
    Optional<XBTBlock> getParentBlock();

    /**
     * Returns whether this block is using sequence of children ended with
     * termination block.
     *
     * @return terminated mode
     */
    @Nonnull
    XBBlockTerminationMode getTerminationMode();

    /**
     * Returns whether this block is data block.
     *
     * @return data mode
     */
    @Nonnull
    XBBlockDataMode getDataMode();

    /**
     * Gets block type.
     *
     * @return block type
     */
    @Nonnull
    XBBlockType getBlockType();

    /**
     * Gets array of attributes in order of appearance.
     *
     * @return array of attributes
     */
    @Nullable
    XBAttribute[] getAttributes();

    /**
     * Gets attribute of given index.
     *
     * Returns zero if attribute index greater than attributes count.
     *
     * @param attributeIndex index of attribute
     * @return attribute value
     */
    @Nullable
    XBAttribute getAttributeAt(int attributeIndex);

    /**
     * Gets count of attributes.
     *
     * @return count of attributes
     */
    int getAttributesCount();

    /**
     * Gets array of all children.
     *
     * @return array of child blocks
     */
    @Nullable
    XBTBlock[] getChildren();

    /**
     * Gets children of given index.
     *
     * If no child for given index exist, return null.
     *
     * @param childIndex index of child block
     * @return child block
     */
    @Nullable
    XBTBlock getChildAt(int childIndex);

    /**
     * Gets count of children blocks.
     *
     * @return count of children
     */
    int getChildrenCount();

    /**
     * Gets block data.
     *
     * @return block data or throws invalid operation on non-data block
     */
    @Nonnull
    InputStream getData();

    /**
     * Gets block data.
     *
     * @return block data or throws invalid operation on non-data block
     */
    @Nonnull
    BinaryData getBlockData();
}
