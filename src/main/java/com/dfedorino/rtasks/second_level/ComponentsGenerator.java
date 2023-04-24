package com.dfedorino.rtasks.second_level;

import java.util.ArrayList;
import java.util.List;

public class ComponentsGenerator {
    /**
     * Дано натуральное число N. Рассмотрим его разбиение на натуральные слагаемые.
     * Два разбиения, отличающихся только порядком слагаемых, будем считать за одно,
     * поэтому можно считать, что слагаемые в разбиении упорядочены по невозрастанию.
     *
     * Входные данные
     * Задано единственное число N. (N ≤ 40)
     *
     * Выходные данные
     * Необходимо вывести все разбиения числа N на натуральные слагаемые в лексикографическом порядке.
     *
     * Пример:
     * Входные данные: 5
     * Выходные данные:
     * 1 1 1 1 1
     * 2 1 1 1
     * 2 2 1
     * 3 1 1
     * 3 2
     * 4 1
     * 5
     *
     * @param number - число N. (N ≤ 40)
     * @return все разбиения числа N на натуральные слагаемые в лексикографическом порядке.
     */
    public List<String> generateComponentsOf(int number) {
        return generateComponentsOf(number, number);
    }

    public List<String> generateComponentsOf(int remainingSum, int maxValue) {
        if (remainingSum == 0) {
            return List.of("");
        } else {
            List<String> currentComponents = new ArrayList<>();
            for (int component = 1; component <= maxValue; component++) {
                remainingSum -= component;
                int maxValueForCurrentComponent = Math.min(component, remainingSum);
                List<String> previousComponents = generateComponentsOf(remainingSum, maxValueForCurrentComponent);
                remainingSum += component;
                for (String previousComponent : previousComponents) {
                    currentComponents.add(component + previousComponent);
                }
            }
            return currentComponents;
        }
    }
}
