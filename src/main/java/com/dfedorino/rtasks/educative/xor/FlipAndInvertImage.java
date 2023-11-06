package com.dfedorino.rtasks.educative.xor;

public class FlipAndInvertImage {

    /**
     * Given a binary matrix representing an image, we want to flip the image horizontally, then invert it.
     *
     * To flip an image horizontally means that each row of the image is reversed.
     * For example, flipping [0, 1, 1] horizontally results in [1, 1, 0].
     *
     * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
     * For example, inverting [1, 1, 0] results in [0, 0, 1].
     *
     * Example 1:
     *
     * Input: [
     *   [1,0,1],
     *   [1,1,1],
     *   [0,1,1]
     * ]
     * Output: [
     *   [0,1,0],
     *   [0,0,0],
     *   [0,0,1]
     * ]
     * Explanation: First reverse each row: [[1,0,1],[1,1,1],[1,1,0]]. Then, invert the image: [[0,1,0],[0,0,0],[0,0,1]]
     *
     * Example 2:
     *
     * Input: [
     *   [1,1,0,0],
     *   [1,0,0,1],
     *   [0,1,1,1],
     *   [1,0,1,0]
     * ]
     * Output: [
     *   [1,1,0,0],
     *   [0,1,1,0],
     *   [0,0,0,1],
     *   [1,0,1,0]
     * ]
     */
    public static int[][] flipAndInvertImageWithXor(int[][] image) {
        int rowLength = image[0].length;
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < (rowLength + 1) / 2; j++) {
                // swap the jth and 'rowLength - j - 1'th values with their inverted values
                int temp = image[i][j] ^ 1; // 0 ^ 1 -> 1; 1 ^ 1 -> 0
                image[i][j] = image[i][rowLength - j - 1] ^ 1;
                image[i][rowLength - j - 1] = temp;
            }
        }
        return image;
    }

    public static int[][] flipAndInvertImageNoXor(int[][] image) {
        int[][] res = new int[image[0].length][image.length];
        for (int i = 0; i < image.length; i++) {
            int rowLength = image[i].length;
            for (int j = 0; j < rowLength; j++) {
                res[i][rowLength - j - 1] = image[i][j] == 1 ? 0 : 1;
            }
        }
        return res;
    }
}
