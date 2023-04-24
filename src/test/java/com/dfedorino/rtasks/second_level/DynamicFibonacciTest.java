package com.dfedorino.rtasks.second_level;

import org.testng.annotations.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

public class DynamicFibonacciTest {
    private final DynamicFibonacci app = new DynamicFibonacci();

    @Test
    public void testGetFibonacciNumberFor_0_0() {
        assertThat(app.getFibonacciNumberFor(0)).isEqualTo(BigInteger.ZERO);
    }

    @Test
    public void testGetFibonacciNumberFor_1_1() {
        assertThat(app.getFibonacciNumberFor(1)).isEqualTo(BigInteger.ONE);
    }

    @Test
    public void testGetFibonacciNumberFor_2_1() {
        assertThat(app.getFibonacciNumberFor(2)).isEqualTo(BigInteger.ONE);
    }

    @Test
    public void testGetFibonacciNumberFor_45_1134903170() {
        assertThat(app.getFibonacciNumberFor(45)).isEqualTo(BigInteger.valueOf(1_134_903_170));
    }

    @Test
    public void testGetFibonacciNumberFor_1000_NumberWith209Digits() {
        String actualTerm = app.getFibonacciNumberFor(1000).toString();
        String expectedTerm =
                "4346655768693745643568852767504062580256466051737178040248172908953655541794905189040" +
                "3879840079255169295922593080322634775209689623239873322471161642996440906533187938298" +
                "969649928516003704476137795166849228875";
        assertThat(actualTerm).isEqualTo(expectedTerm);
    }
}