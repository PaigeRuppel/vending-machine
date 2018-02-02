package com.paigeruppel.katas.vendingmachine;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CoinReturn implements CoinAcceptor {


    // Should I make CoinReturn a Singleton? Does this make sense? Or unnecessary restriction?

    public void accept(Coin coin) {

    }

    public List<Coin> availableCoins() {
        return Collections.emptyList();
    }

    public Coin returnCoin(Coin coin) {
        return coin;
    }
}
