package com.dfedorino.rtasks.third_level.graphs;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DepthFirstSearchTest {
    private final Search app = new DepthFirstSearch();

    @Test
    public void testGetTraversedVertexes_whenNonTransitiveUndirectedGraph_thenAllAdjacentFirstThenTheirAdjacent() {
        List<List<Integer>> adjacencyList = List.of(
                List.of(2, 5, 9),
                List.of(3, 4),
                Collections.emptyList(),
                Collections.emptyList(),
                List.of(6, 7, 8),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList(),
                List.of(10),
                Collections.emptyList()
        );
        // 1 -> 2, 5, 9
        // 2 -> 3, 4
        // 5 -> 6, 7, 8
        // 9 -> 10
        assertThat(app.getTraversedVertexes(adjacencyList)).isEqualTo(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }
}