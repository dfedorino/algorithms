package com.dfedorino.rtasks.first_level;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ScheduleTest {
    private final Schedule app = new Schedule();
    // 09:45 - 1st
    // 10:35 - 2nd
    // 11:35 - 3rd
    // 12:25 - 4th
    // 13:25 - 5th
    // 14:15 - 6th
    // 15:15 - 7th
    // 16:05 - 8th
    // 17:05 - 9th
    // 17:55 - 10th

    @Test
    public void testGetEndTime_After1st_9_45() {
       assertEquals(app.getEndTimeAfter(1), "09 45");
    }

    @Test
    public void testGetEndTime_After2nd_10_35() {
        assertEquals(app.getEndTimeAfter(2), "10 35");
    }

    @Test
    public void testGetEndTime_After3rd_11_35() {
        assertEquals(app.getEndTimeAfter(3), "11 35");
    }

    @Test
    public void testGetEndTime_After9th_17_05() {
        assertEquals(app.getEndTimeAfter(9), "17 05");
    }

    @Test
    public void testGetEndTime_After10th_17_55() {
        assertEquals(app.getEndTimeAfter(10), "17 55");
    }
}