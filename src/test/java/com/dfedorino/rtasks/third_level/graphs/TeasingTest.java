package com.dfedorino.rtasks.third_level.graphs;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TeasingTest {
    private final Teasing app = new Teasing();

    @Test
    public void testComputeShortestPath_whenOddAdjacencyMatrix_thenThreeVertexes() {
        int[][] matrix = {
                {0, 1, 9, 9, 2},
                {1, 0, 9, 9, 9},
                {9, 9, 0, 9, 9},
                {9, 9, 9, 0, 9},
                {2, 9, 9, 9, 0}
        };
        Teasing.Path expectedPath = new Teasing.Path(1, 2, 5);
        assertThat(app.computeShortestPath(matrix)).isEqualTo(expectedPath);
    }

    @Test
    public void testComputeShortestPath_whenEvenLengthAdjacencyMatrix_thenThreeVertexes() {
        int[][] matrix = {
                {0, 1, 9, 9, 9, 2},
                {1, 0, 9, 9, 9, 9},
                {9, 9, 0, 9, 9, 9},
                {9, 9, 9, 0, 9, 9},
                {9, 9, 9, 9, 0, 9},
                {2, 9, 9, 9, 9, 0},
        };
        Teasing.Path expectedPath = new Teasing.Path(1, 2, 6);
        assertThat(app.computeShortestPath(matrix)).isEqualTo(expectedPath);
    }
}