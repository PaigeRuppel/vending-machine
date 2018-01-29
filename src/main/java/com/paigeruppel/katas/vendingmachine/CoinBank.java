package com.paigeruppel.katas.vendingmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static com.paigeruppel.katas.vendingmachine.Coin.*;

public class CoinBank {
    private List<Coin> coinsInBank;

    public CoinBank(List<Coin> coinsInBank) {
        this.coinsInBank = coinsInBank;
    }

    //always need a nickel and a balance of at least ten cents
    public boolean requiresExactChangeOnly() {
        return count(NICKEL) < 2 && count(DIME) == 0;
    }


    private int count(Coin coin) {
        int coinCount = 0;
        for (Coin c : coinsInBank) {
            if (c.equals(coin)) {
                coinCount++;
            }
        }
        return coinCount;
    }


}
