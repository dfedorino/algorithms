package com.dfedorino.rtasks.first_task;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

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

    @Test(
            expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Given RAM amount is negative"
    )
    public void checkRamTest() {
        MachineDistributor md = new MachineDistributor(-16);
        MachineDistributor md1 = new MachineDistributor(Integer.MIN_VALUE);
    }
}