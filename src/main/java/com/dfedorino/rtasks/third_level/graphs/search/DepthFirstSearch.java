package com.dfedorino.rtasks.third_level.graphs.search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch implements Search {
    @Override
    public List<Integer> getTraversedVertexes(List<List<Integer>> adjacencyList) {
        List<Integer> visited = new ArrayList<>(adjacencyList.size());
        ArrayDeque<Integer> toBeVisited = new ArrayDeque<>(adjacencyList.size());
        boolean[] was = new boolean[adjacencyList.size()];
        // for-loop in case there are several components in the graph
        for (int vertex = 1; vertex < was.length; vertex++) {
            if (!was[vertex]) {
                toBeVisited.push(vertex);
            }
            while (!toBeVisited.isEmpty()) {
                int currentVertex = toBeVisited.pop();
                was[currentVertex] = true;
                visited.add(currentVertex);
                List<Integer> adjacentVertexes = adjacencyList.get(currentVertex);
                for (int adjacentVertex = adjacentVertexes.size() - 1; adjacentVertex >= 0; adjacentVertex--) {
                    int currentAdjacentVertex = adjacentVertexes.get(adjacentVertex);
                    if (!was[currentAdjacentVertex]) {
                        toBeVisited.push(currentAdjacentVertex);
                        // this assignment ensures that a vertex that is already added to the toBeVisited
                        // won't be added again
                        was[currentAdjacentVertex] = true;
                    }
                }
            }
        }
        return visited;
    }
}
