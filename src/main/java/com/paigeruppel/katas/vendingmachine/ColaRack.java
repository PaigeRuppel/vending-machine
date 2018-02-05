package com.paigeruppel.katas.vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class ColaRack implements ProductRack {

    List<Product> inventory;

    public ColaRack() {
        inventory = new ArrayList<>();
    }

    @Override
    public void stock() {
        for (int i = inventory.size(); i < MAX_CAPACITY; i++) {
            inventory.add(new Chips());
        }
    }

    @Override
    public boolean isSoldOut() {
        return true;
    }

    @Override
    public void dispense() {

    }

    public Integer availableNumberProducts() {
        return inventory.size();
    }
}
