package com.dfedorino.rtasks.educative.dp;


import com.dfedorino.rtasks.educative.dp.SubsetSum;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SubsetSumTest {
    static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 7}, 6, true),
                Arguments.of(new int[]{1, 2, 7, 1, 5}, 10, true),
                Arguments.of(new int[]{1, 3, 4, 8}, 6, false)
        );
    }

    @ParameterizedTest(name = "top-down, nums={0}, sum={1}, expected={2}")
    @MethodSource("examples")
    void shouldDetermineWithTopDownApproach(int[] nums, int sum, boolean expected) {
        assertThat(new SubsetSum.TopDown().canPartition(nums, sum)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "top-down + memo, nums={0}, sum={1}, expected={2}")
    @MethodSource("examples")
    void shouldDetermineWithTopDownMemoApproach(int[] nums, int sum, boolean expected) {
        assertThat(new SubsetSum.TopDownMemo().canPartition(nums, sum)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "top-down + memo, nums={0}, sum={1}, expected={2}")
    @MethodSource("examples")
    void shouldDetermineWithBottomUpApproach(int[] nums, int sum, boolean expected) {
        assertThat(new SubsetSum.BottomUp().canPartition(nums, sum)).isEqualTo(expected);
    }
}