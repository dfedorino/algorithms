package com.dfedorino.rtasks.second_level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsBuilder {
    /**
     * По данному числу N выведите все перестановки чисел от 1 до N в лексикографическом порядке.
     * Входные данные
     * Задано 1 число: N (0<N<10).
     * <p>
     * Выходные данные
     * Необходимо вывести все перестановки чисел от 1 до N в лексикографическом порядке.
     * Перестановки выводятся по одной в строке, числа в перестановке выводятся без пробелов.
     *
     * @param maxValue - число N
     * @return список строк, которые являются всеми перестановками чисел от 1 до N включительно в
     * лексикографическом порядке
     */
    public List<String> getPermutationsUntil(int maxValue) {
        List<String> permutations = new ArrayList<>();
        int[] combination = new int[maxValue];
        boolean[] was = new boolean[maxValue + 1];
        getPermutations(maxValue, 0, combination, permutations, was);
        return permutations;
    }

    private void getPermutations(int maxValue, int digitIndex, int[] combination, List<String> permutations, boolean[] was) {
        if (digitIndex == maxValue) {
            String combinationString = Arrays.stream(combination)
                    .mapToObj(String::valueOf)
                    .reduce("", String::concat);
            permutations.add(combinationString);
        } else {
            for (int digit = 1; digit < maxValue + 1; digit++) {
                if (!was[digit]) {
                    combination[digitIndex] = digit;
                    was[digit] = true;
                    getPermutations(maxValue, digitIndex + 1, combination, permutations, was);
                    was[digit] = false;
                }
            }
        }
    }
}
