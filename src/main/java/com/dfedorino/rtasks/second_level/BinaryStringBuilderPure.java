package com.dfedorino.rtasks.second_level;

import java.util.ArrayList;
import java.util.List;

public class BinaryStringBuilderPure {
    public List<String> getAllPossibleCombinationsForLength(int numberLength) {
        if (numberLength == 1) {
            System.out.println(">> Length is 1, current combinations are -> [0, 1]");
            System.out.println();
            return List.of("0", "1");
        } else {
            List<String> currentCombinations = new ArrayList<>();
            List<String> shorterCombinations = getAllPossibleCombinationsForLength(numberLength - 1);
            System.out.println(">> Current length " + numberLength + ", got shorter combinations -> " + shorterCombinations);
            for (int possibleValue = 0; possibleValue < 2; possibleValue++) {
                for (String shorterCombination : shorterCombinations) {
                    System.out.println(">> Merging " + possibleValue + " with " + shorterCombination);
                    currentCombinations.add(possibleValue + shorterCombination);
                }
            }
            System.out.println(">> Final combinations for length " + numberLength + " -> " + currentCombinations);
            System.out.println();
            return currentCombinations;
        }
    }
}
