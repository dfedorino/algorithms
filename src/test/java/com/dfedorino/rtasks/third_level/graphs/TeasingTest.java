package com.dfedorino.rtasks.third_level.graphs;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TeasingTest {
    private final Teasing app = new Teasing();

    @Test
    public void testComputeOptimalPath_whenOddAdjacencyMatrix_thenThreeVertexes() {
        int[][] matrix = {
                {0, 1, 9, 9, 2},
                {1, 0, 9, 9, 9},
                {9, 9, 0, 9, 9},
                {9, 9, 9, 0, 9},
                {2, 9, 9, 9, 0}
        };
        Teasing.Path expectedRoute = new Teasing.Path(1, 2, 5);
        assertThat(app.computeOptimalPath(matrix)).isEqualTo(expectedRoute);
    }

    @Test
    public void testComputeOptimalPath_whenEvenLengthAdjacencyMatrix_thenThreeVertexes() {
        int[][] matrix = {
                {0, 1, 9, 9, 9, 2},
                {1, 0, 9, 9, 9, 9},
                {9, 9, 0, 9, 9, 9},
                {9, 9, 9, 0, 9, 9},
                {9, 9, 9, 9, 0, 9},
                {2, 9, 9, 9, 9, 0},
        };
        Teasing.Path expectedRoute = new Teasing.Path(1, 2, 6);
        assertThat(app.computeOptimalPath(matrix)).isEqualTo(expectedRoute);
    }
}