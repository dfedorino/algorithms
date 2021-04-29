package com.dfedorino.rtasks.second_level;

import com.dfedorino.rtasks.Algorithms;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FibonacciAlgorithmsTest {
    private final Algorithms algorithmChecker = new Algorithms(10);

    @Test(dataProvider = "task-algorithms")
    public void testAlgorithm_FibonacciNumberFor0_0(String testCase, Algorithm<Integer, Integer> algorithm) {
        int input = 0;
        assertThat(algorithm.outputFor(input)).isEqualTo(0);
        Runnable task = () -> algorithm.outputFor(input);
        System.out.println("input -> " + input + ", " + testCase + ", " + algorithmChecker.consumedTime(task) + " " +
                algorithmChecker.consumedRam(task));
    }

    @Test(dataProvider = "task-algorithms")
    public void testAlgorithm_FibonacciNumberFor1_1(String testCase, Algorithm<Integer, Integer> algorithm) {
        int input = 1;
        assertThat(algorithm.outputFor(input)).isEqualTo(1);
        Runnable task = () -> algorithm.outputFor(input);
        System.out.println("input -> " + input + ", " + testCase + ", " + algorithmChecker.consumedTime(task) + " " +
                algorithmChecker.consumedRam(task));
    }

    @Test(dataProvider = "task-algorithms")
    public void testAlgorithm_TaskCaseFibonacciNumberFor3_2(String testCase, Algorithm<Integer, Integer> algorithm) {
        int input = 3;
        assertThat(algorithm.outputFor(input)).isEqualTo(2);
        Runnable task = () -> algorithm.outputFor(input);
        System.out.println("input -> " + input + ", " + testCase + ", " + algorithmChecker.consumedTime(task) + " " +
                algorithmChecker.consumedRam(task));
    }

    @Test(dataProvider = "task-algorithms")
    public void testAlgorithm_FibonacciNumberFor30_832040(String testCase, Algorithm<Integer, Integer> algorithm) {
        int input = 30;
        assertThat(algorithm.outputFor(input)).isEqualTo(832040);
        Runnable task = () -> algorithm.outputFor(input);
        System.out.println("input -> " + input + ", " + testCase + ", " + algorithmChecker.consumedTime(task) + " " +
                algorithmChecker.consumedRam(task));
    }

    @DataProvider(name = "task-algorithms")
    public Object[][] taskAlgorithms() {
        return new Object[][]{
                {"Recursive Solution", new FibonacciRecursive()},
                {"Iterative Solution", new FibonacciIterative()}
        };
    }
}