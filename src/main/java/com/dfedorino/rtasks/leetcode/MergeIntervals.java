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
        Arrays.sort(intervals, Comparator.comparingInt((int[] subArray) -> subArray[0]));
        List<int[]> result = new ArrayList<>();
        int leftBorder = intervals[0][0];
        int rightBorder = intervals[0][1];
        for (int i = 1; i <= intervals.length; i++) {
            if (i == intervals.length) {
                result.add(new int[] {leftBorder, rightBorder});
                break;
            }
            int[] current = intervals[i];
            int leftBorderOfCurrent = current[0];
            int rightBorderOfPrevious = rightBorder;
            boolean canBeMerged = rightBorderOfPrevious >= leftBorderOfCurrent;
            if (canBeMerged) {
                rightBorder = Math.max(rightBorder, current[1]);
            } else {
                result.add(new int[] {leftBorder, rightBorder});
                leftBorder = current[0];
                rightBorder = current[1];
            }
            result.forEach(interval -> System.out.println(Arrays.toString(interval)));
        }
        return result.toArray(new int[0][]);
    }
}
