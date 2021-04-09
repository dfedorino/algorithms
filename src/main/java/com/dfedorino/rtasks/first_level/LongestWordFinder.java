package com.dfedorino.rtasks.first_level;

import java.util.Arrays;
import java.util.Comparator;

public class LongestWordFinder {
    public String findLongestWord(String words) {
        String anyWhitespace = "\\s";
        String longest = Arrays.stream(words.split(anyWhitespace))
                .max(Comparator.comparingInt(String::length))
                .orElse("");
        return longest + System.lineSeparator() + longest.length();
    }
}
