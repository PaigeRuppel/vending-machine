package com.paigeruppel.katas.vendingmachine;

public class Sensor {


    public Double weigh(Coin coin) {
        return coin.getWeightInGrams();
    }

    public Double measureDiameter(Coin coin) {
        return coin.getDiameterInMm();
    }

    public Double measureThickness(Coin coin) {
        return coin.getThicknessInMm();
    }
}
