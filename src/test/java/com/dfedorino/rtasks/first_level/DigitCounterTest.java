package com.dfedorino.rtasks.first_level;

import org.testng.annotations.Test;

import java.util.stream.IntStream;

import static org.testng.Assert.assertEquals;

public class DigitCounterTest {
    private final DigitCounter app = new DigitCounter();

    @Test
    public void testCountDigits_OneMinNumber() {
        int[] array = {1};
        int[] actual = app.countDigits(array);
        int[] expected = {1, 0, 0, 0, 0, 0, 0, 0, 0};
        assertEquals(actual, expected);
    }

    @Test
    public void testCountDigits_MaxQuantityOfMinNumber() {
        int[] array = IntStream.iterate(1, seed -> seed).limit(100_000).toArray();
        int[] actual = app.countDigits(array);
        int[] expected = {100_000, 0, 0, 0, 0, 0, 0, 0, 0};
        assertEquals(actual, expected);
    }

    @Test
    public void testCountDigits_OneMaxNumber() {
        int[] array = {9};
        int[] actual = app.countDigits(array);
        int[] expected = {0, 0, 0, 0, 0, 0, 0, 0, 1};
        assertEquals(actual, expected);
    }

    @Test
    public void testCountDigits_MaxQuantityOfMaxNumber() {
        int[] array = IntStream.iterate(9, seed -> seed).limit(100_000).toArray();
        int[] actual = app.countDigits(array);
        int[] expected = {0, 0, 0, 0, 0, 0, 0, 0, 100_000};
        assertEquals(actual, expected);
    }

    @Test
    public void testCountDigits_RandomQuantityOfRandomNumbers() {
        int[] array = {1, 1, 4, 1, 5, 8, 6, 3, 5, 1, 0};
        int[] actual = app.countDigits(array);
        int[] expected = {4, 0, 1, 1, 2, 1, 0, 1, 0};
        assertEquals(actual, expected);
    }
}