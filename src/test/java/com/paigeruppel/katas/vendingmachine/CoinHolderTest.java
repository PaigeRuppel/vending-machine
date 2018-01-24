package com.paigeruppel.katas.vendingmachine;

import org.junit.Before;
import org.junit.Test;

import static com.paigeruppel.katas.vendingmachine.Coin.DIME;
import static com.paigeruppel.katas.vendingmachine.Coin.NICKEL;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CoinHolderTest {

    private CoinHolder underTest;

    @Before
    public void setup() {
        underTest = new CoinHolder();
    }

    @Test
    public void whenNickelIsValidatedShouldAddValue5ToDisplay() {
        assertThat(underTest.acceptCoin(NICKEL, 5), is(5));
    }

    @Test
    public void whenDimeIsValidatedShouldAddValue10ToDisplay() {
        assertThat(underTest.acceptCoin(DIME, 10), is(10));
    }
}
