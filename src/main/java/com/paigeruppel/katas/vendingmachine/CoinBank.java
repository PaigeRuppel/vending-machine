package com.paigeruppel.katas.vendingmachine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class CoinBank implements CoinAcceptor {

    private Collection<Coin> coinsInBank;

    public CoinBank() {
        coinsInBank = new ArrayList<>();
    }

    public Collection<Coin> getCoinsInBank() {
        return coinsInBank;
    }

    @Override
    public void accept(Collection<Coin> coins) {
        coinsInBank = coins.stream().collect(toList());
    }

    @Override
    public Collection<Coin> getCoins() {
        return coinsInBank;
    }
}
