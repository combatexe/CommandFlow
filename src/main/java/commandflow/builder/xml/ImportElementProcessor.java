/**
 * Copyright 2010 Martin Lansler (elansma), Anders Jacobsson
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
package commandflow.builder.xml;

import java.util.Map;

import javax.xml.namespace.QName;

/**
 * An element processor for an import element containing an reference to another command XML.
 * <p>
 * The current {@link XmlCommandBuilder} is cloned and invoked to build the import command XML.
 * @author elansma
 */
public class ImportElementProcessor<C> implements XmlElementProcessor<C> {

    /** {@inheritDoc} */
    @Override
    public void startElement(XmlCommandBuilder<C> xmlCommandBuilder, QName elementName, Map<String, String> attributes) {
        // TODO
    }

    /** {@inheritDoc} */
    @Override
    public void endElement(XmlCommandBuilder<C> xmlCommandBuilder, QName elementName) {
        // TODO

    }

}