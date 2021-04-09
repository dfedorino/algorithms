package com.dfedorino.rtasks.first_level;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TreasureFinderTest {
    private final TreasureFinder app = new TreasureFinder();
    private final int maxSteps = 100_000_000;

    @Test
    public void testGetCoordinates_MaxStepsToNorth_MaxStepsAndZero() {
        String guide = "North " + maxSteps;
        String actual = app.getCoordinates(guide);
        String expected = "0 " + maxSteps;
        assertEquals(actual, expected);
    }

    @Test
    public void testGetCoordinates_MaxStepsToEast_ZeroAndMaxSteps() {
        String guide = "East " + maxSteps;
        String actual = app.getCoordinates(guide);
        String expected = maxSteps + " 0";
        assertEquals(actual, expected);
    }

    @Test
    public void testGetCoordinates_MaxStepToSouth_MinusMaxStepsAndZero() {
        String guide = "South " + maxSteps;
        String actual = app.getCoordinates(guide);
        String expected = "0 " + -maxSteps;
        assertEquals(actual, expected);
    }

    @Test
    public void testGetCoordinates_MaxStepsToWest_ZeroAndMinusMaxSteps() {
        String guide = "West " + maxSteps;
        String actual = app.getCoordinates(guide);
        String expected = -maxSteps + " 0";
        assertEquals(actual, expected);
    }

    @Test
    public void testGetCoordinates_RandomGuide() {
        String guide = "South 19\nEast 2";
        String actual = app.getCoordinates(guide);
        String expected = "2 -19";
        assertEquals(actual, expected);
    }
}