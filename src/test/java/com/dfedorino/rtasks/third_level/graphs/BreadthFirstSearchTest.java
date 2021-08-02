package com.dfedorino.rtasks.third_level.graphs;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BreadthFirstSearchTest {
    Search app = new BreadthFirstSearch();

    @Test
    public void testTraverse_whenGivenAdjacencyList_thenAllAdjacentFirstThenTheirAdjacent() {
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
        assertThat(app.traverse(adjacencyList)).isEqualTo(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    @Test
    public void testTraverse_whenTransitiveUnorderedGraph_thenNoDuplicatesAreAddedToQueue() {
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
        assertThat(app.traverse(adjacencyList)).isEqualTo(List.of(1, 2, 3, 4, 5));
    }
}