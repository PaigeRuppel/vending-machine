package com.paigeruppel.katas.vendingmachine;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ChipsRackTest {

    private ChipsRack underTest;

    @Test
    public void chipsRackShouldHoldTwentyChips() {
        underTest = new ChipsRack();
        underTest.stock();
        assertThat(underTest.availableNumberProducts(), is(20));
    }

    @Test
    public void chipsRackShouldOnlyHoldTwentyChipsEvenIfStockedTwice() {
        underTest = new ChipsRack();
        underTest.stock();
        underTest.stock();
        assertThat(underTest.availableNumberProducts(), is(20));
    }

    @Test
    public void unstockedChipsRackIsSoldOut() {
        underTest = new ChipsRack();
        assertTrue(underTest.isSoldOut());
    }

    @Test
    public void dispensingOneProductShouldRemoveOneFromInventory() {
        underTest = new ChipsRack();
        underTest.stock();
        underTest.dispense();
        assertThat(underTest.availableNumberProducts(), is(19));
    }

    @Test
    public void dispensingTwoProductsShouldRemoveTwoFromInventory() {
        underTest = new ChipsRack();
        underTest.stock();
        underTest.dispense();
        underTest.dispense();
        assertThat(underTest.availableNumberProducts(), is(18));
    }


}
