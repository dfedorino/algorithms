package com.dfedorino.rtasks.leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CoinChangeTest {
    private final CoinChange app = new CoinChange();

    @Test
    public void testCoinChange_whenTestCase1_then3Coins() {
        assertThat(app.coinChange(new int[] {1, 2, 5}, 11)).isEqualTo(3);
    }

    @Test
    public void testCoinChange_whenTestCase2_thenNotEnoughCoins() {
        assertThat(app.coinChange(new int[] {2}, 3)).isEqualTo(-1);
    }

    @Test
    public void testCoinChange_whenAmountIs0_thenNoCoins() {
        assertThat(app.coinChange(new int[] {1}, 0)).isEqualTo(0);
    }

    @Test
    public void testCoinChange_whenOneCoin_thenTwoCoins() {
        assertThat(app.coinChange(new int[] {1}, 2)).isEqualTo(2);
    }

    @Test
    public void testCoinChange_whenTestCase5_thenOneCoin() {
        assertThat(app.coinChange(new int[] {1, 3, 5}, 5)).isEqualTo(1);
    }
}