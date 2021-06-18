package com.dfedorino.rtasks.third_level;

import java.util.ArrayList;
import java.util.List;

public class ProtectedQueueProtocolDynamicImpl implements ProtectedQueueProtocol {

    /**
     * Реализуйте структуру данных "очередь". Напишите программу, содержащую описание очереди и
     * моделирующую работу очереди, реализовав все указанные здесь методы.
     * Программа считывает последовательность команд и в зависимости от команды выполняет
     * ту или иную операцию. После выполнения каждой команды программа должна вывести одну строчку.
     * Возможные команды для программы:
     * <p>
     * push n
     * Добавить в очередь число n (значение n задается после команды). Программа должна вывести ok.
     * pop
     * Удалить из очереди первый элемент. Программа должна вывести его значение.
     * front
     * Программа должна вывести значение первого элемента, не удаляя его из очереди.
     * size
     * Программа должна вывести количество элементов в очереди.
     * clear
     * Программа должна очистить очередь и вывести ok.
     * exit
     * Программа должна вывести bye и завершить работу.
     * Перед исполнением операций front и pop программа должна проверять, содержится ли в очереди
     * хотя бы один элемент. Если во входных данных встречается операция front или pop, и при этом
     * очередь пуста, то программа должна вместо числового значения вывести строку error.
     * <p>
     * Входные данные
     * Вводятся команды управления очередью, по одной на строке. Количество команд не превосходит
     * миллиона, в каждый момент времени в очереди не более 200 элементов.
     * <p>
     * Выходные данные
     * Требуется вывести протокол работы очереди, по одному сообщению на строке
     *
     * @param commands - команды управления очередью
     * @return протокол работы очереди
     */

    public List<String> generateProtocol(List<String> commands) {
        List<String> protocol = new ArrayList<>();
        ProtectedQueue<Integer> queue = new ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl<>();
        for (String command : commands) {
            if (command.startsWith("push ")) {
                int toBeAdded = Integer.parseInt(command.split(" ")[1]);
                queue.pushBack(toBeAdded);
                protocol.add("ok");
            } else if (command.equals("pop")) {
                try {
                    Integer popped = queue.popFront();
                    protocol.add(popped + "");
                } catch (EmptyQueueException e) {
                    protocol.add("error");
                }
            } else if (command.equals("front")) {
                try {
                    protocol.add(queue.front() + "");
                } catch (EmptyQueueException e) {
                    protocol.add("error");
                }
            } else if (command.equals("size")) {
                protocol.add(queue.size() + "");
            } else if (command.equals("clear")) {
                queue.clear();
                protocol.add("ok");
            } else if (command.equals("exit")) {
                protocol.add("bye");
                break;
            } else {
                throw new UnsupportedOperationException(command);
            }
        }
        return protocol;
    }

    public interface ProtectedQueue<T> {

        int size();

        boolean pushBack(T element);

        T popFront();

        T front();

        void clear();
    }

    static class EmptyQueueException extends RuntimeException {}
}
