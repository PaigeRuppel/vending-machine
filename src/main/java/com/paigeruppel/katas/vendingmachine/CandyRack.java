package com.paigeruppel.katas.vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class CandyRack implements ProductRack {

    private List<Product> inventory;
    private final Integer MAX_CAPACITY = 20;

    public CandyRack() {
        inventory = new ArrayList<>();
    }

    public void stock() {
        for (int i = inventory.size(); i < MAX_CAPACITY; i++) {
            inventory.add(new Candy());
        }
    }

    @Override
    public boolean isSoldOut() {
        return inventory.isEmpty();
    }

    @Override
    public void dispense() {
        inventory.remove(0);
    }

    public Integer availableNumberProducts() {
        return inventory.size();
    }
}
