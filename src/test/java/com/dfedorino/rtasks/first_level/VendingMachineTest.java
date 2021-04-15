package com.dfedorino.rtasks.first_level;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class VendingMachineTest {
    private final VendingMachine app = new VendingMachine();

    @Test
    public void testGetInitialChangeQuantity_OneCoinTwoBanknotes_19() {
        int[] purchases = {10, 5, 100};
        int actual = app.getInitialChangeQuantity(purchases);
        assertEquals(actual, 19);
    }

    @Test
    public void testGetInitialChangeQuantity_TwoCoinsOneBanknote_0() {
        int[] purchases = {5, 5, 10};
        int actual = app.getInitialChangeQuantity(purchases);
        assertEquals(actual, 0);
    }

    @Test
    public void testGetInitialChangeQuantity_NoCoinsTwoBanknotes_20() {
        int[] purchases = {10, 100};
        int actual = app.getInitialChangeQuantity(purchases);
        assertEquals(actual, 20);
    }

    @Test
    public void testGetInitialChangeQuantity_CoinsOnly_0() {
        int[] purchases = {5, 5, 5};
        int actual = app.getInitialChangeQuantity(purchases);
        assertEquals(actual, 0);
    }
}