package com.dfedorino.rtasks.third_level.graphs.search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class GraphPath {
    public Route getShortestPath(int[][] adjacencyMatrix, int start, int finish) {
        Integer[] distance = getDistancesFrom(finish, adjacencyMatrix);
        Route route = new Route(new ArrayList<>());
        int currentVertex = start;
        while (currentVertex != finish) {
            int[] adjacentVertexes = adjacencyMatrix[currentVertex - 1];
            for (int adjacentVertexIndex = 0; adjacentVertexIndex < adjacentVertexes.length; adjacentVertexIndex++) {
                if (adjacentVertexes[adjacentVertexIndex] == 1) {
                    if (distance[adjacentVertexIndex] < distance[currentVertex - 1]) {
                        route.addVertex(currentVertex);
                        currentVertex = adjacentVertexIndex + 1;
                    }
                }
            }
        }
        route.addVertex(finish);
        return route;
    }

    private Integer[] getDistancesFrom(int start, int[][] adjacencyMatrix) {
        Integer[] distance = new Integer[adjacencyMatrix.length];
        Queue<Integer> toBeVisited = new ArrayDeque<>(adjacencyMatrix.length);
        toBeVisited.offer(start);
        distance[start - 1] = 0;
        while (!toBeVisited.isEmpty()) {
            int currentVertex = toBeVisited.poll();
            int[] edges = adjacencyMatrix[currentVertex - 1];
            for (int adjacentVertexIndex = 0; adjacentVertexIndex < edges.length; adjacentVertexIndex++) {
                if (edges[adjacentVertexIndex] == 1) {
                    int adjacentVertex = adjacentVertexIndex + 1;
                    if (distance[adjacentVertexIndex] == null) {
                        distance[adjacentVertexIndex] = distance[currentVertex - 1] + 1;
                        toBeVisited.offer(adjacentVertex);
                    }
                }
            }

        }
        return distance;
    }
}
