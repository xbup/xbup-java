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
package org.exbin.xbup.client.catalog.remote.manager;

import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import org.exbin.xbup.client.catalog.XBRCatalog;
import org.exbin.xbup.client.catalog.remote.XBRItem;
import org.exbin.xbup.client.stub.XBPItemStub;
import org.exbin.xbup.core.catalog.base.manager.XBCItemManager;
import org.exbin.xbup.core.catalog.base.service.XBItemWithDetail;

/**
 * Remote manager class for XBRItem catalog items.
 *
 * @version 0.2.1 2020/08/26
 * @author ExBin Project (http://exbin.org)
 */
@ParametersAreNonnullByDefault
public class XBRItemManager extends XBRDefaultManager<XBRItem> implements XBCItemManager<XBRItem> {

    private final XBPItemStub itemStub;

    public XBRItemManager(XBRCatalog catalog) {
        super(catalog);
        itemStub = new XBPItemStub(client);
    }

    @Override
    public long getItemsCount() {
        return itemStub.getItemsCount();
    }

    @Override
    public List<XBItemWithDetail> findAllPaged(int startFrom, int maxResults, @Nullable String filterCondition, @Nullable String orderCondition, @Nullable String specType) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int findAllPagedCount(@Nullable String filterCondition, @Nullable String specType) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
