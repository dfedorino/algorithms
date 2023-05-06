package com.dfedorino.rtasks.educative.dp;

public interface SubsetSumCount {
    /**
     * Given a set of positive numbers, find the total number of subsets
     * whose sum is equal to a given number ‘S’.
     *
     * Example 1:
     * Input: {1, 1, 2, 3}, S=4
     * Output: 3
     * The given set has '3' subsets whose sum is '4': {1, 1, 2}, {1, 3}, {1, 3}
     * Note that we have two similar sets {1, 3}, because we have two '1' in our input.
     *
     * Input: {1, 2, 7, 1, 5}, S=9
     * Output: 3
     * The given set has '3' subsets whose sum is '9': {2, 7}, {1, 7, 1}, {1, 2, 1, 5}
     */
    int countSubsets(int[] nums, int sum);

    class TopDown implements SubsetSumCount {

        @Override
        public int countSubsets(int[] nums, int sum) {
            return countSubsets(nums, sum, 0);
        }

        private int countSubsets(int[] nums, int sum, int i) {
            if (sum == 0) {
                return 1;
            }

            if (i == nums.length) {
                return 0;
            }

            int subsetsWhenSkip = countSubsets(nums, sum, i + 1);
            int subsetsWhenInclude = sum >= nums[i] ? countSubsets(nums, sum - nums[i], i + 1) : 0;

            return subsetsWhenSkip + subsetsWhenInclude;
        }
    }

    class TopDownMemo implements SubsetSumCount {

        @Override
        public int countSubsets(int[] nums, int sum) {
            Integer[][] memo = new Integer[nums.length][sum + 1];
            return countSubsets(nums, sum, 0, memo);
        }

        private int countSubsets(int[] nums, int sum, int i, Integer[][] memo) {
            if (sum == 0) {
                return 1;
            }

            if (i == nums.length) {
                return 0;
            }

            if (memo[i][sum] == null) {
                int subsetCountIfSkip = countSubsets(nums, sum, i + 1, memo);
                int subsetCountIfInclude = sum >= nums[i] ? countSubsets(nums, sum - nums[i], i + 1, memo) : 0;
                memo[i][sum] = subsetCountIfSkip + subsetCountIfInclude;
            }

            return memo[i][sum];
        }
    }

    class BottomUp implements SubsetSumCount {

        @Override
        public int countSubsets(int[] nums, int sum) {
            int[][] memo = new int[nums.length][sum + 1];

            // we can always find an empty subset by excluding all the numbers
            for (int i = 0; i < nums.length; i++) {
                memo[i][0] = 1;
            }

            // when we have only 1 number in each subset, compare it with the sum
            for (int s = 1; s <= sum; s++) {
                memo[0][s] = nums[0] == s ? 1 : 0;
            }

            for (int i = 1; i < nums.length; i++) {
                for (int s = 1; s <= sum; s++) {
                    // result if skip
                    memo[i][s] = memo[i - 1][s];
                    if ( s >= nums[i] ) {
                        // result if include
                        memo[i][s] += memo[i - 1][s - nums[i]];
                    }
                }
            }
            return memo[nums.length - 1][sum];
        }
    }
}
