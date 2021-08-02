package com.dfedorino.rtasks.third_level.graphs;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch implements Search{
    @Override
    public List<Integer> getTraversedVertexes(List<List<Integer>> adjacencyList) {
        boolean[] was = new boolean[adjacencyList.size()];
        List<Integer> traversed = new ArrayList<>();
        for (int vertex = 1; vertex <= adjacencyList.size(); vertex++) {
            if (!was[vertex - 1]) {
                traversed.addAll(getTraversedVertexes(vertex, was, adjacencyList));
            }
        }
        return traversed;
    }

    private List<Integer> getTraversedVertexes(int vertex, boolean[] was, List<List<Integer>> adjacencyList) {
        List<Integer> adjacent = adjacencyList.get(vertex - 1);
        if (adjacent.isEmpty()) {
            was[vertex - 1] = true;
            return List.of(vertex);
        } else {
            was[vertex - 1] = true;
            List<Integer> currentAndAdjacent = new ArrayList<>();
            currentAndAdjacent.add(vertex);
            for (int adj : adjacent) {
                if (!was[adj - 1]) {
                    List<Integer> adjacentToAdjacent = getTraversedVertexes(adj, was, adjacencyList);
                    currentAndAdjacent.addAll(adjacentToAdjacent);
                }
            }
            return currentAndAdjacent;
        }
    }
}
