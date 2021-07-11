package com.dfedorino.rtasks.third_level.structures.command;

import java.util.Deque;
import java.util.List;

public class DequeCommandBuilder extends BaseCommandBuilder<Deque<Integer>> {

    public DequeCommandBuilder(List<String> commands) {
        super(commands);
    }

    @Override
    public Command<Deque<Integer>> buildCommand(String commandString) {
        if (commandString.startsWith("push_front")) {
            return pushCommand(commandString, Deque::addFirst);
        } else if (commandString.startsWith("push_back")) {
            return pushCommand(commandString, Deque::addLast);
        } else if (commandString.equals("pop_front")) {
            return command(Deque::pollFirst);
        } else if (commandString.equals("pop_back")) {
            return command(Deque::pollLast);
        } else if (commandString.equals("front")) {
            return command(Deque::peekFirst);
        } else if (commandString.equals("back")) {
            return command(Deque::peekLast);
        } else if (commandString.equals("size")) {
            return command(Deque::size);
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
