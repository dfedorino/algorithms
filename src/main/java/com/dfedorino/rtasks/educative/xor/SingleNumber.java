package com.dfedorino.rtasks.educative.xor;

public class SingleNumber {
    /**
     * In a non-empty array of integers,
     * every number appears twice except for one,
     * find that single number.
     *
     * Example 1:
     *
     * Input: 1, 4, 2, 1, 3, 2, 3
     * Output: 4
     *
     * Example 2:
     *
     * Input: 7, 9, 7
     * Output: 9
     */
    public int findSingleNumber(int[] arr) {
        // 7, 9, 7
        // 7 ^ 7 ^ 9 = 0 ^ 9 = 9
        int res = 0;
        for (int n : arr) {
            res ^= n;
        }
        return res;
    }
}
