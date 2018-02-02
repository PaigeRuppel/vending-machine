package com.paigeruppel.katas.vendingmachine;

import java.math.BigDecimal;

import static com.paigeruppel.katas.vendingmachine.Constants.SIXTY_FIVE_CENTS;

public class Candy implements Product {

    private BigDecimal price;

    public Candy() {
        price = SIXTY_FIVE_CENTS;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
