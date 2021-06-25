package com.dfedorino.rtasks.third_level.structures;

import java.util.List;

public interface Protocol {
    List<String> generateProtocol(List<String> commands);

    interface SimpleStack<T> {
        int MAX_SIZE = 100;

        String push(T n);

        String popBack();

        String back();

        String size();

        String clear();

        String exit();
    }

    interface ProtectedQueue<T> {
        int MAX_SIZE = 200;

        String push(T n);

        String popFront();

        String back();

        String size();

        String clear();

        String exit();
    }

    interface ProtectedDeque<T> extends ProtectedQueue<T>, SimpleStack<T> {
        int MAX_SIZE = 200;

        default String push(T n) {
            return this.pushBack(n);
        }

        String pushFront(T n);

        String pushBack(T n);

        String popFront();

        String popBack();

        String front();

        String back();

        String size();

        String clear();

        String exit();
    }
}