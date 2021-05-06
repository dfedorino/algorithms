package com.dfedorino.rtasks.second_level;

public class BracesIterative extends Algorithm<String, String> {
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

    public String outputFor(String s, int minElementsNumber) {
        StringBuilder result = new StringBuilder();
        int middleElementIndex = s.length() / 2;
        int minPartLeftBorderIndex = middleElementIndex - (minElementsNumber - 1);
        for (int i = 0; i < middleElementIndex + 1; i++) {
            result.append(s.charAt(i));
            if (i < minPartLeftBorderIndex) {
                result.append("(");
            }
        }
        for (int i = middleElementIndex + 1; i < s.length(); i++) {
            result.append(")").append(s.charAt(i));
        }
        return result.toString();
    }
}
