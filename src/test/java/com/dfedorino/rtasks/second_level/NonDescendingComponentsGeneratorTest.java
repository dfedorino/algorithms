package com.dfedorino.rtasks.second_level;

import org.testng.annotations.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

public class NonDescendingComponentsGeneratorTest {
    private final NonDescendingComponentsGenerator app = new NonDescendingComponentsGenerator();

    @Test
    public void testGenerateComponentsOf_One_OneString() {
        assertThat(app.generateComponentsOf(1))
                .hasSize(1)
                .contains("1");
    }

    @Test
    public void testGenerateComponentsOf_EvenNumberTwo_TwoStrings() {
        assertThat(app.generateComponentsOf(2))
                .hasSize(2)
                .contains("11")
                .contains("2")
                .isSortedAccordingTo(Comparator.naturalOrder());
    }

    @Test
    public void testGenerateComponentsOf_OddNumberFive_SevenStrings() {
        assertThat(app.generateComponentsOf(5))
                .hasSize(7)
                .contains("11111")
                .contains("1112")
                .contains("113")
                .contains("122")
                .contains("14")
                .contains("23")
                .contains("5")
                .isSortedAccordingTo(Comparator.naturalOrder());
    }

//    @Test
//    public void testGenerateComponentsOf_MaxNumberForty_SortedInNaturalOrder() {
//        assertThat(app.generateComponentsOf(40))
//                .isSortedAccordingTo(Comparator.naturalOrder());
//    }
}