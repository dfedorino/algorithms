package com.dfedorino.rtasks.third_level.structures.command;

import java.util.Queue;
import java.util.function.BiFunction;
import java.util.function.Function;

public class QueueScriptBuilder extends BaseScriptBuilder<Queue<Integer>> {
    public QueueScriptBuilder() {
        Function<String, Command<Queue<Integer>>> pushCommand = (commandStr) -> {
            Integer parsedValue = Integer.parseInt(commandStr.split(" ")[1]);
            BiFunction<Integer, Queue<Integer>, CommandResult> operation = (value, queue) -> {
                queue.offer(value);
                return new CommandResult("ok");
            };
            return new CommandImpl<>(parsedValue, operation);
        };

        super.getStringToCommand().put("push", pushCommand);
        super.getStringToCommand().put("pop", (commandStr) -> new CommandImpl<>(null, (value, queue) -> new CommandResult(queue.poll() + "")));
        super.getStringToCommand().put("front", (commandStr) -> new CommandImpl<>(null, (value, queue) -> new CommandResult(queue.peek() + "")));
    }

    @Override
    public Command<Queue<Integer>> getCommand(String commandString) {
        if (commandString.startsWith("push")) {
            return super.getStringToCommand().get("push").apply(commandString);
        } else {
            Command<Queue<Integer>> existingCommand = super.getStringToCommand().get(commandString).apply(commandString);
            if (existingCommand == null) {
                throw new IllegalArgumentException("Command for " + commandString + " doesn't exist.");
            }
            return existingCommand;
        }
    }
}
