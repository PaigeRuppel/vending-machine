package com.paigeruppel.katas.vendingmachine;

import org.junit.Before;
import org.junit.Test;

import static com.paigeruppel.katas.vendingmachine.Coin.NICKEL;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SensorTest {

    private Sensor underTest;

    @Test
    public void sensorShouldCorrectlyWeighCoin() {
        underTest = new Sensor();
        assertThat(underTest.weigh(NICKEL), is(NICKEL.getWeightInGrams()));
    }
}
