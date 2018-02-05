package com.paigeruppel.katas.vendingmachine;

import java.util.HashSet;
import java.util.Set;

import static com.paigeruppel.katas.vendingmachine.Coin.*;

public class CoinSlot {

    private CoinAcceptor validCoinAcceptor;
    private CoinAcceptor invalidCoinAcceptor;


    public CoinSlot(CoinAcceptor validCoinAcceptor, CoinAcceptor invalidCoinAcceptor) {
        this.validCoinAcceptor = validCoinAcceptor;
        this.invalidCoinAcceptor = invalidCoinAcceptor;
    }

    public void receive(Coin coin) {
        if (validCoins().contains(coin)) {
            validCoinAcceptor.accept(coin);
        } else {
            invalidCoinAcceptor.accept(coin);
        }
    }

    private static Set<Coin> validCoins() {
        Set<Coin> validCoins = new HashSet<>();
        validCoins.add(NICKEL);
        validCoins.add(DIME);
        validCoins.add(QUARTER);
        return validCoins;
    }
}
