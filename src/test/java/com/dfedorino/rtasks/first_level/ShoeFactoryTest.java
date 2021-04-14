package com.dfedorino.rtasks.first_level;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ShoeFactoryTest {
    private final ShoeFactory app = new ShoeFactory();
    @Test
    public void testGetShoeLaceLength() {
        assertEquals(app.getShoelaceLength(2, 1, 3, 4), 26);
    }

}