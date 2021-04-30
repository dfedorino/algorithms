package com.dfedorino.rtasks.second_level;

public class AbacabaRecursive extends Algorithm<Integer, String> {
    private final String[] letters = {"A", "B", "C", "D", "E", "F"};
    @Override
    public String outputFor(Integer input) {
        if (input == 1) {
            return letters[0];
        } else {
            return outputFor(input - 1) + letters[input - 1] + outputFor(input - 1);
        }
    }
}
