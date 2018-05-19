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
        coinsInReturn = coins.stream().collect(toList());
    }

    public Collection<Coin> getCoinsInReturn() {
        return coinsInReturn;
    }


}
