package com.dfedorino.rtasks.educative.xor;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ComplementOfBase10NumberTest {
    @Test
    void example1() {
        assertThat(ComplementOfBase10Number.bitwiseComplement(8)).isEqualTo(7);
    }

    @Test
    void example2() {
        assertThat(ComplementOfBase10Number.bitwiseComplement(10)).isEqualTo(5);
    }
}