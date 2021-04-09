package com.dfedorino.rtasks.first_level;

import java.util.Arrays;
import java.util.Comparator;

public class LongestWordFinder {
    /**
     * Дана строка, содержащая пробелы. Найдите в ней самое длинное слово, выведите  это слово и его длину.
     * Если таких слов несколько, выведите первое из них.
     *
     * Входные данные
     * Задана одна строка, содержащая пробелы. Слова разделены ровно одним пробелом. Пробелы в начале и
     * конце строки допускаются.
     *
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
}
