package com.dfedorino.rtasks.educative.binarysearch;

public class CeilingOfANumber {
    /**
     * Given an array of numbers sorted in ascending order, find the ceiling of a given number ‘key’.
     * The ceiling of the ‘key’ will be the smallest element in the given array greater than or equal to the ‘key’.
     * Write a function to return the index of the ceiling of the ‘key’. If there isn’t any ceiling return -1.
     *
     * Example 1:
     * Input: [4, 6, 10], key = 6
     * Output: 1
     * Explanation: The smallest number greater than or equal to '6' is '6' having index '1'.
     *
     * Example 2:
     * Input: [1, 3, 8, 10, 15], key = 12
     * Output: 4
     * Explanation: The smallest number greater than or equal to '12' is '15' having index '4'.
     *
     * Example 3:
     * Input: [1, 3, 8, 10, 15], key = 12
     * Output: 4
     * Explanation: The smallest number greater than or equal to '12' is '15' having index '4'.
     *
     * Example 4:
     * Input: [4, 6, 10], key = -1
     * Output: 0
     * Explanation: The smallest number greater than or equal to '-1' is '4' having index '0'.
     */
    public int searchCeilingOfANumber(int[] arr, int key) {
        int startInclusive = 0;
        int endInclusive = arr.length - 1;

        while (startInclusive <= endInclusive) {
            int mid = startInclusive + (endInclusive - startInclusive) / 2;
            if (arr[mid] > key) {
                endInclusive = mid - 1;
            } else if (arr[mid] < key) {
                startInclusive = mid + 1;
            } else {
                return mid;
            }
        }

        return startInclusive >= arr.length ? -1 : startInclusive;
    }
}
