package com.dfedorino.rtasks.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
    /**
     * Given an array nums of distinct integers, return all the possible permutations.
     * You can return the answer in any order.
     *
     * Link to the task: https://leetcode.com/problems/permutations/
     *
     * @param nums: 1 <= nums.length <= 6, -10 <= nums[i] <= 10, all elements are unique
     * @return list of all possible permutations
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        permute(nums, nums.length, permutations);
        return permutations;
    }

    private void permute(int[] nums, int k, List<List<Integer>> permutations) {
        // Heap's algorithm
        // time complexity: O(n!)
        // space complexity: O(1)
        if (k == 1) {
            permutations.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        } else {
            for (int i = 0; i < k; i++) {
                permute(nums, k - 1, permutations);
                if (k % 2 == 0) {
                    swap(nums, i, k - 1);
                } else {
                    swap(nums, 0, k - 1);
                }
            }
        }
    }

    private void swap(int[] nums, int firstElementIndex, int secondElementIndex) {
        int temp = nums[firstElementIndex];
        nums[firstElementIndex] = nums[secondElementIndex];
        nums[secondElementIndex] = temp;
    }
}
