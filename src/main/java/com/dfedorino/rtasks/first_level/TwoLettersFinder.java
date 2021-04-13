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

    public char findDuplicateLetterWithBooleanArray(String letters) {
        boolean[] upperCaseLetters = new boolean[26];
        boolean[] lowerCaseLetters = new boolean[26];
        int upperCaseLetterCodePointDifference = 65;
        int lowerCaseLetterCodePointDifference = 97;
        int indexInArray;
        for (int characterIndex = 0; characterIndex < letters.length(); characterIndex++) {
            char currentCharacter = letters.charAt(characterIndex);
            if (Character.isUpperCase(currentCharacter)) {
                indexInArray = currentCharacter - upperCaseLetterCodePointDifference;
                if (upperCaseLetters[indexInArray]) {
                    return currentCharacter;
                }
                upperCaseLetters[indexInArray] = true;
            } else if (Character.isLowerCase(currentCharacter)) {
                indexInArray = currentCharacter - lowerCaseLetterCodePointDifference;
                if (lowerCaseLetters[indexInArray]) {
                    return currentCharacter;
                }
                lowerCaseLetters[indexInArray] = true;
            }
        }
        throw new RuntimeException("No duplicates");
    }
}
