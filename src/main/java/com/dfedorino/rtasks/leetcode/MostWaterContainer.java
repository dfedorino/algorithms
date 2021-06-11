package com.dfedorino.rtasks.leetcode;

public class MostWaterContainer {
    public int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int maxContainer = 0;
        while (leftIndex < rightIndex) {
            maxContainer = Math.max(maxContainer, Math.min(height[leftIndex], height[rightIndex]) * (rightIndex - leftIndex));
            if (height[leftIndex] < height[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        return maxContainer;
    }
}
