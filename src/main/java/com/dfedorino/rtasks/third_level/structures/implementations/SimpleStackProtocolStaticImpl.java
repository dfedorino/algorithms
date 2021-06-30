package com.dfedorino.rtasks.third_level.structures.implementations;


import com.dfedorino.rtasks.third_level.structures.SimpleStackProtocol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleStackProtocolStaticImpl implements SimpleStackProtocol {
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
                Arrays.fill(stack, 0);
                size = 0;
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
