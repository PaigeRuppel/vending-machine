package com.paigeruppel.katas.vendingmachine;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.paigeruppel.katas.vendingmachine.Coin.*;
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
    public void whenNickelIsAcceptedShouldReturnListWithNickel() {
        List<Coin> nickelOnly = buildCoinList(NICKEL);
        underTest.accept(NICKEL);
        assertThat(underTest.heldCoins(), is(nickelOnly));
    }

    @Test
    public void whenDimeIsAcceptedShouldReturnListWithDime() {
       List<Coin> dimeOnly = buildCoinList(DIME);
       underTest.accept(DIME);
       assertThat(underTest.heldCoins(), is(dimeOnly));
    }

    @Test
    public void whenNickelDimeAndQuarterAreAcceptedShouldReturnListWithOneOfEach() {
        List<Coin> nickelDimeAndQuarter = buildCoinList(NICKEL, DIME, QUARTER);
        underTest.accept(NICKEL);
        underTest.accept(DIME);
        underTest.accept(QUARTER);
        assertThat(underTest.heldCoins(), is(nickelDimeAndQuarter));
    }

    @Test
    public void whenNickelIsSentToReturnListShouldRemoveOneNickel() {
        List<Coin> threeNickels = buildCoinList(NICKEL, NICKEL, NICKEL);
        List<Coin> twoNickels = buildCoinList(NICKEL, NICKEL);
        underTest.accept(NICKEL);
        underTest.accept(NICKEL);
        underTest.accept(NICKEL);
        assertThat(underTest.heldCoins(), is(threeNickels));
        underTest.sendCoinsToReturn(NICKEL);
        assertThat(underTest.heldCoins(), is(twoNickels));
    }
}
