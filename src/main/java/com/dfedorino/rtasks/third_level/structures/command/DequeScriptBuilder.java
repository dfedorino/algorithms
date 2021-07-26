package com.dfedorino.rtasks.third_level.structures.command;

import java.util.Deque;

public class DequeScriptBuilder extends BaseScriptBuilder<Deque<Integer>> {
    @Override
    public Command<Deque<Integer>> getCommand(String commandString) {
        Commands<Deque<Integer>> commands = new Commands<>();
        if (commandString.startsWith("push_front")) {
            return commands.createPushCommandUsing(commandString, Deque::addFirst);
        } else if (commandString.startsWith("push_back")) {
            return commands.createPushCommandUsing(commandString, Deque::addLast);
        } else if (commandString.equals("pop_front")) {
            return commands.createCommandUsing(Deque::pollFirst);
        } else if (commandString.equals("pop_back")) {
            return commands.createCommandUsing(Deque::pollLast);
        } else if (commandString.equals("front")) {
            return commands.createCommandUsing(Deque::peekFirst);
        } else if (commandString.equals("back")) {
            return commands.createCommandUsing(Deque::peekLast);
        } else if (commandString.equals("size")) {
            return commands.createCommandUsing(Deque::size);
        } else if (commandString.equals("clear")) {
            return (deque) -> {
                deque.clear();
                return new CommandResult("ok");
            };
        } else if (commandString.equals("exit")) {
            return (deque) -> new CommandResult("bye");
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
