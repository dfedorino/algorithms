package com.dfedorino.rtasks.first_level;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WatchTest {
    private final Watch watch = new Watch();

    @Test
    public void testShowTime_TwoSecondsPassed_00_00_02() {
        assertThat(watch.showTime(2)).isEqualTo(new Watch.Time("00", "00", "02"));
    }

    @Test
    public void testShowTime_TwoMinutesTwoSecondsPassed_00_02_02() {
        assertThat(watch.showTime(3599)).isEqualTo(new Watch.Time("00", "59", "59"));
    }

    @Test
    public void testShowTime_TaskCase_01_00_02() {
        assertThat(watch.showTime(3602)).isEqualTo(new Watch.Time("01", "00", "02"));
    }

    @Test
    public void testShowTime_TaskCase_12_01_40() {
        assertThat(watch.showTime(129701)).isEqualTo(new Watch.Time("12", "01", "40"));
    }
}