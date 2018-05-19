package com.paigeruppel.katas.vendingmachine;

import java.util.Collection;

public interface CoinAcceptor {

    void accept(Collection<Coin> coins);
    void accept(Coin coin);
    Collection<Coin> getCoins();
}
