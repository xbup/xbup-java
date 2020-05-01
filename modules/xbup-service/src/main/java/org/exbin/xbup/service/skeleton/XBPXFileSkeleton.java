/*
 * Copyright (C) ExBin Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.exbin.xbup.service.skeleton;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import org.exbin.xbup.catalog.XBAECatalog;
import org.exbin.xbup.catalog.entity.XBENode;
import org.exbin.xbup.catalog.entity.XBEXFile;
import org.exbin.xbup.catalog.entity.service.XBENodeService;
import org.exbin.xbup.catalog.entity.service.XBEXFileService;
import org.exbin.xbup.client.stub.XBPXFileStub;
import org.exbin.xbup.core.block.XBBlockType;
import org.exbin.xbup.core.block.XBTEmptyBlock;
import org.exbin.xbup.core.block.declaration.XBDeclBlockType;
import org.exbin.xbup.core.catalog.base.XBCXFile;
import org.exbin.xbup.core.catalog.base.service.XBCNodeService;
import org.exbin.xbup.core.catalog.base.service.XBCXFileService;
import org.exbin.xbup.core.parser.XBProcessingException;
import org.exbin.xbup.core.parser.token.XBAttribute;
import org.exbin.xbup.core.remote.XBMultiProcedure;
import org.exbin.xbup.core.remote.XBServiceServer;
import org.exbin.xbup.core.serial.param.XBPListenerSerialHandler;
import org.exbin.xbup.core.serial.param.XBPProviderSerialHandler;
import org.exbin.xbup.core.stream.XBInput;
import org.exbin.xbup.core.stream.XBOutput;
import org.exbin.xbup.core.type.XBString;
import org.exbin.xbup.core.ubnumber.type.UBNat32;

/**
 * RPC skeleton class for XBRXFile catalog items.
 *
 * @version 0.1.25 2015/03/16
 * @author ExBin Project (http://exbin.org)
 */
public class XBPXFileSkeleton {

    private final XBAECatalog catalog;

    public XBPXFileSkeleton(XBAECatalog catalog) {
        this.catalog = catalog;
    }

    public void registerProcedures(XBServiceServer remoteServer) {
        remoteServer.addXBProcedure(new XBDeclBlockType(XBPXFileStub.OWNER_FILE_PROCEDURE), new XBMultiProcedure() {
            @Override
            public void execute(XBBlockType blockType, XBOutput parameters, XBInput resultInput) throws XBProcessingException, IOException {
                XBPProviderSerialHandler provider = new XBPProviderSerialHandler(parameters);
                provider.begin();
                provider.matchType(blockType);
                XBAttribute index = provider.pullAttribute();
                provider.end();

                XBEXFileService fileService = (XBEXFileService) catalog.getCatalogService(XBCXFileService.class);
                XBEXFile file = fileService.getItem(index.getNaturalLong());

                XBPListenerSerialHandler listener = new XBPListenerSerialHandler(resultInput);
                listener.process(file == null ? XBTEmptyBlock.getEmptyBlock() : new UBNat32(file.getNode().getId()));
            }
        });

        remoteServer.addXBProcedure(new XBDeclBlockType(XBPXFileStub.FILENAME_FILE_PROCEDURE), new XBMultiProcedure() {
            @Override
            public void execute(XBBlockType blockType, XBOutput parameters, XBInput resultInput) throws XBProcessingException, IOException {
                XBPProviderSerialHandler provider = new XBPProviderSerialHandler(parameters);
                provider.begin();
                provider.matchType(blockType);
                XBAttribute index = provider.pullAttribute();
                provider.end();

                XBEXFileService fileService = (XBEXFileService) catalog.getCatalogService(XBCXFileService.class);
                XBEXFile file = fileService.getItem(index.getNaturalLong());

                XBPListenerSerialHandler listener = new XBPListenerSerialHandler(resultInput);
                listener.process(file == null ? XBTEmptyBlock.getEmptyBlock() : new XBString(file.getFilename()));
            }
        });

        remoteServer.addXBProcedure(new XBDeclBlockType(XBPXFileStub.DATA_FILE_PROCEDURE), new XBMultiProcedure() {
            @Override
            public void execute(XBBlockType blockType, XBOutput parameters, XBInput resultInput) throws XBProcessingException, IOException {
                XBPProviderSerialHandler provider = new XBPProviderSerialHandler(parameters);
                provider.begin();
                provider.matchType(blockType);
                XBAttribute index = provider.pullAttribute();
                provider.end();

                XBEXFileService fileService = (XBEXFileService) catalog.getCatalogService(XBCXFileService.class);
                XBEXFile file = fileService.getItem(index.getNaturalLong());

                XBPListenerSerialHandler listener = new XBPListenerSerialHandler(resultInput);
                listener.begin();
                listener.putData(new ByteArrayInputStream(file.getContent()));
                listener.end();
            }
        });

        remoteServer.addXBProcedure(new XBDeclBlockType(XBPXFileStub.NODEFILES_FILE_PROCEDURE), new XBMultiProcedure() {
            @Override
            public void execute(XBBlockType blockType, XBOutput parameters, XBInput resultInput) throws XBProcessingException, IOException {
                XBPProviderSerialHandler provider = new XBPProviderSerialHandler(parameters);
                provider.begin();
                provider.matchType(blockType);
                long nodeId = provider.pullLongAttribute();
                provider.end();

                XBEXFileService fileService = (XBEXFileService) catalog.getCatalogService(XBCXFileService.class);
                XBENodeService nodeService = (XBENodeService) catalog.getCatalogService(XBCNodeService.class);
                XBENode node = nodeService.getItem(nodeId);
                List<XBCXFile> files = fileService.findFilesForNode(node);

                XBPListenerSerialHandler listener = new XBPListenerSerialHandler(resultInput);
                listener.begin();
                listener.matchType();
                listener.putAttribute(files.size());
                for (XBCXFile file : files) {
                    listener.putAttribute(file.getId());
                }
                listener.end();
            }
        });
    }
}
