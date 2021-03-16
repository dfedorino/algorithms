package com.dfedorino.rtasks.first_task;

import java.util.Arrays;
import java.util.Objects;

public class MachineDistributor {
    private final int ramPerMachine;

    public MachineDistributor(int ramPerMachine) {
        this.ramPerMachine = checkRam(ramPerMachine);
    }

    /**
     * Algorithm is designed to return the amount of fully loaded machines with ramPerMachine memory
     * available. The machine can run only 2 task simultaneously, so it is considered to be fully loaded
     * in the following cases:
     * 1. any task in the processes array consumes the ramPerMachine amount of memory;
     * 2. any two tasks consume the ramPerMachine amount of memory in total;
     * @param processes - array that represents processes' RAM consumption
     * @throws IllegalArgumentException if any of the processes' value is negative
     * @throws NullPointerException if the given array is null
     * @return number of the fully loaded machines
     */
    public int getFullyLoadedMachines(int[] processes) {
        Objects.requireNonNull(processes);
        int[] theProcesses = new int[processes.length];
        System.arraycopy(processes, 0, theProcesses, 0, processes.length);
        Arrays.sort(theProcesses);
        int lastSupportedProcessIndex = getFirstUnsupportedProcessIndex(theProcesses) == -1
                ? theProcesses.length - 1
                : getFirstUnsupportedProcessIndex(theProcesses) - 1;
        int[] supportedProcesses = new int[lastSupportedProcessIndex + 1];
        System.arraycopy(theProcesses, 0, supportedProcesses, 0, lastSupportedProcessIndex + 1);
        int fullyUsedMachines = 0;
        for (int processIndex = lastSupportedProcessIndex; processIndex >= 0; processIndex--) {
            int currentProcess = supportedProcesses[processIndex];
            int ramRemainder = ramPerMachine - currentProcess;
            int ramRemainderIndex = Arrays.binarySearch(supportedProcesses, ramRemainder);
            boolean processEqualsRam = ramRemainder == 0;
            boolean twoProcessesEqualRam = ramRemainderIndex >= 0;
            if (processEqualsRam || twoProcessesEqualRam) {
                fullyUsedMachines++;
                supportedProcesses[processIndex] = 0;
                if (ramRemainderIndex >= 0) {
                    supportedProcesses[ramRemainderIndex] = 0;
                }
            }
        }
        return fullyUsedMachines;
    }

    /**
     * Searches for the first element that is larger than the ramPerMachine value to exclude processes
     * with unsupported sizes from the search range.
     *
     * @param sortedProcessArray - SORTED array with process ram consumption values
     * @return the first index of the unsupported element, otherwise -1
     * @throws IllegalArgumentException if null is passed or if the given array contains negative values
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
     *
     * @param ramPerMachine - any int value that is supposed to represent RAM amount
     * @return argument value
     * @throws IllegalArgumentException when the given value does not satisfy conditions of a valid RAM amount
     */
    private int checkRam(int ramPerMachine) {
        if (ramPerMachine < 0) {
            throw new IllegalArgumentException("Given RAM amount is negative");
        }
        return ramPerMachine;
    }
}
