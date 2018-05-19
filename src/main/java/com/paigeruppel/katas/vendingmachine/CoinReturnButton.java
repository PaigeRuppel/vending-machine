package com.paigeruppel.katas.vendingmachine;

public class CoinReturnButton {

    private CoinHolder coinHolder;

    public CoinReturnButton(CoinHolder coinHolder) {
        this.coinHolder = coinHolder;
    }

    public void push() {
        coinHolder.returnCoins();
    }
}
