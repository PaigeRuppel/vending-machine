package com.paigeruppel.katas.vendingmachine;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static com.paigeruppel.katas.vendingmachine.Coin.*;
import static com.paigeruppel.katas.vendingmachine.Constants.FIVE_CENTS;
import static com.paigeruppel.katas.vendingmachine.Constants.TEN_CENTS;
import static com.paigeruppel.katas.vendingmachine.Constants.TWENTY_FIVE_CENTS;
import static java.math.BigInteger.ZERO;

public class CoinSlot {

    private VendingDisplay display = new VendingDisplay();

    private CoinAcceptor validCoinAcceptor;
    private CoinAcceptor invalidCoinAcceptor;

    public CoinSlot(CoinAcceptor validCoinAcceptor, CoinAcceptor invalidCoinAcceptor) {
        this.validCoinAcceptor = validCoinAcceptor;
        this.invalidCoinAcceptor = invalidCoinAcceptor;
    }

    public void receive(Coin coin) {
        BigDecimal wValue = weightToValueMap().getOrDefault(coin.getWeightInGrams(), BigDecimal.ZERO);
        BigDecimal dValue = diameterToValueMap().getOrDefault(coin.getDiameterInMm(), BigDecimal.ZERO);
        BigDecimal tValue = thicknessToValueMap().getOrDefault(coin.getThicknessInMm(), BigDecimal.ZERO);
        if (wValue.equals(dValue) && dValue.equals(tValue) && !tValue.equals(BigDecimal.ZERO)) {
            validCoinAcceptor.accept(coin);
        } else {
            invalidCoinAcceptor.accept(coin);
        }
    }

    private static Map<Double, BigDecimal> weightToValueMap() {
        Map<Double, BigDecimal> weightToValueMap = new HashMap<>();
        weightToValueMap.put(NICKEL.getWeightInGrams(), FIVE_CENTS);
        weightToValueMap.put(DIME.getWeightInGrams(), TEN_CENTS);
        weightToValueMap.put(QUARTER.getWeightInGrams(), TWENTY_FIVE_CENTS);
        return weightToValueMap;
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
