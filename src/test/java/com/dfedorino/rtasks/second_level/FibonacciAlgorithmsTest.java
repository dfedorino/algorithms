package com.dfedorino.rtasks.second_level;

import com.dfedorino.rtasks.Algorithms;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.Callable;

import static org.assertj.core.api.Assertions.assertThat;

public class FibonacciAlgorithmsTest {
    private final Algorithms algorithmChecker = new Algorithms(10);

    @Test(dataProvider = "task-algorithms")
    public void testAlgorithm_FibonacciNumberFor0_0(String testCase, Algorithm<Integer, Integer> algorithm) throws Exception {
        int input = 0;
        Callable<Integer> task = () -> algorithm.outputFor(input);
        assertThat(task.call()).isEqualTo(0);
        System.out.printf("input -> %s, %s, %s, %s" + System.lineSeparator(),
                input,
                testCase,
                algorithmChecker.consumedTime(task),
                algorithmChecker.consumedRam(task)
        );
    }

    @Test(dataProvider = "task-algorithms")
    public void testAlgorithm_FibonacciNumberFor1_1(String testCase, Algorithm<Integer, Integer> algorithm) throws Exception {
        int input = 1;
        Callable<Integer> task = () -> algorithm.outputFor(input);
        assertThat(task.call()).isEqualTo(1);
        System.out.printf("input -> %s, %s, %s, %s" + System.lineSeparator(),
                input,
                testCase,
                algorithmChecker.consumedTime(task),
                algorithmChecker.consumedRam(task)
        );
    }

    @Test(dataProvider = "task-algorithms")
    public void testAlgorithm_TaskCaseFibonacciNumberFor3_2(String testCase, Algorithm<Integer, Integer> algorithm) throws Exception {
        int input = 3;
        Callable<Integer> task = () -> algorithm.outputFor(input);
        assertThat(task.call()).isEqualTo(2);
        System.out.printf("input -> %s, %s, %s, %s" + System.lineSeparator(),
                input,
                testCase,
                algorithmChecker.consumedTime(task),
                algorithmChecker.consumedRam(task)
        );
    }

    @Test(dataProvider = "task-algorithms")
    public void testAlgorithm_FibonacciNumberFor30_832040(String testCase, Algorithm<Integer, Integer> algorithm) throws Exception {
        int input = 30;
        Callable<Integer> task = () -> algorithm.outputFor(input);
        assertThat(task.call()).isEqualTo(832040);
        System.out.printf("input -> %s, %s, %s, %s" + System.lineSeparator(),
                input,
                testCase,
                algorithmChecker.consumedTime(task),
                algorithmChecker.consumedRam(task)
        );
    }

    @DataProvider(name = "task-algorithms")
    public Object[][] taskAlgorithms() {
        return new Object[][]{
                {"Recursive", new FibonacciRecursive()},
                {"Iterative", new FibonacciIterative()}
        };
    }
}