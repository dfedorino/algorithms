package com.dfedorino.rtasks.third_level.graphs;

import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class KruskalsAlgorithmTest {
    private final KruskalsAlgorithm app = new KruskalsAlgorithm();

    @Test
    public void testBuildSpanningTree_whenConnectedUndirectedGraph_thenMinimumSpanningTree() {
        List<Edge> edges = List.of(
                new Edge(-1, -1, -1),

                new Edge(1, 2, 7),
                new Edge(1, 4, 5),

                new Edge(2, 1, 7),
                new Edge(2, 4, 9),
                new Edge(2, 5, 7),
                new Edge(2, 3, 8),

                new Edge(3, 2, 8),
                new Edge(3, 5, 5),

                new Edge(4, 1, 5),
                new Edge(4, 2, 9),
                new Edge(4, 5, 15),
                new Edge(4, 6, 6),

                new Edge(5, 7, 9),
                new Edge(5, 6, 8),
                new Edge(5, 4, 15),
                new Edge(5, 2, 7),
                new Edge(5, 3, 5),

                new Edge(6, 4, 6),
                new Edge(6, 5, 8),
                new Edge(6, 7, 11),

                new Edge(7, 6, 11),
                new Edge(7, 5, 9)
        );

        List<Edge> actualSpanningTree = app.buildSpanningTree(edges);
        List<Edge> expectedSpanningTree = List.of(
                new Edge(-1, -1, -1),

                new Edge(1, 2, 7),
                new Edge(1, 4, 5),

                new Edge(2, 1, 7),
                new Edge(2, 5, 7),

                new Edge(3, 5, 5),

                new Edge(4, 1, 5),
                new Edge(4, 6, 6),

                new Edge(5, 7, 9),
                new Edge(5, 2, 7),
                new Edge(5, 3, 5),

                new Edge(6, 4, 6),

                new Edge(7, 5, 9)
        );
        assertThat(actualSpanningTree).isEqualTo(expectedSpanningTree);
    }
}