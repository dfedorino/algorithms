package com.dfedorino.rtasks.first_level;

import java.util.Deque;
import java.util.LinkedList;

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
     *
     * На вход программы поступает набор больших латинских букв (не обязательно различных). Разрешается
     * переставлять буквы, а также удалять некоторые буквы. Требуется из данных букв по указанным
     * правилам составить палиндром наибольшей длины, а если таких палиндромов несколько, то выбрать
     * первый из них в алфавитном порядке.
     *
     * Входные данные
     * В первой строке входных данных содержится число N (1 <= N <= 100_000). Во второй строке задается
     * последовательность из N больших латинских букв (буквы записаны без пробелов).
     *
     * Выходные данные
     * В единственной строке выходных данных выдайте искомый палиндром.
     *
     * Группы тестов
     * 25 баллов — (1 ≤ N ≤ 10) .
     *
     * 25 баллов — (1 ≤ N ≤ 1 000 ) .
     *
     * 50 баллов — полные ограничения.
     * @param upperCaseLatinLetters - последовательность букв
     * @return - строка, содержащая самый первый палиндром
     */
    public String build(String upperCaseLatinLetters) {
        Deque<Character> palindrome = new LinkedList<>();
        int[] codePoints = new int[91];
        int maxCharCodePoint = -1;
        for (int charIndex = 0; charIndex < upperCaseLatinLetters.length(); charIndex++) {
            char currentCharacter = upperCaseLatinLetters.charAt(charIndex);
            codePoints[currentCharacter]++;
            maxCharCodePoint = maxCharCodePoint < currentCharacter ? currentCharacter : maxCharCodePoint;
        }
        for (int currentCodePoint = maxCharCodePoint; currentCodePoint >= 0; currentCodePoint--) {
            if (codePoints[currentCodePoint] != 0) {
                int timesToAdd;
                if (currentCodePoint == maxCharCodePoint) {
                    timesToAdd = codePoints[currentCodePoint];
                } else {
                    timesToAdd = codePoints[currentCodePoint] - (codePoints[currentCodePoint] % 2);
                }
                for (int j = 0; j < timesToAdd; j++) {
                    if (j % 2 == 0) {
                        palindrome.addLast((char) currentCodePoint);
                    } else {
                        palindrome.addFirst((char) currentCodePoint);
                    }
                }
            }
        }
        return palindrome.toString();
    }
}
