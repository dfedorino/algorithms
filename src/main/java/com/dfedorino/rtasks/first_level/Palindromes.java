package com.dfedorino.rtasks.first_level;

public class Palindromes {
    /**
     * Дана строка, состоящая из строчных латинских букв и пробелов. Проверьте, является ли она палиндромом
     * без учета пробелов (например, "аргентина манит негра").
     * <p>
     * Входные данные
     * На вход подается 1 строка длины не более 100, содержащая пробелы. Подряд может идти произвольное
     * число пробелов.
     * <p>
     * Выходные данные
     * Необходимо вывести yes, если данная строка является палиндромом, и no в противном случае.
     *
     * @param phrase - произвольная строка
     * @return true, если строка - палиндром, false в противном случае
     */
    public boolean isPalindrome(String phrase) {
        int leftCharIndex = 0;
        int rightCharIndex = phrase.length() - 1;
        while (leftCharIndex <= rightCharIndex) {
            char leftChar = phrase.charAt(leftCharIndex);
            char rightChar = phrase.charAt(rightCharIndex);
            if (leftChar == ' ') {
                leftCharIndex++;
                continue;
            }
            if (rightChar == ' ') {
                rightCharIndex--;
                continue;
            }
            if (leftChar != rightChar) {
                return false;
            } else {
                leftCharIndex++;
                rightCharIndex--;
            }
        }
        return true;
    }

    /**
     * Палиндром - это строка, которая читается одинаково как справа налево, так и слева направо.
     * <p>
     * На вход программы поступает набор больших латинских букв (не обязательно различных). Разрешается
     * переставлять буквы, а также удалять некоторые буквы. Требуется из данных букв по указанным
     * правилам составить палиндром наибольшей длины, а если таких палиндромов несколько, то выбрать
     * первый из них в алфавитном порядке.
     * <p>
     * Входные данные
     * В первой строке входных данных содержится число N (1 <= N <= 100_000). Во второй строке задается
     * последовательность из N больших латинских букв (буквы записаны без пробелов).
     * <p>
     * Выходные данные
     * В единственной строке выходных данных выдайте искомый палиндром.
     * <p>
     * Группы тестов
     * 25 баллов — (1 ≤ N ≤ 10) .
     * <p>
     * 25 баллов — (1 ≤ N ≤ 1 000 ) .
     * <p>
     * 50 баллов — полные ограничения.
     *
     * @param letters - последовательность букв
     * @return - строка, содержащая самый первый палиндром
     */
    public String build(String letters) {
        int[] letterCounters = countLetters(letters);
        StringBuilder palindromeLeftHalf = new StringBuilder();
        int palindromeMiddleCharIndex = -1;
        for (int charCodePoint = 0; charCodePoint < letterCounters.length; charCodePoint++) {
            int occurrences = letterCounters[charCodePoint];
            boolean isOddNumberOfOccurrences = occurrences % 2 != 0;
            int additionLimit = isOddNumberOfOccurrences ? occurrences : occurrences / 2;
            for (int timesToAdd = 0; timesToAdd < additionLimit; timesToAdd++) {
                palindromeLeftHalf.append((char) (charCodePoint + 'A'));
            }
            if (isOddNumberOfOccurrences) {
                palindromeMiddleCharIndex = charCodePoint;
                break;
            }
        }
        palindromeMiddleCharIndex = palindromeMiddleCharIndex >= 0 ? palindromeMiddleCharIndex : palindromeLeftHalf.length();
        return buildCompletePalindrome(palindromeMiddleCharIndex, palindromeLeftHalf);
    }

    private int[] countLetters(String letters) {
        int[] letterCounters = new int[26];
        for (int letterIndex = 0; letterIndex < letters.length(); letterIndex++) {
            char currentLetter = letters.charAt(letterIndex);
            letterCounters[currentLetter - 'A']++;
        }
        return letterCounters;
    }

    private String buildCompletePalindrome(int middleCharIndex, StringBuilder palindromeLeftHalf) {
        for (int rightHalfCharIndex = middleCharIndex - 1; rightHalfCharIndex >= 0; rightHalfCharIndex--) {
            palindromeLeftHalf.append(palindromeLeftHalf.charAt(rightHalfCharIndex));
        }
        return palindromeLeftHalf.toString();
    }
}
