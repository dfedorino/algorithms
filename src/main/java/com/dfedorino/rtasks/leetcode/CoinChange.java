package com.dfedorino.rtasks.leetcode;

import java.util.Arrays;

public class CoinChange {
    /**
     * You are given an integer array coins representing coins of different denominations and
     * an integer amount representing a total amount of money.
     * <p>
     * Return the fewest number of coins that you need to make up that amount.
     * If that amount of money cannot be made up by any combination of the coins, return -1.
     * <p>
     * You may assume that you have an infinite number of each kind of coin.
     *
     * @param coins 1 <= coins.length <= 12
     * @param amount 0 <= amount <= 10^4
     * @return the fewest number of coins that you need to make up that amount
     */

    // partial solution
    public int coinChange(int[] coins, int amount) {
        int[] leastCoins = new int[amount + 1];
        int previousCoins = 0;
        int leastCoinsIndex = 0;
        coinChange(amount, coins, leastCoins, previousCoins, leastCoinsIndex);
        System.out.println(">> " + Arrays.toString(leastCoins));
        return leastCoins[amount];
    }

    private void coinChange(int remainder, int[] coins, int[] leastCoins, int previousCoins, int leastCoinsIndex) {
        if (leastCoinsIndex != leastCoins.length) {
            int bestCoin = coins[0];
            int bestCoinAmount = remainder / bestCoin;
            for (int i = 1; i < coins.length; i++) {
                int currentCoinAmount = remainder / coins[i];
                if (currentCoinAmount < bestCoinAmount) {
                    if (coins[i] <= remainder) {
                        bestCoinAmount = currentCoinAmount;
                        bestCoin = coins[i];
                    }
                }
            }
            leastCoins[leastCoinsIndex] = previousCoins + bestCoinAmount;
            remainder -= bestCoin * bestCoinAmount;
            coinChange(remainder, coins, leastCoins, previousCoins + bestCoinAmount, leastCoinsIndex + 1);
        } else {
            if (remainder != 0) {
                leastCoins[leastCoinsIndex - 1] = -1;
            }
        }
    }
}
