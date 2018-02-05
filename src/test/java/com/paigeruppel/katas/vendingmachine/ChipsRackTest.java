package com.paigeruppel.katas.vendingmachine;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ChipsRackTest {

    private ChipsRack underTest;

    @Test
    public void chipsRackShouldHoldTwentyChips() {
        underTest = new ChipsRack();
        underTest.stock();
        assertThat(underTest.availableNumberProducts(), is(20));
    }


}
