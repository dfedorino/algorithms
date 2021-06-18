package com.dfedorino.rtasks.third_level;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ProtectedQueueProtocolTest {

    @Test(dataProvider = "protocolImplementations")
    public void testQueue_whenEmptyCommandList_thenEmptyProtocol(ProtectedQueueProtocol queue) {
        List<String> commands = new ArrayList<>();
        assertThat(queue.generateProtocol(commands)).isEmpty();
    }

    @Test(dataProvider = "protocolImplementations")
    public void testPush_whenPushDashInteger_thenOk(ProtectedQueueProtocol queue) {
        String push = "push" + " " + Integer.MAX_VALUE;
        List<String> commands = List.of(push);
        assertThat(queue.generateProtocol(commands))
                .hasSize(1)
                .contains("ok");
    }

    @Test(dataProvider = "protocolImplementations")
    public void testPush_whenPushWithoutDash_thenException(ProtectedQueueProtocol queue) {
        String push = "push" + Integer.MAX_VALUE;
        List<String> commands = List.of(push);
        assertThatThrownBy(() -> queue.generateProtocol(commands))
                .isInstanceOf(UnsupportedOperationException.class)
                .hasMessage(push);
    }

    // test push more than max elements then exception

    @Test(dataProvider = "protocolImplementations")
    public void testPop_whenAfterPush_thenDeletedValue(ProtectedQueueProtocol queue) {
        String push = "push" + " " + Integer.MAX_VALUE;
        List<String> commands = List.of(push, "pop");
        assertThat(queue.generateProtocol(commands))
                .hasSize(2)
                .contains("ok")
                .contains(Integer.MAX_VALUE + "");
    }

    @Test(dataProvider = "protocolImplementations")
    public void testPop_whenEmptyQueue_thenError(ProtectedQueueProtocol queue) {
        List<String> commands = List.of("pop");
        assertThat(queue.generateProtocol(commands))
                .hasSize(1)
                .contains("error");
    }

    @Test(dataProvider = "protocolImplementations")
    public void testFront_whenAfterPush_thenValueWithoutRemoving(ProtectedQueueProtocol queue) {
        String push = "push" + " " + Integer.MAX_VALUE;
        List<String> commands = List.of(push, "front");
        assertThat(queue.generateProtocol(commands))
                .hasSize(2)
                .contains("ok")
                .contains(Integer.MAX_VALUE + "");
    }

    @Test(dataProvider = "protocolImplementations")
    public void testFront_whenEmptyQueue_thenError(ProtectedQueueProtocol queue) {
        List<String> commands = List.of("front");
        assertThat(queue.generateProtocol(commands))
                .hasSize(1)
                .contains("error");
    }

    @Test(dataProvider = "protocolImplementations")
    public void testSize_whenEmptyQueue_thenZero(ProtectedQueueProtocol queue) {
        List<String> commands = List.of("size");
        assertThat(queue.generateProtocol(commands))
                .hasSize(1)
                .contains(0 + "");
    }

    @Test(dataProvider = "protocolImplementations")
    public void testSize_whenNonEmptyQueue_thenActualSize(ProtectedQueueProtocol queue) {
        String push = "push" + " " + Integer.MAX_VALUE;
        List<String> commands = List.of(push, "size");
        assertThat(queue.generateProtocol(commands))
                .hasSize(2)
                .contains("ok")
                .contains(1 + "");
    }

    @Test(dataProvider = "protocolImplementations")
    public void testSize_whenSizeAfterPop_thenSizeDecremented(ProtectedQueueProtocol queue) {
        String push = "push" + " " + Integer.MAX_VALUE;
        List<String> commands = List.of(push, "size", "pop", "size");
        assertThat(queue.generateProtocol(commands))
                .hasSize(4)
                .contains("ok")
                .contains(1 + "")
                .contains(Integer.MAX_VALUE + "")
                .contains(0 + "");
    }

    @Test(dataProvider = "protocolImplementations")
    public void testSize_whenAfterFront_thenNotChanged(ProtectedQueueProtocol queue) {
        String push = "push" + " " + Integer.MAX_VALUE;
        List<String> commands = List.of(push, "size", "front", "size");
        assertThat(queue.generateProtocol(commands))
                .hasSize(4)
                .contains("ok")
                .contains(1 + "")
                .contains(Integer.MAX_VALUE + "")
                .contains(1 + "");
    }

    @Test(dataProvider = "protocolImplementations")
    public void testSize_whenAfterPopOnEmptyQueue_thenZero(ProtectedQueueProtocol queue) {
        List<String> commands = List.of("pop", "size");
        assertThat(queue.generateProtocol(commands))
                .hasSize(2)
                .contains("error")
                .contains(0 + "");
    }

    @Test(dataProvider = "protocolImplementations")
    public void testSize_whenAfterFrontOnEmptyQueue_thenZero(ProtectedQueueProtocol queue) {
        List<String> commands = List.of("front", "size");
        assertThat(queue.generateProtocol(commands))
                .hasSize(2)
                .contains("error")
                .contains(0 + "");
    }

    @Test(dataProvider = "protocolImplementations")
    public void testClear_whenEmptyQueue_thenOk(ProtectedQueueProtocol queue) {
        List<String> commands = List.of("clear");
        assertThat(queue.generateProtocol(commands))
                .hasSize(1)
                .contains("ok");
    }

    @Test(dataProvider = "protocolImplementations")
    public void testClear_whenEmptyQueue_thenSizeIsZero(ProtectedQueueProtocol queue) {
        List<String> commands = List.of("clear", "size");
        assertThat(queue.generateProtocol(commands))
                .hasSize(2)
                .contains("ok")
                .contains(0 + "");
    }

    @Test(dataProvider = "protocolImplementations")
    public void testClear_whenNonEmptyQueue_thenOk(ProtectedQueueProtocol queue) {
        String push = "push" + " " + Integer.MAX_VALUE;
        List<String> commands = List.of(push, "clear");
        assertThat(queue.generateProtocol(commands))
                .hasSize(2)
                .contains("ok")
                .contains("ok");
    }

    @Test(dataProvider = "protocolImplementations")
    public void testClear_whenNonEmptyQueue_thenSizeIsZero(ProtectedQueueProtocol queue) {
        String push = "push" + " " + Integer.MAX_VALUE;
        List<String> commands = List.of(push, "size", "clear", "size");
        assertThat(queue.generateProtocol(commands))
                .hasSize(4)
                .contains("ok")
                .contains(1 + "")
                .contains("ok")
                .contains(0 + "");
    }

    @Test(dataProvider = "protocolImplementations")
    public void testExit_whenOnlyOne_thenBye(ProtectedQueueProtocol queue) {
        List<String> commands = List.of("exit");
        assertThat(queue.generateProtocol(commands))
                .hasSize(1)
                .contains("bye");
    }

    @Test(dataProvider = "protocolImplementations")
    public void testExit_whenAtTheEnd_thenByeAndStop(ProtectedQueueProtocol queue) {
        List<String> commands = List.of("size", "exit");
        assertThat(queue.generateProtocol(commands))
                .hasSize(2)
                .contains("bye");
    }

    @Test(dataProvider = "protocolImplementations")
    public void testExit_whenAtArbitraryPosition_thenByeAndStop(ProtectedQueueProtocol queue) {
        List<String> commands = List.of("size", "exit", "size");
        assertThat(queue.generateProtocol(commands))
                .hasSize(2)
                .contains(0 + "")
                .contains("bye");
    }

    @Test(dataProvider = "protocolImplementations")
    public void testQueue_whenTestCase1_thenExpectedProtocol(ProtectedQueueProtocol queue) {
        List<String> commands = List.of("push 1", "front", "exit");
        List<String> expectedProtocol = List.of("ok", "1", "bye");
        assertThat(queue.generateProtocol(commands)).isEqualTo(expectedProtocol);
    }

    @Test(dataProvider = "protocolImplementations")
    public void testQueue_whenTestCase2_thenExpectedProtocol(ProtectedQueueProtocol queue) {
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

    /* TODO: test edge cases
    [0][0][0][0][5]
                 l
                 f
     test push
     test pop

    [1][0][0][0][0]
     l
     f
     test push
     test pop
    */

    // TODO: test push and pop after clear

    // TODO: test max capacity by pushing max size elements

    // TODO: test max commands number by pushing and popping max size of elements up to 5 times

    @DataProvider(name = "protocolImplementations")
    public Object[][] protocolImplementations() {
        return new Object[][] {
                {new ProtectedQueueProtocolStaticImpl()},
                {new ProtectedQueueProtocolDynamicImpl()}
        };
    }
}