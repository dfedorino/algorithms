package com.dfedorino.rtasks.second_level;

import lombok.Getter;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BinaryStringBuilder {
    private final int[] possibleValues;
    private final int[] combination;
    @Getter
    private final String[] combinations;
    private int combinationIndex;

    public BinaryStringBuilder(int combinationLength, int... possibleValues) {
        this.possibleValues = possibleValues;
        combination = new int[combinationLength];
        combinations = new String[(int) Math.pow(possibleValues.length, combinationLength)];
    }

    public void buildFromEnd(int index) {
        if (index == -1) {
            combinations[combinationIndex++] = Arrays.stream(combination)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(""));
        } else {
            for (int value : possibleValues) {
                combination[index] = value;
                buildFromEnd(index - 1);
            }
        }
    }

    public void buildFromBeginning(int index) {
        if (index == combination.length) {
            combinations[combinationIndex++] = Arrays.stream(combination)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(""));
        } else {
            for (int value : possibleValues) {
                combination[index] = value;
                buildFromBeginning(index + 1);
            }
        }
    }
}
