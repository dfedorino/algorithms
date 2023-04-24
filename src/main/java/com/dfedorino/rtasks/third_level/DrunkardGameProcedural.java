package com.dfedorino.rtasks.third_level;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class DrunkardGameProcedural implements DrunkardGame {

    @Override
    public String play(int[] f, int[] s) {
        Queue<Integer> first = Arrays.stream(f).collect(ArrayDeque::new, ArrayDeque::offer, ArrayDeque::addAll);
        Queue<Integer> second = Arrays.stream(s).collect(ArrayDeque::new, ArrayDeque::offer, ArrayDeque::addAll);
        Integer firstPlayerCard = first.poll();
        Integer secondPlayerCard = second.poll();
        int count = 0;
        while (firstPlayerCard != null && secondPlayerCard != null) {
            if (count == 1_000_000) {
                return "botva";
            }
            boolean firstWins;
            if (firstPlayerCard == 9 & secondPlayerCard == 0) {
                firstWins = false;
            } else if (firstPlayerCard == 0 & secondPlayerCard == 9) {
                firstWins = true;
            } else {
                firstWins = firstPlayerCard > secondPlayerCard;
            }
            if (firstWins) {
                first.offer(firstPlayerCard);
                first.offer(secondPlayerCard);
            } else {
                second.offer(firstPlayerCard);
                second.offer(secondPlayerCard);
            }
            count++;

            firstPlayerCard = first.poll();
            secondPlayerCard = second.poll();
        }
        String winner = first.size() != 0 ? "first" : "second";
        return winner + " " + count;
    }
}
