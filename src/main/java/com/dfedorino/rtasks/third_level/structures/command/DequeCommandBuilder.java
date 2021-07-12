package com.dfedorino.rtasks.third_level.structures.command;

import java.util.Deque;
import java.util.List;

public class DequeCommandBuilder extends BaseCommandBuilder<Deque<Integer>> {

    public DequeCommandBuilder(List<String> commands) {
        super(commands);
    }

    @Override
    public Command<Deque<Integer>> buildCommand(String commandString) {
        Commands<Deque<Integer>> commands = new Commands<>();
        if (commandString.startsWith("push_front")) {
            return pushCommand(commandString, Deque::addFirst);
        } else if (commandString.startsWith("push_back")) {
            return pushCommand(commandString, Deque::addLast);
        } else if (commandString.equals("pop_front")) {
            return commands.command(Deque::pollFirst);
        } else if (commandString.equals("pop_back")) {
            return commands.command(Deque::pollLast);
        } else if (commandString.equals("front")) {
            return commands.command(Deque::peekFirst);
        } else if (commandString.equals("back")) {
            return commands.command(Deque::peekLast);
        } else if (commandString.equals("size")) {
            return commands.command(Deque::size);
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
