package com.dfedorino.rtasks.educative.xor;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindTwoMissingNumbersTest {
    @Test
    void example1() {
        int[] arr = {1, 5, 2, 4, 7};
        assertThat(FindTwoMissingNumbers.find(arr))
                .containsExactlyInAnyOrder(3, 6);
    }
}