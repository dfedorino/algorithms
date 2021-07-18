package com.dfedorino.rtasks.third_level.graphs;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TrafficLightsTest {
    private final TrafficLights app = new TrafficLights();

    @Test
    public void testCountTrafficLights_whenVertexes_thenCountEdges() {
        int tunnels = 7;
        int[][] tunnelPairs = {
                {5, 1},
                {3, 2},
                {7, 1},
                {5, 2},
                {7, 4},
                {6, 5},
                {6, 4},
                {7, 5},
                {2, 1},
                {5, 3}
        };
        assertThat(app.countTrafficLights(tunnels, tunnelPairs)).isEqualTo(new int[] {3, 3, 2, 2, 5, 2, 3});
    }
}