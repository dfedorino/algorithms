package com.dfedorino.rtasks.second_level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseComponentGenerator {
    /**
     * Дано натуральное число N. Рассмотрим его разбиение на различные натуральные слагаемые.
     * Два разбиения, отличающихся только порядком слагаемых, будем считать за одно, поэтому
     * можно считать, что слагаемые в разбиении упорядочены по невозрастанию.
     * <p>
     * Входные данные
     * Задано единственное число N. (N ≤ 40)
     * <p>
     * Выходные данные
     * Необходимо вывести все разбиения числа N на различные натуральные слагаемые в обратном
     * лексикографическом порядке.
     *
     * @param number - единственное число N. (N ≤ 40)
     * @return список разбиений числа N на различные натуральные слагаемые в обратном
     * лексикографическом порядке.
     */
    public List<String> generateComponentsOf(int number) {
        List<String> results = new ArrayList<>();
        for (int length = 1; length <= number; length++) {
            int[] components = new int[length];
            fillResultsWithComponents(number, number, number, 0, components, results);
        }
        return results;
    }

    private void fillResultsWithComponents(
            int number,
            int remainingSum,
            int previousComponent,
            int index,
            int[] components,
            List<String> results
    ) {
        if (index == components.length) {
            System.out.println("Current combination -> " + Arrays.toString(components));
            int sum = Arrays.stream(components).sum();
            if (sum == number) {
                results.add(Arrays.stream(components).mapToObj(String::valueOf).reduce("", String::concat));
            }
        } else {
            int maxValue = Math.min(previousComponent, remainingSum - (components.length - index - 1));
            int minValue = remainingSum / (components.length - index);
            for (int component = maxValue; component >= minValue; component--) {
                components[index] = component;
                fillResultsWithComponents(number, remainingSum - component, component,index + 1, components, results);
            }
        }
    }
}