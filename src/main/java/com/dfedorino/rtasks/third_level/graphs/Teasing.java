package com.dfedorino.rtasks.third_level.graphs;

import lombok.Value;

public class Teasing {
    /**
     * В городе N площадей. Любые две площади соединены между собой ровно одной дорогой с двусторонним движением.
     * В этом городе живет Штирлиц. У Штирлица есть хобби - он любит воскресным утром выйти из дома, сесть в машину,
     * выбрать какой-нибудь кольцевой маршрут, проходящий ровно по трем площадям (то есть сначала он едет с какой-то
     * площади на какую-то другую, потом - на третью, затем возвращается на начальную, и опять едет по этому маршруту).
     * Он воображает, что где-то на этом пути стоит Борман. И так вот ездит Штирлиц все воскресенье,
     * пока голова не закружится, и радуется...
     * <p>
     * Естественно, что Штирлицу хочется проезжать мимо точки, в которой, как он воображает, стоит Борман,
     * как можно чаще. Для этого, естественно, выбранный Штирлицем маршрут должен быть как можно короче.
     * Напишите программу, которая выберет оптимальный для Штирлица маршрут.
     * <p>
     * Входные данные
     * В первой строке задается  число N (3 <= N <= 100).
     * В последующих строках содержится матрица NxN расстояний между площадями
     * (число в позиции i,j обозначает длину дороги, соединяющей i-ую и j-ую площади).
     * Все числа в матрице (кроме стоящих на главной диагонали) - натуральные, не превышающие 1000.
     * Матрица симметрична относительно главной диагонали, на главной диагонали стоят 0.
     * <p>
     * Выходные данные
     * Требуется вывести три числа — номера площадей в оптимальном маршруте.
     * Если маршрутов несколько, выведите любой из них.
     *
     * @param matrix - матрица NxN расстояний между площадями
     * @return номера площадей в оптимальном маршруте
     */
    public Path computeShortestPath(int[][] matrix) {
        // initialize upper bound to the number of vertexes for permutations
        int vertexes = matrix.length;

        // initialize dummy path that must be filled with first vertexes inside the loop
        Path currentPath = new Path(0, 0, 0);

        // dummy path that will be substituted with the first real path and its length
        ShortestPath dummyPath = new ShortestPath(Integer.MAX_VALUE, new Path(0, 0, 0));

        // find shortest route using recursive permutation
        ShortestPath shortestPath = computeShortestPath(0, 0, vertexes, currentPath, matrix, dummyPath);

        // return the shortest path
        return shortestPath.getPath();
    }

    private ShortestPath computeShortestPath(int currentVertex, int startVertex, int lastVertex, Path currentPath, int[][] adjacencyMatrix, ShortestPath shortestPath) {
        // exit clause - if first three vertexes found
        if (currentVertex == currentPath.getVertexes().length) {
            int a = currentPath.getVertexes()[0];
            int b = currentPath.getVertexes()[1];
            int c = currentPath.getVertexes()[2];

            // compute length of the current path
            int currentPathLength = adjacencyMatrix[a][b] + adjacencyMatrix[a][c] + adjacencyMatrix[b][c];

            // compare length with the length of the shortest path
            if (shortestPath.getLength() > currentPathLength) {

                // update shortestPair with current length and path
                return new ShortestPath(currentPathLength, new Path(a + 1, b + 1, c + 1));

            }

            // else ignore current length and path and return passed shortestPath

        } else {
            // permute all vertexes
            // if seed == 0 than no need to permute until the last vertex as we need vertexes with at least 2 neighbours
            // so the final set of the combinations of matrix with length 5 will be:
            // [1, 2, 3] [1, 2, 4] [1, 2, 5] [1, 3, 4] [1, 3, 5] [1, 4, 5]
            // [2, 3, 4] [2, 3, 5] [2, 4, 5]
            // [3, 4, 5]
            // no need to permute [4, 5] and [5] as they have 1 and 0 neighbours
            for (int i = startVertex; i < (i == 0 ? lastVertex - 2 : lastVertex); i++) {
                currentPath.getVertexes()[currentVertex] = i;

                // get shortest path so return it after the loop
                int nextVertex = currentVertex + 1;
                int nextAdjacentVertex = i + 1;
                shortestPath = computeShortestPath(nextVertex, nextAdjacentVertex, lastVertex, currentPath, adjacencyMatrix, shortestPath);
            }
        }

        // return is not inside the else clause as it is a common part of the exit clause and loop clause
        return shortestPath;
    }

    @Value
    private static class ShortestPath {
        private Integer length;
        private Path path;
    }

    @Value
    public static class Path {
        private int[] vertexes;

        public Path(int... vertexes) {
            this.vertexes = vertexes;
        }
    }
}
