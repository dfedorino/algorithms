package com.dfedorino.rtasks.second_level;

import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ConditionalBinaryStringBuilderTest {

    @Test
    public void testBuildFromBeginning_LengthOneWithOneOnes_OneString() {
        ConditionalBinaryStringBuilder app = new ConditionalBinaryStringBuilder(1,1);
        app.buildFromBeginning(0, 0);
        List<String> combinations = app.getCombinations();
        assertThat(combinations.size()).isEqualTo(1);
        assertThat(combinations.get(0)).isEqualTo("1");
    }

    @Test
    public void testBuildFromBeginning_TaskCaseLengthFourWithTwoOnes_SixStrings() {
        ConditionalBinaryStringBuilder app = new ConditionalBinaryStringBuilder(4,2);
        app.buildFromBeginning(0, 0);
        List<String> combinations = app.getCombinations();
        assertThat(combinations.get(0)).isEqualTo("0011");
        assertThat(combinations.get(1)).isEqualTo("0101");
        assertThat(combinations.get(2)).isEqualTo("0110");
        assertThat(combinations.get(3)).isEqualTo("1001");
        assertThat(combinations.get(4)).isEqualTo("1010");
        assertThat(combinations.get(5)).isEqualTo("1100");
    }

    @Test
    public void testBuildFromBeginning_LengthThirtyWithThirtyOnes_OneString() {
        ConditionalBinaryStringBuilder app = new ConditionalBinaryStringBuilder(30,30);
        app.buildFromBeginning(0, 0);
        List<String> combinations = app.getCombinations();
        String expectedResult = IntStream.iterate(1, i -> i)
                .limit(30)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(""));
        assertThat(combinations.size()).isEqualTo(1);
        assertThat(combinations.get(0)).isEqualTo(expectedResult);
    }
}