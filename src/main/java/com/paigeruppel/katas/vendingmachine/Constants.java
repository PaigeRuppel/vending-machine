package com.paigeruppel.katas.vendingmachine;

import java.math.BigDecimal;
import java.math.MathContext;

public class Constants {

    public static final MathContext CENTS = new MathContext(2);

    public static final BigDecimal FIVE_CENTS = new BigDecimal(0.05, CENTS);
    public static final BigDecimal TEN_CENTS = new BigDecimal(0.10, CENTS);
    public static final BigDecimal TWENTY_FIVE_CENTS = new BigDecimal(0.25, CENTS);

    public static final BigDecimal FIFTY_CENTS = new BigDecimal(0.50, CENTS);
    public static final BigDecimal SIXTY_FIVE_CENTS = new BigDecimal(0.65, CENTS);
    public static final BigDecimal ONE_DOLLAR = new BigDecimal(1.00, CENTS);
}
