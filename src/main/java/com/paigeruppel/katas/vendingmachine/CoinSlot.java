package com.paigeruppel.katas.vendingmachine;

import java.util.HashMap;
import java.util.Map;

import static com.paigeruppel.katas.vendingmachine.Coin.*;

public class CoinSlot implements CoinAcceptor {

    private VendingDisplay display = new VendingDisplay();

    private CoinAcceptor validCoinAcceptor;
    private CoinAcceptor invalidCoinAcceptor;

    public CoinSlot(CoinAcceptor validCoinAcceptor, CoinAcceptor invalidCoinAcceptor) {
        this.validCoinAcceptor = validCoinAcceptor;
        this.invalidCoinAcceptor = invalidCoinAcceptor;
    }

    public void accept(Coin coin) {
        double value = validCoins().getOrDefault(coin, 0.0);
        if (value == 0) {
            validCoinAcceptor.accept(coin);
        } else {
            invalidCoinAcceptor.accept(coin);
            display.addValue(value);
        }
    }

    private static Map<Coin, Double> validCoins() {
        Map<Coin, Double> validCoinsAndValues = new HashMap<>();
        validCoinsAndValues.put(NICKEL, 0.05);
        validCoinsAndValues.put(DIME, 0.10);
        validCoinsAndValues.put(QUARTER, 0.25);
        return validCoinsAndValues;
    }


    public boolean isValid(Coin coin) {
        return validCoins().containsKey(coin);
    }
}
