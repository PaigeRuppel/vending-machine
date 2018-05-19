package com.paigeruppel.katas.vendingmachine;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.contains;

public class CoinHolderTest {

    @Test
    public void shouldAcceptChange() {
        CoinHolder underTest = new CoinHolder();
        underTest.acceptCoin("nickel");
        List<String> coinsInHolder = underTest.getCoinsInHolder();
        assertThat(coinsInHolder, is(asList("nickel")));
    }

    @Test
    public void shouldReturnChange() {
        CoinHolder underTest = new CoinHolder();
        underTest.acceptCoin("nickel");
        underTest.returnCoins();
        assertThat(underTest.getCoinsInHolder(), is(Collections.emptyList()));
    }
}
