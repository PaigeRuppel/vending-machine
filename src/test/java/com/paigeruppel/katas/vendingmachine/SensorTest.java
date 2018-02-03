package com.paigeruppel.katas.vendingmachine;

import org.junit.Test;

import java.math.BigDecimal;

import static com.paigeruppel.katas.vendingmachine.Coin.DIME;
import static com.paigeruppel.katas.vendingmachine.Coin.NICKEL;
import static com.paigeruppel.katas.vendingmachine.Coin.QUARTER;
import static com.paigeruppel.katas.vendingmachine.Constants.FIVE_CENTS;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SensorTest {

    private Sensor underTest;

    @Test
    public void sensorShouldCorrectlyWeighNickel() {
        underTest = new Sensor();
        BigDecimal nickelWeight = BigDecimal.valueOf(5.0);
        assertThat(underTest.weigh(NICKEL), is(nickelWeight));
    }

    @Test
    public void sensorShouldCorrectlyMeasureVolumeOfNickel() {
        underTest = new Sensor();
        BigDecimal volume = BigDecimal.valueOf(64.9674);
        assertThat(underTest.measureVolume(NICKEL), is(volume));
    }

    @Test
    public void sensorShouldCorrectlyMeasureVolumeOfDime() {
        underTest = new Sensor();
        BigDecimal volume = BigDecimal.valueOf(37.9795);
        assertThat(underTest.measureVolume(DIME), is(volume));
    }

    @Test
    public void sensorShouldCorrectlyMeasureVolumeOfQuarter() {
        underTest = new Sensor();
        BigDecimal volume = BigDecimal.valueOf(66.6882);
        assertThat(underTest.measureVolume(QUARTER), is(volume));
    }

}
