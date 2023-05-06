package com.dfedorino.rtasks.educative.dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SubsetSumCountTest {

    static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 2, 3}, 4, 3),
                Arguments.of(new int[]{1, 2, 7, 1, 5}, 9, 3)
        );
    }

    @ParameterizedTest(name = "top-down, nums={0}, sum={1}, expected={2}")
    @MethodSource("examples")
    void shouldCountSubsetsEqualToSumWithTopDownApproach(int[] nums, int sum, int expectedCount) {
        assertThat(new SubsetSumCount.TopDown().countSubsets(nums, sum)).isEqualTo(expectedCount);
    }

    @ParameterizedTest(name = "top-down + memo, nums={0}, sum={1}, expected={2}")
    @MethodSource("examples")
    void shouldCountSubsetsEqualToSumWithTopDownMemoApproach(int[] nums, int sum, int expectedCount) {
        assertThat(new SubsetSumCount.TopDownMemo().countSubsets(nums, sum)).isEqualTo(expectedCount);
    }

    @ParameterizedTest(name = "bottom-up, nums={0}, sum={1}, expected={2}")
    @MethodSource("examples")
    void shouldCountSubsetsEqualToSumWithBottomUpApproach(int[] nums, int sum, int expectedCount) {
        assertThat(new SubsetSumCount.BottomUp().countSubsets(nums, sum)).isEqualTo(expectedCount);
    }
}