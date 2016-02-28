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
package org.xbup.lib.core.stream;

import java.io.IOException;

/**
 * Interface for stream with method for finishing detection.
 *
 * @version 0.1.25 2015/02/14
 * @author ExBin Project (http://exbin.org)
 */
public interface XBFinishedStream {

    /**
     * Returns true if stream ended.
     *
     * @return true if stream ended
     * @throws IOException if unable to determine stream end
     */
    public boolean isFinishedXB() throws IOException;
}
