package com.paigeruppel.katas.vendingmachine;

import org.junit.Test;

import static com.paigeruppel.katas.vendingmachine.Coin.*;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CoinBankTest {

    @Test
    public void coinBankShouldAcceptCoinsFromHolder() {
        CoinAcceptor coinReturn = new CoinReturn();
        CoinAcceptor underTest = new CoinBank();
        CoinHolder holder = new CoinHolder(coinReturn, underTest);
        holder.accept(NICKEL);
        holder.sendCoinsToBank();
        assertThat(underTest.getCoins(), is(asList(NICKEL)));
    }

    @Test
    public void coinBankShouldAcceptCoinsMultipleTimesAndStoreAllInBank() {
        CoinAcceptor coinReturn = new CoinReturn();
        CoinAcceptor underTest = new CoinBank();
        CoinHolder holder = new CoinHolder(coinReturn, underTest);
        holder.accept(NICKEL);
        holder.sendCoinsToBank();
        holder.accept(DIME);
        holder.sendCoinsToBank();
        assertThat(underTest.getCoins(), is(asList(NICKEL, DIME)));
    }
}
