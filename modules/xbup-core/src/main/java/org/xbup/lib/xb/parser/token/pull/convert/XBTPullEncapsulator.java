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
package org.xbup.lib.xb.parser.token.pull.convert;

import java.io.IOException;
import java.io.InputStream;
import org.xbup.lib.xb.block.XBBlockType;
import org.xbup.lib.xb.block.XBFixedBlockType;
import org.xbup.lib.xb.block.declaration.XBContext;
import org.xbup.lib.xb.parser.XBProcessingException;
import org.xbup.lib.xb.parser.basic.XBTConsumer;
import org.xbup.lib.xb.parser.basic.XBTFilter;
import org.xbup.lib.xb.parser.basic.XBTListener;
import org.xbup.lib.xb.parser.basic.XBTProducer;
import org.xbup.lib.xb.parser.basic.XBTProvider;
import org.xbup.lib.xb.block.XBBlockTerminationMode;
import org.xbup.lib.xb.ubnumber.UBNatural;

/**
 * XB Event Stream Encapsulation Filter
 * TODO: Upgrade for pull processing
 *
 * @version 0.1 wr19.0 2010/06/01
 * @author XBUP Project (http://xbup.org)
 */
public class XBTPullEncapsulator implements XBTFilter, XBTProducer, XBTConsumer {

    private XBTListener listener;
    private XBTProvider declProvider;
    private XBContext context;
    private long counter;

    /** Creates a new instance of XBTEncapsulator */
    public XBTPullEncapsulator(XBContext context) {
        this.context = context;
        declProvider = context.getDeclaration().convertToXBT();
        listener = null;
        counter = 0;
    }

    public XBTPullEncapsulator(XBContext context, XBTListener target) {
        this(context);
        attachXBTListener(target);
    }

    @Override
    public void beginXBT(XBBlockTerminationMode terminationMode) throws XBProcessingException, IOException {
        listener.beginXBT(terminationMode);
        counter++;
    }

    @Override
    public void typeXBT(XBBlockType type) throws XBProcessingException, IOException {
        XBFixedBlockType result = getContext().toStaticType(type);
        if (result == null) {
            result = new XBFixedBlockType();
        }
        listener.typeXBT(result);
    }

    @Override
    public void attribXBT(UBNatural value) throws XBProcessingException, IOException {
        listener.attribXBT(value);
    }

    @Override
    public void dataXBT(InputStream data) throws XBProcessingException, IOException {
        listener.dataXBT(data);
    }

    @Override
    public void endXBT() throws XBProcessingException, IOException {
        if (counter == 0) {
            throw new XBProcessingException("Unexpected stream flow");
        }
        listener.endXBT();
        counter--;
//        if (counter == 0) listener.endXBT();
    }

    @Override
    public void attachXBTListener(XBTListener listener) {
        this.listener = listener;
    }

    /**
     * @return the context
     */
    public XBContext getContext() {
        return context;
    }

    /**
     * @param context the context to set
     */
    public void setContext(XBContext context) {
        this.context = context;
    }

    @Override
    public void attachXBTProvider(XBTProvider provider) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
