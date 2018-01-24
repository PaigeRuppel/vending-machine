package com.paigeruppel.katas.vendingmachine;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class VendingDisplayTest {

    private VendingDisplay underTest;

    @Test
    public void whenValueIsZeroShouldReadInsertCoin() {
        underTest = new VendingDisplay();
        assertThat(underTest.displayMessage(), is("INSERT COIN"));
    }
    @Test
    public void whenNickelIsAcceptedValueIncreasesBy5() {
        underTest = new VendingDisplay();
        underTest.addValue(0.05);
        assertThat(underTest.displayMessage(), is("0.05"));
    }
}
