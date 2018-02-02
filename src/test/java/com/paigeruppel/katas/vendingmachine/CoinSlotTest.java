package com.paigeruppel.katas.vendingmachine;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static com.paigeruppel.katas.vendingmachine.Coin.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;

public class CoinSlotTest {


    @Spy
    private CoinHolder mSpyValidCoinAcceptor;

    @Spy
    private CoinReturn mSpyInvalidCoinAcceptor;

    @InjectMocks
    private CoinSlot underTest;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    private List<Coin> buildCoinList(Coin ... args) {
        List<Coin> coinList = new ArrayList<>();
        for (Coin c : args) {
            coinList.add(c);
        }
        return coinList;
    }

    @Test
    public void whenCoinSlotValidatesNickelValidCoinAcceptorShouldAcceptTheNickel() {
        List<Coin> nickelOnly = buildCoinList(NICKEL);
        underTest.validate(NICKEL);
        assertThat(mSpyValidCoinAcceptor.availableCoins(), is(nickelOnly));
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
