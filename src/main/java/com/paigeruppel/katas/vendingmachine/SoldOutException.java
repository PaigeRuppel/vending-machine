package com.paigeruppel.katas.vendingmachine;

public class SoldOutException extends Exception {
        public SoldOutException(String message) {
            super(message);
        }
}
