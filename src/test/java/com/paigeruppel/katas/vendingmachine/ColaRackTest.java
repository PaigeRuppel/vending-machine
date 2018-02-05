package com.paigeruppel.katas.vendingmachine;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
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
}
