package com.dfedorino.rtasks.educative.topologicalsort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProblemChallenge1Test {
    private final ProblemChallenge1 problemChallenge1 = new ProblemChallenge1();

    @Test
    void shouldReturnTrueExample1() {
        int[] originalSeq = {1, 2, 3, 4};
        int[][] seqs = {
                {1, 2},
                {2, 3},
                {3, 4}
        };
        assertThat(problemChallenge1.canConstruct(originalSeq, seqs)).isTrue();
    }

    @Test
    void shouldReturnFalseExample2() {
        int[] originalSeq = {1, 2, 3, 4};
        int[][] seqs = {
                {1, 2},
                {2, 3},
                {2, 4}
        };
        assertThat(problemChallenge1.canConstruct(originalSeq, seqs)).isFalse();
    }

    @Test
    void shouldReturnTrueExample3() {
        int[] originalSeq = {3, 1, 4, 2, 5};
        int[][] seqs = {
                {3, 1, 5},
                {1, 4, 2, 5}
        };
        assertThat(problemChallenge1.canConstruct(originalSeq, seqs)).isTrue();
    }

    @Test
    void shouldReturnFalseWhenSameLengthButDifferentNodes() {
        int[] originalSeq = {1, 2, 3, 4};
        int[][] seqs = {
                {2, 3},
                {3, 4},
                {4, 5}
        };
        assertThat(problemChallenge1.canConstruct(originalSeq, seqs)).isFalse();
    }
}