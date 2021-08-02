package com.dfedorino.rtasks.third_level.graphs;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch implements Search{
    @Override
    public List<Integer> getTraversedVertexes(List<List<Integer>> adjacencyList) {
        return getTraversedVertexes(1, adjacencyList);
    }

    private List<Integer> getTraversedVertexes(int vertex, List<List<Integer>> adjacencyList) {
        List<Integer> adjacent = adjacencyList.get(vertex - 1);
        if (adjacent.isEmpty()) {
            return List.of(vertex);
        } else {
            List<Integer> currentAndAdjacent = new ArrayList<>();
            currentAndAdjacent.add(vertex);
            for (int adj : adjacent) {
                List<Integer> adjacentToAdjacent = getTraversedVertexes(adj, adjacencyList);
                currentAndAdjacent.addAll(adjacentToAdjacent);
            }
            return currentAndAdjacent;
        }
    }
}
