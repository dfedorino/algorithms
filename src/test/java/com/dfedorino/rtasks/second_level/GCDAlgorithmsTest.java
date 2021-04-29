package com.dfedorino.rtasks.second_level;

import com.dfedorino.rtasks.Algorithms;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.concurrent.Callable;

import static org.assertj.core.api.Assertions.assertThat;

public class GCDAlgorithmsTest {
    private final Algorithms algorithmChecker = new Algorithms(10);

    @Test(dataProvider = "task-algorithms")
    public void testOutputFor_TaskCase12And42_6(String testCase, Algorithm<Long, Integer> algorithm) throws Exception {
        long[] input = {12, 42};
        Callable<Integer> task = () -> algorithm.outputFor(input[0], input[1]);
        assertThat(task.call()).isEqualTo(6);
        System.out.printf("input -> %s, %s, %s, %s" + System.lineSeparator(),
                Arrays.toString(input),
                testCase,
                algorithmChecker.consumedTime(task),
                algorithmChecker.consumedRam(task)
        );
    }

    @Test(dataProvider = "task-algorithms")
    public void testOutputFor_PrimeNumberAndMaxInput_1(String testCase, Algorithm<Long, Integer> algorithm) throws Exception {
        long[] input = {326687, (long) 10E9};
        Callable<Integer> task = () -> algorithm.outputFor(input[0], input[1]);
        assertThat(task.call()).isEqualTo(1);
        System.out.printf("input -> %s, %s, %s, %s" + System.lineSeparator(),
                Arrays.toString(input),
                testCase,
                algorithmChecker.consumedTime(task),
                algorithmChecker.consumedRam(task)
        );
    }

    @DataProvider(name = "task-algorithms")
    public Object[][] taskAlgorithms() {
        return new Object[][] {
                {"Recursive", new GCDRecursive()},
                {"Iterative", new GCDIterative()}
        };
    }
}