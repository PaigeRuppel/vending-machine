package com.paigeruppel.katas.vendingmachine;

import org.junit.Test;

import java.util.Arrays;

import static com.paigeruppel.katas.vendingmachine.Coin.*;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CoinReturnTest {

    @Test
    public void shouldAcceptCoins() {
        CoinReturn underTest = new CoinReturn();
        underTest.acceptCoins(asList(NICKEL, DIME));
        assertThat(underTest.getCoinsInReturn(), is(asList(NICKEL, DIME)));
    }
}
