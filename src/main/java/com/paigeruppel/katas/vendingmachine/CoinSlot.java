package com.paigeruppel.katas.vendingmachine;

import java.util.HashMap;
import java.util.Map;

import static com.paigeruppel.katas.vendingmachine.Coin.*;

public class CoinSlot {



    public int determineValue(Coin coin) {
        return validCoins().get(coin);
    }

    private static Map<Coin, Integer> validCoins() {
        Map<Coin, Integer> validCoinsAndValues = new HashMap<>();
        validCoinsAndValues.put(NICKEL, 5);
        validCoinsAndValues.put(DIME, 10);
        validCoinsAndValues.put(QUARTER, 25);
        return validCoinsAndValues;
    }


}
