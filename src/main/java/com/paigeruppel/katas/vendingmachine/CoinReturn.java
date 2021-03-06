package com.paigeruppel.katas.vendingmachine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class CoinReturn implements CoinAcceptor {

    private Collection<Coin> coinsInReturn;

    public CoinReturn() {
        coinsInReturn = new ArrayList<>();
    }

    @Override
    public void accept(Collection<Coin> coins) {
        coins.stream().forEach(this::accept);
    }

    @Override
    public void accept(Coin coin) {
        coinsInReturn.add(coin);
    }

    @Override
    public Collection<Coin> getCoins() {
        return coinsInReturn;
    }


}
