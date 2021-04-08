package com.dfedorino.rtasks.first_level;

public class PascalTriangleBuilder {
    /**
     * Даны два числа n и m. Создайте двумерный массив [n][m] и заполните его по следующим правилам:
     *  1. Числа, стоящие в строке 0 или в столбце 0 равны 1 (A[0][j]=1, A[i][0]=1);
     *  2. Для всех остальных элементов массива A[i][j]=A[i-1][j]+A[i][j-1],
     *     то есть каждый элемент равен сумме двух элементов, стоящих слева и сверху от него:
     *     1 1 1               1
     *     1 2 3    ->      1  2  1
     *     1 3 6          1  3  3  1
     *                  1  4  6  4  1
     *
     * @param width - ширина матрицы, содержащей часть треугольника
     * @param height - длина матрицы, содержащей часть треугольника
     * @return матрицу, представляющую треугольник Паскаля
     */
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
