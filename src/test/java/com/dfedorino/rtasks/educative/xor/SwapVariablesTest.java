package com.dfedorino.rtasks.educative.xor;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SwapVariablesTest {
    SwapVariables swapVariables = new SwapVariables();

    @Test
    void example1() {
        int[] vars = {1, 2};
        int[] expected = {2, 1};
        swapVariables.swap(vars);
        assertThat(vars).isEqualTo(expected);
    }
}