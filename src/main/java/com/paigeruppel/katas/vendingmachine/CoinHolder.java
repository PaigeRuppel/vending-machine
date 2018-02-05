package com.paigeruppel.katas.vendingmachine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.paigeruppel.katas.vendingmachine.Constants.CENTS;

public class CoinHolder implements CoinAcceptor {


    private CoinAcceptor depositCoinAcceptor;
    private CoinAcceptor returnCoinAcceptor;
    private Sensor sensor;
    private BigDecimal amountInHolder;
    private List<Coin> coinsInHolder;

    public CoinHolder(CoinAcceptor depositCoinAcceptor, CoinAcceptor returnCoinAcceptor) {
        this.depositCoinAcceptor = depositCoinAcceptor;
        this.returnCoinAcceptor = returnCoinAcceptor;
        sensor = new Sensor();
        amountInHolder = new BigDecimal(0.0, CENTS);
        coinsInHolder = new ArrayList<>();
    }

    public CoinHolder() {
        sensor = new Sensor();
        amountInHolder = new BigDecimal(0.0, CENTS);
        coinsInHolder = new ArrayList<>();
    }

    public void accept(Coin coin) {
        amountInHolder = amountInHolder.add(sensor.detectValueOf(coin));
        coinsInHolder.add(coin);
    }

    public List<Coin> availableCoins() {
        return coinsInHolder;
    }


    public void depositCoins() {
        for (Coin c : coinsInHolder) {
            depositCoinAcceptor.accept(c);
        }
        amountInHolder = new BigDecimal(0.0, CENTS);
        coinsInHolder.clear();
    }

    public void returnCoins() {
        for (Coin c : coinsInHolder) {
            returnCoinAcceptor.accept(c);
        }
        amountInHolder = new BigDecimal(0.0, CENTS);
        coinsInHolder.clear();
    }

    public BigDecimal getAmountInHolder() {
        return amountInHolder.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
