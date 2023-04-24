package com.dfedorino.rtasks.educative;

import java.util.Arrays;

public interface MinimumSubsetSum {
    /**
     * Given a set of positive numbers, partition the set into two subsets with minimum difference between their subset sums.
     * <p>
     * Example 1:
     * Input: {1, 2, 3, 9}
     * Output: 3
     * Explanation: We can partition the given set into two subsets where minimum absolute difference
     * between the sum of numbers is 3. Following are the two subsets: {1, 2, 3} & {9}.
     * <p>
     * Example 2:
     * Input: {1, 2, 7, 1, 5}
     * Output: 0
     * Explanation: We can partition the given set into two subsets where minimum absolute difference
     * between the sum of number is 0. Following are the two subsets: {1, 2, 5} & {7, 1}.
     * <p>
     * Example 3:
     * Input: {1, 3, 100, 4}
     * Output: 92
     * Explanation: We can partition the given set into two subsets where minimum absolute difference
     * between the sum of numbers is 92. Here are the two subsets: {1, 3, 4} & {100}.
     *
     * @param nums - unsorted array of positive integers
     * @return - min difference between subset sums
     */
    int canPartition(int[] nums);

    class TopDown implements MinimumSubsetSum {

        @Override
        public int canPartition(int[] nums) {
            // every time we can either include or exclude each number
            // 1, 2, 3, 9, totalSum = 15

            // {1} - {2, 3, 9} = (totalSum - nums[i]) - currSum = 14 - 1 = 13
            // {1, 2} - {3, 9} = (totalSum - nums[i]) - currSum = 12 - 3 = 9
            // {1, 2, 3} - {9} = (totalSum - nums[i]) - currSum = 9 - 6 = 3
            // {1, 2, 3, 9} - {0} = (totalSum - nums[i]) - currSum = 15 - 0 = 15
            return canPartition(nums, 0, Arrays.stream(nums).sum(), 0);
        }

        private int canPartition(int[] nums, int i, int totalSum, int currSum) {
            if (i == nums.length) {
                return Math.abs(totalSum - currSum);
            }
            int resultIfInclude = canPartition(nums, i + 1, totalSum - nums[i], currSum + nums[i]);
            int resultIfSkip = canPartition(nums, i + 1, totalSum, currSum);
            return Math.min(resultIfInclude, resultIfSkip);
        }
    }
}
