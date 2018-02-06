package com.paigeruppel.katas.vendingmachine;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static com.paigeruppel.katas.vendingmachine.Coin.NICKEL;
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
    private CoinHolder coinHolder;
    @Mock
    private CoinBank coinBank;
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
        when(coinBank.requiresExactChangeOnly()).thenReturn(false);
        when(coinHolder.getAmountInHolder()).thenReturn(new BigDecimal(ZERO));
        assertThat(underTest.displayMessage(), is("INSERT COIN"));
    }

    @Test
    public void whenNickelIsInHolderShouldDisplayFiveCents() {
        when(coinHolder.getAmountInHolder()).thenReturn(FIVE_CENTS);
        assertThat(underTest.displayMessage(), is("CURRENT BALANCE: $0.05"));
    }

    @Test
    public void whenBankRequiresExactChangeOnlyDisplayShouldReadExactChangeOnly() {
        when(coinHolder.getAmountInHolder()).thenReturn(new BigDecimal(ZERO));
        when(coinBank.requiresExactChangeOnly()).thenReturn(true);
        assertThat(underTest.displayMessage(), is("EXACT CHANGE ONLY"));
    }

    @Test
    public void whenBankRequiresExactChangeAndInsertedBalanceIsTenCentsDisplayShouldShowCurrentBalance() {
        when(coinHolder.getAmountInHolder()).thenReturn(TEN_CENTS);
        when(coinBank.requiresExactChangeOnly()).thenReturn(true);
        assertThat(underTest.displayMessage(), is("CURRENT BALANCE: $0.10"));
    }

    @Test
    public void whenCurrentBalanceIsFiftyCentsShouldBeAbleToPurchaseChipsButNotCandyOrCola() {
        when(coinHolder.getAmountInHolder()).thenReturn(FIFTY_CENTS);
        when(coinBank.requiresExactChangeOnly()).thenReturn(false);
        assertTrue(underTest.canPurchaseProduct(chips));
        assertFalse(underTest.canPurchaseProduct(candy));
        assertFalse(underTest.canPurchaseProduct(cola));
    }

    @Test
    public void whenCurrentBalanceIsSixtyFiveCentsShouldBeAbleToPurchaseChipsOrCandyButNotCola() {
        when(coinHolder.getAmountInHolder()).thenReturn(SIXTY_FIVE_CENTS);
        when(coinBank.requiresExactChangeOnly()).thenReturn(false);
        assertTrue(underTest.canPurchaseProduct(chips));
        assertTrue(underTest.canPurchaseProduct(candy));
        assertFalse(underTest.canPurchaseProduct(cola));
    }

    @Test
    public void whenCurrentBalanceIsOneDollarShouldBeAbleToPurchaseChipsCandyOrCola() {
        when(coinHolder.getAmountInHolder()).thenReturn(ONE_DOLLAR);
        when(coinBank.requiresExactChangeOnly()).thenReturn(false);
        assertTrue(underTest.canPurchaseProduct(chips));
        assertTrue(underTest.canPurchaseProduct(candy));
        assertTrue(underTest.canPurchaseProduct(cola));
    }

    @Test
    public void whenCurrentBalanceIsFiftyCentsAndChipsArePurchasedShouldSendMoneyToBank() {
        when(coinHolder.getAmountInHolder()).thenReturn(FIFTY_CENTS);
        when(coinBank.requiresExactChangeOnly()).thenReturn(false);
        Chips chips = new Chips();
        underTest.selectProduct(chips);
        assertThat(underTest.getCurrentBalance(), is(new BigDecimal(ZERO)));
    }

}
