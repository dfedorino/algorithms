package com.dfedorino.rtasks.third_level;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DrunkardGameTest {
    private final DrunkardGame app = new DrunkardGame();

    @Test
    public void testPlay_whenTestCase1_thenSecond_5() {
        assertThat(app.play(new int[] {1, 3, 5, 7, 9}, new int[] {2, 4, 6, 8, 0})).isEqualTo("second 5");
    }
}