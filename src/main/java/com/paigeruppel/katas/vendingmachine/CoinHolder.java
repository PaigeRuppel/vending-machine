package com.paigeruppel.katas.vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class CoinHolder implements CoinAcceptor {

    private List<Coin> coinsInHolder;

    public CoinHolder() {
        coinsInHolder = new ArrayList<>();
    }

    public void accept(Coin coin) {
        coinsInHolder.add(coin);
    }

    public List<Coin> availableCoins() {
        return coinsInHolder;
    }

//    public void sendCoinsToReturn(Coin... args) {
//        for (Coin c: args) {
//            coinsInHolder.remove(c);
//            returnSlot.returnCoin(c);
//        }
//    }
}
