package com.dfedorino.rtasks.first_level;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertTrue;

public class PascalTriangleBuilderTest {
    PascalTriangleBuilder pascalTriangleBuilder = new PascalTriangleBuilder();
    @Test
    public void testBuild_WidthThreeHeightThree_TwoDimensionalArray() {
        int[][] expected = {
                {1, 1, 1},
                {1, 2, 3},
                {1, 3, 6}
        };
        int[][] actual = pascalTriangleBuilder.build(3, 3);
        assertTrue(Arrays.deepEquals(expected, actual));
    }

}