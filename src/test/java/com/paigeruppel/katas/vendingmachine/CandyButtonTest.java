package com.paigeruppel.katas.vendingmachine;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CandyButtonTest {

    @Spy
    private CandyRack mSpyCandyRack;
    @InjectMocks
    private CandyButton underTest;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void pushingTheCandyButtonShouldDispenseCandy() {
        mSpyCandyRack.stock();
        underTest.push();
        assertThat(mSpyCandyRack.availableNumberProducts(), is(19));
    }
}
