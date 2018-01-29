package com.paigeruppel.katas.vendingmachine;

public class VendingDisplay {

    private double insertedValue;
    private final String NO_VALUE_MESSAGE = "INSERT COIN";
    private final String EXACT_CHANGE_ONLY = "EXACT CHANGE ONLY";

    public String displayMessage() {

        return (insertedValue == 0) ? NO_VALUE_MESSAGE : displayInsertedValue();
    }

    public void addValue(double value) {
        insertedValue += value;
    }

    private String displayInsertedValue() {
        return "Amount deposited: " + insertedValue;
    }
}
