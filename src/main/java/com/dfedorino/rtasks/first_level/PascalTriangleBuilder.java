package com.dfedorino.rtasks.first_level;

public class PascalTriangleBuilder {
    public int[][] build(int width, int height) {
        int[][] pascalTriangle = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int value;
                boolean isInFirstRowOrFirstColumn = i == 0 || j == 0;
                if (isInFirstRowOrFirstColumn) {
                    value = 1;
                } else {
                    int left = pascalTriangle[i][j - 1];
                    int above = pascalTriangle[i - 1][j];
                    value = left + above;
                }
                pascalTriangle[i][j] = value;
            }
        }
        return pascalTriangle;
    }
}
