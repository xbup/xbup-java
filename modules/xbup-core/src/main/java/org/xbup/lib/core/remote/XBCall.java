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
package org.xbup.lib.core.remote;

import java.io.IOException;
import org.xbup.lib.core.parser.XBProcessingException;
import org.xbup.lib.core.parser.basic.XBTListener;
import org.xbup.lib.core.stream.XBTStreamChecker;

/**
 * XBUP level 1 RPC procedure call interface.
 *
 * @version 0.1.24 2014/10/20
 * @author XBUP Project (http://xbup.org)
 */
public interface XBCall {

    /**
     * Performs remote invocation/calling of given procedure.
     *
     * Position in source is after block type.
     *
     * TODO: Add status handling (may include exceptions)
     * 
     * @param source
     * @param result
     * @return
     * @throws XBProcessingException
     * @throws IOException 
     */
    public XBProcedureStatus call(XBTStreamChecker source, XBTListener result) throws XBProcessingException, IOException;
}
