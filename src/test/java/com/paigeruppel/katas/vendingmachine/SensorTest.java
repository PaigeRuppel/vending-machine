package com.paigeruppel.katas.vendingmachine;

import org.junit.Before;
import org.junit.Test;

import static com.paigeruppel.katas.vendingmachine.Coin.DIME;
import static com.paigeruppel.katas.vendingmachine.Coin.NICKEL;
import static com.paigeruppel.katas.vendingmachine.Coin.QUARTER;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SensorTest {

    private Sensor underTest;

    @Test
    public void sensorShouldCorrectlyWeighCoin() {
        underTest = new Sensor();
        assertThat(underTest.weigh(NICKEL), is(NICKEL.getWeightInGrams()));
    }

    @Test
    public void sensorShouldCorrectlyMeasureDime() {
        underTest = new Sensor();
        assertThat(underTest.measureDiameter(DIME), is(DIME.getDiameterInMm()));
    }

    @Test
    public void sensorShouldCorrectlyMeasureThicknessOfQuarter() {
        underTest = new Sensor();
        assertThat(underTest.measureThickness(QUARTER), is(QUARTER.getThicknessInMm()));
    }
}
