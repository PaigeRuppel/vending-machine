package com.paigeruppel.katas.vendingmachine;

public class ChipsRackButton {

    private ChipsRack rack;

    public void push() {
        try{
            rack.dispense();
        } catch (Exception e){

        }
    }
}
