package com.dfedorino.rtasks.third_level.graphs;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BreadthFirstSearchTest {
    private final Search app = new BreadthFirstSearch();

    @Test
    public void testGetTraversedVertexes_whenNonTransitiveUndirectedGraph_thenAllAdjacentFirstThenTheirAdjacent() {
        List<List<Integer>> adjacencyList = List.of(
                List.of(2, 3, 4),
                List.of(5, 6),
                List.of(7, 8, 9),
                List.of(10),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList()
        );
        // 1 -> 2, 3, 4
        // 2 -> 5, 6
        // 3 -> 7, 8, 9
        // 4 -> 10
        assertThat(app.getTraversedVertexes(adjacencyList)).isEqualTo(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    @Test
    public void testGetTraversedVertexes_whenTransitiveUndirectedGraph_thenAllAdjacentFirstThenTheirAdjacent() {
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

    @Test
    public void testGetTraversedVertexes_whenTransitiveUndirectedGraphWithSeveralComponents_thenAllAdjacentFirstThenTheirAdjacent() {
        List<List<Integer>> adjacencyList = List.of(
                List.of(2, 3),
                List.of(1, 3),
                List.of(1, 2),
                List.of(5),
                List.of(4),
                Collections.emptyList()
        );
        // 1 -> 2, 3
        // 2 -> 1, 3
        // 3 -> 1, 2
        // 4 -> 5
        // 5 -> 4
        // 6
        assertThat(app.getTraversedVertexes(adjacencyList)).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void testGetTraversedVertexes_whenDirectedGraphWithSeveralComponents_thenAllAdjacentFirstThenTheirAdjacent() {
        List<List<Integer>> adjacencyList = List.of(
                List.of(2),
                List.of(3),
                List.of(1),
                List.of(5),
                Collections.emptyList(),
                Collections.emptyList()
        );
        // 1 -> 2
        // 2 -> 3
        // 3 -> 1
        // 4 -> 5
        // 5 -> 4
        // 6
        assertThat(app.getTraversedVertexes(adjacencyList)).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}