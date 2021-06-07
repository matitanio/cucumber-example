package com.cucumber.banco.bdd.excepciones;

public class ElMovimientoNoExiste extends RuntimeException{

    public ElMovimientoNoExiste() {
        super();
    }

    public ElMovimientoNoExiste(String message) {
        super(message);
    }
}
