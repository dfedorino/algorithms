package com.dfedorino.rtasks.educative.binarysearch;
public class MinimumDifferenceElement {
    /**
     * Given an array of numbers sorted in ascending order,
     * find the element in the array that has the minimum
     * difference with the given ‘key’.
     * <p>
     * Example 1:
     * <p>
     * Input: [4, 6, 10], key = 7
     * Output: 6
     * Explanation: The difference between the key '7' and '6' is minimum than any other number in the array
     * Example 2:
     * <p>
     * Input: [4, 6, 10], key = 4
     * Output: 4
     * Example 3:
     * <p>
     * Input: [1, 3, 8, 10, 15], key = 12
     * Output: 10
     * Example 4:
     * <p>
     * Input: [4, 6, 10], key = 17
     * Output: 10
     */
    public int search(int[] arr, int key) {
        // min difference when arr[mid] == key or
        // middle <= key && right >= key or if key is beyond the array
        // return arr[0] or arr[arr.length - 1] if reached
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;

            if (arr[mid] > key) {
                if (mid - 1 > -1 && arr[mid - 1] <= key) {
                    return arr[mid - 1] - key < arr[mid] - key ? arr[mid - 1] : arr[mid];
                }
                end = mid - 1;
            } else if (arr[mid] < key) {
                if (mid + 1 < arr.length && arr[mid + 1] >= key) {
                    return arr[mid] - key < arr[mid + 1] - key ? arr[mid] : arr[mid + 1];
                }
                start = mid + 1;
            } else {
                return arr[mid];
            }
        }
        return arr[mid];
    }
}
