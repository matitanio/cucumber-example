package com.cucumber.banco.bdd.excepciones;

public class ErrorEnBusquedaDeMovimientos extends RuntimeException{

    public ErrorEnBusquedaDeMovimientos() {
        super();
    }

    public ErrorEnBusquedaDeMovimientos(String message) {
        super(message);
    }
}
