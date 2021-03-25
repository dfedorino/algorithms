package com.dfedorino.rtasks.leet_code_hash_table;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LeetCodeTasksTest {
    @Test(dataProvider = "identical-pairs")
    public void numIdenticalPairsTest(int[] nums, int expectedPairs) {
        assertEquals(LeetCodeTasks.numIdenticalPairs(nums), expectedPairs);
    }

    @Test(dataProvider = "stones-and-jewels")
    public void numJewelsInStonesTest(String jewels, String stones, int expectedJewels) {
        assertEquals(LeetCodeTasks.numJewelsInStones(jewels, stones), expectedJewels);
    }

    @DataProvider(name = "identical-pairs")
    public Object[][] identicalPairsDataProvider() {
        return new Object[][] {
                {new int[] {1,2,3,1,1,3}, 4},
                {new int[] {1,1,1,1}, 6},
                {new int[] {1,2,3}, 0}
        };
    }

    @DataProvider(name = "stones-and-jewels")
    public Object[][] stonesAndJewelsDataProvider() {
        return new Object[][] {
                {"aA", "aAAbbbb", 3},
                {"z", "ZZ", 0}
        };
    }

}