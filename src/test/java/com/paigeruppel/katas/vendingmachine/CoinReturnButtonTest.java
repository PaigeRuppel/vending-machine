package com.paigeruppel.katas.vendingmachine;

import org.junit.Test;

import java.util.Collections;

import static com.paigeruppel.katas.vendingmachine.Coin.DIME;
import static com.paigeruppel.katas.vendingmachine.Coin.NICKEL;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;


public class CoinReturnButtonTest {

    //This is a message that is getting sent outside of this object - probably not the proper place to test it
    @Test
    public void onPushCoinsShouldGetReturned() {
        CoinHolder coinHolder = new CoinHolder(new CoinReturn(), new CoinBank());
        CoinReturnButton underTest = new CoinReturnButton(coinHolder);
        coinHolder.accept(asList(NICKEL, DIME));
        underTest.push();
        assertThat(coinHolder.getCoins(), is(Collections.emptyList()));
    }
}
