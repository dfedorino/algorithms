package com.dfedorino.rtasks.third_level.structures.implementations;

import java.util.ArrayList;
import java.util.List;

public class ProtectedQueueProtocolStaticImpl {

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
        int[] queue = new int[200];
        int first = 0;
        int last = -1;
        int size = 0;
        for (String command : commands) {
            if (command.startsWith("push ")) {
                int toBeAdded = Integer.parseInt(command.split(" ")[1]);
                if (last == queue.length - 1) {
                    last = -1;
                }
                queue[++last] = toBeAdded;
                size++;
                protocol.add("ok");
            } else if (command.equals("pop")) {
                if (size == 0) {
                    protocol.add("error");
                } else {
                    int popped = queue[first];
                    if (first == queue.length - 1) {
                        first = 0;
                    } else {
                        first++;
                    }
                    size--;
                    protocol.add(popped + "");
                }
            } else if (command.equals("front")) {
                if (size == 0) {
                    protocol.add("error");
                } else {
                    protocol.add(queue[first] + "");
                }
            } else if (command.equals("size")) {
                protocol.add(size + "");
            } else if (command.equals("clear")) {
                first = 0;
                last = -1;
                size = 0;
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
}
