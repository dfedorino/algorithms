package com.dfedorino.rtasks.first_level;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SymmetricSequenceTest {
    private final SymmetricSequence app = new SymmetricSequence();

    @Test
    public void testGetSymmetricalEnding_AscendingSequence_4_4321() {
        int[] sequence = {1, 2, 3, 4, 5};
        String actual = app.getSymmetricEnding(sequence);
        String expected = "4 [4, 3, 2, 1]";
        assertEquals(actual, expected);
    }

    @Test
    public void testGetSymmetricalEnding_DescendingSequence_4_2345() {
        int[] sequence = {5, 4, 3, 2, 1};
        String actual = app.getSymmetricEnding(sequence);
        String expected = "4 [2, 3, 4, 5]";
        assertEquals(actual, expected);
    }

    @Test
    public void testGetSymmetricalEnding_ArbitrarySequenceWithOneSymmetricElement_3_121() {
        int[] sequence = {1, 2, 1, 2, 2};
        String actual = app.getSymmetricEnding(sequence);
        String expected = "3 [1, 2, 1]";
        assertEquals(actual, expected);
    }

    @Test
    public void testGetSymmetricalEnding_SymmetricSequence_0() {
        int[] sequence = {1, 2, 1, 2, 2, 1, 2, 1};
        String actual = app.getSymmetricEnding(sequence);
        String expected = "0 []";
        assertEquals(actual, expected);
    }
}