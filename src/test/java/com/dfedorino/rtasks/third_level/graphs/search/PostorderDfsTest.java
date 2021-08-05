package com.dfedorino.rtasks.third_level.graphs.search;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PostorderDfsTest {
    private final Search postorderDfs = new PostorderDfs();

    @Test
    public void testGetTraversedVertexes_whenBinaryTree_thenPostorderTraversal() {
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
        assertThat(postorderDfs.getTraversedVertexes(binaryTree)).isEqualTo(List.of(4, 5, 2, 6, 7, 3, 1));
    }

    @Test
    public void testGetTraversedVertexes_whenUndirectedConnectedGraph_thenPostorderTraversal() {
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
        assertThat(postorderDfs.getTraversedVertexes(undirectedConnectedGraph))
                .isEqualTo(List.of(5, 6, 2, 7, 3, 8, 9, 10, 4, 1));
    }

    @Test
    public void testGetTraversedVertexes_whenUndirectedDisconnectedGraph_thenPostorderTraversal() {
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
        assertThat(postorderDfs.getTraversedVertexes(undirectedConnectedGraph))
                .isEqualTo(List.of(5, 6, 2, 7, 3, 1, 8, 9, 10, 4));
    }
}