package com.dfedorino.rtasks.third_level.structures.implementations;

import org.testng.annotations.Test;

import java.util.Arrays;

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
    public void testSize_whenNoArgsConstructor_thenSizeIsZero() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        assertThat(deque.getSize()).isEqualTo("0");
    }

    @Test
    public void testSize_whenConstructorWithCapacity_thenSizeIsZero() {
        int customCapacity = 32;
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(customCapacity);
        assertThat(deque.getSize()).isEqualTo("0");
    }

    // Add Last tests
    @Test
    public void testAddLast_whenFirstElement_thenOk() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        assertThat(deque.addLast(1)).isEqualTo("ok");
    }

    @Test
    public void testAddLast_whenFirstElement_thenSizeIsOne() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        deque.addLast(1);
        assertThat(deque.getSize()).isEqualTo("1");
    }

    @Test
    public void testAddLast_whenFirstElement_thenIndexOfFirstAndIndexOfLastAreSame() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        deque.addLast(1);
        assertThat(deque.indexOfFirst).isEqualTo(0);
        assertThat(deque.indexOfLast).isEqualTo(0);
    }

    @Test
    public void testAddLast_whenAddLastTwoTimes_thenIndexOfFirstIsZeroIndexOfLastIsOne() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        deque.addLast(1);
        deque.addLast(2);
        assertThat(deque.indexOfFirst).isEqualTo(0);
        assertThat(deque.indexOfLast).isEqualTo(1);
        assertThat(deque.array[0]).isEqualTo(1);
        assertThat(deque.array[1]).isEqualTo(2);
    }

    @Test
    public void testAddLast_whenAddMaxElements_thenArrayIsFullButCapacityIsSame() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        int initialCapacity = deque.capacity;
        for (int i = 0; i < initialCapacity; i++) {
            deque.addLast(i);
        }
        assertThat(deque.capacity).isEqualTo(initialCapacity);
    }

    @Test
    public void testAddLast_whenAddMaxElements_thenSizeIsEqualToCapacity() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        int initialCapacity = deque.capacity;
        for (int i = 0; i < initialCapacity; i++) {
            deque.addLast(i);
        }
        assertThat(deque.getSize()).isEqualTo(initialCapacity + "");
    }

    @Test
    public void testAddLast_whenAddMaxElements_thenIndexOfFirstIs0IndexOfLastIs15() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        int initialCapacity = deque.capacity;
        for (int i = 0; i < initialCapacity; i++) {
            deque.addLast(i);
        }
        assertThat(deque.indexOfFirst).isEqualTo(0);
        assertThat(deque.indexOfLast).isEqualTo(initialCapacity - 1);
    }

    @Test
    public void testAddLast_whenAddMoreThanMaxElements_thenResize() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        int initialCapacity = deque.capacity;
        for (int i = 0; i < initialCapacity + 1; i++) {
            deque.addLast(i);
        }
        assertThat(deque.capacity).isNotEqualTo(initialCapacity);
    }

    @Test
    public void testAddLast_whenAddMaxElementsThenPopFirstThenAddLast_thenCapacityIsSameSizeIsMaxIndexOfLastIs0() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        int initialCapacity = deque.capacity;
        for (int i = 0; i < initialCapacity; i++) {
            deque.addLast(i);
        }
        deque.popFirst();
        deque.addLast(16);
        assertThat(deque.capacity).isEqualTo(initialCapacity);
        assertThat(deque.getSize()).isEqualTo("16");
        assertThat(deque.indexOfLast).isEqualTo(0);
        assertThat(deque.array[0]).isEqualTo(16);
        System.out.println(">> deque array -> " + Arrays.toString(deque.array));
    }

    // Resize tests
    @Test
    public void testResize_whenCalled_thenCapacityIsDoubled() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        int initialCapacity = deque.capacity;
        for (int i = 0; i < initialCapacity + 1; i++) {
            deque.addLast(i);
        }
        assertThat(deque.capacity).isEqualTo(initialCapacity * 2);
    }

    @Test
    public void testResize_whenIndexOfLastIsMoreThanIndexOfFirst_thenCapacityIsDoubledAndIndexOfLastIsMoreThanIndexOfFirst() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(5);
        int initialCapacity = deque.capacity;

        for (int i = 0; i < initialCapacity; i++) {
            deque.addLast(i);
        }

        deque.addLast(initialCapacity);

        assertThat(deque.capacity).isEqualTo(initialCapacity * 2);
        assertThat(deque.indexOfFirst).isEqualTo(0);
        assertThat(deque.indexOfLast).isEqualTo(initialCapacity);
    }

    @Test
    public void testResize_whenIndexOfLastIsLessThanIndexOfFirst_thenCapacityIsDoubledAndIndexOfLastIsMoreThanIndexOfFirst() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>(5);
        int initialCapacity = deque.capacity;
        for (int i = 0; i < initialCapacity; i++) {
            deque.addLast(i);
        }
        assertThat(deque.indexOfFirst).isEqualTo(0);
        assertThat(deque.indexOfLast).isEqualTo(4);

        deque.popFirst();

        deque.addLast(5);

        assertThat(deque.indexOfFirst).isEqualTo(1);
        assertThat(deque.indexOfLast).isEqualTo(0);

        deque.addLast(6);

        assertThat(deque.capacity).isEqualTo(initialCapacity * 2);
        assertThat(deque.indexOfFirst).isEqualTo(0);
        assertThat(deque.indexOfLast).isEqualTo(5);
    }

    // Pop First Tests
    @Test
    public void testPopFirst_whenEmptyDeque_thenErrorString() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        assertThat(deque.popFirst()).isEqualTo("error");
    }

    @Test
    public void testPopFirst_whenOneElementAdded_thenRemovedValue() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        deque.addLast(1);
        assertThat(deque.popFirst()).isEqualTo("1");
    }

    @Test
    public void testPopFirst_whenOneElementAdded_thenSizeIsZero() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        deque.addLast(1);
        deque.popFirst();
        assertThat(deque.getSize()).isEqualTo("0");
    }

    @Test
    public void testPopFirst_whenOneElementAdded_thenResetIndexOfFirstAndIndexOfLast() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        deque.addLast(1);
        deque.popFirst();
        assertThat(deque.indexOfFirst).isEqualTo(-1);
        assertThat(deque.indexOfLast).isEqualTo(-1);
    }

    @Test
    public void testPopFirst_whenTwoElementsAdded_thenIncrementIndexOfFirst() {
        SimpleArrayDeque<Integer> deque = new SimpleArrayDeque<>();
        deque.addLast(1);
        deque.addLast(2);
        assertThat(deque.indexOfFirst).isEqualTo(0);
        deque.popFirst();
        assertThat(deque.indexOfFirst).isEqualTo(1);
    }
}