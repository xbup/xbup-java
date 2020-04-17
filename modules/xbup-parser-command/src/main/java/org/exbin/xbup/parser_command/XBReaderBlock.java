/*
 * Copyright (C) ExBin Project
 *
 * This application or library is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * This application or library is distributed in the hope that it will be
 * useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along this application.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.exbin.xbup.parser_command;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.exbin.auxiliary.paged_data.BinaryData;
import org.exbin.xbup.core.block.XBBlock;
import org.exbin.xbup.core.block.XBBlockDataMode;
import org.exbin.xbup.core.block.XBBlockTerminationMode;
import org.exbin.xbup.core.parser.XBProcessingException;
import org.exbin.xbup.core.parser.token.XBAttribute;
import org.exbin.xbup.core.ubnumber.UBNatural;

/**
 * XBUP level 0 command reader block.
 *
 * @version 0.2.0 2016/05/24
 * @author ExBin Project (http://exbin.org)
 */
public class XBReaderBlock implements XBCommandBlock, XBBlock, Closeable {

    private final long[] blockPath;
    private final XBReader reader;

    public XBReaderBlock(XBReader reader, long[] blockPath) {
        this.blockPath = blockPath;
        this.reader = reader;
    }

    @Nonnull
    @Override
    public Optional<XBBlock> getParentBlock() {
        if (blockPath.length == 0) {
            return Optional.empty();
        } else {
            return reader.getBlock(Arrays.copyOf(blockPath, blockPath.length - 1));
        }
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof XBReaderBlock) {
            Arrays.equals(((XBReaderBlock) obj).blockPath, blockPath);
        }

        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Arrays.hashCode(this.blockPath);
        return hash;
    }

    @Nonnull
    @Override
    public long[] getBlockPath() {
        return blockPath;
    }

    @Nonnull
    @Override
    public XBBlockDataMode getDataMode() {
        try {
            reader.seekBlock(this);
            return reader.getBlockDataMode();
        } catch (XBProcessingException | IOException ex) {
            return null;
        }
    }

    @Nonnull
    @Override
    public XBBlockTerminationMode getTerminationMode() {
        try {
            reader.seekBlock(this);
            return reader.getBlockTerminationMode();
        } catch (XBProcessingException | IOException ex) {
            return null;
        }
    }

    @Override
    public XBAttribute[] getAttributes() {
        try {
            reader.seekBlock(this);
        } catch (XBProcessingException | IOException ex) {
            return null;
        }

        List<XBAttribute> attributes = new ArrayList<>();
        int attributeIndex = 0;
        XBAttribute blockAttribute;
        do {
            try {
                blockAttribute = reader.getBlockAttribute(attributeIndex);
            } catch (XBProcessingException | IOException ex) {
                blockAttribute = null;
            }
            if (blockAttribute != null) {
                attributes.add(blockAttribute);
                attributeIndex++;
            }
        } while (blockAttribute != null);

        return attributes.toArray(new XBAttribute[0]);
    }

    @Override
    public UBNatural getAttributeAt(int attributeIndex) {
        try {
            reader.seekBlock(this);
        } catch (XBProcessingException | IOException ex) {
            return null;
        }

        XBAttribute blockAttribute = null;
        try {
            blockAttribute = reader.getBlockAttribute(attributeIndex);
        } catch (XBProcessingException | IOException ex) {
            Logger.getLogger(XBReaderBlock.class.getName()).log(Level.SEVERE, null, ex);
        }
        return blockAttribute == null ? null : blockAttribute.convertToNatural();
    }

    @Override
    public int getAttributesCount() {
        try {
            reader.seekBlock(this);
            return reader.getBlockAttributesCount();
        } catch (XBProcessingException | IOException ex) {
            return 0;
        }
    }

    @Override
    public XBBlock[] getChildren() {
        int childrenCount = getChildrenCount();
        XBBlock[] result = new XBBlock[childrenCount];
        for (int i = 0; i < result.length; i++) {
            long[] childPath = Arrays.copyOf(blockPath, blockPath.length + 1);
            childPath[childPath.length - 1] = i;
            result[i] = new XBReaderBlock(reader, childPath);
        }
        return result;
    }

    @Override
    public XBBlock getChildAt(int childIndex) {
        try {
            if (reader.hasBlockChildAt(childIndex)) {
                long[] childPath = Arrays.copyOf(blockPath, blockPath.length + 1);
                childPath[childPath.length - 1] = childIndex;
                return new XBReaderBlock(reader, childPath);
            }
        } catch (XBProcessingException | IOException ex) {
        }

        return null;
    }

    @Override
    public int getChildrenCount() {
        try {
            reader.seekBlock(this);
            return reader.getBlockChildrenCount();
        } catch (XBProcessingException | IOException ex) {
            return 0;
        }
    }

    @Override
    public InputStream getData() {
        try {
            reader.seekBlock(this);
            return reader.getBlockData();
        } catch (XBProcessingException | IOException ex) {
            throw new IllegalStateException("Unable to acquire data", ex);
        }
    }

    @Override
    public void close() throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Nonnull
    @Override
    public BinaryData getBlockData() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
