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
package org.xbup.web.xbcatalogweb.base;

import java.util.List;
import org.xbup.lib.catalog.entity.XBEXHDoc;
import org.xbup.lib.catalog.entity.XBEXLanguage;

/**
 * Full item record entity interface.
 *
 * @version 0.1.24 2014/11/11
 * @author XBUP Project (http://xbup.org)
 */
public interface XBCFullItemRecord extends XBCItemRecord {

    String getDescription();

    XBEXHDoc getHdoc();

    String getHdocText();

    String getItemName();

    XBEXLanguage getLanguage();

    String getParentNode();

    String getStringId();

    List<XBCDefinitionRecord> getDefinitions();

    void setDescription(String description);

    void setHdoc(XBEXHDoc hdoc);

    void setHdocText(String hdocText);

    void setItemName(String itemName);

    void setLanguage(XBEXLanguage language);

    void setParentNode(String parentNode);

    void setStringId(String stringId);

}
