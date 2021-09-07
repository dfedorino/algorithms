package com.dfedorino.rtasks.first_level;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MetroTest {
    private final Metro app = new Metro();

    @Test
    public void testGetMinStations_NextStation_0() {
        assertEquals(app.getMinStations(101, 5, 6), 0);
    }

    @Test
    public void testGetMinStations_PreviousStation_0() {
        assertEquals(app.getMinStations(11, 6, 5), 0);
    }

    @Test
    public void testGetMinStations_10StationsFrom1To9_1() {
        assertEquals(app.getMinStations(11, 1, 9), 2);
    }
}