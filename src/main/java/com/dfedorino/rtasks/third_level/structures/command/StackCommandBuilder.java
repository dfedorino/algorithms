package com.dfedorino.rtasks.third_level.structures.command;

import java.util.List;
import java.util.Stack;

public class StackCommandBuilder extends BaseCommandBuilder<Stack<Integer>> {

    public StackCommandBuilder(List<String> commands) {
        super(commands);
    }

    @Override
    public Command<Stack<Integer>> buildCommand(String commandString) {
        if (commandString.startsWith("push")) {
            return pushCommand(commandString, Stack::push);
        } else if (commandString.equals("pop")) {
            return command(Stack::pop);
        } else if (commandString.equals("back")) {
            return command(Stack::peek);
        } else if (commandString.equals("size")) {
            return command(Stack::size);
        } else if (commandString.equals("clear")) {
            return (stack) -> {
                stack.clear();
                return new CommandResult("ok");
            };
        } else if (commandString.equals("exit")) {
            return (stack) -> new CommandResult("bye");
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
