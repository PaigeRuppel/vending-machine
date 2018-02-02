package com.paigeruppel.katas.vendingmachine;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static com.paigeruppel.katas.vendingmachine.Coin.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class CoinSlotTest {

    private CoinSlot underTest;

    private CoinAcceptor validCoinAcceptor;
    private CoinAcceptor invalidCoinAcceptor;

    @Before
    public void setup() {
        validCoinAcceptor = mock(CoinHolder.class);
        invalidCoinAcceptor = mock(CoinReturn.class);
        underTest = new CoinSlot(validCoinAcceptor, invalidCoinAcceptor);
    }

    @Test
    public void whenNickelIsAcceptedValidCoinAcceptorShouldReceiveCoin() {
        doNothing().when(validCoinAcceptor).accept(NICKEL);

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
