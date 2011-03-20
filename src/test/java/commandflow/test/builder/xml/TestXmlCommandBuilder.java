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
package commandflow.test.builder.xml;

import org.junit.Before;
import org.junit.Test;

import commandflow.builder.xml.XmlBuilderFactory;
import commandflow.builder.xml.XmlCommandBuilder;
import commandflow.builder.xml.v1.XmlBuilderConfigurerV1;
import commandflow.catalog.DefaultCommandCatalog;

/**
 * Tests {@link XmlCommandBuilder}.
 * <p>
 * Tests are done using schema of {@link XmlBuilderConfigurerV1} so as to avoid having to build a new schema just for testing.
 * @author elansma
 */
public class TestXmlCommandBuilder {
    private XmlCommandBuilder<Object> xmlCommandBuilder;
    private DefaultCommandCatalog<Object> commandCatalog;

    @Before
    public void init() {
        xmlCommandBuilder = XmlBuilderFactory.createBuilder(XmlBuilderFactory.NAMESPACE_COMMANDFLOW_V1);
        commandCatalog = new DefaultCommandCatalog<Object>();
    }

    @Test
    public void testBuild() {
        xmlCommandBuilder.build(commandCatalog);
    }
}
