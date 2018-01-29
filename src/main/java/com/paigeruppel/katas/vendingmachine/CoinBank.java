package com.paigeruppel.katas.vendingmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static com.paigeruppel.katas.vendingmachine.Coin.*;

public class CoinBank {
    private List<Coin> coinsInBank;

    public CoinBank(List<Coin> coinsInBank) {
        this.coinsInBank = coinsInBank;
    }

    //always need a nickel and a balance of at least ten cents
    public boolean requiresExactChangeOnly() {
        int nickels = 0;
        int dimes = 0;
        for (Coin c: coinsInBank) {
            if (c.equals(NICKEL)) {
                nickels++;
            }
            if (c.equals(DIME)) {
                dimes++;
            }
        }
        return nickels < 2 && dimes == 0;
    }


}
