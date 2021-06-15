package com.dfedorino.rtasks.third_level;

import java.util.Objects;

/**
 * Реализуйте структуру данных "стек". Напишите программу:
 * 1. содержащую описание стека;
 * 2. моделирующую работу стека:
 * 2.1 push n - добавить в стек число n (значение n задается после команды). Программа должна вывести ok;
 * 2.2 pop - удалить из стека последний элемент. Программа должна вывести его значение;
 * 2.3 back - программа должна вывести значение последнего элемента, не удаляя его из стека;
 * 2.4 size - программа должна вывести количество элементов в стеке;
 * 2.5 clear - программа должна очистить стек и вывести ok;
 * 2.6 exit - программа должна вывести bye и завершить работу;
 *
 * Программа считывает последовательность команд и в зависимости от команды выполняет ту или иную операцию.
 * После выполнения каждой команды программа должна вывести одну строчку.
 */
public class SimpleStack {
    private final Node<Integer> tail = new Node<>(null, null);

    public int size() {
        return 0;
    }

    public Node<Integer> getTail() {
        return tail;
    }

    protected static final class Node<T> {
        private final T element;
        private final Node<T> previous;

        public Node(T element, Node<T> previous) {
            this.element = element;
            this.previous = previous;
        }

        public T getElement() {
            return element;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || this.getClass() != o.getClass()) {
                return false;
            }
            Node<?> other = (Node<?>) o;
            return Objects.equals(this.element, other.element) && Objects.equals(this.previous, other.previous);
        }

        @Override
        public int hashCode() {
            return Objects.hash(element, previous);
        }
    }
}
