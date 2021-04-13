package com.dfedorino.rtasks.first_level;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CyphersTest {
    private final Cyphers app = new Cyphers();

    @Test
    public void testEncrypt_sandwich_shacnidw() {
        String word = "sandwich";
        String actual = app.encrypt(word);
        String expected = "shacnidw#";
        assertEquals(actual, expected);
    }

    @Test
    public void testDecrypt_shacnidw_sandwich() {
        String encrypted = "shacnidw#";
        String actual = app.decrypt(encrypted);
        String expected = "sandwich";
        assertEquals(actual, expected);
    }

    @Test
    public void testDecrypt_MaxCharacters_SuperSecretNo() {
        String word = "Super---Secret---No.";
        String encrypted = app.encrypt(word); // S.uopNe-r----t-eSrec#
        System.out.println(encrypted);
        String actual = app.decrypt(encrypted);
        assertEquals(actual, word);
    }

    @Test
    public void testDecrypt_MaxCharactersOdd_SuperSecretNo() {
        String word = "Super---Secret---No";
        String encrypted = app.encrypt(word);
        System.out.println(encrypted);
        String actual = app.decrypt(encrypted);
        assertEquals(actual, word);
    }
}