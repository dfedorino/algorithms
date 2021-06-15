package com.dfedorino.rtasks.leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MergeIntervalsTest {
    private MergeIntervals app = new MergeIntervals();

    @Test
    public void testMerge_whenArrayOfLength1IsPassed_thenSameArrayIsReturned() {
        int[][] array = new int[][] {{1, 10}};
        assertThat(app.merge(array)).isEqualTo(array);
    }

    @Test
    public void testMerge_whenTestCase1_thenArrayOfLength3IsReturned() {
        int[][] array = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        int[][] expected = {
                {1, 6},
                {8, 10},
                {15, 18}
        };
        assertThat(app.merge(array)).isEqualTo(expected);
    }

    @Test
    public void testMerge_whenTestCase2_thenArrayOfLength1IsReturned() {
        int[][] array = {
                {1, 4},
                {4, 5}
        };
        int[][] expected = {
                {1, 5}
        };
        assertThat(app.merge(array)).isEqualTo(expected);
    }

    @Test
    public void testMerge_whenUnsortedArray_thenArrayOfLength1IsReturned() {
        int[][] array = {
                {2, 4},
                {3, 5},
                {4, 6},
                {5, 7},
                {6, 8},
                {7, 9},
                {1, 10}
        };
        int[][] expected = {
                {1, 10}
        };
        assertThat(app.merge(array)).isEqualTo(expected);
    }
}