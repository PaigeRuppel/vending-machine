package com.paigeruppel.katas.vendingmachine;

public class CandyButton {

    private CandyRack rack;

    public CandyButton() {
        rack = new CandyRack();
    }

    public void push() {
        rack.dispense();
    }
}
