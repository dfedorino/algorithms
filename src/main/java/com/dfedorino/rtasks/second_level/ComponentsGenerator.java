package com.dfedorino.rtasks.second_level;

import java.util.ArrayList;
import java.util.List;

public class ComponentsGenerator {
    public List<String> generateComponentsOf(int number) {
        if (number == 1) {
            return List.of("1");
        } else {
            List<String> currentComponents = new ArrayList<>();
            for (int digitToBeAdded = 1; digitToBeAdded < number; digitToBeAdded++) {
                List<String> prev = generateComponentsOf(number - digitToBeAdded);
                for (String component : prev) {
                    char componentLastDigitChar = component.charAt(component.length() - 1);
                    int componentLastDigit = Integer.parseInt(String.valueOf(componentLastDigitChar));
                    if (digitToBeAdded <= componentLastDigit) {
                        currentComponents.add(component + digitToBeAdded);
                    }
                }
            }
            currentComponents.add(number + "");
            return currentComponents;
        }
    }
}
