package com.paigeruppel.katas.vendingmachine;

import sun.awt.image.IntegerComponentRaster;

import java.util.ArrayList;
import java.util.List;

public class ChipsRack implements ProductRack{

    private List<Product> inventory;

    public ChipsRack() {
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
        return inventory.isEmpty();
    }

    @Override
    public void dispense() throws SoldOutException {
        if (!isSoldOut()) {
            inventory.remove(0);
        } else {
            throw new SoldOutException("The product is sold out, please make another selection");
        }
    }

    public Integer availableNumberProducts() {
        return inventory.size();
    }

}
