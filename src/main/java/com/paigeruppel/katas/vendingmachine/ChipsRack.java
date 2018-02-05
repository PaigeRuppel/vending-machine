package com.paigeruppel.katas.vendingmachine;

import sun.awt.image.IntegerComponentRaster;

import java.util.ArrayList;
import java.util.List;

public class ChipsRack implements ProductRack{

    private List<Product> inventory;

    public ChipsRack() {
        inventory = new ArrayList<>();
    }

    public void stock() {
        for (int i = inventory.size(); i < MAX_CAPACITY; i++) {
            inventory.add(new Chips());
        }
    }

    public Integer availableNumberProducts() {
        return inventory.size();
    }

    @Override
    public boolean isSoldOut() {
        return inventory.isEmpty();
    }
}
