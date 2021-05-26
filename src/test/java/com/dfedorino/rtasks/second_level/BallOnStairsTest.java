package com.dfedorino.rtasks.second_level;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallOnStairsTest {
    private final BallOnStairs app = new BallOnStairs();

    @Test
    public void testGetWaysToGroundForHeight_0_0() {
        assertThat(app.getWaysToGroundForHeight(0)).isEqualTo(0);
    }

    @Test
    public void testGetWaysToGroundForHeight_1_1() {
        assertThat(app.getWaysToGroundForHeight(1)).isEqualTo(1);
    }

    @Test
    public void testGetWaysToGroundForHeight_2_2() {
        assertThat(app.getWaysToGroundForHeight(2)).isEqualTo(2);
    }

    @Test
    public void testGetWaysToGroundForHeight_3_4() {
        assertThat(app.getWaysToGroundForHeight(3)).isEqualTo(4);
    }

    @Test
    public void testGetWaysToGroundForHeight_4_7() {
        assertThat(app.getWaysToGroundForHeight(4)).isEqualTo(7);
    }
}