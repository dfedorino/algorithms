package com.dfedorino.rtasks.third_level;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleStackProtocolTest {

    @Test(dataProvider = "protocolImplementations")
    public void testGetSimpleStackProtocol(SimpleStackProtocol protocol) {
        List<String> commands = List.of(
                "push 3",
                "push 14",
                "size",
                "clear",
                "push 1",
                "back",
                "push 2",
                "back",
                "pop",
                "size",
                "pop",
                "size",
                "exit"
        );
        List<String> actualProtocol = protocol.generateProtocol(commands);
        List<String> expectedProtocol = List.of(
                "ok",
                "ok",
                "2",
                "ok",
                "ok",
                "1",
                "ok",
                "2",
                "2",
                "1",
                "1",
                "0",
                "bye"
        );
        assertThat(actualProtocol).isEqualTo(expectedProtocol);
    }

    @DataProvider(name = "protocolImplementations")
    public Object[][] protocolImplementations() {
        return new Object[][] {
                {new SimpleStackProtocolStaticImpl()},
                {new SimpleStackProtocolDynamicImpl()}
        };
    }
}