package com.dfedorino.rtasks.second_level;

import org.testng.annotations.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleSequenceTest {
    private final SimpleSequence app = new SimpleSequence();

    @Test
    public void testGetTermOfIndex_0_1() {
        assertThat(app.getTermOfIndex(0)).isEqualTo(BigInteger.ONE);
    }

    @Test
    public void testGetTermOfIndex_1_1() {
        assertThat(app.getTermOfIndex(1)).isEqualTo(BigInteger.ONE);
    }

    @Test
    public void testGetTermOfIndex_EvenIndex4_3() {
        assertThat(app.getTermOfIndex(4)).isEqualTo(BigInteger.valueOf(3));
    }

    @Test
    public void testGetTermOfIndex_OddIndex5_3() {
        assertThat(app.getTermOfIndex(5)).isEqualTo(BigInteger.valueOf(2));
    }
}