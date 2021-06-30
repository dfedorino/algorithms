package com.dfedorino.rtasks.third_level.structures;

import com.dfedorino.rtasks.third_level.structures.implementations.ProtectedQueueProtocolDynamicImpl;
import com.dfedorino.rtasks.third_level.structures.implementations.ProtectedQueueProtocolStaticImpl;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ProtectedQueueProtocolTest {

    @Test(dataProvider = "implementations")
    public void testQueue_whenEmptyCommandList_thenEmptyProtocol(String name, ProtectedQueueProtocol queue) {
        List<String> commands = new ArrayList<>();
        assertThat(queue.generateProtocol(commands)).isEmpty();
    }

    @Test(dataProvider = "implementations")
    public void testPush_whenPushN_thenOk(String name, ProtectedQueueProtocol queue) {
        String push = "push" + " " + Integer.MAX_VALUE;
        List<String> commands = List.of(push);
        assertThat(queue.generateProtocol(commands))
                .hasSize(1)
                .contains("ok");
    }
    
    @Test(dataProvider = "implementations")
    public void testPop_whenAfterPush_thenDeletedValue(String name, ProtectedQueueProtocol queue) {
        String push = "push" + " " + Integer.MAX_VALUE;
        List<String> commands = List.of(push, "pop");
        assertThat(queue.generateProtocol(commands))
                .hasSize(2)
                .contains("ok")
                .contains(Integer.MAX_VALUE + "");
    }

    @Test(dataProvider = "implementations")
    public void testPop_whenEmptyQueue_thenError(String name, ProtectedQueueProtocol queue) {
        List<String> commands = List.of("pop");
        assertThat(queue.generateProtocol(commands))
                .hasSize(1)
                .contains("error");
    }

    @Test(dataProvider = "implementations")
    public void testFront_whenAfterPush_thenValueWithoutRemoving(String name, ProtectedQueueProtocol queue) {
        String push = "push" + " " + Integer.MAX_VALUE;
        List<String> commands = List.of(push, "front");
        assertThat(queue.generateProtocol(commands))
                .hasSize(2)
                .contains("ok")
                .contains(Integer.MAX_VALUE + "");
    }

    @Test(dataProvider = "implementations")
    public void testFront_whenEmptyQueue_thenError(String name, ProtectedQueueProtocol queue) {
        List<String> commands = List.of("front");
        assertThat(queue.generateProtocol(commands))
                .hasSize(1)
                .contains("error");
    }

    @Test(dataProvider = "implementations")
    public void testSize_whenEmptyQueue_thenZero(String name, ProtectedQueueProtocol queue) {
        List<String> commands = List.of("size");
        assertThat(queue.generateProtocol(commands))
                .hasSize(1)
                .contains(0 + "");
    }

    @Test(dataProvider = "implementations")
    public void testSize_whenNonEmptyQueue_thenActualSize(String name, ProtectedQueueProtocol queue) {
        String push = "push" + " " + Integer.MAX_VALUE;
        List<String> commands = List.of(push, "size");
        assertThat(queue.generateProtocol(commands))
                .hasSize(2)
                .contains("ok")
                .contains(1 + "");
    }

    @Test(dataProvider = "implementations")
    public void testSize_whenSizeAfterPop_thenSizeDecremented(String name, ProtectedQueueProtocol queue) {
        String push = "push" + " " + Integer.MAX_VALUE;
        List<String> commands = List.of(push, "size", "pop", "size");
        assertThat(queue.generateProtocol(commands))
                .hasSize(4)
                .contains("ok")
                .contains(1 + "")
                .contains(Integer.MAX_VALUE + "")
                .contains(0 + "");
    }

    @Test(dataProvider = "implementations")
    public void testSize_whenAfterFront_thenNotChanged(String name, ProtectedQueueProtocol queue) {
        String push = "push" + " " + Integer.MAX_VALUE;
        List<String> commands = List.of(push, "size", "front", "size");
        assertThat(queue.generateProtocol(commands))
                .hasSize(4)
                .contains("ok")
                .contains(1 + "")
                .contains(Integer.MAX_VALUE + "")
                .contains(1 + "");
    }

    @Test(dataProvider = "implementations")
    public void testSize_whenAfterPopOnEmptyQueue_thenZero(String name, ProtectedQueueProtocol queue) {
        List<String> commands = List.of("pop", "size");
        assertThat(queue.generateProtocol(commands))
                .hasSize(2)
                .contains("error")
                .contains(0 + "");
    }

    @Test(dataProvider = "implementations")
    public void testSize_whenAfterFrontOnEmptyQueue_thenZero(String name, ProtectedQueueProtocol queue) {
        List<String> commands = List.of("front", "size");
        assertThat(queue.generateProtocol(commands))
                .hasSize(2)
                .contains("error")
                .contains(0 + "");
    }

    @Test(dataProvider = "implementations")
    public void testClear_whenEmptyQueue_thenOk(String name, ProtectedQueueProtocol queue) {
        List<String> commands = List.of("clear");
        assertThat(queue.generateProtocol(commands))
                .hasSize(1)
                .contains("ok");
    }

    @Test(dataProvider = "implementations")
    public void testClear_whenEmptyQueue_thenSizeIsZero(String name, ProtectedQueueProtocol queue) {
        List<String> commands = List.of("clear", "size");
        assertThat(queue.generateProtocol(commands))
                .hasSize(2)
                .contains("ok")
                .contains(0 + "");
    }

    @Test(dataProvider = "implementations")
    public void testClear_whenNonEmptyQueue_thenOk(String name, ProtectedQueueProtocol queue) {
        String push = "push" + " " + Integer.MAX_VALUE;
        List<String> commands = List.of(push, "clear");
        assertThat(queue.generateProtocol(commands))
                .hasSize(2)
                .contains("ok")
                .contains("ok");
    }

    @Test(dataProvider = "implementations")
    public void testClear_whenNonEmptyQueue_thenSizeIsZero(String name, ProtectedQueueProtocol queue) {
        String push = "push" + " " + Integer.MAX_VALUE;
        List<String> commands = List.of(push, "size", "clear", "size");
        assertThat(queue.generateProtocol(commands))
                .hasSize(4)
                .contains("ok")
                .contains(1 + "")
                .contains("ok")
                .contains(0 + "");
    }

    @Test(dataProvider = "implementations")
    public void testExit_whenOnlyOne_thenBye(String name, ProtectedQueueProtocol queue) {
        List<String> commands = List.of("exit");
        assertThat(queue.generateProtocol(commands))
                .hasSize(1)
                .contains("bye");
    }

    @Test(dataProvider = "implementations")
    public void testExit_whenAtTheEnd_thenByeAndStop(String name, ProtectedQueueProtocol queue) {
        List<String> commands = List.of("size", "exit");
        assertThat(queue.generateProtocol(commands))
                .hasSize(2)
                .contains("bye");
    }

    @Test(dataProvider = "implementations")
    public void testExit_whenAtArbitraryPosition_thenByeAndStop(String name, ProtectedQueueProtocol queue) {
        List<String> commands = List.of("size", "exit", "size");
        assertThat(queue.generateProtocol(commands))
                .hasSize(2)
                .contains(0 + "")
                .contains("bye");
    }

    @Test(dataProvider = "implementations")
    public void testGenerateProtocol_whenPushToEmptyStack_thenSizeIncrements(String name, ProtectedQueueProtocol protocol) {
        List<String> commands = List.of("size", "push 1", "size");
        assertThat(protocol.generateProtocol(commands)).isEqualTo(List.of("0", "ok", "1"));
    }

    @Test(dataProvider = "implementations")
    public void testGenerateProtocol_whenPushMaxNumberOfElementsToEmptyStack_thenSizeIsMax(String name, ProtectedQueueProtocol protocol) {
        List<String> commands = IntStream.rangeClosed(1, ProtectedQueueProtocol.MAX_SIZE).mapToObj(i -> "push " + i).collect(Collectors.toList());
        commands.add("size");
        List<String> expectedProtocol = IntStream.rangeClosed(1, ProtectedQueueProtocol.MAX_SIZE).mapToObj(i -> "ok").collect(Collectors.toList());
        expectedProtocol.add(ProtectedQueueProtocol.MAX_SIZE + "");
        assertThat(protocol.generateProtocol(commands)).isEqualTo(expectedProtocol);
    }

    @Test(dataProvider = "implementations")
    public void testGenerateProtocol_whenPopAfterPush_thenSizeDecrements(String name, ProtectedQueueProtocol protocol) {
        List<String> commands = List.of("size", "push 1", "pop", "size");
        assertThat(protocol.generateProtocol(commands)).isEqualTo(List.of("0", "ok", "1", "0"));
    }

    @Test(dataProvider = "implementations")
    public void testGenerateProtocol_whenBackAfterPush_thenSizeIsSame(String name, ProtectedQueueProtocol protocol) {
        List<String> commands = List.of("size", "push 1", "front", "size");
        assertThat(protocol.generateProtocol(commands)).isEqualTo(List.of("0", "ok", "1", "1"));
    }

    @Test(dataProvider = "implementations")
    public void testGenerateProtocol_whenPushMaxNumberOfElementsAndClear_thenSizeIsZero(String name, ProtectedQueueProtocol protocol) {
        List<String> commands = IntStream.rangeClosed(1, ProtectedQueueProtocol.MAX_SIZE).mapToObj(i -> "push " + i).collect(Collectors.toList());
        commands.add("size");
        commands.add("clear");
        commands.add("size");
        List<String> expectedProtocol = IntStream.rangeClosed(1, ProtectedQueueProtocol.MAX_SIZE).mapToObj(i -> "ok").collect(Collectors.toList());
        expectedProtocol.add(ProtectedQueueProtocol.MAX_SIZE + "");
        expectedProtocol.add("ok");
        expectedProtocol.add("0");
        assertThat(protocol.generateProtocol(commands)).isEqualTo(expectedProtocol);
    }

    @Test(dataProvider = "implementations")
    public void testGenerateProtocol_whenPushAfterClearOnEmptyStack_thenOk(String name, ProtectedQueueProtocol protocol) {
        List<String> commands = List.of("size", "clear", "push 1", "size");
        assertThat(protocol.generateProtocol(commands)).isEqualTo(List.of("0", "ok", "ok", "1"));
    }

    @Test(dataProvider = "implementations")
    public void testGenerateProtocol_whenPushAfterClearOnNonEmptyStack_thenOk(String name, ProtectedQueueProtocol protocol) {
        List<String> commands = List.of("push 1", "size", "clear", "size");
        assertThat(protocol.generateProtocol(commands)).isEqualTo(List.of("ok", "1", "ok", "0"));
    }

    @Test(dataProvider = "implementations")
    public void testQueue_whenTestCase1_thenExpectedProtocol(String name, ProtectedQueueProtocol queue) {
        List<String> commands = List.of("push 1", "front", "exit");
        List<String> expectedProtocol = List.of("ok", "1", "bye");
        assertThat(queue.generateProtocol(commands)).isEqualTo(expectedProtocol);
    }

    @Test(dataProvider = "implementations")
    public void testQueue_whenTestCase2_thenExpectedProtocol(String name, ProtectedQueueProtocol queue) {
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
        assertThat(queue.generateProtocol(commands)).isEqualTo(expectedProtocol);
    }

    @DataProvider(name = "implementations")
    public Object[][] implementations() {
        return new Object[][] {
                {"Static implementation", new ProtectedQueueProtocolStaticImpl()},
                {"Dynamic implementation", new ProtectedQueueProtocolDynamicImpl()}
        };
    }
}