package com.dfedorino.rtasks.educative.xor;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FlipAndInvertImageTest {

    @Test
    void example1() {
        int[][] image = {
                {1, 0, 1},
                {1, 1, 1},
                {0, 1, 1}
        };

        int[][] expected = {
                {0, 1, 0},
                {0, 0, 0},
                {0, 0, 1}
        };

        assertThat(FlipAndInvertImage.flipAndInvertImageNoXor(image)).isEqualTo(expected);
        assertThat(FlipAndInvertImage.flipAndInvertImageWithXor(image)).isEqualTo(expected);
    }

    @Test
    void example2() {
        int[][] image = {
                {1, 1, 0, 0},
                {1, 0, 0, 1},
                {0, 1, 1, 1},
                {1, 0, 1, 0}
        };

        int[][] expected = {
                {1, 1, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 1},
                {1, 0, 1, 0}
        };

        assertThat(FlipAndInvertImage.flipAndInvertImageNoXor(image)).isEqualTo(expected);
        assertThat(FlipAndInvertImage.flipAndInvertImageWithXor(image)).isEqualTo(expected);
    }
}