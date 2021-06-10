package com.dfedorino.rtasks.second_level;

import org.testng.annotations.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

public class ReverseComponentGeneratorTest {
    private final ReverseComponentGenerator app = new ReverseComponentGenerator();

    @Test
    public void testGenerateComponentsOf_MinimalPossibleValue_OneCombinationString() {
        assertThat(app.generateComponentsOf(1))
                .hasSize(1)
                .contains("1");
    }

    @Test
    public void testGenerateComponentsOf_EvenNumber_FiveStringsCombinations() {
        assertThat(app.generateComponentsOf(4))
                .hasSize(5)
                .contains("1111")
                .contains("211")
                .contains("22")
                .contains("31")
                .contains("4")
                .isSortedAccordingTo(Comparator.reverseOrder());
    }

    @Test
    public void testGenerateComponentsOf_OddNumber_SevenStringsCombinations() {
        assertThat(app.generateComponentsOf(5))
                .hasSize(7)
                .contains("11111")
                .contains("2111")
                .contains("221")
                .contains("311")
                .contains("32")
                .contains("41")
                .contains("5")
                .isSortedAccordingTo(Comparator.reverseOrder());
    }

    @Test
    public void testGenerateComponentsOf_MaxNumber_ResultIsNotEmpty() {
        assertThat(app.generateComponentsOf(40))
                .isNotEmpty();
    }
}