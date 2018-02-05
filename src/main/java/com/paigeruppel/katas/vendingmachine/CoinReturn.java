package com.paigeruppel.katas.vendingmachine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CoinReturn implements CoinAcceptor {


    private List<Coin> coinsInReturn;

    public CoinReturn() {
        coinsInReturn = new ArrayList<>();
    }

    public void accept(Coin coin) {
        coinsInReturn.add(coin);
    }

    public List<Coin> availableCoins() {
        return coinsInReturn;
    }

    public void empty() {
        coinsInReturn.clear();
    }

}
