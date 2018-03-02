package com.paigeruppel.katas.vendingmachine;

public class ColaRackButton implements Button {

    private ProductRack rack;

    public ColaRackButton() {
        rack = new ColaRack();
    }

    public void push() {
        try{
            rack.dispense();
        } catch (Exception e){

        }
    }
}
