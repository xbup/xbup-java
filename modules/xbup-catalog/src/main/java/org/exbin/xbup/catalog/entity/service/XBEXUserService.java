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
package org.exbin.xbup.catalog.entity.service;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import org.exbin.xbup.catalog.XBECatalog;
import org.exbin.xbup.catalog.entity.XBEXUser;
import org.exbin.xbup.catalog.entity.manager.XBEXUserManager;
import org.exbin.xbup.core.catalog.base.manager.XBCXUserManager;
import org.exbin.xbup.core.catalog.base.service.XBCXUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Interface for XBEXUser items service.
 *
 * @version 0.1.21 2014/03/16
 * @author ExBin Project (http://exbin.org)
 */
@Service
public class XBEXUserService extends XBEDefaultService<XBEXUser> implements XBCXUserService<XBEXUser>, Serializable {

    @Autowired
    private XBEXUserManager manager;

    public XBEXUserService() {
        super();
    }

    public XBEXUserService(XBECatalog catalog) {
        super(catalog);
        itemManager = new XBEXUserManager(catalog);
        catalog.addCatalogManager(XBCXUserManager.class, (XBCXUserManager) itemManager);
    }

    @PostConstruct
    public void init() {
        itemManager = manager;
    }

    public XBEXUser findByLogin(String userLogin) {
        return manager.findByLogin(userLogin);
    }
}
