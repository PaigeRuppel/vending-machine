package com.paigeruppel.katas.vendingmachine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.paigeruppel.katas.vendingmachine.Coin.*;
import static com.paigeruppel.katas.vendingmachine.Constants.*;
import static java.math.BigInteger.ZERO;

public class CoinBank implements CoinAcceptor {

    private List<Coin> coinsInBank;
    private BigDecimal amountToReturn;
    private CoinAcceptor returnCoinAcceptor;

    public CoinBank() {
        coinsInBank = new ArrayList<>();
        amountToReturn = new BigDecimal(ZERO);
        returnCoinAcceptor = new CoinReturn();
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
        amountToReturn = difference;
        while (amountToReturn.compareTo(BigDecimal.ZERO) == 1) {
            if (amountToReturnIsAtLeast(TWENTY_FIVE_CENTS)) {
                checkBankInventoryAndReturnTwentyFiveCents();
                decreaseAmountToReturnBy(TWENTY_FIVE_CENTS);
            } else if (amountToReturnIsAtLeast(TEN_CENTS)) {
                checkBankInventoryAndReturnTenCents();
                decreaseAmountToReturnBy(TEN_CENTS);
            } else if (amountToReturnIsAtLeast(FIVE_CENTS)) {
                checkBankInventoryAndReturnFiveCents();
                decreaseAmountToReturnBy(FIVE_CENTS);
            }
        }
    }

    private boolean amountToReturnIsAtLeast(BigDecimal centAmount) {
        return amountToReturn.compareTo(centAmount) >= 0;
    }

    private void decreaseAmountToReturnBy(BigDecimal amountReturned) {
        amountToReturn = amountToReturn.subtract(amountReturned, CENTS);
    }

    private void checkBankInventoryAndReturnFiveCents() {
        if (count(NICKEL) >= 1) {
            returnCoinAcceptor.accept(NICKEL);
            coinsInBank.remove(NICKEL);
        }
    }

    private void checkBankInventoryAndReturnTenCents() {
        if (count(DIME) >= 1) {
            returnCoinAcceptor.accept(DIME);
            coinsInBank.remove(DIME);
        } else {
            checkBankInventoryAndReturnFiveCents();
            checkBankInventoryAndReturnFiveCents();
        }
    }

    private void checkBankInventoryAndReturnTwentyFiveCents() {
        if (count(QUARTER) >= 1) {
            returnCoinAcceptor.accept(QUARTER);
            coinsInBank.remove(QUARTER);
        } else {
            checkBankInventoryAndReturnTenCents();
            checkBankInventoryAndReturnTenCents();
            checkBankInventoryAndReturnFiveCents();
        }
    }
}
