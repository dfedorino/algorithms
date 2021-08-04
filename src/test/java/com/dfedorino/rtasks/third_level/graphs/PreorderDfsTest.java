package com.dfedorino.rtasks.third_level.graphs;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PreorderDfsTest {
    private final Search preorderDfs = new PreorderDfs();

    @Test
    public void testGetTraversedVertexes_whenBinaryTree_thenPreorderTraversal() {
        List<List<Integer>> binaryTree = List.of(
                Collections.emptyList(), // index starts from 1
                List.of(2, 3),
                List.of(4, 5),
                List.of(6, 7),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList()
        );
        assertThat(preorderDfs.getTraversedVertexes(binaryTree)).isEqualTo(List.of(1, 2, 4, 5, 3, 6, 7));
    }

    @Test
    public void testGetTraversedVertexes_whenUndirectedConnectedGraph_thenPreorderTraversal() {
        List<List<Integer>> undirectedConnectedGraph = List.of(
                Collections.emptyList(), // index starts from 1
                List.of(2, 3, 4),
                List.of(5, 6),
                List.of(7),
                List.of(8, 9, 10),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList()
        );
        assertThat(preorderDfs.getTraversedVertexes(undirectedConnectedGraph))
                .isEqualTo(List.of(1, 2, 5, 6, 3, 7, 4, 8, 9, 10));
    }

    @Test
    public void testGetTraversedVertexes_whenUndirectedDisconnectedGraph_thenPreorderTraversal() {
        List<List<Integer>> undirectedConnectedGraph = List.of(
                Collections.emptyList(), // index starts from 1
                List.of(2, 3),
                List.of(5, 6),
                List.of(7),
                List.of(8, 9, 10),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList()
        );
        assertThat(preorderDfs.getTraversedVertexes(undirectedConnectedGraph))
                .isEqualTo(List.of(1, 2, 5, 6, 3, 7, 4, 8, 9, 10));
    }
}