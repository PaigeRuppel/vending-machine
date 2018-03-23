package com.paigeruppel.katas.vendingmachine;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class CandyRackTest {

    private CandyRack underTest;

    @Test
    public void candyRackShouldHoldTwentyCandies() {
        underTest = new CandyRack();
        underTest.stock();
        assertThat(underTest.availableNumberProducts(), is(20));
    }

    @Test
    public void unstockedCandyRackShouldBeSoldOut() {
        underTest = new CandyRack();
        assertTrue(underTest.isSoldOut());
    }

    @Test
    public void stockedCandyRackIsNotSoldOut() {
        underTest = new CandyRack();
        underTest.stock();
        assertFalse(underTest.isSoldOut());
    }

    @Test
    public void dispenseShouldRemoveOneCandyFromInventory() throws SoldOutException {
        underTest = new CandyRack();
        underTest.stock();
        underTest.dispense();
        assertThat(underTest.availableNumberProducts(), is(19));
    }

    @Test
    public void twoDispensesShouldRemoveTwoCandiesFromInventory() throws SoldOutException {
        underTest = new CandyRack();
        underTest.stock();
        underTest.dispense();
        underTest.dispense();
        assertThat(underTest.availableNumberProducts(), is(18));
    }
}
