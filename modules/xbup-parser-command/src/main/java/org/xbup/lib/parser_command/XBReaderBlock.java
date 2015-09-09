/*
 * Copyright (C) XBUP Project
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
package org.xbup.lib.parser_command;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.xbup.lib.core.block.XBBlock;
import org.xbup.lib.core.block.XBBlockData;
import org.xbup.lib.core.block.XBBlockDataMode;
import org.xbup.lib.core.block.XBBlockTerminationMode;
import org.xbup.lib.core.parser.token.XBAttribute;
import org.xbup.lib.core.ubnumber.UBNatural;

/**
 * XBUP level 0 command reader block.
 *
 * @version 0.1.23 2014/04/14
 * @author XBUP Project (http://xbup.org)
 */
public class XBReaderBlock implements XBBlock, Closeable {

    private final long[] blockPath;
    private final XBCommandReader reader;

    public XBReaderBlock(XBCommandReader reader, long[] blockPath) {
        this.blockPath = blockPath;
        this.reader = reader;
    }

    @Override
    public XBBlock getParent() {
        if (blockPath.length == 0) {
            return null;
        } else {
            return reader.getBlock(Arrays.copyOf(blockPath, blockPath.length - 1));
        }
    }

    @Override
    public XBBlockDataMode getDataMode() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public XBBlockTerminationMode getTerminationMode() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public XBAttribute[] getAttributes() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public UBNatural getAttributeAt(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getAttributesCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public XBBlock[] getChildren() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public XBBlock getChildAt(int childIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getChildrenCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public InputStream getData() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public long getDataSize() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public long getBlockSize() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void close() throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public XBBlockData getBlockData() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getBlockIndex() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
