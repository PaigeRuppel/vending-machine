package com.paigeruppel.katas.vendingmachine;

import org.junit.Test;

import java.util.Arrays;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CoinReturnTest {

    @Test
    public void shouldAcceptCoins() {
        CoinReturn underTest = new CoinReturn();
        underTest.acceptCoins(asList("nickel", "dime"));
        assertThat(underTest.getCoinsInReturn(), is(asList("nickel", "dime")));
    }
}
