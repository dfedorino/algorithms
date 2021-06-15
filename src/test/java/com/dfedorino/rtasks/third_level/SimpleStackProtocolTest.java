package com.dfedorino.rtasks.third_level;

import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleStackProtocolTest {

    @Test
    public void testGetSimpleStackProtocol() {
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
        List<String> dynamicStackProtocol = new DynamicSimpleStackProtocol().generateProtocol(commands);
        List<String> staticStackProtocol = new StaticSimpleStackProtocol().generateProtocol(commands);
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
        assertThat(dynamicStackProtocol).isEqualTo(expectedProtocol);
        assertThat(staticStackProtocol).isEqualTo(expectedProtocol);
    }
}