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
package org.xbup.lib.xb.block.declaration;

import java.util.Map;
import org.xbup.lib.xb.parser.basic.XBTConsumer;
import org.xbup.lib.xb.parser.basic.XBTProducer;

/**
 * Status context representation.
 *
 * @version 0.1 wr19.0 2010/06/02
 * @author XBUP Project (http://xbup.org)
 */
public interface XBStatusContext extends XBTProducer, XBTConsumer { // extends XBContext

    public Map<Integer,Integer> getLevelLimits();

    public int getCurrentLevel();
}
