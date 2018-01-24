package com.paigeruppel.katas.vendingmachine;

import java.util.HashMap;
import java.util.Map;

import static com.paigeruppel.katas.vendingmachine.Coin.*;

public class CoinSlot {

    private CoinReturn coinReturn = new CoinReturn();
    private CoinHolder coinHolder = new CoinHolder();

    public int validateCoin(Coin coin) {
        int value = validCoins().getOrDefault(coin, 0);
        if (value == 0) {
            coinReturn.returnCoin(coin);
        } else {
            coinHolder.acceptCoin(coin, value);
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
