package com.dfedorino.rtasks.third_level.structures.command;

import java.util.Stack;
import java.util.function.BiFunction;
import java.util.function.Function;

public class StackScriptBuilder extends BaseScriptBuilder<Stack<Integer>> {
    public StackScriptBuilder() {

        Function<String, Command<Stack<Integer>>> pushCommand = (commandStr) -> {
            Integer parsedValue = Integer.parseInt(commandStr.split(" ")[1]);
            BiFunction<Integer, Stack<Integer>, CommandResult> operation = (value, stack) -> {
                stack.push(value);
                return new CommandResult("ok");
            };
            return new CommandImpl<>(parsedValue, operation);
        };

        super.getStringToCommand().put("push", pushCommand);
        super.getStringToCommand().put("pop", (commandStr) -> new CommandImpl<>(null, (value, stack) -> new CommandResult(stack.pop() + "")));
        super.getStringToCommand().put("back", (commandStr) -> new CommandImpl<>(null, (value, stack) -> new CommandResult(stack.peek() + "")));
    }

    @Override
    public Command<Stack<Integer>> getCommand(String commandString) {
        if (commandString.startsWith("push")) {
            return super.getStringToCommand().get("push").apply(commandString);
        } else {
            Command<Stack<Integer>> existingCommand = super.getStringToCommand().get(commandString).apply(commandString);
            if (existingCommand == null) {
                throw new IllegalArgumentException("Command for " + commandString + " doesn't exist.");
            }
            return existingCommand;
        }
    }
}
