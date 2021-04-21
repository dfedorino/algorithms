package com.dfedorino.rtasks.first_level;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class ElectionsTest {
    private final Elections app = new Elections();

    @Test
    public void testGetPartiesOrdinals_3Parties2Winners_1_2() {
        List<Integer> expected = Arrays.asList(1, 2);
        List<Integer> actual = app.getPartiesOrdinals(3, 4, new String[]{
                "+--",
                "+--",
                "-+-",
                "+--"
        });
        assertEquals(actual, expected);
    }

    @Test
    public void testGetPartiesOrdinals_1Party1Winner_1() {
        List<Integer> expected = Arrays.asList(1);
        List<Integer> actual = app.getPartiesOrdinals(1, 5, new String[]{
                "+",
                "-",
                "-",
                "-"
        });
        assertEquals(actual, expected);
    }
}