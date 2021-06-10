package com.dfedorino.rtasks.third_level;

public class GreedyPaidLadder {
    public int getLeastSum(int[] prices) {
        if (prices.length <= 1) {
            return prices.length == 0 ? 0 : prices[0];
        }
        int leastSum = 0;
        for (int nextStep = 0; nextStep < prices.length; /* update is inside the loop */) {
            if (nextStep + 1 == prices.length - 1) {
                leastSum += prices[nextStep + 1];
                break;
            }
            leastSum += prices[nextStep] < prices[nextStep + 1] ? prices[nextStep++] : prices[++nextStep];
        }
        return leastSum;
    }
}
