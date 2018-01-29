package com.paigeruppel.katas.vendingmachine;

import java.util.List;

public class CoinBank {
    private List<Coin> coinsInBank;

    public CoinBank(List<Coin> coinsInBank) {
        this.coinsInBank = coinsInBank;
    }

    public boolean requiresExactChangeOnly() {
        return coinsInBank.isEmpty();
    }
}
