package com.dfedorino.rtasks.educative.xor;

public class TwoSingleNumbers {
    /**
     * In a non-empty array of numbers,
     * every number appears exactly twice except two numbers that appear only once.
     * Find the two numbers that appear only once.
     *
     * Example 1:
     * Input: [1, 4, 2, 1, 3, 5, 6, 2, 3, 5]
     * Output: [4, 6]
     *
     * Example 2:
     * Input: [2, 1, 3, 2]
     * Output: [1, 3]
     */
    public static int[] findSingleNumbers(int[] arr) {
        // 1. Find XOR of all the numbers
        int xor = 0;
        for (int n : arr) {
            xor ^= n;
        }
        // 2. Now we have XOR of 2 single numbers, because the rest of the numbers
        //    eliminated each other. Get the rightmost bit that is set to 1
        //    meaning that this bit is different in the 2 single numbers.
        int bit = 1;
        // Here we compare the XOR with the mask in order to find the rightmost bit, i.e.:
        // XOR = 10100
        // bit = 1
        // When comparing the above values, we get:
        // 10100
        // 00001
        // -----
        // 00000
        // because the & operator returns 1 only when two bits are '1'
        // we will continue iterating until we get the following comparison:
        // 10100
        // 00100
        // -----
        // 00100
        while ((xor & bit) == 0) {
            bit <<= 1;
        }

        // 3. At this point the 'bit' variable has the rightmost bit of the XOR value.
        //    We can partition the input array values into 2 groups by the value of this bit.
        //    This way we will get 2 single numbers in different partitions. We can store the
        //    results of the partitioning into variables. At the end, those variables will be
        //    the answer, because all the rest duplicate numbers will eliminate each other
        int n1 = 0, n2 = 0;
        for (int n : arr) {
            if ((n & bit) != 0) {
                // the bit in 'n' is set to 1
                n1 ^= n;
            } else {
                // the bit in 'n' is not set
                n2 ^= n;
            }
        }
        return new int[] {n1, n2};
    }
}
