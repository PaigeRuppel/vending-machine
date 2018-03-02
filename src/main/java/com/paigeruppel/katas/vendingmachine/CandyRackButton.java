package com.paigeruppel.katas.vendingmachine;

public class CandyRackButton {

    private CandyRack rack;

    public CandyRackButton() {
        rack = new CandyRack();
    }

    public void push() {
        try{
            rack.dispense();
        } catch (Exception e){

        }
    }
}
