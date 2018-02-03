package com.paigeruppel.katas.vendingmachine;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.paigeruppel.katas.vendingmachine.Coin.*;
import static com.paigeruppel.katas.vendingmachine.Constants.*;

public class Sensor {

    private MathContext sensorPrecision = new MathContext(6);

    public BigDecimal detectValueOf(Coin coin) {
        List<BigDecimal> propertyList = buildPropertyList(coin);
        return coinPropertiesToValueMap().getOrDefault(propertyList, BigDecimal.ZERO);
    }

    private List<BigDecimal> buildPropertyList(Coin coin) {
        List<BigDecimal> parameterList = new ArrayList<>();
        parameterList.add(weigh(coin));
        parameterList.add(measureVolume(coin));
        return parameterList;
    }

    private BigDecimal weigh(Coin coin) {
        BigDecimal adjustedWeight = new BigDecimal(coin.getWeightInGrams(), sensorPrecision);
        return BigDecimal.valueOf(coin.getWeightInGrams());
    }

    private BigDecimal measureVolume(Coin coin) {
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

    private Map<List<BigDecimal>, BigDecimal> coinPropertiesToValueMap() {
        Map<List<BigDecimal>, BigDecimal> volumeToValue = new HashMap<>();
        volumeToValue.put(buildPropertyList(NICKEL), FIVE_CENTS);
        volumeToValue.put(buildPropertyList(DIME), TEN_CENTS);
        volumeToValue.put(buildPropertyList(QUARTER), TWENTY_FIVE_CENTS);
        return volumeToValue;
    }
}
