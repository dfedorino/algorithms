package com.dfedorino.rtasks.first_task;

import java.util.Objects;

public class MachineDistributor {
    private final int ramPerMachine;

    public MachineDistributor(int ramPerMachine) {
        this.ramPerMachine = checkRam(ramPerMachine);
    }

    /**
     * Searches for the first element that is larger than the ramPerMachine value to exclude processes
     * with unsupported sizes from the search range.
     * @param sortedProcessArray - SORTED array with process ram consumption values
     * @throws IllegalArgumentException if null is passed or if the given array contains negative values
     * @return the first index of the unsupported element, otherwise -1
     */
    protected int getFirstUnsupportedProcessIndex(int[] sortedProcessArray) {
        Objects.requireNonNull(sortedProcessArray);
        for (int processIndex = 0; processIndex < sortedProcessArray.length; processIndex++) {
            if (checkRam(sortedProcessArray[processIndex]) > ramPerMachine) {
                return processIndex;
            }
        }
        return -1;
    }

    /**
     * Simple RAM value check
     * @param ramPerMachine - any int value that is supposed to represent RAM amount
     * @throws IllegalArgumentException when the given value does not satisfy conditions of a valid RAM amount
     * @return argument value
     */
    private int checkRam(int ramPerMachine) {
        if (ramPerMachine < 0) {
            throw new IllegalArgumentException("Given RAM amount is negative");
        }
        return ramPerMachine;
    }
}
