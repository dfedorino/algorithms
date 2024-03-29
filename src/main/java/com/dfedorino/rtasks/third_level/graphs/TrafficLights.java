package com.dfedorino.rtasks.third_level.graphs;

public class TrafficLights {
    /**
     * В подземелье M тоннелей и N перекрестков, каждый тоннель соединяет какие-то два перекрестка.
     * Мышиный король решил поставить по светофору в каждом тоннеле перед каждым перекрестком.
     * Напишите программу, которая посчитает, сколько светофоров должно быть установлено на каждом из перекрестков.
     * Перекрестки пронумерованы числами от 1 до N.
     * <p>
     * Входные данные
     * Первая строка входных данных содержит два числа N и M (0 < N ≤ 100, 0 ≤ M ≤ N*(N – 1)/2).
     * В каждой из следующих M строк записаны по два числа i и j (1 ≤ i,j ≤ N),
     * которые означают, что перекрестки i и j соединены тоннелем.
     * <p>
     * Выходные данные
     * Требуется вывести N чисел: k-ое число означает количество светофоров на k-ом перекрестке.
     * <p>
     * Примечание. Можно считать, что любые два перекрестка соединены не более, чем одним тоннелем.
     * Нет тоннелей от перекрестка i до него самого.
     *
     * @param tunnels - кол-во перекрестков (вершин)
     * @param tunnelPairs - массив с парами перекрестков, между которыми есть туннель (ребро)
     * @return кол-во светофоров для каждого перекрестка (кол-во ребер каждой вершины)
     */
    public int[] countTrafficLights(int tunnels, int[][] tunnelPairs) {
        int[] trafficLights = new int[tunnels];
        for (int[] pair : tunnelPairs) {
            trafficLights[pair[0] - 1]++;
            trafficLights[pair[1] - 1]++;
        }
        return trafficLights;
    }
}
