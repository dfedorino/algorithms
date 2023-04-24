package com.dfedorino.rtasks.second_level;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PaidLadderTest {
    private final PaidLadder app = new PaidLadder();

    @Test
    public void testGetLeastSum_SimplestCaseLength0_0() {
        assertThat(app.getLeastSum(new int[]{})).isEqualTo(0);
    }

    @Test
    public void testGetLeastSum_SimplestCaseLength1_PriceOfLastStep() {
        assertThat(app.getLeastSum(new int[]{1})).isEqualTo(1);
    }

    @Test
    public void testGetLeastSum_SimplestCaseLength2_PriceOfLastStep() {
        assertThat(app.getLeastSum(new int[]{1, 2})).isEqualTo(2);
    }

    @Test
    public void testGetLeastSum_Length3_SumOfLastStepPriceAndLeastPriceOfPreviousTwo() {
        assertThat(app.getLeastSum(new int[]{1, 3, 1})).isEqualTo(2);
    }

    @Test
    public void testGetLeastSum_EvenLength_SumOfLastStepPriceAndLeastPriceOfPreviousThree() {
        assertThat(app.getLeastSum(new int[]{1, 2, 10, 2})).isEqualTo(4);
    }

    @Test
    public void testGetLeastSum_OddLength_SumOfLastStepPriceAndLeastPriceOfPreviousFour() {
        assertThat(app.getLeastSum(new int[]{1, 1, 1, 1, 1})).isEqualTo(3);
    }
}