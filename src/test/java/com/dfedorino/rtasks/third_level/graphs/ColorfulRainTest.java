package com.dfedorino.rtasks.third_level.graphs;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ColorfulRainTest {
    private final ColorfulRain app = new ColorfulRain();

    @Test
    public void testCountBadBridges_whenGivenAdjacencyMatrix_thenNumberOfBadBridges() {
        int[][] hills = {
                {0, 1, 0, 0, 0, 1, 1},
                {1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 1, 0},
                {1, 0, 1, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0}
        };
        int[] hillsColors = {1, 1, 1, 1, 1, 3, 3};
        assertThat(app.countBadBridges(hills, hillsColors)).isEqualTo(4);
    }
}