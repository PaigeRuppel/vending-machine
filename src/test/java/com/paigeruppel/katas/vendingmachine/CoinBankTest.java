package com.paigeruppel.katas.vendingmachine;

import org.junit.Test;

import static com.paigeruppel.katas.vendingmachine.Coin.*;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CoinBankTest {

    @Test
    public void coinBankShouldAcceptCoinsFromHolder() {
        CoinReturn coinReturn = new CoinReturn();
        CoinBank underTest = new CoinBank();
        CoinHolder holder = new CoinHolder(coinReturn, underTest);
        holder.acceptCoin(NICKEL);
        holder.sendCoinsToBank();
        assertThat(underTest.getCoinsInBank(), is(asList(NICKEL)));
    }
}
