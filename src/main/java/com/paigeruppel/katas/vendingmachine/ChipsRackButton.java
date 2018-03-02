package com.paigeruppel.katas.vendingmachine;

public class ChipsRackButton implements Button {

    private ProductRack rack;

    public ChipsRackButton() {
        rack = new ChipsRack();
    }

    public void push() {
        try{
            rack.dispense();
        } catch (Exception e){

        }
    }
}
