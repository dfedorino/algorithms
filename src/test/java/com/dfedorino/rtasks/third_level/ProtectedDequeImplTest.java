package com.dfedorino.rtasks.third_level;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProtectedDequeImplTest {

    @Test
    public void testToString() {
        ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl<Integer> deque = new ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl<>();
        String expected = "[dummyNode] [dummyNode]";
        assertThat(deque.toString()).isEqualTo(expected);
    }

    @Test
    public void testPushFront() {
        ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl<Integer> deque = new ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl<>();
        deque.pushFront(1);
        String expected = "[dummyNode] [null] <-prev [1] next-> [null] [dummyNode]";
        assertThat(deque.toString()).isEqualTo(expected);
        assertThat(deque.size()).isEqualTo(1);
        ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl.Node<Integer> head = new ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl.Node<>();
        ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl.Node<Integer> one = new ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl.Node<>();
        ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl.Node<Integer> tail = new ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl.Node<>();
        head.setPrevious(null);
        head.setNext(one);
        one.setElement(1);
        one.setPrevious(head);
        tail.setPrevious(one);
        tail.setNext(null);
        assertThat(deque.getHead()).isEqualTo(head);
        assertThat(deque.getHead().getNext()).isEqualTo(one);
        assertThat(deque.getTail()).isEqualTo(tail);
    }

    @Test
    public void testPushBack() {
        ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl<Integer> deque = new ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl<>();
        deque.pushFront(1);
        deque.pushBack(2);
        String expected = "[dummyNode] [null] <-prev [1] next-> [2] [1] <-prev [2] next-> [null] [dummyNode]";
        assertThat(deque.toString()).isEqualTo(expected);
        assertThat(deque.size()).isEqualTo(2);
        ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl.Node<Integer> head = new ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl.Node<>();
        ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl.Node<Integer> one = new ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl.Node<>();
        ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl.Node<Integer> two = new ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl.Node<>();
        ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl.Node<Integer> tail = new ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl.Node<>();
        head.setPrevious(null);
        head.setNext(one);
        one.setElement(1);
        one.setPrevious(head);
        one.setNext(two);
        two.setPrevious(one);
        two.setElement(2);
        two.setNext(tail);
        tail.setPrevious(two);
        tail.setNext(null);
        assertThat(deque.getHead()).isEqualTo(head);
        assertThat(deque.getHead().getNext()).isEqualTo(one);
        assertThat(deque.getTail().getPrevious()).isEqualTo(two);
        assertThat(deque.getTail()).isEqualTo(tail);
    }

    @Test
    public void testPopFront() {
        ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl<Integer> deque = new ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl<>();
        // fill in
        deque.pushFront(1);
        deque.pushBack(2);
        String expectedBeforePopFront = "[dummyNode] [null] <-prev [1] next-> [2] [1] <-prev [2] next-> [null] [dummyNode]";
        assertThat(deque.toString()).isEqualTo(expectedBeforePopFront);
        assertThat(deque.size()).isEqualTo(2);
        // actual test
        deque.popFront();
        String expected = "[dummyNode] [null] <-prev [2] next-> [null] [dummyNode]";
        assertThat(deque.toString()).isEqualTo(expected);
        assertThat(deque.size()).isEqualTo(1);
        ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl.Node<Integer> head = new ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl.Node<>();
        ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl.Node<Integer> two = new ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl.Node<>();
        ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl.Node<Integer> tail = new ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl.Node<>();
        head.setPrevious(null);
        head.setNext(two);
        two.setPrevious(head);
        two.setElement(2);
        two.setNext(tail);
        tail.setPrevious(two);
        tail.setNext(null);
        assertThat(deque.getHead()).isEqualTo(head);
        assertThat(deque.getTail().getPrevious()).isEqualTo(two);
        assertThat(deque.getTail()).isEqualTo(tail);
    }

    @Test
    public void testPopBack() {
        ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl<Integer> deque = new ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl<>();
        // fill in
        deque.pushFront(1);
        deque.pushBack(2);
        String expectedBeforePopBack = "[dummyNode] [null] <-prev [1] next-> [2] [1] <-prev [2] next-> [null] [dummyNode]";
        assertThat(deque.toString()).isEqualTo(expectedBeforePopBack);
        assertThat(deque.size()).isEqualTo(2);
        // actual test
        deque.popBack();
        String expected = "[dummyNode] [null] <-prev [1] next-> [null] [dummyNode]";
        assertThat(deque.toString()).isEqualTo(expected);
        assertThat(deque.size()).isEqualTo(1);
        ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl.Node<Integer> head = new ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl.Node<>();
        ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl.Node<Integer> one = new ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl.Node<>();
        ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl.Node<Integer> tail = new ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl.Node<>();
        head.setPrevious(null);
        head.setNext(one);
        one.setPrevious(head);
        one.setElement(1);
        one.setNext(tail);
        tail.setPrevious(one);
        tail.setNext(null);
        assertThat(deque.getHead()).isEqualTo(head);
        assertThat(deque.getTail().getPrevious()).isEqualTo(one);
        assertThat(deque.getTail()).isEqualTo(tail);
    }

    @Test
    public void testFront() {
        ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl<Integer> deque = new ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl<>();
        // fill in
        deque.pushFront(1);
        deque.pushBack(2);
        String expectedBeforeFront = "[dummyNode] [null] <-prev [1] next-> [2] [1] <-prev [2] next-> [null] [dummyNode]";
        assertThat(deque.toString()).isEqualTo(expectedBeforeFront);
        assertThat(deque.size()).isEqualTo(2);
        // actual test
        assertThat(deque.front()).isEqualTo(1);
        assertThat(deque.size()).isEqualTo(2);
        assertThat(deque.toString()).isEqualTo(expectedBeforeFront);
    }

    @Test
    public void testBack() {
        ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl<Integer> deque = new ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl<>();
        // fill in
        deque.pushFront(1);
        deque.pushBack(2);
        String expectedBeforeBack = "[dummyNode] [null] <-prev [1] next-> [2] [1] <-prev [2] next-> [null] [dummyNode]";
        assertThat(deque.toString()).isEqualTo(expectedBeforeBack);
        assertThat(deque.size()).isEqualTo(2);
        // actual test
        assertThat(deque.back()).isEqualTo(2);
        assertThat(deque.size()).isEqualTo(2);
        assertThat(deque.toString()).isEqualTo(expectedBeforeBack);
    }

    @Test
    public void testSize() {
        ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl<Integer> deque = new ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl<>();
        // fill in
        deque.pushFront(1);
        deque.pushBack(2);
        String expectedState = "[dummyNode] [null] <-prev [1] next-> [2] [1] <-prev [2] next-> [null] [dummyNode]";
        assertThat(deque.toString()).isEqualTo(expectedState);
        // actual test
        assertThat(deque.size()).isEqualTo(2);
    }

    @Test
    public void testClear() {
        ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl<Integer> deque = new ProtectedDequeProtocolDynamicImpl.ProtectedDequeImpl<>();
        // fill in
        deque.pushFront(1);
        deque.pushBack(2);
        String expectedState = "[dummyNode] [null] <-prev [1] next-> [2] [1] <-prev [2] next-> [null] [dummyNode]";
        assertThat(deque.toString()).isEqualTo(expectedState);
        // actual test
        deque.clear();
        String expectedAfterClear = "[dummyNode] [dummyNode]";
        assertThat(deque.toString()).isEqualTo(expectedAfterClear);
        assertThat(deque.size()).isEqualTo(0);
    }
}