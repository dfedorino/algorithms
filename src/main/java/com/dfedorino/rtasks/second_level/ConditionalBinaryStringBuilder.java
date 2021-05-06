package com.dfedorino.rtasks.second_level;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConditionalBinaryStringBuilder {
    private final int counterValue;
    private final int[] combination;
    @Getter
    private final List<String> combinations = new ArrayList<>();

    public ConditionalBinaryStringBuilder(int combinationLength, int counterValue) {
        this.counterValue = counterValue;
        combination = new int[combinationLength];
    }

    public void buildFromBeginning(int counter, int index) {
        if (index == combination.length) {
            if (counter == counterValue) {
                String combinationString = Arrays.stream(combination)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(""));

                combinations.add(combinationString);
            }
        } else {
            combination[index] = 0;
            buildFromBeginning(counter, index + 1);
            combination[index] = 1;
            buildFromBeginning(++counter, index + 1);
        }
    }
}
