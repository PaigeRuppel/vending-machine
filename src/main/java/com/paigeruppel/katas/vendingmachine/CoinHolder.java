package com.paigeruppel.katas.vendingmachine;

import java.util.ArrayList;
import java.util.Collection;

public class CoinHolder implements CoinAcceptor {

    private Collection<Coin> coinsInHolder;
    private CoinAcceptor coinReturn;
    private CoinAcceptor coinBank;

    public CoinHolder(CoinAcceptor coinReturn, CoinAcceptor coinBank) {
        coinsInHolder = new ArrayList<>();
        this.coinReturn = coinReturn;
        this.coinBank = coinBank;
    }

    @Override
    public void accept(Collection<Coin> coins) {
    }

    @Override
    public void accept(Coin coin) {
        coinsInHolder.add(coin);
    }

    public void returnCoins() {
        coinReturn.accept(coinsInHolder);
        coinsInHolder.clear();
    }

    @Override
    public Collection<Coin> getCoins() {
        return coinsInHolder;
    }

    public void sendCoinsToBank() {
        coinBank.accept(coinsInHolder);
        coinsInHolder.clear();
    }
}
