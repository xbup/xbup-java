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
package org.xbup.tool.editor.base.api;

import java.util.List;
import java.util.prefs.Preferences;

/**
 * Interface for basic options panels.
 *
 * @version 0.1.22 2013/03/18
 * @author XBUP Project (http://xbup.org)
 */
public interface OptionsPanel {

    /**
     * Get path in options dialog.
     *
     * @return path to options dialog
     */
    public List<PathItem> getPath();

    /**
     * Inicialize configuration from given properties.
     */
    public void applyPreferencesChanges();

    /**
     * Load configuration from given properties.
     *
     * @param preferences
     */
    public void loadFromPreferences(Preferences preferences);

    /**
     * Save configuration from given properties.
     *
     * @param preferences
     */
    public void saveToPreferences(Preferences preferences);

    /**
     * Register listener for changes monitoring.
     *
     * @param listener modified option listener
     */
    public void setModifiedOptionListener(ModifiedOptionListener listener);

    public class PathItem {

        private String name;
        private String caption;

        public PathItem() {
        }

        public PathItem(String name, String caption) {
            this.name = name;
            if (caption == null) {
                caption = name;
            }

            this.caption = caption;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCaption() {
            return caption;
        }

        public void setCaption(String caption) {
            this.caption = caption;
        }
    }

    public interface ModifiedOptionListener {

        public void wasModified();
    }
}
