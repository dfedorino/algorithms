package com.dfedorino.rtasks.second_level;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ComponentsGeneratorTest {
    private final ComponentsGenerator app = new ComponentsGenerator();

    @Test
    public void testGenerateComponentsOf_Two_TwoStrings() {
        assertThat(app.generateComponentsOf(2))
                .contains("11")
                .contains("2")
                .hasSize(2);
    }

    @Test
    public void testGenerateComponentsOf_Three_ThreeStrings() {
        assertThat(app.generateComponentsOf(3))
                .contains("111")
                .contains("21")
                .contains("3")
                .hasSize(3);
    }

    @Test
    public void testGenerateComponentsOf_Four_FourStrings() {
        assertThat(app.generateComponentsOf(4))
                .contains("1111")
                .contains("211")
                .contains("22")
                .contains("31")
                .contains("4")
                .hasSize(5);
    }

    @Test
    public void testGenerateComponentsOf_Five_SevenStrings() {
        assertThat(app.generateComponentsOf(5))
                .contains("11111")
                .contains("2111")
                .contains("221")
                .contains("311")
                .contains("32")
                .contains("41")
                .contains("5")
                .hasSize(7);
    }

    @Test
    public void testGenerateComponentsOf_MaxNumber_IsNotNull() {
        assertThat(app.generateComponentsOf(40))
                .isNotNull();
    }
}