package com.dfedorino.rtasks.educative.binarysearch;

public class NumberRange {
    /**
     * Given an array of numbers sorted in ascending order, find the range of a given number ‘key’.
     * The range of the ‘key’ will be the first and last position of the ‘key’ in the array.
     * Write a function to return the range of the ‘key’. If the ‘key’ is not present return [-1, -1].
     *
     * Example 1:
     * Input: [4, 6, 6, 6, 9], key = 6
     * Output: [1, 3]
     *
     * Example 2:
     * Input: [1, 3, 8, 10, 15], key = 10
     * Output: [3, 3]
     *
     * Example 3:
     * Input: [1, 3, 8, 10, 15], key = 12
     * Output: [-1, -1]
     */
    public int[] findRange(int[] arr, int key) {
        return new int[] {findFirst(arr, key), findLast(arr, key)};
    }

    private int findFirst(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < key) {
                start = mid + 1;
            } else if (arr[mid] >= key) {
                end = mid - 1;
            }
        }
        return arr[start] == key ? start : -1;
    }

    private int findLast(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] <= key) {
                start = mid + 1;
            } else if (arr[mid] > key) {
                end = mid - 1;
            }
        }
        return arr[end] == key ? end : -1;
    }
}
