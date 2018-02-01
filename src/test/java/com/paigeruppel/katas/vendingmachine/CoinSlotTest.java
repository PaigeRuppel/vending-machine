package com.paigeruppel.katas.vendingmachine;

import org.junit.Before;
import org.junit.Test;

import static com.paigeruppel.katas.vendingmachine.Coin.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class CoinSlotTest {

    private CoinSlot underTest;

    @Before
    public void setup() {
        underTest = new CoinSlot();
    }

    @Test
    public void shouldReturnValue5WhenNickelIsAccepted() {
        assertTrue(underTest.isValid(NICKEL));
    }

    @Test
    public void shouldReturnValue10WhenDimeIsAccepted() {
        assertThat(underTest.validateCoin(DIME), is(0.10));
    }

    @Test
    public void shouldReturnValue25WhenQuarterIsAccepted() {
        assertThat(underTest.validateCoin(QUARTER), is(0.25));
    }


    @Test
    public void pennyShouldGiveZeroValue() {
        assertThat(underTest.validateCoin(PENNY), is(0.0));
    }


}
