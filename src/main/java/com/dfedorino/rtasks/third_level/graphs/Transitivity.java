package com.dfedorino.rtasks.third_level.graphs;

import java.util.ArrayList;
import java.util.List;

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

        // initialize boolean array to mark traversed vertexes
        boolean[] was = new boolean[vertexes];

        // traverse the vertexes
        for (int vertex = 0; vertex < vertexes; vertex++) {
            if (!was[vertex]) {
                was[vertex] = true;
                List<Integer> adjacentToCurrent = adjacencyList.getAdjacentTo(vertex);
                int edges = adjacentToCurrent.size();

                // check if any adjacent vertex has less edges than current
                for (Integer adjacentVertex : adjacentToCurrent) {
                    if (!was[adjacentVertex - 1]) {
                        was[adjacentVertex - 1] = true;
                        int adjacentVertexEdges = adjacencyList.getAdjacentTo(adjacentVertex - 1).size();
                        if (adjacentVertexEdges != edges) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private static class AdjacencyList {
        private final List<List<Integer>> adjacencyList;

        public AdjacencyList(int vertexes, int[][] pairs) {
            adjacencyList = initializeAdjacencyList(vertexes);
            fillAdjacencyList(pairs, adjacencyList);
        }

        private List<List<Integer>> initializeAdjacencyList(int vertexes) {
            List<List<Integer>> adjacencyList = new ArrayList<>(vertexes);
            for (int i = 0; i < vertexes; i++) {
                adjacencyList.add(i, new ArrayList<>());
            }
            return adjacencyList;
        }

        private void fillAdjacencyList(int[][] pairs, List<List<Integer>> adjacencyList) {
            for (int[] pair : pairs) {
                int firstVertex = pair[0];
                int secondVertex = pair[1];
                adjacencyList.get(firstVertex - 1).add(secondVertex);
                adjacencyList.get(secondVertex - 1).add(firstVertex);
            }
        }

        public List<Integer> getAdjacentTo(int vertex) {
            return adjacencyList.get(vertex);
        }

        @Override
        public String toString() {
            StringBuilder string = new StringBuilder();
            for (int i = 0; i < adjacencyList.size(); i++) {
                string
                        .append("[")
                        .append(i + 1)
                        .append("] -> ")
                        .append(adjacencyList.get(i))
                        .append(System.lineSeparator());
            }
            return string.toString();
        }
    }
}
