package com.dfedorino.rtasks.third_level.structures.command;

import java.util.Stack;

public class StackScriptBuilder extends BaseScriptBuilder<Stack<Integer>> {
    @Override
    public Command<Stack<Integer>> createCommand(String commandString) {
        Commands<Stack<Integer>> commands = new Commands<>();
        if (commandString.startsWith("push")) {
            return commands.createPushCommandUsing(commandString, Stack::push);
        } else if (commandString.equals("pop")) {
            return commands.createCommandUsing(Stack::pop);
        } else if (commandString.equals("back")) {
            return commands.createCommandUsing(Stack::peek);
        } else if (commandString.equals("size")) {
            return commands.createCommandUsing(Stack::size);
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
