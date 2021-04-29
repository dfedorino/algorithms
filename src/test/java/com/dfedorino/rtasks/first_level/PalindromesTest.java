package com.dfedorino.rtasks.first_level;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PalindromesTest {
    private final Palindromes app = new Palindromes();

    @Test
    public void testIsPalindrome_PalindromeNonLatin_True() {
        String phrase = "аргентина манит негра";
        assertTrue(app.isPalindrome(phrase));
    }

    @Test
    public void testIsPalindrome_PalindromeLatin_True() {
        String phrase = "ab a";
        assertTrue(app.isPalindrome(phrase));
    }

    @Test
    public void testIsPalindrome_PalindromeLatinWithTwoWhitespaces_True() {
        String phrase = "ab  a";
        assertTrue(app.isPalindrome(phrase));
    }

    @Test
    public void testIsPalindrome_PalindromeLatinWithoutWhitespacesOddNumberOfLetters_True() {
        String phrase = "aba";
        assertTrue(app.isPalindrome(phrase));
    }

    @Test
    public void testIsPalindrome_PalindromeLatinWithoutWhitespacesEvenNumberOfLetters_True() {
        String phrase = "abba";
        assertTrue(app.isPalindrome(phrase));
    }

    @Test
    public void testBuild_OddNumberOfLetters_ABA() {
        assertEquals(app.build("AAB"), "ABA");
    }

    @Test
    public void testBuild_EvenNumberOfLetters_ABBA() {
        assertEquals(app.build("AABB"), "ABBA");
    }

    @Test
    public void testBuild_EvenNumberOfLettersSeveralRedundant_ABCBA() {
        assertEquals(app.build("AABBCDEFGHI"), "ABCBA");
    }

    @Test
    public void testBuild_EvenNumberOfSameLetters_ABCBA() {
        assertEquals(app.build("AA"), "AA");
    }

    @Test
    public void testBuild_OddNumberOfSameLetters_AAA() {
        assertEquals(app.build("AAA"), "AAA");
    }

    @Test
    public void testBuild_TaskTest1_AQZZQA() {
        assertEquals(app.build("QAZQAZ"), "AQZZQA");
    }

    @Test
    public void testBuild_TaskTest2_A() {
        assertEquals(app.build("ABCDEF"), "A");
    }
}