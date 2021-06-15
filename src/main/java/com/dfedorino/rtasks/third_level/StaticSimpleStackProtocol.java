package com.dfedorino.rtasks.third_level;

import java.util.ArrayList;
import java.util.List;

public class StaticSimpleStackProtocol implements SimpleStackProtocol {
    public List<String> generateProtocol(List<String> commands) {
        int[] stack = new int[100];
        int size = 0;
        List<String> protocol = new ArrayList<>();
        for (String command : commands) {
            if (command.startsWith("push")) {
                int number = Integer.parseInt(command.split(" ")[1]);
                stack[size++] = number;
                protocol.add("ok");
            } else if (command.equals("pop")) {
                int popped = stack[size - 1];
                stack[size--] = 0;
                protocol.add(popped + "");
            } else if (command.equals("back")) {
                protocol.add(stack[size - 1] + "");
            } else if (command.equals("size")) {
                protocol.add(size + "");
            } else if (command.equals("clear")) {
                while (size != 0) {
                    stack[size--] = 0;
                }
                stack[0] = 0;
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
