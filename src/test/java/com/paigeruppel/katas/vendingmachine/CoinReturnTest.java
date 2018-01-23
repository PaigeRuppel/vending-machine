package com.paigeruppel.katas.vendingmachine;

import org.junit.Before;
import org.junit.Test;

import static com.paigeruppel.katas.vendingmachine.Coin.PENNY;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CoinReturnTest {

    private CoinReturn underTest;

    @Before
    public void setup() {
        underTest = new CoinReturn();
    }

    @Test
    public void shouldReturnAPenny() {
        assertThat(underTest.returnCoin(PENNY), is(PENNY));
    }
}
