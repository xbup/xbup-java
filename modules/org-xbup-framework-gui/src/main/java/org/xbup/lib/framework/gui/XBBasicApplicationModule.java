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
package org.xbup.lib.framework.gui;

import java.io.FileOutputStream;
import org.xbup.lib.framework.gui.api.XBApplicationModule;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xbup.lib.core.parser.XBProcessingException;
import org.xbup.lib.core.parser.token.XBAttributeToken;
import org.xbup.lib.core.parser.token.XBBeginToken;
import org.xbup.lib.core.parser.token.XBDataToken;
import org.xbup.lib.core.parser.token.XBEndToken;
import org.xbup.lib.core.parser.token.XBTAttributeToken;
import org.xbup.lib.core.parser.token.XBTBeginToken;
import org.xbup.lib.core.parser.token.XBTDataToken;
import org.xbup.lib.core.parser.token.XBTToken;
import org.xbup.lib.core.parser.token.event.XBEventListener;
import org.xbup.lib.core.parser.token.event.XBEventProducer;
import org.xbup.lib.core.parser.token.event.XBEventWriter;
import org.xbup.lib.core.parser.token.event.XBTEventListener;
import org.xbup.lib.core.serial.param.XBPListenerSerialHandler;
import org.xbup.lib.core.serial.param.XBPSequenceSerialHandler;
import org.xbup.lib.core.serial.param.XBPSequenceSerializable;
import org.xbup.lib.core.serial.param.XBSerializationMode;
import org.xbup.lib.core.serial.sequence.XBStringListConsistSerializable;
import org.xbup.lib.core.type.XBString;
import org.xbup.lib.core.ubnumber.type.UBNat32;
import org.xbup.lib.framework.gui.api.XBApplicationModulePlugin;

/**
 * Record about single module.
 *
 * @version 0.2.0 2015/12/31
 * @author XBUP Project (http://xbup.org)
 */
public class XBBasicApplicationModule implements XBPSequenceSerializable, XBApplicationModule {

    static long[] XBUP_BLOCKREV_CATALOGPATH = {1, 3, 1, 2, 0, 0};

    private final String moduleId;
    private final XBApplicationModulePlugin plugin;
    private String name;
    private String description;
    private final List<String> optionalModuleIds = new ArrayList<>();
    private final List<String> dependencyModuleIds = new ArrayList<>();

    public XBBasicApplicationModule(String moduleId, XBApplicationModulePlugin plugin) {
        this.moduleId = moduleId;
        this.plugin = plugin;
    }

    // Temporary method to create module file.
    public static void main(String[] params) {
        XBBasicApplicationModule module = new XBBasicApplicationModule("org.xbup.lib.framework.gui.about.GuiAboutModule", null);
        module.setName("XBUP Text Editor Module");
        module.setDescription("Module supporting editation of plain text documents");
        String[] depedency = new String[] { "org.xbup.lib.framework.gui.file.GuiFileModule" };
        
        module.addDependencyModuleIds(Arrays.asList(depedency));
        try {
            XBEventWriter eventWriter = new XBEventWriter(new FileOutputStream("module.xb"));
            XBPListenerSerialHandler serial = new XBPListenerSerialHandler(new XBTToXBEventTypeRemover(eventWriter));
            serial.process(module);
        } catch (IOException ex) {
            Logger.getLogger(XBBasicApplicationModule.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getModuleId() {
        return moduleId;
    }

    @Override
    public XBApplicationModulePlugin getPlugin() {
        return plugin;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public List<String> getOptionalModuleIds() {
        return optionalModuleIds;
    }

    public void addOptionalModuleIds(List<String> optionalModuleIds) {
        this.optionalModuleIds.addAll(optionalModuleIds);
    }

    @Override
    public List<String> getDependencyModuleIds() {
        return dependencyModuleIds;
    }

    public void addDependencyModuleIds(List<String> dependencyModuleIds) {
        this.dependencyModuleIds.addAll(dependencyModuleIds);
    }

    @Override
    public void serializeXB(XBPSequenceSerialHandler serial) throws XBProcessingException, IOException {
        serial.begin();
        serial.matchType();
        XBStringListConsistSerializable dependencies = new XBStringListConsistSerializable(dependencyModuleIds);
        XBStringListConsistSerializable optionals = new XBStringListConsistSerializable(optionalModuleIds);
        if (serial.getSerializationMode() == XBSerializationMode.PULL) {
            if (serial.pullIfEmptyBlock()) {
                name = null;
            } else {
                XBString nameString = new XBString();
                serial.consist(nameString);
                name = nameString.getValue();
            }

            if (serial.pullIfEmptyBlock()) {
                description = null;
            } else {
                XBString descriptionString = new XBString();
                serial.consist(descriptionString);
                description = descriptionString.getValue();
            }
        } else {
            serial.consist(new XBString(name));
            serial.consist(new XBString(description));
        }

        serial.listConsist(dependencies);
        serial.listConsist(optionals);
        serial.end();
    }

    private static class XBTToXBEventTypeRemover implements XBTEventListener, XBEventProducer {

        private XBEventListener eventListener;
        private boolean blockIdSent = false;

        public XBTToXBEventTypeRemover(XBEventListener eventListener) {
            this.eventListener = eventListener;
        }

        @Override
        public void putXBTToken(XBTToken token) throws XBProcessingException, IOException {
            switch (token.getTokenType()) {
                case BEGIN: {
                    eventListener.putXBToken(new XBBeginToken(((XBTBeginToken) token).getTerminationMode()));
                    blockIdSent = false;
                    break;
                }
                case TYPE: {
                    eventListener.putXBToken(new XBAttributeToken(new UBNat32()));
                    break;
                }
                case ATTRIBUTE: {
                    if (!blockIdSent) {
                        eventListener.putXBToken(new XBAttributeToken(new UBNat32()));
                        blockIdSent = true;
                    }
                    eventListener.putXBToken(new XBAttributeToken(((XBTAttributeToken) token).getAttribute()));
                    break;
                }
                case DATA: {
                    eventListener.putXBToken(new XBDataToken(((XBTDataToken) token).getData()));
                    break;
                }
                case END: {
                    eventListener.putXBToken(new XBEndToken());
                    break;
                }
            }
        }

        @Override
        public void attachXBEventListener(XBEventListener eventListener) {
            this.eventListener = eventListener;
        }
    }
}
