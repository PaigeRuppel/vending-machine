package com.paigeruppel.katas.vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class CoinHolder implements CoinAcceptor {

    private List<Coin> coinsInHolder;

    private CoinAcceptor depositCoinAcceptor;
    private CoinAcceptor returnCoinAcceptor;

    public CoinHolder(CoinAcceptor depositCoinAcceptor, CoinAcceptor returnCoinAcceptor) {
        this.depositCoinAcceptor = depositCoinAcceptor;
        this.returnCoinAcceptor = returnCoinAcceptor;
        coinsInHolder = new ArrayList<>();
    }

    public void accept(Coin coin) {
        coinsInHolder.add(coin);
    }

    public List<Coin> availableCoins() {
        return coinsInHolder;
    }


    public void depositCoins() {
        for (Coin c: coinsInHolder) {
            depositCoinAcceptor.accept(c);
        }
        coinsInHolder.clear();
    }

    public void returnCoins() {
        for (Coin c : coinsInHolder) {
            returnCoinAcceptor.accept(c);
        }
        coinsInHolder.clear();
    }
}
