package com.dfedorino.rtasks.first_level;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PlaceFinderTest {
    private PlaceFinder app = new PlaceFinder();

    @Test
    public void testFindPlace_ArbitraryIndex_Third() {
        int expected = 3;
        int actual = app.findPlace(new int[]{165, 163, 160, 160, 157, 157, 155, 154}, 162);
        assertEquals(actual, expected);
    }

    @Test
    public void testFindPlace_ArbitraryIndexAfterSameAsNumber_Fifth() {
        int expected = 5;
        int actual = app.findPlace(new int[]{165, 163, 162, 162, 157, 157, 155, 154}, 162);
        assertEquals(actual, expected);
    }

    @Test
    public void testFindPlace_LargerThanAnyNumber_First() {
        int expected = 1;
        int actual = app.findPlace(new int[]{165, 163, 162, 162, 157, 157, 155, 154}, 166);
        assertEquals(actual, expected);
    }

    @Test
    public void testFindPlace_SmallerThanAnyNumber_Last() {
        int expected = 9;
        int actual = app.findPlace(new int[]{165, 163, 162, 162, 157, 157, 155, 154}, 153);
        assertEquals(actual, expected);
    }
}