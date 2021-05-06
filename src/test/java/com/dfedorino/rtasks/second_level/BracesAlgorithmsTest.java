package com.dfedorino.rtasks.second_level;

import com.dfedorino.rtasks.Algorithms;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.Callable;

import static org.assertj.core.api.Assertions.assertThat;

public class BracesAlgorithmsTest {

    private final Algorithms algorithmChecker = new Algorithms(10);

    @Test(dataProvider = "task-algorithms")
    public void testOutputFor_TaskCaseOddLengthString_OneCharInTheMiddle(String testCase, Algorithm<String, String> algorithm) throws Exception {
        String input = "example";
        Callable<String> task = () -> algorithm.outputFor(input);
        assertThat(task.call()).isEqualTo("e(x(a(m)p)l)e");
        System.out.printf("input -> %s, %s, %s, %s" + System.lineSeparator(),
                input,
                testCase,
                algorithmChecker.consumedTime(task),
                algorithmChecker.consumedRam(task)
        );
    }

    @Test(dataProvider = "task-algorithms")
    public void testOutputFor_TaskCaseEvenLengthString_TwoCharsInTheMiddle(String testCase, Algorithm<String, String> algorithm) throws Exception {
        String input = "card";
        Callable<String> task = () -> algorithm.outputFor(input);
        assertThat(task.call()).isEqualTo("c(ar)d");
        System.out.printf("input -> %s, %s, %s, %s" + System.lineSeparator(),
                input,
                testCase,
                algorithmChecker.consumedTime(task),
                algorithmChecker.consumedRam(task)
        );
    }

    @Test(dataProvider = "task-algorithms")
    public void testOutputFor_MinEvenLengthString_TwoCharsInTheMiddle(String testCase, Algorithm<String, String> algorithm) throws Exception {
        String input = "aa";
        Callable<String> task = () -> algorithm.outputFor(input);
        assertThat(task.call()).isEqualTo("aa");
        System.out.printf("input -> %s, %s, %s, %s" + System.lineSeparator(),
                input,
                testCase,
                algorithmChecker.consumedTime(task),
                algorithmChecker.consumedRam(task)
        );
    }

    @Test(dataProvider = "task-algorithms")
    public void testOutputFor_MinOddLengthString_TwoCharsInTheMiddle(String testCase, Algorithm<String, String> algorithm) throws Exception {
        String input = "a";
        Callable<String> task = () -> algorithm.outputFor(input);
        assertThat(task.call()).isEqualTo("a");
        System.out.printf("input -> %s, %s, %s, %s" + System.lineSeparator(),
                input,
                testCase,
                algorithmChecker.consumedTime(task),
                algorithmChecker.consumedRam(task)
        );
    }

    @Test(dataProvider = "task-algorithms")
    public void testOutputFor_MaxEvenLengthString_TwoCharsInTheMiddle(String testCase, Algorithm<String, String> algorithm) throws Exception {
        String input = copyString(1000, "a");
        Callable<String> task = () -> algorithm.outputFor(input);
        String expectedStringBuilder =
                copyString(499, "a(") + "aa" + copyString(499, ")a");
        assertThat(task.call()).isEqualTo(expectedStringBuilder);
        System.out.printf("input -> %s, %s, %s, %s" + System.lineSeparator(),
                "a * 1000",
                testCase,
                algorithmChecker.consumedTime(task),
                algorithmChecker.consumedRam(task)
        );
    }

    @Test(dataProvider = "task-algorithms")
    public void testOutputFor_MaxOddLengthString_TwoCharsInTheMiddle(String testCase, Algorithm<String, String> algorithm) throws Exception {
        String input = copyString(999, "a");
        Callable<String> task = () -> algorithm.outputFor(input);
        String expectedStringBuilder =
                copyString(499, "a(") + "a" + copyString(499, ")a");
        assertThat(task.call()).isEqualTo(expectedStringBuilder);
        System.out.printf("input -> %s, %s, %s, %s" + System.lineSeparator(),
                "a * 999",
                testCase,
                algorithmChecker.consumedTime(task),
                algorithmChecker.consumedRam(task)
        );
    }

    private String copyString(int times, String stringToBeCopied) {
        StringBuilder inputBuilder = new StringBuilder(times);
        for (int i = 0; i < times; i++) {
            inputBuilder.append(stringToBeCopied);
        }
        return inputBuilder.toString();
    }

    @DataProvider(name = "task-algorithms")
    public Object[][] taskAlgorithms() {
        return new Object[][]{
                {"Recursive", new BracesRecursive()},
                {"Iterative", new BracesIterative()}
        };
    }
}