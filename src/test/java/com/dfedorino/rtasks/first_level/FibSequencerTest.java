package com.dfedorino.rtasks.first_level;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FibSequencerTest {
    private final FibSequencer app = new FibSequencer();

    @Test
    public void testGetFirstAndSecond_1ElementOfFibSequence_3_5() {
        assertEquals(app.getFirstAndSecond(1, 3, 5), new int[] {3, 5});
    }

    @Test
    public void testGetFirstAndSecond_4ElementsOfFibSequence_1_1() {
        assertEquals(app.getFirstAndSecond(4, 3, 5), new int[] {1, 1});
    }

    @Test
    public void testGetFirstAndSecond_10ElementsOfFibSequence_1_1() {
        assertEquals(app.getFirstAndSecond(10, 55, 89), new int[] {1, 1});
        // 0 1 2 3 4 5 6 7  8  9  10 11
        // 0 1 1 2 3 5 8 13 21 34 55 89
    }
}