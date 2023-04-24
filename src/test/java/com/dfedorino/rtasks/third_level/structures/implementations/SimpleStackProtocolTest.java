package com.dfedorino.rtasks.third_level.structures.implementations;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleStackProtocolTest {

    @Test(dataProvider = "implementations")
    public void testGenerateProtocol_whenPushN_thenOk(String name, SimpleStackProtocol protocol) {
        assertThat(protocol.generateProtocol(List.of("push 5"))).isEqualTo(List.of("ok"));
    }

    @Test(dataProvider = "implementations")
    public void testGenerateProtocol_whenPop_thenDeletedValue(String name, SimpleStackProtocol protocol) {
        String push = "push " + Integer.MAX_VALUE;
        List<String> commands = List.of(push, "pop");
        assertThat(protocol.generateProtocol(commands)).isEqualTo(List.of("ok", Integer.MAX_VALUE + ""));
    }

    @Test(dataProvider = "implementations")
    public void testGenerateProtocol_whenBack_thenValue(String name, SimpleStackProtocol protocol) {
        String push = "push " + Integer.MAX_VALUE;
        List<String> commands = List.of(push, "back");
        assertThat(protocol.generateProtocol(commands)).isEqualTo(List.of("ok", Integer.MAX_VALUE + ""));
    }

    @Test(dataProvider = "implementations")
    public void testGenerateProtocol_whenSize_thenNumberOfElements(String name, SimpleStackProtocol protocol) {
        String push = "push " + Integer.MAX_VALUE;
        List<String> commands = List.of(push, "size");
        assertThat(protocol.generateProtocol(commands)).isEqualTo(List.of("ok", 1 + ""));
    }

    @Test(dataProvider = "implementations")
    public void testGenerateProtocol_whenClear_thenOk(String name, SimpleStackProtocol protocol) {
        String push = "push " + Integer.MAX_VALUE;
        List<String> commands = List.of(push, "clear");
        assertThat(protocol.generateProtocol(commands)).isEqualTo(List.of("ok", "ok"));
    }

    @Test(dataProvider = "implementations")
    public void testGenerateProtocol_whenExit_thenBye(String name, SimpleStackProtocol protocol) {
        List<String> commands = List.of("exit");
        assertThat(protocol.generateProtocol(commands)).isEqualTo(List.of("bye"));
    }

    @Test(dataProvider = "implementations")
    public void testGenerateProtocol_whenPushToEmptyStack_thenSizeIncrements(String name, SimpleStackProtocol protocol) {
        List<String> commands = List.of("size", "push 1", "size");
        assertThat(protocol.generateProtocol(commands)).isEqualTo(List.of("0", "ok", "1"));
    }

    @Test(dataProvider = "implementations")
    public void testGenerateProtocol_whenPushMaxNumberOfElementsToEmptyStack_thenSizeIsMax(String name, SimpleStackProtocol protocol) {
        List<String> commands = IntStream.rangeClosed(1, SimpleStackProtocol.MAX_SIZE).mapToObj(i -> "push " + i).collect(Collectors.toList());
        commands.add("size");
        List<String> expectedProtocol = IntStream.rangeClosed(1, SimpleStackProtocol.MAX_SIZE).mapToObj(i -> "ok").collect(Collectors.toList());
        expectedProtocol.add(SimpleStackProtocol.MAX_SIZE + "");
        assertThat(protocol.generateProtocol(commands)).isEqualTo(expectedProtocol);
    }

    @Test(dataProvider = "implementations")
    public void testGenerateProtocol_whenPopAfterPush_thenSizeDecrements(String name, SimpleStackProtocol protocol) {
        List<String> commands = List.of("size", "push 1", "pop", "size");
        assertThat(protocol.generateProtocol(commands)).isEqualTo(List.of("0", "ok", "1", "0"));
    }

    @Test(dataProvider = "implementations")
    public void testGenerateProtocol_whenBackAfterPush_thenSizeIsSame(String name, SimpleStackProtocol protocol) {
        List<String> commands = List.of("size", "push 1", "back", "size");
        assertThat(protocol.generateProtocol(commands)).isEqualTo(List.of("0", "ok", "1", "1"));
    }

    @Test(dataProvider = "implementations")
    public void testGenerateProtocol_whenPushMaxNumberOfElementsAndClear_thenSizeIsZero(String name, SimpleStackProtocol protocol) {
        List<String> commands = IntStream.rangeClosed(1, SimpleStackProtocol.MAX_SIZE).mapToObj(i -> "push " + i).collect(Collectors.toList());
        commands.add("size");
        commands.add("clear");
        commands.add("size");
        List<String> expectedProtocol = IntStream.rangeClosed(1, SimpleStackProtocol.MAX_SIZE).mapToObj(i -> "ok").collect(Collectors.toList());
        expectedProtocol.add(SimpleStackProtocol.MAX_SIZE + "");
        expectedProtocol.add("ok");
        expectedProtocol.add("0");
        assertThat(protocol.generateProtocol(commands)).isEqualTo(expectedProtocol);
    }

    @Test(dataProvider = "implementations")
    public void testGetSimpleStackProtocol(String name, SimpleStackProtocol protocol) {
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

    @DataProvider(name = "implementations")
    public Object[][] implementations() {
        return new Object[][] {
                {"Static implementation", new SimpleStackProtocolStaticImpl()}
        };
    }
}