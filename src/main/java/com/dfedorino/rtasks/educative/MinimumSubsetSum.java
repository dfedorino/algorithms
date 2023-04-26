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

    class EducativeTopDown implements MinimumSubsetSum {

        @Override
        public int canPartition(int[] nums) {
            return canPartition(nums, 0, 0, 0);
        }

        private int canPartition(int[] nums, int i, int sum1, int sum2) {
            if (i == nums.length) {
                return Math.abs(sum1 - sum2);
            }
            int resultIfInclude = canPartition(nums, i + 1, sum1 + nums[i], sum2);
            int resultIfSkip = canPartition(nums, i + 1, sum1, sum2 + nums[i]);
            return Math.min(resultIfInclude, resultIfSkip);
        }
    }

    class TopDownMemo implements MinimumSubsetSum {

        @Override
        public int canPartition(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            Integer[][] memo = new Integer[nums.length + 1][sum + 1];
            return canPartition(nums, 0, sum, 0, memo);
        }

        private int canPartition(int[] nums, int i, int totalSum, int currSum, Integer[][] memo) {
            if (memo[i][totalSum] == null) {
                if (i == nums.length) {
                    return Math.abs(totalSum - currSum);
                }
                int diff1 = canPartition(nums, i + 1, totalSum - nums[i], currSum + nums[i], memo);
                int diff2 = canPartition(nums, i + 1, totalSum, currSum, memo);
                memo[i][totalSum] = Math.min(diff1, diff2);
            }
            return memo[i][totalSum];
        }
    }

    class EducativeTopDownMemo implements MinimumSubsetSum {

        @Override
        public int canPartition(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            Integer[][] memo = new Integer[nums.length][sum + 1];
            return canPartition(nums, 0, 0, 0, memo);
        }

        private int canPartition(int[] nums, int i, int sum1, int sum2, Integer[][] memo) {
            if (i == nums.length) {
                return Math.abs(sum1 - sum2);
            }
            if (memo[i][sum1] == null) {
                int diff1 = canPartition(nums, i + 1, sum1 + nums[i], sum2, memo);
                int diff2 = canPartition(nums, i + 1, sum1, sum2 + nums[i], memo);
                memo[i][sum1] = Math.min(diff1, diff2);
            }
            return memo[i][sum1];
        }
    }

    class BottomUp implements MinimumSubsetSum {

        @Override
        public int canPartition(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            /**
             * in this problem we need to find a subset sum as close as possible to S/2,
             * because in this case the min difference will be 0 (idea from educative)
             */
            int half = sum / 2;
            boolean[][] memo = new boolean[nums.length][half + 1];

            /**
             * for the '0' sum we can always exclude all the numbers
             */
            for (int i = 0; i < nums.length; i++) {
                memo[i][0] = true;
            }

            /**
             * if the 1st number is equal to any possible sum from 1 to S/2, then true, else false
             */
            for (int s = 1; s <= half; s++) {
                memo[0][s] = nums[0] == s;
            }

            /**
             * for all the following numbers we check result if include and result if skip
             */
            for (int i = 1; i < nums.length; i++) {
                for (int s = 1; s <= half; s++) {
                    boolean resultIfSkip = memo[i - 1][s];
                    boolean resultIfInclude = nums[i] <= s && memo[i - 1][s - nums[i]];
                    memo[i][s] = resultIfSkip || resultIfInclude;
                }
            }

            /**
             * the above solution is the same as in the 'Subset Sum' problem except for the following:
             * if we cannot find subset sum equal to S/2, we need to find the closest sum
             */
            int maxSubsetSumClosestToHalf = 0;
            for (int i = sum / 2; i >= 0; i--) {
                if (memo[nums.length - 1][i]) {
                    maxSubsetSumClosestToHalf = i;
                    break;
                }
            }

            int diff = sum - maxSubsetSumClosestToHalf;
            return Math.abs(diff - maxSubsetSumClosestToHalf);
        }
    }
}
