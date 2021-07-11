package com.dfedorino.rtasks.third_level.structures.command;

import java.util.Deque;
import java.util.List;

public class DequeCommandBuilder extends BaseCommandBuilder<Deque<Integer>> {
    private final Deque<Integer> deque;

    public DequeCommandBuilder(List<String> commands, Deque<Integer> deque) {
        super(commands);
        this.deque = deque;
    }

    @Override
    public Command<Deque<Integer>> buildCommand(String commandString) {
        if (commandString.startsWith("push_front")) {
            return pushCommand(commandString, deque::addFirst);
        } else if (commandString.startsWith("push_back")) {
            return pushCommand(commandString, deque::addLast);
        } else if (commandString.equals("pop_front")) {
            return command(deque::pollFirst);
        } else if (commandString.equals("pop_back")) {
            return command(deque::pollLast);
        } else if (commandString.equals("front")) {
            return command(deque::peekFirst);
        } else if (commandString.equals("back")) {
            return command(deque::peekLast);
        } else if (commandString.equals("size")) {
            return command(deque::size);
        } else if (commandString.equals("clear")) {
            return () -> {
                deque.clear();
                return new CommandResult("ok");
            };
        } else if (commandString.equals("exit")) {
            return () -> new CommandResult("bye");
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
