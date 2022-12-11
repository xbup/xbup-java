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

import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import org.exbin.auxiliary.paged_data.BinaryData;
import org.exbin.xbup.core.parser.token.XBAttribute;

/**
 * Interface for editable XBUP level 1 block.
 *
 * @author ExBin Project (https://exbin.org)
 */
@ParametersAreNonnullByDefault
public interface XBTEditableBlock extends XBTBlock {

    /**
     * Sets parent block.
     *
     * @param parent block
     */
    void setParent(@Nullable XBTBlock parent);

    /**
     * Sets terminated mode.
     *
     * @param terminationMode terminated mode flag
     */
    void setTerminationMode(XBBlockTerminationMode terminationMode);

    /**
     * Sets data mode.
     *
     * @param dataMode data mode
     */
    void setDataMode(XBBlockDataMode dataMode);

    /**
     * Sets array of attributes in order of appearance.
     *
     * @param attributes array of attributes
     */
    void setAttributes(@Nullable XBAttribute[] attributes);

    /**
     * Sets attribute of given index.
     *
     * If index is greater than current count of attributes, new zero attributes
     * will be filled.
     *
     * @param attribute attribute value
     * @param attributeIndex attribute index
     */
    void setAttributeAt(XBAttribute attribute, int attributeIndex);

    /**
     * Sets count of attributes.
     *
     * List of attributes will be trimmed/extended with zero values.
     *
     * @param count count of attributes
     */
    void setAttributesCount(int count);

    /**
     * Removes attribute on given position.
     *
     * @param attributeIndex attribute index
     */
    void removeAttribute(int attributeIndex);

    /**
     * Sets block type.
     *
     * @param blockType block type
     */
    void setBlockType(XBBlockType blockType);

    /**
     * Sets array of all children.
     *
     * @param blocks array of blocks
     */
    void setChildren(@Nullable XBTBlock[] blocks);

    /**
     * This method instantiates new child node.
     *
     * @param childIndex child index
     * @return new instance of block
     */
    @Nonnull
    XBTBlock createNewChild(int childIndex);

    /**
     * Sets children of given index.
     *
     * If index is greater than current count of children, new empty blocks will
     * be filled.
     *
     * @param block child block
     * @param childIndex child index
     */
    void setChildAt(XBTBlock block, int childIndex);

    /**
     * Gets count of children.
     *
     * List of children will be trimmed/extended with empty blocks.
     *
     * @param count count of child blocks
     */
    void setChildrenCount(int count);

    /**
     * Removes child on given position.
     *
     * @param childIndex child index
     */
    void removeChild(int childIndex);

    /**
     * Sets block data.
     *
     * @param data data stream
     * @throws java.io.IOException if input/output error
     */
    void setData(@Nullable InputStream data) throws IOException;

    /**
     * Sets block data.
     *
     * @param data data stream
     */
    void setData(@Nullable BinaryData data);

    /**
     * Clears all data, attributes and child blocks.
     */
    void clear();
}
