package com.paigeruppel.katas.vendingmachine;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.internal.matchers.Null;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ColaRackTest {

    private ColaRack underTest;

    @Before
    public void setup() {
        underTest = new ColaRack();
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void colaRackShouldHoldTwentyColas() {
        underTest.stock();
        assertThat(underTest.availableNumberProducts(), is(20));
    }

    @Test
    public void unstockedColaRackIsSoldOut() {
        assertTrue(underTest.isSoldOut());
    }

    @Test
    public void stockedColaRackIsNotSoldOut() {
        underTest.stock();
        assertFalse(underTest.isSoldOut());
    }

    @Test
    public void dispenseShouldRemoveOneColaFromInventory() throws SoldOutException {
        underTest.stock();
        underTest.dispense();
        assertThat(underTest.availableNumberProducts(), is(19));
    }

    @Test
    public void dispenseWithNoInventoryShouldThrowSoldOutException() throws SoldOutException {
        exception.expect(SoldOutException.class);
        underTest.dispense();
    }


}
