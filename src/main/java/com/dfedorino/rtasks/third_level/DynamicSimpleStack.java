package com.dfedorino.rtasks.third_level;

import lombok.Value;

import java.util.EmptyStackException;

public class DynamicSimpleStack {
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
