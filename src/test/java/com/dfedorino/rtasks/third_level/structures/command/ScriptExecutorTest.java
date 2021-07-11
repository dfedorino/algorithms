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
        CommandBuilder commandBuilder = new StackCommandBuilder(script, stack);
        List<Command> stackCommands = commandBuilder.buildCommands(); // commands
        ScriptExecutor stackScriptExecutor = new ScriptExecutor(stackCommands); // sender
        List<String> actualProtocol = stackScriptExecutor.generateProtocol();
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
        CommandBuilder commandBuilder = new QueueCommandBuilder(script, queue);
        List<Command> commands = commandBuilder.buildCommands(); // commands
        ScriptExecutor queueScriptExecutor = new ScriptExecutor(commands); // sender
        List<String> actualProtocol = queueScriptExecutor.generateProtocol();
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
        CommandBuilder commandBuilder = new DequeCommandBuilder(script, deque);
        List<Command> commands = commandBuilder.buildCommands(); // commands
        ScriptExecutor dequeScriptExecutor = new ScriptExecutor(commands); // sender
        List<String> actualProtocol = dequeScriptExecutor.generateProtocol();
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