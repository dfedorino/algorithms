package com.dfedorino.rtasks.educative.binarysearch;

public class SearchSortedInfiniteArray {
    public static class ArrayReader {
        private final int[] arr;

        public ArrayReader(int[] arr) {
            this.arr = arr;
        }

        public int get(int index) {
            if (index >= arr.length) {
                return Integer.MAX_VALUE;
            }
            return arr[index];
        }
    }

    /**
     * Given an infinite sorted array (or an array with unknown size),
     * find if a given number ‘key’ is present in the array.
     * Write a function to return the index of the ‘key’ if it is present in the array, otherwise return -1.
     *
     * Since it is not possible to define an array with infinite (unknown) size,
     * you will be provided with an interface ArrayReader to read elements of the array.
     * ArrayReader.get(index) will return the number at index; if the array’s size is smaller than the index,
     * it will return Integer.MAX_VALUE.
     *
     * Example 1:
     * Input: [4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30], key = 16
     * Output: 6
     * Explanation: The key is present at index '6' in the array.
     *
     * Example 2:
     * Input: [4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30], key = 11
     * Output: -1
     * Explanation: The key is not present in the array.
     *
     * Example 3:
     * Input: [1, 3, 8, 10, 15], key = 15
     * Output: 4
     * Explanation: The key is present at index '4' in the array.
     *
     * Example 4:
     * Input: [1, 3, 8, 10, 15], key = 200
     * Output: -1
     * Explanation: The key is not present in the array.
     */
    public int search(ArrayReader arr, int key) {
        int start = 0;
        int end = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr.get(mid) < key) {
                start = mid + 1;
            } else if (arr.get(mid) > key) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int searchWithProperBounds(ArrayReader arr, int key) {
        int start = 0;
        int end = 1;

        while (arr.get(end) < key) {
            int newStart = end + 1;
            // start = 0, end = 1
            // start = 2, end = 5
            // start = 6, end = 13
            end += (end - start + 1) * 2;
            start = newStart;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr.get(mid) < key) {
                start = mid + 1;
            } else if (arr.get(mid) > key) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
