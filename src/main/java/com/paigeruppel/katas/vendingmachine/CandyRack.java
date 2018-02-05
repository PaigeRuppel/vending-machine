package com.paigeruppel.katas.vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class CandyRack {

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

    public Integer availableNumberProducts() {
        return inventory.size();
    }
}
