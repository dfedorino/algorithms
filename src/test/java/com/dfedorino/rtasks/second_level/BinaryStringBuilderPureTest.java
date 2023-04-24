package com.dfedorino.rtasks.second_level;

import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryStringBuilderPureTest {
    private final BinaryStringBuilderPure app = new BinaryStringBuilderPure();

    @Test
    public void testBuild_OneDigit_TwoCombinations() {
        assertThat(app.getAllPossibleCombinationsForLength(1)).isEqualTo(List.of("0", "1"));
    }

    @Test
    public void testBuild_TwoDigits_FourCombinations() {
        assertThat(app.getAllPossibleCombinationsForLength(2)).isEqualTo(List.of("00", "01", "10", "11"));
    }

    @Test
    public void testBuild_ThreeDigits_EightCombinations() {
        assertThat(app.getAllPossibleCombinationsForLength(3)).isEqualTo(List.of("000", "001", "010", "011", "100", "101", "110", "111"));
    }
}
