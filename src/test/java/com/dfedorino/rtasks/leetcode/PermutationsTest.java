package com.dfedorino.rtasks.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PermutationsTest {
    private final Permutations app = new Permutations();

    @Test(dataProvider = "testCases")
    void when_given_numbers_then_all_possible_permutations(int[] givenNums, List<List<Integer>> expectedPermutations) {
        assertThat(app.permute(givenNums)).isEqualTo(expectedPermutations);
    }

    @DataProvider(name = "testCases")
    public Object[][] testCases() {
        return new Object[][] {
                {new int[] {1, 2, 3}, List.of(
                        List.of(1, 2, 3),
                        List.of(2, 1, 3),
                        List.of(3, 1, 2),
                        List.of(1, 3, 2),
                        List.of(2, 3, 1),
                        List.of(3, 2, 1)
                )},
                {new int[] {0, 1}, List.of(
                        List.of(0, 1),
                        List.of(1, 0)
                )},
                {new int[] {1}, List.of(List.of(1))}
        };
    }
}
