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
}