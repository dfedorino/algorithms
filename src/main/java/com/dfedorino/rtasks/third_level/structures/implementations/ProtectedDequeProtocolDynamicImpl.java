package com.dfedorino.rtasks.third_level.structures.implementations;

import com.dfedorino.rtasks.third_level.structures.ProtectedDequeProtocol;

import java.util.ArrayList;
import java.util.List;

public class ProtectedDequeProtocolDynamicImpl implements ProtectedDequeProtocol {
    @Override
    public List<String> generateProtocol(List<String> commands) {
        List<String> protocol = new ArrayList<>();
        ProtectedDeque<Integer> deque = new DynamicProtectedDeque<>();
        for (String command : commands) {
            if (command.startsWith("push_front")) {
                deque.pushFront(extractedNumberFrom(command));
                protocol.add("ok");
            } else if(command.startsWith("push_back")) {
                deque.pushBack(extractedNumberFrom(command));
                protocol.add("ok");
            } else if(command.equals("pop_front")) {
                protocol.add(deque.popFront() + "");
            } else if(command.equals("pop_back")) {
                protocol.add(deque.popBack() + "");
            } else if(command.equals("front")) {
                protocol.add(deque.front() + "");
            } else if(command.equals("back")) {
                protocol.add(deque.back() + "");
            } else if(command.equals("size")) {
                protocol.add(deque.size() + "");
            } else if(command.equals("clear")) {
                deque.clear();
                protocol.add("ok");
            } else if(command.equals("exit")) {
                protocol.add("bye");
            } else {
                throw new UnsupportedOperationException();
            }
        }
        return protocol;
    }

    private int extractedNumberFrom(String command) {
        return Integer.parseInt(command.split(" ")[1]);
    }

    public interface ProtectedDeque<T> extends ProtectedQueueProtocolDynamicImpl.ProtectedQueue<T> {
    
        boolean pushFront(T element);
    
        T popBack();
    
        T back();
    }

    static class EmptyDequeException extends ProtectedQueueProtocolDynamicImpl.EmptyQueueException {}
}
