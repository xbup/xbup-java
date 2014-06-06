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
package org.xbup.lib.xbcatalog;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.URLDataSource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import org.xbup.lib.xb.block.declaration.XBContext;
import org.xbup.lib.xb.catalog.base.service.XBCXDescService;
import org.xbup.lib.xb.catalog.base.service.XBCXLangService;
import org.xbup.lib.xb.catalog.base.service.XBCXNameService;
import org.xbup.lib.xb.parser.XBProcessingException;
import org.xbup.lib.xb.parser.basic.XBTProducer;
import org.xbup.lib.xb.parser.basic.convert.XBTDecapsulator;
import org.xbup.lib.xb.parser.basic.convert.XBTEncapsulator;
import org.xbup.lib.xb.parser.basic.convert.XBTProducerToProvider;
import org.xbup.lib.xb.parser.basic.convert.XBTProviderToProducer;
import org.xbup.lib.xb.parser.token.event.convert.XBTEventListenerToListener;
import org.xbup.lib.xb.parser.token.event.convert.XBTListenerToEventListener;
import org.xbup.lib.xb.parser.token.event.convert.XBTToXBEventConvertor;
import org.xbup.lib.xb.parser.token.pull.convert.XBTProviderToPullProvider;
import org.xbup.lib.xb.parser.token.pull.convert.XBTPullProviderToProvider;
import org.xbup.lib.xb.parser.token.pull.convert.XBToXBTPullConvertor;
import org.xbup.lib.xb.serial.XBSerializationType;
import org.xbup.lib.xb.serial.child.XBTChildListenerSerialHandler;
import org.xbup.lib.xb.serial.child.XBTChildProviderSerialHandler;
import org.xbup.lib.xb.stream.file.XBFileInputStream;
import org.xbup.lib.xb.stream.file.XBFileOutputStream;
import org.xbup.lib.xb.type.XBString;
import org.xbup.lib.xbcatalog.entity.service.XBEXDescService;
import org.xbup.lib.xbcatalog.entity.service.XBEXLangService;
import org.xbup.lib.xbcatalog.entity.service.XBEXNameService;

/**
 * Test operations, should be test clases later
 *
 * @version 0.1 wr23.0 2013/11/21
 * @author XBUP Project (http://xbup.org)
 */
public class Test1 {

    public static void main(String args[]) {
        test4();
    }

    public static void test3() {
//        String catalogURL = "http://catalog.xbup.org/interface/wr14-0.php";
        String catalogURL = "http://catalog.xbup.org/interface/wr14-0.php";
        URL myURL;
        try {
            myURL = new URL(catalogURL + "?op=getlang&code=cs");
            URLDataSource dataSource = new URLDataSource(myURL);
            BufferedReader dis = new BufferedReader(new InputStreamReader(dataSource.getInputStream(),Charset.forName("UTF-8")));
            String line;
            line = dis.readLine();
            if (line.equals("id")) {
                System.out.println("Result: "+new Long(dis.readLine()));
                dis.readLine();
                System.out.println("Caption: "+ dis.readLine());
            } else {
                System.out.println("Error: "+line);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(Test1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Test1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void test4() {
        try {
            XBECatalog catalog;
            try {
                // Database Initialization
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("XBLibPU");
                EntityManager em = emf.createEntityManager();
                em.setFlushMode(FlushModeType.AUTO);
                catalog = new XBECatalog(em, "");
                if (catalog.isShallInit()) {
                    catalog.initCatalog();
                }
                catalog.addCatalogService(XBCXLangService.class, new XBEXLangService(catalog));
                catalog.addCatalogService(XBCXNameService.class, new XBEXNameService(catalog));
                catalog.addCatalogService(XBCXDescService.class, new XBEXDescService(catalog));
            } catch (Exception ex) {
                Logger.getLogger(Test1.class.getName()).log(Level.SEVERE, null, ex);
//                    catalog = new XBDefaultCatalog();
                catalog = null;
            }
            XBString text = new XBString("Test");
            XBFileOutputStream output = new XBFileOutputStream("string.xb");
            XBTChildListenerSerialHandler handler = new XBTChildListenerSerialHandler();
            XBTEncapsulator encapsulator = new XBTEncapsulator(new XBContext(catalog, text.getXBDeclaration()));
            encapsulator.attachXBTListener(new XBTEventListenerToListener(new XBTToXBEventConvertor(output)));
            handler.attachXBTEventListener(new XBTListenerToEventListener(encapsulator));
            text.serializeXB(XBSerializationType.TO_XB, 0, handler);
//            new XBL1ToL0StreamConvertor.XBCL1ToL0DefaultStreamConvertor((XBCL1Streamable) new XBL2ToL1StreamConvertor.XBCL2ToL1DefaultStreamConvertor(text)).writeXBStream(output);
            output.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Test1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Test1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            XBString text2 = new XBString();
            XBFileInputStream input = new XBFileInputStream("string.xb");
            XBTChildProviderSerialHandler handler = new XBTChildProviderSerialHandler();
            // TODO optimalization
            XBTDecapsulator decapsulator = new XBTDecapsulator();
            XBTProducer producer = new XBTProviderToProducer(new XBTPullProviderToProvider(new XBToXBTPullConvertor(input)));
            producer.attachXBTListener(decapsulator);
            handler.attachXBTPullProvider(new XBTProviderToPullProvider(new XBTProducerToProvider(decapsulator)));
            text2.serializeXB(XBSerializationType.FROM_XB, 0, handler);
//            new XBL1ToL0StreamConvertor.XBCL1ToL0DefaultStreamConvertor((XBCL1Streamable) new XBL2ToL1StreamConvertor.XBCL2ToL1DefaultStreamConvertor(text2)).readXBStream(input);
            input.close();
            System.out.println("XBString test result (should be Test): " + text2.getValue());
        } catch (XBProcessingException ex) {
            Logger.getLogger(Test1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Test1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Test1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
