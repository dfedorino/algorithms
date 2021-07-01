package com.dfedorino.rtasks.third_level.structures.command;

import java.util.Deque;
import java.util.Queue;
import java.util.Stack;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CommandFactory {

    private CommandFactory() {}

    public static Command createCommand(Stack<Integer> stack, String commandString) {
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

    public static Command createCommand(Queue<Integer> queue, String commandString) {
        if (commandString.startsWith("push")) {
            return pushCommand(commandString, queue::offer);
        } else if (commandString.equals("pop")) {
            return command(queue::poll);
        } else if (commandString.equals("front")) {
            return command(queue::peek);
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

    public static Command createCommand(Deque<Integer> deque, String commandString) {
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

    private static Command pushCommand(String commandString, Consumer<Integer> collectionMethod) {
        return () -> {
            Integer data = Integer.parseInt(commandString.split(" ")[1]);
            collectionMethod.accept(data);
            return new CommandResult("ok");
        };
    }

    private static Command command(Supplier<Integer> collectionPopMethod) {
        return () -> new CommandResult(String.valueOf(collectionPopMethod.get()));
    }
}
