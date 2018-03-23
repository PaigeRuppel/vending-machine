package com.paigeruppel.katas.vendingmachine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CandyRack implements ProductRack {

    private List<Candy> inventory;
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
