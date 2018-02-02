package com.paigeruppel.katas.vendingmachine;

import java.util.List;

public interface CoinAcceptor {

    void accept(Coin coin);

    List<Coin> availableCoins();
}
