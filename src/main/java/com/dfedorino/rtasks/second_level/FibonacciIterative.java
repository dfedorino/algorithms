package com.dfedorino.rtasks.second_level;

public class FibonacciIterative extends Algorithm<Integer, Integer> {
    @Override
    public Integer outputFor(Integer input) {
        int fibOfBeforePrevious = -1;
        int fibOfPrevious = 1;
        int fibOfCurrent = 0;
        for (int currentNumber = 0; currentNumber <= input; currentNumber++) {
            fibOfCurrent = fibOfPrevious + fibOfBeforePrevious;
            int fibOfPreviousCopy = fibOfPrevious;
            fibOfPrevious = fibOfCurrent;
            fibOfBeforePrevious = fibOfPreviousCopy;
        }
        return fibOfCurrent;
    }
}
