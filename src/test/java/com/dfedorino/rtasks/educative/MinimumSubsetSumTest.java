package com.dfedorino.rtasks.educative;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class MinimumSubsetSumTest {
    static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.of(new int[] {1, 2, 3, 9}, 3),
                Arguments.of(new int[] {1, 2, 7, 1, 5}, 0),
                Arguments.of(new int[] {1, 3, 100, 4}, 92)
        );
    }

    @ParameterizedTest(name = "nums={0}, expected={1}")
    @MethodSource("examples")
    void shouldPartitionWithTopDownApproach(int[] nums, int expected) {
        assertThat(new MinimumSubsetSum.TopDown().canPartition(nums)).isEqualTo(expected);
    }
}