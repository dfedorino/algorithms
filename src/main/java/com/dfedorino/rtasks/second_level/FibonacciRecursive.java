package com.dfedorino.rtasks.second_level;

public class FibonacciRecursive extends Algorithm<Integer, Integer> {
    @Override
    public Integer outputFor(Integer input) {
        if (input == 0) {
            return 0;
        } else if (input == 1) {
            return 1;
        } else {
            return outputFor(input - 1) + outputFor(input - 2);
        }
    }
}
