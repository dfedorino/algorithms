package com.dfedorino.rtasks.first_level;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MatchTest {
    private final Match app = new Match();

    @Test
    public void testGetScoreFromProtocol_Events_Score() {
        String[] events = {
                "service",
                "goal", // 1:0
                "service",
                "out", // 1:1
                "service",
                "net", // 1:2
                "service",
                "return",
                "return",
                "return",
                "out", // 1:3
                "service",
                "return",
                "goal", // 2:3
                "service",
                "goal", // 2:4
                "eom"
        };
        String actual = app.getScoreFromProtocol(events);
        String expected = "2 4";
        assertEquals(actual, expected);
    }
}