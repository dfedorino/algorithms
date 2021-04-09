package com.dfedorino.rtasks.first_level;

import java.util.HashSet;
import java.util.Set;

public class TwoLettersFinder {
    /**
     * Дана строка. Известно, что она содержит ровно две одинаковые буквы. Найдите эти буквы.
     * Гарантируется, что повторяются буквы только одного вида.
     *
     * Ваше решение должно содержать только один проход по строке.
     *
     * Входные данные
     * На вход подается 1 строка, состоящая только из латинских букв.
     *
     * Выходные данные
     * Необходимо вывести  букву, которая встречается в строке дважды.
     *
     * @param letters - строка, содержащая буквы, две из которых одинаковые
     * @return повторяющийся символ
     */
    public char findDuplicateLetter(String letters) {
        Set<Character> uniqueLetters = new HashSet<>();
        for (int letterIndex = 0; letterIndex < letters.length(); letterIndex++) {
            char currentCharacter = letters.charAt(letterIndex);
            boolean isUnique = uniqueLetters.add(currentCharacter);
            if (!isUnique) return currentCharacter;
        }
        throw new RuntimeException("No duplicates");
    }
}
