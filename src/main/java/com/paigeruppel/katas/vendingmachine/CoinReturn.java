package com.paigeruppel.katas.vendingmachine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class CoinReturn {

    private Collection<String> coinsInReturn;

    public CoinReturn() {
        coinsInReturn = new ArrayList<>();
    }

    public void acceptCoins(List<String> coins) {
        coinsInReturn = coins.stream().collect(toList());
    }

    public Collection<String> getCoinsInReturn() {
        return coinsInReturn;
    }
}
