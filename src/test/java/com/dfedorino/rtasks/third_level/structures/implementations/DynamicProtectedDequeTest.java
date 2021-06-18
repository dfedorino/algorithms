package com.dfedorino.rtasks.third_level.structures.implementations;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DynamicProtectedDequeTest {

    @Test
    public void testToString() {
        DynamicProtectedDeque<Integer> deque = new DynamicProtectedDeque<>();
        String expected = "[dummyNode] [dummyNode]";
        assertThat(deque.toString()).isEqualTo(expected);
    }

    @Test
    public void testPushFront() {
        DynamicProtectedDeque<Integer> deque = new DynamicProtectedDeque<>();
        deque.pushFront(1);
        String expected = "[dummyNode] [null] <-prev [1] next-> [null] [dummyNode]";
        assertThat(deque.toString()).isEqualTo(expected);
        assertThat(deque.size()).isEqualTo(1);
        DynamicProtectedDeque.Node<Integer> head = new DynamicProtectedDeque.Node<>();
        DynamicProtectedDeque.Node<Integer> one = new DynamicProtectedDeque.Node<>();
        DynamicProtectedDeque.Node<Integer> tail = new DynamicProtectedDeque.Node<>();
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
        DynamicProtectedDeque<Integer> deque = new DynamicProtectedDeque<>();
        deque.pushFront(1);
        deque.pushBack(2);
        String expected = "[dummyNode] [null] <-prev [1] next-> [2] [1] <-prev [2] next-> [null] [dummyNode]";
        assertThat(deque.toString()).isEqualTo(expected);
        assertThat(deque.size()).isEqualTo(2);
        DynamicProtectedDeque.Node<Integer> head = new DynamicProtectedDeque.Node<>();
        DynamicProtectedDeque.Node<Integer> one = new DynamicProtectedDeque.Node<>();
        DynamicProtectedDeque.Node<Integer> two = new DynamicProtectedDeque.Node<>();
        DynamicProtectedDeque.Node<Integer> tail = new DynamicProtectedDeque.Node<>();
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
        DynamicProtectedDeque<Integer> deque = new DynamicProtectedDeque<>();
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
        DynamicProtectedDeque.Node<Integer> head = new DynamicProtectedDeque.Node<>();
        DynamicProtectedDeque.Node<Integer> two = new DynamicProtectedDeque.Node<>();
        DynamicProtectedDeque.Node<Integer> tail = new DynamicProtectedDeque.Node<>();
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
        DynamicProtectedDeque<Integer> deque = new DynamicProtectedDeque<>();
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
        DynamicProtectedDeque.Node<Integer> head = new DynamicProtectedDeque.Node<>();
        DynamicProtectedDeque.Node<Integer> one = new DynamicProtectedDeque.Node<>();
        DynamicProtectedDeque.Node<Integer> tail = new DynamicProtectedDeque.Node<>();
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
        DynamicProtectedDeque<Integer> deque = new DynamicProtectedDeque<>();
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
        DynamicProtectedDeque<Integer> deque = new DynamicProtectedDeque<>();
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
        DynamicProtectedDeque<Integer> deque = new DynamicProtectedDeque<>();
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
        DynamicProtectedDeque<Integer> deque = new DynamicProtectedDeque<>();
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