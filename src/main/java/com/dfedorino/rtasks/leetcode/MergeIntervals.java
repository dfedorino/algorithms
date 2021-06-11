package com.dfedorino.rtasks.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    /**
     * Given an array of intervals where intervals[i] = [start i, end i], merge all overlapping intervals,
     * and return an array of the non-overlapping intervals that cover all the intervals in the input.
     *
     * @param intervals 1 <= intervals.length <= 10^4,  intervals[i].length == 2, 0 <= start i <= end i <= 10^4
     * @return an array of the non-overlapping intervals that cover all the intervals in the input
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt((int[] subArray) -> subArray[0]));
        List<int[]> result = new ArrayList<>();
        for (int i = 1; i <= intervals.length; i++) {
            if (i == intervals.length) {
                result.add(intervals[i - 1]);
                break;
            }
            int[] right = intervals[i];
            int[] left = intervals[i - 1];
            boolean isMergeable = right[0] <= left[1];
            if (isMergeable) {
                intervals[i] = new int[] {left[0], Math.max(left[1], right[1])};
            } else {
                result.add(left);
            }
        }
        return result.toArray(new int[0][]);
    }
}
