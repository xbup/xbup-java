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
package org.xbup.lib.catalog.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.xbup.lib.core.catalog.base.XBCItem;
import org.xbup.lib.core.catalog.base.XBCXItemInfo;

/**
 * Item information database entity.
 *
 * @version 0.1.21 2012/01/28
 * @author XBUP Project (http://xbup.org)
 */
@Entity(name = "XBItemInfo")
public class XBEXItemInfo implements XBCXItemInfo, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private XBEItem item;
    @ManyToOne
    private XBEXUser owner;
    @ManyToOne
    private XBEXUser createdByUser;
    private Time creationDate;

    public XBEXItemInfo() {
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns a hash code value for the object. This implementation computes a
     * hash code value based on the id fields in this object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this Item. The result is
     * <code>true</code> if and only if the argument is not null and is a Item
     * object that has the same id field values as this object.
     *
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof XBEXItemInfo)) {
            return false;
        }
        XBEXItemInfo other = (XBEXItemInfo) object;
        return !(!Objects.equals(this.id, other.id) && (this.id == null || !this.id.equals(other.id)));
    }

    /**
     * Returns a string representation of the object. This implementation
     * constructs that representation based on the id fields.
     *
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return "org.xbup.catalog.entity.Node[id=" + id + "]";
    }

    @Override
    public XBCItem getItem() {
        return item;
    }

    public void setItem(XBCItem item) {
        this.setItem((XBEItem) item);
    }

    @Override
    public XBEXUser getOwner() {
        return owner;
    }

    @Override
    public XBEXUser getCreatedByUser() {
        return createdByUser;
    }

    @Override
    public Time getCreationDate() {
        return creationDate;
    }

    public void setItem(XBEItem item) {
        this.item = item;
    }

    public void setOwner(XBEXUser owner) {
        this.owner = owner;
    }

    public void setCreatedByUser(XBEXUser createdByUser) {
        this.createdByUser = createdByUser;
    }

    public void setCreationDate(Time creationDate) {
        this.creationDate = creationDate;
    }
}
