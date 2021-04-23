package com.dfedorino.rtasks.second_level;

public class Arrays {
    /**
     * Дан массив из N целых чисел. Вам поступают запросы о сумме всех элементов массива с элемента x по
     * элемент y включительно. Требуется ответить на все запросы.
     *
     * Входные данные
     * В первой строке находится число N количество элементов массива (1 ≤ N ≤ 100000) и M - количесто
     * запросов(1 ≤ M ≤ 100000). В следующей строке через пробел указаны элементы массива (по модулю не
     * превосходят 1000). Последующие M строк содержат по 2-а целых числа, разделенных пробелом - запрос
     * на сумму элементов на отрезке массива (1 ≤ x ≤ y ≤ N)
     *
     * Выходные данные
     * Для каждого запроса на отдельной строке выведите его результат - сумму всех чисел в массиве от
     * элемента x до элемента y.
     *
     * @param array - массив чисел
     * @param firstElementIndex - индекс первого элемента, начиная с 1
     * @param lastElementIndexInclusively - индекс последнего элемента начиная с 1, включительно
     * @return сумма элементов с firstElementIndex по lastElementIndexInclusively
     */
    public int findSum(int[] array, int firstElementIndex, int lastElementIndexInclusively) {
        int[] prefSums = new int[array.length + 1];
        prefSums[0] = 0;
        for (int elementIndex = 1; elementIndex < prefSums.length; elementIndex++) {
            prefSums[elementIndex] = prefSums[elementIndex - 1] + array[elementIndex - 1];
        }
        return prefSums[lastElementIndexInclusively] - prefSums[firstElementIndex - 1];
    }
}
