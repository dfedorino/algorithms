package com.dfedorino.rtasks.first_task;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MachineDistributorTest {
    @Test(dataProvider = "data-provider-getFullyLoadedMachines")
    public void getFullyLoadedMachinesWithTwoPointersTest(int ramPerMachine, int[] processesRam, int expectedMachineNumber) {
        MachineDistributor md = new MachineDistributor(ramPerMachine);
        int actualMachineNumber = md.getFullyLoadedMachinesWithTwoPointers(ramPerMachine, processesRam);
        assertEquals(actualMachineNumber, expectedMachineNumber);
    }

    @Test(dataProvider = "data-provider-getFullyLoadedMachines")
    public void getFullyLoadedMachinesTest(int ramPerMachine, int[] processesRam, int expectedMachineNumber) {
        MachineDistributor md = new MachineDistributor(ramPerMachine);
        int actualMachineNumber = md.getFullyLoadedMachines(processesRam);
        assertEquals(actualMachineNumber, expectedMachineNumber);
    }

    @Test(
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Given RAM amount is negative"
    )
    public void getFullyLoadedMachinesNegativeValueTest() {
        MachineDistributor md = new MachineDistributor(16);
        md.getFullyLoadedMachines(new int[]{Integer.MIN_VALUE});
    }

    @Test(
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Given RAM amount is negative"
    )
    public void checkRamTest() {
        MachineDistributor md = new MachineDistributor(-16);
        MachineDistributor md1 = new MachineDistributor(Integer.MIN_VALUE);
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