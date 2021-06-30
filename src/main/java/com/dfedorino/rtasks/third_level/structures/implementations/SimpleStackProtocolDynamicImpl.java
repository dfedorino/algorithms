package com.dfedorino.rtasks.third_level.structures.implementations;

import com.dfedorino.rtasks.third_level.structures.SimpleStackProtocol;
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

