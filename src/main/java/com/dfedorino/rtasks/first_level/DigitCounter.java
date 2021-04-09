package com.dfedorino.rtasks.first_level;

public class DigitCounter {
    public int[] countDigits(int[] array) {
        int[] digits = new int[9];
        for (int number : array) {
            if (number == 0) break;
            digits[number - 1]++;
        }
        return digits;
    }
}
