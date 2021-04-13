package com.dfedorino.rtasks.first_level;

public class MatrixChecker {
    /**
     * Проверьте, является ли двумерный массив симметричным относительно главной диагонали.
     * Главная диагональ — та, которая идёт из левого верхнего угла двумерного массива в правый нижний.
     *
     * Симметричная матрица, где диагональ - числа 0, 5, 4:
     * 0 1 2
     * 1 5 3
     * 2 3 4
     *
     * Несимметричная матрица:
     * 0 0 0
     * 0 0 0
     * 1 0 0
     *
     * @param matrix - проверяемая матрица
     * @return true, если матрица симметрична по заданным условиям, false в противном случае
     */
    public boolean isSymmetric(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
