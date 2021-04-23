package com.dfedorino.rtasks.first_level;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GreatestCommonDivisorTest {
    private final GreatestCommonDivisor gcd = new GreatestCommonDivisor();

    @Test
    public void testFind_BIsMoreThanA_3() {
        assertThat(gcd.find(-9, 12)).isEqualTo(3);
    }

    @Test
    public void testFind_AIsMoreThanB_3() {
        assertThat(gcd.find(12, -9)).isEqualTo(3);
    }

    @Test
    public void testFind_BIsZero_A() {
        assertThat(gcd.find(12, 0)).isEqualTo(12);
    }

    @Test
    public void testFind_AIsZero_B() {
        assertThat(gcd.find(0, 12)).isEqualTo(12);
    }
}