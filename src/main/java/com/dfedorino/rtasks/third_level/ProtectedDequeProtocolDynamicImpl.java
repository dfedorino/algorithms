package com.dfedorino.rtasks.third_level;

import lombok.Data;

import java.util.List;
import java.util.Objects;

public class ProtectedDequeProtocolDynamicImpl implements ProtectedDequeProtocol{
    @Override
    public List<String> generateProtocol(List<String> commands) {
        return null;
    }

    public interface ProtectedDeque<T> extends ProtectedQueueProtocolDynamicImpl.ProtectedQueue<T> {
    
        boolean pushFront(T element);
    
        T popBack();
    
        T back();
    }

    public static class ProtectedDequeImpl<T> implements ProtectedDeque<T> {
        private final Node<T> head;
        private final Node<T> tail;
        private int size = 0;
    
        public ProtectedDequeImpl() {
            head = new Node<>();
            tail = new Node<>();
            head.setNext(tail);
            tail.setPrevious(head);
        }
    
        @Override
        public boolean pushFront(T element) {
            Node<T> newNode = new Node<>();
            newNode.setElement(element);
            Node<T> currentAfterHead = head.getNext();
            head.setNext(newNode);
            newNode.setPrevious(head);
            newNode.setNext(currentAfterHead);
            currentAfterHead.setPrevious(newNode);
            size++;
            return true;
        }
    
        @Override
        public boolean pushBack(T element) {
            Node<T> newNode = new Node<>();
            newNode.setElement(element);
            Node<T> currentBeforeTail = tail.getPrevious();
            tail.setPrevious(newNode);
            newNode.setNext(tail);
            newNode.setPrevious(currentBeforeTail);
            currentBeforeTail.setNext(newNode);
            size++;
            return true;
        }
    
        @Override
        public T popFront() {
            if (size == 0) {
                throw new EmptyDequeException();
            }
            Node<T> currentAfterHead = head.getNext();
            Node<T> newAfterHead = currentAfterHead.getNext();
            T deleted = currentAfterHead.getElement();
            head.setNext(newAfterHead);
            newAfterHead.setPrevious(head);
            currentAfterHead.setNext(null);
            currentAfterHead.setPrevious(null);
            currentAfterHead.setElement(null);
            size--;
            return deleted;
        }
    
        @Override
        public T popBack() {
            if (size == 0) {
                throw new EmptyDequeException();
            }
            Node<T> currentBeforeTail = tail.getPrevious();
            Node<T> newBeforeTail = currentBeforeTail.getPrevious();
            T deleted = currentBeforeTail.getElement();
            tail.setPrevious(newBeforeTail);
            newBeforeTail.setNext(tail);
            currentBeforeTail.setNext(null);
            currentBeforeTail.setPrevious(null);
            currentBeforeTail.setElement(null);
            size--;
            return deleted;
        }
    
        @Override
        public T front() {
            if (size == 0) {
                throw new EmptyDequeException();
            }
            return head.getNext().getElement();
        }
    
        @Override
        public T back() {
            if (size == 0) {
                throw new EmptyDequeException();
            }
            return tail.getPrevious().getElement();
        }
    
        @Override
        public int size() {
            return size;
        }
    
        @Override
        public void clear() {
            Node<T> currentNode = head.getNext();
            while (!(currentNode.getNext() == null)) {
                Node<T> nextNode = currentNode.getNext();
                currentNode.setPrevious(null);
                currentNode.setElement(null);
                currentNode.setNext(null);
                currentNode = nextNode;
            }
            head.setNext(currentNode);
            currentNode.setPrevious(head);
            size = 0;
        }
    
        @Data
        static class Node<T> {
            private T element;
            private Node<T> next;
            private Node<T> previous;
    
            // TODO: refactor equals and hashcode. This is an unsafe implementation to avoid StackOverflow error;
            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Node<T> node = (Node<T>) o;
                T thisPreviousElement = this.previous == null ? null : previous.getElement();
                T thisNextElement = this.next == null ? null : next.getElement();
                T otherPreviousElement = node.previous == null ? null : node.previous.getElement();
                T otherNextElement = node.next == null ? null : node.next.getElement();
                return  Objects.equals(element, node.element) &&
                        Objects.equals(thisNextElement, otherNextElement) &&
                        Objects.equals(thisPreviousElement, otherPreviousElement);
            }
    
            // TODO: refactor equals and hashcode. This is an unsafe implementation to avoid StackOverflow error;
            @Override
            public int hashCode() {
                return Objects.hash(element, next.element, previous.element);
            }
    
            /**
             * For demonstration only!
             * @return visual representation of a node
             */
            @Override
            public String toString() {
                T previousElement = previous == null ? null : previous.getElement();
                T nextElement = next == null ? null : next.getElement();
                return "[" + previousElement + "] <-prev [" + element + "] next-> [" + nextElement + "]";
            }
        }
    
        /**
         * For demonstration only!
         * @return visual representation of current state of the deque
         */
        @Override
        public String toString() {
            StringBuilder string = new StringBuilder();
            Node<T> currentNode = head;
            while (currentNode != null) {
                boolean isHead = currentNode.getElement() == null & currentNode.getPrevious() == null;
                boolean isTail = currentNode.getElement() == null & currentNode.getNext() == null;
                if (isHead || isTail) {
                    string.append("[").append("dummyNode").append("]").append(" ");
                } else {
                    string.append(currentNode).append(" ");
                }
                currentNode = currentNode.getNext();
            }
            return string.toString().trim();
        }
    
        Node<T> getHead() {
            return head;
        }
    
        Node<T> getTail() {
            return tail;
        }
    }

    static class EmptyDequeException extends ProtectedQueueProtocolDynamicImpl.EmptyQueueException {}
}
