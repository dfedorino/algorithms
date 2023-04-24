package com.dfedorino.rtasks.yandex_contest;

import java.util.HashMap;
import java.util.Map;

public class Anagrams {
    /**
     * Checks whether two strings are anagrams.
     * Strings considered to be anagrams if only the order of characters is different.
     *
     * @param first  - a string with latin characters
     * @param second - a string with latin characters
     * @return 1 if strings are anagrams, 0 otherwise
     */
    public int areAnagrams(String first, String second) {
        if (first.length() != second.length()) return 0;
        return countCharacters(first).equals(countCharacters(second)) ? 1 : 0;
    }

    private Map<Character, Integer> countCharacters(String string) {
        Map<Character, Integer> stringCharCounter = new HashMap<>();
        for (int charIndex = 0; charIndex < string.length(); charIndex++) {
            Character currentCharacter = string.charAt(charIndex);
            int value = stringCharCounter.getOrDefault(currentCharacter, 0);
            stringCharCounter.put(currentCharacter, ++value);
        }
        return stringCharCounter;
    }
}
