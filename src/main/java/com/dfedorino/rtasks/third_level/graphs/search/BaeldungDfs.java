package com.dfedorino.rtasks.third_level.graphs.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BaeldungDfs implements Search {
    @Override
    public List<Integer> getTraversedVertexes(List<List<Integer>> adjacencyList) {
        List<Integer> visited = new ArrayList<>(adjacencyList.size());
        dfsWithoutRecursion(1, adjacencyList, visited);
        return visited;
    }

    // doesn't traverse multiple components,
    public void dfsWithoutRecursion(int start, List<List<Integer>> adjVertices, List<Integer> visited) {
        Stack<Integer> stack = new Stack<>();
        boolean[] isVisited = new boolean[adjVertices.size()];
        stack.push(start);
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
