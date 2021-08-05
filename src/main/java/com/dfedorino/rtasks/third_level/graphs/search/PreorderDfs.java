package com.dfedorino.rtasks.third_level.graphs.search;

import java.util.ArrayList;
import java.util.List;

public class PreorderDfs implements Search {
    @Override
    public List<Integer> getTraversedVertexes(List<List<Integer>> adjacencyList) {
        boolean[] was = new boolean[adjacencyList.size()];
        List<Integer> visited = new ArrayList<>(adjacencyList.size());
        for (int vertex = 1; vertex < adjacencyList.size(); vertex++) {
            if (!was[vertex]) {
                traverseVertex(vertex, was, adjacencyList, visited);
            }
        }
        return visited;
    }

    private void traverseVertex(int vertex, boolean[] was, List<List<Integer>> adjacencyList, List<Integer> visited) {
        was[vertex] = true;
        // process vertex BEFORE (pre) all its adjacent vertexes
        visited.add(vertex);
        for (int adjacentVertex : adjacencyList.get(vertex)) {
            if (!was[adjacentVertex]) {
                traverseVertex(adjacentVertex, was, adjacencyList, visited);
            }
        }
    }
}
