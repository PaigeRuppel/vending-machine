package com.paigeruppel.katas.vendingmachine;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.text.NumberFormat;
import java.util.Observable;
import java.util.Observer;

import static com.paigeruppel.katas.vendingmachine.Constants.CENTS;
import static com.paigeruppel.katas.vendingmachine.Constants.FIVE_CENTS;
import static java.math.BigDecimal.ZERO;

public class VendingDisplay {

    private final String NO_VALUE_MESSAGE = "INSERT COIN";
    private final String EXACT_CHANGE_ONLY = "EXACT CHANGE ONLY";
    private BigDecimal currentBalance;
    private CoinHolder coinHolder;
    private CoinBank coinBank;


    public VendingDisplay() {
        this.coinHolder = new CoinHolder();
        this.coinBank = new CoinBank();
        currentBalance = new BigDecimal(0.0, CENTS);
    }

    public String displayMessage() {
        currentBalance = coinHolder.getAmountInHolder();
        if (hasCurrentBalance()) {
            return currencyFormat(currentBalance);
        }
        return (coinBank.requiresExactChangeOnly()) ? EXACT_CHANGE_ONLY : NO_VALUE_MESSAGE;
    }

    private boolean hasCurrentBalance() {
        return currentBalance.compareTo(ZERO) > 0;
    }

    private String currencyFormat(BigDecimal balance) {
        return "CURRENT BALANCE: " + NumberFormat.getCurrencyInstance().format(balance);
    }

    private Product chips = new Chips();

    public boolean canPurchaseChips() {
        currentBalance = coinHolder.getAmountInHolder();
        return currentBalance.compareTo(chips.getPrice()) >= 0;
    }

    private Product candy = new Chips();

    public boolean canPurchaseCandy() {
        currentBalance = coinHolder.getAmountInHolder();
        return currentBalance.compareTo(candy.getPrice()) >= 0;
    }
}
