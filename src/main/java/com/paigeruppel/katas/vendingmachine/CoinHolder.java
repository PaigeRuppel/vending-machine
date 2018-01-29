package com.paigeruppel.katas.vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class CoinHolder {

    private List<Coin> coinsInHolder;
    private CoinReturn returnSlot = new CoinReturn();

    public CoinHolder() {
        coinsInHolder = new ArrayList<>();
    }

    public void acceptCoin(Coin coin) {
        coinsInHolder.add(coin);
    }

    public List<Coin> heldCoins() {
        return coinsInHolder;
    }

    public void sendCoinsToReturn(Coin... args) {
        for (Coin c: args) {
            coinsInHolder.remove(c);
            returnSlot.returnCoin(c);
        }
    }
}
