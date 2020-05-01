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
package org.exbin.xbup.client.catalog.remote.service;

import org.exbin.xbup.client.catalog.XBRCatalog;
import org.exbin.xbup.client.catalog.remote.XBRTran;
import org.exbin.xbup.client.catalog.remote.manager.XBRTranManager;
import org.exbin.xbup.core.catalog.base.manager.XBCTranManager;
import org.exbin.xbup.core.catalog.base.service.XBCTranService;

/**
 * Remote service for XBRTran items.
 *
 * @version 0.1.25 2015/03/19
 * @author ExBin Project (http://exbin.org)
 */
public class XBRTranService extends XBRDefaultService<XBRTran> implements XBCTranService<XBRTran> {

    public XBRTranService(XBRCatalog catalog) {
        super(catalog);
        itemManager = new XBRTranManager(catalog);
        catalog.addCatalogManager(XBCTranManager.class, (XBCTranManager) itemManager);
    }
}
