package com.dfedorino.rtasks.educative.binarysearch;

public class OrderAgnosticBinarySearch {
    /**
     * Given an array of numbers sorted in an ascending order, find the ceiling of a given number ‘key’.
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
     * Input: [4, 6, 10], key = 17
     * Output: -1
     * Explanation: There is no number greater than or equal to '17' in the given array.
     *
     * Example 4:
     * Input: [4, 6, 10], key = -1
     * Output: 0
     * Explanation: The smallest number greater than or equal to '-1' is '4' having index '0'.
     */
    public int search(int[] arr, int key) {
        if (arr.length == 1) return arr[0] == key ? 0 : -1;
        boolean isIncreasing = arr[0] < arr[1];
        int startInclusive = 0;
        int endInclusive = arr.length - 1;
        while (startInclusive <= endInclusive) {
            int middle = startInclusive + (endInclusive - startInclusive) / 2;
            if (key == arr[middle]) return middle;

            if (isIncreasing) {
                if (key < arr[middle]) {
                    endInclusive = middle - 1;
                } else {
                    startInclusive = middle + 1;
                }
            } else {
                if (key > arr[middle]) {
                    endInclusive = middle - 1;
                } else {
                    startInclusive = middle + 1;
                }
            }
        }
        return -1;
    }
}
