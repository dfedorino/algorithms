package com.dfedorino.rtasks.second_level;

public class GCDIterative extends Algorithm<Long, Integer> {
    @Override
    public Integer outputFor(Long... input) {
        long first = input[0];
        long second = input[1];
        while (second != 0) {
            long firstValue = first;
            first = second;
            second = firstValue % second;
        }
        return (int) first;
    }
}
