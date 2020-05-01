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
package org.exbin.xbup.catalog.entity.manager;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;
import org.exbin.xbup.catalog.XBECatalog;
import org.exbin.xbup.catalog.entity.XBEItem;
import org.exbin.xbup.catalog.entity.XBEXHDoc;
import org.exbin.xbup.catalog.entity.XBEXLanguage;
import org.exbin.xbup.core.catalog.base.XBCItem;
import org.exbin.xbup.core.catalog.base.XBCXLanguage;
import org.exbin.xbup.core.catalog.base.manager.XBCXHDocManager;
import org.exbin.xbup.core.catalog.base.manager.XBCXLangManager;
import org.springframework.stereotype.Repository;

/**
 * XBUP catalog HTML documentation manager.
 *
 * @version 0.1.25 2015/09/06
 * @author ExBin Project (http://exbin.org)
 */
@Repository
public class XBEXHDocManager extends XBEDefaultCatalogManager<XBEXHDoc> implements XBCXHDocManager<XBEXHDoc>, Serializable {

    public XBEXHDocManager() {
        super();
    }

    public XBEXHDocManager(XBECatalog catalog) {
        super(catalog);
    }

    @Override
    public Long getAllHDocsCount() {
        try {
            return (Long) catalog.getEntityManager().createQuery("SELECT count(o) FROM XBXHDoc as o").getSingleResult();
        } catch (NoResultException ex) {
            return 0l;
        } catch (Exception ex) {
            Logger.getLogger(XBEXHDocManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public XBEXHDoc findById(Long id) {
        try {
            return (XBEXHDoc) catalog.getEntityManager().createQuery("SELECT object(o) FROM XBXHDoc as o WHERE o.id = " + id).getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } catch (Exception ex) {
            Logger.getLogger(XBEXHDocManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void initializeExtension() {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public XBEXHDoc getDocumentation(XBCItem item) {
        XBCXLangManager langManager = catalog.getCatalogManager(XBCXLangManager.class);
        if (!(item instanceof XBEItem)) {
            return null;
        }
        XBCXLanguage language = langManager.getDefaultLang();
        return getDocumentation(item, language);
    }

    public XBEXHDoc getDocumentation(XBCItem item, XBCXLanguage language) {
        try {
            return (XBEXHDoc) catalog.getEntityManager().createQuery("SELECT object(o) FROM XBXHDoc as o WHERE o.item.id = " + item.getId() + " AND o.lang.id = " + (((XBEXLanguage) language).getId())).getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } catch (Exception ex) {
            Logger.getLogger(XBEXHDocManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public String getExtensionName() {
        return "HDoc Extension";
    }
}
