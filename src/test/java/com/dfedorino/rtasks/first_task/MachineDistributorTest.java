package com.dfedorino.rtasks.first_task;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MachineDistributorTest {
    @Test (dataProvider = "one-process")
    public void testGetFullyLoadedMachines_OneProcess(String testCase, int ram, int[] processes, int expected) {
        assertEquals(MachineDistributor.getFullyLoadedMachines(ram,  processes), expected);
    }

    @Test (dataProvider = "even-number-of-processes")
    public void testGetFullyLoadedMachines_evenNumberOfProcesses(String testCase, int ram, int[] processes, int expected) {
        assertEquals(MachineDistributor.getFullyLoadedMachines(ram,  processes), expected);
    }

    @Test (dataProvider = "one-process")
    public void testGetFullyLoadedMachinesWithPointers_OneProcess(String testCase, int ram, int[] processes, int expected) {
        assertEquals(MachineDistributor.getFullyLoadedMachinesWithTwoPointers(ram,  processes), expected);
    }

    @Test (dataProvider = "even-number-of-processes")
    public void testGetFullyLoadedMachinesWithPointers_evenNumberOfProcesses(String testCase, int ram, int[] processes, int expected) {
        assertEquals(MachineDistributor.getFullyLoadedMachinesWithTwoPointers(ram,  processes), expected);
    }

    @Test (dataProvider = "one-process")
    public void testGetFullyLoadedMachinesWithMap_OneProcess(String testCase, int ram, int[] processes, int expected) {
        assertEquals(MachineDistributor.getFullyLoadedMachinesWithMap(ram,  processes), expected);
    }

    @Test (dataProvider = "even-number-of-processes")
    public void testGetFullyLoadedMachinesWithMap_evenNumberOfProcesses(String testCase, int ram, int[] processes, int expected) {
        assertEquals(MachineDistributor.getFullyLoadedMachinesWithMap(ram,  processes), expected);
    }

    @Test(dataProvider = "data-provider-getFullyLoadedMachines")
    public void getFullyLoadedMachinesWithMapTest(int ramPerMachine, int[] processesRam, int expectedMachineNumber) {
        int actualMachineNumber = MachineDistributor.getFullyLoadedMachinesWithMap(ramPerMachine, processesRam);
        assertEquals(actualMachineNumber, expectedMachineNumber);
    }

    @Test(dataProvider = "data-provider-getFullyLoadedMachines")
    public void getFullyLoadedMachinesWithTwoPointersTest(int ramPerMachine, int[] processesRam, int expectedMachineNumber) {
        int actualMachineNumber = MachineDistributor.getFullyLoadedMachinesWithTwoPointers(ramPerMachine, processesRam);
        assertEquals(actualMachineNumber, expectedMachineNumber);
    }

    @Test(dataProvider = "data-provider-getFullyLoadedMachines")
    public void getFullyLoadedMachinesTest(int ramPerMachine, int[] processesRam, int expectedMachineNumber) {
        int actualMachineNumber = MachineDistributor.getFullyLoadedMachines(ramPerMachine, processesRam);
        assertEquals(actualMachineNumber, expectedMachineNumber);
    }

    @Test(
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Given RAM amount is negative"
    )
    public void getFullyLoadedMachinesNegativeValueTest() {
        MachineDistributor.getFullyLoadedMachines(16, new int[]{Integer.MIN_VALUE});
    }

    @Test(
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Given RAM amount is negative"
    )
    public void checkRamTest() {
        MachineDistributor.getFullyLoadedMachines(Integer.MIN_VALUE, new int[] {});
        MachineDistributor.getFullyLoadedMachinesWithTwoPointers(Integer.MIN_VALUE, new int[] {});
        MachineDistributor.getFullyLoadedMachinesWithMap(Integer.MIN_VALUE, new int[] {});
    }

    @DataProvider(name ="one-process")
    public Object[][] oneProcess() {
        return new Object[][] {
                {"One process more than RAM", 16, new int[] {Integer.MAX_VALUE}, 0},
                {"One process equal to RAM", 16, new int[] {16}, 1},
                {"One process less than RAM", 16, new int[] {8}, 0},
                {"One process equal to zero", 16, new int[] {0}, 0},
                {"One process less than zero", 16, new int[] {Integer.MIN_VALUE}, 0}
        };
    }

    @DataProvider(name ="even-number-of-processes")
    public Object[][] evenNumberOfProcesses() {
        return new Object[][] {
                {"One process is equal to RAM, another is 0", 16, new int[] {16, 0}, 1},
                {"Two processes are equal to half RAM", 16, new int[] {8, 8}, 1},
                {"Two processes in sum are equal to RAM", 16, new int[] {14, 2}, 1},
                {"Even number of processes equal to half RAM", 16, new int[] {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8}, 6},
                {"Even number of processes equal to RAM", 16, new int[] {1, 2, 3, 4, 16, 16, 16, 16}, 4},
                {"Odd number of processes equal to RAM", 16, new int[] {1, 2, 3, 16, 16, 16, 17, 18}, 3},
                {"All elements are less than RAM", 16, new int[] {4, 2, 1, 3}, 0},
                {"All elements are more than RAM", 16, new int[] {24, 22, 21, 23}, 0},
        };
    }

    @DataProvider(name = "data-provider-getFullyLoadedMachines")
    public Object[][] dataProviderGetFullyLoadedMachines() {
        int max = Integer.MAX_VALUE - 1;
        int halfMax = Integer.MAX_VALUE / 2;
        return new Object[][]{
                // zero elements
                //ramPerMachine,    processes,      expected loaded machines
                {16,                new int[]{},    0},
                {max, new int[]{}, 0},

                // one element
                {16, new int[]{16}, 1},
                {16, new int[]{8}, 0},
                {16, new int[]{0}, 0},
                {16, new int[]{max}, 0},

                {max, new int[]{16}, 0},
                {max, new int[]{halfMax}, 0},
                {max, new int[]{0}, 0},
                {max, new int[]{max}, 1},

                // two elements, important for the algorithm with indexes
                {16, new int[]{16, 16}, 2},
                {16, new int[]{8, 8}, 1},
                {16, new int[]{0, 0}, 0},
                {16, new int[]{max, max}, 0},
                {16, new int[]{16, 0}, 1},
                {16, new int[]{0, 16}, 1},
                {16, new int[]{14, 2}, 1},
                {16, new int[]{2, 14}, 1},
                {16, new int[]{0, 15}, 0},
                {16, new int[]{15, 2}, 0},

                {max, new int[]{16, 16}, 0},
                {max, new int[]{halfMax, halfMax}, 1},
                {max, new int[]{0, 0}, 0},
                {max, new int[]{max, max}, 2},
                {max, new int[]{max, 0}, 1},
                {max, new int[]{0, max}, 1},
                {max, new int[]{max - 2, 2}, 1},
                {max, new int[]{2, max - 2}, 1},
                {max, new int[]{0, max - 1}, 0},
                {max, new int[]{max - 1, 2}, 0},

                // odd number of elements
                {16, new int[]{16, 16, 16}, 3},
                {16, new int[]{8, 8, 8}, 1},
                {16, new int[]{0, 0, 0}, 0},
                {16, new int[]{max, max, max}, 0},
                {16, new int[]{16, 8, 0}, 1},
                {16, new int[]{0, 8, 16}, 1},
                {16, new int[]{8, 0, 16}, 1},
                {16, new int[]{16, 0, 8}, 1},
                {16, new int[]{16, 8, 8}, 2},
                {16, new int[]{8, 8, 16}, 2},
                {16, new int[]{max, max, 16}, 1},
                {16, new int[]{16, max, max}, 1},

                {max, new int[]{16, 16, 16}, 0},
                {max, new int[]{16, max, max}, 2},
                {max, new int[]{max, max, 16}, 2},
                {max, new int[]{halfMax, halfMax, halfMax}, 1},
                {max, new int[]{0, 0, 0}, 0},
                {max, new int[]{max, max, max}, 3},
                {max, new int[]{max, halfMax, 0}, 1},
                {max, new int[]{0, halfMax, max}, 1},
                {max, new int[]{halfMax, 0, max}, 1},
                {max, new int[]{max, 0, halfMax}, 1},
                {max, new int[]{max, halfMax, halfMax}, 2},
                {max, new int[]{halfMax, halfMax, max}, 2},

                // even number of elements
                {16, new int[]{16, 16, 16, 16}, 4},
                {16, new int[]{0, 0, 0, 0}, 0},
                {16, new int[]{0, 1, 2, 3, max}, 0},
                {16, new int[]{max, 0, 1, 2, 3}, 0},
                {16, new int[]{2, 14, 14, 14}, 1},
                {16, new int[]{14, 14, 14, 2}, 1},

                {max, new int[]{max, max, max, max}, 4},
                {max, new int[]{0, 0, 0, 0}, 0},
                {max, new int[]{0, 1, 2, 3, max}, 1},
                {max, new int[]{max, 0, 1, 2, 3}, 1},
                {max, new int[]{2, max - 2, max - 2, max - 2}, 1},
                {max, new int[]{max - 2, max - 2, max - 2, 2}, 1},

                // random tests
                {16, new int[]{14, 5, 6, 2, 4, 16, 8}, 2},
                {16, new int[]{max, 14, 5, 6, 2, 4, 16, 8}, 2},
        };
    }
}