package com.dfedorino.rtasks.third_level.structures.command;

import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class ScriptExecutorTest {
    private final ScriptExecutor executor = new ScriptExecutor();

    @Test
    public void testGenerateProtocol_whenStackScript_thenExpectedProtocol() {
        Stack<Integer> stack = new Stack<>();
        List<String> script = List.of(
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
        List<String> actualProtocol = executor.generateProtocol(stack, script);
        assertThat(actualProtocol).isEqualTo(expectedProtocol);
    }

    @Test
    public void testGenerateProtocol_whenQueueScript_thenExpectedProtocol() {
        Queue<Integer> queue = new ArrayDeque<>();
        List<String> script = List.of(
                "push 1",
                "front",
                "exit"
        );
        List<String> expectedProtocol = List.of(
                "ok",
                "1",
                "bye"
        );
        List<String> actualProtocol = executor.generateProtocol(queue, script);
        assertThat(actualProtocol).isEqualTo(expectedProtocol);
    }

    @Test
    public void testGenerateProtocol_whenDequeScript_thenExpectedProtocol() {
        Deque<Integer> deque = new ArrayDeque<>();
        List<String> script = List.of(
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
        List<String> actualProtocol = executor.generateProtocol(deque, script);
        assertThat(actualProtocol).isEqualTo(expectedProtocol);
    }
}