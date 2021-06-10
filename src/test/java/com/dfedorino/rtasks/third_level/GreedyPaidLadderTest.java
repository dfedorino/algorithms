package com.dfedorino.rtasks.third_level;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class GreedyPaidLadderTest {
    private final GreedyPaidLadder app = new GreedyPaidLadder();

    @Test
    public void testGetLeastSum_SimplestCaseLength0_Zero() {
        assertThat(app.getLeastSum(new int[] {})).isEqualTo(0);
    }

    @Test
    public void testGetLeastSum_SimplestCaseLength1_LastStepPrice() {
        assertThat(app.getLeastSum(new int[] {1})).isEqualTo(1);
    }

    @Test
    public void testGetLeastSum_SimplestCaseLength2_LastStepPrice() {
        assertThat(app.getLeastSum(new int[] {1, 10})).isEqualTo(10);
    }

    @Test
    public void testGetLeastSum_Length3_LastStepPriceAndLeastPricesOfPreviousSteps() {
        assertThat(app.getLeastSum(new int[] {1, 10, 1})).isEqualTo(2);
    }

    @Test
    public void testGetLeastSum_Length4_LastStepPriceAndLeastPricesOfPreviousSteps() {
        /*
            this test shows that a greedy algorithm is not correct for the problem:
            1 < 2, then choose the 1st step
            2 < 10, then choose the 2nd step
            add price of the last step -> 5
            the problem can be correctly solved with a DP algorithm as one needs
            to check min sum starting both from the 1st step and from the 2nd step:
            least sum before reaching last step starting from 1st step -> 3
            least sum before reaching last step starting from 2nd step -> 2
            choose starting from 2nd step and add price of the last step -> 4
         */
        assertThat(app.getLeastSum(new int[] {1, 2, 10, 2})).isEqualTo(5);
    }
}