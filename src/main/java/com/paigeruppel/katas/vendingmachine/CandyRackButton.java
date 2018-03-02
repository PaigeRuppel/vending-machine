package com.paigeruppel.katas.vendingmachine;

public class CandyRackButton implements Button {

    private ProductRack rack;

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
