package com.dfedorino.rtasks.leetcode;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReverseStringTest {
    private final ReverseString app = new ReverseString();

    @Test(dataProvider = "testCases")
    void when_array_of_chars_then_reversed_in_place_array(char[] givenArray, char[] expectedArray) {
        app.reverseString(givenArray);
        assertThat(givenArray).isEqualTo(expectedArray);
    }

    @DataProvider(name = "testCases")
    public Object[][] testCases() {
        return new Object[][] {
                {new char[] {'h', 'e', 'l', 'l', 'o'}, new char[] {'o', 'l', 'l', 'e', 'h'}},
                {new char[]{'H', 'a', 'n', 'n', 'a', 'h'}, new char[]{'h', 'a', 'n', 'n', 'a', 'H'}},
        };
    }
}