package com.dfedorino.rtasks.second_level;

public class GCDRecursive extends Algorithm<Long, Integer> {
    @Override
    public Integer outputFor(Long... input) {
        long first = input[0];
        long second = input[1];
        if (second == 0) {
            return (int) first;
        } else {
            return outputFor(second, (first % second));
        }
    }
}
