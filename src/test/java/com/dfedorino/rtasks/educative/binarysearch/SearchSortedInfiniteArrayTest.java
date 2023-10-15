package com.dfedorino.rtasks.educative.binarysearch;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SearchSortedInfiniteArrayTest {
    private final SearchSortedInfiniteArray solution = new SearchSortedInfiniteArray();
    @Test
    void example1() {
        int[] arr = {4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30};
        var arrayReader = new SearchSortedInfiniteArray.ArrayReader(arr);
        int key = 16;
        assertThat(solution.search(arrayReader, key)).isEqualTo(6);
    }

    @Test
    void example2() {
        int[] arr = {4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30};
        var arrayReader = new SearchSortedInfiniteArray.ArrayReader(arr);
        int key = 11;
        assertThat(solution.search(arrayReader, key)).isEqualTo(-1);
    }

    @Test
    void example3() {
        int[] arr = {1, 3, 8, 10, 15};
        var arrayReader = new SearchSortedInfiniteArray.ArrayReader(arr);
        int key = 15;
        assertThat(solution.search(arrayReader, key)).isEqualTo(4);
    }

    @Test
    void example4() {
        int[] arr = {1, 3, 8, 10, 15};
        var arrayReader = new SearchSortedInfiniteArray.ArrayReader(arr);
        int key = 200;
        assertThat(solution.search(arrayReader, key)).isEqualTo(-1);
    }
}