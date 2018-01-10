package com.paigeruppel.katas.vendingmachine;

public class InvalidPaymentException extends Exception {

    public InvalidPaymentException(String message) {
        super(message);
    }
}
