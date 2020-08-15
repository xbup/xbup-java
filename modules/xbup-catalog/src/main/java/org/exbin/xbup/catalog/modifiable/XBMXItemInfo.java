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
package org.exbin.xbup.catalog.modifiable;

import java.sql.Time;
import javax.annotation.ParametersAreNonnullByDefault;
import org.exbin.xbup.core.catalog.base.XBCItem;
import org.exbin.xbup.core.catalog.base.XBCXItemInfo;
import org.exbin.xbup.core.catalog.base.XBCXUser;

/**
 * Interface for item information entity.
 *
 * @version 0.2.1 2020/08/14
 * @author ExBin Project (http://exbin.org)
 */
@ParametersAreNonnullByDefault
public interface XBMXItemInfo extends XBCXItemInfo, XBMBase {

    /**
     * Sets related item.
     *
     * @param item item
     */
    void setItem(XBCItem item);

    /**
     * Sets item owner.
     *
     * @param user user
     */
    void setOwner(XBCXUser user);

    /**
     * Sets created by user.
     *
     * @param user user
     */
    void setCreatedByUser(XBCXUser user);

    /**
     * Sets creation date.
     *
     * @param time creation date
     */
    void setCreationDate(Time time);
}
