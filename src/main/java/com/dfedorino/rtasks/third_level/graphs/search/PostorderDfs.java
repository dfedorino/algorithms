package com.dfedorino.rtasks.third_level.graphs.search;

import java.util.ArrayList;
import java.util.List;

public class PostorderDfs implements Search {
    @Override
    public List<Integer> getTraversedVertexes(List<List<Integer>> adjacencyList) {
        boolean[] was = new boolean[adjacencyList.size()];
        List<Integer> visited = new ArrayList<>();
        for (int vertex = 1; vertex < was.length; vertex++) {
            if(!was[vertex]) {
                traverseVertex(vertex, was, adjacencyList, visited);
            }
        }
        return visited;
    }

    private void traverseVertex(int vertex, boolean[] was, List<List<Integer>> adjacencyList, List<Integer> visited) {
        was[vertex] = true;
        for (int adjacentVertex : adjacencyList.get(vertex)) {
            if (!was[adjacentVertex]) {
                traverseVertex(adjacentVertex, was, adjacencyList, visited);
            }
        }
        // process vertex AFTER (post) all its adjacent vertexes
        visited.add(vertex);
    }
}
