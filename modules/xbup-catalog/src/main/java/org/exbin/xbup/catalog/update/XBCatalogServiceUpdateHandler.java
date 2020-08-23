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
package org.exbin.xbup.catalog.update;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import org.exbin.xbup.catalog.XBAECatalog;
import org.exbin.xbup.client.XBCatalogNetServiceClient;
import org.exbin.xbup.client.stub.XBPRootStub;
import org.exbin.xbup.client.update.XBCUpdateHandler;
import org.exbin.xbup.client.update.XBCUpdateListener;

/**
 * Catalog service update handler.
 *
 * @version 0.2.1 2020/08/23
 * @author ExBin Project (http://exbin.org)
 */
@ParametersAreNonnullByDefault
public class XBCatalogServiceUpdateHandler implements XBCUpdateHandler {

    private final List<XBCUpdateListener> updateListeners = new ArrayList<>();
    private final XBCatalogNetServiceClient serviceClient;
    private final XBAECatalog catalog;

    public XBCatalogServiceUpdateHandler(XBAECatalog catalog, XBCatalogNetServiceClient serviceClient) {
        this.catalog = catalog;
        this.serviceClient = serviceClient;
    }

    @Override
    public void init() {
    }

    @Nonnull
    @Override
    public Date getMainLastUpdate() {
        XBPRootStub rootStub = new XBPRootStub(serviceClient);
        return rootStub.getMainLastUpdate().get();
    }

    @Override
    public void performUpdateMain() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void performUpdate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addUpdateListener(XBCUpdateListener listener) {
        updateListeners.add(listener);
    }

    @Override
    public void removeUpdateListener(XBCUpdateListener listener) {
        updateListeners.remove(listener);
    }

    @Override
    public void fireUsageEvent(boolean usage) {
        updateListeners.forEach(listener -> {
            listener.webServiceUsage(usage);
        });
    }
}
