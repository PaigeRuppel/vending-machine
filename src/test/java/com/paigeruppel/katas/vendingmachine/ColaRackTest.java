package com.paigeruppel.katas.vendingmachine;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ColaRackTest {

    private ColaRack underTest;

    @Test
    public void colaRackShouldHoldTwentyColas() {
        underTest = new ColaRack();
        underTest.stock();
        assertThat(underTest.availableNumberProducts(), is(20));
    }

    @Test
    public void unstockedColaRackIsSoldOut() {
        underTest = new ColaRack();
        assertTrue(underTest.isSoldOut());
    }

    @Test
    public void stockedColaRackIsNotSoldOut() {
        underTest = new ColaRack();
        underTest.stock();
        assertFalse(underTest.isSoldOut());
    }

    @Test
    public void dispenseShouldRemoveOneColaFromInventory() {
        underTest = new ColaRack();
        underTest.stock();
        underTest.dispense();
        assertThat(underTest.availableNumberProducts(), is(19));
    }
}
