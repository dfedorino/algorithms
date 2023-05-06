package com.dfedorino.rtasks.educative.dp;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class TargetSumTest {

    static Stream<Arguments> examples() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 2, 3}, 1, 3),
                Arguments.of(new int[]{1, 2, 7, 1}, 9, 2)
        );
    }

    @ParameterizedTest(name = "top-down, nums={0}, sum={1}, expected={2}")
    @MethodSource("examples")
    void shouldCountSubsetsWithTargetSumWithTopDownApproach(int[] nums, int sum, int expectedCount) {
        assertThat(new TargetSum.BottomUp().findTargetSubsets(nums, sum)).isEqualTo(expectedCount);
    }
}