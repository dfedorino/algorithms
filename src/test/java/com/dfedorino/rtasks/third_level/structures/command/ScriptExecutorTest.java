package com.dfedorino.rtasks.third_level.structures.command;

import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class ScriptExecutorTest {
    @Test
    public void testGenerateProtocol_whenStackScript_thenExpectedProtocol() {
        Stack<Integer> stack = new Stack<>(); // receiver
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
        CommandBuilder<Stack<Integer>> commandBuilder = new StackCommandBuilder(script);
        List<Command<Stack<Integer>>> stackCommands = commandBuilder.buildCommands(); // commands
        ScriptExecutor<Stack<Integer>> stackScriptExecutor = new ScriptExecutor<>(stackCommands); // sender
        List<String> actualProtocol = stackScriptExecutor.generateProtocol(stack);
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
    public void testGenerateProtocol_whenQueueScript_thenExpectedProtocol() {
        Queue<Integer> queue = new ArrayDeque<>(); // receiver
        List<String> script = List.of(
                "push 1",
                "front",
                "exit"
        );
        CommandBuilder<Queue<Integer>> commandBuilder = new QueueCommandBuilder(script);
        List<Command<Queue<Integer>>> commands = commandBuilder.buildCommands(); // commands
        ScriptExecutor<Queue<Integer>> queueScriptExecutor = new ScriptExecutor<>(commands); // sender
        List<String> actualProtocol = queueScriptExecutor.generateProtocol(queue);
        List<String> expectedProtocol = List.of(
                "ok",
                "1",
                "bye"
        );
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
        CommandBuilder<Deque<Integer>> commandBuilder = new DequeCommandBuilder(script);
        List<Command<Deque<Integer>>> commands = commandBuilder.buildCommands(); // commands
        ScriptExecutor<Deque<Integer>> dequeScriptExecutor = new ScriptExecutor<>(commands); // sender
        List<String> actualProtocol = dequeScriptExecutor.generateProtocol(deque);
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
        assertThat(actualProtocol).isEqualTo(expectedProtocol);
    }
}