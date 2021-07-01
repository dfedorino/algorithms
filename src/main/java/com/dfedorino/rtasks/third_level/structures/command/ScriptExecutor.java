package com.dfedorino.rtasks.third_level.structures.command;

import java.util.Deque;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

public class ScriptExecutor {
    public List<String> generateProtocol(Stack<Integer> stack, List<String> commandStrings) {
        return commandStrings.stream()
                .map(commandString -> CommandFactory.createCommand(stack, commandString))
                .map(Command::execute)
                .map(CommandResult::getValue)
                .collect(Collectors.toList());
    }

    public List<String> generateProtocol(Queue<Integer> queue, List<String> commandStrings) {
        return commandStrings.stream()
                .map(commandString -> CommandFactory.createCommand(queue, commandString)).filter(Objects::nonNull)
                .map(Command::execute)
                .map(CommandResult::getValue)
                .collect(Collectors.toList());
    }

    public List<String> generateProtocol(Deque<Integer> deque, List<String> commandStrings) {
        return commandStrings.stream()
                .map(commandString -> CommandFactory.createCommand(deque, commandString)).filter(Objects::nonNull)
                .map(Command::execute)
                .map(CommandResult::getValue)
                .collect(Collectors.toList());
    }
}
