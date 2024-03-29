package com.dfedorino.rtasks.third_level.graphs.search.dfs;

import com.dfedorino.rtasks.third_level.graphs.search.Search;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DepthFirstSearchTest {
    @Test(dataProvider = "implementations")
    public void testGetTraversedVertexes_whenNonTransitiveUndirectedGraph_thenDepthFirstSearch(Search app) {
        List<List<Integer>> adjacencyList = List.of(
                Collections.emptyList(),
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
        assertThat(app.getTraversedVertexes(adjacencyList)).containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    @Test(dataProvider = "implementations")
    public void testGetTraversedVertexes_whenTransitiveUndirectedGraph_thenDepthFirstSearch(Search app) {
        List<List<Integer>> adjacencyList = List.of(
                Collections.emptyList(),
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
        assertThat(app.getTraversedVertexes(adjacencyList)).containsExactlyInAnyOrder(1, 2, 3, 4, 5);
    }

    @Test(dataProvider = "implementations")
    public void testGetTraversedVertexes_whenTransitiveUndirectedGraphWithSeveralComponents_thenDepthFirstSearch(Search app) {
        List<List<Integer>> adjacencyList = List.of(
                Collections.emptyList(),
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
        assertThat(app.getTraversedVertexes(adjacencyList)).containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6);
    }

    @Test(dataProvider = "implementations")
    public void testGetTraversedVertexes_whenDirectedGraphWithSeveralComponents_thenDepthFirstSearch(Search app) {
        List<List<Integer>> adjacencyList = List.of(
                Collections.emptyList(),
                List.of(2, 3),
                Collections.emptyList(),
                Collections.emptyList(),
                List.of(5),
                Collections.emptyList(),
                Collections.emptyList()
        );
        // 1 -> 2, 3
        // 2 ->
        // 3 ->
        // 4 -> 5
        // 5 ->
        // 6
        assertThat(app.getTraversedVertexes(adjacencyList)).containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6);
    }

    @Test(dataProvider = "implementations")
    public void testGetTraversedVertexes_whenUndirectedBinaryTree_thenDepthFirstSearch(Search app) {
        List<List<Integer>> adjacencyList = List.of(
                Collections.emptyList(),
                List.of(2, 9),
                List.of(3, 6),
                List.of(4, 5),
                Collections.emptyList(),
                Collections.emptyList(),
                List.of(7, 8),
                Collections.emptyList(),
                Collections.emptyList(),
                List.of(10, 13),
                List.of(11, 12),
                Collections.emptyList(),
                Collections.emptyList(),
                List.of(14, 15),
                Collections.emptyList(),
                Collections.emptyList()
        );
        assertThat(app.getTraversedVertexes(adjacencyList))
                .containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
    }

    @DataProvider(name = "implementations")
    public Object[][] implementations() {
        return new Object[][] {
                {new DepthFirstSearch()},
                {new BaeldungDfs()}
        };
    }
}