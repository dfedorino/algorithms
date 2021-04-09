package com.dfedorino.rtasks.first_level;

import org.testng.annotations.Test;

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
}