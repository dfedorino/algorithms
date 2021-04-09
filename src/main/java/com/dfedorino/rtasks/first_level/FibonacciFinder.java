package com.dfedorino.rtasks.first_level;

public class FibonacciFinder {
    /**
     * F1 = F2 = 1, Fn = Fn-1 + Fn-2, при n > 2
     *
     * Входные данные
     * В единственной строке входных данных записано натуральное число n (1 ≤ n ≤ 45).
     *
     * Выходные данные
     * Вывести одно число Fn
     *
     * @param number - число n
     * @return - число Fn
     */
    public int getFibOf(int number) {
        if (number < 3) return 1;
        int previousFib = 1;
        int beforePreviousFib = 1;
        for (int i = 3; i <= number; i++) {
            if (i == number) return previousFib + beforePreviousFib;
            int temp = beforePreviousFib;
            beforePreviousFib = previousFib;
            previousFib = previousFib + temp;
        }
        throw new RuntimeException();
    }
}
