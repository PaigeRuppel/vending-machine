package com.paigeruppel.katas.vendingmachine;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.paigeruppel.katas.vendingmachine.Coin.*;
import static org.junit.Assert.*;

public class CoinBankTest {

    private CoinBank underTest;

    private List<Coin> fillBank(Coin... args) {
        List<Coin> coinsInBank = new ArrayList<>();
        for (Coin c : args) {
            coinsInBank.add(c);
        }
        return coinsInBank;
    }

    @Test
    public void whenCoinsInBankIsEmptyShouldRequireExactChangeOnly() {
        List<Coin> coinsInBank = Collections.emptyList();
        underTest = new CoinBank(coinsInBank);
        assertTrue(underTest.requiresExactChangeOnly());
    }

    @Test
    public void whenNickelDimeAndQuarterAreInBankShouldNotRequireExactChange() {
        List<Coin> coinsInBank = fillBank(NICKEL, DIME, QUARTER);
        underTest = new CoinBank(coinsInBank);
        assertFalse(underTest.requiresExactChangeOnly());
    }
}
