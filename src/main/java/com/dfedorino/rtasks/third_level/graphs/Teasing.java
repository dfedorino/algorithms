package com.dfedorino.rtasks.third_level.graphs;

import lombok.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Teasing {


    public OptimalRoute computeOptimalRoute(int[][] matrix) {
        // представить матрицу смежности в виде списка смежностей
        // так как граф ориентированный, можно идти только по второй половине матрицы
        List<Vertex> vertexes = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            vertexes.add(new Vertex(i + 1, new TreeMap<>()));
        }

        for (int i = 0; i < matrix.length; i++) {
            Vertex currentVertex = vertexes.get(i);
            for (int j = i + 1; j < matrix.length; j++) {
                Vertex adjacentVertex = vertexes.get(j);
                int priceToAdjacentVertex = matrix[i][j];
                currentVertex.addEdge(adjacentVertex, priceToAdjacentVertex);
                adjacentVertex.addEdge(currentVertex, priceToAdjacentVertex);
            }
        }
        vertexes.forEach(System.out::println);
        // для каждой вершины найти оптимальный маршрут из 3х вершин

        // сохранить оптимальный
        return new OptimalRoute(1, 2, 5);
    }

    @Value
    public static class Vertex {
        private int id;
        private Map<Integer, List<Integer>> priceAndEdges;

        private void addEdge(Vertex adjacentVertex, int priceToAdjacentVertex) {
            priceAndEdges.putIfAbsent(priceToAdjacentVertex, new ArrayList<>());
            priceAndEdges.get(priceToAdjacentVertex).add(adjacentVertex.getId());
        }
    }

    @Value
    public static class OptimalRoute {
        private int firstVertex;
        private int secondVertex;
        private int thirdVertex;
    }
}
