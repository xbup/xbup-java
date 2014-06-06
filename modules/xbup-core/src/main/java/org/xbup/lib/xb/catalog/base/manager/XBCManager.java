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
package org.xbup.lib.xb.catalog.base.manager;

import java.util.List;
import org.xbup.lib.xb.catalog.base.XBCBase;

/**
 * Generic interface for persistence item management classes.
 *
 * @version 0.1 wr21.0 2011/12/12
 * @author XBUP Project (http://xbup.org)
 * @param <T> base entity
 */
public interface XBCManager<T extends XBCBase> {

    /**
     * Create instance of new item and set it to default state.
     *
     * @return new item
     */
    public T createItem();

    /**
     * Update item state to persistent repository.
     *
     * @param item to update
     */
    public void persistItem(T item);

    /**
     * Delete item from persistent repository.
     *
     * @param item
     */
    public void removeItem(T item);

    /**
     * Get item from persistent repository.
     *
     * @param itemId item id
     * @return instance of item or null
     */
    public T getItem(long itemId);

    /**
     * Get list of all items from persistent repository.
     *
     * @return list of items
     */
    public List<T> getAllItems();

    /**
     * Count of items in persistent repository.
     *
     * @return count of items
     */
    public long getItemsCount();
}
