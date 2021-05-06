package com.dfedorino.rtasks.second_level;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryStringBuilderTest {

    @Test
    public void testBuildFromEnd_LengthThreeTwoValues_EightStrings() {
        BinaryStringBuilder app = new BinaryStringBuilder(3, 0, 1);
        app.buildFromEnd(2);
        String[] combinations = app.getCombinations();
        assertThat(combinations[0]).isEqualTo("000");
        assertThat(combinations[1]).isEqualTo("100");
        assertThat(combinations[2]).isEqualTo("010");
        assertThat(combinations[3]).isEqualTo("110");
        assertThat(combinations[4]).isEqualTo("001");
        assertThat(combinations[5]).isEqualTo("101");
        assertThat(combinations[6]).isEqualTo("011");
        assertThat(combinations[7]).isEqualTo("111");
    }

    @Test
    public void testBuildFromBeginning_LengthThreeTwoValues_EightStrings() {
        BinaryStringBuilder app = new BinaryStringBuilder(3, 0, 1);
        app.buildFromBeginning(0);
        String[] combinations = app.getCombinations();
        assertThat(combinations[0]).isEqualTo("000");
        assertThat(combinations[1]).isEqualTo("001");
        assertThat(combinations[2]).isEqualTo("010");
        assertThat(combinations[3]).isEqualTo("011");
        assertThat(combinations[4]).isEqualTo("100");
        assertThat(combinations[5]).isEqualTo("101");
        assertThat(combinations[6]).isEqualTo("110");
        assertThat(combinations[7]).isEqualTo("111");
    }

    @Test
    public void testBuildFromBeginning_TaskTestCaseLengthTwoTwoValues_FourStrings() {
        BinaryStringBuilder app = new BinaryStringBuilder(2, 0, 1);
        app.buildFromBeginning(0);
        String[] combinations = app.getCombinations();
        assertThat(combinations[0]).isEqualTo("00");
        assertThat(combinations[1]).isEqualTo("01");
        assertThat(combinations[2]).isEqualTo("10");
        assertThat(combinations[3]).isEqualTo("11");
    }

    @Test
    public void testBuildFromBeginning_LengthTwoThreeValues_NineStrings() {
        BinaryStringBuilder app = new BinaryStringBuilder(2, 0, 1, 2);
        app.buildFromBeginning(0);
        String[] combinations = app.getCombinations();
        assertThat(combinations[0]).isEqualTo("00");
        assertThat(combinations[1]).isEqualTo("01");
        assertThat(combinations[2]).isEqualTo("02");
        assertThat(combinations[3]).isEqualTo("10");
        assertThat(combinations[4]).isEqualTo("11");
        assertThat(combinations[5]).isEqualTo("12");
        assertThat(combinations[6]).isEqualTo("20");
        assertThat(combinations[7]).isEqualTo("21");
        assertThat(combinations[8]).isEqualTo("22");
    }
}