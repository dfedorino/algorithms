package com.dfedorino.rtasks.second_level;

import java.math.BigInteger;

public class DynamicFibonacci {
    /**
     * F1 = F2 = 1, Fn = Fn-1 + Fn-2, при n > 2
     *
     * Входные данные
     * В единственной строке входных данных записано натуральное число n (1 ≤ n ≤ 45).
     *
     * Выходные данные
     * Вывести одно число Fn
     *
     * @param number - натуральное число n (1 ≤ n ≤ 45).
     * @return число Fn.
     */
    public BigInteger getFibonacciNumberFor(int number) {
        // 1.  разбиваем задачу на подзадачи меньше:
        // 1.1 каждое число Фибоначчи по индексу i равно сумме числа Фибоначчи [i - 1]
        //     и числа Фибоначчи [i - 2]
        // 2.  чем может закончиться каждое из решений подзадач:
        // 2.2 при i == 0, число Фибонначи будет равно 0
        // 2.3 при i == 1, число Фибонначи будет равно 1
        BigInteger[] fibonacciNumbers = new BigInteger[number + 1];
        fibonacciNumbers[0] = BigInteger.ZERO;
        for (int fibonacciNumberIndex = 1; fibonacciNumberIndex < fibonacciNumbers.length; fibonacciNumberIndex++) {
            if (fibonacciNumberIndex == 1) {
                fibonacciNumbers[1] = BigInteger.valueOf(1);
            } else {
                BigInteger previous = fibonacciNumbers[fibonacciNumberIndex - 1];
                BigInteger beforePrevious = fibonacciNumbers[fibonacciNumberIndex - 2];
                fibonacciNumbers[fibonacciNumberIndex] = previous.add(beforePrevious);
            }
        }
        return fibonacciNumbers[number];
    }
}
