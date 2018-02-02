package com.paigeruppel.katas.vendingmachine;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.CheckedOutputStream;

import static com.paigeruppel.katas.vendingmachine.Coin.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CoinSlotTest {


    @Spy
    private CoinHolder mSpyValidCoinAcceptor;

    @Spy
    private CoinReturn mSpyInvalidCoinAcceptor;

    private CoinSlot underTest;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        underTest = new CoinSlot(mSpyValidCoinAcceptor, mSpyInvalidCoinAcceptor);
    }

    private List<Coin> buildCoinList(Coin ... args) {
        List<Coin> coinList = new ArrayList<>();
        for (Coin c : args) {
            coinList.add(c);
        }
        return coinList;
    }

    @Test
    public void whenCoinSlotReceivesNickelValidCoinAcceptorShouldAcceptTheNickel() {
        List<Coin> nickelOnly = buildCoinList(NICKEL);
        underTest.recieve(NICKEL);
        assertThat(mSpyValidCoinAcceptor.availableCoins(), is(nickelOnly));
    }

    @Test
    public void whenCoinSlotRecievesPennyInvalidCoinAcceptorShouldAcceptThePenny() {
        List<Coin> pennyOnly = buildCoinList(PENNY);
        underTest.recieve(PENNY);
        assertThat(mSpyInvalidCoinAcceptor.availableCoins(), is(pennyOnly));
    }

    @Test
    public void whenCoinSlotReceivesMultipleCoinsInvalidAcceptorShouldAcceptAllPenniesAndValidAcceptorShouldAcceptAllOthers() {
        List<Coin> threePennies = buildCoinList(PENNY, PENNY, PENNY);
        List<Coin> threeNickelsOneDimeAndTwoQuarters = buildCoinList(NICKEL, NICKEL, NICKEL, DIME, QUARTER, QUARTER);
        underTest.recieve(PENNY);
        underTest.recieve(PENNY);
        underTest.recieve(PENNY);
        underTest.recieve(NICKEL);
        underTest.recieve(NICKEL);
        underTest.recieve(NICKEL);
        underTest.recieve(DIME);
        underTest.recieve(QUARTER);
        underTest.recieve(QUARTER);
        assertThat(mSpyInvalidCoinAcceptor.availableCoins(), is(threePennies));
        assertThat(mSpyValidCoinAcceptor.availableCoins(), is(threeNickelsOneDimeAndTwoQuarters));
    }


}
