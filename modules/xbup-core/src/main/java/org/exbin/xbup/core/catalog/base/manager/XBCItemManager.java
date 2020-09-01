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
package org.exbin.xbup.core.catalog.base.manager;

import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import org.exbin.xbup.core.catalog.base.XBCItem;
import org.exbin.xbup.core.catalog.base.service.XBItemWithDetail;

/**
 * Interface for XBCItem catalog manager.
 *
 * @version 0.2.1 2020/08/26
 * @author ExBin Project (http://exbin.org)
 * @param <T> entity
 */
@ParametersAreNonnullByDefault
public interface XBCItemManager<T extends XBCItem> extends XBCCatalogManager<T> {

    @Nonnull
    List<XBItemWithDetail> findAllPaged(int startFrom, int maxResults, @Nullable String filterCondition, @Nullable String orderCondition, @Nullable String specType);

    int findAllPagedCount(@Nullable String filterCondition, @Nullable String specType);
}
