package com.paigeruppel.katas.vendingmachine;

import org.junit.Before;
import org.junit.Test;

public class CoinRouteTest {

    private PaymentRoute underTest;

    @Before
    public void setup() {
        underTest = new CoinRoute();
    }

    @Test
    public void shouldDeliverCoinFromCoinSlotToCoinHolder() {
        underTest.deliverPayment();
    }
}
