package com.dfedorino.rtasks.leetcode;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneNumberLetterCombinationsTest {
    private final PhoneNumberLetterCombinations app = new PhoneNumberLetterCombinations();

    @Test // Example 1
    public void testLetterCombinations_whenStringContainsSeveralDigits_thenListOfLetterCombinationsIsReturned() {
        assertThat(app.letterCombinations("23"))
                .hasSize(9)
                .contains("ad")
                .contains("ae")
                .contains("af")
                .contains("bd")
                .contains("be")
                .contains("bf")
                .contains("cd")
                .contains("ce")
                .contains("cf");
    }

    @Test // Example 2
    public void testLetterCombinations_whenEmptyString_thenEmptyList() {
        assertThat(app.letterCombinations("")).isEqualTo(new ArrayList<>());
    }

    @Test // Example 3
    public void testLetterCombinations_whenStringContainsOneDigit_thenListOfLetterOfThatDigitIsReturned() {
        assertThat(app.letterCombinations("2")).isEqualTo(List.of("a", "b", "c"));
    }
}