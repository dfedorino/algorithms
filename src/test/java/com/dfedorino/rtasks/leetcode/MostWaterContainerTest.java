package com.dfedorino.rtasks.leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MostWaterContainerTest {
    private final MostWaterContainer app = new MostWaterContainer();

    @Test
    public void testMaxArea_whenTestCaseOne_then49() {
        int[] testCase = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        assertThat(app.maxArea(testCase)).isEqualTo(49);
    }

    @Test
    public void testMaxArea_whenOnlyElements_then1() {
        int[] testCase = {1, 1};
        assertThat(app.maxArea(testCase)).isEqualTo(1);
    }

    @Test
    public void testMaxArea_whenTestCaseThree_then2() {
        int[] testCase = {1, 2, 1};
        assertThat(app.maxArea(testCase)).isEqualTo(2);
    }
}