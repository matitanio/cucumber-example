package com.cucumber.banco.exceptions;

public class SaldoInsuficiente extends RuntimeException{

    public SaldoInsuficiente() {
    }

    public SaldoInsuficiente(String message) {
        super(message);
    }
}
