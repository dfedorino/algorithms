package com.dfedorino.rtasks.first_level;

public class FibSequencer {
    /**
     * Последовательность чисел a1, a2, …, ai,… называется Фибоначчиевой, если для всех i≥3 верно, что
     * ai=ai–1+ai–2, то есть каждый член последовательности (начиная с третьего) равен сумме двух предыдущих.
     * <p>
     * Ясно, что задавая различные числа a1 и a2 мы можем получать различные такие последовательности, и
     * любая Фибоначчиева последовательность однозначно задается двумя своими первыми членами.
     * <p>
     * Будем решать обратную задачу. Вам будет дано число N и два члена последовательности: aN и aN+1.
     * Вам нужно написать программу, которая по их значениям найдет a1 и a2.
     * <p>
     * Входные данные
     * Вводятся число N и значения двух членов последователности: aN и aN+1 (1≤N≤30, члены последовательности — целые числа, по модулю не превышающие 100)
     * Если вы пишите на языке программирования python, то считывание aN и aN+1 элементов должно быть организовано так:
     * x, y = map(int, input().split())
     * <p>
     * Выходные данные
     * Выведите два числа — значения первого и второго членов этой последовательности.
     *
     * @param elementsInSequence - кол-во элементов в последовательности
     * @param beforeLast         - аN-1
     * @param last               - aN
     * @return массив, содержащий первый и второй элементы последовательности
     */
    public int[] getFirstAndSecond(int elementsInSequence, int beforeLast, int last) {
        int first = beforeLast;
        int second = last;
        System.out.println("first -> " + first + ", second -> " + second);
        for (int i = elementsInSequence; i > 1; i--) {
            int firstValue = first;
            first = second - first;
            second = firstValue;
            System.out.println("first -> " + first + ", second -> " + second);
        }
        System.out.println("first -> " + first + ", second -> " + second);
        return new int[]{first, second};
    }
}
