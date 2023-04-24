package com.dfedorino.rtasks.third_level.graphs.search.dfs;

import com.dfedorino.rtasks.third_level.graphs.search.Search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch implements Search {
    @Override
    public List<Integer> getTraversedVertexes(List<List<Integer>> adjacencyList) {
        List<Integer> visited = new ArrayList<>(adjacencyList.size());
        boolean[] was = new boolean[adjacencyList.size()];
        for (int vertex = 1; vertex < was.length; vertex++) {
            if (!was[vertex]) {
                traverseGraphStartingFrom(vertex, adjacencyList, was, visited);
            }
        }
        return visited;
    }

    private void traverseGraphStartingFrom(int vertex, List<List<Integer>> adjacencyList, boolean[] was, List<Integer> visited) {
        ArrayDeque<Integer> toBeVisited = new ArrayDeque<>();
        toBeVisited.push(vertex);
        while (!toBeVisited.isEmpty()) {
            int currentVertex = toBeVisited.pop();
            if (!was[currentVertex]) {
                was[currentVertex] = true;
                visited.add(currentVertex);
            }
            List<Integer> adjacentVertexes = adjacencyList.get(currentVertex);
            adjacentVertexes.stream()
                    .filter(adjacentVertex -> !was[adjacentVertex])
                    .forEach(toBeVisited::push);
        }
    }
}
