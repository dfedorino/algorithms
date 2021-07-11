package com.dfedorino.rtasks.third_level.structures.command;

import java.util.List;
import java.util.Stack;

public class StackCommandBuilder extends BaseCommandBuilder {
    private final Stack<Integer> stack;

    public StackCommandBuilder(List<String> commands, Stack<Integer> stack) {
        super(commands);
        this.stack = stack;
    }

    @Override
    public Command buildCommand(String commandString) {
        if (commandString.startsWith("push")) {
            return pushCommand(commandString, stack::push);
        } else if (commandString.equals("pop")) {
            return command(stack::pop);
        } else if (commandString.equals("back")) {
            return command(stack::peek);
        } else if (commandString.equals("size")) {
            return command(stack::size);
        } else if (commandString.equals("clear")) {
            return () -> {
                stack.clear();
                return new CommandResult("ok");
            };
        } else if (commandString.equals("exit")) {
            return () -> new CommandResult("bye");
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
