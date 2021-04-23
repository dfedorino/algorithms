package com.dfedorino.rtasks.second_level;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArraysTest {
    private final Arrays arrays = new Arrays();

    @Test
    public void testFindSum_AllElementsSum_15() {
        assertThat(arrays.findSum(new int[] {1, 2, 3, 4, 5}, 1, 5)).isEqualTo(15);
    }

    @Test
    public void testFindSum_OneElement_1() {
        assertThat(arrays.findSum(new int[] {1, 2, 3, 4, 5}, 1, 1)).isEqualTo(1);
    }

    @Test
    public void testFindSum_TwoElements_3() {
        assertThat(arrays.findSum(new int[] {1, 2, 3, 4, 5}, 1, 2)).isEqualTo(3);
    }

    @Test
    public void testFindSum_TaskCase0() {
        assertThat(arrays.findSum(new int[] {1, 2, 3, 4, 5}, 2, 4)).isEqualTo(9);
    }

    @Test
    public void testFindSum_TaskCase1() {
        assertThat(arrays.findSum(new int[] {1, 2, 3, 4, 5}, 3, 5)).isEqualTo(12);
    }

    @Test
    public void testCountZeros_CountAllZeros_4() {
        assertThat(arrays.countZeros(new int[]{0, 0, 0, 0, 2}, 1, 5)).isEqualTo(4);
    }

    @Test
    public void testCountZeros_CountOneZero_1() {
        assertThat(arrays.countZeros(new int[]{0, 0, 0, 0, 2}, 1, 1)).isEqualTo(1);
    }

    @Test
    public void testCountZeros_ArrayWithoutZeros_0() {
        assertThat(arrays.countZeros(new int[]{1, 2, 3, 4, 5}, 1, 5)).isEqualTo(0);
    }

    @Test
    public void testCountZeros_TaskCase0() {
        assertThat(arrays.countZeros(new int[]{0, 0, 0, 0, 2}, 2, 3)).isEqualTo(2);
    }

    @Test
    public void testCountZeros_TaskCase1() {
        assertThat(arrays.countZeros(new int[]{0, 0, 0, 0, 2}, 2, 5)).isEqualTo(3);
    }
}