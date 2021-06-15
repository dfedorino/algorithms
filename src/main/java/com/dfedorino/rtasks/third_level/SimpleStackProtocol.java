package com.dfedorino.rtasks.third_level;

import java.util.ArrayList;
import java.util.List;

public class SimpleStackProtocol {
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
     * <p>
     * Программа считывает последовательность команд и в зависимости от команды выполняет ту или иную операцию.
     * После выполнения каждой команды программа должна вывести одну строчку.
     *
     * @param commands - последовательность команд
     * @return последовательность строчек согласно переданным командам
     */
    public List<String> generateSimpleStackProtocol(List<String> commands) {
        List<String> protocol = new ArrayList<>();
        SimpleStack stack = new SimpleStack();
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
