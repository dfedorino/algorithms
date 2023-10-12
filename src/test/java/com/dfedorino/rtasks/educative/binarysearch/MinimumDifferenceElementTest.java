package com.dfedorino.rtasks.educative.binarysearch;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumDifferenceElementTest {
    private final MinimumDifferenceElement solution = new MinimumDifferenceElement();

    /**
     * Element is not in the array
     */
    @Test
    void example1() {
        int[] arr = {4, 6, 10};
        int key = 7;
        int expected = 6;
        assertThat(solution.search(arr, key)).isEqualTo(expected);
    }

    /**
     * Element is in the array
     */
    @Test
    void example2() {
        int[] arr = {4, 6, 10};
        int key = 4;
        int expected = 4;
        assertThat(solution.search(arr, key)).isEqualTo(expected);
    }

    /**
     * Larger array, element is not in the array
     */
    @Test
    void example3() {
        int[] arr = {1, 3, 8, 10, 15};
        int key = 12;
        int expected = 10;
        assertThat(solution.search(arr, key)).isEqualTo(expected);
    }

    /**
     * Element is not in the array, greater than the largest element
     */
    @Test
    void example4() {
        int[] arr = {4, 6, 10};
        int key = 17;
        int expected = 10;
        assertThat(solution.search(arr, key)).isEqualTo(expected);
    }

    /**
     * Element is not in the array, smaller than the smallest element
     */
    @Test
    void customExample1() {
        int[] arr = {4, 6, 10};
        int key = 1;
        int expected = 4;
        assertThat(solution.search(arr, key)).isEqualTo(expected);
    }

    /**
     * Element is in the array, several duplicates
     */
    @Test
    void customExample2() {
        int[] arr = {4, 6, 6, 6, 10};
        int key = 6;
        int expected = 6;
        assertThat(solution.search(arr, key)).isEqualTo(expected);
    }

    /**
     * Element is not in the array, equal difference with neighbouring elements
     * 6 - 4 = 2
     * 8 - 6 = 2
     */
    @Test
    void customExample3() {
        int[] arr = {4, 8, 10};
        int key = 6;
        assertThat(solution.search(arr, key)).isIn(4, 8);
    }
}