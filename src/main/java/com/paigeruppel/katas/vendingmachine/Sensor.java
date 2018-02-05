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
        List<BigDecimal> propertiesOfCoin = buildPropertyList(coin);
        BigDecimal value = coinPropertiesToValueMap().getOrDefault(propertiesOfCoin, BigDecimal.ZERO);
        return value;
    }

    private List<BigDecimal> buildPropertyList(Coin coin) {
        List<BigDecimal> parameterList = new ArrayList<>();
        parameterList.add(weigh(coin));
        parameterList.add(measureDiameter(coin));
        parameterList.add(measureThickness(coin));
        return parameterList;
    }

    private BigDecimal weigh(Coin coin) {
        BigDecimal adjustedWeight = new BigDecimal(coin.getWeightInGrams(), sensorPrecision);
        return BigDecimal.valueOf(coin.getWeightInGrams());
    }
    private BigDecimal measureDiameter(Coin coin) {
        BigDecimal adjustedDiameter = new BigDecimal(coin.getDiameterInMm(), sensorPrecision);
        return adjustedDiameter;
    }
    private BigDecimal measureThickness(Coin coin) {
        BigDecimal adjustedThickness = new BigDecimal(coin.getThicknessInMm(), sensorPrecision);
        return adjustedThickness;
    }

    private Map<List<BigDecimal>, BigDecimal> coinPropertiesToValueMap() {
        Map<List<BigDecimal>, BigDecimal> propertiesToValue = new HashMap<>();
        propertiesToValue.put(buildPropertyList(NICKEL), FIVE_CENTS);
        propertiesToValue.put(buildPropertyList(DIME), TEN_CENTS);
        propertiesToValue.put(buildPropertyList(QUARTER), TWENTY_FIVE_CENTS);
        return propertiesToValue;
    }

}
