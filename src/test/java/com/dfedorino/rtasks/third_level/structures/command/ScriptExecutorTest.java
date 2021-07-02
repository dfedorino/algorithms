package com.dfedorino.rtasks.third_level.structures.command;

import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

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
        List<Command> stackCommands = script.stream()
                .map(commandString -> CommandFactory.createCommand(stack, commandString))
                .collect(Collectors.toList()); // commands
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
    public void testGenerateProtocol_whenStackScript1_thenExpectedProtocol() {
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
        Stack<Integer> stack = new Stack<>(); // получатель
        List<Command> commands = script.stream()
                .map(commandString -> CommandFactory.createCommand(stack, commandString))
                .collect(Collectors.toList()); // команды
        ScriptExecutor stackScriptExecutor = new ScriptExecutor(commands); // отправитель
        List<String> actualProtocol = stackScriptExecutor.generateProtocol();
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
        List<Command> commands = script.stream()
                .map(commandString -> CommandFactory.createCommand(queue, commandString))
                .collect(Collectors.toList()); // commands
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
        List<Command> commands = script.stream()
                .map(commandString -> CommandFactory.createCommand(deque, commandString))
                .collect(Collectors.toList()); // commands
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