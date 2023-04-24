package com.dfedorino.rtasks.first_level;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RailwayCarSorterTest {
    private final RailwayCarSorter app = new RailwayCarSorter();

    @Test
    public void testGetMinSeparations_OneMinElement_ZeroSeparations() {
        int[] railwayCars = {1};
        int expectedSeparations = 0;
        int actualSeparations = app.getMinSeparations(railwayCars);
        assertEquals(actualSeparations, expectedSeparations);
    }

    @Test
    public void testGetMinSeparations_OneArbitraryElement_ZeroSeparations() {
        int[] railwayCars = {42};
        int expectedSeparations = 0;
        int actualSeparations = app.getMinSeparations(railwayCars);
        assertEquals(actualSeparations, expectedSeparations);
    }

    @Test
    public void testGetMinSeparations_OneMaxElement_ZeroSeparations() {
        int[] railwayCars = {100};
        int expectedSeparations = 0;
        int actualSeparations = app.getMinSeparations(railwayCars);
        assertEquals(actualSeparations, expectedSeparations);
    }

    @Test
    public void testGetMinSeparations_TwoMinElements_ZeroSeparations() {
        int[] railwayCars = {1, 1};
        int expectedSeparations = 0;
        int actualSeparations = app.getMinSeparations(railwayCars);
        assertEquals(actualSeparations, expectedSeparations);
    }

    @Test
    public void testGetMinSeparations_TwoArbitraryElementsSorted_ZeroSeparations() {
        int[] railwayCars = {1, 2};
        int expectedSeparations = 0;
        int actualSeparations = app.getMinSeparations(railwayCars);
        assertEquals(actualSeparations, expectedSeparations);
    }

    @Test
    public void testGetMinSeparations_TwoArbitraryElementsUnsorted_OneSeparation() {
        int[] railwayCars = {2, 1};
        int expectedSeparations = 1;
        int actualSeparations = app.getMinSeparations(railwayCars);
        assertEquals(actualSeparations, expectedSeparations);
    }

    @Test
    public void testGetMinSeparations_TwoMaxElements_ZeroSeparations() {
        int[] railwayCars = {100, 100};
        int expectedSeparations = 0;
        int actualSeparations = app.getMinSeparations(railwayCars);
        assertEquals(actualSeparations, expectedSeparations);
    }

    @Test
    public void testGetMinSeparations_ThreeMinElements_ZeroSeparations() {
        int[] railwayCars = {1, 1, 1};
        int expectedSeparations = 0;
        int actualSeparations = app.getMinSeparations(railwayCars);
        assertEquals(actualSeparations, expectedSeparations);
    }

    @Test
    public void testGetMinSeparations_ThreeArbitraryElementsSorted_ZeroSeparations() {
        int[] railwayCars = {1, 2, 3};
        int expectedSeparations = 0;
        int actualSeparations = app.getMinSeparations(railwayCars);
        assertEquals(actualSeparations, expectedSeparations);
    }

    @Test
    public void testGetMinSeparations_ThreeArbitraryElementsUnsorted_TwoSeparations() {
        int[] railwayCars = {3, 2, 1};
        int expectedSeparations = 2;
        int actualSeparations = app.getMinSeparations(railwayCars);
        assertEquals(actualSeparations, expectedSeparations);
    }

    @Test
    public void testGetMinSeparations_ThreeMaxElements_ZeroSeparations() {
        int[] railwayCars = {100, 100, 100};
        int expectedSeparations = 0;
        int actualSeparations = app.getMinSeparations(railwayCars);
        assertEquals(actualSeparations, expectedSeparations);
    }

    @Test
    public void testGetMinSeparations_EvenNumberOfElementsRandomOrder_FourSeparations() {
        int[] railwayCars = {3, 1, 2, 4};
        int expectedSeparations = 2;
        int actualSeparations = app.getMinSeparations(railwayCars);
        assertEquals(actualSeparations, expectedSeparations);
    }

    @Test
    public void testGetMinSeparations_EvenNumberOfElementsRandomOrderTwoDuplicates_FourSeparations() {
        int[] railwayCars = {3, 1, 2, 3};
        int expectedSeparations = 1;
        int actualSeparations = app.getMinSeparations(railwayCars);
        assertEquals(actualSeparations, expectedSeparations);
    }
}