package com.dfedorino.rtasks.third_level.graphs;

import lombok.Value;

public class Teasing {

    public Path computeOptimalPath(int[][] matrix) {
        // initialize array that will map length of the path to the vertices
        Integer[][] lengths = new Integer[3000][3];

        // initialize upper bound for permutations
        int bound = matrix.length;

        // initialize array that will store current vertices
        int[] curr = new int[3];

        // recursive permutation that will store every sum and vertices array into the lengths 2D array
        computeOptimalPath(0, 0, bound, curr, matrix, lengths);

        // find the first (which will be the cheapest) array of vertices
        return findShortestPath(lengths);
    }

    private Path findShortestPath(Integer[][] sums) {
        for (Integer[] vertices : sums) {
            if (vertices[0] != null) {
                return new Path(vertices[0] + 1, vertices[1] + 1, vertices[2] + 1);
            }
        }
        throw new IllegalArgumentException("Paths are not initialized");
    }

    private void computeOptimalPath(int index, int seed, int bound, int[] curr, int[][] m, Integer[][] sums) {
        if (index == curr.length) {
            // compute sum of edges between vertices
            int a = curr[0];
            int b = curr[1];
            int c = curr[2];
            int currRouteSum = m[a][b] + m[a][c] + m[b][c];
            // put result into the sums array
            sums[currRouteSum] = new Integer[]{a, b, c};
        } else {
            for (int i = seed; i < (i == 0 ? bound - 2 : bound); i++) {
                curr[index] = i;
                computeOptimalPath(index + 1, i + 1, bound, curr, m, sums);
            }
        }
    }

    @Value
    public static class Path {
        private int firstVertex;
        private int secondVertex;
        private int thirdVertex;
    }
}
