package com.paigeruppel.katas.vendingmachine;

public enum Coin {
    PENNY(2.500, 19.05, 1.52),
    NICKEL(5.000, 21.21, 1.95),
    DIME(2.268, 17.91, 1.35),
    QUARTER(5.670, 24.26, 1.75);

    private final Double weightInGrams;
    private final Double diameterInMm;
    private final Double thicknessInMm;

    Coin(Double weight, Double diameter, Double thickness) {
        this.weightInGrams = weight;
        this.diameterInMm = diameter;
        this.thicknessInMm = thickness;
    }

    public Double getWeightInGrams() {
        return weightInGrams;
    }

    public Double getDiameterInMm() {
        return diameterInMm;
    }

    public Double getThicknessInMm() {
        return thicknessInMm;
    }


}
