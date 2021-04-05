package com.cucumber.banco.bdd.extraccion;

import com.cucumber.banco.bdd.runners.ExtraccionRunner;
import com.cucumber.banco.bdd.runners.backendRunnner.ExtraccionBackendRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.math.BigDecimal;


public class DefinicionPasosExtraccion {

    private ExtraccionRunner runner = new ExtraccionBackendRunner();

    @When("Extraigo {} en la cuenta")
    public void extraigo_en_la_cuenta(BigDecimal montoExtraccion) {

        runner.extraigo_en_la_cuenta(montoExtraccion);
    }


    @Then("Tengo el movimiento de extraccion por {} en mi lista de movimientos")
    public void tengo_el_movimiento_de_extraccion_por_en_mi_lista_de_movimientos(BigDecimal montoMovimiento) {

        runner.tengo_el_movimiento_de_extraccion_por_en_mi_lista_de_movimientos(montoMovimiento);
    }


    @When("Intengo extraer {}")
    public void intengo_extraer(BigDecimal monto) {

        runner.intengo_extraer(monto);
    }
}
