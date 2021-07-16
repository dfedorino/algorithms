package com.dfedorino.rtasks.third_level.graphs;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SourcesAndSinks {
    /**
     * Напомним, что вершина ориентированного графа называется истоком,
     * если в нее не входит ни одно ребро и стоком, если из нее не выходит ни одного ребра.
     * <p>
     * Ориентированный граф задан матрицей смежности. Найдите все вершины графа,
     * которые являются истоками, и все его вершины, которые являются стоками.
     * <p>
     * Входные данные
     * Сначала вводится число n ( 1$ le$n$ le$100) – количество вершин в графе,
     * а затем n строк по n чисел, каждое из которых равно 0 или 1, – его матрица смежности.
     * <p>
     * Выходные данные
     * Вначале выведите k – число истоков в графе и затем k чисел – номера вершин, которые являются истоками,
     * в возрастающем порядке. Затем выведите информацию о стоках в том же формате.
     *
     * @param adjacencyMatrix - матрица смежности
     * @return пара сетов, первый из которых - истоки, а второй - стоки
     */
    public Pair<Set<Integer>, Set<Integer>> countSourcesAndSinks(int[][] adjacencyMatrix) {
        Set<Integer> sources = IntStream.rangeClosed(1, adjacencyMatrix.length).boxed().collect(Collectors.toSet());
        Set<Integer> sinks = new HashSet<>(sources);
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    sources.remove(j + 1);
                    sinks.remove(i + 1);
                }
            }
        }
        return new Pair<>(sources, sinks);
    }
}
