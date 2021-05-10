package com.dfedorino.rtasks.second_level;

import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PermutationsBuilderTest {
    private final PermutationsBuilder app = new PermutationsBuilder();

    @Test
    public void testBuildAllPermutationsUntil_One_OnePermutation() {
        assertThat(app.getPermutationsUntil(1)).isEqualTo(List.of("1"));
    }

    @Test
    public void testBuildAllPermutationsUntil_Two_TwoPermutations() {
        assertThat(app.getPermutationsUntil(2)).isEqualTo(List.of("12", "21"));
    }

    @Test
    public void testBuildAllPermutationsUntil_Three_SixPermutations() {
        assertThat(app.getPermutationsUntil(3)).isEqualTo(List.of(
                "123", "132",
                "213", "231",
                "312", "321")
        );
    }
}