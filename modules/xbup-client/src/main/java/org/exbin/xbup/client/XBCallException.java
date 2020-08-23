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
package org.exbin.xbup.client;

/**
 * Exception class for service calls.
 *
 * @version 0.2.1 2020/08/23
 * @author ExBin Project (http://exbin.org)
 */
public class XBCallException extends RuntimeException {

    public XBCallException() {
    }

    public XBCallException(String message) {
        super(message);
    }

    public XBCallException(String message, Throwable cause) {
        super(message, cause);
    }

    public XBCallException(Throwable cause) {
        super(cause);
    }

    public XBCallException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
