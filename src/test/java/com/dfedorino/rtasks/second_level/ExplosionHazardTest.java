package com.dfedorino.rtasks.second_level;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExplosionHazardTest {
    private final ExplosionHazard app = new ExplosionHazard();

    @Test
    public void testGetNumberOfSafeStacks_0_0() {
        assertThat(app.getNumberOfSafeStacks(0)).isEqualTo(0);
    }

    @Test
    public void testGetNumberOfSafeStacks_1_2() {
        assertThat(app.getNumberOfSafeStacks(1)).isEqualTo(2);
    }

    @Test
    public void testGetNumberOfSafeStacks_2_3() {
        assertThat(app.getNumberOfSafeStacks(2)).isEqualTo(3);
    }

    @Test
    public void testGetNumberOfSafeStacks_OddNumberOfContainers_5() {
        assertThat(app.getNumberOfSafeStacks(3)).isEqualTo(5);
    }

    @Test
    public void testGetNumberOfSafeStacks_EvenNumberOfContainers_8() {
        assertThat(app.getNumberOfSafeStacks(4)).isEqualTo(8);
    }
}