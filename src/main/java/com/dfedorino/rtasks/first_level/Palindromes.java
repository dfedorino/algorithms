package com.dfedorino.rtasks.first_level;

public class Palindromes {
    /**
     * Дана строка, состоящая из строчных латинских букв и пробелов. Проверьте, является ли она палиндромом
     * без учета пробелов (например, "аргентина манит негра").
     *
     * Входные данные
     * На вход подается 1 строка длины не более 100, содержащая пробелы. Подряд может идти произвольное
     * число пробелов.
     *
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
            }
            else {
                leftCharIndex++;
                rightCharIndex--;
            }
        }
        return true;
    }
}
