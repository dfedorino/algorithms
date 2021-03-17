package com.dfedorino.rtasks.first_task;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MachineDistributorTest {
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

    // input, expected
    @DataProvider(name = "data-provider-getFullyLoadedMachines")
    public Object[][] dataProviderGetFullyLoadedMachines() {
        return new Object[][]{
                {16, new int[]{14, 5, 6, 2, 4, 16, 8}, 2},
                {16, new int[]{16, 16, 16, 16}, 4},
                {16, new int[]{0, 0, 0, 0}, 0},
                {16, new int[]{0, 1, 2, 3, Integer.MAX_VALUE}, 0},
                {16, new int[]{Integer.MAX_VALUE, 0, 1, 2, 3}, 0},
                {16, new int[]{2, 14, 14, 14}, 1},
                {16, new int[]{14, 14, 14, 2}, 1},
                {16, new int[]{Integer.MAX_VALUE, 14, 5, 6, 2, 4, 16, 8}, 2},
                {16, new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, 16}, 1},
                {16, new int[]{16, Integer.MAX_VALUE, Integer.MAX_VALUE}, 1},
                {Integer.MAX_VALUE, new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE}, 2},
                {Integer.MAX_VALUE, new int[]{16, Integer.MAX_VALUE, Integer.MAX_VALUE}, 2},
                {Integer.MAX_VALUE, new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, 16}, 2}
        };
    }
}