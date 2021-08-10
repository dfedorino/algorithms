package com.dfedorino.rtasks.third_level.graphs.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BaeldungDfs implements Search {
    @Override
    public List<Integer> getTraversedVertexes(List<List<Integer>> adjacencyList) {
        List<Integer> visited = new ArrayList<>(adjacencyList.size());
        dfsWithoutRecursion(adjacencyList, visited);
        return visited;
    }

    public void dfsWithoutRecursion(List<List<Integer>> adjVertices, List<Integer> visited) {
        Stack<Integer> stack = new Stack<>();
        boolean[] isVisited = new boolean[adjVertices.size()];
        for (int vertex = 1; vertex < adjVertices.size(); vertex++) {
            if (!isVisited[vertex]) {
                stack.push(vertex);
                while (!stack.isEmpty()) {
                    int current = stack.pop();
                    if (!isVisited[current]) {
                        visited.add(current); // instead of 'visit(current);'
                        isVisited[current] = true;
                    }
                    for (int dest : adjVertices.get(current)) {
                        if (!isVisited[dest])
                            stack.push(dest);
                    }
                }
            }
        }

    }
}
