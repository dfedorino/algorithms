package com.dfedorino.rtasks.third_level.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class Transitivity {
    /**
     * Напомним, что граф называется транзитивным, если всегда из того,
     * что вершины u и v соединены ребром и вершины v и w соединены ребром следует,
     * что вершины u и w соединены ребром.
     * <p>
     * Проверьте, что заданный неориентированный граф является транзитивным.
     * <p>
     * Входные данные
     * Сначала вводятся числа:
     * n (1 ≤ n ≤ 100) – количество вершин в графе;
     * m (1 ≤ m ≤ n(n − 1)/2) – количество ребер.
     * Затем следует m пар чисел – ребра графа.
     * <p>
     * Выходные данные
     * Выведите  «YES», если граф является транзитивным, и «NO» в противном случае.
     *
     * @param vertexes - количество вершин в графе
     * @param pairs    - ребра графа
     * @return true, если граф является транзитивным, false в противном случае
     */
    public boolean isTransitive(int vertexes, int[][] pairs) {
        AdjacencyList adjacencyList = new AdjacencyList(vertexes, pairs);
        Map<Integer, List<Integer>> map = adjacencyList.getComponentsOfGraph();
        for (Integer id : map.keySet()) {
            List<Integer> component = map.get(id);
            int edges = component.size() - 1;
            for (Integer vertex : component) {
                boolean hasLessEdges = adjacencyList.getAdjacentTo(vertex - 1).size() != edges;
                if (hasLessEdges) {
                    return false;
                }
            }
        }
        return true;
    }

    private static class AdjacencyList {
        private final int vertexes;
        private final List<List<Integer>> adjList;

        public AdjacencyList(int vertexes, int[][] pairs) {
            this.vertexes = vertexes;
            adjList = new ArrayList<>(vertexes);
            for (int i = 0; i < vertexes; i++) {
                adjList.add(i, new ArrayList<>());
            }
            for (int[] pair : pairs) {
                adjList.get(pair[0] - 1).add(pair[1]);
                adjList.get(pair[1] - 1).add(pair[0]);
            }
        }

        public List<Integer> getAdjacentTo(int vertexIndex) {
            return adjList.get(vertexIndex);
        }

        public Map<Integer, List<Integer>> getComponentsOfGraph() {
            Map<Integer, List<Integer>> idToComponent = new HashMap<>();
            Queue<Integer> notVisited = new ArrayDeque<>();
            boolean[] was = new boolean[vertexes];
            for (int vertexId = 1; vertexId < vertexes; vertexId++) {
                notVisited.add(vertexId);
                List<Integer> visited = new ArrayList<>();
                while (!notVisited.isEmpty()) {
                    for (Integer vertex : notVisited) {
                        notVisited.poll();
                        if (!was[vertex - 1]) {
                            visited.add(vertex);
                            was[vertex - 1] = true;
                            List<Integer> adjacentVertexes = adjList.get(vertex - 1);
                            for (Integer adjacentVertex : adjacentVertexes) {
                                if (!was[adjacentVertex - 1]) {
                                    notVisited.add(adjacentVertex);
                                }
                            }
                        }
                    }
                }
                if (!visited.isEmpty()) {
                    idToComponent.put(vertexId, visited);
                }
            }
            return idToComponent;
        }
    }
}
