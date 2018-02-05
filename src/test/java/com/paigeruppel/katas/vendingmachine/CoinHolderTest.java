package com.paigeruppel.katas.vendingmachine;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.paigeruppel.katas.vendingmachine.Coin.*;
import static com.paigeruppel.katas.vendingmachine.Constants.CENTS;
import static com.paigeruppel.katas.vendingmachine.Constants.FORTY_CENTS;
import static com.paigeruppel.katas.vendingmachine.Constants.SIXTY_FIVE_CENTS;
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
    public void whenNickelDimeAndQuarterAreAcceptedShouldReturnListWithOneOfEachAndFortyCentsAvailable() {
        List<Coin> nickelDimeAndQuarter = buildCoinList(NICKEL, DIME, QUARTER);
        underTest.accept(NICKEL);
        underTest.accept(DIME);
        underTest.accept(QUARTER);
        assertThat(underTest.availableCoins(), is(nickelDimeAndQuarter));
        assertThat(underTest.getAmountInHolder(), is(FORTY_CENTS));
    }

    @Test
    public void whenCoinsInHolderAreDepositedAvailableCoinsShouldBeEmptyAndCoinsShouldGoToDepositCoinAcceptor() {
        List<Coin> threeNickels = buildCoinList(NICKEL, NICKEL, NICKEL);
        underTest.accept(NICKEL);
        underTest.accept(NICKEL);
        underTest.accept(NICKEL);

        underTest.depositCoins();
        assertThat(underTest.availableCoins(), is(Collections.emptyList()));
        assertThat(mSpyDepositCoinAcceptor.availableCoins(), is(threeNickels));
    }

    @Test
    public void whenCoinsInHolderAreReturnedAvailableCoinsShouldBeEmptyAndCoinsShouldGoToReturnCoinAcceptor() {
        List<Coin> threeNickels = buildCoinList(NICKEL, NICKEL, NICKEL);
        underTest.accept(NICKEL);
        underTest.accept(NICKEL);
        underTest.accept(NICKEL);

        underTest.returnCoins();
        assertThat(underTest.availableCoins(), is(Collections.emptyList()));
        assertThat(mSpyReturnCoinAcceptor.availableCoins(), is(threeNickels));
    }

    @Test
    public void whenCoinHolderAcceptsOneNickelOneDimeAndTwoQuartersAmountInHolderShouldBeSixtyFiveCents() {
        underTest.accept(NICKEL);
        underTest.accept(DIME);
        underTest.accept(QUARTER);
        underTest.accept(QUARTER);
        assertThat(underTest.getAmountInHolder(), is(new BigDecimal(0.65, CENTS)));
    }

    @Test
    public void whenCoinHolderAcceptsOneNickelAmountInHolderShouldBeFiveCents() {
        underTest.accept(NICKEL);
        assertThat(underTest.getAmountInHolder(), is(new BigDecimal(0.05, CENTS)));
    }
}
