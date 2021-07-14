package com.dfedorino.rtasks.third_level.structures.implementations;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleArrayDequeTest {
    // Initial State Tests
    @Test
    public void testDefaultCapacity_whenNoArgsConstructor_thenCapacityIs16() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        assertThat(deque.getCapacity()).isEqualTo(16);
    }

    @Test
    public void testDefaultCapacity_whenConstructorWithCapacity_thenCapacityIsCustom() {
        int customCapacity = 32;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(customCapacity);
        assertThat(deque.getCapacity()).isEqualTo(customCapacity);
    }

    // Size Tests
    @Test
    public void testSize_whenNoArgsConstructor_thenSizeIs0() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        assertThat(deque.size()).isEqualTo("0");
    }

    @Test
    public void testSize_whenConstructorWithCapacity_thenSizeIs0() {
        int customCapacity = 32;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(customCapacity);
        assertThat(deque.size()).isEqualTo("0");
    }

    // Add Last tests
    @Test
    public void testAddLast_whenFirstElement_thenOk() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        assertThat(deque.pushBack(1)).isEqualTo("ok");
    }

    @Test
    public void testAddLast_whenFirstElement_thenSizeIs1() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        deque.pushBack(1);
        assertThat(deque.size()).isEqualTo("1");
    }

    @Test
    public void testAddLast_whenFirstElement_thenIndexOfFirstAndIndexOfLastAreSame() {
        int initialCapacity = 2;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);
        deque.pushBack(1);

        assertThat(deque.getIndexOfFirst()).isEqualTo(0);
        assertThat(deque.getIndexOfLast()).isEqualTo(0);
    }

    @Test
    public void testAddLast_whenAddLastTwoTimes_thenIndexOfFirstIs0IndexOfLastIs1() {
        int initialCapacity = 2;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);

        deque.pushBack(1);
        deque.pushBack(2);

        assertThat(deque.getIndexOfFirst()).isEqualTo(0);
        assertThat(deque.getIndexOfLast()).isEqualTo(1);
    }

    @Test
    public void testAddLast_whenAddMaxElements_thenSizeIsEqualToInitialCapacityAndInitialCapacityIsSame() {
        int initialCapacity = 3;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);

        deque.pushBack(0);
        deque.pushBack(1);
        deque.pushBack(2);

        assertThat(deque.getCapacity()).isEqualTo(initialCapacity);
        assertThat(deque.size()).isEqualTo(initialCapacity + "");
    }

    @Test
    public void testAddLast_whenAddMaxElements_thenIndexOfFirstIs0IndexOfLastIs2() {
        int initialCapacity = 3;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);

        deque.pushBack(0);
        deque.pushBack(1);
        deque.pushBack(2);

        int expectedIndexOfLast = initialCapacity - 1; // 2
        assertThat(deque.getIndexOfFirst()).isEqualTo(0);
        assertThat(deque.getIndexOfLast()).isEqualTo(expectedIndexOfLast);
    }

    @Test
    public void testAddLast_whenAddMaxElements_thenOrderIsSameAsElementsWereAdded() {
        int initialCapacity = 3;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);

        deque.pushBack(0);
        deque.pushBack(1);
        deque.pushBack(2);
    }

    @Test
    public void testAddLast_whenAddMoreThanMaxElements_thenSizeIsDoubled() {
        int initialCapacity = 3;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);

        deque.pushBack(0);
        deque.pushBack(1);
        deque.pushBack(2);
        assertThat(deque.getCapacity()).isEqualTo(initialCapacity);

        deque.pushBack(3);
        assertThat(deque.getCapacity()).isEqualTo(initialCapacity * 2);
    }

    @Test
    public void testAddLast_whenAddMaxElementsThenPopFirstThenAddLast_thenCapacityIsSameSizeIsMaxIndexOfLastIs0() {
        int initialCapacity = 3;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);

        deque.pushBack(0);
        deque.pushBack(1);
        deque.pushBack(2);
        assertThat(deque.getIndexOfFirst()).isEqualTo(0);
        assertThat(deque.getIndexOfLast()).isEqualTo(2);

        deque.popFront();
        assertThat(deque.getIndexOfFirst()).isEqualTo(1);
        assertThat(deque.getIndexOfLast()).isEqualTo(2);

        deque.pushBack(3);
        assertThat(deque.getIndexOfLast()).isEqualTo(0);

        assertThat(deque.getCapacity()).isEqualTo(initialCapacity);
        String expectedSize = initialCapacity + ""; // 3
        assertThat(deque.size()).isEqualTo(expectedSize);
    }

    @Test
    public void testAddLast_whenAfterReset_thenElementsAreAddedFromTheBeginning() {
        int initialCapacity = 3;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);

        deque.pushBack(0);
        deque.pushBack(1);
        deque.pushBack(2);

        deque.popFront();
        assertThat(deque.getIndexOfFirst()).isEqualTo(1);
        assertThat(deque.getIndexOfLast()).isEqualTo(2);

        deque.pushBack(3);
        assertThat(deque.getIndexOfFirst()).isEqualTo(1);
        assertThat(deque.getIndexOfLast()).isEqualTo(0);

        deque.popFront();
        assertThat(deque.getIndexOfFirst()).isEqualTo(2);
        assertThat(deque.getIndexOfLast()).isEqualTo(0);

        deque.popFront();
        assertThat(deque.getIndexOfFirst()).isEqualTo(0);
        assertThat(deque.getIndexOfLast()).isEqualTo(0);

        deque.popFront();
        assertThat(deque.getIndexOfFirst()).isEqualTo(-1);
        assertThat(deque.getIndexOfLast()).isEqualTo(-1);
        assertThat(deque.size()).isEqualTo("0");

        deque.pushBack(4);
        deque.pushBack(5);
        deque.pushBack(6);

        assertThat(deque.getIndexOfFirst()).isEqualTo(0);
        assertThat(deque.getIndexOfLast()).isEqualTo(2);

        assertThat(deque.size()).isEqualTo("3");
    }

    @Test
    public void testAddLast_whenAfterClear_thenElementsAreAddedFromTheBeginning() {
        int initialCapacity = 3;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);

        deque.pushBack(0);
        deque.pushBack(1);
        deque.pushBack(2);

        deque.clear();

        deque.pushBack(3);
        deque.pushBack(4);
        deque.pushBack(5);
    }

    // Add First tests
    @Test
    public void testAddFirst_whenFirstElement_thenOk() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        assertThat(deque.pushFront(1)).isEqualTo("ok");
    }

    @Test
    public void testAddFirst_whenFirstElement_thenSizeIsOne() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        deque.pushFront(1);
        assertThat(deque.size()).isEqualTo("1");
    }

    @Test
    public void testAddFirst_whenFirstElement_thenIndexOfFirstAndIndexOfLastAreSame() {
        int initialCapacity = 2;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);
        deque.pushFront(1);
        assertThat(deque.getIndexOfFirst()).isEqualTo(0);
        assertThat(deque.getIndexOfLast()).isEqualTo(0);
    }

    @Test
    public void testAddFirst_whenTwoElements_thenIndexOfFirstIs1AndIndexOfLastIs0SizeAndInitialCapacityAreEqual() {
        int initialCapacity = 3;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);

        deque.pushFront(0);
        deque.pushFront(1);
        deque.pushFront(2);

        assertThat(deque.getIndexOfFirst()).isEqualTo(1);
        assertThat(deque.getIndexOfLast()).isEqualTo(0);

        assertThat(deque.getCapacity()).isEqualTo(initialCapacity);
        assertThat(deque.size()).isEqualTo(initialCapacity + "");
    }

    @Test
    public void testAddFirst_whenAddMaxElements_thenIndexOfFirstIs0IndexOfLastIsInitialCapacityMinusOne() {
        int initialCapacity = 3;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);

        deque.pushFront(0);
        assertThat(deque.getIndexOfFirst()).isEqualTo(0);
        assertThat(deque.getIndexOfLast()).isEqualTo(0);

        deque.pushFront(1);
        assertThat(deque.getIndexOfFirst()).isEqualTo(2);
        assertThat(deque.getIndexOfLast()).isEqualTo(0);

        deque.pushFront(2);
        assertThat(deque.getIndexOfFirst()).isEqualTo(1);
        assertThat(deque.getIndexOfLast()).isEqualTo(0);
    }

    @Test
    public void testAddFirst_whenAddMaxElements_thenOrderIsReversed() {
        int initialCapacity = 3;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);

        deque.pushFront(0);
        assertThat(deque.getIndexOfFirst()).isEqualTo(0);
        assertThat(deque.getIndexOfLast()).isEqualTo(0);

        deque.pushFront(1);
        assertThat(deque.getIndexOfFirst()).isEqualTo(2);
        assertThat(deque.getIndexOfLast()).isEqualTo(0);

        deque.pushFront(2);
        assertThat(deque.getIndexOfFirst()).isEqualTo(1);
        assertThat(deque.getIndexOfLast()).isEqualTo(0);
    }

    @Test
    public void testAddFirst_whenAddMoreThanMaxElements_thenResize() {
        int initialCapacity = 3;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);

        deque.pushFront(0);
        deque.pushFront(1);
        deque.pushFront(2);
        assertThat(deque.getCapacity()).isEqualTo(initialCapacity);

        deque.pushFront(3);
        assertThat(deque.getCapacity()).isEqualTo(initialCapacity * 2);
    }

    @Test
    public void testAddFirst_whenAddMaxElementsThenPopFirstThenAddFirst_thenCapacityIsSameSizeIsMaxIndexOfFirstIs1() {
        int initialCapacity = 3;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);

        deque.pushFront(0);
        deque.pushFront(1);
        deque.pushFront(2);
        assertThat(deque.getIndexOfFirst()).isEqualTo(1);

        deque.popFront();
        assertThat(deque.getIndexOfFirst()).isEqualTo(2);

        deque.pushFront(3);
        assertThat(deque.getIndexOfFirst()).isEqualTo(1);

        assertThat(deque.getCapacity()).isEqualTo(initialCapacity);
        assertThat(deque.size()).isEqualTo("3");
    }

    @Test
    public void testAddFirst_whenAfterReset_thenElementsAreAddedFromTheBeginning() {
        int initialCapacity = 3;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);
        deque.pushFront(0);
        deque.pushFront(1);
        deque.pushFront(2);
        assertThat(deque.getIndexOfFirst()).isEqualTo(1);
        assertThat(deque.getIndexOfLast()).isEqualTo(0);

        deque.popFront();
        assertThat(deque.getIndexOfFirst()).isEqualTo(2);

        deque.popFront();
        assertThat(deque.getIndexOfFirst()).isEqualTo(0);

        deque.popFront();
        assertThat(deque.getIndexOfFirst()).isEqualTo(-1);
        assertThat(deque.getIndexOfLast()).isEqualTo(-1);

        deque.pushFront(4);
        assertThat(deque.getIndexOfFirst()).isEqualTo(0);
        assertThat(deque.getIndexOfLast()).isEqualTo(0);

        deque.pushFront(5);
        assertThat(deque.getIndexOfFirst()).isEqualTo(2);
        assertThat(deque.getIndexOfLast()).isEqualTo(0);

        deque.pushFront(6);
        assertThat(deque.getIndexOfFirst()).isEqualTo(1);
        assertThat(deque.getIndexOfLast()).isEqualTo(0);
    }

    // Resize tests
    @Test
    public void testResize_whenCalled_thenCapacityIsDoubled() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        int initialCapacity = deque.getCapacity();
        for (int i = 0; i < initialCapacity + 1; i++) {
            deque.pushBack(i);
        }
        assertThat(deque.getCapacity()).isEqualTo(initialCapacity * 2);
    }

    @Test
    public void testResize_whenIndexOfLastIsMoreThanIndexOfFirst_thenCapacityIsDoubledAndIndexOfLastIsMoreThanIndexOfFirst() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(5);
        int initialCapacity = deque.getCapacity();
        for (int i = 0; i < initialCapacity; i++) {
            deque.pushBack(i);
        }

        deque.pushBack(5);

        assertThat(deque.getCapacity()).isEqualTo(initialCapacity * 2);
        assertThat(deque.getIndexOfFirst()).isEqualTo(0);
        assertThat(deque.getIndexOfLast()).isEqualTo(5);
    }

    @Test
    public void testResize_whenIndexOfLastIsLessThanIndexOfFirst_thenCapacityIsDoubledAndIndexOfLastIsMoreThanIndexOfFirst() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(5);
        int initialCapacity = deque.getCapacity();

        for (int i = 0; i < initialCapacity; i++) {
            deque.pushBack(i);
        }
        assertThat(deque.getIndexOfFirst()).isEqualTo(0);
        assertThat(deque.getIndexOfLast()).isEqualTo(4);

        deque.popFront();

        deque.pushBack(5);

        assertThat(deque.getIndexOfFirst()).isEqualTo(1);
        assertThat(deque.getIndexOfLast()).isEqualTo(0);

        deque.pushBack(6);

        assertThat(deque.getCapacity()).isEqualTo(initialCapacity * 2);
        assertThat(deque.getIndexOfFirst()).isEqualTo(0);
        assertThat(deque.getIndexOfLast()).isEqualTo(5);
    }

    // Pop First Tests
    @Test
    public void testPopFirst_whenEmptyDeque_thenErrorString() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        assertThat(deque.popFront()).isEqualTo("error");
    }

    @Test
    public void testPopFirst_whenOneElementAdded_thenRemovedValue() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        deque.pushBack(1);
        assertThat(deque.popFront()).isEqualTo("1");
    }

    @Test
    public void testPopFirst_whenOneElementAdded_thenSizeIsZero() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        deque.pushBack(1);
        deque.popFront();
        assertThat(deque.size()).isEqualTo("0");
    }

    @Test
    public void testPopFirst_whenOneElementAdded_thenResetIndexOfFirstAndIndexOfLast() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        deque.pushBack(1);
        deque.popFront();
        assertThat(deque.getIndexOfFirst()).isEqualTo(-1);
        assertThat(deque.getIndexOfLast()).isEqualTo(-1);
    }

    @Test
    public void testPopFirst_whenTwoElementsAdded_thenIncrementIndexOfFirst() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        deque.pushBack(1);
        deque.pushBack(2);
        assertThat(deque.getIndexOfFirst()).isEqualTo(0);
        deque.popFront();
        assertThat(deque.getIndexOfFirst()).isEqualTo(1);
    }

    @Test
    public void testPopFirst_whenIndexOfFirstAndIndexOfLastAreEqual_thenResetIndexOfFirstAndIndexOfLast() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(3);
        deque.pushBack(0);
        deque.pushBack(1);
        deque.pushBack(2);
        assertThat(deque.getIndexOfFirst()).isEqualTo(0);
        assertThat(deque.getIndexOfLast()).isEqualTo(2);

        deque.popFront();
        assertThat(deque.getIndexOfFirst()).isEqualTo(1);
        assertThat(deque.getIndexOfLast()).isEqualTo(2);

        deque.pushBack(3);
        assertThat(deque.getIndexOfFirst()).isEqualTo(1);
        assertThat(deque.getIndexOfLast()).isEqualTo(0);

        deque.popFront();
        assertThat(deque.getIndexOfFirst()).isEqualTo(2);
        assertThat(deque.getIndexOfLast()).isEqualTo(0);

        deque.popFront();
        assertThat(deque.getIndexOfFirst()).isEqualTo(0);
        assertThat(deque.getIndexOfLast()).isEqualTo(0);

        deque.popFront();
        assertThat(deque.getIndexOfFirst()).isEqualTo(-1);
        assertThat(deque.getIndexOfLast()).isEqualTo(-1);
    }

    // Pop Last Tests
    @Test
    public void testPopLast_whenEmptyDeque_thenErrorString() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        assertThat(deque.popBack()).isEqualTo("error");
    }

    @Test
    public void testPopLast_whenOneElementAdded_thenRemovedValue() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        deque.pushBack(1);
        assertThat(deque.popBack()).isEqualTo("1");
    }

    @Test
    public void testPopLast_whenOneElementAdded_thenSizeIsZero() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        deque.pushBack(1);
        deque.popBack();
        assertThat(deque.size()).isEqualTo("0");
    }

    @Test
    public void testPopLast_whenOneElementAdded_thenResetIndexOfFirstAndIndexOfLast() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        deque.pushBack(1);
        deque.popBack();
        assertThat(deque.getIndexOfFirst()).isEqualTo(-1);
        assertThat(deque.getIndexOfLast()).isEqualTo(-1);
    }

    @Test
    public void testPopLast_whenTwoElementsAdded_thenUpdateIndexOfLast() {
        int initialCapacity = 2;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);

        deque.pushBack(1);
        deque.pushBack(2);
        assertThat(deque.getIndexOfLast()).isEqualTo(1);
        deque.popBack();
        assertThat(deque.getIndexOfLast()).isEqualTo(0);
    }

    @Test
    public void testPopLast_whenIndexOfFirstAndIndexOfLastAreEqual_thenResetIndexOfFirstAndIndexOfLast() {
        int initialCapacity = 3;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);
        deque.pushBack(0);
        deque.pushBack(1);
        deque.pushBack(2);
        assertThat(deque.getIndexOfFirst()).isEqualTo(0);
        assertThat(deque.getIndexOfLast()).isEqualTo(2);

        deque.popBack();
        assertThat(deque.getIndexOfLast()).isEqualTo(1);

        deque.popBack();
        assertThat(deque.getIndexOfLast()).isEqualTo(0);

        deque.popBack();
        assertThat(deque.getIndexOfFirst()).isEqualTo(-1);
        assertThat(deque.getIndexOfLast()).isEqualTo(-1);
    }

    // Front Tests
    @Test
    public void testFront_whenEmptyDeque_thenError() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        assertThat(deque.front()).isEqualTo("error");
    }

    @Test
    public void testFront_whenDequeAddLast_thenStringValueOfTheElementAtTheIndexOfFirstIsReturned() {
        int initialCapacity = 3;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);

        deque.pushBack(0);
        deque.pushBack(1);
        deque.pushBack(2);
        assertThat(deque.getIndexOfFirst()).isEqualTo(0);
        assertThat(deque.getIndexOfLast()).isEqualTo(2);

        assertThat(deque.front()).isEqualTo("0");
        assertThat(deque.getIndexOfFirst()).isEqualTo(0);
        assertThat(deque.getIndexOfLast()).isEqualTo(2);
    }

    @Test
    public void testFront_whenDequeAddFirst_thenStringValueOfTheElementAtTheIndexOfFirstIsReturned() {
        int initialCapacity = 3;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);

        deque.pushFront(0);
        deque.pushFront(1);
        deque.pushFront(2);
        assertThat(deque.getIndexOfFirst()).isEqualTo(1);
        assertThat(deque.getIndexOfLast()).isEqualTo(0);

        assertThat(deque.front()).isEqualTo("2");
        assertThat(deque.getIndexOfFirst()).isEqualTo(1);
        assertThat(deque.getIndexOfLast()).isEqualTo(0);
    }

    // Back Tests
    @Test
    public void testBack_whenEmptyDeque_thenError() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        assertThat(deque.back()).isEqualTo("error");
    }

    @Test
    public void testBack_whenDequeAddLast_thenStringValueOfTheElementAtTheIndexOfLastIsReturned() {
        int initialCapacity = 3;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);

        deque.pushBack(0);
        deque.pushBack(1);
        deque.pushBack(2);
        assertThat(deque.getIndexOfFirst()).isEqualTo(0);
        assertThat(deque.getIndexOfLast()).isEqualTo(2);

        assertThat(deque.back()).isEqualTo("2");
        assertThat(deque.getIndexOfFirst()).isEqualTo(0);
        assertThat(deque.getIndexOfLast()).isEqualTo(2);
    }

    @Test
    public void testBack_whenDequeAddFirst_thenStringValueOfTheElementAtTheIndexOfFirstIsReturned() {
        int initialCapacity = 3;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);

        deque.pushFront(0);
        deque.pushFront(1);
        deque.pushFront(2);
        assertThat(deque.getIndexOfFirst()).isEqualTo(1);
        assertThat(deque.getIndexOfLast()).isEqualTo(0);

        assertThat(deque.back()).isEqualTo("0");
        assertThat(deque.getIndexOfFirst()).isEqualTo(1);
        assertThat(deque.getIndexOfLast()).isEqualTo(0);
    }

    // Clear Tests
    @Test
    public void testClear_whenDequeIsEmpty_thenError() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        assertThat(deque.clear()).isEqualTo("error");
    }

    @Test
    public void testClear_whenDequeWithElements_thenOkSizeIs0IndexOfFirstAndIndexOfLastAreUpdatedNewCapacityIsSame() {
        int initialCapacity = 3;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);

        deque.pushFront(0);
        deque.pushFront(1);
        deque.pushFront(2);
        assertThat(deque.getCapacity()).isEqualTo(initialCapacity);
        assertThat(deque.getIndexOfFirst()).isEqualTo(1);
        assertThat(deque.getIndexOfLast()).isEqualTo(0);
        assertThat(deque.size()).isEqualTo("3");

        assertThat(deque.clear()).isEqualTo("ok");

        assertThat(deque.getCapacity()).isEqualTo(initialCapacity);
        assertThat(deque.getIndexOfFirst()).isEqualTo(-1);
        assertThat(deque.getIndexOfLast()).isEqualTo(-1);
        assertThat(deque.size()).isEqualTo("0");
    }
}