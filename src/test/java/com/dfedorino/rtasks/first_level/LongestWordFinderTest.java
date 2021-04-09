package com.dfedorino.rtasks.first_level;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LongestWordFinderTest {
    private final LongestWordFinder app = new LongestWordFinder();

    @Test
    public void testFindLongestWord_EmptyString_EmptyStringAndZero() {
        String words = " ";
        String actual = app.findLongestWord(words);
        String expected = "\r\n0";
        assertEquals(actual, expected);
    }

    @Test
    public void testFindLongestWord_SpaceOneWordSpace_SameWordAndLength() {
        String words = " one ";
        String actual = app.findLongestWord(words);
        String expected = "one\r\n3";
        assertEquals(actual, expected);
    }

    @Test
    public void testFindLongestWord_TwoEqualWordsSameLength_FirstWordAndLength() {
        String words = " one one ";
        String actual = app.findLongestWord(words);
        String expected = "one\r\n3";
        assertEquals(actual, expected);
    }

    @Test
    public void testFindLongestWord_TwoDifferentWordsSameLength_FirstWordAndLength() {
        String words = " one two ";
        String actual = app.findLongestWord(words);
        String expected = "one\r\n3";
        assertEquals(actual, expected);
    }

    @Test
    public void testFindLongestWord_SeveralWordsArbitraryLength_SameWordAndLength() {
        String words = " one two three four five six ";
        String actual = app.findLongestWord(words);
        String expected = "three\r\n5";
        assertEquals(actual, expected);
    }
}