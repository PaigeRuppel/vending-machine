package com.paigeruppel.katas.vendingmachine;

import org.junit.Test;

import java.util.Collection;
import java.util.Collections;

import static com.paigeruppel.katas.vendingmachine.Coin.*;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CoinHolderTest {

    @Test
    public void shouldAcceptMultipleCoins() {
        CoinReturn coinReturn = new CoinReturn();
        CoinHolder underTest = new CoinHolder(coinReturn, new CoinBank());
        underTest.accept(NICKEL);
        underTest.accept(DIME);
        Collection<Coin> coinsInHolder = underTest.getCoins();
        assertThat(coinsInHolder, is(asList(NICKEL, DIME)));
    }

    @Test
    public void shouldReturnChange() {
        CoinReturn coinReturn = new CoinReturn();
        CoinHolder underTest = new CoinHolder(coinReturn, new CoinBank());
        underTest.accept(NICKEL);
        underTest.returnCoins();
        assertThat(underTest.getCoins(), is(Collections.emptyList()));
    }

    @Test
    public void shouldSendCoinsToBank() {
        CoinReturn coinReturn = new CoinReturn();
        CoinHolder underTest = new CoinHolder(coinReturn, new CoinBank());
        underTest.accept(NICKEL);
        underTest.sendCoinsToBank();
        assertThat(underTest.getCoins(), is(Collections.emptyList()));
    }
}
