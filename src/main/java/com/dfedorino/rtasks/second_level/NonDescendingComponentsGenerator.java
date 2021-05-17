package com.dfedorino.rtasks.second_level;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NonDescendingComponentsGenerator {
    /**
     * Дано натуральное число N. Рассмотрим его разбиение на различные натуральные слагаемые.
     * Два разбиения, отличающихся только порядком слагаемых,  будем считать за одно, поэтому
     * можно считать, что слагаемые в разбиении упорядочены по неубыванию.
     * <p>
     * Входные данные
     * Задано единственное число N. (N ≤ 40)
     * <p>
     * Выходные данные
     * Необходимо вывести все разбиения числа N на различные натуральные слагаемые. Порядок
     * вывода самих разбиений – лексикографический.
     *
     * @param number - число N. (N ≤ 40)
     * @return список всех разбиений числа N на различные натуральные слагаемые
     */
    public List<String> generateComponentsOf(int number) {
        return generateComponentsOf(number, new HashMap<>());
    }

    /**
     * Рекурсивно вычисляет все комбинации слагаемых заданного числа.
     * При данном числе number > 1 алгоритм следующий:
     * <p>
     * 1. создается список, в который будут складываться результаты комбинирования слагаемого candidate
     * и слагаемых числа difference, которое является суммой слагаемых без учета candidate:
     * <p>
     * number -> 3,
     * candidate -> 1,
     * difference -> 2,
     * componentsOfDifference -> [11, 2],
     * currentComponents -> [111, 12]
     * <p>
     * number -> 3,
     * candidate -> 2,
     * difference -> 1,
     * componentsOfDifference -> [1],
     * currentComponents -> [21]
     * <p>
     * таким образом слагаемое candidate будет комбинироваться только со слагаемыми, которые в сумме
     * будут давать number. Список слагаемых difference либо берется из мапы cache по ключу difference,
     * если этот список уже был вычислен раннее или вычисляется один раз и кладется в cache;
     * <p>
     * 2. после получения слагаемых числа difference производится отбор слагаемых, чтобы первая цифра слагаемого
     * числа difference была меньше или равна слагаемому candidate, чтобы избежать дубликатов вида 12 и 21;
     * <p>
     * 3. полученная комбинация заносится в список currentNumberComponents, в который по окончании вносится само
     * число number.
     *
     * @param number - число N. (N ≤ 40)
     * @param cache  - мапа, в которую будут сохраняться списки комбинаций для чисел меньше N;
     * @return список всех разбиений числа N на различные натуральные слагаемые;
     */
    private List<String> generateComponentsOf(int number, Map<Integer, List<String>> cache) {
        if (number == 1) {
            return cache.computeIfAbsent(1, one -> List.of("1"));
        } else {
            List<String> currentNumberComponents = new ArrayList<>();
            for (int candidate = 1; candidate < number; candidate++) {
                int difference = number - candidate;
                List<String> componentsOfDifference = cache.computeIfAbsent(difference, this::generateComponentsOf);
                for (String component : componentsOfDifference) {
                    char firstDigitChar = component.charAt(0);
                    int firstDigit = Integer.parseInt(String.valueOf(firstDigitChar));
                    if (candidate <= firstDigit) {
                        currentNumberComponents.add(candidate + component);
                    }
                }
            }
            currentNumberComponents.add(number + "");
            return currentNumberComponents;
        }
    }
}
