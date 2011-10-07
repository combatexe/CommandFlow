package org.codegility.commandflow.test.bind.xml;

import javax.xml.namespace.QName;

import org.codegility.commandflow.bind.xml.BasicCommandProcessor;
import org.codegility.commandflow.bind.xml.CommandConfigurationProcessor;
import org.codegility.commandflow.bind.xml.XmlBindingHandler;
import org.junit.Test;

public class CommandConfigurationProcessorTest extends AbstractXmlElementProcessorTest {
    @Override
    protected String getTestResourceName() {
        return "commandConfigurationProcessorTest.xml";
    }

    @Override
    protected void setupBindingHandler(XmlBindingHandler<TestContext> xmlBindingHandler) {
        xmlBindingHandler.addElementProcessor(new QName("command"), new BasicCommandProcessor<TestContext>("class", "ref", "dynamic", "value"));
        xmlBindingHandler.addElementProcessor(new QName("property"), new CommandConfigurationProcessor<TestContext>("name", "value"));
    }

    @Test
    public void test() {
        TestContext context = assertExecute("testConfigure", true);
    }

}
