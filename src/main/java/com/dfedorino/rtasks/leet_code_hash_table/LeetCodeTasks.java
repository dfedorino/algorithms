package com.dfedorino.rtasks.leet_code_hash_table;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCodeTasks {
    /**
     * Given an array of integers nums.
     * A pair (i,j) is called good if nums[i] == nums[j] and i < j.
     * Return the number of good pairs.
     *
     * @param nums - an array of numbers that is 1 <= length <= 100 and 1 <= nums[i] <= 100
     * @return number of 'good' pairs.
     */
    public static int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int goodPairs = 0;
        for (int num : nums) {
            int quantity = map.getOrDefault(num, 0);
            map.put(num, ++quantity);
        }
        for (int quantity : map.values()) {
            int pairs = numberOfPairs(quantity);
            goodPairs += pairs;
        }
        return goodPairs;
    }

    private static int numberOfPairs(int quantityOfNums) {
        int result = 0;
        for (int i = 1; i < quantityOfNums; i++) {
            result += i;
        }
        return result;
    }

    /**
     * You're given strings jewels representing the types of stones that are jewels, and stones representing
     * the stones you have. Each character in stones is a type of stone you have. You want to know how many
     * of the stones you have are also jewels.
     * Letters are case sensitive, so "a" is considered a different type of stone from "A".
     *
     * @param jewels - a string containing jewels types which is 1 <= length <= 50
     * @param stones - a string containing stones which is 1 <= length <= 50
     * @return number of jewels found in stones
     */
    public static int numJewelsInStones(String jewels, String stones) {
        int foundJewels = 0;
        Set<Character> jewelsSet = new HashSet<>();
        for (int jewelsIndex = 0; jewelsIndex < jewels.length(); jewelsIndex++) {
            jewelsSet.add(jewels.charAt(jewelsIndex));
        }
        for (int stoneIndex = 0; stoneIndex < stones.length(); stoneIndex++) {
            if (jewelsSet.contains(stones.charAt(stoneIndex))) {
                foundJewels++;
            }
        }
        return foundJewels;
    }
}
