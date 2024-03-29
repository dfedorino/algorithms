package com.dfedorino.rtasks.first_level;

public class MatrixMaxValueFinder {
    /**
     * В метании молота состязается n спортcменов. Каждый из них сделал m бросков. Победителем соревнований
     * объявляется тот спортсмен, у которого максимален наилучший результат по всем броскам. Таким образом,
     * программа должна найти значение максимального элемента в данном массиве, а также его индексы
     * (то есть номер спортсмена и номер попытки).
     * <p>
     * Входные данные
     * Программа получает на вход два числа n и m, являющиеся числом строк и столбцов в массиве. Далее во
     * входном потоке идет n строк по m чисел, являющихся элементами массива.
     * <p>
     * Выходные данные
     * Программа выводит значение максимального элемента, затем номер строки и номер столбца, в котором он
     * встречается. Если в массиве несколько максимальных элементов, то нужно вывести минимальный номер строки,
     * в которой встречается такой элемент, а если в этой строке таких элементов несколько, то нужно вывести
     * минимальный номер столбца. Не забудьте, что все строки и столбцы нумеруются с 0.
     *
     * @param matrix - матрица, в которой будет производиться поиск
     * @return массив из трех элементов, где первый элемент - это максимальное значение, второй элемент - индекс
     * первого массива, где оно встречается, третий элемент - первый индекс максимального значения
     */
    public int[] findMaxValueAndIndexes(int[][] matrix) {
        int longestShot = Integer.MIN_VALUE;
        int rowIndex = 0;
        int valueIndex = 0;
        for (int currentRowIndex = 0; currentRowIndex < matrix.length; currentRowIndex++) {
            for (int valueInRowIndex = 0; valueInRowIndex < matrix[currentRowIndex].length; valueInRowIndex++) {
                int currentValue = matrix[currentRowIndex][valueInRowIndex];
                if (currentValue > longestShot) {
                    longestShot = currentValue;
                    rowIndex = currentRowIndex;
                    valueIndex = valueInRowIndex;
                }
            }
        }
        return new int[]{longestShot, rowIndex, valueIndex};
    }
}
