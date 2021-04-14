package com.dfedorino.rtasks.first_level;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AppleDividerTest {
    private final AppleDivider app = new AppleDivider();

    @Test
    public void testGetLosers_7Students30Apples_5Losers() {
        assertEquals(app.getLosers(7, 30), 5);
    }

    @Test
    public void testGetLosers_7Students28Apples_0Losers() {
        assertEquals(app.getLosers(7, 28), 0);
    }
}