package com.paigeruppel.katas.vendingmachine;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.paigeruppel.katas.vendingmachine.Coin.DIME;
import static com.paigeruppel.katas.vendingmachine.Coin.NICKEL;
import static com.paigeruppel.katas.vendingmachine.Coin.QUARTER;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CoinHolderTest {

    private CoinHolder underTest;

    @Before
    public void setup() {
        underTest = new CoinHolder();
    }

    private List<Coin> buildCoinList(Coin... args) {
        List<Coin> coins = new ArrayList<>();
        for (Coin c : args) {
            coins.add(c);
        }
        return coins;
    }

    @Test
    public void whenNoCoinsAreInsertedShouldReturnEmptyList() {
        assertThat(underTest.heldCoins(), is(Collections.emptyList()));
    }
    @Test
    public void whenNickelIsValidatedShouldAddValue5ToDisplay() {
        List<Coin> nickelOnly = buildCoinList(NICKEL);
        underTest.acceptCoin(NICKEL);
        assertThat(underTest.heldCoins(), is(nickelOnly));
    }

    @Test
    public void whenDimeIsValidatedShouldAddValue10ToDisplay() {
       List<Coin> dimeOnly = buildCoinList(DIME);
       underTest.acceptCoin(DIME);
       assertThat(underTest.heldCoins(), is(dimeOnly));
    }

    @Test
    public void whenNickelDimeAndQuarterAreAcceptedShouldReturnListWithOneOfEach() {
        List<Coin> nickelDimeAndQuarter = buildCoinList(NICKEL, DIME, QUARTER);
        underTest.acceptCoin(NICKEL);
        underTest.acceptCoin(DIME);
        underTest.acceptCoin(QUARTER);
        assertThat(underTest.heldCoins(), is(nickelDimeAndQuarter));
    }
}
