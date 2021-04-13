package com.dfedorino.rtasks.first_level;

import java.util.Arrays;
import java.util.Comparator;

public class LongestWordFinder {
    /**
     * Дана строка, содержащая пробелы. Найдите в ней самое длинное слово, выведите  это слово и его длину.
     * Если таких слов несколько, выведите первое из них.
     * <p>
     * Входные данные
     * Задана одна строка, содержащая пробелы. Слова разделены ровно одним пробелом. Пробелы в начале и
     * конце строки допускаются.
     * <p>
     * Выходные данные
     * Необходимо вывести самое длинное слово в строке и его длину.
     *
     * @param words - строка, содержащая слова, разделенные пробелом
     * @return - строка, содержащая самое длинное слово и его длину
     */
    public String findLongestWord(String words) {
        String anyWhitespace = "\\s";
        String longest = Arrays.stream(words.split(anyWhitespace))
                .max(Comparator.comparingInt(String::length))
                .orElse("");
        return longest + System.lineSeparator() + longest.length();
    }

    public String findLongestWordZeroSpaceComplexity(String words) {
        int maxLength = 0;
        int currentWordLength = 0;
        int maxWordFirstCharacterIndex = 0;
        int currentWordFirstCharacterIndex = 0;
        boolean isFirstCharacterAfterWhiteSpace = true;
        for (int currentCharacterIndex = 0; currentCharacterIndex < words.length(); currentCharacterIndex++) {
            char currentCharacter = words.charAt(currentCharacterIndex);
            if (Character.isWhitespace(currentCharacter)) {
                if (currentWordLength > maxLength) {
                    maxLength = currentWordLength;
                    maxWordFirstCharacterIndex = currentWordFirstCharacterIndex;
                }
                isFirstCharacterAfterWhiteSpace = true;
                currentWordLength = 0;
            } else {
                if (isFirstCharacterAfterWhiteSpace) {
                    currentWordFirstCharacterIndex = currentCharacterIndex;
                    isFirstCharacterAfterWhiteSpace = false;
                }
                currentWordLength++;
            }
        }
        return words.substring(maxWordFirstCharacterIndex, maxWordFirstCharacterIndex + maxLength) +
                System.lineSeparator() +
                maxLength;
    }
}
