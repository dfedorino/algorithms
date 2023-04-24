package com.dfedorino.rtasks.third_level.graphs;

import org.testng.annotations.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SourcesAndSinksTest {
    private final SourcesAndSinks app = new SourcesAndSinks();

    @Test
    public void testCountSourcesAndSinks_whenAdjacencyMatrix_thenSourcesAndSinks() {
        int[][] adjacencyMatrix = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        Pair<Set<Integer>, Set<Integer>> expectedSourcesAndSinks = new Pair<>(
                Set.of(3, 4),
                Set.of(1, 4, 5)
        );
        assertThat(app.countSourcesAndSinks(adjacencyMatrix)).isEqualTo(expectedSourcesAndSinks);
    }
}