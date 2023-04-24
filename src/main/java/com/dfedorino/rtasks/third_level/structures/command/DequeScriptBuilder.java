package com.dfedorino.rtasks.third_level.structures.command;

import java.util.Deque;
import java.util.function.BiFunction;
import java.util.function.Function;

public class DequeScriptBuilder extends BaseScriptBuilder<Deque<Integer>> {
    public DequeScriptBuilder() {
        Function<String, Command<Deque<Integer>>> pushFrontCommand = (commandStr) -> {
            Integer parsedValue = Integer.parseInt(commandStr.split(" ")[1]);
            BiFunction<Integer, Deque<Integer>, CommandResult> operation = (value, deque) -> {
                deque.addFirst(value);
                return new CommandResult("ok");
            };
            return new CommandImpl<>(parsedValue, operation);
        };

        Function<String, Command<Deque<Integer>>> pushBackCommand = (commandStr) -> {
            Integer parsedValue = Integer.parseInt(commandStr.split(" ")[1]);
            BiFunction<Integer, Deque<Integer>, CommandResult> operation = (value, deque) -> {
                deque.addLast(value);
                return new CommandResult("ok");
            };
            return new CommandImpl<>(parsedValue, operation);
        };

        super.getStringToCommand().put("push_front", pushFrontCommand);
        super.getStringToCommand().put("push_back", pushBackCommand);
        super.getStringToCommand().put("pop_front", (commandStr) -> new CommandImpl<>(null, (value, deque) -> new CommandResult(deque.removeFirst() + "")));
        super.getStringToCommand().put("pop_back", (commandStr) -> new CommandImpl<>(null, (value, deque) -> new CommandResult(deque.removeLast() + "")));
        super.getStringToCommand().put("front", (commandStr) -> new CommandImpl<>(null, (value, deque) -> new CommandResult(deque.getFirst() + "")));
        super.getStringToCommand().put("back", (commandStr) -> new CommandImpl<>(null, (value, deque) -> new CommandResult(deque.getLast() + "")));
    }

    @Override
    public Command<Deque<Integer>> getCommand(String commandString) {
        if (commandString.startsWith("push")) {
            return commandString.contains("front") ?
                    super.getStringToCommand().get("push_front").apply(commandString) :
                    super.getStringToCommand().get("push_back").apply(commandString);
        } else if (commandString.startsWith("pop")) {
            return commandString.contains("front") ?
                    super.getStringToCommand().get("pop_front").apply(commandString) :
                    super.getStringToCommand().get("pop_back").apply(commandString);
        } else {
            Command<Deque<Integer>> existingCommand = super.getStringToCommand().get(commandString).apply(commandString);
            if (existingCommand == null) {
                throw new IllegalArgumentException("Command for " + commandString + " doesn't exist.");
            }
            return existingCommand;
        }
    }
}
