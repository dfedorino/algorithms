package com.dfedorino.rtasks.educative.dp;

public interface TargetSum {
    /**
     * You are given a set of positive numbers and a target sum ‘S’.
     * Each number should be assigned either a ‘+’ or ‘-’ sign.
     * We need to find the total ways to assign symbols
     * to make the sum of the numbers equal to the target ‘S’.
     * <p>
     * Example 1:
     * Input: {1, 1, 2, 3}, S=1
     * Output: 3
     * Explanation: The given set has '3' ways to make a sum of '1': {+1-1-2+3} & {-1+1-2+3} & {+1+1+2-3}
     * <p>
     * Example 2:
     * Input: {1, 2, 7, 1}, S=9
     * Output: 2
     * Explanation: The given set has '2' ways to make a sum of '9': {+1+2+7-1} & {-1+2+7+1}
     */

    int findTargetSubsets(int[] nums, int s);

    class BottomUp implements TargetSum {

        @Override
        public int findTargetSubsets(int[] nums, int targetSum) {
            // let's consider the following example: {1, 1, 2, 3}, S=1
            // one of the solutions is  {+1-1-2+3} = 4 - 3 = 1
            // it can be converted to the following equation:
            // (1 + 3) - (1 + 2) = 1
            //
            // sum(s1) - sum(s2) = s
            //
            // let's find the relation between the total sum of the array and each subset
            // to reduce the problem to the finding of the subset sum equal to some value:
            //
            // sum(s1) + sum(s2) = sum(nums)
            //
            // if we combine the two equations above, we will get:
            // sum(s1) - sum(s2) + sum(s1) + sum(s2) = s + sum(s)
            // sum(s1) + sum(s1) - sum(s2) + sum(s2) = s + sum(s)
            // 2 * sum(s1) = s + sum(s)
            //
            // sum(s1) = (s + sum(s)) / 2
            //
            // with the equation above we can find count of all sub-arrays which sum is equal to (s + sum(s)) / 2

            int totalSum = 0;
            for (int n : nums) {
                totalSum += n;
            }

            // if 's + totalSum' is odd, we can't find a subset with sum equal to '(s + totalSum) / 2'
            if (totalSum < targetSum || (targetSum + totalSum) % 2 == 1) {
                return 0;
            }

            // we don't need this variable anymore, so replace with the equation result
            targetSum = (totalSum + targetSum) / 2;

            int[][] memo = new int[nums.length][targetSum + 1];

            // populate the sum=0 columns, as we will always have an empty set for zero sum
            for (int i = 0; i < nums.length; i++)
                memo[i][0] = 1;

            // with only one number, we can form a subset only when the required sum is equal to the nu mber
            for (int s = 1; s <= targetSum; s++) {
                memo[0][s] = (nums[0] == s ? 1 : 0);
            }

            // process all subsets for all sums
            for (int i = 1; i < nums.length; i++) {
                for (int s = 1; s <= targetSum; s++) {
                    memo[i][s] = memo[i - 1][s];
                    if (nums[i] <= s) {
                        memo[i][s] += memo[i - 1][s - nums[i]];
                    }
                }
            }

            return memo[nums.length - 1][targetSum];
        }
    }
}
