package com.paigeruppel.katas.vendingmachine;

import sun.awt.image.IntegerComponentRaster;

public interface ProductRack {

    final Integer MAX_CAPACITY = 20;

    void stock();

    boolean isSoldOut();
}
