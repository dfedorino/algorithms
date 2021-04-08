package com.dfedorino.rtasks.first_level;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MatrixCheckerTest {
    MatrixChecker checker = new MatrixChecker();
    @Test
    public void testIsSymmetric_SymmetricTwoDimensionalArray_True() {
        int[][] matrix = {
                {0, 1, 2},
                {1, 5, 3},
                {2, 3, 4},
        };
        assertTrue(checker.isSymmetric(matrix));
    }
    @Test
    public void testIsSymmetric_NonSymmetricTwoDimensionalArray_False() {
        int[][] matrix = {
                {0, 0, 0},
                {0, 0, 0},
                {1, 0, 0},
        };
        assertFalse(checker.isSymmetric(matrix));
    }
}