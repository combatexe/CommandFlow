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
 * Interface for processing an XML element with associated attributes.
 * <p>
 * Typical processors can create commands, handle import clauses etc.
 * <p>
 * A command processor that creates a command pushes the command onto the handler stack using {@link XmlBindingHandler#pushCommand(org.codegility.commandflow.Command, String)} when processing the
 * start of the element. The created command must subsequently be popped using {@link XmlBindingHandler#popCommand()} when processing the end of the element.
 * <p>
 * A processor may be stateful internally, if needed it will be cloned.
 * 
 * @author Martin Lansler
 * @param <C> the context class of the commands
 */
public interface XmlElementProcessor<C> {
    /**
     * Called to notify the processor that processing has commenced.
     * <p>
     * This is mainly intended to facilitate processor internal house-keeping tasks.
     */
    void startProcessing();

    /**
     * Called to process the start of the given XML element.
     * 
     * @param handler the XML binding handler
     * @param elementName the qualified name of the XML element
     * @param attributes the map of attributes (maps from attribute name to value)
     */
    void startElement(XmlBindingHandler<C> handler, QName elementName, Map<String, String> attributes);

    /**
     * Called to process the end of the given XML element
     * @param handler the XML binding handler
     * @param elementName the qualified name of the XML element
     */
    void endElement(XmlBindingHandler<C> handler, QName elementName);

    /**
     * Called to notify the processor that processing has ended.
     * <p>
     * This is mainly intended to facilitate processor internal house-keeping tasks, like clearing held resources etc.
     */
    void endProcessing();

    /**
     * Clones this XML element processor.
     * @return a deep copy of this XML element processor
     */
    XmlElementProcessor<C> clone();
}
