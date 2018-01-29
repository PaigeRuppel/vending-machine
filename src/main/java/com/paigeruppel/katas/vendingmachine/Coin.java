package com.paigeruppel.katas.vendingmachine;

public enum Coin {
    PENNY(2.500, 19.05, 1.52),
    NICKEL(5.000, 21.21, 1.95),
    DIME(2.268, 17.91, 1.35),
    QUARTER(5.670, 24.26, 1.75);

    private final double weightInGrams;
    private final double diameterInMm;
    private final double thicknessInMm;

    Coin(double weight, double diameter, double thickness) {
        this.weightInGrams = weight;
        this.diameterInMm = diameter;
        this.thicknessInMm = thickness;
    }

    public double getWeightInGrams() {
        return weightInGrams;
    }

    public double getDiameterInMm() {
        return diameterInMm;
    }

    public double getThicknessInMm() {
        return thicknessInMm;
    }


}
