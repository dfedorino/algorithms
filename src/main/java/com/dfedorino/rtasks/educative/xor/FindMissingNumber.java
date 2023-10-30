package com.dfedorino.rtasks.educative.xor;

public class FindMissingNumber {
    /**
     * Given an array of n − 1 integers in the range from 1 to n,
     * find the one number that is missing from the array.
     *
     * Input: 1, 5, 2, 6, 4
     * Answer: 3
     */
    public int findViaXor(int[] arr) {
        // x ^ x = 0
        // x ^ 0 = x
        // x ^ y = y ^ x
        // a ^ (b ^ c) = (a ^ b) ^ c
        // example:
        // [1, 2, 4] -> 1, 2, 3, 4 && 1, 2, 4
        // we're doing the following:
        // 1 ^ 1 ^ 2 ^ 2 ^ 3 ^ 4 ^ 4
        // since XOR is associative (a ^ (b ^ c) = (a ^ b) ^ c):
        // (1 ^ 1) ^ (2 ^ 2) ^ 3 ^ (4 ^ 4)
        // since x ^ x = 0:
        // 0 ^ 0 ^ 3 ^ 0
        // since x ^ 0 = x
        // 0 ^ 0 ^ 0 ^ 3 = 0 ^ 3 = 3
        // since XOR is commutative (x ^ y = y ^ x)
        // 1 ^ 1 ^ 2 ^ 2 = 1 ^ 2 ^ 1 ^ 2
        // which means that we can XOR all the numbers from 1 to n first
        // then XOR all the actual numbers in the array
        // then XOR the results:

        int x1 = 0;
        // XOR all numbers from 1 to n + 1,
        // because if 1 number is missing, the max value will be n + 1
        for (int i = 1; i <= arr.length + 1; i++) {
            x1 ^= i;
        }
        // XOR all the actual numbers with the result, eliminating all the duplicates
        int x2 = 0;
        for (int n : arr) {
            x2 ^= n;
        }
        return x1 ^ x2;
    }

    /**
     * n * (n + 1) / 2
     */
    public int findViaSum(int[] arr) {
        // number sum in range 1 to n
        int s1 = 0;
        for (int i = 1; i < arr.length + 1; i++) {
            s1 += i;
        }

        // actual number sum
        int s2 = 0;
        for (int n : arr) {
            s2 += n;
        }

        // difference is the answer
        return s2 - s1;
    }
}
