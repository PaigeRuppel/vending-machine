package com.paigeruppel.katas.vendingmachine;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.paigeruppel.katas.vendingmachine.Coin.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CoinBankTest {

    private CoinBank underTest;


    @Before
    public void setup() {
        underTest = new CoinBank();
    }

    private List<Coin> buildCoinList(Coin... args) {
        List<Coin> coinList = new ArrayList<>();
        for (Coin c : args) {
            coinList.add(c);
        }
        return coinList;
    }

    @Test
    public void whenBankNotStockedAndEmptyShouldRequireExacatChangeOnly() {
        assertTrue(underTest.requiresExactChangeOnly());
    }

    @Test
    public void whenNickelDimeAndQuarterAreInBankShouldNotRequireExactChangeOnly() {
        List<Coin> nickelDimeAndQuarter = buildCoinList(NICKEL, DIME, QUARTER);
        underTest.stock(nickelDimeAndQuarter);
        assertFalse(underTest.requiresExactChangeOnly());
    }

    @Test
    public void whenBankOnlyHasANickelShouldRequireExactChangeOnly() {
        List<Coin> nickelOnly = buildCoinList(NICKEL);
        underTest.stock(nickelOnly);
        assertTrue(underTest.requiresExactChangeOnly());
    }

    @Test
    public void whenBankOnlyHasANickelAndADimeShouldNotRequireExactChangeOnly() {
        List<Coin> nickelAndDime = buildCoinList(NICKEL, DIME);
        underTest.stock(nickelAndDime);
        assertFalse(underTest.requiresExactChangeOnly());
    }

    @Test
    public void whenBankOnlyHasAQuarterShouldRequireExactChange() {
        List<Coin> quarterOnly = buildCoinList(QUARTER);
        underTest.stock(quarterOnly);
        assertTrue(underTest.requiresExactChangeOnly());
    }

    @Test
    public void whenBankHasTwoQuartersShouldRequireExactChangeOnly() {
        List<Coin> twoQuarters = buildCoinList(QUARTER, QUARTER);
        underTest.stock(twoQuarters);
        assertTrue(underTest.requiresExactChangeOnly());
    }

    @Test
    public void whenBankHasThreNickelsShouldNotRequireExactChangeOnly() {
        List<Coin> threeNickels = buildCoinList(NICKEL, NICKEL, NICKEL);
        underTest.stock(threeNickels);
        assertFalse(underTest.requiresExactChangeOnly());
    }

    @Test
    public void whenBankHasTwoDimesShouldRequireExactChangeOnly() {
        List<Coin> twoDimes = buildCoinList(DIME, DIME);
        underTest.stock(twoDimes);
        assertTrue(underTest.requiresExactChangeOnly());
    }
}
