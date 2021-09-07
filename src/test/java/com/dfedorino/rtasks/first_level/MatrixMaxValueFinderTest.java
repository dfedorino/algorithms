package com.dfedorino.rtasks.first_level;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MatrixMaxValueFinderTest {
    private MatrixMaxValueFinder app = new MatrixMaxValueFinder();

    @Test
    public void testFindMaxValueAndIndexes_MatrixWithOneMax_ValueAndIndex() {
        int[] expected = {4, 1, 2};
        int[] actual = app.findMaxValueAndIndexes(new int[][]{
                {3, 1, 2},
                {1, 3, 4},
                {3, 3, 3}
        });
        assertEquals(expected, actual);
    }

    @Test
    public void testFindMaxValueAndIndexes_MatrixWithTwoMaxInOneRow_ValueAndIndex() {
        int[] expected = {4, 1, 1};
        int[] actual = app.findMaxValueAndIndexes(new int[][]{
                {3, 1, 2},
                {1, 4, 4},
                {3, 3, 3}
        });
        assertEquals(expected, actual);
    }

    @Test
    public void testFindMaxValueAndIndexes_MatrixWithOneMaxInTwoRows_ValueAndIndex() {
        int[] expected = {4, 1, 2};
        int[] actual = app.findMaxValueAndIndexes(new int[][]{
                {3, 1, 2},
                {1, 3, 4},
                {3, 3, 4}
        });
        assertEquals(expected, actual);
    }
}