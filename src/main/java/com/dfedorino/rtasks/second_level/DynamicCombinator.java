package com.dfedorino.rtasks.second_level;

public class DynamicCombinator {
    /**
     * Дано число. Рассмотрим все последовательностей из нулей и единиц.
     * Назовём последовательность хорошей, если в ней нигде не встречается две единицы подряд.
     * Требуется посчитать общее количество хороших последовательностей.
     *
     * @param length - длина комбинации
     * @return кол-во хороших комбинаций
     */
    public int getNumberOfCorrectCombinationsForLength(int length) {
        // 1.  разбиваем задачу на более мелкие аналогичные подзадачи:
        // 1.1 при length == 0 ответом будет 0
        //     при length == 1 ответом будет 2, [0] и [1];
        //     при length == 2 ответом будет 3, [0, 0], [0, 1], [1, 0];
        // 2.  на что может заканчиваться хорошая последовательность длины length > 2:
        //     [..., 0] or [..., 1]
        // 2.1 если последовательность заканчивается на 0, то перед ней может идти
        //     любая хорошая последовательность длины [length - 1];
        // 2.2 если последовательность заканчивается на 1, то перед ней может идти
        //     только 0, а до него - любая хорошая последовательность длины [length - 2];
        int[] goodCombinations = new int[length + 1];
        for (int combinationLength = 0; combinationLength < goodCombinations.length; combinationLength++) {
            switch (combinationLength) {
                case 0:
                    goodCombinations[0] = 0;
                    break;
                case 1:
                    goodCombinations[1] = 2;
                    break;
                case 2:
                    goodCombinations[2] = 3;
                    break;
                default:
                    int goodCombinationsOfPreviousLength = goodCombinations[combinationLength - 1];
                    int goodCombinationsOfBeforePreviousLength = goodCombinations[combinationLength - 2];
                    goodCombinations[combinationLength] = goodCombinationsOfPreviousLength + goodCombinationsOfBeforePreviousLength;
                    break;
            }
        }
        return goodCombinations[length];
    }
}
