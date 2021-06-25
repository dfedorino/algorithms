package com.dfedorino.rtasks.third_level.structures.implementations;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleArrayDequeTest {
    // Initial State Tests
    @Test
    public void testDefaultCapacity_whenNoArgsConstructor_thenCapacityIs16() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        assertThat(deque.array.length).isEqualTo(16);
        assertThat(deque.capacity).isEqualTo(16);
    }

    @Test
    public void testDefaultCapacity_whenConstructorWithCapacity_thenCapacityIsCustom() {
        int customCapacity = 32;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(customCapacity);
        assertThat(deque.array.length).isEqualTo(customCapacity);
        assertThat(deque.capacity).isEqualTo(customCapacity);
    }

    // Size Tests
    @Test
    public void testSize_whenNoArgsConstructor_thenSizeIs0() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        assertThat(deque.getSize()).isEqualTo("0");
    }

    @Test
    public void testSize_whenConstructorWithCapacity_thenSizeIs0() {
        int customCapacity = 32;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(customCapacity);
        assertThat(deque.getSize()).isEqualTo("0");
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
        assertThat(deque.getSize()).isEqualTo("1");
    }

    @Test
    public void testAddLast_whenFirstElement_thenIndexOfFirstAndIndexOfLastAreSame() {
        int initialCapacity = 2;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);
        deque.pushBack(1);
        assertThat(deque.array).isEqualTo(new Object[]{1, null});

        assertThat(deque.indexOfFirst).isEqualTo(0);
        assertThat(deque.indexOfLast).isEqualTo(0);
    }

    @Test
    public void testAddLast_whenAddLastTwoTimes_thenIndexOfFirstIs0IndexOfLastIs1() {
        int initialCapacity = 2;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);

        deque.pushBack(1);
        assertThat(deque.array).isEqualTo(new Object[]{1, null});

        deque.pushBack(2);
        assertThat(deque.array).isEqualTo(new Object[]{1, 2});

        assertThat(deque.indexOfFirst).isEqualTo(0);
        assertThat(deque.indexOfLast).isEqualTo(1);
    }

    @Test
    public void testAddLast_whenAddMaxElements_thenSizeIsEqualToInitialCapacityAndInitialCapacityIsSame() {
        int initialCapacity = 3;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);

        deque.pushBack(0);
        deque.pushBack(1);
        deque.pushBack(2);

        assertThat(deque.capacity).isEqualTo(initialCapacity);
        assertThat(deque.getSize()).isEqualTo(initialCapacity + "");
    }

    @Test
    public void testAddLast_whenAddMaxElements_thenIndexOfFirstIs0IndexOfLastIs2() {
        int initialCapacity = 3;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);

        deque.pushBack(0);
        deque.pushBack(1);
        deque.pushBack(2);

        int expectedIndexOfLast = initialCapacity - 1; // 2
        assertThat(deque.indexOfFirst).isEqualTo(0);
        assertThat(deque.indexOfLast).isEqualTo(expectedIndexOfLast);
    }

    @Test
    public void testAddLast_whenAddMaxElements_thenOrderIsSameAsElementsWereAdded() {
        int initialCapacity = 3;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);

        deque.pushBack(0);
        assertThat(deque.array).isEqualTo(new Object[]{0, null, null});

        deque.pushBack(1);
        assertThat(deque.array).isEqualTo(new Object[]{0, 1, null});

        deque.pushBack(2);
        assertThat(deque.array).isEqualTo(new Object[]{0, 1, 2});
    }

    @Test
    public void testAddLast_whenAddMoreThanMaxElements_thenSizeIsDoubled() {
        int initialCapacity = 3;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);

        deque.pushBack(0);
        deque.pushBack(1);
        deque.pushBack(2);
        assertThat(deque.capacity).isEqualTo(initialCapacity);

        deque.pushBack(3);
        assertThat(deque.capacity).isEqualTo(initialCapacity * 2);
    }

    @Test
    public void testAddLast_whenAddMaxElementsThenPopFirstThenAddLast_thenCapacityIsSameSizeIsMaxIndexOfLastIs0() {
        int initialCapacity = 3;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);

        deque.pushBack(0);
        deque.pushBack(1);
        deque.pushBack(2);
        assertThat(deque.array).isEqualTo(new Object[]{0, 1, 2});
        assertThat(deque.indexOfFirst).isEqualTo(0);
        assertThat(deque.indexOfLast).isEqualTo(2);

        deque.popFront();
        assertThat(deque.array).isEqualTo(new Object[]{0, 1, 2});
        assertThat(deque.indexOfFirst).isEqualTo(1);
        assertThat(deque.indexOfLast).isEqualTo(2);

        deque.pushBack(3);
        assertThat(deque.array).isEqualTo(new Object[]{3, 1, 2});
        assertThat(deque.indexOfLast).isEqualTo(0);
        assertThat(deque.array[0]).isEqualTo(3);

        assertThat(deque.capacity).isEqualTo(initialCapacity);
        String expectedSize = initialCapacity + ""; // 3
        assertThat(deque.getSize()).isEqualTo(expectedSize);
    }

    @Test
    public void testAddLast_whenAfterReset_thenElementsAreAddedFromTheBeginning() {
        int initialCapacity = 3;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);

        deque.pushBack(0);
        deque.pushBack(1);
        deque.pushBack(2);
        assertThat(deque.array).isEqualTo(new Object[]{0, 1, 2});

        deque.popFront();
        assertThat(deque.array).isEqualTo(new Object[]{0, 1, 2});
        assertThat(deque.indexOfFirst).isEqualTo(1);
        assertThat(deque.indexOfLast).isEqualTo(2);

        deque.pushBack(3);
        assertThat(deque.array).isEqualTo(new Object[]{3, 1, 2});
        assertThat(deque.indexOfFirst).isEqualTo(1);
        assertThat(deque.indexOfLast).isEqualTo(0);

        deque.popFront();
        assertThat(deque.array).isEqualTo(new Object[]{3, 1, 2});
        assertThat(deque.indexOfFirst).isEqualTo(2);
        assertThat(deque.indexOfLast).isEqualTo(0);

        deque.popFront();
        assertThat(deque.array).isEqualTo(new Object[]{3, 1, 2});
        assertThat(deque.indexOfFirst).isEqualTo(0);
        assertThat(deque.indexOfLast).isEqualTo(0);

        deque.popFront();
        assertThat(deque.array).isEqualTo(new Object[]{3, 1, 2});
        assertThat(deque.indexOfFirst).isEqualTo(-1);
        assertThat(deque.indexOfLast).isEqualTo(-1);
        assertThat(deque.getSize()).isEqualTo("0");

        deque.pushBack(4);
        assertThat(deque.array).isEqualTo(new Object[]{4, 1, 2});

        deque.pushBack(5);
        assertThat(deque.array).isEqualTo(new Object[]{4, 5, 2});

        deque.pushBack(6);
        assertThat(deque.array).isEqualTo(new Object[]{4, 5, 6});

        assertThat(deque.indexOfFirst).isEqualTo(0);
        assertThat(deque.indexOfLast).isEqualTo(2);

        assertThat(deque.getSize()).isEqualTo("3");
    }

    @Test
    public void testAddLast_whenAfterClear_thenElementsAreAddedFromTheBeginning() {
        int initialCapacity = 3;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);

        deque.pushBack(0);
        deque.pushBack(1);
        deque.pushBack(2);
        assertThat(deque.array).isEqualTo(new Object[]{0, 1, 2});

        deque.clear();

        deque.pushBack(3);
        deque.pushBack(4);
        deque.pushBack(5);
        assertThat(deque.array).isEqualTo(new Object[]{3, 4, 5});
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
        assertThat(deque.getSize()).isEqualTo("1");
    }

    @Test
    public void testAddFirst_whenFirstElement_thenIndexOfFirstAndIndexOfLastAreSame() {
        int initialCapacity = 2;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);
        deque.pushFront(1);
        assertThat(deque.array).isEqualTo(new Object[]{1, null});
        assertThat(deque.indexOfFirst).isEqualTo(0);
        assertThat(deque.indexOfLast).isEqualTo(0);
    }

    @Test
    public void testAddFirst_whenTwoElements_thenIndexOfFirstIs1AndIndexOfLastIs0SizeAndInitialCapacityAreEqual() {
        int initialCapacity = 3;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);
        assertThat(deque.array).isEqualTo(new Object[]{null, null, null});

        deque.pushFront(0);
        assertThat(deque.array).isEqualTo(new Object[]{0, null, null});
        deque.pushFront(1);
        assertThat(deque.array).isEqualTo(new Object[]{0, null, 1});
        deque.pushFront(2);
        assertThat(deque.array).isEqualTo(new Object[]{0, 2, 1});

        assertThat(deque.indexOfFirst).isEqualTo(1);
        assertThat(deque.indexOfLast).isEqualTo(0);

        assertThat(deque.capacity).isEqualTo(initialCapacity);
        assertThat(deque.getSize()).isEqualTo(initialCapacity + "");
    }

    @Test
    public void testAddFirst_whenAddMaxElements_thenIndexOfFirstIs0IndexOfLastIsInitialCapacityMinusOne() {
        int initialCapacity = 3;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);

        deque.pushFront(0);
        assertThat(deque.array).isEqualTo(new Object[]{0, null, null});
        assertThat(deque.indexOfFirst).isEqualTo(0);
        assertThat(deque.indexOfLast).isEqualTo(0);

        deque.pushFront(1);
        assertThat(deque.array).isEqualTo(new Object[]{0, null, 1});
        assertThat(deque.indexOfFirst).isEqualTo(2);
        assertThat(deque.indexOfLast).isEqualTo(0);

        deque.pushFront(2);
        assertThat(deque.array).isEqualTo(new Object[]{0, 2, 1});
        assertThat(deque.indexOfFirst).isEqualTo(1);
        assertThat(deque.indexOfLast).isEqualTo(0);
    }

    @Test
    public void testAddFirst_whenAddMaxElements_thenOrderIsReversed() {
        int initialCapacity = 3;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);
        assertThat(deque.array).isEqualTo(new Object[]{null, null, null});

        deque.pushFront(0);
        assertThat(deque.array).isEqualTo(new Object[]{0, null, null});
        assertThat(deque.indexOfFirst).isEqualTo(0);
        assertThat(deque.indexOfLast).isEqualTo(0);

        deque.pushFront(1);
        assertThat(deque.array).isEqualTo(new Object[]{0, null, 1});
        assertThat(deque.indexOfFirst).isEqualTo(2);
        assertThat(deque.indexOfLast).isEqualTo(0);

        deque.pushFront(2);
        assertThat(deque.array).isEqualTo(new Object[]{0, 2, 1});
        assertThat(deque.indexOfFirst).isEqualTo(1);
        assertThat(deque.indexOfLast).isEqualTo(0);
    }

    @Test
    public void testAddFirst_whenAddMoreThanMaxElements_thenResize() {
        int initialCapacity = 3;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);

        deque.pushFront(0);
        assertThat(deque.array).isEqualTo(new Object[]{0, null, null});
        deque.pushFront(1);
        assertThat(deque.array).isEqualTo(new Object[]{0, null, 1});
        deque.pushFront(2);
        assertThat(deque.array).isEqualTo(new Object[]{0, 2, 1});
        assertThat(deque.capacity).isEqualTo(initialCapacity);

        deque.pushFront(3);
        assertThat(deque.array).isEqualTo(new Object[]{2, 1, 0, null, null, 3});
        assertThat(deque.capacity).isEqualTo(initialCapacity * 2);
    }

    @Test
    public void testAddFirst_whenAddMaxElementsThenPopFirstThenAddFirst_thenCapacityIsSameSizeIsMaxIndexOfFirstIs1() {
        int initialCapacity = 3;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);
        assertThat(deque.array).isEqualTo(new Object[]{null, null, null});

        deque.pushFront(0);
        assertThat(deque.array).isEqualTo(new Object[]{0, null, null});

        deque.pushFront(1);
        assertThat(deque.array).isEqualTo(new Object[]{0, null, 1});

        deque.pushFront(2);
        assertThat(deque.array).isEqualTo(new Object[]{0, 2, 1});
        assertThat(deque.indexOfFirst).isEqualTo(1);

        deque.popFront();
        assertThat(deque.array).isEqualTo(new Object[]{0, 2, 1});
        assertThat(deque.indexOfFirst).isEqualTo(2);

        deque.pushFront(3);
        assertThat(deque.array).isEqualTo(new Object[]{0, 3, 1});
        assertThat(deque.indexOfFirst).isEqualTo(1);

        assertThat(deque.capacity).isEqualTo(initialCapacity);
        assertThat(deque.getSize()).isEqualTo("3");
    }

    @Test
    public void testAddFirst_whenAfterReset_thenElementsAreAddedFromTheBeginning() {
        int initialCapacity = 3;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);
        deque.pushFront(0);
        deque.pushFront(1);
        deque.pushFront(2);
        assertThat(deque.array).isEqualTo(new Object[]{0, 2, 1});
        assertThat(deque.indexOfFirst).isEqualTo(1);
        assertThat(deque.indexOfLast).isEqualTo(0);

        deque.popFront();
        assertThat(deque.indexOfFirst).isEqualTo(2);

        deque.popFront();
        assertThat(deque.indexOfFirst).isEqualTo(0);

        deque.popFront();
        assertThat(deque.indexOfFirst).isEqualTo(-1);
        assertThat(deque.indexOfLast).isEqualTo(-1);

        deque.pushFront(4);
        assertThat(deque.array).isEqualTo(new Object[]{4, 2, 1});
        assertThat(deque.indexOfFirst).isEqualTo(0);
        assertThat(deque.indexOfLast).isEqualTo(0);

        deque.pushFront(5);
        assertThat(deque.array).isEqualTo(new Object[]{4, 2, 5});
        assertThat(deque.indexOfFirst).isEqualTo(2);
        assertThat(deque.indexOfLast).isEqualTo(0);

        deque.pushFront(6);
        assertThat(deque.array).isEqualTo(new Object[]{4, 6, 5});
        assertThat(deque.indexOfFirst).isEqualTo(1);
        assertThat(deque.indexOfLast).isEqualTo(0);
    }

    // Resize tests
    @Test
    public void testResize_whenCalled_thenCapacityIsDoubled() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        int initialCapacity = deque.capacity;
        for (int i = 0; i < initialCapacity + 1; i++) {
            deque.pushBack(i);
        }
        assertThat(deque.capacity).isEqualTo(initialCapacity * 2);
    }

    @Test
    public void testResize_whenIndexOfLastIsMoreThanIndexOfFirst_thenCapacityIsDoubledAndIndexOfLastIsMoreThanIndexOfFirst() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(5);
        int initialCapacity = deque.capacity;
        for (int i = 0; i < initialCapacity; i++) {
            deque.pushBack(i);
        }

        deque.pushBack(5);

        assertThat(deque.capacity).isEqualTo(initialCapacity * 2);
        assertThat(deque.indexOfFirst).isEqualTo(0);
        assertThat(deque.indexOfLast).isEqualTo(5);
    }

    @Test
    public void testResize_whenIndexOfLastIsLessThanIndexOfFirst_thenCapacityIsDoubledAndIndexOfLastIsMoreThanIndexOfFirst() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(5);
        int initialCapacity = deque.capacity;

        for (int i = 0; i < initialCapacity; i++) {
            deque.pushBack(i);
        }
        assertThat(deque.indexOfFirst).isEqualTo(0);
        assertThat(deque.indexOfLast).isEqualTo(4);

        deque.popFront();

        deque.pushBack(5);

        assertThat(deque.indexOfFirst).isEqualTo(1);
        assertThat(deque.indexOfLast).isEqualTo(0);

        deque.pushBack(6);

        assertThat(deque.capacity).isEqualTo(initialCapacity * 2);
        assertThat(deque.indexOfFirst).isEqualTo(0);
        assertThat(deque.indexOfLast).isEqualTo(5);
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
        assertThat(deque.getSize()).isEqualTo("0");
    }

    @Test
    public void testPopFirst_whenOneElementAdded_thenResetIndexOfFirstAndIndexOfLast() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        deque.pushBack(1);
        deque.popFront();
        assertThat(deque.indexOfFirst).isEqualTo(-1);
        assertThat(deque.indexOfLast).isEqualTo(-1);
    }

    @Test
    public void testPopFirst_whenTwoElementsAdded_thenIncrementIndexOfFirst() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        deque.pushBack(1);
        deque.pushBack(2);
        assertThat(deque.indexOfFirst).isEqualTo(0);
        deque.popFront();
        assertThat(deque.indexOfFirst).isEqualTo(1);
    }

    @Test
    public void testPopFirst_whenIndexOfFirstAndIndexOfLastAreEqual_thenResetIndexOfFirstAndIndexOfLast() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(3);
        deque.pushBack(0);
        deque.pushBack(1);
        deque.pushBack(2);
        assertThat(deque.indexOfFirst).isEqualTo(0);
        assertThat(deque.indexOfLast).isEqualTo(2);

        deque.popFront();
        assertThat(deque.indexOfFirst).isEqualTo(1);
        assertThat(deque.indexOfLast).isEqualTo(2);

        deque.pushBack(3);
        assertThat(deque.indexOfFirst).isEqualTo(1);
        assertThat(deque.indexOfLast).isEqualTo(0);

        deque.popFront();
        assertThat(deque.indexOfFirst).isEqualTo(2);
        assertThat(deque.indexOfLast).isEqualTo(0);

        deque.popFront();
        assertThat(deque.indexOfFirst).isEqualTo(0);
        assertThat(deque.indexOfLast).isEqualTo(0);

        deque.popFront();
        assertThat(deque.indexOfFirst).isEqualTo(-1);
        assertThat(deque.indexOfLast).isEqualTo(-1);
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
        assertThat(deque.getSize()).isEqualTo("0");
    }

    @Test
    public void testPopLast_whenOneElementAdded_thenResetIndexOfFirstAndIndexOfLast() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        deque.pushBack(1);
        deque.popBack();
        assertThat(deque.indexOfFirst).isEqualTo(-1);
        assertThat(deque.indexOfLast).isEqualTo(-1);
    }

    @Test
    public void testPopLast_whenTwoElementsAdded_thenUpdateIndexOfLast() {
        int initialCapacity = 2;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);

        deque.pushBack(1);
        deque.pushBack(2);
        assertThat(deque.indexOfLast).isEqualTo(1);
        deque.popBack();
        assertThat(deque.indexOfLast).isEqualTo(0);
    }

    @Test
    public void testPopLast_whenIndexOfFirstAndIndexOfLastAreEqual_thenResetIndexOfFirstAndIndexOfLast() {
        int initialCapacity = 3;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);
        deque.pushBack(0);
        deque.pushBack(1);
        deque.pushBack(2);
        assertThat(deque.array).isEqualTo(new Object[]{0, 1, 2});
        assertThat(deque.indexOfFirst).isEqualTo(0);
        assertThat(deque.indexOfLast).isEqualTo(2);

        deque.popBack();
        assertThat(deque.indexOfLast).isEqualTo(1);

        deque.popBack();
        assertThat(deque.indexOfLast).isEqualTo(0);

        deque.popBack();
        assertThat(deque.indexOfFirst).isEqualTo(-1);
        assertThat(deque.indexOfLast).isEqualTo(-1);
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
        assertThat(deque.array).isEqualTo(new Object[]{0, 1, 2});
        assertThat(deque.indexOfFirst).isEqualTo(0);
        assertThat(deque.indexOfLast).isEqualTo(2);

        assertThat(deque.front()).isEqualTo("0");
        assertThat(deque.array).isEqualTo(new Object[]{0, 1, 2});
        assertThat(deque.indexOfFirst).isEqualTo(0);
        assertThat(deque.indexOfLast).isEqualTo(2);
    }

    @Test
    public void testFront_whenDequeAddFirst_thenStringValueOfTheElementAtTheIndexOfFirstIsReturned() {
        int initialCapacity = 3;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);

        deque.pushFront(0);
        deque.pushFront(1);
        deque.pushFront(2);
        assertThat(deque.array).isEqualTo(new Object[]{0, 2, 1});
        assertThat(deque.indexOfFirst).isEqualTo(1);
        assertThat(deque.indexOfLast).isEqualTo(0);

        assertThat(deque.front()).isEqualTo("2");
        assertThat(deque.array).isEqualTo(new Object[]{0, 2, 1});
        assertThat(deque.indexOfFirst).isEqualTo(1);
        assertThat(deque.indexOfLast).isEqualTo(0);
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
        assertThat(deque.array).isEqualTo(new Object[]{0, 1, 2});
        assertThat(deque.indexOfFirst).isEqualTo(0);
        assertThat(deque.indexOfLast).isEqualTo(2);

        assertThat(deque.back()).isEqualTo("2");
        assertThat(deque.array).isEqualTo(new Object[]{0, 1, 2});
        assertThat(deque.indexOfFirst).isEqualTo(0);
        assertThat(deque.indexOfLast).isEqualTo(2);
    }

    @Test
    public void testBack_whenDequeAddFirst_thenStringValueOfTheElementAtTheIndexOfFirstIsReturned() {
        int initialCapacity = 3;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(initialCapacity);

        deque.pushFront(0);
        deque.pushFront(1);
        deque.pushFront(2);
        assertThat(deque.array).isEqualTo(new Object[]{0, 2, 1});
        assertThat(deque.indexOfFirst).isEqualTo(1);
        assertThat(deque.indexOfLast).isEqualTo(0);

        assertThat(deque.back()).isEqualTo("0");
        assertThat(deque.array).isEqualTo(new Object[]{0, 2, 1});
        assertThat(deque.indexOfFirst).isEqualTo(1);
        assertThat(deque.indexOfLast).isEqualTo(0);
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
        assertThat(deque.capacity).isEqualTo(initialCapacity);
        assertThat(deque.indexOfFirst).isEqualTo(1);
        assertThat(deque.indexOfLast).isEqualTo(0);
        assertThat(deque.getSize()).isEqualTo("3");

        assertThat(deque.clear()).isEqualTo("ok");

        assertThat(deque.capacity).isEqualTo(initialCapacity);
        assertThat(deque.indexOfFirst).isEqualTo(-1);
        assertThat(deque.indexOfLast).isEqualTo(-1);
        assertThat(deque.getSize()).isEqualTo("0");
    }
}