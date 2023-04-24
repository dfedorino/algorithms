package com.dfedorino.rtasks.third_level;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DrunkardGameTest {
    @Test(dataProvider = "implementations")
    public void testPlay_whenTestCase1_thenSecond_5(DrunkardGame app) {
        assertThat(app.play(new int[] {1, 3, 5, 7, 9}, new int[] {2, 4, 6, 8, 0})).isEqualTo("second 5");
    }

    @Test(dataProvider = "implementations")
    public void testPlay_whenTestCase2_thenBotva(DrunkardGame app) {
        assertThat(app.play(new int[] {1, 0}, new int[] {2, 9})).isEqualTo("botva");
    }

    @DataProvider(name = "implementations")
    public Object[][] implementations() {
        return new Object[][] {
                {new DrunkardGameProcedural()},
                {new DrunkardGameObjectOriented()}
        };
    }
}