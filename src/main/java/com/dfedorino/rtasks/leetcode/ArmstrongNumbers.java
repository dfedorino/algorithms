package com.dfedorino.rtasks.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArmstrongNumbers {
    long[][] powers = new long[10 + 1][19 + 1];

    public ArmstrongNumbers() {
        for (int i = 0; i < powers.length; i++) {
            for (int j = 0; j < powers[i].length; j++) {
                if (j == 19 & i == 10) {
                    powers[i][j] = Long.MAX_VALUE;
                } else {
                    powers[i][j] = (long) Math.pow(i, j);
                }
            }
        }
    }

    public void fillListWithArmstrongNumbersUntil(long number, List<Long> armstrongNumbers) {
        String numberString = String.valueOf(number);
        for (int length = 1; length <= numberString.length(); length++) {
            long maxSum = powers[10][length];
            long minSum = powers[10][length - 1];
            int[] digits = new int[length];
            fillListWithArmstrongNumbers(0, 9, maxSum, minSum, digits, armstrongNumbers);
        }
    }

    // partial solution
    public void fillListWithArmstrongNumbers(int index, int previousDigit, long maxSum, long minSum, int[] digits, List<Long> armstrongNumbers) {
        if (index == digits.length) {
            long digitSum = 0;
            for (int digit : digits) {
                digitSum += powers[digit][digits.length];
            }
            String digitSumString = String.valueOf(digitSum);
            StringBuilder digitString = new StringBuilder();
            for (int digit : digits) {
                digitString.append(digit);
            }
            if (areAnagrams(digitSumString, digitString.toString())) {
                armstrongNumbers.add(digitSum);
            }
        } else {
            int maxDigitForCurrentIndex = (int) Math.min(previousDigit, Math.ceil(Math.pow(maxSum, 1.0/digits.length)));
            int minDigitForCurrentIndex = (int) Math.round(Math.pow(minSum, 1.0/digits.length));
            for (int digit = maxDigitForCurrentIndex; digit >= minDigitForCurrentIndex; digit--) {
                digits[index] = digit;
                long nextMaxSum = maxSum - (powers[digit][digits.length]);
                long nextMinSum = minSum - (powers[digit][digits.length]);
                fillListWithArmstrongNumbers(index + 1, digit, nextMaxSum, nextMinSum, digits, armstrongNumbers);
            }
        }
    }

    private boolean areAnagrams(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }
        Map<Character, Integer> firstChars = new HashMap<>();
        Map<Character, Integer> secondChars = new HashMap<>();
        for (int i = 0; i < first.length(); i++) {
            char firstChar = first.charAt(i);
            char secondChar = second.charAt(i);
            firstChars.putIfAbsent(firstChar, 0);
            secondChars.putIfAbsent(secondChar, 0);
            firstChars.computeIfPresent(firstChar, (character, count) -> ++count);
            secondChars.computeIfPresent(secondChar, (character, count) -> ++count);
        }
        return firstChars.equals(secondChars);
    }
}
