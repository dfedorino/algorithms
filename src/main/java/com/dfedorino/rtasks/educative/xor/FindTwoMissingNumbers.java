package com.dfedorino.rtasks.educative.xor;

public class FindTwoMissingNumbers {

    /**
     * Given an array of n − 2 integers in the range from 1 to n,
     * find the two numbers that are missing from the array.
     *
     * Input: 1, 5, 2, 4, 7
     * Answer: 3, 6
     */
    public static int[] find(int[] arr) {
        // 1. find xor of X and Y via XORing numbers from 1 to n and the actual numbers in the array
        int xor = 0;
        for (int i = 1; i <= arr.length + 2; i++) {
            xor ^= i;
        }
        for (int n : arr) {
            xor ^= n;
        }
        // 2. partition the numbers from 1 to n and the actual numbers based on the flipped bit
        int bit = 1;
        while((xor & bit) == 0) {
            bit <<= 1;
        }
        int n1 = 0, n2 = 0;
        for (int i = 1; i <= arr.length + 2; i++) {
            if ((i & bit) == 0) {
                n1 ^= i;
            } else {
                n2 ^= i;
            }
        }
        for (int n : arr) {
            if ((n & bit) == 0) {
                n1 ^= n;
            } else {
                n2 ^= n;
            }
        }
        return new int[] {n1, n2};
    }
}
