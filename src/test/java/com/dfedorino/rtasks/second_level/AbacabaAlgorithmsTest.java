package com.dfedorino.rtasks.second_level;

import com.dfedorino.rtasks.Algorithms;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.concurrent.Callable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class AbacabaAlgorithmsTest {
    private final Algorithms algorithmChecker = new Algorithms(10);

    @Test(dataProvider = "task-algorithms")
    public void testOutputFor_MinValue1_A(String testCase, Algorithm<Integer, String> algorithm) throws Exception {
        int input = 1;
        Callable<String> task = () -> algorithm.outputFor(input);
        assertThat(task.call()).isEqualTo("A");
        System.out.printf("input -> %s, %s, %s, %s" + System.lineSeparator(),
                input,
                testCase,
                algorithmChecker.consumedTime(task),
                algorithmChecker.consumedRam(task)
        );
    }

    @Test(dataProvider = "task-algorithms")
    public void testOutputFor_MaxValue6_ABACABADABACABAEABACABADABACABAFABACABADABACABAEABACABADABACABA
            (String testCase, Algorithm<Integer, String> algorithm) throws Exception {
        int input = 6;
        Callable<String> task = () -> algorithm.outputFor(input);
        assertThat(task.call()).isEqualTo("ABACABADABACABAEABACABADABACABAFABACABADABACABAEABACABADABACABA");
        System.out.printf("input -> %s, %s, %s, %s" + System.lineSeparator(),
                input,
                testCase,
                algorithmChecker.consumedTime(task),
                algorithmChecker.consumedRam(task)
        );
    }

    @Test(dataProvider = "task-algorithms")
    public void testOutputFor_TaskCase3_ABACABA (String testCase, Algorithm<Integer, String> algorithm) throws Exception {
        int input = 3;
        Callable<String> task = () -> algorithm.outputFor(input);
        assertThat(task.call()).isEqualTo("ABACABA");
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
                {"Recursive", new AbacabaRecursive()},
//                {"Iterative", new AbacabaIterative()}
        };
    }

    public static void main(String[] args) {
        //[A, B, A, C, A, B, A, D, A, B, A, C, A, B, A, E]
        // 1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16

        //[A, B, C, D, E, F]
        // 1  2  3  4  5  6
        String[] letters = {"A", "B", "C", "D", "E", "F"};
        String[] result = new String[31];
        int middleIndex = result.length / 2;
        result[middleIndex] = letters[(int) Math.sqrt(result.length)];
        for (int i = 0; i < result.length / 2; i++) {
            if (i % 2 == 0) {
//                System.out.print(letters[0]);
                result[i] = letters[0];
                result[result.length - 1 - i] = letters[0];
            } else {
                int pow = (int) Math.round(Math.sqrt(i + 1));
                int biggestPowerOfTwo = (int) Math.pow(2, pow);
                boolean isPowerOfTwo = (i + 1) % biggestPowerOfTwo == 0;
                if (isPowerOfTwo) {
//                    System.out.print(letters[pow]);
                    result[i] = letters[pow];
                    result[result.length - 1 - i] = letters[pow];
                } else {
//                    System.out.print(letters[i % biggestPowerOfTwo]);
                    result[i] = letters[i % biggestPowerOfTwo];
                    result[result.length - 1 - i] = letters[i % biggestPowerOfTwo];
                }
//              System.out.println("i -> " + i + ", sqrt -> " + pow + ", biggest power of 2 -> " + biggestPowerOfTwo + ", is power of 2 -> " + isPowerOfTwo);
            }
        }
        System.out.println(Arrays.toString(result));
    }
}