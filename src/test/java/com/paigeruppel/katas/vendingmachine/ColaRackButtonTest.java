package com.paigeruppel.katas.vendingmachine;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ColaRackButtonTest {

    @Spy
    private ColaRack mSpyColaRack;
    @InjectMocks
    private ColaRackButton underTest;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void pushingTheCandyButtonShouldDispenseCandy() {
        mSpyColaRack.stock();
        underTest.push();
        assertThat(mSpyColaRack.availableNumberProducts(), is(19));
    }

}
