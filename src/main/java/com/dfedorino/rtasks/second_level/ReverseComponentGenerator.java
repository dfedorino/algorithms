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
        List<String> combinations = new ArrayList<>();
        for (int length = 1; length < (number + 1); length++) {
            int[] combinationHolder = new int[length];
            int seed = number - (length - 1);
            generateComponentsOf(0, seed, number, combinationHolder, combinations);
        }
        return combinations;
    }

    /**
     * Принимает на входе массив чисел combinationHolder, по значениям которого будет производиться
     * рекурсивный перебор. Для числа 5 начальная комбинация выглядит следующим образом:
     * currentIndex = 0;
     * combinationHolder = {0, 0, 0, 0, 0};
     * так как currentIndex не равен 5 (максимальная длина одной комбинации), то
     * 1. присваиваем в previousCandidate число, равное предыдущему кандидату (для первого вызова это number):
     *    combinationHolder = {5, 0, 0, 0, 0};
     * 2. рекурсивно вызываем метод для индекса 1, получаем combinationHolder = {5, 5, 0, 0, 0}
     * 3. рекурсивно вызываем метод, пока currentIndex не будет равен длине массива combinationHolder;
     * 4. как только выполняется условие выше, проверяем, является ли сумма полученной комбинации чисел
     *    равной number, если да, то превращаем комбинацию в строку и сохраняем в combination. Самой первой
     *    комбинацией будет {5, 5, 5, 5, 5}, поэтому возвращаемся в вызов метода, где уменьшаем значение, т.е.
     *    следующая комбинация для проверки будет {5, 5, 5, 5, 4} и так далее, пока не будет получена комбинация
     *    {1, 1, 1, 1, 1}, удовлетворяющая условию;
     *
     * @param currentIndex - 1 <= index <= combinationHolder.length, используется для того, чтобы
     * @param previousCandidate - 1 <= previousCandidate < number, предыдущее значение в массиве combinationHolder
     * @param number - 1 <= number <= 40, данное число N
     * @param combinationHolder - массив комбинаций слагаемых
     * @param combinations - список строк всех комбинаций слагаемых, которые равны N
     */
    private void generateComponentsOf(
            int currentIndex,
            int previousCandidate,
            int number,
            int[] combinationHolder,
            List<String> combinations
    ) {
        if (currentIndex == combinationHolder.length) {
            System.out.println(Arrays.toString(combinationHolder));
            if (Arrays.stream(combinationHolder).sum() == number) {
                String currentCombination = Arrays.stream(combinationHolder)
                        .mapToObj(String::valueOf)
                        .reduce("", String::concat);
                combinations.add(currentCombination);
            }
        } else {
            for (int candidate = previousCandidate; candidate > 0; candidate--) {
                combinationHolder[currentIndex] = candidate;
                generateComponentsOf(currentIndex + 1, Math.min(candidate, number - candidate)  , number, combinationHolder, combinations);
            }
        }
    }
}