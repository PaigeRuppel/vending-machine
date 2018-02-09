package com.paigeruppel.katas.vendingmachine;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.spi.CalendarDataProvider;

import static com.paigeruppel.katas.vendingmachine.Constants.*;
import static java.math.BigInteger.ZERO;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class VendingDisplayTest {

    @Mock
    private CoinHolder mockCoinHolder;
    @Mock
    private CoinBank mockCoinBank;

    @InjectMocks
    private VendingDisplay underTest;

    private Product chips;
    private Product candy;
    private Product cola;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        chips = new Chips();
        candy = new Candy();
        cola = new Cola();
    }

    @Test
    public void whenValueIsZeroShouldReadInsertCoin() {
        when(mockCoinBank.requiresExactChangeOnly()).thenReturn(false);
        when(mockCoinHolder.getAmountInHolder()).thenReturn(new BigDecimal(ZERO));
        assertThat(underTest.displayMessage(), is("INSERT COIN"));
    }

    @Test
    public void whenNickelIsInHolderShouldDisplayFiveCents() {
        when(mockCoinHolder.getAmountInHolder()).thenReturn(FIVE_CENTS);
        assertThat(underTest.displayMessage(), is("CURRENT BALANCE: $0.05"));
    }

    @Test
    public void whenBankRequiresExactChangeOnlyDisplayShouldReadExactChangeOnly() {
        when(mockCoinHolder.getAmountInHolder()).thenReturn(new BigDecimal(ZERO));
        when(mockCoinBank.requiresExactChangeOnly()).thenReturn(true);
        assertThat(underTest.displayMessage(), is("EXACT CHANGE ONLY"));
    }

    @Test
    public void whenBankRequiresExactChangeAndInsertedBalanceIsTenCentsDisplayShouldShowCurrentBalance() {
        when(mockCoinHolder.getAmountInHolder()).thenReturn(TEN_CENTS);
        when(mockCoinBank.requiresExactChangeOnly()).thenReturn(true);
        assertThat(underTest.displayMessage(), is("CURRENT BALANCE: $0.10"));
    }

    @Test
    public void whenCurrentBalanceIsFiftyCentsShouldBeAbleToPurchaseChipsButNotCandyOrCola() {
        when(mockCoinHolder.getAmountInHolder()).thenReturn(FIFTY_CENTS);
        when(mockCoinBank.requiresExactChangeOnly()).thenReturn(false);
        assertTrue(underTest.hasAdequatePaymentEntered(chips));
        assertFalse(underTest.hasAdequatePaymentEntered(candy));
        assertFalse(underTest.hasAdequatePaymentEntered(cola));
    }

    @Test
    public void whenCurrentBalanceIsSixtyFiveCentsShouldBeAbleToPurchaseChipsOrCandyButNotCola() {
        when(mockCoinHolder.getAmountInHolder()).thenReturn(SIXTY_FIVE_CENTS);
        when(mockCoinBank.requiresExactChangeOnly()).thenReturn(false);
        assertTrue(underTest.hasAdequatePaymentEntered(chips));
        assertTrue(underTest.hasAdequatePaymentEntered(candy));
        assertFalse(underTest.hasAdequatePaymentEntered(cola));
    }

    @Test
    public void whenCurrentBalanceIsOneDollarShouldBeAbleToPurchaseChipsCandyOrCola() {
        when(mockCoinHolder.getAmountInHolder()).thenReturn(ONE_DOLLAR);
        when(mockCoinBank.requiresExactChangeOnly()).thenReturn(false);
        assertTrue(underTest.hasAdequatePaymentEntered(chips));
        assertTrue(underTest.hasAdequatePaymentEntered(candy));
        assertTrue(underTest.hasAdequatePaymentEntered(cola));
    }

    @Test
    public void whenCurrentBalanceIsFiftyCentsAndChipsArePurchasedShouldSendMoneyToBank() {
        when(mockCoinHolder.getAmountInHolder()).thenReturn(FIFTY_CENTS);
        when(mockCoinBank.requiresExactChangeOnly()).thenReturn(false);
        underTest.selectProduct(chips);
        assertThat(underTest.getCurrentBalance(), is(new BigDecimal(ZERO)));
    }

    @Test
    public void whenCurrentBalanceIsSixtyFiveCentsAndCandyIsPurchasedShouldSendMoneyToBank() {
        when(mockCoinHolder.getAmountInHolder()).thenReturn(SIXTY_FIVE_CENTS);
        when(mockCoinBank.requiresExactChangeOnly()).thenReturn(false);
        underTest.selectProduct(candy);
        assertThat(underTest.getCurrentBalance(), is(new BigDecimal(ZERO)));
    }


}
