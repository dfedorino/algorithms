package com.dfedorino.rtasks.third_level.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
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
        Map<Integer, ComponentVertexesCounter> vertexToConnectedVertexMap = adjacencyList.getVertexesInComponentsOfGraph();
        for (int vertex : vertexToConnectedVertexMap.keySet()) {
            int edges = adjacencyList.getAdjacentTo(vertex).size();
            int expectedEdges = vertexToConnectedVertexMap.get(vertex).getNumberOfConnectedVertexes() - 1;
            if (edges != expectedEdges) {
                return false;
            }
        }
        return true;
    }

    private static class AdjacencyList {
        private final List<List<Integer>> adjList;

        public AdjacencyList(int vertexes, int[][] pairs) {
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

        public Map<Integer, ComponentVertexesCounter> getVertexesInComponentsOfGraph() {
            // create map that maps every vertex to number of vertexes in its component
            Map<Integer, ComponentVertexesCounter> vertexToVertexesInComponent = new HashMap<>();

            // queue for bfs
            Queue<Integer> notVisited = new ArrayDeque<>(adjList.size());

            // boolean array for bfs
            boolean[] was = new boolean[adjList.size()];

            // boolean array for bfs that stores vertexes that were already added to queue but were not processed yet
            boolean[] alreadyAddedToNotVisited = new boolean[adjList.size()];

            // for every not visited vertex in was array
            for (int notVisitedVertex = 1; notVisitedVertex > 0; notVisitedVertex = getFirstNotVisited(was)) {

                // create new counter that counts vertexes in component of the current vertex
                ComponentVertexesCounter vertexesInComponentCounter = new ComponentVertexesCounter(0);

                // add first not visited vertex to queue
                notVisited.offer(notVisitedVertex);

                // while there are not visited vertexes in the queue
                while (!notVisited.isEmpty()) {

                    // poll vertex that is visited
                    int currentVertex = notVisited.poll();

                    // increment counter as at the moment there is at least 1 vertex
                    vertexesInComponentCounter.increment();

                    // update array so it can be reused for further iterations
                    alreadyAddedToNotVisited[currentVertex - 1] = false;

                    // get adjacent to current
                    List<Integer> adjacentVertexes = adjList.get(currentVertex - 1);

                    // process adjacent to current
                    adjacentVertexes.stream()
                            // leave only those that were not visited
                            .filter(adjacentVertex -> !was[adjacentVertex - 1])
                            // leave only those that were not added to the queue
                            .filter(adjacentVertex -> !alreadyAddedToNotVisited[adjacentVertex - 1])
                            // as remaining vertex are going to be added to queue, mark them as added beforehand
                            .peek(adjacentVertex -> alreadyAddedToNotVisited[adjacentVertex - 1] = true)

                            // put in the map counter that is common for every vertex in the component
                            // custom wrapper is needed here because Integer does not dynamically increase
                            .peek(adjacentVertex -> vertexToVertexesInComponent.put(adjacentVertex, vertexesInComponentCounter))

                            // add remaining adjacent vertexes to the queue
                            .forEach(notVisited::offer);

                    // mark current vertex as visited
                    was[currentVertex - 1] = true;
                }

                // put current not visited vertex in the map with the number of vertexes in its component
                vertexToVertexesInComponent.put(notVisitedVertex, vertexesInComponentCounter);
            }
            return vertexToVertexesInComponent;
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

    private static class ComponentVertexesCounter {
        private int counter;

        public ComponentVertexesCounter(int value) {
            this.counter = value;
        }

        public void increment() {
            counter++;
        }

        public int getNumberOfConnectedVertexes() {
            return counter;
        }

        @Override
        public String toString() {
            return String.valueOf(counter);
        }
    }
}
