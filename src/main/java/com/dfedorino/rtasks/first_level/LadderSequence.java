package com.dfedorino.rtasks.first_level;

import java.util.Deque;
import java.util.LinkedList;

public class LadderSequence {
    public Deque<Integer> build(int[] array) {
        int maxNumber = 0;
        int[] numberCounter = new int[5000];
        for (int number : array) {
            maxNumber = Math.max(number, maxNumber);
            numberCounter[number - 1]++;
        }
        return collectNumbersIntoLadder(numberCounter, maxNumber - 1);
    }

    private Deque<Integer> collectNumbersIntoLadder(int[] numberCounter, int maxIndex) {
        Deque<Integer> ladder = new LinkedList<>();
        for (int numberIndex = maxIndex; numberIndex >= 0; numberIndex--) {
            int currentNumber = numberIndex + 1;
            if (numberIndex == maxIndex) {
                ladder.add(currentNumber);
            } else if (numberCounter[numberIndex] != 0) {
                int timesToAdd = numberCounter[numberIndex] - (numberCounter[numberIndex] % 2);
                for (int i = 0; i < timesToAdd; i++) {
                    if (i % 2 == 0) {
                        ladder.addLast(currentNumber);
                    } else {
                        ladder.addFirst(currentNumber);
                    }
                }
            }
        }
        return ladder;
    }
}
