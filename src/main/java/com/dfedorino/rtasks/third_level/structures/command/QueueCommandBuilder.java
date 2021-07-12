package com.dfedorino.rtasks.third_level.structures.command;

import java.util.List;
import java.util.Queue;

public class QueueCommandBuilder extends BaseCommandBuilder<Queue<Integer>> {

    public QueueCommandBuilder(List<String> commands) {
        super(commands);
    }

    @Override
    public Command<Queue<Integer>> buildCommand(String commandString) {
        Commands<Queue<Integer>> commands = new Commands<>();
        if (commandString.startsWith("push")) {
            return commands.pushCommand(commandString, Queue::offer);
        } else if (commandString.equals("pop")) {
            return (queue) -> queue.isEmpty() ? new CommandResult("error") : new CommandResult(String.valueOf(queue.poll()));
        } else if (commandString.equals("front")) {
            return (queue) -> queue.isEmpty() ? new CommandResult("error") : new CommandResult(String.valueOf(queue.peek()));
        } else if (commandString.equals("size")) {
            return commands.command(Queue::size);
        } else if (commandString.equals("clear")) {
            return (queue) -> {
                queue.clear();
                return new CommandResult("ok");
            };
        } else if (commandString.equals("exit")) {
            return (queue) -> new CommandResult("bye");
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
