package com.paigeruppel.katas.vendingmachine;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ChipsRackButtonTest {

    @Spy
    private ChipsRack mSpyChipsRack;
    @InjectMocks
    private ChipsRackButton underTest;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void pushingTheCandyButtonShouldDispenseCandy() {
        mSpyChipsRack.stock();
        underTest.push();
        assertThat(mSpyChipsRack.availableNumberProducts(), is(19));
    }

}
