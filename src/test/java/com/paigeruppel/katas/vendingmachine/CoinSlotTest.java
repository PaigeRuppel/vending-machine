package com.paigeruppel.katas.vendingmachine;

import com.paigeruppel.katas.vendingmachine.CoinSlot;
import org.junit.Test;

import static com.paigeruppel.katas.vendingmachine.Coin.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CoinSlotTest {

    private CoinSlot underTest;

    @Test
    public void shouldReturnValue5WhenNickelIsAccepted() {
        underTest = new CoinSlot();
        assertThat(underTest.acceptPayment(NICKEL), is(5));
    }

    @Test
    public void shouldReturnValue10WhenDimeIsAccepted() {
        underTest = new CoinSlot();
        assertThat(underTest.acceptPayment(DIME), is(10));
    }

    @Test
    public void shouldReturnValue25WhenQuarterIsAccepted() {
        underTest = new CoinSlot();
        assertThat(underTest.acceptPayment(QUARTER), is(25));
    }

}
