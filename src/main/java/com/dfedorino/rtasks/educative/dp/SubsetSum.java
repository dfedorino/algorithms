package com.dfedorino.rtasks.educative.dp;

import java.util.Arrays;

public interface SubsetSum {
    /**
     * Given a set of positive numbers, determine if a subset exists whose sum is equal to a given number ‘S’.
     *
     * @param nums - unsorted set of positive integers
     * @param sum  - positive integer
     * @return true if there is at least 1 subset with sum equal to sum
     * <p>
     * Example 1
     * Input: {1, 2, 3, 7}, S=6
     * Output: True
     * The given set has a subset whose sum is '6': {1, 2, 3}
     * <p>
     * Example 2
     * Input: {1, 2, 7, 1, 5}, S=10
     * Output: True
     * The given set has a subset whose sum is '10': {1, 2, 7}
     * <p>
     * Example 3
     * Input: {1, 3, 4, 8}, S=6
     * Output: False
     * The given set does not have any subset whose sum is equal to '6'.
     */
    boolean canPartition(int[] nums, int sum);

    class TopDown implements SubsetSum {

        @Override
        public boolean canPartition(int[] nums, int sum) {
            return canPartition(nums, sum, 0);
        }

        private boolean canPartition(int[] nums, int sum, int i) {
            if (i == nums.length) {
                return false;
            }

            if (sum == 0) {
                return true;
            }

            if (nums[i] <= sum && canPartition(nums, sum - nums[i], i + 1)) {
                return true;
            }

            return canPartition(nums, sum, i + 1);
        }
    }

    class TopDownMemo implements SubsetSum {

        @Override
        public boolean canPartition(int[] nums, int sum) {
            Boolean[][] memo = new Boolean[nums.length][sum + 1];
            return canPartition(nums, sum, 0, memo);
        }

        private boolean canPartition(int[] nums, int sum, int i, Boolean[][] memo) {
            if (i == nums.length) {
                return false;
            }

            // TODO: consider moving it inside the calculation
            if (sum == 0) {
                return true;
            }

            if (memo[i][sum] == null) {
                if (nums[i] <= sum && canPartition(nums, sum - nums[i], i + 1, memo)) {
                    memo[i][sum] = true;
                    return true;
                }
                memo[i][sum] = canPartition(nums, sum, i + 1, memo);
            }
            return memo[i][sum];
        }
    }

    class BottomUp implements SubsetSum {

        @Override
        public boolean canPartition(int[] nums, int sum) {
            /**
             * 'memo' is built to include all possible sums (including 0) till 'sum'
             * also every number must be processed, so there will be 'nums.length' indexes (all possible indexes)
             * the 'boolean' type is used, because we don't need to check nullity, we will only rely on previously calculated result
             */
            boolean[][] memo = new boolean[nums.length][sum + 1];

            /**
             * for the nums = {1, 2, 3, 7}, sum = 6 we must build the following memo table:
             *
             *      0   1   2   3   4   5   6
             * 0    t   t   f   f   f   f   f
             * 1    t
             * 2    t
             * 3    t
             *
             * we will not go beyond 6 as we are not interested in any bigger sum
             * for the '0' sum we always return 'true' as we can just exclude all the numbers
             * for the '0' index we can easily define whether it's true or false with the following logic:
             *  if nums[0] == s, then 'true' else - 'false'
             */
            for (int i = 0; i < nums.length; i++) {
                memo[i][0] = true;
            }

            /**
             * we must skip s == 0, because we've already solved it
             */
            for (int s = 1; s <= sum; s++) {
                memo[0][s] = nums[0] == s;
            }
//            print(memo);

            /**
             * at this point we're ready to use the 'result if skip or result if include' approach
             * we will go from index 1 up to index 3 and check result if skip:
             * memo[i - 1][s] - indeed, the sum is not changed, only the amount of numbers in the subset
             *
             * also we will check result if include:
             * if (nums[i] <= s) {
             *     memo[i - 1][s - nums[i]]
             * }
             * we don't need to check if the current num is too large
             *
             * we go backwards [i - 1] because we know the result for all the previous elements both included or excluded
             */

            for (int i = 1; i < nums.length; i++) {
                for (int s = 1; s <= sum; s++) {
                    boolean resultIfInclude = nums[i] <= s && memo[i - 1][s - nums[i]];
                    boolean resultIfSkip = memo[i - 1][s];
                    memo[i][s] = resultIfInclude || resultIfSkip;
                }
            }

            print(memo);

            return memo[nums.length - 1][sum];
        }

        private static void print(boolean[][] memo) {
            for (boolean[] row : memo) {
                System.out.println(Arrays.toString(row));
            }
        }
    }
}
