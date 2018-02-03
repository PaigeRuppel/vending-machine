package com.paigeruppel.katas.vendingmachine;

import java.math.BigDecimal;
import java.math.MathContext;

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


}
