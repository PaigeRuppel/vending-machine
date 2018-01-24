package com.paigeruppel.katas.vendingmachine;

public class VendingDisplay {
    private double insertedValue;
    private final String NO_VALUE_MESSAGE = "INSERT COIN";

    public String displayMessage() {
        return (insertedValue == 0) ? NO_VALUE_MESSAGE : "" + insertedValue;
    }

    public void addValue(double value) {
        insertedValue += value;
    }
}
