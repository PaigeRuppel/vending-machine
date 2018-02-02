package com.paigeruppel.katas.vendingmachine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.paigeruppel.katas.vendingmachine.Coin.*;

public class CoinBank implements CoinAcceptor {
    private List<Coin> coinsInBank;

    private static final BigDecimal ZERO = new BigDecimal(0.00);
    private static final BigDecimal TWENTY_FIVE_CENTS = new BigDecimal(0.25);
    private static final BigDecimal TEN_CENTS = new BigDecimal(0.10);
    private static final BigDecimal FIVE_CENTS = new BigDecimal(0.05);

    public CoinBank() {
        coinsInBank = new ArrayList<>();
    }

    public void accept(Coin coin) {
        coinsInBank.add(coin);
    }

    public List<Coin> availableCoins() {
        return coinsInBank;
    }

    public void stock(List<Coin> coinsToStock) {
        for (Coin c : coinsToStock) {
            coinsInBank.add(c);
        }
    }

    public boolean requiresExactChangeOnly() {
        return canNotReturnTenCents() || canNotReturnFiveCents();
    }

    private boolean canNotReturnFiveCents() {
        return count(NICKEL) == 0;
    }

    private boolean canNotReturnTenCents() {
        return count(NICKEL) < 2 && count(DIME) == 0;
    }

    private int count(Coin coin) {
        int coinCount = 0;
        for (Coin c : coinsInBank) {
            if (c.equals(coin)) {
                coinCount++;
            }
        }
        return coinCount;
    }

    public void returnChange(BigDecimal difference) {
        BigDecimal amountToReturn = difference;
        while (amountToReturn.compareTo(BigDecimal.ZERO) == 1) {
            if (amountToReturn.compareTo(TWENTY_FIVE_CENTS) >= 0) {
                checkBankInventoryAndReturnTwentyFiveCents();
                amountToReturn = amountToReturn.subtract(TWENTY_FIVE_CENTS);
            } else if (amountToReturn.compareTo(TEN_CENTS) >= 0) {
                checkBankInventoryAndReturnTenCents();
                amountToReturn = amountToReturn.subtract(TEN_CENTS);
            } else if (amountToReturn.compareTo(FIVE_CENTS) >= 0) {
                checkBankInventoryAndReturnFiveCents();
                amountToReturn = amountToReturn.subtract(FIVE_CENTS);
            }
        }
    }

    private void checkBankInventoryAndReturnFiveCents() {
        if (count(NICKEL) >= 1) {
            coinsInBank.remove(NICKEL);
        }
    }

    private void checkBankInventoryAndReturnTenCents() {
        if (count(DIME) >= 1) {
            coinsInBank.remove(DIME);
        } else if (count(NICKEL) >= 2) {
            coinsInBank.remove(NICKEL);
            coinsInBank.remove(NICKEL);
        }
    }

    private void checkBankInventoryAndReturnTwentyFiveCents() {
        if (count(QUARTER) >= 1) {
            coinsInBank.remove(QUARTER);
        } else {
            checkBankInventoryAndReturnTenCents();
            checkBankInventoryAndReturnTenCents();
            checkBankInventoryAndReturnFiveCents();
        }
    }
}
