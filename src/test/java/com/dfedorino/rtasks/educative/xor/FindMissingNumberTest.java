package com.dfedorino.rtasks.educative.xor;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindMissingNumberTest {
    private final FindMissingNumber findMissingNumber = new FindMissingNumber();

    @Test
       void example1() {
        int[] arr = {1, 5, 2, 6, 4};
        assertThat(findMissingNumber.findViaSum(arr)).isEqualTo(3);
        assertThat(findMissingNumber.findViaXor(arr)).isEqualTo(3);
    }
}