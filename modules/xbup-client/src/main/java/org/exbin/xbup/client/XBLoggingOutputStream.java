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
package org.exbin.xbup.client;

import java.io.IOException;
import java.io.OutputStream;
import javax.annotation.Nonnull;
import org.exbin.xbup.core.type.XBData;

/**
 * Output stream copying data to data logging blob.
 *
 * @version 0.2.1 2017/06/06
 * @author ExBin Project (http://exbin.org)
 */
public class XBLoggingOutputStream extends OutputStream {

    @Nonnull
    private final XBData data = new XBData();
    @Nonnull
    private final OutputStream targetOutputStream;

    public XBLoggingOutputStream(@Nonnull OutputStream targetOutputStream) {
        this.targetOutputStream = targetOutputStream;
    }

    @Override
    public void write(int bufferData) throws IOException {
        targetOutputStream.write(bufferData);
        long dataSize = data.getDataSize();
        data.insert(dataSize, 1);
        data.setByte(dataSize, (byte) bufferData);
    }

    @Override
    public void write(@Nonnull byte[] bufferData, int offset, int length) throws IOException {
        targetOutputStream.write(bufferData, offset, length);
        data.insert(data.getDataSize(), bufferData, offset, length);
    }

    @Override
    public void write(@Nonnull byte[] bufferData) throws IOException {
        targetOutputStream.write(bufferData);
        data.insert(data.getDataSize(), bufferData);
    }

    @Nonnull
    public XBData getData() {
        return data;
    }

}
