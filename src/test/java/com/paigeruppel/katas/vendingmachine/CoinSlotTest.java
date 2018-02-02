package com.paigeruppel.katas.vendingmachine;

import org.junit.Before;
import org.junit.Test;

import static com.paigeruppel.katas.vendingmachine.Coin.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CoinSlotTest {

    private CoinSlot underTest;


    private CoinAcceptor validCoinAcceptor;

    private CoinAcceptor invalidCoinAcceptor;

    @Before
    public void setup() {
        validCoinAcceptor = new CoinHolder();
        invalidCoinAcceptor = new CoinReturn();
        underTest = new CoinSlot(validCoinAcceptor, invalidCoinAcceptor);
    }

    @Test
    public void nickelIsValid() {
        assertTrue(underTest.isValid(NICKEL));
    }

    @Test
    public void dimeIsValid() {
        assertTrue(underTest.isValid(DIME));
    }

    @Test
    public void quarterIsValid() {
        assertTrue(underTest.isValid(QUARTER));
    }


    @Test
    public void pennyIsNotValid() {
        assertFalse(underTest.isValid(PENNY));
    }


}
