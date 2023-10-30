package com.dfedorino.rtasks.educative.xor;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TwoSingleNumbersTest {
    @Test
    void example1() {
        int[] arr = {1, 4, 2, 1, 3, 5, 6, 2, 3, 5};
        assertThat(TwoSingleNumbers.findSingleNumbers(arr))
                .containsExactlyInAnyOrder(4, 6);
    }

    @Test
    void example2() {
        int[] arr = {2, 1, 3, 2};
        assertThat(TwoSingleNumbers.findSingleNumbers(arr))
                .containsExactlyInAnyOrder(1, 3);
    }
}