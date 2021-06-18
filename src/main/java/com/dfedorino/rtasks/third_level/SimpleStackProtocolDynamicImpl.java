package com.dfedorino.rtasks.third_level;

import lombok.Value;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class SimpleStackProtocolDynamicImpl implements SimpleStackProtocol {
    public List<String> generateProtocol(List<String> commands) {
        List<String> protocol = new ArrayList<>();
        DynamicSimpleStack stack = new DynamicSimpleStack();
        for (String command : commands) {
            if (command.startsWith("push")) {
                String[] commandTokens = command.split(" ");
                int toBePushed = Integer.parseInt(commandTokens[1]);
                stack.push(toBePushed);
                protocol.add("ok");
            } else if (command.equals("pop")) {
                protocol.add(stack.pop() + "");
            } else if (command.equals("back")) {
                protocol.add(stack.top() + "");
            } else if (command.equals("size")) {
                protocol.add(stack.size() + "");
            } else if (command.equals("clear")) {
                stack.clear();
                protocol.add("ok");
            } else if (command.equals("exit")) {
                protocol.add("bye");
            } else {
                throw new UnsupportedOperationException();
            }
        }
        return protocol;
    }
}

class DynamicSimpleStack {
    private Node<Integer> tail = new Node<>(null, null);
    private int size;

    public int size() {
        return size;
    }

    protected Node<Integer> getTail() {
        return tail;
    }

    public boolean push(int i) {
        tail = new Node<>(i, tail);
        size++;
        return true;
    }

    public Integer pop() {
        validateSize();
        Node<Integer> previous = tail.getPrevious();
        Integer popped = tail.getElement();
        tail = previous;
        size--;
        return popped;
    }

    public Integer top() {
        validateSize();
        return tail.getElement();
    }

    private void validateSize() {
        if (size == 0) {
            throw new EmptyStackException();
        }
    }

    public void clear() {
        tail = new Node<>(null, null);
        System.gc();
        size = 0;
    }

    @Value
    protected static class Node<T> {
        T element;
        Node<T> previous;
    }
}
