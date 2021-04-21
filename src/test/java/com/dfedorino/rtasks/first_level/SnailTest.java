package com.dfedorino.rtasks.first_level;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SnailTest {
    private final Snail app = new Snail();

    @Test
    public void testGetDays_DistanceLessThanDistancePerDay_OneDay() {
        assertEquals(app.getDays(1, 3, 2), 1);
    }

    @Test
    public void testGetDays_DistanceMoreThanDistancePerDay_TwoDays() {
        assertEquals(app.getDays(4, 3, 2), 2);
    }

    @Test
    public void testGetDays_DistancePerNightLessThanDistancePerDay_TwoDays() {
        assertEquals(app.getDays(6, 3, 1), 3);
    }
}