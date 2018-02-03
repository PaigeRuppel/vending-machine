package com.paigeruppel.katas.vendingmachine;

import org.junit.Test;

import static com.paigeruppel.katas.vendingmachine.Constants.FIFTY_CENTS;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ChipsTest {

    private Chips underTest;

    @Test
    public void getPriceShouldReturnSixtyFiveCentsForChips() {
        underTest = new Chips();
        assertThat(underTest.getPrice(), is(FIFTY_CENTS));
    }
}