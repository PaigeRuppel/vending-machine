package com.paigeruppel.katas.vendingmachine;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.paigeruppel.katas.vendingmachine.Coin.*;
import static com.paigeruppel.katas.vendingmachine.Constants.FIVE_CENTS;
import static com.paigeruppel.katas.vendingmachine.Constants.TEN_CENTS;
import static com.paigeruppel.katas.vendingmachine.Constants.TWENTY_FIVE_CENTS;
import static java.math.BigInteger.ZERO;

public class CoinSlot {

    private VendingDisplay display = new VendingDisplay();

    private CoinAcceptor validCoinAcceptor;
    private CoinAcceptor invalidCoinAcceptor;
    private Sensor sensor;

    public CoinSlot(CoinAcceptor validCoinAcceptor, CoinAcceptor invalidCoinAcceptor) {
        this.validCoinAcceptor = validCoinAcceptor;
        this.invalidCoinAcceptor = invalidCoinAcceptor;
        sensor = new Sensor();
    }

    public void receive(Coin coin) {
        sensor.detectValueOf(coin);
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


    private static Map<Double, BigDecimal> diameterToValueMap() {
        Map<Double, BigDecimal> diameterToValueMap = new HashMap<>();
        diameterToValueMap.put(NICKEL.getDiameterInMm(), FIVE_CENTS);
        diameterToValueMap.put(DIME.getDiameterInMm(), TEN_CENTS);
        diameterToValueMap.put(QUARTER.getDiameterInMm(), TWENTY_FIVE_CENTS);
        return diameterToValueMap;
    }


    private static Map<Double, BigDecimal> thicknessToValueMap() {
        Map<Double, BigDecimal> thicknessToValueMap = new HashMap<>();
        thicknessToValueMap.put(NICKEL.getThicknessInMm(), FIVE_CENTS);
        thicknessToValueMap.put(DIME.getThicknessInMm(), TEN_CENTS);
        thicknessToValueMap.put(QUARTER.getThicknessInMm(), TWENTY_FIVE_CENTS);
        return thicknessToValueMap;
    }


    public Double weigh(Coin coin) {
        return coin.getWeightInGrams();
    }
}
