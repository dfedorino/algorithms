package com.dfedorino.rtasks.second_level;

public class BracesRecursive extends Algorithm<String, String> {
    /**
     * Дана строка, содержащая только английские буквы (большие и маленькие).
     * Добавить открывающиеся и закрывающиеся скобки по следующему образцу:
     * example -> e(x(a(m)p)l)e До середины добавляются открывающиеся скобки,
     * после середины – закрывающиеся. В случае, когда длина строки четна,
     * в скобках, расположенных в середине, должно быть 2 символа:
     * card -> c(ar)d, но не c(a()r)d.
     * <p>
     * Входные данные
     * Вводится строка ненулевой длины. Известно также, что длина строки не
     * превышает 1000 знаков.
     * <p>
     * Выходные данные
     * Вывести строку, которая получится после добавления скобок.
     *
     * @param input - строка без скобок
     * @return - строка со скобками
     */
    @Override
    public String outputFor(String input) {
        return input.length() % 2 == 0 ? outputFor(input, 2) : outputFor(input, 1);
    }

    private String outputFor(String s, int smallestAmountOfChars) {
        int stringLength = s.length();
        if (stringLength == smallestAmountOfChars) {
            return s;
        } else {
            char beforeLeftBrace = s.charAt(0);
            char afterRightBrace = s.charAt(s.length() - 1);
            String substringBetweenBraces = outputFor(s.substring(1, s.length() - 1), smallestAmountOfChars);
            return beforeLeftBrace + "(" + substringBetweenBraces + ")" + afterRightBrace;
        }
    }
}
