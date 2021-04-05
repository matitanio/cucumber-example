package com.cucumber.banco.bdd.runners;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.math.BigDecimal;

public interface ExtraccionRunner {
    @When("Extraigo {} en la cuenta")
    void extraigo_en_la_cuenta(BigDecimal montoExtraccion);

    @Then("Tengo el movimiento de extraccion por {} en mi lista de movimientos")
    void tengo_el_movimiento_de_extraccion_por_en_mi_lista_de_movimientos(BigDecimal montoMovimiento);

    @When("Intengo extraer {}")
    void intengo_extraer(BigDecimal monto);
}
