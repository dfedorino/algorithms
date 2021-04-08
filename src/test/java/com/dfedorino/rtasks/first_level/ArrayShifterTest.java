package com.dfedorino.rtasks.first_level;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArrayShifterTest {
    ArrayShifter app = new ArrayShifter();
    @Test
    public void testRightShift_UniqueElements_ArrayShiftedInPlace() {
        int[] expected = {9, 3, 5, 7};
        int[] actual = {3, 5, 7, 9};
        app.rightShift(actual);
        assertEquals(expected, actual);
    }
}