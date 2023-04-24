package com.dfedorino.rtasks.third_level.graphs;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TransitivityTest {
    private final Transitivity app = new Transitivity();

    @Test
    public void testIsTransitiveGraph_whenFourComponentsThenTrue() {
        int vertexes = 5;
        int[][] pairs = {
                {2, 5}
        };
        assertThat(app.isTransitive(vertexes, pairs)).isTrue();
    }

    @Test
    public void testIsTransitiveGraph_whenAllVertexesAreConnectedThenTrue() {
        int vertexes = 5;
        int[][] pairs = {
                {1, 2},
                {1, 3},
                {1, 4},
                {1, 5},
                {2, 3},
                {2, 4},
                {2, 5},
                {3, 4},
                {3, 5},
                {4, 5}
        };
        assertThat(app.isTransitive(vertexes, pairs)).isTrue();
    }

    @Test
    public void testIsTransitiveGraph_whenAtLeastOnePairNotConnectedThenFalse() {
        int vertexes = 5;
        int[][] pairs = {
                {1, 2},
                {1, 3},
                {1, 4},
                {1, 5},
                {2, 3},
                {2, 4},
                {2, 5},
                {3, 4},
                {3, 5}
        };
        assertThat(app.isTransitive(vertexes, pairs)).isFalse();
    }

    @Test
    public void testIsTransitiveGraph_whenGraphLikeRectangleThenFalse() {
        int vertexes = 4;
        int[][] pairs = {
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 1}
        };
        assertThat(app.isTransitive(vertexes, pairs)).isFalse();
    }
}