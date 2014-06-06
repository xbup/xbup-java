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
package org.xbup.lib.xb.parser.basic.wrapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * Input stream wrapper for extended area.
 *
 * @version 0.1 wr23.0 2014/01/06
 * @author XBUP Project (http://xbup.org)
 */
public class ExtendedAreaInputStreamWrapper extends InputStream {

    private final InputStream source;

    public ExtendedAreaInputStreamWrapper(final InputStream source) {
        this.source = source;
    }

    @Override
    public int read() throws IOException {
        return source.read();
    }

    @Override
    public int available() throws IOException {
        return source.available();
    }

    @Override
    public void close() throws IOException {
        source.close();
    }

    @Override
    public int read(byte[] b) throws IOException {
        return source.read(b);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return source.read(b, off, len);
    }

    @Override
    public synchronized void reset() throws IOException {
    }

    @Override
    public long skip(long n) throws IOException {
        return source.skip(n);
    }
}
