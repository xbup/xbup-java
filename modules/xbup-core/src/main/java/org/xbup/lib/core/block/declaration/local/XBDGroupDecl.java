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
package org.xbup.lib.core.block.declaration.local;

import java.io.IOException;
import java.util.List;
import org.xbup.lib.core.block.declaration.XBBlockDecl;
import org.xbup.lib.core.block.declaration.XBGroupDecl;
import org.xbup.lib.core.block.definition.local.XBDGroupDef;
import org.xbup.lib.core.block.definition.XBGroupDef;
import org.xbup.lib.core.parser.XBProcessingException;
import org.xbup.lib.core.serial.sequence.XBTSequenceSerialHandler;
import org.xbup.lib.core.serial.sequence.XBTSequenceSerializable;

/**
 * XBUP level 1 group declaration.
 *
 * @version 0.1.24 2014/11/30
 * @author XBUP Project (http://xbup.org)
 */
public class XBDGroupDecl implements XBGroupDecl, XBTSequenceSerializable {

    private long revision = 0;
    private XBDGroupDef groupDef;

    public XBDGroupDecl() {
    }

    public XBDGroupDecl(XBDGroupDef groupDef) {
        this.groupDef = groupDef;
    }
    
    public XBDGroupDecl(XBBlockDecl block) {
        groupDef = new XBDGroupDef(block);
    }

    public List<XBBlockDecl> getBlocks() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public long getRevision() {
        return revision;
    }

    public void setRevision(long revision) {
        this.revision = revision;
    }

    public int getBlocksLimit() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public XBGroupDef getGroupDef() {
        return groupDef;
    }

    @Override
    public void serializeXB(XBTSequenceSerialHandler serializationHandler) throws XBProcessingException, IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

//    @Override
//    public void serializeXB(XBTSequenceSerialHandler serializationHandler) throws XBProcessingException, IOException {
//        XBSerialSequence seq = new XBSerialSequence(new XBFixedBlockType(XBBasicBlockType.GROUP_DECLARATION));
//
//        // Join GroupsLimit (UBNatural)
//        seq.join(new XBTSequenceSerializable() {
//
//            @Override
//            public void serializeXB(XBTSequenceSerialHandler serializationHandler) throws XBProcessingException, IOException {
//                long[] xbGroupLimitBlockType = {1, 5};
//                XBSerialSequence seq = new XBSerialSequence(new XBDeclBlockType(new XBPBlockDecl(xbGroupLimitBlockType)));
//                seq.join(blocksLimit);
//                // Join FormatSpecCatalogPath (UBPath)
//                // seq.join(new UBPath32(getCatalogPath()));
//                // Join Revision (UBNatural)
//                seq.join(new XBTSequenceSerializable() {
//                    @Override
//                    public void serializeXB(XBTSequenceSerialHandler serializationHandler) throws XBProcessingException, IOException {
//                        long[] xbRevisionBlockType = {1, 5};
//                        XBSerialSequence subSequence = new XBSerialSequence(new XBDeclBlockType(new XBPBlockDecl(xbRevisionBlockType)));
//                        subSequence.join(new UBNat32(revision));
//
//                        serializationHandler.sequenceXB(subSequence);
//                    }
//                });
//
//                // List GroupSpecification
//                seq.listConsist(new XBSerialSequenceIList() {
//
//                    private int position = 0;
//
//                    @Override
//                    public void setSize(UBENatural count) {
//                        int i = count.getInt() - blocks.size();
//                        if ((i > 0) && (blocks == null)) {
//                            blocks = new ArrayList<>();
//                        }
//
//                        if (i > 0) {
//                            while (i > 0) {
//                                blocks.add(new XBDBlockDecl());
//                                i--;
//                            }
//                        } else {
//                            while (i < 0) {
//                                blocks.remove(blocks.size() - 1);
//                                i++;
//                            }
//                        }
//                    }
//
//                    @Override
//                    public UBENatural getSize() {
//                        if (blocks == null) {
//                            return new UBENat32();
//                        }
//                        return new UBENat32(blocks.size());
//                    }
//
//                    @Override
//                    public XBSerializable next() {
//                        return (XBSerializable) blocks.get(position++);
//                        /* TODO detect
//                         XBTSerialMethod serialMethod = blocks.get(position++).getXBTSerializationMethod();
//                         if (serialMethod instanceof XBTSerialSequenceListenerMethod) {
//                         return ((XBTSerialSequenceListenerMethod) serialMethod).getXBSerialSequence();
//                         } else {
//                         throw new UnsupportedOperationException("Not supported yet.");
//                         } */
//                    }
//
//                    @Override
//                    public void reset() {
//                        position = 0;
//                    }
//                });
//
//                // List FormatConstructor
//                seq.listConsist(new XBSerialSequenceIList() {
//
//                    private int position = 0;
//
//                    @Override
//                    public void setSize(UBENatural count) {
//                        int i = count.getInt() - groupDefs.size();
//                        if ((i > 0) && (groupDefs == null)) {
//                            groupDefs = new ArrayList<>();
//                        }
//                        if (i > 0) {
//                            while (i > 0) {
//                                groupDefs.add(new XBDGroupDef());
//                                i--;
//                            }
//                        } else {
//                            while (i < 0) {
//                                groupDefs.remove(groupDefs.size() - 1);
//                                i++;
//                            }
//                        }
//                    }
//
//                    @Override
//                    public UBENatural getSize() {
//                        if (groupDefs == null) {
//                            return new UBENat32();
//                        }
//                        return new UBENat32(groupDefs.size());
//                    }
//
//                    @Override
//                    public XBSerializable next() {
//                        return groupDefs.get(position++);
//                        /* TODO
//                         XBTSerialMethod serialMethod = groupDefs.get(position++).getXBTSerializationMethod();
//                         if (serialMethod instanceof XBTSerialSequenceListenerMethod) {
//                         return ((XBTSerialSequenceListenerMethod) serialMethod).getXBSerialSequence();
//                         } else {
//                         throw new UnsupportedOperationException("Not supported yet.");
//                         } */
//                    }
//
//                    @Override
//                    public void reset() {
//                        position = 0;
//                    }
//                });
//
//                // List Revision
//                seq.listConsist(new XBSerialSequenceIList() {
//
//                    private int position = 0;
//
//                    @Override
//                    public void setSize(UBENatural count) {
//                        int i = count.getInt() - revisionDefs.size();
//                        if ((i > 0) && (revisionDefs == null)) {
//                            revisionDefs = new ArrayList<>();
//                        }
//                        if (i > 0) {
//                            while (i > 0) {
//                                revisionDefs.add(new XBDRevisionDef());
//                                i--;
//                            }
//                        } else {
//                            while (i < 0) {
//                                revisionDefs.remove(revisionDefs.size() - 1);
//                                i++;
//                            }
//                        }
//                    }
//
//                    @Override
//                    public UBENatural getSize() {
//                        if (revisionDefs == null) {
//                            return new UBENat32();
//                        }
//                        return new UBENat32(revisionDefs.size());
//                    }
//
//                    @Override
//                    public XBSerializable next() {
//                        return revisionDefs.get(position++);
//                        /* TODO
//                         XBTSerialMethod serialMethod = revisionDefs.get(position++).getXBTSerializationMethod();
//                         if (serialMethod instanceof XBTSerialSequenceListenerMethod) {
//                         return ((XBTSerialSequenceListenerMethod) serialMethod).getXBSerialSequence();
//                         } else {
//                         throw new UnsupportedOperationException("Not supported yet.");
//                         } */
//                    }
//
//                    @Override
//                    public void reset() {
//                        position = 0;
//                    }
//                });
//
//                serializationHandler.sequenceXB(seq);
//            }
//        });
//
//        serializationHandler.sequenceXB(seq);
//    }
}
