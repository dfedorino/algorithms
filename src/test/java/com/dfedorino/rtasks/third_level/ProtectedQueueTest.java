package com.dfedorino.rtasks.third_level;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ProtectedQueueTest {
    private final ProtectedQueue queue = new ProtectedQueue();

    @Test
    public void testQueue_whenEmptyCommandList_thenEmptyProtocol() {
        List<String> commands = new ArrayList<>();
        assertThat(queue.generateProtocol(commands)).isEmpty();
    }

    @Test
    public void testPush_whenPushDashInteger_thenOk() {
        String push = "push" + " " + Integer.MAX_VALUE;
        List<String> commands = List.of(push);
        assertThat(queue.generateProtocol(commands))
                .hasSize(1)
                .contains("ok");
    }

    @Test
    public void testPush_whenPushWithoutDash_thenException() {
        String push = "push" + Integer.MAX_VALUE;
        List<String> commands = List.of(push);
        assertThatThrownBy(() -> queue.generateProtocol(commands))
                .isInstanceOf(UnsupportedOperationException.class)
                .hasMessage(push);
    }

    // test push more than max elements then exception

    @Test
    public void testPop_whenAfterPush_thenDeletedValue() {
        String push = "push" + " " + Integer.MAX_VALUE;
        List<String> commands = List.of(push, "pop");
        assertThat(queue.generateProtocol(commands))
                .hasSize(2)
                .contains("ok")
                .contains(Integer.MAX_VALUE + "");
    }

    @Test
    public void testPop_whenEmptyQueue_thenError() {
        List<String> commands = List.of("pop");
        assertThat(queue.generateProtocol(commands))
                .hasSize(1)
                .contains("error");
    }

    @Test
    public void testFront_whenAfterPush_thenValueWithoutRemoving() {
        String push = "push" + " " + Integer.MAX_VALUE;
        List<String> commands = List.of(push, "front");
        assertThat(queue.generateProtocol(commands))
                .hasSize(2)
                .contains("ok")
                .contains(Integer.MAX_VALUE + "");
    }

    @Test
    public void testFront_whenEmptyQueue_thenError() {
        List<String> commands = List.of("front");
        assertThat(queue.generateProtocol(commands))
                .hasSize(1)
                .contains("error");
    }

    @Test
    public void testSize_whenEmptyQueue_thenZero() {
        List<String> commands = List.of("size");
        assertThat(queue.generateProtocol(commands))
                .hasSize(1)
                .contains(0 + "");
    }

    @Test
    public void testSize_whenNonEmptyQueue_thenActualSize() {
        String push = "push" + " " + Integer.MAX_VALUE;
        List<String> commands = List.of(push, "size");
        assertThat(queue.generateProtocol(commands))
                .hasSize(2)
                .contains("ok")
                .contains(1 + "");
    }

    @Test
    public void testSize_whenSizeAfterPop_thenSizeDecremented() {
        String push = "push" + " " + Integer.MAX_VALUE;
        List<String> commands = List.of(push, "size", "pop", "size");
        assertThat(queue.generateProtocol(commands))
                .hasSize(4)
                .contains("ok")
                .contains(1 + "")
                .contains(Integer.MAX_VALUE + "")
                .contains(0 + "");
    }

    @Test
    public void testSize_whenAfterFront_thenNotChanged() {
        String push = "push" + " " + Integer.MAX_VALUE;
        List<String> commands = List.of(push, "size", "front", "size");
        assertThat(queue.generateProtocol(commands))
                .hasSize(4)
                .contains("ok")
                .contains(1 + "")
                .contains(Integer.MAX_VALUE + "")
                .contains(1 + "");
    }

    @Test
    public void testSize_whenAfterPopOnEmptyQueue_thenZero() {
        List<String> commands = List.of("pop", "size");
        assertThat(queue.generateProtocol(commands))
                .hasSize(2)
                .contains("error")
                .contains(0 + "");
    }

    @Test
    public void testSize_whenAfterFrontOnEmptyQueue_thenZero() {
        List<String> commands = List.of("front", "size");
        assertThat(queue.generateProtocol(commands))
                .hasSize(2)
                .contains("error")
                .contains(0 + "");
    }

    @Test
    public void testClear_whenEmptyQueue_thenOk() {
        List<String> commands = List.of("clear");
        assertThat(queue.generateProtocol(commands))
                .hasSize(1)
                .contains("ok");
    }

    @Test
    public void testClear_whenEmptyQueue_thenSizeIsZero() {
        List<String> commands = List.of("clear", "size");
        assertThat(queue.generateProtocol(commands))
                .hasSize(2)
                .contains("ok")
                .contains(0 + "");
    }

    @Test
    public void testClear_whenNonEmptyQueue_thenOk() {
        String push = "push" + " " + Integer.MAX_VALUE;
        List<String> commands = List.of(push, "clear");
        assertThat(queue.generateProtocol(commands))
                .hasSize(2)
                .contains("ok")
                .contains("ok");
    }

    @Test
    public void testClear_whenNonEmptyQueue_thenSizeIsZero() {
        String push = "push" + " " + Integer.MAX_VALUE;
        List<String> commands = List.of(push, "size", "clear", "size");
        assertThat(queue.generateProtocol(commands))
                .hasSize(4)
                .contains("ok")
                .contains(1 + "")
                .contains("ok")
                .contains(0 + "");
    }

    @Test
    public void testExit_whenOnlyOne_thenBye() {
        List<String> commands = List.of("exit");
        assertThat(queue.generateProtocol(commands))
                .hasSize(1)
                .contains("bye");
    }

    @Test
    public void testExit_whenAtTheEnd_thenByeAndStop() {
        List<String> commands = List.of("size", "exit");
        assertThat(queue.generateProtocol(commands))
                .hasSize(2)
                .contains("bye");
    }

    @Test
    public void testExit_whenAtArbitraryPosition_thenByeAndStop() {
        List<String> commands = List.of("size", "exit", "size");
        assertThat(queue.generateProtocol(commands))
                .hasSize(2)
                .contains(0 + "")
                .contains("bye");
    }

    @Test
    public void testQueue_whenTestCase1_thenExpectedProtocol() {
        List<String> commands = List.of("push 1", "front", "exit");
        List<String> expectedProtocol = List.of("ok", "1", "bye");
        assertThat(queue.generateProtocol(commands)).isEqualTo(expectedProtocol);
    }

    @Test
    public void testQueue_whenTestCase2_thenExpectedProtocol() {
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
}