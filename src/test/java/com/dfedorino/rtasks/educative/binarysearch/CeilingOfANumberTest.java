package com.dfedorino.rtasks.educative.binarysearch;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CeilingOfANumberTest {
    private final CeilingOfANumber ceilingOfANumber = new CeilingOfANumber();
    @Test
    void example1() {
        int[] arr = {4, 6, 10};
        int key = 6;
        assertThat(ceilingOfANumber.searchCeilingOfANumber(arr, key)).isEqualTo(1);
    }

    @Test
    void example2() {
        int[] arr = {1, 3, 8, 10, 15};
        int key = 12;
        assertThat(ceilingOfANumber.searchCeilingOfANumber(arr, key)).isEqualTo(4);
    }

    @Test
    void example3() {
        int[] arr = {4, 6, 10};
        int key = 17;
        assertThat(ceilingOfANumber.searchCeilingOfANumber(arr, key)).isEqualTo(-1);
    }

    @Test
    void example4() {
        int[] arr = {4, 6, 10};
        int key = -1;
        assertThat(ceilingOfANumber.searchCeilingOfANumber(arr, key)).isEqualTo(0);
    }
}