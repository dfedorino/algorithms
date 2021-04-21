package com.dfedorino.rtasks.first_level;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TwoLettersFinderTest {
    private final TwoLettersFinder app = new TwoLettersFinder();

    @Test
    public void testFindDuplicateLetter_TwoEqualLowercaseLetters_SecondLetter() {
        String letters = "ff";
        char actual = app.findDuplicateLetterWithBooleanArray(letters);
        char expected = 'f';
        assertEquals(actual, expected);
    }

    @Test
    public void testFindDuplicateLetter_TwoEqualUppercaseLetters_SecondLetter() {
        String letters = "FF";
        char actual = app.findDuplicateLetterWithBooleanArray(letters);
        char expected = 'F';
        assertEquals(actual, expected);
    }

    @Test
    public void testFindDuplicateLetter_ArbitraryLowercaseLetters_LastLetter() {
        String letters = "fif";
        char actual = app.findDuplicateLetterWithBooleanArray(letters);
        char expected = 'f';
        assertEquals(actual, expected);
    }

    @Test
    public void testFindDuplicateLetter_ArbitraryLowercaseLettersWithNonLetterChars_LastLetter() {
        String letters = "fi  f";
        char actual = app.findDuplicateLetterWithBooleanArray(letters);
        char expected = 'f';
        assertEquals(actual, expected);
    }
}