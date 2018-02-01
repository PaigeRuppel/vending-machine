package com.paigeruppel.katas.vendingmachine;

import java.util.HashMap;
import java.util.Map;

import static com.paigeruppel.katas.vendingmachine.Coin.*;

public class CoinSlot {

    private CoinReturn coinReturn = new CoinReturn();
    private CoinHolder coinHolder = new CoinHolder();
    private VendingDisplay display = new VendingDisplay();

    public double validateCoin(Coin coin) {
        double value = validCoins().getOrDefault(coin, 0.0);
        if (value == 0) {
            coinReturn.returnCoin(coin);
        } else {
            coinHolder.acceptCoin(coin);
            display.addValue(value);
        }
        return value;
    }

    private static Map<Coin, Double> validCoins() {
        Map<Coin, Double> validCoinsAndValues = new HashMap<>();
        validCoinsAndValues.put(NICKEL, 0.05);
        validCoinsAndValues.put(DIME, 0.10);
        validCoinsAndValues.put(QUARTER, 0.25);
        return validCoinsAndValues;
    }


    public boolean isValid(Coin nickel) {
        return true;
    }
}
