package com.dfedorino.rtasks.third_level.graphs.search;

import java.util.ArrayList;
import java.util.List;

public class RecursiveDepthFirstSearch implements Search{
    @Override
    public List<Integer> getTraversedVertexes(List<List<Integer>> adjacencyList) {
        boolean[] was = new boolean[adjacencyList.size()];
        List<Integer> traversed = new ArrayList<>();
        for (int vertex = 1; vertex <= adjacencyList.size(); vertex++) {
            if (!was[vertex - 1]) {
                depthFirstSearch(vertex, was, adjacencyList, traversed);
            }
        }
        return traversed;
    }

    private void depthFirstSearch(int vertex, boolean[] was, List<List<Integer>> adjacencyList, List<Integer> visited) {
        was[vertex - 1] = true;
        visited.add(vertex);
        List<Integer> adjacentVertexes = adjacencyList.get(vertex - 1);
        for (int adjacentVertex : adjacentVertexes) {
            if (!was[adjacentVertex - 1]) {
                depthFirstSearch(adjacentVertex, was, adjacencyList, visited);
            }
        }
    }
}
