package com.dfedorino.rtasks.first_level;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import static org.testng.Assert.*;

public class LadderSequenceTest {
    private final LadderSequence app = new LadderSequence();

    @Test
    public void testBuild_IncreasingOrder_SymmetricLadder() {
        int[] array = {1, 1, 2, 2, 3};
        Deque<Integer> actual = app.build(array);
        System.out.println(actual);
        Deque<Integer> expected = new LinkedList<>(Arrays.asList(1, 2, 3, 2, 1));
        assertEquals(actual, expected);
    }

    @Test
    public void testBuild_ArbitraryOrder_SymmetricLadder() {
        int[] array = {3, 1, 1, 2, 2};
        Deque<Integer> actual = app.build(array);
        System.out.println(actual);
        Deque<Integer> expected = new LinkedList<>(Arrays.asList(1, 2, 3, 2, 1));
        assertEquals(actual, expected);
    }

    @Test
    public void testBuild_ArbitraryOrderTwoMax_SymmetricLadderOneMax() {
        int[] array = {3, 3, 1, 1, 2, 2};
        Deque<Integer> actual = app.build(array);
        System.out.println(actual);
        Deque<Integer> expected = new LinkedList<>(Arrays.asList(1, 2, 3, 2, 1));
        assertEquals(actual, expected);
    }

    @Test
    public void testBuild_ArbitraryOrderTwoRedundant_SymmetricLadderOneMax() {
        int[] array = {3, 1, 1, 1, 2, 2, 2};
        Deque<Integer> actual = app.build(array);
        System.out.println(actual);
        Deque<Integer> expected = new LinkedList<>(Arrays.asList(1, 2, 3, 2, 1));
        assertEquals(actual, expected);
    }

    @Test
    public void testBuild_AscendingOrder_OneSideLadder() {
        int[] array = {1, 2, 3};
        Deque<Integer> actual = app.build(array);
        System.out.println(actual);
        Deque<Integer> expected = new LinkedList<>(Arrays.asList(3, 2, 1));
        assertEquals(actual, expected);
    }
}