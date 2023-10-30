package com.dfedorino.rtasks.educative.xor;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SingleNumberTest {
    private final SingleNumber singleNumber = new SingleNumber();

    @Test
    void example1() {
        int[] arr = {1, 4, 2, 1, 3, 2, 3};
        assertThat(singleNumber.findSingleNumber(arr)).isEqualTo(4);
    }

    @Test
    void example2() {
        int[] arr = {7, 9, 7};
        assertThat(singleNumber.findSingleNumber(arr)).isEqualTo(9);
    }
}