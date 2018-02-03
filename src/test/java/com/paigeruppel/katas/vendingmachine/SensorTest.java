package com.paigeruppel.katas.vendingmachine;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static com.paigeruppel.katas.vendingmachine.Coin.*;
import static com.paigeruppel.katas.vendingmachine.Constants.FIVE_CENTS;
import static com.paigeruppel.katas.vendingmachine.Constants.TEN_CENTS;
import static com.paigeruppel.katas.vendingmachine.Constants.TWENTY_FIVE_CENTS;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SensorTest {

    private Sensor underTest;

    @Before
    public void setup() {
        underTest = new Sensor();
    }

    @Test
    public void shouldCorrectlyDetectValueOfNickel() {
        assertThat(underTest.detectValueOf(NICKEL), is(FIVE_CENTS));
    }

    @Test
    public void shouldCorrectlyDetectValueOfDime() {
        assertThat(underTest.detectValueOf(DIME), is(TEN_CENTS));
    }

    @Test
    public void shouldCorrectlyDetectValueOfQuarter() {
        assertThat(underTest.detectValueOf(QUARTER), is(TWENTY_FIVE_CENTS));
    }

    @Test
    public void shouldReturnZeroValueForPenny() {
        assertThat(underTest.detectValueOf(PENNY), is(BigDecimal.ZERO));
    }


}
