/**
 * Copyright 2010/2011, Martin Lansler
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.codegility.commandflow.binding.xml;

import java.util.Map;

import javax.xml.namespace.QName;

/**
 * Processor used to ignore a specific XML element, a no-op processor.
 * @author Martin Lansler
 */
public class IgnoreElementProcessor<C> implements XmlElementProcessor<C> {
    @Override
    public void startProcessing() {
        // no more
    }

    @Override
    public void startElement(XmlBindingHandler<C> handler, QName elementName, Map<String, String> attributes) {
        // no more
    }

    @Override
    public void endElement(XmlBindingHandler<C> handler, QName elementName) {
        // no more
    }

    @Override
    public void endProcessing() {
        // no more
    }

    @Override
    public IgnoreElementProcessor<C> clone() {
        return this; // no held state, so this is fine...
    }

}
