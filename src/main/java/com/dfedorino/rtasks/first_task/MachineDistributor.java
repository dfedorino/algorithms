package com.dfedorino.rtasks.first_task;

import java.util.Arrays;
import java.util.Objects;

public class MachineDistributor {
    private final int ramPerMachine;

    public MachineDistributor(int ramPerMachine) {
        this.ramPerMachine = checkRam(ramPerMachine);
    }

    /**
     * Algorithm is designed to return the amount of fully loaded machines with {@code ramPerMachine} memory
     * available. The machine can run only 2 task simultaneously, so it is considered to be fully loaded
     * in the following cases:
     * 1. any task in the processes array consumes the {@code ramPerMachine} amount of memory;
     * 2. any two tasks consume the ramPerMachine amount of memory in total.
     *
     * @param processes - array that represents processes' RAM consumption
     * @return number of the fully loaded machines
     * @throws IllegalArgumentException if any of the processes' value is negative
     * @throws NullPointerException     if the given array is {@code null}
     */
    public int getFullyLoadedMachines(int[] processes) {
        Objects.requireNonNull(processes);
        int[] processesSortedCopy = getSortedCopy(processes);
        int fullyUsedMachines = 0;
        for (int processIndex = 0; processIndex < processesSortedCopy.length; processIndex++) {
            int currentProcess = checkRam(processesSortedCopy[processIndex]);
            if (currentProcess > ramPerMachine) break;
            int ramRemainderIndex = Arrays.binarySearch(processesSortedCopy, ramPerMachine - currentProcess);
            if (currentProcess == ramPerMachine || ramRemainderIndex >= 0) {
                eraseCheckedProcesses(processesSortedCopy, processIndex, ramRemainderIndex);
                fullyUsedMachines++;
            }
        }
        return fullyUsedMachines;
    }

    public int getFullyLoadedMachinesWithTwoPointers(int ramPerMachine, int[] processes) {
        Objects.requireNonNull(processes);
        int[] processesSortedCopy = getSortedCopy(processes);
        if (processes.length == 0) return 0;
        if (processes.length == 1) return processes[0] == ramPerMachine ? 1 : 0;
        int middleIndex = processesSortedCopy.length / 2;
        int fullyLoadedMachines = 0;
        for (int leftIndex = 0, rightIndex = processes.length - 1; leftIndex < middleIndex & rightIndex >= middleIndex;) {
            int rightElement = processesSortedCopy[rightIndex];
            int leftElement = processesSortedCopy[leftIndex];
            int sum = rightElement + leftElement;
            if (leftElement == ramPerMachine || rightElement == ramPerMachine) {
                if (leftElement == rightElement & leftElement == ramPerMachine) {
                    return processes.length;
                }
                if (leftElement == ramPerMachine) {
                    fullyLoadedMachines++;
                    leftIndex++;
                }
                if (rightElement == ramPerMachine) {
                    fullyLoadedMachines++;
                    rightIndex--;
                }
            } else {
                if (sum <= 0) {
                    rightIndex--;
                } else {
                    if (sum == ramPerMachine) {
                        fullyLoadedMachines++;
                        leftIndex++;
                        rightIndex--;
                    }
                    if (sum < ramPerMachine) {
                        leftIndex++;
                    }
                    if (sum > ramPerMachine) {
                        rightIndex--;
                    }
                }
            }
        }
        return fullyLoadedMachines;
    }

    /**
     * Rewrites with 0 all the values to avoid repeated use of the distributed processes.
     *
     * @param supportedProcesses - array of the processes' RAM consumption values to be updated
     * @param processIndex       - current process's RAM consumption value is to be erased
     * @param ramRemainderIndex  - process which RAM consumption is used to fully load a machine and which
     *                           value is to be erased
     */
    private void eraseCheckedProcesses(int[] supportedProcesses, int processIndex, int ramRemainderIndex) {
        supportedProcesses[processIndex] = 0;
        if (ramRemainderIndex >= 0) {
            supportedProcesses[ramRemainderIndex] = 0;
        }
    }

    /**
     * Copies the given array and sorts the copy.
     *
     * @param givenProcesses - given array with processes' RAM consumption
     * @return a sorted copy of the given array
     */
    private int[] getSortedCopy(int[] givenProcesses) {
        int[] sortedCopy = new int[givenProcesses.length];
        System.arraycopy(givenProcesses, 0, sortedCopy, 0, givenProcesses.length); // around O(n)
        Arrays.sort(sortedCopy); // O(n log(n))
        return sortedCopy;
    }

    /**
     * Simple RAM value check.
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
