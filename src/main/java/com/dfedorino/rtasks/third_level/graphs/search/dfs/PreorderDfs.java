package com.dfedorino.rtasks.third_level.graphs.search.dfs;

import com.dfedorino.rtasks.third_level.graphs.search.Search;

import java.util.ArrayList;
import java.util.List;

public class PreorderDfs implements Search {
    @Override
    public List<Integer> getTraversedVertexes(List<List<Integer>> binaryTree) {
        List<Integer> visited = new ArrayList<>(binaryTree.size());
        int root = 1;
        traverse(root, binaryTree, visited);
        return visited;
    }

    private void traverse(int root, List<List<Integer>> binaryTree, List<Integer> visited) {
        List<Integer> children = binaryTree.get(root);
        visited.add(root);
        if (!children.isEmpty()) {
            int left = children.get(0);
            int right = children.get(1);
            traverse(left, binaryTree, visited);
            traverse(right, binaryTree, visited);
        }
    }
}
