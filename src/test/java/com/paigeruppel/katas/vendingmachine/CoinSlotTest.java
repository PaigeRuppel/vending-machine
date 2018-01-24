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
    public void shouldReturnValue5WhenNickelIsAccepted() throws InvalidPaymentException {
        assertThat(underTest.validateCoin(NICKEL), is(5));
    }

    @Test
    public void shouldReturnValue10WhenDimeIsAccepted() throws InvalidPaymentException {
        assertThat(underTest.validateCoin(DIME), is(10));
    }

    @Test
    public void shouldReturnValue25WhenQuarterIsAccepted() throws InvalidPaymentException {
        assertThat(underTest.validateCoin(QUARTER), is(25));
    }


    @Test
    public void pennyShouldGiveZeroValue() {
        assertThat(underTest.validateCoin(PENNY), is(0));
    }


}
