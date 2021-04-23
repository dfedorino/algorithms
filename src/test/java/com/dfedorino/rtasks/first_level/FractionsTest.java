package com.dfedorino.rtasks.first_level;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FractionsTest {
    private final Fractions fractions = new Fractions();

    @Test
    public void testReduce_PositiveNumAndDenomWithCommonDivisor_Reduced() {
        Fraction actualReducedFraction = fractions.reduce(new Fraction(3, 6));
        assertThat(actualReducedFraction).isEqualTo(new Fraction(1, 2));
    }

    @Test
    public void testReduce_ZeroNumAndPositiveDenomWithCommonDivisor_Reduced() {
        Fraction actualReducedFraction = fractions.reduce(new Fraction(0, 6));
        assertThat(actualReducedFraction).isEqualTo(new Fraction(0, 1));
    }

    @Test
    public void testReduce_NegativeNumAndPositiveDenomWithoutCommonDivisor_SameFraction() {
        Fraction actualReducedFraction = fractions.reduce(new Fraction(-2, 5));
        assertThat(actualReducedFraction).isEqualTo(new Fraction(-2, 5));
    }
}