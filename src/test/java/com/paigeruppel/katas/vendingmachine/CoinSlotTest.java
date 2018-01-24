package com.paigeruppel.katas.vendingmachine;

import org.junit.Before;
import org.junit.Test;

import static com.paigeruppel.katas.vendingmachine.Coin.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CoinSlotTest {

    private CoinSlot underTest;

    @Before
    public void setup() {
        underTest = new CoinSlot();
    }

    @Test
    public void shouldReturnValue5WhenNickelIsAccepted() {
        assertThat(underTest.validateCoin(NICKEL), is(0.05));
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
        assertThat(underTest.validateCoin(PENNY), is(0));
    }


}
