package com.paigeruppel.katas.vendingmachine;

import java.util.HashMap;
import java.util.Map;

import static com.paigeruppel.katas.vendingmachine.Coin.*;

public class CoinSlot {

    public int acceptCoin(Coin coin) throws InvalidPaymentException {
        int value = 0;
        try {
            value = validCoins().get(coin);
        } catch (Exception e) {
            value = 0;
            throw new InvalidPaymentException("Please insert either a quarter, dime, or nickel.", e);
        }
        return value;
    }

    private static Map<Coin, Integer> validCoins() {
        Map<Coin, Integer> validCoinsAndValues = new HashMap<>();
        validCoinsAndValues.put(NICKEL, 5);
        validCoinsAndValues.put(DIME, 10);
        validCoinsAndValues.put(QUARTER, 25);
        return validCoinsAndValues;
    }


}
