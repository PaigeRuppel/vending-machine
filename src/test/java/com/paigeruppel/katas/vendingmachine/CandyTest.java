package com.paigeruppel.katas.vendingmachine;

import org.junit.Test;

import static com.paigeruppel.katas.vendingmachine.Constants.SIXTY_FIVE_CENTS;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CandyTest {

    private Candy underTest;

    @Test
    public void getPriceShouldReturnSixtyFiveCentsForCandy() {
        underTest = new Candy();
        assertThat(underTest.getPrice(), is(SIXTY_FIVE_CENTS));
    }
}
