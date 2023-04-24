package com.dfedorino.rtasks.yandex_contest;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AnagramsTest {
    @Test
    public void testAreAnagrams_EmptyStrings_One() {
        Anagrams anagrams = new Anagrams();
        assertEquals(anagrams.areAnagrams("", ""), 1);
    }

    @Test
    public void testAreAnagrams_EqualChars_One() {
        Anagrams anagrams = new Anagrams();
        assertEquals(anagrams.areAnagrams("a", "a"), 1);
    }

    @Test
    public void testAreAnagrams_EqualCharsDifferentLength_Zero() {
        Anagrams anagrams = new Anagrams();
        assertEquals(anagrams.areAnagrams("a", "aa"), 0);
    }

    @Test
    public void testAreAnagrams_DifferentCharsEqualLength_Zero() {
        Anagrams anagrams = new Anagrams();
        assertEquals(anagrams.areAnagrams("a", "b"), 0);
    }

    @Test
    public void testAreAnagrams_EqualCharsEqualLength_Zero() {
        Anagrams anagrams = new Anagrams();
        assertEquals(anagrams.areAnagrams("aa", "bb"), 0);
    }

    @Test
    public void testAreAnagrams_EqualCharsEqualLengthEqualPosition_One() {
        Anagrams anagrams = new Anagrams();
        assertEquals(anagrams.areAnagrams("qiu", "qiu"), 1);
    }

    @Test
    public void testAreAnagrams_EqualCharsEqualLengthDifferentPosition_One() {
        Anagrams anagrams = new Anagrams();
        assertEquals(anagrams.areAnagrams("qiu", "iuq"), 1);
    }

    @Test
    public void testAreAnagrams_OneDifferentCharEqualLengthEqualPosition_Zero() {
        Anagrams anagrams = new Anagrams();
        assertEquals(anagrams.areAnagrams("zprl", "zprc"), 0);
    }

    @Test
    public void testAreAnagrams_EqualCharsEqualLengthDifferentQuantityOfChars_Zero() {
        Anagrams anagrams = new Anagrams();
        assertEquals(anagrams.areAnagrams("aaab", "bbba"), 0);
    }
}