package com.paigeruppel.katas.vendingmachine;

import java.util.HashMap;
import java.util.Map;

import static com.paigeruppel.katas.vendingmachine.Coin.*;

public class CoinSlot {



    public int determineValue(Coin coin) throws InvalidPaymentException {
        if (validCoins().containsKey(coin)) {
            return validCoins().get(coin);
        } else {
            throw new InvalidPaymentException(
                    "Please insert either a quarter, dime, or nickel."
            );
        }
    }

    private static Map<Coin, Integer> validCoins() {
        Map<Coin, Integer> validCoinsAndValues = new HashMap<>();
        validCoinsAndValues.put(NICKEL, 5);
        validCoinsAndValues.put(DIME, 10);
        validCoinsAndValues.put(QUARTER, 25);
        return validCoinsAndValues;
    }


}
