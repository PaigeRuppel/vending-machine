package com.paigeruppel.katas.vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class CandyRack {

    private List<Product> inventory;

    public CandyRack() {
        inventory = new ArrayList<>();
    }

    public void stock() {
        int count = 20;
        for (int i = 0; i < count; i++) {
            inventory.add(new Candy());
        }
    }

    public Integer availableNumberProducts() {
        return inventory.size();
    }
}
