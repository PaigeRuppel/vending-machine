package com.paigeruppel.katas.vendingmachine;

import org.junit.Test;

import static com.paigeruppel.katas.vendingmachine.Coin.*;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CoinReturnTest {

    @Test
    public void shouldAcceptCoinsFromCoinHolder() {
        CoinReturn underTest = new CoinReturn();
        CoinHolder holder = new CoinHolder(underTest, new CoinBank());
        holder.accept(NICKEL);
        holder.returnCoins();
        assertThat(underTest.getCoins(), is(asList(NICKEL)));
    }

    @Test
    public void coinsShouldAccumulateInReturnIfNotCleared() {
        CoinReturn underTest = new CoinReturn();
        CoinHolder holder = new CoinHolder(underTest, new CoinBank());
        holder.accept(NICKEL);
        holder.returnCoins();
        holder.accept(DIME);
        holder.returnCoins();
        assertThat(underTest.getCoins(), is(asList(NICKEL, DIME)));
    }
}
