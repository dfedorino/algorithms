package com.dfedorino.rtasks.third_level.graphs;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TeasingTest {
    private final Teasing app = new Teasing();
    @Test
    public void testComputeOptimalRoute_whenAdjacencyMatrix_thenThreeVertexes() {
        int[][] matrix = {
                {0, 1, 9, 9, 2},
                {1, 0, 9, 9, 9},
                {9, 9, 0, 9, 9},
                {9, 9, 9, 0, 9},
                {2, 9, 9, 9, 0}
        };
        Teasing.OptimalRoute expectedRoute = new Teasing.OptimalRoute(1, 2, 5);
        assertThat(app.computeOptimalRoute(matrix)).isEqualTo(expectedRoute);
    }
}