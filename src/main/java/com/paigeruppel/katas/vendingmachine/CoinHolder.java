package com.paigeruppel.katas.vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class CoinHolder {

    private List<Coin> coinsInHolder;

    public CoinHolder() {
        coinsInHolder = new ArrayList<>();
    }

    public void acceptCoin(Coin coin) {
        coinsInHolder.add(coin);
    }

    public List<Coin> heldCoins() {
        return coinsInHolder;
    }
}
