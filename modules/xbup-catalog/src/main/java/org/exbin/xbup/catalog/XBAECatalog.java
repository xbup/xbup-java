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
package org.exbin.xbup.catalog;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.exbin.xbup.catalog.entity.service.XBELimiService;
import org.exbin.xbup.catalog.entity.service.XBETranService;
import org.exbin.xbup.core.block.declaration.XBContext;
import org.exbin.xbup.core.catalog.XBACatalog;
import org.exbin.xbup.core.catalog.base.service.XBCLimiService;
import org.exbin.xbup.core.catalog.base.service.XBCTranService;

/**
 * Basic level 2 catalog class using Java persistence.
 *
 * @version 0.1.25 2015/08/08
 * @author ExBin Project (http://exbin.org)
 */
@ParametersAreNonnullByDefault
public class XBAECatalog extends XBECatalog implements XBACatalog {

    public XBAECatalog() {
        super();
    }

    public XBAECatalog(EntityManager em) {
        super(em);

        catalogServices.put(XBCLimiService.class, new XBELimiService(this));
        catalogServices.put(XBCTranService.class, new XBETranService(this));
    }

    public void clear() {
        // TODO: Delete everything
    }

    @Override
    public XBContext getRootContext() {
        return super.getRootContext();
        // TODO: Should be level 2 Context
    }

    @Override
    public void initCatalog() {
        super.initCatalog();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();

            /*            XBEType node = new XBEType();
             node.setXBIndex(0l);
             node.setOwner(null);
             em.persist(node);

             XBEAttrib attrib = new XBEAttrib();
             attrib.setOwner(node);
             attrib.setXBIndex(0l);
             em.persist(attrib);
             */
            tx.commit();
        } catch (Exception ex) {
            Logger.getLogger(XBAECatalog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
