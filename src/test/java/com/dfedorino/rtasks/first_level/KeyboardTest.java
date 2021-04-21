package com.dfedorino.rtasks.first_level;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class KeyboardTest {
    private final Keyboard app = new Keyboard();

    @Test
    public void testCheck_TaskTest_ynnny() {
        int[] resist = {1, 50, 3, 4, 3};
        int[] log = {1, 2, 3, 4, 5, 1, 3, 3, 4, 5, 5, 5, 5, 5, 4, 5};
        // 1st button -> 2 pushes, resist -> 1, breaks
        // 2nd button -> 1 pushes, resist -> 50, doesn't break
        // 3rd button -> 3 pushes, resist -> 3, doesn't break
        // 4th button -> 4 pushes, resist -> 4, doesn't break
        // 5th button -> 7 pushes, resist -> 3, breaks
        String actual = app.check(resist, log);
        String expected =
                "true" + System.lineSeparator() +
                "false" + System.lineSeparator() +
                "false" + System.lineSeparator() +
                "false" + System.lineSeparator() +
                "true";
        assertEquals(actual, expected);
    }
}