package com.dfedorino.rtasks.first_level;

public class DigitCounter {
    /**
     * На вход программе подается последовательность чисел от 1 до 9, заканчивающаяся нулем. Всего будет введено не
     * более 100_000 чисел. Подсчитайте в этой последовательности количество единиц, количество двоек, количество
     * троек и т.д. и выдайте результат. В выходных данных всегда должно быть 9 чисел.
     *
     * @param array - последовательность чисел от 1 до 9, заканчивающаяся нулем
     * @return
     */
    public int[] countDigits(int[] array) {
        int[] digits = new int[9];
        for (int number : array) {
            if (number == 0) {
                break;
            }
            digits[number - 1]++;
        }
        return digits;
    }
}
