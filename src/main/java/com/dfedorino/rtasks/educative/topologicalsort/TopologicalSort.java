package com.dfedorino.rtasks.educative.topologicalsort;

import java.util.*;

public class TopologicalSort {
    /**
     * "Topological Sort" of a directed graph (a graph with unidirectional edges) is a linear ordering of its vertices
     * such that for every directed edge (U, V) from vertex U to vertex V, U comes before V in the ordering.
     * <p>
     *
     * Given a directed graph, find the topological ordering of its vertices.
     * <p>
     *
     * Example 1:
     * Input: Vertices=4, Edges=[3, 2], [3, 0], [2, 0], [2, 1]
     * Output: Following are the two valid topological sorts for the given graph:
     * 1) 3, 2, 0, 1
     * 2) 3, 2, 1, 0
     * <p>
     *
     * Example 2:
     * Input: Vertices=5, Edges=[4, 2], [4, 3], [2, 0], [2, 1], [3, 1]
     * Output: Following are all valid topological sorts for the given graph:
     * 1) 4, 2, 3, 0, 1
     * 2) 4, 3, 2, 0, 1
     * 3) 4, 3, 2, 1, 0
     * 4) 4, 2, 3, 1, 0
     * 5) 4, 2, 0, 3, 1
     * <p>
     *
     * Example 3:
     * Input: Vertices=5, Edges=[4, 2], [4, 3], [2, 0], [2, 1], [3, 1]
     * Output: Following are all valid topological sorts for the given graph:
     * 1) 4, 2, 3, 0, 1
     * 2) 4, 3, 2, 0, 1
     * 3) 4, 3, 2, 1, 0
     * 4) 4, 2, 3, 1, 0
     * 5) 4, 2, 0, 3, 1
     **/
    public List<Integer> sort(int vertices, int[][] edges) {
        int[] incomingEdgesCount = new int[vertices];
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // fill in the graph + count incoming edges for every vertex
        for (int[] edge : edges) {
            List<Integer> children = graph.getOrDefault(edge[0], new ArrayList<>());
            children.add(edge[1]);
            incomingEdgesCount[edge[1]]++;
            graph.put(edge[0], children);
        }

        List<Integer> sortedVertices = new ArrayList<>(vertices);
        Queue<Integer> sourceQueue = new ArrayDeque<>();

        // find all the sources
        for (int i = 0; i < incomingEdgesCount.length; i++) {
            if (incomingEdgesCount[i] == 0) {
                sourceQueue.add(i);
            }
        }

        // traverse the graph in a BFS manner
        // after moving current vertex to the sorted list
        // decrement each child's incoming edge count
        // if the count is 0 - we got a new source, add it to the queue
        // until there is no more source vertices
        while (!sourceQueue.isEmpty()) {
            int vertex = sourceQueue.poll();
            sortedVertices.add(vertex);
            List<Integer> children = graph.getOrDefault(vertex, Collections.emptyList());
            for (Integer child : children) {
                if (--incomingEdgesCount[child] == 0) {
                    sourceQueue.offer(child);
                }
            }
        }

        return sortedVertices;

        // Edges=[3,2] [3,0] [2,0] [2,1]

        // Graph:
        // 3 -> [2, 0]
        // 2 -> [0, 1]
        // 1 -> []
        // 0 -> []

        // incoming vertices:
        // 0 | 1 | 2 | 3
        //---|---|---|---
        // 2 | 1 | 1 | 0

        // sources:
        // [3]

        // sorted vertices:
        // []

        // 1. Remove current sources:
        // 1.1 Take 3
        // 1.2 Take all its children: [2, 0]
        // 1.3 Decrease children's incoming vertices count
        // 1.4 If any child's incoming vertices count is 0 -> add it to the sources array (add 2 to sources)
        // 1.5 Add 3 to the sorted vertices

        // first iteration:

        // incoming vertices:
        // 0 | 1 | 2 | 3
        //---|---|---|---
        // 2 | 1 | 0 | 0

        // sources:
        // [2]

        // sorted vertices:
        // [3]

        // final result:
        // [3, 2, 1, 0]
    }
}
