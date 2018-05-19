package com.paigeruppel.katas.vendingmachine;

public class ColaRackButton implements Button {

    private ProductRack rack;

    private String status;

    public String getStatus() {
        return status;
    }

    public ColaRackButton() {
        rack = new ColaRack();
    }

    public void push() {
        try{
            rack.dispense();
        } catch (Exception e){
            //send the message here? - but how without telling this button about the display?
            status = e.getMessage();
        }
    }
}
