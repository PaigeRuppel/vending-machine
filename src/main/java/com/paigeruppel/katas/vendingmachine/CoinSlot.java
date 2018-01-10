package com.paigeruppel.katas.vendingmachine;

import static com.paigeruppel.katas.vendingmachine.Coin.*;

public class CoinSlot {


    public int acceptPayment(Coin coin) {
        if (!coin.equals(NICKEL) && !coin.equals(DIME)) {
            return 25;
        }
        return (coin.equals(NICKEL) ? 5 : 10);
    }


}
