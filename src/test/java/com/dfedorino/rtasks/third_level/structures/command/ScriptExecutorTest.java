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
        List<String> commandStrings = List.of(
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
        ScriptBuilder<Stack<Integer>> scriptBuilder = new StackScriptBuilder();
        Script<Stack<Integer>> stackScript = scriptBuilder.buildScript(commandStrings); // commands
        ScriptExecutor<Stack<Integer>> scriptExecutor = new ScriptExecutor<>(); // sender
        Protocol<String> actualProtocol = scriptExecutor.generateProtocol(stackScript, stack);
        Protocol<String> expectedProtocol = new Protocol<>(List.of(
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

        ));
        assertThat(actualProtocol).isEqualTo(expectedProtocol);
    }

    @Test
    public void testGenerateProtocol_whenQueueScript_thenExpectedProtocol() {
        Queue<Integer> queue = new ArrayDeque<>(); // receiver
        List<String> commandStrings = List.of(
                "push 1",
                "front",
                "exit"
        );
        ScriptBuilder<Queue<Integer>> scriptBuilder = new QueueScriptBuilder();
        Script<Queue<Integer>> queueScript = scriptBuilder.buildScript(commandStrings); // commands
        ScriptExecutor<Queue<Integer>> scriptExecutor = new ScriptExecutor<>(); // sender
        Protocol<String> actualProtocol = scriptExecutor.generateProtocol(queueScript, queue);
        Protocol<String> expectedProtocol = new Protocol<>(List.of(
                "ok",
                "1",
                "bye"
        ));
        assertThat(actualProtocol).isEqualTo(expectedProtocol);
    }

    @Test
    public void testGenerateProtocol_whenDequeScript_thenExpectedProtocol() {
        Deque<Integer> deque = new ArrayDeque<>();
        List<String> commandStrings = List.of(
                "size",
                "push_back 1",
                "size",
                "push_back 2",
                "size",
                "push_front 3",
                "size",
                "exit"
        );
        ScriptBuilder<Deque<Integer>> scriptBuilder = new DequeScriptBuilder();
        Script<Deque<Integer>> dequeScript = scriptBuilder.buildScript(commandStrings); // commands
        ScriptExecutor<Deque<Integer>> scriptExecutor = new ScriptExecutor<>(); // sender
        Protocol<String> actualProtocol = scriptExecutor.generateProtocol(dequeScript, deque);
        Protocol<String> expectedProtocol = new Protocol<>(List.of(
                "0",
                "ok",
                "1",
                "ok",
                "2",
                "ok",
                "3",
                "bye"
        ));
        assertThat(actualProtocol).isEqualTo(expectedProtocol);
    }
}