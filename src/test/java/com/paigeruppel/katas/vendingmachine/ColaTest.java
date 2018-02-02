package com.paigeruppel.katas.vendingmachine;

import org.junit.Test;

import static com.paigeruppel.katas.vendingmachine.Constants.ONE_DOLLAR;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ColaTest {

    private Cola underTest;

    @Test
    public void getPriceShouldReturnOneDollarForCola() {
        underTest = new Cola();
        assertThat(underTest.getPrice(), is(ONE_DOLLAR));
    }
}
