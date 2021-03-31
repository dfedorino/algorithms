package com.dfedorino.rtasks.yandex_contest;

import java.util.HashMap;
import java.util.Map;

public class Anagrams {
    /**
     *
     * @param first
     * @param second
     * @return
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
