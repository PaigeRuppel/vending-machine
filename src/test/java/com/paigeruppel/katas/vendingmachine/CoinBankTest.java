package com.paigeruppel.katas.vendingmachine;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.paigeruppel.katas.vendingmachine.Coin.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

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
    public void whenBankHasThreeNickelsShouldNotRequireExactChangeOnly() {
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

    @Test
    public void whenReturnAmountIs5CentsShouldRemoveANickelFromCoinsInBank() {
        List<Coin> twoNickels = buildCoinList(NICKEL, NICKEL);
        underTest.stock(twoNickels);
        underTest.returnChange(BigDecimal.valueOf(0.05));
        List<Coin> oneNickel = buildCoinList(NICKEL);
        assertThat(underTest.availableCoins(), is(oneNickel));
    }

    @Test
    public void whenReturnAmountIs10CentsShouldRemoveADimeFromCoinsInBank() {
        List<Coin> twoDimesAndANickel = buildCoinList(NICKEL, DIME, DIME);
        underTest.stock(twoDimesAndANickel);
        underTest.returnChange(BigDecimal.valueOf(0.10));
        List<Coin> oneDimeAndOneNickel = buildCoinList(NICKEL, DIME);
        assertThat(underTest.availableCoins(), is(oneDimeAndOneNickel));
    }

    @Test
    public void whenReturnAmountIs10CentsAndNoDimesAreInBankShouldReturnTwoNickels() {
        List<Coin> fourNickels = buildCoinList(NICKEL, NICKEL, NICKEL, NICKEL);
        underTest.stock(fourNickels);
        underTest.returnChange(BigDecimal.valueOf(0.10));
        List<Coin> twoNickels = buildCoinList(NICKEL, NICKEL);
        assertThat(underTest.availableCoins(), is(twoNickels));
    }

    @Test
    public void whenReturnAmountIs15CentsShouldReturnADimeAndANickel() {
        List<Coin> oneNickelAndOneDime = buildCoinList(NICKEL, DIME);
        underTest.stock(oneNickelAndOneDime);
        underTest.returnChange(BigDecimal.valueOf(0.15));
        assertThat(underTest.availableCoins(), is(Collections.emptyList()));
    }

    @Test
    public void whenReturnAmountIs15CentsAndOnlyNickelsAreInBankShouldReturn3Nickels() {
        List<Coin> threeNickels = buildCoinList(NICKEL, NICKEL, NICKEL);
        underTest.stock(threeNickels);
        underTest.returnChange(BigDecimal.valueOf(0.15));
        assertThat(underTest.availableCoins(), is(Collections.emptyList()));
    }

    @Test
    public void whenReturnAmountIs25CentsShouldRemoveAQuarterFromCoinsInBank() {
        List<Coin> fourNickelsAndAQuarter = buildCoinList(NICKEL, NICKEL, NICKEL, NICKEL, QUARTER);
        underTest.stock(fourNickelsAndAQuarter);
        underTest.returnChange(BigDecimal.valueOf(0.25));
        List<Coin> fourNickels = buildCoinList(NICKEL, NICKEL, NICKEL, NICKEL);
        assertThat(underTest.availableCoins(), is(fourNickels));
    }

    @Test
    public void whenReturnAmountIs25CentsAndNoQuarterIsInBankShouldReturnFiveNickels() {
        List<Coin> fiveNickels = buildCoinList(NICKEL, NICKEL, NICKEL, NICKEL, NICKEL);
        underTest.stock(fiveNickels);
        underTest.returnChange(BigDecimal.valueOf(0.25));
        assertThat(underTest.availableCoins(), is(Collections.emptyList()));
    }

    @Test
    public void whenReturnAmountIs25CentsAndNoQuarterAndOnlyThreeNickelsShouldReturnThreeNickelsAndADime() {
        List<Coin> threeNickelsAndOneDime = buildCoinList(NICKEL, NICKEL, NICKEL, DIME);
        underTest.stock(threeNickelsAndOneDime);
        underTest.returnChange(BigDecimal.valueOf(0.25));
        assertThat(underTest.availableCoins(), is(Collections.emptyList()));
    }

    @Test
    public void whenReturnAmountIs25CentsAndNoQuartersAndLessThanFiveNickelsInBankShouldReturnTwoDimesAndANickel() {
        List<Coin> oneNickelAndTwoDimes = buildCoinList(NICKEL, DIME, DIME);
        underTest.stock(oneNickelAndTwoDimes);
        underTest.returnChange(BigDecimal.valueOf(0.25));
        assertThat(underTest.availableCoins(), is(Collections.emptyList()));
    }

    @Test
    public void whenReturnAmountIs35CentsShouldReturnAQuarterAndADime() {
        List<Coin> threeNickelsOneDimeAndOneQuarter = buildCoinList(NICKEL, NICKEL, NICKEL, DIME, QUARTER);
        underTest.stock(threeNickelsOneDimeAndOneQuarter);
        underTest.returnChange(BigDecimal.valueOf(0.35));
        List<Coin> threeNickels = buildCoinList(NICKEL, NICKEL, NICKEL);
        assertThat(underTest.availableCoins(), is(threeNickels));

    }

    @Test
    public void whenReturnAmountIs50CentsShouldReturnTwoQuarters() {
        List<Coin> twoQuartersAndThreeNickels = buildCoinList(QUARTER, QUARTER, NICKEL, NICKEL, NICKEL);
        underTest.stock(twoQuartersAndThreeNickels);
        underTest.returnChange(BigDecimal.valueOf(0.50));
        List<Coin> threeNickels = buildCoinList(NICKEL, NICKEL, NICKEL);
        assertThat(underTest.availableCoins(), is(threeNickels));
    }

}
