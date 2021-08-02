package com.dfedorino.rtasks.third_level.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class BreadthFirstSearch implements Search {

    @Override
    public List<Integer> getTraversedVertexes(List<List<Integer>> adjacencyList) {
        Queue<Integer> toBeVisited = new ArrayDeque<>(adjacencyList.size());
        boolean[] was = new boolean[adjacencyList.size()];
        List<Integer> visited = new ArrayList<>(adjacencyList.size());
        for (int vertex = 1; vertex <= adjacencyList.size(); vertex++) {
            if (!was[vertex - 1]) {
                toBeVisited.offer(vertex);
            }
            while(!toBeVisited.isEmpty()) {
                int currentVertex = toBeVisited.poll();
                if (!was[currentVertex - 1]) {
                    adjacencyList.get(currentVertex - 1).stream()
                            .filter(adjacentVertex -> !was[adjacentVertex - 1])
                            .filter(adjacentVertex -> !toBeVisited.contains(adjacentVertex))
                            .forEach(toBeVisited::offer);
                    was[currentVertex - 1] = true;
                    visited.add(currentVertex);
                }
            }
        }
        return visited;
    }
}
