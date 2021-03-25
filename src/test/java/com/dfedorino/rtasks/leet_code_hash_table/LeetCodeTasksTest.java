package com.dfedorino.rtasks.leet_code_hash_table;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LeetCodeTasksTest {
    @Test(dataProvider = "identical-pairs")
    public void numIdenticalPairsTest(int[] nums, int expectedPairs) {
        assertEquals(LeetCodeTasks.numIdenticalPairs(nums), expectedPairs);
    }

    @DataProvider(name = "identical-pairs")
    public Object[][] identicalPairsDataProvider() {
        return new Object[][] {
                {new int[] {1,2,3,1,1,3}, 4}
        };
    }

}