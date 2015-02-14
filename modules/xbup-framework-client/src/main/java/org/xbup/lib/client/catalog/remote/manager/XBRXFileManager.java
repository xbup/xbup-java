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
package org.xbup.lib.client.catalog.remote.manager;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import org.xbup.lib.client.catalog.XBRCatalog;
import org.xbup.lib.core.catalog.base.XBCNode;
import org.xbup.lib.core.catalog.base.XBCXFile;
import org.xbup.lib.core.catalog.base.manager.XBCXFileManager;
import org.xbup.lib.client.XBCatalogServiceMessage;
import org.xbup.lib.client.catalog.remote.XBRXDesc;
import org.xbup.lib.client.catalog.remote.XBRXFile;
import org.xbup.lib.core.parser.XBProcessingException;
import org.xbup.lib.core.parser.basic.XBListener;
import org.xbup.lib.core.parser.basic.XBMatchingProvider;
import org.xbup.lib.core.remote.XBServiceClient;
import org.xbup.lib.core.ubnumber.type.UBNat32;
import org.xbup.lib.core.util.StreamUtils;

/**
 * Manager class for XBRXFile catalog items.
 *
 * @version 0.1.22 2013/07/28
 * @author XBUP Project (http://xbup.org)
 */
public class XBRXFileManager extends XBRDefaultManager<XBRXFile> implements XBCXFileManager<XBRXFile> {

    public XBRXFileManager(XBRCatalog catalog) {
        super(catalog);
    }

    public Long getAllFilesCount() {
        throw new UnsupportedOperationException("Not supported yet.");
/*        try {
            XBCatalogServiceMessage message = client.executeProcedure(XBServiceClient.SPECSCOUNT_SPEC_PROCEDURE);
            XBListener listener = message.getXBOutput();
            listener.endXB();
            XBMatchingProvider checker = message.getXBInput();
            Long index = checker.matchAttribXB().getNaturalLong();
            checker.matchEndXB();
            message.close();
            return index;
        } catch (XBProcessingException ex) {
            Logger.getLogger(XBRItem.class.getExtensionName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XBRItem.class.getExtensionName()).log(Level.SEVERE, null, ex);
        }
        return null; */
    }

    @Override
    public Long[] getFileXBPath(XBCXFile file) {
        ArrayList<Long> list = new ArrayList<Long>();
        XBCNode parent = file.getNode();
        while (parent != null) {
            if (parent.getParent() != null) {
                if (parent.getXBIndex() == null) {
                    return null;
                }
                list.add(0, parent.getXBIndex());
            }
            parent = (XBCNode) parent.getParent();
        }
        list.add(file.getId());
        return (Long[]) list.toArray(new Long[list.size()]);
    }

    @Override
    public ImageIcon getFileAsImageIcon(XBCXFile iconFile) {
        try {
            XBCatalogServiceMessage message = client.executeProcedure(XBServiceClient.DATA_FILE_PROCEDURE);
            XBListener listener = message.getXBOutput();
            listener.attribXB(new UBNat32(iconFile.getId()));
            listener.endXB();
            XBMatchingProvider checker = message.getXBInput();
            checker.matchAttribXB(new UBNat32(1));
            checker.matchBeginXB();
            InputStream istream = checker.matchDataXB();
            ByteArrayOutputStream data = new ByteArrayOutputStream();
            StreamUtils.copyInputStreamToOutputStream(istream, data);
            checker.matchEndXB();
            message.close();
            return new ImageIcon(data.toByteArray()); // TODO: Is there better to convert InputStream?
        } catch (XBProcessingException ex) {
            Logger.getLogger(XBRXDesc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XBRXDesc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public XBCXFile findById(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public InputStream getFile(XBCXFile iconFile) {
        try {
            XBCatalogServiceMessage message = client.executeProcedure(XBServiceClient.DATA_FILE_PROCEDURE);
            XBListener listener = message.getXBOutput();
            listener.attribXB(new UBNat32(iconFile.getId()));
            listener.endXB();
            XBMatchingProvider checker = message.getXBInput();
            checker.matchAttribXB(new UBNat32(1));
            checker.matchBeginXB();
            InputStream istream = checker.matchDataXB();
            ByteArrayOutputStream data = new ByteArrayOutputStream();
            StreamUtils.copyInputStreamToOutputStream(istream, data);
            checker.matchEndXB();
            message.close();
            return new ByteArrayInputStream(data.toByteArray()); // TODO: Is there better to convert InputStream?
        } catch (XBProcessingException ex) {
            Logger.getLogger(XBRXDesc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XBRXDesc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public XBRXFile findFile(XBCNode node, String fileName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void initializeExtension() {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getExtensionName() {
        return "File Repository Extension";
    }

    @Override
    public List<XBCXFile> findFilesForNode(XBCNode node) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
