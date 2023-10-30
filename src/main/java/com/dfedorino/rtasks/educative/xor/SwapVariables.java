package com.dfedorino.rtasks.educative.xor;

public class SwapVariables {
    /**
     * Swap 2 variables without using a 3rd variable
     * [1, 2] -> [2, 1]
     */
    public void swap(int[] arr) {
        // x ^ (x ^ y) = y
        // y ^ (x ^ y) = x
        arr[0] ^= arr[1]; // (x ^ y)
        arr[1] ^= arr[0]; // y ^ (x ^ y) = 0 ^ x = x = arr[0]
        arr[0] ^= arr[1]; // x ^ (x ^ y) = 0 ^ y = y = arr[1]
    }
}
