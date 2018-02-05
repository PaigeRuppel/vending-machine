package com.paigeruppel.katas.vendingmachine;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static com.paigeruppel.katas.vendingmachine.Coin.NICKEL;
import static com.paigeruppel.katas.vendingmachine.Constants.FIVE_CENTS;
import static com.paigeruppel.katas.vendingmachine.Constants.TEN_CENTS;
import static java.math.BigInteger.ZERO;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class VendingDisplayTest {

    @Mock
    private CoinHolder coinHolder;
    @Mock
    private CoinBank coinBank;
    @InjectMocks
    private VendingDisplay underTest;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
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
        assertThat(underTest.displayMessage(), is("$0.05"));
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
        assertThat(underTest.displayMessage(), is("$0.10"));
    }

}
