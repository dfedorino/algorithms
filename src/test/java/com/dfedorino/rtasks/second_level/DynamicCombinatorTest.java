package com.dfedorino.rtasks.second_level;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DynamicCombinatorTest {
    private final DynamicCombinator app = new DynamicCombinator();

    @Test
    public void testGetNumberOfCorrectCombinationsForLength_One_TwoCombinations() {
        String[] expectedGoodCombinations = {
                "0",
                "1"
        };
        assertThat(app.getNumberOfCorrectCombinationsForLength(1)).isEqualTo(expectedGoodCombinations.length);
    }

    @Test
    public void testGetNumberOfCorrectCombinationsForLength_Two_ThreeCombinations() {
        String[] expectedGoodCombinations = {
                "00",
                "01",
                "10"
        };
        assertThat(app.getNumberOfCorrectCombinationsForLength(2)).isEqualTo(expectedGoodCombinations.length);
    }

    @Test
    public void testGetNumberOfCorrectCombinationsForLength_Three_SevenCombinations() {
        String[] expectedGoodCombinations = {
                "000",
                "010",
                "100",
                "001",
                "101"
        };
        assertThat(app.getNumberOfCorrectCombinationsForLength(3)).isEqualTo(expectedGoodCombinations.length);
    }
}