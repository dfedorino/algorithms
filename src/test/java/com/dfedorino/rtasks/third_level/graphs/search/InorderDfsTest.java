package com.dfedorino.rtasks.third_level.graphs.search;

import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InorderDfsTest {
    private final Search preorderDfs = new InorderDfs();

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
        assertThat(preorderDfs.getTraversedVertexes(binaryTree)).isEqualTo(List.of(4, 2, 5, 1, 6, 3, 7));
    }
}