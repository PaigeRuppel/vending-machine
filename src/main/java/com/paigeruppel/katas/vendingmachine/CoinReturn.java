package com.paigeruppel.katas.vendingmachine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class CoinReturn {

    private Collection<Coin> coinsInReturn;

    public CoinReturn() {
        coinsInReturn = new ArrayList<>();
    }

    public void acceptCoins(Collection<Coin> coins) {
        coinsInReturn = coins.stream().collect(toList());
    }

    public Collection<Coin> getCoinsInReturn() {
        return coinsInReturn;
    }
}
