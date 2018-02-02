package com.paigeruppel.katas.vendingmachine;

import java.math.BigDecimal;

import static com.paigeruppel.katas.vendingmachine.Constants.FIFTY_CENTS;
import static com.paigeruppel.katas.vendingmachine.Constants.SIXTY_FIVE_CENTS;

public class Chips implements Product {

    private BigDecimal price;

    public Chips() {
        price = FIFTY_CENTS;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
