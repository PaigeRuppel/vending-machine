package com.paigeruppel.katas.vendingmachine;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;

import static com.paigeruppel.katas.vendingmachine.Coin.DIME;
import static com.paigeruppel.katas.vendingmachine.Coin.NICKEL;
import static com.paigeruppel.katas.vendingmachine.Coin.QUARTER;
import static com.paigeruppel.katas.vendingmachine.Constants.FIVE_CENTS;
import static com.paigeruppel.katas.vendingmachine.Constants.TEN_CENTS;
import static com.paigeruppel.katas.vendingmachine.Constants.TWENTY_FIVE_CENTS;

public class Sensor {

    private MathContext sensorPrecision = new MathContext(6);

    public BigDecimal weigh(Coin coin) {
        BigDecimal adjustedWeight = new BigDecimal(coin.getWeightInGrams(), sensorPrecision);
        return BigDecimal.valueOf(coin.getWeightInGrams());
    }

    public BigDecimal measureVolume(Coin coin) {
        Double pi = Math.PI;
        Double radius = measureDiameter(coin) / 2;
        Double height = measureThickness(coin);
        Double rawVolume = pi * radius * height;
        BigDecimal adjustedVolume = new BigDecimal(rawVolume, sensorPrecision);
        return adjustedVolume;
    }

    private Double measureDiameter(Coin coin) {
        return coin.getDiameterInMm();
    }

    private Double measureThickness(Coin coin) {
        return coin.getThicknessInMm();
    }

    private Map<BigDecimal, BigDecimal> volumeToValueMap() {
        Map<BigDecimal, BigDecimal> volumeToValue = new HashMap<>();
        volumeToValue.put(measureVolume(NICKEL), FIVE_CENTS);
        volumeToValue.put(measureVolume(DIME), TEN_CENTS);
        volumeToValue.put(measureVolume(QUARTER), TWENTY_FIVE_CENTS);
        return volumeToValue;
    }

    private Map<BigDecimal, BigDecimal> weightToValueMap() {
        Map<BigDecimal, BigDecimal> weightToValue = new HashMap<>();
        weightToValue.put(weigh(NICKEL), FIVE_CENTS);
        weightToValue.put(weigh(DIME), TEN_CENTS);
        weightToValue.put(weigh(QUARTER), TWENTY_FIVE_CENTS);
        return weightToValue;
    }

    public BigDecimal detectValueOf(Coin coin) {
        Map<BigDecimal, BigDecimal> volumeToValue = volumeToValueMap();
        Map<BigDecimal, BigDecimal> weightToValue = weightToValueMap();
        BigDecimal volume = measureVolume(coin);
        BigDecimal weight = weigh(coin);
        BigDecimal volumeValue = volumeToValue.get(volume);
        BigDecimal weightValue = weightToValue.get(weight);
        if (!volumeValue.equals(weightValue) || weightValue.equals(null)) {
            return BigDecimal.ZERO;
        }
        return volumeValue;
    }
}
