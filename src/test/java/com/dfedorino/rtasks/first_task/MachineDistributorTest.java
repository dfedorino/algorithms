package com.dfedorino.rtasks.first_task;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertSame;
import static org.testng.Assert.assertEquals;

public class MachineDistributorTest {
    @Test
    public void constructorTest() {
        MachineDistributor md = new MachineDistributor(16);
        MachineDistributor md1 = new MachineDistributor(0);
        MachineDistributor md2 = new MachineDistributor(Integer.MAX_VALUE);
        assertSame(md, md);
        assertSame(md1, md1);
        assertSame(md2, md2);
    }

    @Test(dataProvider = "data-provider-getFirstUnsupportedProcessIndex")
    public void getFirstUnsupportedProcessIndexTest(int[] sortedArray, int expectedIndex) {
        MachineDistributor md = new MachineDistributor(16);
        int actualIndex = md.getFirstUnsupportedProcessIndex(sortedArray);
        assertEquals(actualIndex, expectedIndex);
    }

    @Test(
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Given RAM amount is negative"
    )
    public void checkRamTest() {
        MachineDistributor md = new MachineDistributor(-16);
        MachineDistributor md1 = new MachineDistributor(Integer.MIN_VALUE);
    }

    @Test(
            expectedExceptions = NullPointerException.class
    )
    public void getFirstUnsupportedProcessIndexNullTest() {
        MachineDistributor md = new MachineDistributor(16);
        md.getFirstUnsupportedProcessIndex(null);
    }

    @Test(
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Given RAM amount is negative"
    )
    public void checkGivenNegativeRamValuesTest() {
        MachineDistributor md = new MachineDistributor(16);
        md.getFirstUnsupportedProcessIndex(new int[] {Integer.MIN_VALUE});
    }

    // input, expected
    @DataProvider(name = "data-provider-getFirstUnsupportedProcessIndex")
    public Object[][] dataProviderGetFirstUnsupportedProcessIndex() {
        return new Object[][] {
                { new int[] {}, -1 },
                { new int[] {16}, -1 },
                { new int[] {2, 4, 6, 5, 8, 14, 16}, -1 },
                { new int[] {Integer.MAX_VALUE}, 0 },
                { new int[] {2, 4, 6, 5, 8, 14, 16, Integer.MAX_VALUE}, 7 },
                { new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE}, 0 }
        };
    }
}