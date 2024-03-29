package com.dfedorino.rtasks.third_level.graphs;

public class CitiesAndRoads {
    /**
     * В галактике "Milky Way" на планете "Neptune" есть N городов, некоторые из которых соединены дорогами.
     * Император "Maximus" галактики "Milky Way" решил провести инвентаризацию дорог на планете "Neptune".
     * Но, как оказалось, он не силен в математике, поэтому он просит вас сосчитать количество дорог.
     * <p>
     * Входные данные
     * В первой строке  задается число N (0 ≤ N ≤ 100). В следующих N строках содержится по N чисел,
     * каждое из которых является единичкой или ноликом. Причем, если в позиции (i,j) квадратной матрицы
     * стоит единичка, то i-ый и j-ый города соединены дорогами, а если нолик, то не соединены.
     * <p>
     * Выходные данные
     * Выведите одно число – количество дорог на планете "Neptune".
     *
     * @param citiesAndRoads - матрица смежности, содержащая 1, если дорога есть и 0, если ее нет
     * @return количество дорог
     */
    public int countRoads(int[][] citiesAndRoads) {
        int roads = 0;
        for (int i = 0; i < citiesAndRoads.length; i++) {
            for (int j = i + 1; j < citiesAndRoads[i].length; j++) {
                roads += citiesAndRoads[i][j];
            }
        }
        return roads;
    }
}
