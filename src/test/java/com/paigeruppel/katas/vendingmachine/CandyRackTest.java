package com.paigeruppel.katas.vendingmachine;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CandyRackTest {

    private CandyRack underTest;

    @Test
    public void candyRackShouldHoldTwentyCandies() {
        underTest = new CandyRack();
        underTest.stock();
        assertThat(underTest.availableNumberProducts(), is(20));
    }
}
