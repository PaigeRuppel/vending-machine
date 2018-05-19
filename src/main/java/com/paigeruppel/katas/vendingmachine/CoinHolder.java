package com.paigeruppel.katas.vendingmachine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CoinHolder {

    List<String> coinsInHolder;

    public CoinHolder() {
        coinsInHolder = new ArrayList<>();
    }

    public void acceptCoin(String coin) {
        coinsInHolder.add(coin);
    }

    public void returnCoins() {
        coinsInHolder.clear();
    }

    public List<String> getCoinsInHolder() {
        return coinsInHolder;
    }
}
