package com.paigeruppel.katas.vendingmachine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CoinHolder {

    Collection<Coin> coinsInHolder;

    public CoinHolder() {
        coinsInHolder = new ArrayList<>();
    }

    public void acceptCoin(Coin coin) {
        coinsInHolder.add(coin);
    }

    public void returnCoins() {
        coinsInHolder.clear();
    }

    public Collection<Coin> getCoinsInHolder() {
        return coinsInHolder;
    }

    public void sendCoinsToBank() {
        coinsInHolder.clear();
    }
}
