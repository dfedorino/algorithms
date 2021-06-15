package com.dfedorino.rtasks.third_level;

import lombok.Value;

import java.util.EmptyStackException;

/**
 * Реализуйте структуру данных "стек". Напишите программу:
 * 1. содержащую описание стека;
 * 2. моделирующую работу стека:
 *  + 2.1 push n - добавить в стек число n (значение n задается после команды). Программа должна вывести ok;
 * 2.2 pop - удалить из стека последний элемент. Программа должна вывести его значение;
 * 2.3 back - программа должна вывести значение последнего элемента, не удаляя его из стека;
 *  + 2.4 size - программа должна вывести количество элементов в стеке;
 * 2.5 clear - программа должна очистить стек и вывести ok;
 * 2.6 exit - программа должна вывести bye и завершить работу;
 *
 * Программа считывает последовательность команд и в зависимости от команды выполняет ту или иную операцию.
 * После выполнения каждой команды программа должна вывести одну строчку.
 */
public class SimpleStack {
    private Node<Integer> tail = new Node<>(null, null);
    private int size;

    public int size() {
        return size;
    }

    public Node<Integer> getTail() {
        return tail;
    }

    public boolean push(int i) {
        tail = new Node<>(i, tail);
        size++;
        return true;
    }

    public Integer pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        SimpleStack.Node<Integer> previous = tail.getPrevious();
        Integer popped = tail.getElement();
        tail = previous;
        size--;
        return popped;
    }

    @Value
    protected static class Node<T> {
        T element;
        Node<T> previous;
    }
}
