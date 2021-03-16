package com.dfedorino.rtasks.first_task;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MachineDistributorTest {
    @Test
    public void constructorTest() {
        MachineDistributor md = new MachineDistributor(16);
        assertSame(md, md);
    }
}