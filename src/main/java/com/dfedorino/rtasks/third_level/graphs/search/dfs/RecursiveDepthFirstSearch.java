package com.dfedorino.rtasks.third_level.graphs.search.dfs;

import com.dfedorino.rtasks.third_level.graphs.search.Search;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RecursiveDepthFirstSearch implements Search {
    @Override
    public List<Integer> getTraversedVertexes(List<List<Integer>> adjacencyList) {
        boolean[] was = new boolean[adjacencyList.size()];
        return IntStream.range(1, adjacencyList.size())
                .filter(vertex -> !was[vertex])
                .mapToObj(vertex -> depthFirstSearch(vertex, was, adjacencyList))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    private List<Integer> depthFirstSearch(int vertex, boolean[] was, List<List<Integer>> adjacencyList) {
        List<Integer> adjacentVertexes = adjacencyList.get(vertex);
        if (adjacentVertexes.isEmpty()) {
            was[vertex] = true;
            return List.of(vertex);
        } else {
            was[vertex] = true;
            List<Integer> visited = adjacentVertexes.stream()
                    .filter(adjacentVertex -> !was[adjacentVertex])
                    .map(adjacentVertex -> depthFirstSearch(adjacentVertex, was, adjacencyList))
                    .flatMap(List::stream)
                    .collect(Collectors.toList());
            visited.add(vertex);
            return visited;
        }
    }
}
