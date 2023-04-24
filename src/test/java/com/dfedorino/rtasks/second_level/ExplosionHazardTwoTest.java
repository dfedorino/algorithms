package com.dfedorino.rtasks.second_level;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExplosionHazardTwoTest {
    private final ExplosionHazardTwo app = new ExplosionHazardTwo();

    @Test
    public void testGetNumberOfSafeStacks_0_0() {
        assertThat(app.getNumberOfSafeStacks(0)).isEqualTo(0);
    }

    @Test
    public void testGetNumberOfSafeStacks_1_3() {
        assertThat(app.getNumberOfSafeStacks(1)).isEqualTo(3);
    }

    @Test
    public void testGetNumberOfSafeStacks_2_8() {
        assertThat(app.getNumberOfSafeStacks(2)).isEqualTo(8);
    }

    @Test
    public void testGetNumberOfSafeStacks_3_22() {
        assertThat(app.getNumberOfSafeStacks(3)).isEqualTo(22);
    }

    @Test
    public void testGetNumberOfSafeStacks_18_77473792() {
//        long expectedResult = checkManuallyFor(18); // 77_473_792
        assertThat(app.getNumberOfSafeStacks(18)).isEqualTo(77_473_792);
    }

    private long checkManuallyFor(int containers) {
        long goodSequenceCounter = 0;
        long border = (int) Math.pow(3, containers);
        for (long i = 0; i < border; i++) {
            if (!Long.toString(i, 3).contains("11")) {
                goodSequenceCounter++;
            }
        }
        return goodSequenceCounter;
    }
}