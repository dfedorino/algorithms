package com.dfedorino.rtasks.third_level.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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
        Map<Integer, List<Integer>> componentsOfGraph = adjacencyList.getComponentsOfGraph();
        System.out.println(">> components -> " + componentsOfGraph);
        for (int vertex : componentsOfGraph.keySet()) {
            int edges = adjacencyList.getAdjacentTo(vertex).size();
            int expectedEdges = componentsOfGraph.get(vertex).size() - 1;
            if (edges != expectedEdges) {
                return false;
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

        public List<Integer> getAdjacentTo(int vertex) {
            return adjList.get(vertex - 1);
        }

        public Map<Integer, List<Integer>> getComponentsOfGraph() {
            Map<Integer, List<Integer>> idToComponent = new HashMap<>();
            Queue<Integer> notVisited = new ArrayDeque<>(adjList.size());
            boolean[] was = new boolean[adjList.size()];
            boolean[] alreadyAddedToNotVisited = new boolean[adjList.size()];
            for (int vertex = 1; vertex < vertexes; vertex++) {
                int firstNotVisitedVertex = getFirstNotVisited(was);
                if (firstNotVisitedVertex == -1) {
                    break;
                }
                List<Integer> component = new ArrayList<>();
                notVisited.offer(firstNotVisitedVertex);
                while (!notVisited.isEmpty()) {
                    int currentVertex = notVisited.poll();
                    alreadyAddedToNotVisited[currentVertex - 1] = false;
                    List<Integer> adjacentVertexes = adjList.get(currentVertex - 1);
                    adjacentVertexes.stream()
                            .filter(adjacentVertex -> !was[adjacentVertex - 1])
                            .filter(adjacentVertex -> !alreadyAddedToNotVisited[adjacentVertex - 1])
                            .peek(adjacentVertex -> alreadyAddedToNotVisited[adjacentVertex - 1] = true)
                            .peek(adjacentVertex -> idToComponent.put(adjacentVertex, component))
                            .forEach(notVisited::offer);
                    component.add(currentVertex);
                    was[currentVertex - 1] = true;
                }
                idToComponent.put(vertex, component);
            }
            return idToComponent;
        }

        private int getFirstNotVisited(boolean[] was) {
            for (int vertexIndex = 0; vertexIndex < was.length; vertexIndex++) {
                if (!was[vertexIndex]) {
                    return vertexIndex + 1;
                }
            }
            return -1;
        }
    }
}
