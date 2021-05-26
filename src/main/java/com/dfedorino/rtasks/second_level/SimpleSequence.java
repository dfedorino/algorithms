package com.dfedorino.rtasks.second_level;

import java.math.BigInteger;

public class SimpleSequence {
    /**
     * Вычислите n-й член последовательности, заданной формулами:
     * <p>
     * a2n = an + an-1,
     * a2n+1 = an – an-1,
     * a0 = a1 = 1.
     * Входные данные
     * Вводится одно натуральное число n (1 ≤ n ≤ 1000).
     * <p>
     * Выходные данные
     * Вывести одно число an.
     *
     * @param index - натуральное число n (1 ≤ n ≤ 1000).
     * @return число a по индексу n
     */
    public BigInteger getTermOfIndex(int index) {
        // 1.  разбиваем задачу на подзадачи меньше:
        // 1.1 каждое четное число последовательности - это сумма двух предыдущих, каждое нечетчное - их разность;
        // 2.  каковы самые маленькие входные данные для вычисления простейшей подзадачи:
        // 2.1 a0 == 1 и a1 == 1
        BigInteger[] sequence = new BigInteger[index + 1];
        sequence[0] = BigInteger.ONE;
        for (int termIndex = 1; termIndex < sequence.length; termIndex++) {
            if (termIndex == 1) {
                sequence[1] = BigInteger.ONE;
            } else {
                BigInteger previous = sequence[termIndex - 1];
                BigInteger beforePrevious = sequence[termIndex - 2];
                if (termIndex % 2 == 0) {
                    sequence[termIndex] = previous.add(beforePrevious);
                } else {
                    sequence[termIndex] = previous.subtract(beforePrevious);
                }
            }
        }
        return sequence[index];
    }
}
