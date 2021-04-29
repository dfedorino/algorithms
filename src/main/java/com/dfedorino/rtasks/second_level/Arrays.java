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

    /**
     * Реализуйте структуру данных для эффективного вычисления количества нулей в отрезке массива.
     *
     * Входные данные
     * В первой строке вводится одно натуральное число N (1≤100000) — количество чисел в массиве.
     *
     * Во второй строке вводятся N чисел от 0 до 100000 — элементы массива.
     *
     * В третьей строке вводится одно натуральное число K (1≤K≤30000) — количество запросов на вычисление
     * количества нулей.
     *
     * В следующих K строках вводится по два числа — номера левого и правого элементов отрезка массива
     * (считается, что элементы массива нумеруются с единицы).
     *
     * Выходные данные
     * Для каждого запроса выведите количество нулей на соответствующем участке массива. Числа выводите
     * в одну строку через пробел.
     *
     * @param array - массив чисел
     * @param firstElementIndex - индекс первого элемента, начиная с 1
     * @param lastElementIndexInclusively - индекс последнего элемента начиная с 1, включительно
     * @return кол-во нулей на заданном отрезке
     */
    public int countZeros(int[] array, int firstElementIndex, int lastElementIndexInclusively) {
        int[] zerosCount = new int[array.length + 1];
        zerosCount[0] = 0;
        for (int i = 1; i < zerosCount.length; i++) {
            zerosCount[i] = array[i - 1] == 0 ? zerosCount[i - 1] + 1 : zerosCount[i - 1];
        }
        return zerosCount[lastElementIndexInclusively] - zerosCount[firstElementIndex - 1];
    }
}
