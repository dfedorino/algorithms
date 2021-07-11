package com.dfedorino.rtasks.third_level.structures.command;

import java.util.List;
import java.util.Queue;

public class QueueCommandBuilder extends BaseCommandBuilder {
    private final Queue<Integer> queue;

    public QueueCommandBuilder(List<String> commands, Queue<Integer> queue) {
        super(commands);
        this.queue = queue;
    }

    @Override
    public Command<Queue<Integer>> buildCommand(String commandString) {
        if (commandString.startsWith("push")) {
            return pushCommand(commandString, queue::offer);
        } else if (commandString.equals("pop")) {
            return () -> queue.isEmpty() ? new CommandResult("error") : new CommandResult(String.valueOf(queue.poll()));
        } else if (commandString.equals("front")) {
            return () -> queue.isEmpty() ? new CommandResult("error") : new CommandResult(String.valueOf(queue.peek()));
        } else if (commandString.equals("size")) {
            return command(queue::size);
        } else if (commandString.equals("clear")) {
            return () -> {
                queue.clear();
                return new CommandResult("ok");
            };
        } else if (commandString.equals("exit")) {
            return () -> new CommandResult("bye");
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
