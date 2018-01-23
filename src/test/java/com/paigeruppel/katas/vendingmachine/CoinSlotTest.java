package com.paigeruppel.katas.vendingmachine;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.paigeruppel.katas.vendingmachine.Coin.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CoinSlotTest {

    private CoinSlot underTest;

    @Before
    public void setup() {
        underTest = new CoinSlot();
    }

    @Test
    public void shouldReturnValue5WhenNickelIsAccepted() throws InvalidPaymentException {
        assertThat(underTest.acceptCoin(NICKEL), is(5));
    }

    @Test
    public void shouldReturnValue10WhenDimeIsAccepted() throws InvalidPaymentException {
        assertThat(underTest.acceptCoin(DIME), is(10));
    }

    @Test
    public void shouldReturnValue25WhenQuarterIsAccepted() throws InvalidPaymentException {
        assertThat(underTest.acceptCoin(QUARTER), is(25));
    }


    @Test (expected = InvalidPaymentException.class)
    public void pennyShouldThrowInvalidPaymentException() throws InvalidPaymentException {
        underTest.acceptCoin(PENNY);
    }

//    Do I need to write a test around an exception? Should I mock?
//    @Test
//    public void shouldRaiseInvalidCoinExceptionWhenPennyIsInserted() throws InvalidPaymentException {
//        try {
//            int penny = underTest.getValue(PENNY);
//            Assert.fail("Fail! Method was expected to throw an exception because pennies are not a valid payment.");
//        } catch (InvalidPaymentException e) {
//            // expected
//        }
//    }


}
