package com.dfedorino.rtasks.third_level.structures.implementations;

import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class ProtocolImplTest {
    private final ProtocolImpl protocolGenerator = new ProtocolImpl();

    @Test
    public void testGenerateProtocolForStack() {
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
        List<String> actualProtocol = protocolGenerator.generateProtocolForStack(commands);
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

    @Test
    public void testGenerateProtocolForQueue() {
        List<String> commands = List.of(
                "size",
                "push 1",
                "size",
                "push 2",
                "size",
                "push 3",
                "size",
                "exit"
        );
        List<String> expectedProtocol = List.of(
                "0",
                "ok",
                "1",
                "ok",
                "2",
                "ok",
                "3",
                "bye"
        );
        assertThat(protocolGenerator.generateProtocolForQueue(commands)).isEqualTo(expectedProtocol);
    }

    @Test
    public void testGenerateProtocolForDeque() {
        List<String> commands = List.of(
                "size",
                "push_back 1",
                "size",
                "push_back 2",
                "size",
                "push_front 3",
                "size",
                "exit"

        );
        List<String> expectedProtocol = List.of(
                "0",
                "ok",
                "1",
                "ok",
                "2",
                "ok",
                "3",
                "bye"
        );
        assertThat(protocolGenerator.generateProtocolForDeque(commands)).isEqualTo(expectedProtocol);
    }
}