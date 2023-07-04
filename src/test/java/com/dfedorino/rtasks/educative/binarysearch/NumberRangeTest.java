package com.dfedorino.rtasks.educative.binarysearch;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberRangeTest {
    private final NumberRange numberRange = new NumberRange();
    @Test
    void example1() {
        int[] arr = {4, 6, 6, 6, 9};
        int key = 6;
        int[] expected = {1, 3};
        assertThat(numberRange.findRange(arr, key)).containsExactly(expected);
    }

    @Test
    void example2() {
        int[] arr = {1, 3, 8, 10, 15};
        int key = 10;
        int[] expected = {3, 3};
        assertThat(numberRange.findRange(arr, key)).containsExactly(expected);
    }

    @Test
    void example3() {
        int[] arr = {1, 3, 8, 10, 15};
        int key = 12;
        int[] expected = {-1, -1};
        assertThat(numberRange.findRange(arr, key)).containsExactly(expected);
    }

    @Test
    void customExample() {
        int[] arr = {1, 1, 1, 1, 1};
        int key = 1;
        int[] expected = {0, 4};
        assertThat(numberRange.findRange(arr, key)).containsExactly(expected);
    }
}