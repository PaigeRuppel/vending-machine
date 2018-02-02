package com.paigeruppel.katas.vendingmachine;

import java.math.BigDecimal;

import static com.paigeruppel.katas.vendingmachine.Constants.ONE_DOLLAR;

public class Cola {

    private BigDecimal price;

    public Cola() {
        price = ONE_DOLLAR;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
