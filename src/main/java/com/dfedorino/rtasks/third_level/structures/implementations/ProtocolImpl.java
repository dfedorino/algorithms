package com.dfedorino.rtasks.third_level.structures.implementations;

import com.dfedorino.rtasks.third_level.structures.Protocol;

import java.util.ArrayList;
import java.util.List;

public class ProtocolImpl implements Protocol {
    @Override
    public List<String> generateProtocolForStack(List<String> commands) {
        Protocol.SimpleStack<Integer> stack = new SimpleArrayDeque<>();
        List<String> protocol = new ArrayList<>();
        for (String command : commands) {
            if (command.startsWith("push ")) {
                String[] commandTokens = command.split(" ");
                int toBePushed = Integer.parseInt(commandTokens[1]);
                protocol.add(stack.push(toBePushed));
            } else if (command.equals("pop")) {
                protocol.add(stack.popBack());
            } else if (command.equals("back")) {
                protocol.add(stack.back());
            } else if (command.equals("size")) {
                protocol.add(stack.size());
            } else if (command.equals("clear")) {
                protocol.add(stack.clear());
            } else if (command.equals("exit")) {
                protocol.add(stack.exit());
            } else {
                throw new UnsupportedOperationException();
            }
        }
        return protocol;
    }

    @Override
    public List<String> generateProtocolForQueue(List<String> commands) {
        Protocol.ProtectedQueue<Integer> queue = new SimpleArrayDeque<>();
        List<String> protocol = new ArrayList<>();
        for (String command : commands) {
            if (command.startsWith("push ")) {
                String[] commandTokens = command.split(" ");
                int toBePushed = Integer.parseInt(commandTokens[1]);
                protocol.add(queue.push(toBePushed));
            } else if (command.equals("pop")) {
                protocol.add(queue.popFront());
            } else if (command.equals("front")) {
                protocol.add(queue.front());
            } else if (command.equals("size")) {
                protocol.add(queue.size());
            } else if (command.equals("clear")) {
                protocol.add(queue.clear());
            } else if (command.equals("exit")) {
                protocol.add(queue.exit());
            } else {
                throw new UnsupportedOperationException();
            }
        }
        return protocol;
    }

    @Override
    public List<String> generateProtocolForDeque(List<String> commands) {
        Protocol.ProtectedDeque<Integer> deque = new SimpleArrayDeque<>();
        List<String> protocol = new ArrayList<>();
        for (String command : commands) {
            if (command.startsWith("push_front")) {
                String[] commandTokens = command.split(" ");
                int toBePushed = Integer.parseInt(commandTokens[1]);
                protocol.add(deque.pushFront(toBePushed));
            } else if(command.startsWith("push_back")) {
                String[] commandTokens = command.split(" ");
                int toBePushed = Integer.parseInt(commandTokens[1]);
                protocol.add(deque.pushBack(toBePushed));
            } else if(command.equals("pop_front")) {
                protocol.add(deque.popFront());
            } else if(command.equals("pop_back")) {
                protocol.add(deque.popBack());
            } else if(command.equals("front")) {
                protocol.add(deque.front());
            } else if (command.equals("back")) {
                protocol.add(deque.back() + "");
            } else if (command.equals("size")) {
                protocol.add(deque.size() + "");
            } else if (command.equals("clear")) {
                protocol.add(deque.clear());
            } else if (command.equals("exit")) {
                protocol.add(deque.exit());
            } else {
                throw new UnsupportedOperationException();
            }
        }
        return protocol;
    }
}
