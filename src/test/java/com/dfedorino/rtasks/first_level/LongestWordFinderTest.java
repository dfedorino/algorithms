package com.dfedorino.rtasks.first_level;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestWordFinderTest {
    private final LongestWordFinder app = new LongestWordFinder();

    @Test
    public void testFindLongestWord_EmptyString_EmptyStringAndZero() {
        String words = " ";
        LongestWordFinder.Result actual = app.findLongestWordZeroSpaceComplexity(words);
        LongestWordFinder.Result expected = new LongestWordFinder.Result("", 0);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testFindLongestWord_SpaceOneWordSpace_SameWordAndLength() {
        String words = " one ";
        LongestWordFinder.Result actual = app.findLongestWordZeroSpaceComplexity(words);
        LongestWordFinder.Result expected = new LongestWordFinder.Result("one", 3);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testFindLongestWord_TwoEqualWordsSameLength_FirstWordAndLength() {
        String words = " one one ";
        LongestWordFinder.Result actual = app.findLongestWordZeroSpaceComplexity(words);
        LongestWordFinder.Result expected = new LongestWordFinder.Result("one", 3);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testFindLongestWord_TwoDifferentWordsSameLength_FirstWordAndLength() {
        String words = " one two ";
        LongestWordFinder.Result actual = app.findLongestWordZeroSpaceComplexity(words);
        LongestWordFinder.Result expected = new LongestWordFinder.Result("one", 3);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testFindLongestWord_SeveralWordsArbitraryLength_SameWordAndLength() {
        String words = " one two three four five six ";
        LongestWordFinder.Result actual = app.findLongestWordZeroSpaceComplexity(words);
        LongestWordFinder.Result expected = new LongestWordFinder.Result("three", 5);
        assertThat(actual).isEqualTo(expected);
    }
}