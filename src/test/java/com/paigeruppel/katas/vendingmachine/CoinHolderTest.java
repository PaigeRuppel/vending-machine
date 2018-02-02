package com.paigeruppel.katas.vendingmachine;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.paigeruppel.katas.vendingmachine.Coin.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CoinHolderTest {

    @Spy
    private CoinBank mSpyDepositCoinAcceptor;

    @Spy
    private CoinReturn mSpyReturnCoinAcceptor;

    private CoinHolder underTest;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        underTest = new CoinHolder(mSpyDepositCoinAcceptor, mSpyReturnCoinAcceptor);
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
        assertThat(underTest.availableCoins(), is(Collections.emptyList()));
    }

    @Test
    public void whenNickelIsAcceptedShouldReturnListWithNickel() {
        List<Coin> nickelOnly = buildCoinList(NICKEL);
        underTest.accept(NICKEL);
        assertThat(underTest.availableCoins(), is(nickelOnly));
    }

    @Test
    public void whenDimeIsAcceptedShouldReturnListWithDime() {
       List<Coin> dimeOnly = buildCoinList(DIME);
       underTest.accept(DIME);
       assertThat(underTest.availableCoins(), is(dimeOnly));
    }

    @Test
    public void whenNickelDimeAndQuarterAreAcceptedShouldReturnListWithOneOfEach() {
        List<Coin> nickelDimeAndQuarter = buildCoinList(NICKEL, DIME, QUARTER);
        underTest.accept(NICKEL);
        underTest.accept(DIME);
        underTest.accept(QUARTER);
        assertThat(underTest.availableCoins(), is(nickelDimeAndQuarter));
    }

    @Test
    public void whenCoinsInHolderAreDepositedAvailableCoinsShouldBeEmptyAndCoinsShouldGoToDepositCoinAcceptor() {
        List<Coin> threeNickels = buildCoinList(NICKEL, NICKEL, NICKEL);
        underTest.accept(NICKEL);
        underTest.accept(NICKEL);
        underTest.accept(NICKEL);

        underTest.deposit();
        assertThat(underTest.availableCoins(), is(Collections.emptyList()));
        assertThat(mSpyDepositCoinAcceptor.availableCoins(), is(threeNickels));
    }
}
