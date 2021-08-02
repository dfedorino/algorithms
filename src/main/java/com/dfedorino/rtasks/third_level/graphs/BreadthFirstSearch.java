package com.dfedorino.rtasks.third_level.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class BreadthFirstSearch implements Search {

    @Override
    public List<Integer> traverse(List<List<Integer>> adjacencyList) {
        Queue<Integer> toBeVisited = new ArrayDeque<>(adjacencyList.size());
        boolean[] was = new boolean[adjacencyList.size()];
        List<Integer> visited = new ArrayList<>(adjacencyList.size());
        toBeVisited.offer(1);
        while(!toBeVisited.isEmpty()) {
            int currentVertex = toBeVisited.poll();
            if (!was[currentVertex - 1]) {
                adjacencyList.get(currentVertex - 1).stream()
                        .filter(vertex -> !was[vertex - 1])
                        .forEach(toBeVisited::offer);
                was[currentVertex - 1] = true;
                visited.add(currentVertex);
            }
        }
        return visited;
    }
}
