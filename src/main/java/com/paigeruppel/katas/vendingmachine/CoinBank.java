package com.paigeruppel.katas.vendingmachine;

import java.util.List;

import static com.paigeruppel.katas.vendingmachine.Coin.*;

public class CoinBank implements CoinAcceptor {
    private List<Coin> coinsInBank;

    public CoinBank(List<Coin> coinsInBank) {
        this.coinsInBank = coinsInBank;
    }

    public void accept(Coin coin) {

    }

    public List<Coin> availableCoins() {
        return coinsInBank;
    }

    public boolean requiresExactChangeOnly() {
        return count(NICKEL) < 2 && count(DIME)== 0 || count(NICKEL) == 0;
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
