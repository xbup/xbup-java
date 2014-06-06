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
package org.xbup.lib.xb.catalog.remote;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xbup.lib.xb.catalog.base.XBCXFile;
import org.xbup.lib.xb.catalog.base.XBCXPlugin;
import org.xbup.lib.xb.catalog.client.XBCatalogServiceClient;
import org.xbup.lib.xb.catalog.client.XBCatalogServiceMessage;
import org.xbup.lib.xb.parser.XBProcessingException;
import org.xbup.lib.xb.parser.basic.XBListener;
import org.xbup.lib.xb.remote.XBServiceClient;
import org.xbup.lib.xb.serial.XBSerializationType;
import org.xbup.lib.xb.serial.child.XBChildProviderSerialHandler;
import org.xbup.lib.xb.stream.XBTokenInputStream;
import org.xbup.lib.xb.stream.XBStreamChecker;
import org.xbup.lib.xb.type.XBString;
import org.xbup.lib.xb.ubnumber.type.UBNat32;

/**
 *
 * @version 0.1 wr19.0 2010/06/19
 * @author XBUP Project (http://xbup.org)
 */
public class XBRXPlugin implements XBCXPlugin {

    private long id;
    protected XBCatalogServiceClient client;

    public XBRXPlugin(XBCatalogServiceClient client, long id) {
        this.id = id;
        this.client = client;
    }

    @Override
    public XBRNode getOwner() {
        try {
            XBCatalogServiceMessage message = client.executeProcedure(XBServiceClient.OWNER_PLUGIN_PROCEDURE);
            XBListener listener = message.getXBOutput();
            listener.attribXB(new UBNat32(getId()));
            listener.endXB();
            XBStreamChecker checker = message.getXBInput();
            long ownerId = checker.attribXB().getLong();
            checker.endXB();
            message.close();
            if (ownerId == 0) {
                return null;
            }
            return new XBRNode(client, ownerId);
        } catch (XBProcessingException ex) {
            Logger.getLogger(XBRItem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XBRItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getFilename() {
        try {
            XBCatalogServiceMessage message = client.executeProcedure(XBServiceClient.FILENAME_FILE_PROCEDURE);
            XBListener listener = message.getXBOutput();
            listener.attribXB(new UBNat32(getId()));
            listener.endXB();
            XBTokenInputStream input = message.getXBInputStream();
            XBStreamChecker checker = message.getXBInput();
            checker.attribXB(new UBNat32(1));
            checker.beginXB();
            checker.attribXB();
            checker.attribXB();
            XBString text = new XBString();
            XBChildProviderSerialHandler handler = new XBChildProviderSerialHandler();
            handler.attachXBPullProvider(input);
            text.serializeXB(XBSerializationType.FROM_XB, 0, handler);
//            new XBL1ToL0DefaultStreamConvertor(new XBL2ToL1DefaultStreamConvertor(text)).readXBStream(input);
            checker.endXB();
            checker.endXB();
            message.close();
            return text.getValue();
        } catch (XBProcessingException ex) {
            Logger.getLogger(XBRXDesc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XBRXDesc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public XBCXFile getPluginFile() {
        try {
            XBCatalogServiceMessage message = client.executeProcedure(XBServiceClient.FILE_PLUGIN_PROCEDURE);
            XBListener listener = message.getXBOutput();
            listener.attribXB(new UBNat32(getId()));
            listener.endXB();
            XBStreamChecker checker = message.getXBInput();
            long index = checker.attribXB().getLong();
            checker.endXB();
            message.close();
            return new XBRXFile(client, index);
        } catch (XBProcessingException ex) {
            Logger.getLogger(XBRXDesc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XBRXDesc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Long getPluginIndex() {
        try {
            XBCatalogServiceMessage message = client.executeProcedure(XBServiceClient.INDEX_PLUGIN_PROCEDURE);
            XBListener listener = message.getXBOutput();
            listener.attribXB(new UBNat32(getId()));
            listener.endXB();
            XBStreamChecker checker = message.getXBInput();
            long index = checker.attribXB().getLong();
            checker.endXB();
            message.close();
            return index;
        } catch (XBProcessingException ex) {
            Logger.getLogger(XBRItem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XBRItem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
