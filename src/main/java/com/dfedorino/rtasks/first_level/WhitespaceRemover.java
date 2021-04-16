package com.dfedorino.rtasks.first_level;

public class WhitespaceRemover {
    /**
     * Дана строка, Вам требуется преобразовать все идущие подряд пробелы в один.
     *
     * Входные данные
     * Длина строки не превосходит 1000.
     *
     * Выходные данные
     * Выведите измененную строку.
     *
     * @param s - строка
     * @return строка без дублирующихся пробелов
     */
    public String removeRedundant(String s) {
        StringBuilder result = new StringBuilder();
        boolean isRedundantWhitespace = false;
        for (int charIndex = 0; charIndex < s.length(); charIndex++) {
            char currentChar = s.charAt(charIndex);
            if (Character.isWhitespace(currentChar)) {
                if (!isRedundantWhitespace) {
                    result.append(currentChar);
                    isRedundantWhitespace = true;
                }
            } else {
                result.append(currentChar);
                isRedundantWhitespace = false;
            }
        }
        return result.toString();
    }
}
