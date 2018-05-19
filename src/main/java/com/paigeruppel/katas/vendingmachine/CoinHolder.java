package com.paigeruppel.katas.vendingmachine;

import java.util.ArrayList;
import java.util.Collection;

public class CoinHolder {

    private Collection<Coin> coinsInHolder;
    private CoinReturn coinReturn;
    private CoinBank coinBank;

    public CoinHolder(CoinReturn coinReturn, CoinBank coinBank) {
        coinsInHolder = new ArrayList<>();
        this.coinReturn = coinReturn;
        this.coinBank = coinBank;
    }

    public void acceptCoin(Coin coin) {
        coinsInHolder.add(coin);
    }

    public void returnCoins() {
        coinReturn.acceptCoins(coinsInHolder);
        coinsInHolder.clear();
    }

    public Collection<Coin> getCoinsInHolder() {
        return coinsInHolder;
    }

    public void sendCoinsToBank() {
        coinBank.acceptCoins(coinsInHolder);
        coinsInHolder.clear();
    }
}
