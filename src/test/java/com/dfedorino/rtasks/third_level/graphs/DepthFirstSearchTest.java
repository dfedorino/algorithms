package com.dfedorino.rtasks.third_level.graphs;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DepthFirstSearchTest {
    private final Search app = new DepthFirstSearch();

    @Test
    public void testGetTraversedVertexes_whenNonTransitiveUndirectedGraph_thenDepthFirstSearch() {
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

    @Test
    public void testGetTraversedVertexes_whenTransitiveUndirectedGraph_thenDepthFirstSearch() {
        List<List<Integer>> adjacencyList = List.of(
                List.of(2, 3, 4, 5),
                List.of(1, 3, 4, 5),
                List.of(1, 2, 4, 5),
                List.of(1, 2, 3, 5),
                List.of(1, 2, 3, 4)
        );
        // 1 -> 2, 3, 4, 5
        // 2 -> 1, 3, 4, 5
        // 3 -> 1, 2, 4, 5
        // 4 -> 1, 2, 3, 4
        assertThat(app.getTraversedVertexes(adjacencyList)).isEqualTo(List.of(1, 2, 3, 4, 5));
    }
}