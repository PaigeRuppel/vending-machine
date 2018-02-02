package com.paigeruppel.katas.vendingmachine;

import java.util.ArrayList;
import java.util.List;

import static com.paigeruppel.katas.vendingmachine.Coin.*;

public class CoinBank implements CoinAcceptor {
    private List<Coin> coinsInBank;

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
        return count(NICKEL) < 2 && count(DIME)== 0;
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

    public void returnChange(double difference) {
        if (difference == 0.05) {
            checkBankInventoryAndReturnFiveCents();
        } else if (difference == 0.10) {
            checkBankInventoryAndReturnTenCents();
        } else if (difference == 0.15) {
            checkBankInventoryAndReturnFiveCents();
            checkBankInventoryAndReturnTenCents();
        } else if (difference == 0.25) {
            checkBankInventoryAndReturnTwentyFiveCents();
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
        } else if (count(NICKEL)  >= 2) {
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
