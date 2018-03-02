package com.paigeruppel.katas.vendingmachine;

public class ColaRackButton {

    private ColaRack rack;

    public void push() {
        try{
            rack.dispense();
        } catch (Exception e){

        }
    }
}
