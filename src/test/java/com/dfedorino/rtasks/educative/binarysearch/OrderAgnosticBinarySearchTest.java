package com.dfedorino.rtasks.educative.binarysearch;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderAgnosticBinarySearchTest {
    private final OrderAgnosticBinarySearch orderAgnosticBinarySearch = new OrderAgnosticBinarySearch();
    @Test
    void shouldReturnIndexExample1() {
        int[] arr = {4, 6, 10};
        int key = 10;
        assertThat(orderAgnosticBinarySearch.search(arr, key)).isEqualTo(2);
    }

    @Test
    void shouldReturnMinusOneCustomExample() {
        int[] arr = {4, 6, 10};
        int key = 11;
        assertThat(orderAgnosticBinarySearch.search(arr, key)).isEqualTo(-1);
    }

    @Test
    void shouldReturnIndexExample2() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int key = 5;
        assertThat(orderAgnosticBinarySearch.search(arr, key)).isEqualTo(4);
    }

    @Test
    void shouldReturnIndexExample3() {
        int[] arr = {10, 6, 4};
        int key = 4;
        assertThat(orderAgnosticBinarySearch.search(arr, key)).isEqualTo(2);
    }

    @Test
    void shouldReturnIndexCustomExample() {
        int[] arr = {1, 2, 3, 4, 5, 5, 6, 7};
        int key = 5;
        assertThat(orderAgnosticBinarySearch.search(arr, key)).isPositive();
    }
}