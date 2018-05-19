package com.paigeruppel.katas.vendingmachine;

import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.contains;

public class CoinHolderTest {

    @Test
    public void shouldAcceptMultipleCoins() {
        CoinHolder underTest = new CoinHolder();
        underTest.acceptCoin("nickel");
        underTest.acceptCoin("dime");
        Collection<String> coinsInHolder = underTest.getCoinsInHolder();
        assertThat(coinsInHolder, is(asList("nickel", "dime")));
    }

    @Test
    public void shouldReturnChange() {
        CoinHolder underTest = new CoinHolder();
        underTest.acceptCoin("nickel");
        underTest.returnCoins();
        assertThat(underTest.getCoinsInHolder(), is(Collections.emptyList()));
    }

    @Test
    public void shouldSendCoinsToBank() {
        CoinHolder underTest = new CoinHolder();
        underTest.acceptCoin("nickel");
        underTest.sendCoinsToBank();
        assertThat(underTest.getCoinsInHolder(), is(Collections.emptyList()));
    }
}
