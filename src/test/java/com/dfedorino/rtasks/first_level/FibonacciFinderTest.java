package com.dfedorino.rtasks.first_level;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FibonacciFinderTest {
    private final FibonacciFinder app = new FibonacciFinder();

    @Test
    public void testGetFibOf_One_One() {
        int actual = app.getFibOf(1);
        int expected = 1;
        assertEquals(actual, expected);
    }

    @Test
    public void testGetFibOf_Two_One() {
        int actual = app.getFibOf(2);
        int expected = 1;
        assertEquals(actual, expected);
    }

    @Test
    public void testGetFibOf_Three_Two() {
        int actual = app.getFibOf(3);
        int expected = 2;
        assertEquals(actual, expected);
    }

    @Test
    public void testGetFibOf_MaxNumberIsFortyFive_1134903170() {
        int actual = app.getFibOf(45);
        int expected = 1134903170;
        assertEquals(actual, expected);
    }
}