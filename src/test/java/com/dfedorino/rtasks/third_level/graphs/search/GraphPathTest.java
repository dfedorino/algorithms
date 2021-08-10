package com.dfedorino.rtasks.third_level.graphs.search;

import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class GraphPathTest {
    private final GraphPath app = new GraphPath();

    @Test
    public void testGetShortestPath_whenUnorderedGraph_thenShortestRouteBetweenStartAndFinish() {
        int[][] matrix = {
                {0, 1, 0, 0, 1},
                {1, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0}
        };
        /*
            1 -> 2, 5
            2 -> 1, 3
            3 -> 2
            4 ->
            5 -> 1
         */
        int start = 3;
        int finish = 5;
        Route expectedRoute = new Route(List.of(3, 2, 1, 5));
        assertThat(app.getShortestPath(matrix, start, finish)).isEqualTo(expectedRoute);
    }
}