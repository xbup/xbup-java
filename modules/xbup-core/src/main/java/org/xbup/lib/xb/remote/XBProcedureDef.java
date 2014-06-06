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
package org.xbup.lib.xb.remote;

import org.xbup.lib.xb.block.XBBlockType;
import org.xbup.lib.xb.block.declaration.XBBlockDecl;

/**
 * XBUP level 1 RPC procedure definition interface.
 *
 * @version 0.1 wr21.0 2011/10/30
 * @author XBUP Project (http://xbup.org)
 */
public interface XBProcedureDef {

    /**
     * Return type of this procedure.
     * 
     * @return Type of this procedure.
     */
    public XBBlockType getType();

    /**
     * Return type of input data parameter.
     * 
     * @return Declaration of input type.
     */
    public XBBlockDecl getParameterType();

    /**
     * Return type of output data returned as result.
     * 
     * @return Declaration of output type.
     */
    public XBBlockDecl getReturnType();

    /**
     * Return type of status data for reporting proper execution or exception.
     * 
     * @return Declaration of execution status type.
     */
    public XBBlockDecl getStatusType();
}
