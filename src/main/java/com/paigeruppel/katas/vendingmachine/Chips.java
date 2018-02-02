package com.paigeruppel.katas.vendingmachine;

import java.math.BigDecimal;

import static com.paigeruppel.katas.vendingmachine.Constants.SIXTY_FIVE_CENTS;

public class Chips {

    private BigDecimal price;

    public Chips() {
        price = SIXTY_FIVE_CENTS;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
