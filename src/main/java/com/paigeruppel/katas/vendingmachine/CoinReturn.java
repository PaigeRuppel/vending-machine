package com.paigeruppel.katas.vendingmachine;

public class CoinReturn implements CoinAcceptor {


    // Should I make CoinReturn a Singleton? Does this make sense? Or unnecessary restriction?

    public void accept(Coin coin) {

    }

    public Coin returnCoin(Coin coin) {
        return coin;
    }
}
