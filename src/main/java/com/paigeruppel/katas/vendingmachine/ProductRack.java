package com.paigeruppel.katas.vendingmachine;

import sun.awt.image.IntegerComponentRaster;

import java.util.List;

public interface ProductRack {

    final Integer MAX_CAPACITY = 20;

    void stock();

    boolean isSoldOut();

    void dispense() throws SoldOutException;
}
